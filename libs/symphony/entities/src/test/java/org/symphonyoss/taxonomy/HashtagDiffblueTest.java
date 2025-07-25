package org.symphonyoss.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HashtagDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Value is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Hashtag#Hashtag()}
   *   <li>{@link Hashtag#getSymbolPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Value is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Hashtag.<init>()",
    "void Hashtag.<init>(String)",
    "String Hashtag.getSymbolPrefix()"
  })
  void testGettersAndSetters_thenReturnValueIsNull() {
    // Arrange and Act
    Hashtag actualHashtag = new Hashtag();

    // Assert
    assertEquals("#", actualHashtag.getSymbolPrefix());
    assertNull(actualHashtag.getValue());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Value is {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Hashtag#Hashtag(String)}
   *   <li>{@link Hashtag#getSymbolPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '42'; then return Value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Hashtag.<init>()",
    "void Hashtag.<init>(String)",
    "String Hashtag.getSymbolPrefix()"
  })
  void testGettersAndSetters_when42_thenReturnValueIs42() {
    // Arrange and Act
    Hashtag actualHashtag = new Hashtag("42");

    // Assert
    assertEquals("#", actualHashtag.getSymbolPrefix());
    assertEquals("42", actualHashtag.getValue());
  }
}
