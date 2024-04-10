package dannelysbeth.ecommerce.mongodbshop.filters;

import dannelysbeth.ecommerce.mongodbshop.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;


@RequiredArgsConstructor
public class UserSpecification {
    public static Specification<User> startsWithLastname(String startsWith) {
        return (root, query, builder) -> builder.like(root.get("lastname"), "%" + startsWith + "%");
    }

    public static Specification<User> startsWithFirstname(String code) {
        return (root, query, builder) -> builder.like(root.get("firstname"), "%" + code + "%");
    }
}
