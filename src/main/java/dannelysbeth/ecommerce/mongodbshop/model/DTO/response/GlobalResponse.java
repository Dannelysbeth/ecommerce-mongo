package dannelysbeth.ecommerce.mongodbshop.model.DTO.response;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class GlobalResponse {

    long count;

    String responseTime;

    Set<Object> entries;

}
