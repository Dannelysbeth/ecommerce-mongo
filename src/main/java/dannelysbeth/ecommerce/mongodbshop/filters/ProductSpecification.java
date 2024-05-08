package dannelysbeth.ecommerce.mongodbshop.filters;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ProductSpecification {

    public static Query filterBy(Double lowerPrice, Double higherPrice, Long minQuantity, List<String> categories, List<String> colors, List<String> sizes) {
        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();

        if (colors != null) {
            criteriaList.add(getByColors(colors));
        }
        if (categories != null) {
            criteriaList.add(getByCategories(categories));
        }
        if (lowerPrice != null) {
            criteriaList.add(getByPriceGreaterThan(lowerPrice));
        }
        if (higherPrice != null) {
            criteriaList.add(getByPriceSmallerThan(higherPrice));
        }

        // Combine all criteria with an 'and' operator
        if (!criteriaList.isEmpty()) {
            Criteria finalCriteria = new Criteria().andOperator(criteriaList.toArray(new Criteria[0]));
            query.addCriteria(finalCriteria);
        }

        return query;
    }

    public static  Criteria getByCategories(List<String> categories) {
        return Criteria.where("category").in(categories);
    }

    public static  Criteria getByColors(List<String> colors) {
        return Criteria.where("items.features").elemMatch(
                Criteria.where("value").in(colors)
        );
    }
    public static  Criteria getByPriceGreaterThan(double price) {
        return Criteria.where("price").gte(price);
    }
    public static  Criteria getByPriceSmallerThan(double price) {
        return Criteria.where("price").lte(price);
    }

}
