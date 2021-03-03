package com.uuhnaut69.keydb.repository;

import com.uuhnaut69.keydb.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository {

  Mono<Customer> save(Customer customer);

  Flux<Customer> findAll();
}
