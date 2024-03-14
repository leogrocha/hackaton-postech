package com.hackaton.postech.application.exceptions;

public class DatabaseException extends RuntimeException{

  public DatabaseException(String message) {
    super(message);
  }
}
