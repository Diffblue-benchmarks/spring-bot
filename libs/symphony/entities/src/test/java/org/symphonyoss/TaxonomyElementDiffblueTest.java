package org.symphonyoss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import com.symphony.user.DisplayName;
import org.junit.jupiter.api.Test;
import org.symphonyoss.fin.security.id.Cusip;

class TaxonomyElementDiffblueTest {
  /**
   * Method under test: {@link TaxonomyElement#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals("42", (new DisplayName("42")).getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaxonomyElement#equals(Object)}
   *   <li>{@link TaxonomyElement#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link TaxonomyElement#equals(Object)}
   *   <li>{@link TaxonomyElement#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link TaxonomyElement#equals(Object)}
   *   <li>{@link TaxonomyElement#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DisplayName displayName = new DisplayName("42");

    // Act and Assert
    assertEquals(displayName, displayName);
    int expectedHashCodeResult = displayName.hashCode();
    assertEquals(expectedHashCodeResult, displayName.hashCode());
  }

  /**
   * Method under test: {@link TaxonomyElement#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("TaxonomyElement [value=42, prefix=@]", (new DisplayName("42")).toString());
  }

  /**
   * Method under test: {@link TaxonomyElement#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DisplayName displayName = new DisplayName("Value");

    // Act and Assert
    assertNotEquals(displayName, new DisplayName("42"));
  }

  /**
   * Method under test: {@link TaxonomyElement#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DisplayName displayName = new DisplayName(null);

    // Act and Assert
    assertNotEquals(displayName, new DisplayName("42"));
  }

  /**
   * Method under test: {@link TaxonomyElement#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new DisplayName("42"), mock(Cusip.class));
  }

  /**
   * Method under test: {@link TaxonomyElement#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DisplayName("42"), null);
  }

  /**
   * Method under test: {@link TaxonomyElement#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DisplayName("42"), "Different type to TaxonomyElement");
  }
}
