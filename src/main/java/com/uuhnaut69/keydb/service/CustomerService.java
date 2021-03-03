package com.uuhnaut69.keydb.service;

import com.uuhnaut69.keydb.resource.dto.CustomerRequest;
import com.uuhnaut69.keydb.resource.dto.CustomerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

  Mono<CustomerResponse> create(CustomerRequest customerRequest);

  Flux<CustomerResponse> findAll();
}
