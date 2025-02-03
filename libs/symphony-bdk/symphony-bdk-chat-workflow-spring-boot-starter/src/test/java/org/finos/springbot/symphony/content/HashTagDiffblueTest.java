package org.finos.springbot.symphony.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HashTagDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Value is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HashTag#HashTag()}
   *   <li>{@link HashTag#getTagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.symphony.content.HashTag.<init>()",
      "void org.finos.springbot.symphony.content.HashTag.<init>(java.lang.String)",
      "org.finos.springbot.workflow.content.Tag$Type org.finos.springbot.symphony.content.HashTag.getTagType()"})
  void testGettersAndSetters_thenReturnValueIsNull() {
    // Arrange and Act
    HashTag actualHashTag = new HashTag();
    actualHashTag.getTagType();

    // Assert
    assertNull(actualHashTag.getValue());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Value is {@code 42}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HashTag#HashTag(String)}
   *   <li>{@link HashTag#getTagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '42'; then return Value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.symphony.content.HashTag.<init>()",
      "void org.finos.springbot.symphony.content.HashTag.<init>(java.lang.String)",
      "org.finos.springbot.workflow.content.Tag$Type org.finos.springbot.symphony.content.HashTag.getTagType()"})
  void testGettersAndSetters_when42_thenReturnValueIs42() {
    // Arrange and Act
    HashTag actualHashTag = new HashTag("42");
    actualHashTag.getTagType();

    // Assert
    assertEquals("42", actualHashTag.getValue());
  }

  /**
   * Test {@link HashTag#getName()}.
   * <ul>
   *   <li>Given {@link HashTag#HashTag(String)} with id is {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashTag#getName()}
   */
  @Test
  @DisplayName("Test getName(); given HashTag(String) with id is '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.content.HashTag.getName()"})
  void testGetName_givenHashTagWithIdIs42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new HashTag("42")).getName());
  }

  /**
   * Test {@link HashTag#createID()}.
   * <p>
   * Method under test: {@link HashTag#createID()}
   */
  @Test
  @DisplayName("Test createID()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.symphony.content.HashTag org.finos.springbot.symphony.content.HashTag.createID()"})
  void testCreateID() {
    // Arrange, Act and Assert
    assertEquals("#", HashTag.createID().getSymbolPrefix());
  }

  /**
   * Test {@link HashTag#createID(UUID)} with {@code UUID}.
   * <ul>
   *   <li>When randomUUID.</li>
   *   <li>Then return SymbolPrefix is {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashTag#createID(UUID)}
   */
  @Test
  @DisplayName("Test createID(UUID) with 'UUID'; when randomUUID; then return SymbolPrefix is '#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.symphony.content.HashTag org.finos.springbot.symphony.content.HashTag.createID(java.util.UUID)"})
  void testCreateIDWithUuid_whenRandomUUID_thenReturnSymbolPrefixIsNumberSign() {
    // Arrange, Act and Assert
    assertEquals("#", HashTag.createID(UUID.randomUUID()).getSymbolPrefix());
  }
}
