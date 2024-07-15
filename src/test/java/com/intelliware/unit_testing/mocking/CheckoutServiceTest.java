package com.intelliware.unit_testing.mocking;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.intelliware.unit_testing.mocking.banking.BankService;

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
    // when(nameOfMock.methodWeWantToMock(args)).thenReturn(desiredResponse);

    var actual = fixture.purchase(null, null);

    assertTrue(actual);
  }
}
