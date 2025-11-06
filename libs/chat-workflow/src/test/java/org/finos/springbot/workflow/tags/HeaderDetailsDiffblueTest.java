package org.finos.springbot.workflow.tags;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

class HeaderDetailsDiffblueTest {
  /**
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

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertTrue(actualTags.isEmpty());
    assertSame(tags, actualTags);
  }

  /**
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
  void testGettersAndSetters2() {
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

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertTrue(actualTags.isEmpty());
    assertSame(tags, actualTags);
  }

  /**
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
  void testGettersAndSetters3() {
    // Arrange and Act
    HeaderDetails actualHeaderDetails = new HeaderDetails(new ArrayList<>());
    actualHeaderDetails.setDescription("The characteristics of someone or something");
    actualHeaderDetails.setName("Name");
    ArrayList<String> tags = new ArrayList<>();
    actualHeaderDetails.setTags(tags);
    String actualDescription = actualHeaderDetails.getDescription();
    String actualName = actualHeaderDetails.getName();
    List<String> actualTags = actualHeaderDetails.getTags();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertTrue(actualTags.isEmpty());
    assertSame(tags, actualTags);
  }

  /**
   * Method under test:
   * {@link HeaderDetails.LegacyHeaderDeserialize#convert(Object)}
   */
  @Test
  void testLegacyHeaderDeserializeConvert() {
    // Arrange, Act and Assert
    assertEquals("42", (new HeaderDetails.LegacyHeaderDeserialize()).convert("42"));
    assertNull((new HeaderDetails.LegacyHeaderDeserialize()).convert(2));
  }

  /**
   * Method under test:
   * {@link HeaderDetails.LegacyHeaderDeserialize#convert(Object)}
   */
  @Test
  void testLegacyHeaderDeserializeConvert2() {
    // Arrange
    HeaderDetails.LegacyHeaderDeserialize legacyHeaderDeserialize = new HeaderDetails.LegacyHeaderDeserialize();

    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("name", "foo");

    // Act and Assert
    assertEquals("foo", legacyHeaderDeserialize.convert(objectObjectMap));
  }
}
