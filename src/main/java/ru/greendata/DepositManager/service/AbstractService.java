package ru.greendata.DepositManager.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import ru.greendata.DepositManager.entity.AbstractEntity;
import ru.greendata.DepositManager.repository.CommonRepository;

import java.util.List;
import java.util.Optional;

public class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>>
        implements CommonService<E> {

    private final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public Optional<E> save(E entity) {
        return Optional.of(repository.save(entity));
    }

    @Override
    public Optional<E> update(E entity) {
        return Optional.of(repository.save(entity));
    }

    @Override
    public Optional<E> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<E> getAll(Specification<E> specification, Sort sort) {
        return Lists.newArrayList(repository.findAll(specification, sort));
    }

    @Override
    public void deleteById(Long id) {
        E entity = getById(id)
                .orElseThrow(() -> new RuntimeException("ENTITY_NOT_FOUND"));
        repository.delete(entity);
    }

}
