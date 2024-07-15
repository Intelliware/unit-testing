package com.intelliware.unit_testing.romanNumerals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DecoderTest {

  private Decoder fixture;

  @BeforeEach
  public void setup() {
    fixture = new Decoder();
  }

  @Test
  public void testDecoder() {
    assertEquals(0, fixture.decode("anything"));
  }
}
