package com.intelliware.unit_testing.mocking.banking.adapters;

public class InsufficientFundsException extends RuntimeException {

  public InsufficientFundsException(String message) {
    super(message);
  }

  public InsufficientFundsException() {
    super();
  }

}
