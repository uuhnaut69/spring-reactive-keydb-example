package com.uuhnaut69.keydb.resource;

import com.uuhnaut69.keydb.resource.dto.CustomerRequest;
import com.uuhnaut69.keydb.resource.dto.CustomerResponse;
import com.uuhnaut69.keydb.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CustomerResource {

  private final CustomerService customerService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<CustomerResponse> create(@RequestBody CustomerRequest customerRequest) {
    log.info("Request create new customer {}", customerRequest);
    return customerService.create(customerRequest);
  }

  @GetMapping
  public Flux<CustomerResponse> getAllCustomers() {
    log.info("Request get all customers");
    return customerService.findAll();
  }
}
