package org.finos.springbot.symphony.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class HashTagDiffblueTest {
  /**
   * Method under test: {@link HashTag#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("42", (new HashTag("42")).getName());
  }

  /**
   * Method under test: {@link HashTag#createID()}
   */
  @Test
  void testCreateID() {
    // Arrange, Act and Assert
    assertEquals("#", HashTag.createID().getSymbolPrefix());
    assertEquals("#", HashTag.createID(UUID.randomUUID()).getSymbolPrefix());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HashTag#HashTag()}
   *   <li>{@link HashTag#getTagType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    HashTag actualHashTag = new HashTag();
    actualHashTag.getTagType();

    // Assert
    assertNull(actualHashTag.getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HashTag#HashTag(String)}
   *   <li>{@link HashTag#getTagType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    HashTag actualHashTag = new HashTag("42");
    actualHashTag.getTagType();

    // Assert
    assertEquals("42", actualHashTag.getValue());
  }
}
