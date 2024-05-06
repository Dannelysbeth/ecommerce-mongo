package dannelysbeth.ecommerce.mongodbshop.service.definition;

import dannelysbeth.ecommerce.mongodbshop.model.ShippingMethod;

public interface ShippingMethodService {

    ShippingMethod getShippingMethodByCode(String code);
}
