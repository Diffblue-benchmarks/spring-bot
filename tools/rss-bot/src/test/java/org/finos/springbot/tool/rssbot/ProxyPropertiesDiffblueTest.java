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
  @MethodsUnderTest({"void ProxyProperties.<init>()", "String ProxyProperties.getHost()",
      "String ProxyProperties.getPassword()", "int ProxyProperties.getPort()", "String ProxyProperties.getUser()",
      "void ProxyProperties.setHost(String)", "void ProxyProperties.setPassword(String)",
      "void ProxyProperties.setPort(int)", "void ProxyProperties.setUser(String)"})
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
