package dannelysbeth.ecommerce.mongodbshop.service.implementation;

import dannelysbeth.ecommerce.mongodbshop.model.ShippingMethod;
import dannelysbeth.ecommerce.mongodbshop.repository.ShippingMethodRepository;
import dannelysbeth.ecommerce.mongodbshop.service.definition.ShippingMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingMethodServiceImpl implements ShippingMethodService {

    private final ShippingMethodRepository repository;

    @Override
    public ShippingMethod getShippingMethodByCode(String code) {
        return repository.getById(code);
    }
}
