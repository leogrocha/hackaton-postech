package com.hackaton.postech.application.exceptions.dto;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }
}
