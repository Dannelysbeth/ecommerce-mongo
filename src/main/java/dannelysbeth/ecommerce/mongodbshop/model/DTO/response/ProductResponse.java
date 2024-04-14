package dannelysbeth.ecommerce.mongodbshop.model.DTO.response;

import dannelysbeth.ecommerce.mongodbshop.model.Variation;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@Builder
public class ProductResponse {
    @Id
    private String id;

    private String name;

    private String description;

    private double price;

    private byte [] image;

    private String category;

    private Set<Variation> variations;
}
