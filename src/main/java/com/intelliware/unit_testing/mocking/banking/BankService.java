package com.intelliware.unit_testing.mocking.banking;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.intelliware.unit_testing.mocking.banking.adapters.BankAdapter;
import com.intelliware.unit_testing.mocking.banking.adapters.InsufficientFundsException;
import com.intelliware.unit_testing.mocking.banking.adapters.ScotiaBankAdapter;
import com.intelliware.unit_testing.mocking.banking.adapters.TDAdapter;

@Service
public class BankService {
  static final UUID OUR_STORE_ID = UUID.randomUUID(); //pretend this comes from a file somewhere

  private ScotiaBankAdapter scotiaBankAdapter;

  private TDAdapter tdAdapter;

  public BankService(ScotiaBankAdapter scotiaBankAdapter, TDAdapter tdAdapter) {
    this.scotiaBankAdapter = scotiaBankAdapter;
    this.tdAdapter = tdAdapter;
  }

  public Boolean getFunds(UUID customerId, Float purchaseAmount) {
    var bankAdapter = findAppropriateBankAdapter(customerId);
    try {
      bankAdapter.transferFunds(purchaseAmount, OUR_STORE_ID);
    } catch (InsufficientFundsException e) {
      return false;
    }

    return true;
  }

  private BankAdapter findAppropriateBankAdapter(UUID customerId) {
    if (tdAdapter.representsCustomer(customerId)) {
      return tdAdapter;
    } else if (scotiaBankAdapter.representsCustomer(customerId)) {
      return scotiaBankAdapter;
    } else {
      throw new RuntimeException("None of the banks we work with service account: " + customerId);
    }
  }
}
