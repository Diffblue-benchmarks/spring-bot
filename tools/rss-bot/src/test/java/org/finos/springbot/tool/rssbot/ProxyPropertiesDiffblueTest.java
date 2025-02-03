package org.finos.springbot.tool.rssbot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProxyPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.ProxyProperties.<init>()",
      "java.lang.String org.finos.springbot.tool.rssbot.ProxyProperties.getHost()",
      "java.lang.String org.finos.springbot.tool.rssbot.ProxyProperties.getPassword()",
      "int org.finos.springbot.tool.rssbot.ProxyProperties.getPort()",
      "java.lang.String org.finos.springbot.tool.rssbot.ProxyProperties.getUser()",
      "void org.finos.springbot.tool.rssbot.ProxyProperties.setHost(java.lang.String)",
      "void org.finos.springbot.tool.rssbot.ProxyProperties.setPassword(java.lang.String)",
      "void org.finos.springbot.tool.rssbot.ProxyProperties.setPort(int)",
      "void org.finos.springbot.tool.rssbot.ProxyProperties.setUser(java.lang.String)"})
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

    // Assert
    assertEquals("User", actualProxyProperties.getUser());
    assertEquals("iloveyou", actualPassword);
    assertEquals("localhost", actualHost);
    assertEquals(8080, actualPort);
  }
}
