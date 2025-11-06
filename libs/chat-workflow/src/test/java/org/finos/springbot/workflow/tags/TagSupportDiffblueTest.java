package org.finos.springbot.workflow.tags;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.finos.springbot.workflow.annotations.Work;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TagSupportDiffblueTest {
  /**
   * Test {@link TagSupport#toTags(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSupport#toTags(Class)}
   */
  @Test
  @DisplayName("Test toTags(Class); when 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set TagSupport.toTags(Class)"})
  void testToTags_whenJavaLangObject() {
    // Arrange
    Class<Object> c = Object.class;

    // Act
    Set<String> actualToTagsResult = TagSupport.toTags(c);

    // Assert
    assertTrue(actualToTagsResult.isEmpty());
  }

  /**
   * Test {@link TagSupport#toTags(Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSupport#toTags(Class)}
   */
  @Test
  @DisplayName("Test toTags(Class); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set TagSupport.toTags(Class)"})
  void testToTags_whenNull() {
    // Arrange and Act
    Set<String> actualToTagsResult = TagSupport.toTags(null);

    // Assert
    assertTrue(actualToTagsResult.isEmpty());
  }

  /**
   * Test {@link TagSupport#toTags(Class)}.
   * <ul>
   *   <li>When {@code Work}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSupport#toTags(Class)}
   */
  @Test
  @DisplayName("Test toTags(Class); when 'org.finos.springbot.workflow.annotations.Work'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set TagSupport.toTags(Class)"})
  void testToTags_whenOrgFinosSpringbotWorkflowAnnotationsWork() {
    // Arrange
    Class<Work> c = Work.class;

    // Act
    Set<String> actualToTagsResult = TagSupport.toTags(c);

    // Assert
    assertTrue(actualToTagsResult.isEmpty());
  }

  /**
   * Test {@link TagSupport#formatTag(Class)} with {@code Class}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code java-lang-object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSupport#formatTag(Class)}
   */
  @Test
  @DisplayName("Test formatTag(Class) with 'Class'; when 'java.lang.Object'; then return 'java-lang-object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TagSupport.formatTag(Class)"})
  void testFormatTagWithClass_whenJavaLangObject_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> in = Object.class;

    // Act and Assert
    assertEquals("java-lang-object", TagSupport.formatTag(in));
  }

  /**
   * Test {@link TagSupport#formatTag(String)} with {@code String}.
   * <p>
   * Method under test: {@link TagSupport#formatTag(String)}
   */
  @Test
  @DisplayName("Test formatTag(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TagSupport.formatTag(String)"})
  void testFormatTagWithString() {
    // Arrange, Act and Assert
    assertEquals("in", TagSupport.formatTag("In"));
  }
}
