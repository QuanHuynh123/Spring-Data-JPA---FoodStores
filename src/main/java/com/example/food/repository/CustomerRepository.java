package com.example.food.repository;

import com.example.food.entity.CustomerEntity;
import lombok.NonNull;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,String> {

    @Override
    List<CustomerEntity> findAll();

    @Override
    boolean existsById(String idCustomer);

    // Phụ thuộc vào việc tên biến sau "By" khớp với biến Entity
    List<CustomerEntity> findAllByfirstName(String firstName);

    Optional<CustomerEntity> findByphone(String idCustomer);
    
    <S extends CustomerEntity, R> R findByfirstName(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    @Override
    <S extends CustomerEntity> S save(S entity);

    @Override
    void deleteById(@NonNull String idCustomer);
}
