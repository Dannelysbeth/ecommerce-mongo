package dannelysbeth.ecommerce.mongodbshop.model.DTO.request;

import lombok.Data;

@Data
public class OrderRequest {

    Long addressId;

    String shippingMethod;

}
