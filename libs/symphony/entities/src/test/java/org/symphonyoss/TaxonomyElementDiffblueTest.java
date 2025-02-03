package org.symphonyoss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.user.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TaxonomyElementDiffblueTest {
  /**
   * Test {@link TaxonomyElement#getValue()}.
   * <p>
   * Method under test: {@link TaxonomyElement#getValue()}
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test getValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.symphonyoss.TaxonomyElement.getValue()"})
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals("42", (new DisplayName("42")).getValue());
  }

  /**
   * Test {@link TaxonomyElement#equals(Object)}, and {@link TaxonomyElement#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TaxonomyElement#equals(Object)}
   *   <li>{@link TaxonomyElement#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.symphonyoss.TaxonomyElement.equals(java.lang.Object)",
      "int org.symphonyoss.TaxonomyElement.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DisplayName displayName = new DisplayName("42");
    DisplayName displayName2 = new DisplayName("42");

    // Act and Assert
    assertEquals(displayName, displayName2);
    int expectedHashCodeResult = displayName.hashCode();
    assertEquals(expectedHashCodeResult, displayName2.hashCode());
  }

  /**
   * Test {@link TaxonomyElement#equals(Object)}, and {@link TaxonomyElement#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TaxonomyElement#equals(Object)}
   *   <li>{@link TaxonomyElement#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.symphonyoss.TaxonomyElement.equals(java.lang.Object)",
      "int org.symphonyoss.TaxonomyElement.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DisplayName displayName = new DisplayName(null);
    DisplayName displayName2 = new DisplayName(null);

    // Act and Assert
    assertEquals(displayName, displayName2);
    int expectedHashCodeResult = displayName.hashCode();
    assertEquals(expectedHashCodeResult, displayName2.hashCode());
  }

  /**
   * Test {@link TaxonomyElement#equals(Object)}, and {@link TaxonomyElement#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TaxonomyElement#equals(Object)}
   *   <li>{@link TaxonomyElement#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.symphonyoss.TaxonomyElement.equals(java.lang.Object)",
      "int org.symphonyoss.TaxonomyElement.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DisplayName displayName = new DisplayName("42");

    // Act and Assert
    assertEquals(displayName, displayName);
    int expectedHashCodeResult = displayName.hashCode();
    assertEquals(expectedHashCodeResult, displayName.hashCode());
  }

  /**
   * Test {@link TaxonomyElement#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyElement#equals(Object)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.symphonyoss.TaxonomyElement.equals(java.lang.Object)",
      "int org.symphonyoss.TaxonomyElement.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DisplayName displayName = new DisplayName("Value");

    // Act and Assert
    assertNotEquals(displayName, new DisplayName("42"));
  }

  /**
   * Test {@link TaxonomyElement#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyElement#equals(Object)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.symphonyoss.TaxonomyElement.equals(java.lang.Object)",
      "int org.symphonyoss.TaxonomyElement.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DisplayName displayName = new DisplayName(null);

    // Act and Assert
    assertNotEquals(displayName, new DisplayName("42"));
  }

  /**
   * Test {@link TaxonomyElement#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyElement#equals(Object)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.symphonyoss.TaxonomyElement.equals(java.lang.Object)",
      "int org.symphonyoss.TaxonomyElement.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DisplayName("42"), null);
  }

  /**
   * Test {@link TaxonomyElement#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyElement#equals(Object)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.symphonyoss.TaxonomyElement.equals(java.lang.Object)",
      "int org.symphonyoss.TaxonomyElement.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DisplayName("42"), "Different type to TaxonomyElement");
  }

  /**
   * Test {@link TaxonomyElement#toString()}.
   * <p>
   * Method under test: {@link TaxonomyElement#toString()}
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.symphonyoss.TaxonomyElement.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("TaxonomyElement [value=42, prefix=@]", (new DisplayName("42")).toString());
  }
}
