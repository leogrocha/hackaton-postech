package com.hackaton.postech.application.exceptions.dto;

public class DatabaseException extends RuntimeException{

  public DatabaseException(String message) {
    super(message);
  }
}
