package org.finos.springbot.tool.rssbot.feed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SubscribeRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SubscribeRequest}
   *   <li>{@link SubscribeRequest#setName(String)}
   *   <li>{@link SubscribeRequest#setUrl(String)}
   *   <li>{@link SubscribeRequest#getName()}
   *   <li>{@link SubscribeRequest#getUrl()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SubscribeRequest actualSubscribeRequest = new SubscribeRequest();
    actualSubscribeRequest.setName("Name");
    actualSubscribeRequest.setUrl("https://example.org/example");
    String actualName = actualSubscribeRequest.getName();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("https://example.org/example", actualSubscribeRequest.getUrl());
  }
}
