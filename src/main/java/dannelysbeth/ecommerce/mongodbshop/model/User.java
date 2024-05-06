package dannelysbeth.ecommerce.mongodbshop.model;

import dannelysbeth.ecommerce.mongodbshop.model.enums.Role;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Document
@Data
@Builder
public class User implements UserDetails {
    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String password;

    private String email;

    private String firstname;

    private String lastname;

    private Role role;

    private Set<Address> addresses;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.role.name()));

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void addAddress(Address address) {

        if (this.addresses == null) {
            this.addresses = new HashSet<>();
            address.setDefault(true);
        } else {
            Optional<Address> addr = this.addresses.stream().filter(Address::isDefault).findAny();
            if (addr.isEmpty()) {
                address.setDefault(true);
            }
        }
        this.addresses.add(address);
    }
}
