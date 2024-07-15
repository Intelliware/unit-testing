package com.intelliware.unit_testing.mocking.banking.adapters;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TDAdapter implements BankAdapter {

  @Override
  public boolean representsCustomer(UUID customerId) {
    throw new UnsupportedOperationException(
        "Method not implemented.  You shouldn't have to change this to test the other services");
  }

  @Override
  public void transferFunds(Float amount, UUID destinationAccount) {
    throw new UnsupportedOperationException(
        "Method not implemented.  You shouldn't have to change this to test the other services");
  }
}
