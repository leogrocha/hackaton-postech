package com.hackaton.postech.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FieldMessage {
  private String fieldName;
  private String message;
}
