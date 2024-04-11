package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {

    private String name;

    private Category parentCategory;
}
