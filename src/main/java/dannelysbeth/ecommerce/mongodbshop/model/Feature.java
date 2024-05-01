package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Feature {

    String parameter;

    String value;
}
