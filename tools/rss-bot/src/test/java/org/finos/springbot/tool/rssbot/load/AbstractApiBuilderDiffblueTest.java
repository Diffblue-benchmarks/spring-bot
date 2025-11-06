package org.finos.springbot.tool.rssbot.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractApiBuilderDiffblueTest {
  /**
   * Test {@link AbstractApiBuilder#setProxyDetails(String, String, String, int)}.
   * <p>
   * Method under test: {@link AbstractApiBuilder#setProxyDetails(String, String, String, int)}
   */
  @Test
  @DisplayName("Test setProxyDetails(String, String, String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractApiBuilder.setProxyDetails(String, String, String, int)"})
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
   * Test {@link AbstractApiBuilder#getTrustManagers()}.
   * <p>
   * Method under test: {@link AbstractApiBuilder#getTrustManagers()}
   */
  @Test
  @DisplayName("Test getTrustManagers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TrustManager[] AbstractApiBuilder.getTrustManagers()"})
  void testGetTrustManagers() {
    // Arrange, Act and Assert
    assertNull((new JerseyApiBuilder("https://example.org/example")).getTrustManagers());
  }

  /**
   * Test {@link AbstractApiBuilder#setTrustManagers(TrustManager[])}.
   * <p>
   * Method under test: {@link AbstractApiBuilder#setTrustManagers(TrustManager[])}
   */
  @Test
  @DisplayName("Test setTrustManagers(TrustManager[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractApiBuilder.setTrustManagers(TrustManager[])"})
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
   * Test {@link AbstractApiBuilder#getKeyManagers()}.
   * <p>
   * Method under test: {@link AbstractApiBuilder#getKeyManagers()}
   */
  @Test
  @DisplayName("Test getKeyManagers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyManager[] AbstractApiBuilder.getKeyManagers()"})
  void testGetKeyManagers() {
    // Arrange, Act and Assert
    assertNull((new JerseyApiBuilder("https://example.org/example")).getKeyManagers());
  }

  /**
   * Test {@link AbstractApiBuilder#setKeyManagers(KeyManager[])}.
   * <p>
   * Method under test: {@link AbstractApiBuilder#setKeyManagers(KeyManager[])}
   */
  @Test
  @DisplayName("Test setKeyManagers(KeyManager[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractApiBuilder.setKeyManagers(KeyManager[])"})
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
   * Test {@link AbstractApiBuilder#setConnectTimeout(long)}.
   * <p>
   * Method under test: {@link AbstractApiBuilder#setConnectTimeout(long)}
   */
  @Test
  @DisplayName("Test setConnectTimeout(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractApiBuilder.setConnectTimeout(long)"})
  void testSetConnectTimeout() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");

    // Act
    jerseyApiBuilder.setConnectTimeout(1L);

    // Assert
    assertEquals(1L, jerseyApiBuilder.connectTimeout.longValue());
  }
}
