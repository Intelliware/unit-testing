package com.intelliware.unit_testing.mocking.banking;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.intelliware.unit_testing.mocking.banking.adapters.InsufficientFundsException;
import com.intelliware.unit_testing.mocking.banking.adapters.ScotiaBankAdapter;
import com.intelliware.unit_testing.mocking.banking.adapters.TDAdapter;

public class BankServiceTest {

  private BankService fixture;

  @Mock
  private ScotiaBankAdapter scotiaBankAdapter;

  @Mock
  private TDAdapter tdAdapter;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);

    fixture = new BankService(scotiaBankAdapter, tdAdapter);
  }

  @Test
  public void testBankServiceTransfersFromScotia() {
    UUID customerId = UUID.randomUUID();
    Float purchaseAmount = 100f;

    when(tdAdapter.representsCustomer(customerId)).thenReturn(false);
    when(scotiaBankAdapter.representsCustomer(customerId)).thenReturn(true);

    var actual = fixture.getFunds(customerId, purchaseAmount);

    assertTrue(actual);
  }

  @Test
  public void testBankServiceTransferFailsToTD() {
    UUID customerId = UUID.randomUUID();
    Float purchaseAmount = 100f;

    when(tdAdapter.representsCustomer(customerId)).thenReturn(true);
    doThrow(new InsufficientFundsException())
        .when(tdAdapter).transferFunds(purchaseAmount, BankService.OUR_STORE_ID);

    var actual = fixture.getFunds(customerId, purchaseAmount);

    assertFalse(actual);
  }
}
