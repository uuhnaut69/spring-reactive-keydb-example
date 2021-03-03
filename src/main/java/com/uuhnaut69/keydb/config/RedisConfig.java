package com.uuhnaut69.keydb.config;

import com.uuhnaut69.keydb.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

  @Bean
  public ReactiveRedisOperations<String, Customer> redisOperations(
      ReactiveRedisConnectionFactory factory) {
    Jackson2JsonRedisSerializer<Customer> serializer =
        new Jackson2JsonRedisSerializer<>(Customer.class);

    RedisSerializationContext.RedisSerializationContextBuilder<String, Customer> builder =
        RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

    RedisSerializationContext<String, Customer> context = builder.value(serializer).build();

    return new ReactiveRedisTemplate<>(factory, context);
  }
}
