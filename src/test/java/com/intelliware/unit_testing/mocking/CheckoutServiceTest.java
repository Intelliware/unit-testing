package com.intelliware.unit_testing.mocking;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.intelliware.unit_testing.mocking.banking.BankService;
import com.intelliware.unit_testing.mocking.product.Product;

public class CheckoutServiceTest {

  private CheckoutService fixture;

  @Mock
  private BankService mockBankService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);

    fixture = new CheckoutService(mockBankService);
  }

  @Test
  public void testPurchaseSucceeds() {
    UUID customerId = UUID.randomUUID();
    Product prod = new Product();
    prod.setPrice(100f);

    when(mockBankService.getFunds(customerId, prod.getPrice())).thenReturn(true);

    var actual = fixture.purchase(customerId, prod);

    assertTrue(actual);
  }

  @Test
  public void testPurchaseFailsWhenBankServiceFails() {
    UUID customerId = UUID.randomUUID();
    Product prod = new Product();
    prod.setPrice(100f);

    when(mockBankService.getFunds(customerId, prod.getPrice())).thenReturn(false);

    var actual = fixture.purchase(customerId, prod);

    assertFalse(actual);
  }

  @Test
  public void testPurchaseFailsForInvalidProduct() {
    UUID customerId = UUID.randomUUID();
    Product prod = new Product();
    prod.setPrice(-1f);

    var actual = fixture.purchase(customerId, prod);

    assertFalse(actual);
    verifyNoInteractions(mockBankService);
  }
}
