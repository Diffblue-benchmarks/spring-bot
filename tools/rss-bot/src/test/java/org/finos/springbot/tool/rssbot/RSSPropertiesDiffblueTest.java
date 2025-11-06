package org.finos.springbot.tool.rssbot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RSSPropertiesDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RSSProperties}
   *   <li>{@link RSSProperties#setFailureMessage(String)}
   *   <li>{@link RSSProperties#setObservationStreamId(String)}
   *   <li>{@link RSSProperties#setProxies(List)}
   *   <li>{@link RSSProperties#setProxy(List)}
   *   <li>{@link RSSProperties#setSuccessMessage(String)}
   *   <li>{@link RSSProperties#getFailureMessage()}
   *   <li>{@link RSSProperties#getObservationStreamId()}
   *   <li>{@link RSSProperties#getProxies()}
   *   <li>{@link RSSProperties#getSuccessMessage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RSSProperties actualRssProperties = new RSSProperties();
    actualRssProperties.setFailureMessage("Failure Message");
    actualRssProperties.setObservationStreamId("Observation Stream");
    actualRssProperties.setProxies(new ArrayList<>());
    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    actualRssProperties.setProxy(proxy);
    actualRssProperties.setSuccessMessage("Success Message");
    String actualFailureMessage = actualRssProperties.getFailureMessage();
    String actualObservationStreamId = actualRssProperties.getObservationStreamId();
    List<ProxyProperties> actualProxies = actualRssProperties.getProxies();

    // Assert that nothing has changed
    assertEquals("Failure Message", actualFailureMessage);
    assertEquals("Observation Stream", actualObservationStreamId);
    assertEquals("Success Message", actualRssProperties.getSuccessMessage());
    assertTrue(actualProxies.isEmpty());
    assertSame(proxy, actualProxies);
  }
}
