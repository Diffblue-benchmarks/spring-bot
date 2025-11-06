package org.symphonyoss.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class HashtagDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Hashtag#Hashtag()}
   *   <li>{@link Hashtag#getSymbolPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Hashtag actualHashtag = new Hashtag();

    // Assert
    assertEquals("#", actualHashtag.getSymbolPrefix());
    assertNull(actualHashtag.getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Hashtag#Hashtag(String)}
   *   <li>{@link Hashtag#getSymbolPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    Hashtag actualHashtag = new Hashtag("42");

    // Assert
    assertEquals("#", actualHashtag.getSymbolPrefix());
    assertEquals("42", actualHashtag.getValue());
  }
}
