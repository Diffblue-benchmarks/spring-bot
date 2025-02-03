package org.finos.springbot.tests.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PersonDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.controller.Person.<init>()",
      "void org.finos.springbot.tests.controller.Person.<init>(java.util.List)",
      "void org.finos.springbot.tests.controller.Person.<init>(java.util.List, java.util.List)",
      "java.util.List org.finos.springbot.tests.controller.Person.getAddresses()",
      "java.util.List org.finos.springbot.tests.controller.Person.getNames()",
      "void org.finos.springbot.tests.controller.Person.setAddresses(java.util.List)",
      "void org.finos.springbot.tests.controller.Person.setNames(java.util.List)"})
  void testGettersAndSetters() {
    // Arrange and Act
    Person actualPerson = new Person();
    ArrayList<Address> addresses = new ArrayList<>();
    actualPerson.setAddresses(addresses);
    ArrayList<String> names = new ArrayList<>();
    actualPerson.setNames(names);
    List<Address> actualAddresses = actualPerson.getAddresses();
    List<String> actualNames = actualPerson.getNames();

    // Assert
    assertTrue(actualAddresses.isEmpty());
    assertTrue(actualNames.isEmpty());
    assertSame(addresses, actualAddresses);
    assertSame(names, actualNames);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.controller.Person.<init>()",
      "void org.finos.springbot.tests.controller.Person.<init>(java.util.List)",
      "void org.finos.springbot.tests.controller.Person.<init>(java.util.List, java.util.List)",
      "java.util.List org.finos.springbot.tests.controller.Person.getAddresses()",
      "java.util.List org.finos.springbot.tests.controller.Person.getNames()",
      "void org.finos.springbot.tests.controller.Person.setAddresses(java.util.List)",
      "void org.finos.springbot.tests.controller.Person.setNames(java.util.List)"})
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    Person actualPerson = new Person(new ArrayList<>());
    ArrayList<Address> addresses = new ArrayList<>();
    actualPerson.setAddresses(addresses);
    ArrayList<String> names = new ArrayList<>();
    actualPerson.setNames(names);
    List<Address> actualAddresses = actualPerson.getAddresses();
    List<String> actualNames = actualPerson.getNames();

    // Assert
    assertTrue(actualAddresses.isEmpty());
    assertTrue(actualNames.isEmpty());
    assertSame(addresses, actualAddresses);
    assertSame(names, actualNames);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.controller.Person.<init>()",
      "void org.finos.springbot.tests.controller.Person.<init>(java.util.List)",
      "void org.finos.springbot.tests.controller.Person.<init>(java.util.List, java.util.List)",
      "java.util.List org.finos.springbot.tests.controller.Person.getAddresses()",
      "java.util.List org.finos.springbot.tests.controller.Person.getNames()",
      "void org.finos.springbot.tests.controller.Person.setAddresses(java.util.List)",
      "void org.finos.springbot.tests.controller.Person.setNames(java.util.List)"})
  void testGettersAndSetters_whenArrayList2() {
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

    // Assert
    assertTrue(actualAddresses.isEmpty());
    assertTrue(actualNames.isEmpty());
    assertSame(addresses, actualAddresses);
    assertSame(names2, actualNames);
  }
}
