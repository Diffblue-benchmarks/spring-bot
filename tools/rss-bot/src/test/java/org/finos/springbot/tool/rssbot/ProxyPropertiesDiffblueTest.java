package org.finos.springbot.tool.rssbot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ProxyPropertiesDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ProxyProperties}
   *   <li>{@link ProxyProperties#setHost(String)}
   *   <li>{@link ProxyProperties#setPassword(String)}
   *   <li>{@link ProxyProperties#setPort(int)}
   *   <li>{@link ProxyProperties#setUser(String)}
   *   <li>{@link ProxyProperties#getHost()}
   *   <li>{@link ProxyProperties#getPassword()}
   *   <li>{@link ProxyProperties#getPort()}
   *   <li>{@link ProxyProperties#getUser()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ProxyProperties actualProxyProperties = new ProxyProperties();
    actualProxyProperties.setHost("localhost");
    actualProxyProperties.setPassword("iloveyou");
    actualProxyProperties.setPort(8080);
    actualProxyProperties.setUser("User");
    String actualHost = actualProxyProperties.getHost();
    String actualPassword = actualProxyProperties.getPassword();
    int actualPort = actualProxyProperties.getPort();

    // Assert that nothing has changed
    assertEquals("User", actualProxyProperties.getUser());
    assertEquals("iloveyou", actualPassword);
    assertEquals("localhost", actualHost);
    assertEquals(8080, actualPort);
  }
}
