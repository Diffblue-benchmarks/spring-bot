package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ImageDiffblueTest {
  /**
   * Method under test: {@link Image#getText()}
   */
  @Test
  void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", (new Image.ImageImpl("https://example.org/example", "Alt")).getText());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Image.ImageImpl#equals(Object)}
   *   <li>{@link Image.ImageImpl#hashCode()}
   * </ul>
   */
  @Test
  void testImageImplEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Image.ImageImpl imageImpl = new Image.ImageImpl("https://example.org/example", "Alt");
    Image.ImageImpl imageImpl2 = new Image.ImageImpl("https://example.org/example", "Alt");

    // Act and Assert
    assertEquals(imageImpl, imageImpl2);
    int expectedHashCodeResult = imageImpl.hashCode();
    assertEquals(expectedHashCodeResult, imageImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Image.ImageImpl#equals(Object)}
   *   <li>{@link Image.ImageImpl#hashCode()}
   * </ul>
   */
  @Test
  void testImageImplEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Image.ImageImpl imageImpl = new Image.ImageImpl("https://example.org/example", "Alt");

    // Act and Assert
    assertEquals(imageImpl, imageImpl);
    int expectedHashCodeResult = imageImpl.hashCode();
    assertEquals(expectedHashCodeResult, imageImpl.hashCode());
  }

  /**
   * Method under test: {@link Image.ImageImpl#equals(Object)}
   */
  @Test
  void testImageImplEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Image.ImageImpl imageImpl = new Image.ImageImpl("Url", "Alt");

    // Act and Assert
    assertNotEquals(imageImpl, new Image.ImageImpl("https://example.org/example", "Alt"));
  }

  /**
   * Method under test: {@link Image.ImageImpl#equals(Object)}
   */
  @Test
  void testImageImplEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Image.ImageImpl imageImpl = new Image.ImageImpl("https://example.org/example",
        "org.finos.springbot.workflow.content.Image");

    // Act and Assert
    assertNotEquals(imageImpl, new Image.ImageImpl("https://example.org/example", "Alt"));
  }

  /**
   * Method under test: {@link Image.ImageImpl#equals(Object)}
   */
  @Test
  void testImageImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Image.ImageImpl("https://example.org/example", "Alt"), null);
  }

  /**
   * Method under test: {@link Image.ImageImpl#equals(Object)}
   */
  @Test
  void testImageImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Image.ImageImpl("https://example.org/example", "Alt"), "Different type to ImageImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Image.ImageImpl#ImageImpl(String, String)}
   *   <li>{@link Image.ImageImpl#getAlt()}
   *   <li>{@link Image.ImageImpl#getUrl()}
   * </ul>
   */
  @Test
  void testImageImplGettersAndSetters() {
    // Arrange and Act
    Image.ImageImpl actualImageImpl = new Image.ImageImpl("https://example.org/example", "Alt");
    String actualAlt = actualImageImpl.getAlt();

    // Assert
    assertEquals("Alt", actualAlt);
    assertEquals("https://example.org/example", actualImageImpl.getUrl());
  }

  /**
   * Method under test: {@link Image#of(String, String)}
   */
  @Test
  void testOf() {
    // Arrange and Act
    Image actualOfResult = Image.of("https://example.org/example", "Alt");

    // Assert
    assertTrue(actualOfResult instanceof Image.ImageImpl);
    assertEquals("", actualOfResult.getText());
    assertEquals("Alt", actualOfResult.getAlt());
    assertEquals("https://example.org/example", actualOfResult.getUrl());
  }
}
