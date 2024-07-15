package com.intelliware.unit_testing.mocking.banking;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    Boolean actual = fixture.getFunds(null, null);

    assertTrue(actual);
  }

  @Test
  public void testBankServiceTransferFailsToTD() {
    Boolean actual = fixture.getFunds(null, null);

    // look at doThrow() in mockito documentation for help mocking void methods

    assertFalse(actual);
  }
}
