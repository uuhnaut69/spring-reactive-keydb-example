package com.uuhnaut69.keydb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  private String id;
  private String fullName;
  private String address;
  private Timestamp createdDate;
}
