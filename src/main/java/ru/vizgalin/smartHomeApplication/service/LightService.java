package ru.vizgalin.smartHomeApplication.service;

import java.util.Optional;

public interface LightService<T, PK>   {

    public String isWork(Boolean t);

    Optional<T> findById(PK id);

    T save(T entity);

    T update(T entity);

    void deleteById(PK id);

    boolean existsById(PK id);

}
