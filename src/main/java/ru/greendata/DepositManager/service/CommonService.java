package ru.greendata.DepositManager.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import ru.greendata.DepositManager.entity.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface CommonService<E extends AbstractEntity> {

    Optional<E> save(E entity);

    Optional<E> update(E entity);

    Optional<E> getById(Long id);

    List<E> getAll(Specification<E> specification, Sort sort);

    void deleteById(Long id);

}
