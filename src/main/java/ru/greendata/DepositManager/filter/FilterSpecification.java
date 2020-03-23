package ru.greendata.DepositManager.filter;

import org.springframework.data.jpa.domain.Specification;
import ru.greendata.DepositManager.entity.AbstractEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class FilterSpecification<E extends AbstractEntity> implements Specification<E> {

    private FilterCriteria filterCriteria;

    public FilterSpecification(FilterCriteria filterCriteria) {
        this.filterCriteria = filterCriteria;
    }

    @Override
    public Predicate toPredicate(Root<E> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (filterCriteria == null)
            return null;
        switch (filterCriteria.getOperation()) {
            case ">":
                return criteriaBuilder.greaterThan(root.<String>get(filterCriteria.getFieldName()), filterCriteria.getValue().toString());
            case ">=":
                return criteriaBuilder.greaterThanOrEqualTo(root.<String>get(filterCriteria.getFieldName()), filterCriteria.getValue().toString());
            case "<":
                return criteriaBuilder.lessThan(root.<String>get(filterCriteria.getFieldName()), filterCriteria.getValue().toString());
            case "<=":
                return criteriaBuilder.lessThanOrEqualTo(root.<String>get(filterCriteria.getFieldName()), filterCriteria.getValue().toString());
            case "=":
                return criteriaBuilder.equal(root.get(filterCriteria.getFieldName()), filterCriteria.getValue());
            default:
                return null;
        }
    }

}
