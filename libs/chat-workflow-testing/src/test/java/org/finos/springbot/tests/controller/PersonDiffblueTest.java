package org.finos.springbot.tests.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class PersonDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Person#Person()}
   *   <li>{@link Person#setAddresses(List)}
   *   <li>{@link Person#setNames(List)}
   *   <li>{@link Person#getAddresses()}
   *   <li>{@link Person#getNames()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Person actualPerson = new Person();
    ArrayList<Address> addresses = new ArrayList<>();
    actualPerson.setAddresses(addresses);
    ArrayList<String> names = new ArrayList<>();
    actualPerson.setNames(names);
    List<Address> actualAddresses = actualPerson.getAddresses();
    List<String> actualNames = actualPerson.getNames();

    // Assert that nothing has changed
    assertTrue(actualAddresses.isEmpty());
    assertTrue(actualNames.isEmpty());
    assertSame(addresses, actualAddresses);
    assertSame(names, actualNames);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Person#Person(List)}
   *   <li>{@link Person#setAddresses(List)}
   *   <li>{@link Person#setNames(List)}
   *   <li>{@link Person#getAddresses()}
   *   <li>{@link Person#getNames()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    Person actualPerson = new Person(new ArrayList<>());
    ArrayList<Address> addresses = new ArrayList<>();
    actualPerson.setAddresses(addresses);
    ArrayList<String> names = new ArrayList<>();
    actualPerson.setNames(names);
    List<Address> actualAddresses = actualPerson.getAddresses();
    List<String> actualNames = actualPerson.getNames();

    // Assert that nothing has changed
    assertTrue(actualAddresses.isEmpty());
    assertTrue(actualNames.isEmpty());
    assertSame(addresses, actualAddresses);
    assertSame(names, actualNames);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Person#Person(List, List)}
   *   <li>{@link Person#setAddresses(List)}
   *   <li>{@link Person#setNames(List)}
   *   <li>{@link Person#getAddresses()}
   *   <li>{@link Person#getNames()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange
    ArrayList<String> names = new ArrayList<>();

    // Act
    Person actualPerson = new Person(names, new ArrayList<>());
    ArrayList<Address> addresses = new ArrayList<>();
    actualPerson.setAddresses(addresses);
    ArrayList<String> names2 = new ArrayList<>();
    actualPerson.setNames(names2);
    List<Address> actualAddresses = actualPerson.getAddresses();
    List<String> actualNames = actualPerson.getNames();

    // Assert that nothing has changed
    assertTrue(actualAddresses.isEmpty());
    assertTrue(actualNames.isEmpty());
    assertSame(addresses, actualAddresses);
    assertSame(names2, actualNames);
  }
}
