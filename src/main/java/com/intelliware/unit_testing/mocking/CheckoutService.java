package com.intelliware.unit_testing.mocking;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.intelliware.unit_testing.mocking.banking.BankService;
import com.intelliware.unit_testing.mocking.product.Product;

@Service
public class CheckoutService {
  
  private BankService bankService;

  public CheckoutService(BankService bankService) {
    this.bankService = bankService;
  }

  public boolean purchase(UUID customerId, Product product) {
    if (validatePurchase(product)) {
      return bankService.getFunds(customerId, product.getPrice());
    }
    return false;
  }

  private boolean validatePurchase(Product product) {
    return product.getPrice() > 0;
  }

}
