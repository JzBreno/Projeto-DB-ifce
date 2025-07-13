package com.example.locadora.exceptions;

public class FilmeNotFoundException extends RuntimeException {

  public FilmeNotFoundException(String message) {
    super(message);
  }

}
