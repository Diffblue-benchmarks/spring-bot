package org.finos.springbot.symphony.tags;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.finos.springbot.symphony.content.CashTag;
import org.finos.springbot.symphony.content.HashTag;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SymphonyTagSupportDiffblueTest {
  /**
   * Test {@link SymphonyTagSupport#toHashTag(String)}.
   *
   * <ul>
   *   <li>When {@code In}.
   *   <li>Then return {@code <hash tag="in" />}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTagSupport#toHashTag(String)}
   */
  @Test
  @DisplayName("Test toHashTag(String); when 'In'; then return '<hash tag=\"in\" />'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTagSupport.toHashTag(String)"})
  void testToHashTag_whenIn_thenReturnHashTagIn() {
    // Arrange, Act and Assert
    assertEquals("<hash tag=\"in\" /> ", SymphonyTagSupport.toHashTag("In"));
  }

  /**
   * Test {@link SymphonyTagSupport#toHashTag(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTagSupport#toHashTag(String)}
   */
  @Test
  @DisplayName("Test toHashTag(String); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTagSupport.toHashTag(String)"})
  void testToHashTag_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", SymphonyTagSupport.toHashTag(null));
  }

  /**
   * Test {@link SymphonyTagSupport#toCashTag(String)}.
   *
   * <ul>
   *   <li>When {@code In}.
   *   <li>Then return {@code <cash tag="in" />}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTagSupport#toCashTag(String)}
   */
  @Test
  @DisplayName("Test toCashTag(String); when 'In'; then return '<cash tag=\"in\" />'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTagSupport.toCashTag(String)"})
  void testToCashTag_whenIn_thenReturnCashTagIn() {
    // Arrange, Act and Assert
    assertEquals("<cash tag=\"in\" /> ", SymphonyTagSupport.toCashTag("In"));
  }

  /**
   * Test {@link SymphonyTagSupport#toCashTag(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTagSupport#toCashTag(String)}
   */
  @Test
  @DisplayName("Test toCashTag(String); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTagSupport.toCashTag(String)"})
  void testToCashTag_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", SymphonyTagSupport.toCashTag(null));
  }

  /**
   * Test {@link SymphonyTagSupport#toUserTag(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code <mention uid="42" />}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTagSupport#toUserTag(String)}
   */
  @Test
  @DisplayName("Test toUserTag(String); when '42'; then return '<mention uid=\"42\" />'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTagSupport.toUserTag(String)"})
  void testToUserTag_when42_thenReturnMentionUid42() {
    // Arrange, Act and Assert
    assertEquals("<mention uid=\"42\" />", SymphonyTagSupport.toUserTag("42"));
  }

  /**
   * Test {@link SymphonyTagSupport#toUserTag(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTagSupport#toUserTag(String)}
   */
  @Test
  @DisplayName("Test toUserTag(String); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTagSupport.toUserTag(String)"})
  void testToUserTag_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", SymphonyTagSupport.toUserTag(null));
  }

  /**
   * Test {@link SymphonyTagSupport#format(Tag)}.
   *
   * <ul>
   *   <li>When {@link CashTag#CashTag(String)} with id is {@code 42}.
   *   <li>Then return {@code <cash tag="42" />}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SymphonyTagSupport#format(org.finos.springbot.workflow.content.Tag)}
   */
  @Test
  @DisplayName(
      "Test format(Tag); when CashTag(String) with id is '42'; then return '<cash tag=\"42\" />'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTagSupport.format(org.finos.springbot.workflow.content.Tag)"})
  void testFormat_whenCashTagWithIdIs42_thenReturnCashTag42() {
    // Arrange, Act and Assert
    assertEquals("<cash tag=\"42\" /> ", SymphonyTagSupport.format(new CashTag("42")));
  }

  /**
   * Test {@link SymphonyTagSupport#format(Tag)}.
   *
   * <ul>
   *   <li>When {@link CashTag#CashTag(String)} with id is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * SymphonyTagSupport#format(org.finos.springbot.workflow.content.Tag)}
   */
  @Test
  @DisplayName(
      "Test format(Tag); when CashTag(String) with id is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTagSupport.format(org.finos.springbot.workflow.content.Tag)"})
  void testFormat_whenCashTagWithIdIsEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", SymphonyTagSupport.format(new CashTag("")));
  }

  /**
   * Test {@link SymphonyTagSupport#format(Tag)}.
   *
   * <ul>
   *   <li>When {@link HashTag#HashTag(String)} with id is {@code 42}.
   *   <li>Then return {@code <hash tag="42" />}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SymphonyTagSupport#format(org.finos.springbot.workflow.content.Tag)}
   */
  @Test
  @DisplayName(
      "Test format(Tag); when HashTag(String) with id is '42'; then return '<hash tag=\"42\" />'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTagSupport.format(org.finos.springbot.workflow.content.Tag)"})
  void testFormat_whenHashTagWithIdIs42_thenReturnHashTag42() {
    // Arrange, Act and Assert
    assertEquals("<hash tag=\"42\" /> ", SymphonyTagSupport.format(new HashTag("42")));
  }

  /**
   * Test {@link SymphonyTagSupport#format(Tag)}.
   *
   * <ul>
   *   <li>When {@link HashTag#HashTag(String)} with id is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * SymphonyTagSupport#format(org.finos.springbot.workflow.content.Tag)}
   */
  @Test
  @DisplayName(
      "Test format(Tag); when HashTag(String) with id is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTagSupport.format(org.finos.springbot.workflow.content.Tag)"})
  void testFormat_whenHashTagWithIdIsEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", SymphonyTagSupport.format(new HashTag("")));
  }

  /**
   * Test {@link SymphonyTagSupport#format(Tag)}.
   *
   * <ul>
   *   <li>When {@link SymphonyUser#SymphonyUser(String, String)} with {@code Name} and emailAddress
   *       is {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SymphonyTagSupport#format(org.finos.springbot.workflow.content.Tag)}
   */
  @Test
  @DisplayName(
      "Test format(Tag); when SymphonyUser(String, String) with 'Name' and emailAddress is '42 Main St'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTagSupport.format(org.finos.springbot.workflow.content.Tag)"})
  void testFormat_whenSymphonyUserWithNameAndEmailAddressIs42MainSt() {
    // Arrange, Act and Assert
    assertEquals("", SymphonyTagSupport.format(new SymphonyUser("Name", "42 Main St")));
  }

  /**
   * Test {@link SymphonyTagSupport#format(Tag)}.
   *
   * <ul>
   *   <li>When {@link SymphonyUser#SymphonyUser(long)} with userId is one.
   *   <li>Then return {@code <mention uid="1" />}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SymphonyTagSupport#format(org.finos.springbot.workflow.content.Tag)}
   */
  @Test
  @DisplayName(
      "Test format(Tag); when SymphonyUser(long) with userId is one; then return '<mention uid=\"1\" />'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTagSupport.format(org.finos.springbot.workflow.content.Tag)"})
  void testFormat_whenSymphonyUserWithUserIdIsOne_thenReturnMentionUid1() {
    // Arrange, Act and Assert
    assertEquals("<mention uid=\"1\" />", SymphonyTagSupport.format(new SymphonyUser(1L)));
  }

  /**
   * Test {@link SymphonyTagSupport#classHashTags(Object)}.
   *
   * <ul>
   *   <li>When {@code In}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTagSupport#classHashTags(Object)}
   */
  @Test
  @DisplayName("Test classHashTags(Object); when 'In'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SymphonyTagSupport.classHashTags(Object)"})
  void testClassHashTags_whenIn() {
    // Arrange and Act
    Set<HashTag> actualClassHashTagsResult = SymphonyTagSupport.classHashTags("In");

    // Assert
    assertTrue(actualClassHashTagsResult.isEmpty());
  }

  /**
   * Test {@link SymphonyTagSupport#classHashTags(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTagSupport#classHashTags(Object)}
   */
  @Test
  @DisplayName("Test classHashTags(Object); when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SymphonyTagSupport.classHashTags(Object)"})
  void testClassHashTags_whenJavaLangObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    Set<HashTag> actualClassHashTagsResult = SymphonyTagSupport.classHashTags(forNameResult);

    // Assert
    assertTrue(actualClassHashTagsResult.isEmpty());
  }

  /**
   * Test {@link SymphonyTagSupport#classHashTags(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTagSupport#classHashTags(Object)}
   */
  @Test
  @DisplayName("Test classHashTags(Object); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SymphonyTagSupport.classHashTags(Object)"})
  void testClassHashTags_whenNull() {
    // Arrange and Act
    Set<HashTag> actualClassHashTagsResult = SymphonyTagSupport.classHashTags(null);

    // Assert
    assertTrue(actualClassHashTagsResult.isEmpty());
  }

  /**
   * Test {@link SymphonyTagSupport#toHashTags(Class)}.
   *
   * <p>Method under test: {@link SymphonyTagSupport#toHashTags(Class)}
   */
  @Test
  @DisplayName("Test toHashTags(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SymphonyTagSupport.toHashTags(Class)"})
  void testToHashTags() {
    // Arrange
    Class<Object> c = Object.class;

    // Act
    Set<HashTag> actualToHashTagsResult = SymphonyTagSupport.toHashTags(c);

    // Assert
    assertTrue(actualToHashTagsResult.isEmpty());
  }
}
