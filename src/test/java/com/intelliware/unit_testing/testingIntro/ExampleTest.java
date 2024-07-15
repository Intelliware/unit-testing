package com.intelliware.unit_testing.testingIntro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExampleTest {

  private Example fixture;

  @BeforeEach
  public void setup() {
    fixture = new Example();
  }

  @Test
  public void testsGoHere() {
    assertEquals(2, 1+1);
  }

}
