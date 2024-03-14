package com.hackaton.postech.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class CustomError {

  private Instant timestamp;
  private Integer status;
  private String error;
  private String path;
}
