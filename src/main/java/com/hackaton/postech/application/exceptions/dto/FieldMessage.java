package com.hackaton.postech.application.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FieldMessage {
  private String fieldName;
  private String message;
}
