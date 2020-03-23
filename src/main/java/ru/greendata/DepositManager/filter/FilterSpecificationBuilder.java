package ru.greendata.DepositManager.filter;

import org.springframework.data.jpa.domain.Specification;
import ru.greendata.DepositManager.entity.AbstractEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterSpecificationBuilder<E extends AbstractEntity> {

    private final List<FilterCriteria> filterCriteriaList;

    public FilterSpecificationBuilder() {
        filterCriteriaList = new ArrayList<>();
    }

    public FilterSpecificationBuilder with(String fieldName, String operation, Object value) {
        filterCriteriaList.add(new FilterCriteria(fieldName, operation, value));
        return this;
    }

    public Specification<E> build() {
        if (filterCriteriaList.size() == 0) {
            return null;
        }
        List<Specification> specificationList = filterCriteriaList.stream()
                .map(FilterSpecification::new)
                .collect(Collectors.toList());
        Specification result = specificationList.get(0);
        for (int i = 1; i < filterCriteriaList.size(); i++) {
            result = Specification.where(result).and(specificationList.get(i));
        }
        return result;
    }

}
