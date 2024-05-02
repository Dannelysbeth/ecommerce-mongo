package dannelysbeth.ecommerce.mongodbshop.auth;


import dannelysbeth.ecommerce.mongodbshop.auth.DTO.request.AuthenticationRequest;
import dannelysbeth.ecommerce.mongodbshop.auth.DTO.request.RegisterRequest;
import dannelysbeth.ecommerce.mongodbshop.auth.DTO.response.AuthenticationResponse;
import dannelysbeth.ecommerce.mongodbshop.exception.EmailExistsException;
import dannelysbeth.ecommerce.mongodbshop.exception.IncorrectPasswordException;
import dannelysbeth.ecommerce.mongodbshop.exception.UserNotFoundException;
import dannelysbeth.ecommerce.mongodbshop.exception.UsernameAlreadyTakenException;
import dannelysbeth.ecommerce.mongodbshop.mapper.definition.UserMapper;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.request.UserRequest;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import dannelysbeth.ecommerce.mongodbshop.model.enums.Role;
import dannelysbeth.ecommerce.mongodbshop.repository.UserRepository;
import dannelysbeth.ecommerce.mongodbshop.security.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final UserMapper userMapper;

    public AuthenticationResponse register(RegisterRequest request) {
        verifyRequestCorrectness(request);
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .firstname(request.getEmail())
                .lastname(request.getLastname())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER_ROLE)
                .build();

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        User user = userRepository.getUserByUsername(request.getUsername()).orElseGet(() -> userRepository.getUserByEmail(request.getUsername())
                .orElseThrow(UserNotFoundException::new));
        boolean decoded = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!decoded) {
            throw new IncorrectPasswordException();
        }
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public void importMultipleUsers(Set<UserRequest> requests) {
        requests.forEach(req -> {
            userRepository.save(userMapper.tranformRequestToUser(req,
                    passwordEncoder.encode(req.getUsername()),
                    Role.USER_ROLE));
        });
    }


    private void verifyRequestCorrectness(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailExistsException();
        }
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyTakenException();
        }
    }
}