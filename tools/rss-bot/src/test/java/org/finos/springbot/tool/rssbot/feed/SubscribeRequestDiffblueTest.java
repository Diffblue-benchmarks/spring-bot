package org.finos.springbot.tool.rssbot.feed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SubscribeRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SubscribeRequest.<init>()", "String SubscribeRequest.getName()",
      "String SubscribeRequest.getUrl()", "void SubscribeRequest.setName(String)",
      "void SubscribeRequest.setUrl(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    SubscribeRequest actualSubscribeRequest = new SubscribeRequest();
    actualSubscribeRequest.setName("Name");
    actualSubscribeRequest.setUrl("https://example.org/example");
    String actualName = actualSubscribeRequest.getName();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("https://example.org/example", actualSubscribeRequest.getUrl());
  }
}
