package org.finos.springbot.symphony.tags;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.finos.springbot.symphony.content.CashTag;
import org.finos.springbot.symphony.content.HashTag;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.Tag;
import org.junit.jupiter.api.Test;

class SymphonyTagSupportDiffblueTest {
  /**
   * Method under test: {@link SymphonyTagSupport#toHashTag(String)}
   */
  @Test
  void testToHashTag() {
    // Arrange, Act and Assert
    assertEquals("<hash tag=\"in\" /> ", SymphonyTagSupport.toHashTag("In"));
    assertEquals("", SymphonyTagSupport.toHashTag(null));
  }

  /**
   * Method under test: {@link SymphonyTagSupport#toCashTag(String)}
   */
  @Test
  void testToCashTag() {
    // Arrange, Act and Assert
    assertEquals("<cash tag=\"in\" /> ", SymphonyTagSupport.toCashTag("In"));
    assertEquals("", SymphonyTagSupport.toCashTag(null));
  }

  /**
   * Method under test: {@link SymphonyTagSupport#toUserTag(String)}
   */
  @Test
  void testToUserTag() {
    // Arrange, Act and Assert
    assertEquals("<mention uid=\"42\" />", SymphonyTagSupport.toUserTag("42"));
    assertEquals("", SymphonyTagSupport.toUserTag(null));
  }

  /**
   * Method under test: {@link SymphonyTagSupport#format(Tag)}
   */
  @Test
  void testFormat() {
    // Arrange, Act and Assert
    assertEquals("<cash tag=\"42\" /> ", SymphonyTagSupport.format(new CashTag("42")));
    assertEquals("<mention uid=\"1\" />", SymphonyTagSupport.format(new SymphonyUser(1L)));
    assertEquals("", SymphonyTagSupport.format(new CashTag("")));
    assertEquals("<hash tag=\"42\" /> ", SymphonyTagSupport.format(new HashTag("42")));
    assertEquals("", SymphonyTagSupport.format(new HashTag("")));
    assertEquals("", SymphonyTagSupport.format(new SymphonyUser("Name", "42 Main St")));
  }

  /**
   * Method under test: {@link SymphonyTagSupport#classHashTags(Object)}
   */
  @Test
  void testClassHashTags() {
    // Arrange and Act
    Set<HashTag> actualClassHashTagsResult = SymphonyTagSupport.classHashTags("In");

    // Assert
    assertTrue(actualClassHashTagsResult.isEmpty());
  }

  /**
   * Method under test: {@link SymphonyTagSupport#classHashTags(Object)}
   */
  @Test
  void testClassHashTags2() {
    // Arrange and Act
    Set<HashTag> actualClassHashTagsResult = SymphonyTagSupport.classHashTags(null);

    // Assert
    assertTrue(actualClassHashTagsResult.isEmpty());
  }

  /**
   * Method under test: {@link SymphonyTagSupport#classHashTags(Object)}
   */
  @Test
  void testClassHashTags3() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    Set<HashTag> actualClassHashTagsResult = SymphonyTagSupport.classHashTags(forNameResult);

    // Assert
    assertTrue(actualClassHashTagsResult.isEmpty());
  }

  /**
   * Method under test: {@link SymphonyTagSupport#toHashTags(Class)}
   */
  @Test
  void testToHashTags() {
    // Arrange
    Class<Object> c = Object.class;

    // Act
    Set<HashTag> actualToHashTagsResult = SymphonyTagSupport.toHashTags(c);

    // Assert
    assertTrue(actualToHashTagsResult.isEmpty());
  }
}
