package com.intelliware.unit_testing.testingIntro;

public class Example {

  public Integer factorial(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Number must be non-negative");
    }
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }

}
