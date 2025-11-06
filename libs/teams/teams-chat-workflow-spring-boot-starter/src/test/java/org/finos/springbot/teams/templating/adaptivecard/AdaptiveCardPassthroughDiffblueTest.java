package org.finos.springbot.teams.templating.adaptivecard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AdaptiveCardPassthroughDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdaptiveCardPassthrough#AdaptiveCardPassthrough(JsonNode)}
   *   <li>{@link AdaptiveCardPassthrough#getJsonNode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdaptiveCardPassthrough.<init>(JsonNode)", "JsonNode AdaptiveCardPassthrough.getJsonNode()"})
  void testGettersAndSetters() {
    // Arrange
    MissingNode jsonNode = MissingNode.getInstance();

    // Act and Assert
    assertSame(jsonNode, (new AdaptiveCardPassthrough(jsonNode)).getJsonNode());
  }

  /**
   * Test {@link AdaptiveCardPassthrough#isAdaptiveCard(WorkResponse)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdaptiveCardPassthrough#isAdaptiveCard(WorkResponse)}
   */
  @Test
  @DisplayName("Test isAdaptiveCard(WorkResponse); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AdaptiveCardPassthrough.isAdaptiveCard(WorkResponse)"})
  void testIsAdaptiveCard_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AdaptiveCardPassthrough.isAdaptiveCard(new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH)));
  }
}
