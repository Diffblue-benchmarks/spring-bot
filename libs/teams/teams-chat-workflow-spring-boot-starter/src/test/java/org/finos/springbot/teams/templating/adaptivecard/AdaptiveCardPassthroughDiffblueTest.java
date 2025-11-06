package org.finos.springbot.teams.templating.adaptivecard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.finos.springbot.teams.content.TeamsChannel;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.Test;

class AdaptiveCardPassthroughDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AdaptiveCardPassthrough#AdaptiveCardPassthrough(JsonNode)}
   *   <li>{@link AdaptiveCardPassthrough#getJsonNode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    MissingNode jsonNode = MissingNode.getInstance();

    // Act and Assert
    assertSame(jsonNode, (new AdaptiveCardPassthrough(jsonNode)).getJsonNode());
  }

  /**
   * Method under test:
   * {@link AdaptiveCardPassthrough#isAdaptiveCard(WorkResponse)}
   */
  @Test
  void testIsAdaptiveCard() {
    // Arrange, Act and Assert
    assertFalse(
        AdaptiveCardPassthrough.isAdaptiveCard(new WorkResponse(new TeamsChannel("42", "Name"), "42", WorkMode.BOTH)));
  }
}
