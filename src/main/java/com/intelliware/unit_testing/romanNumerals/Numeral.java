package com.intelliware.unit_testing.romanNumerals;

public enum Numeral {
  I(1),
  V(5),
  X(10),
  L(50),
  C(100),
  D(500),
  M(1000);

  private int value;

  Numeral(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
