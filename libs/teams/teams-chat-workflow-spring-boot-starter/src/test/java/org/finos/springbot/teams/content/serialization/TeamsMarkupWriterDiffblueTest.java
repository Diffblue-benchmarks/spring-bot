package org.finos.springbot.teams.content.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.microsoft.bot.schema.Entity;
import java.util.List;
import java.util.Map;
import org.finos.springbot.teams.content.TeamsChannel;
import org.finos.springbot.teams.content.serialization.TeamsMarkupWriter.EntityTagWriter;
import org.finos.springbot.teams.response.templating.MarkupAndEntities;
import org.finos.springbot.workflow.content.Content;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TeamsMarkupWriter.class})
@ExtendWith(SpringExtension.class)
class TeamsMarkupWriterDiffblueTest {
  @Autowired private TeamsMarkupWriter teamsMarkupWriter;

  /**
   * Test {@link TeamsMarkupWriter#createEntity(Content)}.
   *
   * <p>Method under test: {@link TeamsMarkupWriter#createEntity(Content)}
   */
  @Test
  @DisplayName("Test createEntity(Content)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity TeamsMarkupWriter.createEntity(Content)"})
  void testCreateEntity() {
    // Arrange and Act
    Entity actualCreateEntityResult =
        teamsMarkupWriter.createEntity(new TeamsChannel("42", "Name"));

    // Assert
    Map<String, JsonNode> properties = actualCreateEntityResult.getProperties();
    assertEquals(2, properties.size());
    assertTrue(properties.get("mentioned") instanceof ObjectNode);
    assertTrue(properties.get("text") instanceof TextNode);
    assertEquals("mention", actualCreateEntityResult.getType());
  }

  /**
   * Test EntityTagWriter {@link EntityTagWriter#apply(Content, MarkupAndEntities)} with {@code
   * Content}, {@code MarkupAndEntities}.
   *
   * <p>Method under test: {@link EntityTagWriter#apply(Content, MarkupAndEntities)}
   */
  @Test
  @DisplayName(
      "Test EntityTagWriter apply(Content, MarkupAndEntities) with 'Content', 'MarkupAndEntities'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityTagWriter.apply(Content, MarkupAndEntities)"})
  void testEntityTagWriterApplyWithContentMarkupAndEntities() {
    // Arrange
    EntityTagWriter entityTagWriter = new TeamsMarkupWriter().new EntityTagWriter("Tag");
    TeamsChannel t = new TeamsChannel("42", "Name");
    MarkupAndEntities c = new MarkupAndEntities("Not all who wander are lost");

    // Act
    String actualApplyResult = entityTagWriter.apply(t, c);

    // Assert
    List<Entity> entities = c.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    Map<String, JsonNode> properties = getResult.getProperties();
    assertEquals(2, properties.size());
    assertTrue(properties.get("mentioned") instanceof ObjectNode);
    assertTrue(properties.get("text") instanceof TextNode);
    assertEquals("<Tag>Name</Tag>", actualApplyResult);
    assertEquals("mention", getResult.getType());
  }

  /**
   * Test EntityTagWriter {@link EntityTagWriter#getContainedMarkup(Content)}.
   *
   * <p>Method under test: {@link EntityTagWriter#getContainedMarkup(Content)}
   */
  @Test
  @DisplayName("Test EntityTagWriter getContainedMarkup(Content)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityTagWriter.getContainedMarkup(Content)"})
  void testEntityTagWriterGetContainedMarkup() {
    // Arrange
    EntityTagWriter entityTagWriter = new TeamsMarkupWriter().new EntityTagWriter("Tag");

    // Act
    String actualContainedMarkup =
        entityTagWriter.getContainedMarkup(new TeamsChannel("42", "Name"));

    // Assert
    assertEquals("Name", actualContainedMarkup);
  }
}
