package org.finos.springbot.workflow.tags;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.finos.springbot.workflow.annotations.Work;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TagSupportDiffblueTest {
  /**
   * Test {@link TagSupport#classTags(Object)}.
   *
   * <ul>
   *   <li>When {@code In}.
   * </ul>
   *
   * <p>Method under test: {@link TagSupport#classTags(Object)}
   */
  @Test
  @DisplayName("Test classTags(Object); when 'In'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set TagSupport.classTags(Object)"})
  void testClassTags_whenIn() {
    // Arrange and Act
    Set<String> actualClassTagsResult = TagSupport.classTags("In");

    // Assert
    assertTrue(actualClassTagsResult.isEmpty());
  }

  /**
   * Test {@link TagSupport#classTags(Object)}.
   *
   * <ul>
   *   <li>When {@code Class}.
   * </ul>
   *
   * <p>Method under test: {@link TagSupport#classTags(Object)}
   */
  @Test
  @DisplayName("Test classTags(Object); when 'java.lang.Class'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set TagSupport.classTags(Object)"})
  void testClassTags_whenJavaLangClass() {
    // Arrange
    Class<Class> forNameResult = Class.class;

    // Act
    Set<String> actualClassTagsResult = TagSupport.classTags(forNameResult);

    // Assert
    assertTrue(actualClassTagsResult.isEmpty());
  }

  /**
   * Test {@link TagSupport#classTags(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link TagSupport#classTags(Object)}
   */
  @Test
  @DisplayName("Test classTags(Object); when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set TagSupport.classTags(Object)"})
  void testClassTags_whenJavaLangObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    Set<String> actualClassTagsResult = TagSupport.classTags(forNameResult);

    // Assert
    assertTrue(actualClassTagsResult.isEmpty());
  }

  /**
   * Test {@link TagSupport#classTags(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TagSupport#classTags(Object)}
   */
  @Test
  @DisplayName("Test classTags(Object); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set TagSupport.classTags(Object)"})
  void testClassTags_whenNull() {
    // Arrange and Act
    Set<String> actualClassTagsResult = TagSupport.classTags(null);

    // Assert
    assertTrue(actualClassTagsResult.isEmpty());
  }

  /**
   * Test {@link TagSupport#toTags(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link TagSupport#toTags(Class)}
   */
  @Test
  @DisplayName("Test toTags(Class); when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TagSupport#toTags(Class)}
   */
  @Test
  @DisplayName("Test toTags(Class); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set TagSupport.toTags(Class)"})
  void testToTags_whenNull() {
    // Arrange and Act
    Set<String> actualToTagsResult = TagSupport.toTags(null);

    // Assert
    assertTrue(actualToTagsResult.isEmpty());
  }

  /**
   * Test {@link TagSupport#toTags(Class)}.
   *
   * <ul>
   *   <li>When {@code Work}.
   * </ul>
   *
   * <p>Method under test: {@link TagSupport#toTags(Class)}
   */
  @Test
  @DisplayName("Test toTags(Class); when 'org.finos.springbot.workflow.annotations.Work'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code java-lang-object}.
   * </ul>
   *
   * <p>Method under test: {@link TagSupport#formatTag(Class)}
   */
  @Test
  @DisplayName(
      "Test formatTag(Class) with 'Class'; when 'java.lang.Object'; then return 'java-lang-object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TagSupport.formatTag(Class)"})
  void testFormatTagWithClass_whenJavaLangObject_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> in = Object.class;

    // Act and Assert
    assertEquals("java-lang-object", TagSupport.formatTag(in));
  }

  /**
   * Test {@link TagSupport#formatTag(String)} with {@code String}.
   *
   * <p>Method under test: {@link TagSupport#formatTag(String)}
   */
  @Test
  @DisplayName("Test formatTag(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TagSupport.formatTag(String)"})
  void testFormatTagWithString() {
    // Arrange, Act and Assert
    assertEquals("in", TagSupport.formatTag("In"));
  }
}
