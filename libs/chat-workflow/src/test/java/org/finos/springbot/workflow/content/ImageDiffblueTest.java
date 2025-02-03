package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.content.Image.ImageImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImageDiffblueTest {
  /**
   * Test {@link Image#getText()}.
   * <p>
   * Method under test: {@link Image#getText()}
   */
  @Test
  @DisplayName("Test getText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.workflow.content.Image.getText()"})
  void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", (new ImageImpl("https://example.org/example", "Alt")).getText());
  }

  /**
   * Test ImageImpl {@link ImageImpl#equals(Object)}, and {@link ImageImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageImpl#equals(Object)}
   *   <li>{@link ImageImpl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ImageImpl equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Image$ImageImpl.equals(java.lang.Object)",
      "int org.finos.springbot.workflow.content.Image$ImageImpl.hashCode()"})
  void testImageImplEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImageImpl imageImpl = new ImageImpl("https://example.org/example", "Alt");
    ImageImpl imageImpl2 = new ImageImpl("https://example.org/example", "Alt");

    // Act and Assert
    assertEquals(imageImpl, imageImpl2);
    int expectedHashCodeResult = imageImpl.hashCode();
    assertEquals(expectedHashCodeResult, imageImpl2.hashCode());
  }

  /**
   * Test ImageImpl {@link ImageImpl#equals(Object)}, and {@link ImageImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageImpl#equals(Object)}
   *   <li>{@link ImageImpl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ImageImpl equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Image$ImageImpl.equals(java.lang.Object)",
      "int org.finos.springbot.workflow.content.Image$ImageImpl.hashCode()"})
  void testImageImplEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImageImpl imageImpl = new ImageImpl("https://example.org/example", "Alt");

    // Act and Assert
    assertEquals(imageImpl, imageImpl);
    int expectedHashCodeResult = imageImpl.hashCode();
    assertEquals(expectedHashCodeResult, imageImpl.hashCode());
  }

  /**
   * Test ImageImpl {@link ImageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test ImageImpl equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Image$ImageImpl.equals(java.lang.Object)",
      "int org.finos.springbot.workflow.content.Image$ImageImpl.hashCode()"})
  void testImageImplEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImageImpl imageImpl = new ImageImpl("Url", "Alt");

    // Act and Assert
    assertNotEquals(imageImpl, new ImageImpl("https://example.org/example", "Alt"));
  }

  /**
   * Test ImageImpl {@link ImageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test ImageImpl equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Image$ImageImpl.equals(java.lang.Object)",
      "int org.finos.springbot.workflow.content.Image$ImageImpl.hashCode()"})
  void testImageImplEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImageImpl imageImpl = new ImageImpl("https://example.org/example", "org.finos.springbot.workflow.content.Image");

    // Act and Assert
    assertNotEquals(imageImpl, new ImageImpl("https://example.org/example", "Alt"));
  }

  /**
   * Test ImageImpl {@link ImageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test ImageImpl equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Image$ImageImpl.equals(java.lang.Object)",
      "int org.finos.springbot.workflow.content.Image$ImageImpl.hashCode()"})
  void testImageImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ImageImpl("https://example.org/example", "Alt"), null);
  }

  /**
   * Test ImageImpl {@link ImageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test ImageImpl equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Image$ImageImpl.equals(java.lang.Object)",
      "int org.finos.springbot.workflow.content.Image$ImageImpl.hashCode()"})
  void testImageImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ImageImpl("https://example.org/example", "Alt"), "Different type to ImageImpl");
  }

  /**
   * Test ImageImpl getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageImpl#ImageImpl(String, String)}
   *   <li>{@link ImageImpl#getAlt()}
   *   <li>{@link ImageImpl#getUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test ImageImpl getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.content.Image$ImageImpl.<init>(java.lang.String, java.lang.String)",
      "java.lang.String org.finos.springbot.workflow.content.Image$ImageImpl.getAlt()",
      "java.lang.String org.finos.springbot.workflow.content.Image$ImageImpl.getUrl()"})
  void testImageImplGettersAndSetters() {
    // Arrange and Act
    ImageImpl actualImageImpl = new ImageImpl("https://example.org/example", "Alt");
    String actualAlt = actualImageImpl.getAlt();

    // Assert
    assertEquals("Alt", actualAlt);
    assertEquals("https://example.org/example", actualImageImpl.getUrl());
  }

  /**
   * Test {@link Image#of(String, String)}.
   * <p>
   * Method under test: {@link Image#of(String, String)}
   */
  @Test
  @DisplayName("Test of(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Image org.finos.springbot.workflow.content.Image.of(java.lang.String, java.lang.String)"})
  void testOf() {
    // Arrange and Act
    Image actualOfResult = Image.of("https://example.org/example", "Alt");

    // Assert
    assertTrue(actualOfResult instanceof ImageImpl);
    assertEquals("", actualOfResult.getText());
    assertEquals("Alt", actualOfResult.getAlt());
    assertEquals("https://example.org/example", actualOfResult.getUrl());
  }
}
