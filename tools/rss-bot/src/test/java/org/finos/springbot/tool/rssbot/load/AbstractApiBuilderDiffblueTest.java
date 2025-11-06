package org.finos.springbot.tool.rssbot.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import org.junit.jupiter.api.Test;

class AbstractApiBuilderDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractApiBuilder#setProxyDetails(String, String, String, int)}
   */
  @Test
  void testSetProxyDetails() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");

    // Act
    jerseyApiBuilder.setProxyDetails("localhost", "User", "iloveyou", 8080);

    // Assert
    assertEquals("User", jerseyApiBuilder.user);
    assertEquals("iloveyou", jerseyApiBuilder.password);
    assertEquals("localhost", jerseyApiBuilder.proxyHost);
    assertEquals(8080, jerseyApiBuilder.port);
  }

  /**
   * Method under test: {@link AbstractApiBuilder#getTrustManagers()}
   */
  @Test
  void testGetTrustManagers() {
    // Arrange, Act and Assert
    assertNull((new JerseyApiBuilder("https://example.org/example")).getTrustManagers());
  }

  /**
   * Method under test:
   * {@link AbstractApiBuilder#setTrustManagers(TrustManager[])}
   */
  @Test
  void testSetTrustManagers() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");
    TrustManager[] trustManagers = new TrustManager[]{null};

    // Act
    jerseyApiBuilder.setTrustManagers(trustManagers);

    // Assert
    assertSame(trustManagers, jerseyApiBuilder.getTrustManagers());
  }

  /**
   * Method under test: {@link AbstractApiBuilder#getKeyManagers()}
   */
  @Test
  void testGetKeyManagers() {
    // Arrange, Act and Assert
    assertNull((new JerseyApiBuilder("https://example.org/example")).getKeyManagers());
  }

  /**
   * Method under test: {@link AbstractApiBuilder#setKeyManagers(KeyManager[])}
   */
  @Test
  void testSetKeyManagers() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");
    KeyManager[] keyManagers = new KeyManager[]{null};

    // Act
    jerseyApiBuilder.setKeyManagers(keyManagers);

    // Assert
    assertSame(keyManagers, jerseyApiBuilder.getKeyManagers());
  }

  /**
   * Method under test: {@link AbstractApiBuilder#setConnectTimeout(long)}
   */
  @Test
  void testSetConnectTimeout() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");

    // Act
    jerseyApiBuilder.setConnectTimeout(1L);

    // Assert
    assertEquals(1L, jerseyApiBuilder.connectTimeout.longValue());
  }
}
