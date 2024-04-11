package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Variation {
    private String name;

    private VariationOption type;
}
