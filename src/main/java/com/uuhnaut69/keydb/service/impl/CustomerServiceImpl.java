package com.uuhnaut69.keydb.service.impl;

import com.uuhnaut69.keydb.model.Customer;
import com.uuhnaut69.keydb.repository.CustomerRepository;
import com.uuhnaut69.keydb.resource.dto.CustomerRequest;
import com.uuhnaut69.keydb.resource.dto.CustomerResponse;
import com.uuhnaut69.keydb.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

  @Override
  public Mono<CustomerResponse> create(CustomerRequest customerRequest) {
    log.info("Perform business logic before create new customer {}", customerRequest);
    var customer =
        new Customer(
            UUID.randomUUID().toString(),
            customerRequest.fullName(),
            customerRequest.address(),
            Timestamp.from(Instant.now()));
    return customerRepository
        .save(customer)
        .map(
            result ->
                new CustomerResponse(
                    result.getId(),
                    result.getFullName(),
                    result.getAddress(),
                    result.getCreatedDate()));
  }

  @Override
  public Flux<CustomerResponse> findAll() {
    log.info("Get all customers");
    return customerRepository
        .findAll()
        .map(
            customer ->
                new CustomerResponse(
                    customer.getId(),
                    customer.getFullName(),
                    customer.getAddress(),
                    customer.getCreatedDate()));
  }
}
