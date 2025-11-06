package org.finos.springbot.teams.content.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.microsoft.bot.schema.Entity;
import java.util.Map;
import org.finos.springbot.teams.content.TeamsChannel;
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
  @Autowired
  private TeamsMarkupWriter teamsMarkupWriter;

  /**
   * Test {@link TeamsMarkupWriter#createEntity(Content)}.
   * <p>
   * Method under test: {@link TeamsMarkupWriter#createEntity(Content)}
   */
  @Test
  @DisplayName("Test createEntity(Content)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity TeamsMarkupWriter.createEntity(Content)"})
  void testCreateEntity() {
    // Arrange and Act
    Entity actualCreateEntityResult = teamsMarkupWriter.createEntity(new TeamsChannel("42", "Name"));

    // Assert
    Map<String, JsonNode> properties = actualCreateEntityResult.getProperties();
    assertEquals(2, properties.size());
    assertTrue(properties.get("mentioned") instanceof ObjectNode);
    assertTrue(properties.get("text") instanceof TextNode);
    assertEquals("mention", actualCreateEntityResult.getType());
  }
}
