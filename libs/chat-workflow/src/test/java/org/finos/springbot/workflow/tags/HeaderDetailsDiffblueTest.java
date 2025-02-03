package org.finos.springbot.workflow.tags;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.finos.springbot.workflow.tags.HeaderDetails.LegacyHeaderDeserialize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HeaderDetailsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HeaderDetails#HeaderDetails()}
   *   <li>{@link HeaderDetails#setDescription(String)}
   *   <li>{@link HeaderDetails#setName(String)}
   *   <li>{@link HeaderDetails#setTags(List)}
   *   <li>{@link HeaderDetails#getDescription()}
   *   <li>{@link HeaderDetails#getName()}
   *   <li>{@link HeaderDetails#getTags()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.tags.HeaderDetails.<init>()",
      "void org.finos.springbot.workflow.tags.HeaderDetails.<init>(java.lang.String, java.lang.String, java.util.List)",
      "void org.finos.springbot.workflow.tags.HeaderDetails.<init>(java.util.List)",
      "java.lang.String org.finos.springbot.workflow.tags.HeaderDetails.getDescription()",
      "java.lang.String org.finos.springbot.workflow.tags.HeaderDetails.getName()",
      "java.util.List org.finos.springbot.workflow.tags.HeaderDetails.getTags()",
      "void org.finos.springbot.workflow.tags.HeaderDetails.setDescription(java.lang.String)",
      "void org.finos.springbot.workflow.tags.HeaderDetails.setName(java.lang.String)",
      "void org.finos.springbot.workflow.tags.HeaderDetails.setTags(java.util.List)"})
  void testGettersAndSetters() {
    // Arrange and Act
    HeaderDetails actualHeaderDetails = new HeaderDetails();
    actualHeaderDetails.setDescription("The characteristics of someone or something");
    actualHeaderDetails.setName("Name");
    ArrayList<String> tags = new ArrayList<>();
    actualHeaderDetails.setTags(tags);
    String actualDescription = actualHeaderDetails.getDescription();
    String actualName = actualHeaderDetails.getName();
    List<String> actualTags = actualHeaderDetails.getTags();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertTrue(actualTags.isEmpty());
    assertSame(tags, actualTags);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HeaderDetails#HeaderDetails(List)}
   *   <li>{@link HeaderDetails#setDescription(String)}
   *   <li>{@link HeaderDetails#setName(String)}
   *   <li>{@link HeaderDetails#setTags(List)}
   *   <li>{@link HeaderDetails#getDescription()}
   *   <li>{@link HeaderDetails#getName()}
   *   <li>{@link HeaderDetails#getTags()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.tags.HeaderDetails.<init>()",
      "void org.finos.springbot.workflow.tags.HeaderDetails.<init>(java.lang.String, java.lang.String, java.util.List)",
      "void org.finos.springbot.workflow.tags.HeaderDetails.<init>(java.util.List)",
      "java.lang.String org.finos.springbot.workflow.tags.HeaderDetails.getDescription()",
      "java.lang.String org.finos.springbot.workflow.tags.HeaderDetails.getName()",
      "java.util.List org.finos.springbot.workflow.tags.HeaderDetails.getTags()",
      "void org.finos.springbot.workflow.tags.HeaderDetails.setDescription(java.lang.String)",
      "void org.finos.springbot.workflow.tags.HeaderDetails.setName(java.lang.String)",
      "void org.finos.springbot.workflow.tags.HeaderDetails.setTags(java.util.List)"})
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    HeaderDetails actualHeaderDetails = new HeaderDetails(new ArrayList<>());
    actualHeaderDetails.setDescription("The characteristics of someone or something");
    actualHeaderDetails.setName("Name");
    ArrayList<String> tags = new ArrayList<>();
    actualHeaderDetails.setTags(tags);
    String actualDescription = actualHeaderDetails.getDescription();
    String actualName = actualHeaderDetails.getName();
    List<String> actualTags = actualHeaderDetails.getTags();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertTrue(actualTags.isEmpty());
    assertSame(tags, actualTags);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HeaderDetails#HeaderDetails(String, String, List)}
   *   <li>{@link HeaderDetails#setDescription(String)}
   *   <li>{@link HeaderDetails#setName(String)}
   *   <li>{@link HeaderDetails#setTags(List)}
   *   <li>{@link HeaderDetails#getDescription()}
   *   <li>{@link HeaderDetails#getName()}
   *   <li>{@link HeaderDetails#getTags()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.tags.HeaderDetails.<init>()",
      "void org.finos.springbot.workflow.tags.HeaderDetails.<init>(java.lang.String, java.lang.String, java.util.List)",
      "void org.finos.springbot.workflow.tags.HeaderDetails.<init>(java.util.List)",
      "java.lang.String org.finos.springbot.workflow.tags.HeaderDetails.getDescription()",
      "java.lang.String org.finos.springbot.workflow.tags.HeaderDetails.getName()",
      "java.util.List org.finos.springbot.workflow.tags.HeaderDetails.getTags()",
      "void org.finos.springbot.workflow.tags.HeaderDetails.setDescription(java.lang.String)",
      "void org.finos.springbot.workflow.tags.HeaderDetails.setName(java.lang.String)",
      "void org.finos.springbot.workflow.tags.HeaderDetails.setTags(java.util.List)"})
  void testGettersAndSetters_whenName() {
    // Arrange and Act
    HeaderDetails actualHeaderDetails = new HeaderDetails("Name", "The characteristics of someone or something",
        new ArrayList<>());
    actualHeaderDetails.setDescription("The characteristics of someone or something");
    actualHeaderDetails.setName("Name");
    ArrayList<String> tags = new ArrayList<>();
    actualHeaderDetails.setTags(tags);
    String actualDescription = actualHeaderDetails.getDescription();
    String actualName = actualHeaderDetails.getName();
    List<String> actualTags = actualHeaderDetails.getTags();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertTrue(actualTags.isEmpty());
    assertSame(tags, actualTags);
  }

  /**
   * Test LegacyHeaderDeserialize {@link LegacyHeaderDeserialize#convert(Object)}.
   * <ul>
   *   <li>Given {@code name}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code name} is {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyHeaderDeserialize#convert(Object)}
   */
  @Test
  @DisplayName("Test LegacyHeaderDeserialize convert(Object); given 'name'; when HashMap() 'name' is 'foo'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.tags.HeaderDetails$LegacyHeaderDeserialize.convert(java.lang.Object)"})
  void testLegacyHeaderDeserializeConvert_givenName_whenHashMapNameIsFoo_thenReturnFoo() {
    // Arrange
    LegacyHeaderDeserialize legacyHeaderDeserialize = new LegacyHeaderDeserialize();

    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("name", "foo");

    // Act and Assert
    assertEquals("foo", legacyHeaderDeserialize.convert(objectObjectMap));
  }

  /**
   * Test LegacyHeaderDeserialize {@link LegacyHeaderDeserialize#convert(Object)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyHeaderDeserialize#convert(Object)}
   */
  @Test
  @DisplayName("Test LegacyHeaderDeserialize convert(Object); when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.tags.HeaderDetails$LegacyHeaderDeserialize.convert(java.lang.Object)"})
  void testLegacyHeaderDeserializeConvert_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new LegacyHeaderDeserialize()).convert("42"));
  }

  /**
   * Test LegacyHeaderDeserialize {@link LegacyHeaderDeserialize#convert(Object)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyHeaderDeserialize#convert(Object)}
   */
  @Test
  @DisplayName("Test LegacyHeaderDeserialize convert(Object); when two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.tags.HeaderDetails$LegacyHeaderDeserialize.convert(java.lang.Object)"})
  void testLegacyHeaderDeserializeConvert_whenTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new LegacyHeaderDeserialize()).convert(2));
  }
}
