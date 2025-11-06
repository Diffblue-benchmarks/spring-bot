package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.springbot.workflow.content.BlockQuote.BlockQuoteImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractOrderedContentDiffblueTest {
  /**
   * Test {@link AbstractOrderedContent#getContents()}.
   * <p>
   * Method under test: {@link AbstractOrderedContent#getContents()}
   */
  @Test
  @DisplayName("Test getContents()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List AbstractOrderedContent.getContents()"})
  void testGetContents() {
    // Arrange, Act and Assert
    assertTrue((new BlockQuoteImpl(new ArrayList<>())).getContents().isEmpty());
  }

  /**
   * Test {@link AbstractOrderedContent#equals(Object)}, and {@link AbstractOrderedContent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderedContent#equals(Object)}
   *   <li>{@link AbstractOrderedContent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractOrderedContent.equals(Object)", "int AbstractOrderedContent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());
    BlockQuoteImpl blockQuoteImpl2 = new BlockQuoteImpl(new ArrayList<>());

    // Act and Assert
    assertEquals(blockQuoteImpl, blockQuoteImpl2);
    int expectedHashCodeResult = blockQuoteImpl.hashCode();
    assertEquals(expectedHashCodeResult, blockQuoteImpl2.hashCode());
  }

  /**
   * Test {@link AbstractOrderedContent#equals(Object)}, and {@link AbstractOrderedContent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderedContent#equals(Object)}
   *   <li>{@link AbstractOrderedContent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractOrderedContent.equals(Object)", "int AbstractOrderedContent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());

    // Act and Assert
    assertEquals(blockQuoteImpl, blockQuoteImpl);
    int expectedHashCodeResult = blockQuoteImpl.hashCode();
    assertEquals(expectedHashCodeResult, blockQuoteImpl.hashCode());
  }

  /**
   * Test {@link AbstractOrderedContent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderedContent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractOrderedContent.equals(Object)", "int AbstractOrderedContent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(mock(Content.class));
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(c);

    // Act and Assert
    assertNotEquals(blockQuoteImpl, new BlockQuoteImpl(new ArrayList<>()));
  }

  /**
   * Test {@link AbstractOrderedContent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderedContent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractOrderedContent.equals(Object)", "int AbstractOrderedContent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new BlockQuoteImpl(new ArrayList<>()));
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(c);

    ArrayList<Content> c2 = new ArrayList<>();
    c2.add(mock(Content.class));

    // Act and Assert
    assertNotEquals(blockQuoteImpl, new BlockQuoteImpl(c2));
  }

  /**
   * Test {@link AbstractOrderedContent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderedContent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractOrderedContent.equals(Object)", "int AbstractOrderedContent.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockQuoteImpl(new ArrayList<>()), null);
  }

  /**
   * Test {@link AbstractOrderedContent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderedContent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractOrderedContent.equals(Object)", "int AbstractOrderedContent.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockQuoteImpl(new ArrayList<>()), "Different type to AbstractOrderedContent");
  }

  /**
   * Test {@link AbstractOrderedContent#getText()}.
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return empty string.</li>
   *   <li>Then return {@code Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderedContent#getText()}
   */
  @Test
  @DisplayName("Test getText(); given Content getText() return empty string; then return 'Text'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractOrderedContent.getText()"})
  void testGetText_givenContentGetTextReturnEmptyString_thenReturnText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("");
    Content content2 = mock(Content.class);
    when(content2.getText()).thenReturn("Text");

    ArrayList<Content> c = new ArrayList<>();
    c.add(content2);
    c.add(content);

    // Act
    String actualText = (new BlockQuoteImpl(c)).getText();

    // Assert
    verify(content2).getText();
    verify(content).getText();
    assertEquals("Text", actualText);
  }

  /**
   * Test {@link AbstractOrderedContent#getText()}.
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code Text}.</li>
   *   <li>Then return {@code Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderedContent#getText()}
   */
  @Test
  @DisplayName("Test getText(); given Content getText() return 'Text'; then return 'Text'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractOrderedContent.getText()"})
  void testGetText_givenContentGetTextReturnText_thenReturnText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("Text");

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);

    // Act
    String actualText = (new BlockQuoteImpl(c)).getText();

    // Assert
    verify(content).getText();
    assertEquals("Text", actualText);
  }

  /**
   * Test {@link AbstractOrderedContent#getText()}.
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code Text}.</li>
   *   <li>Then return {@code Text Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderedContent#getText()}
   */
  @Test
  @DisplayName("Test getText(); given Content getText() return 'Text'; then return 'Text Text'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractOrderedContent.getText()"})
  void testGetText_givenContentGetTextReturnText_thenReturnTextText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("Text");
    Content content2 = mock(Content.class);
    when(content2.getText()).thenReturn("Text");

    ArrayList<Content> c = new ArrayList<>();
    c.add(content2);
    c.add(content);

    // Act
    String actualText = (new BlockQuoteImpl(c)).getText();

    // Assert
    verify(content2).getText();
    verify(content).getText();
    assertEquals("Text Text", actualText);
  }

  /**
   * Test {@link AbstractOrderedContent#getText()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderedContent#getText()}
   */
  @Test
  @DisplayName("Test getText(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractOrderedContent.getText()"})
  void testGetText_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new BlockQuoteImpl(new ArrayList<>())).getText());
  }
}
