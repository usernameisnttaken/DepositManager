package ru.greendata.DepositManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.greendata.DepositManager.entity.AbstractEntity;
import ru.greendata.DepositManager.filter.FilterSpecificationBuilder;
import ru.greendata.DepositManager.service.CommonService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbstractController<E extends AbstractEntity, S extends CommonService<E>>
        implements CommonController<E> {

    private final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<E>> getAll(@RequestParam(value = "filter", required = false) String filter, Sort sort) {
        String modifiedFilter = filter + ",";
        FilterSpecificationBuilder filterSpecificationBuilder = new FilterSpecificationBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(=|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(modifiedFilter);
        while (matcher.find()) {
            filterSpecificationBuilder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        Specification<E> spec = filterSpecificationBuilder.build();
        return ResponseEntity.ok(service.getAll(spec, sort));
    }

    @Override
    public ResponseEntity<E> getById(@RequestParam Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("ENTITY_NOT_FOUND"));
    }

    @Override
    public ResponseEntity<E> save(@RequestBody E entity) {
        return service.save(entity).map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("ENTITY_NOT_SAVED"));
    }

    @Override
    public ResponseEntity<E> update(@RequestBody E entity) {
        return service.update(entity).map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("ENTITY_NOT_UPDATED"));
    }

    @Override
    public void deleteById(@RequestParam Long id) {
        service.deleteById(id);
    }

}
