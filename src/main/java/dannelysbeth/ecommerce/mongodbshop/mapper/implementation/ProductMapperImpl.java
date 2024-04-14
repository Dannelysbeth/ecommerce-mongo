package dannelysbeth.ecommerce.mongodbshop.mapper.implementation;

import dannelysbeth.ecommerce.mongodbshop.exception.FileInputException;
import dannelysbeth.ecommerce.mongodbshop.mapper.definition.ProductMapper;
import dannelysbeth.ecommerce.mongodbshop.model.Product;
import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import dannelysbeth.ecommerce.mongodbshop.model.Variation;
import dannelysbeth.ecommerce.mongodbshop.model.VariationOption;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public List<ProductItem> readFromFile(MultipartFile file) {
        JSONParser jsonParser = new JSONParser();

        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            Object obj = jsonParser.parse(reader);

            return getProductItems((JSONArray) obj);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new FileInputException(e.getMessage());
        }
    }

    private List<ProductItem> getProductItems(JSONArray obj) {
        List<ProductItem> productItems = new ArrayList<>();

        obj.forEach(product -> {
            ProductItem productItem = ProductItem.builder()
                    .product(this.getProduct((JSONObject) product))
                    .SKU(this.getSKU((JSONObject) product))
                    .quantityInStock(this.getQuantityInStock((JSONObject) product))
                    .variation(this.getVariations((JSONObject) product))
                    .build();
            productItems.add(productItem);
        });
        return productItems;
    }

    private Product getProduct(JSONObject jsonObj) {
        JSONObject jsonProduct = (JSONObject) jsonObj.get("product");

        String productCode = jsonProduct.get("productCode").toString();
        String name = jsonProduct.get("name").toString();
        String description = jsonProduct.get("description").toString();
        double price = (double) jsonProduct.get("price");
        String category = jsonProduct.get("category").toString();
        return Product.builder()
                .productCode(productCode)
                .name(name)
                .price(price)
                .category(category)
                .description(description)
                .build();
    }

    private long getQuantityInStock(JSONObject jsonObject) {
        return (long) jsonObject.get("quantityInStock");
    }

    private long getSKU(JSONObject jsonObject) {
        return (long) jsonObject.get("SKU");
    }

    private List<Variation> getVariations(JSONObject jsonObj) {
        List<Variation> variationList = new ArrayList<>();

        JSONArray variationsJsonArr = (JSONArray) jsonObj.get("variation");
        variationsJsonArr.forEach(varJson -> {
            String parameter = ((JSONObject) varJson).get("parameter").toString();
            JSONObject variationOptionJSONObj = (JSONObject) ((JSONObject) varJson).get("type");
            String name = variationOptionJSONObj.get("name").toString();
            variationList.add(Variation.builder()
                    .parameter(parameter)
                    .type(VariationOption.builder()
                            .name(name)
                            .build())
                    .build()
            );
        });
        return variationList;
    }


}
