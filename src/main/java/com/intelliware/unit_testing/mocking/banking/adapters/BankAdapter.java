package com.intelliware.unit_testing.mocking.banking.adapters;

import java.util.UUID;

public interface BankAdapter {
  public boolean representsCustomer(UUID customerId);
  public void transferFunds(Float amount, UUID destinationAccount);
}
