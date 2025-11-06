package org.finos.springbot.teams.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.content.TeamsChannel;
import org.junit.jupiter.api.Test;

class TeamsResponseHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}
   */
  @Test
  void testCreateStorageTags() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();

    // Act
    Map<String, String> actualCreateStorageTagsResult = TeamsResponseHandler.createStorageTags(data,
        new TeamsChannel("42", "Name"));

    // Assert
    assertEquals(2, actualCreateStorageTagsResult.size());
    assertEquals("42", actualCreateStorageTagsResult.get("addressable"));
  }
}
