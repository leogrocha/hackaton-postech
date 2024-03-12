package com.hackaton.postech.application.exceptions.dto;

import org.springframework.http.HttpStatus;

public record ErrorDetails(String message, HttpStatus status) {
}
