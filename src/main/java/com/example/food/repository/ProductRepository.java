package com.example.food.repository;

import com.example.food.entity.ProductEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Override
    List<ProductEntity> findAll();

    @Override
    Optional<ProductEntity> findById(Integer idProduct);

    @Override
    <S extends ProductEntity> S save(S entity);

    @Override
    void delete(ProductEntity entity);

    @Override
    void deleteById(Integer idProduct);

    @Override
    <S extends ProductEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

}
