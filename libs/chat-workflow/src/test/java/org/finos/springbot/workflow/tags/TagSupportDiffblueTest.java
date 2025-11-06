package org.finos.springbot.workflow.tags;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.finos.springbot.workflow.annotations.Work;
import org.junit.jupiter.api.Test;

class TagSupportDiffblueTest {
  /**
   * Method under test: {@link TagSupport#toTags(Class)}
   */
  @Test
  void testToTags() {
    // Arrange
    Class<Object> c = Object.class;

    // Act
    Set<String> actualToTagsResult = TagSupport.toTags(c);

    // Assert
    assertTrue(actualToTagsResult.isEmpty());
  }

  /**
   * Method under test: {@link TagSupport#toTags(Class)}
   */
  @Test
  void testToTags2() {
    // Arrange and Act
    Set<String> actualToTagsResult = TagSupport.toTags(null);

    // Assert
    assertTrue(actualToTagsResult.isEmpty());
  }

  /**
   * Method under test: {@link TagSupport#toTags(Class)}
   */
  @Test
  void testToTags3() {
    // Arrange
    Class<Work> c = Work.class;

    // Act
    Set<String> actualToTagsResult = TagSupport.toTags(c);

    // Assert
    assertTrue(actualToTagsResult.isEmpty());
  }

  /**
   * Method under test: {@link TagSupport#formatTag(Class)}
   */
  @Test
  void testFormatTag() {
    // Arrange
    Class<Object> in = Object.class;

    // Act and Assert
    assertEquals("java-lang-object", TagSupport.formatTag(in));
  }

  /**
   * Method under test: {@link TagSupport#formatTag(String)}
   */
  @Test
  void testFormatTag2() {
    // Arrange, Act and Assert
    assertEquals("in", TagSupport.formatTag("In"));
  }
}
