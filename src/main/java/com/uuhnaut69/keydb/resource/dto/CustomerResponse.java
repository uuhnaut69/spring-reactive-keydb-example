package com.uuhnaut69.keydb.resource.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.sql.Timestamp;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record CustomerResponse(String id, String fullName, String address, Timestamp createdDate) {
}
