package com.uuhnaut69.keydb.repository.impl;

import com.uuhnaut69.keydb.model.Customer;
import com.uuhnaut69.keydb.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

  private final ReactiveRedisOperations<String, Customer> reactiveRedisOperations;

  @Override
  public Mono<Customer> save(Customer customer) {
    log.info("Persist new customer {} into database", customer);
    return reactiveRedisOperations
        .opsForValue()
        .set(customer.getId(), customer)
        .thenReturn(customer);
  }

  @Override
  public Flux<Customer> findAll() {
    log.info("Get all customers");
    return reactiveRedisOperations
        .keys("*")
        .flatMap(key -> reactiveRedisOperations.opsForValue().get(key));
  }
}
