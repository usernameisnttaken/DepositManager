package ru.greendata.DepositManager.controller;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.greendata.DepositManager.entity.AbstractEntity;

import java.util.List;

public interface CommonController<E extends AbstractEntity> {

    @PostMapping
    ResponseEntity<E> save(@RequestBody E entity);

    @PutMapping
    ResponseEntity<E> update(@RequestBody E entity);

    @GetMapping
    ResponseEntity<E> getById(@RequestParam Long id);

    @GetMapping("/all")
    ResponseEntity<List<E>> getAll(@RequestParam(value = "filter", required = false) String filter, Sort sort);

    @DeleteMapping
    void deleteById(@RequestParam Long id);

}
