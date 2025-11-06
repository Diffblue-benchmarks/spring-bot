package org.finos.springbot.tool.rssbot.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.ws.rs.RuntimeType;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.UriBuilder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Map;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyWebTarget;
import org.glassfish.jersey.uri.internal.JerseyUriBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JerseyApiBuilderDiffblueTest {
  /**
   * Test {@link JerseyApiBuilder#JerseyApiBuilder(String, KeyManager[])}.
   * <ul>
   *   <li>Then return first element is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JerseyApiBuilder#JerseyApiBuilder(String, KeyManager[])}
   */
  @Test
  @DisplayName("Test new JerseyApiBuilder(String, KeyManager[]); then return first element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JerseyApiBuilder.<init>()", "void JerseyApiBuilder.<init>(String)",
      "void JerseyApiBuilder.<init>(String, KeyManager[])"})
  void testNewJerseyApiBuilder_thenReturnFirstElementIsNull() {
    // Arrange
    KeyManager[] keyManagers = new KeyManager[]{null};

    // Act
    JerseyApiBuilder actualJerseyApiBuilder = new JerseyApiBuilder("https://example.org/example", keyManagers);

    // Assert
    assertNull(actualJerseyApiBuilder.getTrustManagers());
    KeyManager[] keyManagers2 = actualJerseyApiBuilder.getKeyManagers();
    assertNull(keyManagers2[0]);
    assertEquals(1, keyManagers2.length);
    assertSame(keyManagers, keyManagers2);
  }

  /**
   * Test {@link JerseyApiBuilder#JerseyApiBuilder()}.
   * <ul>
   *   <li>Then return KeyManagers is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JerseyApiBuilder#JerseyApiBuilder()}
   */
  @Test
  @DisplayName("Test new JerseyApiBuilder(); then return KeyManagers is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JerseyApiBuilder.<init>()", "void JerseyApiBuilder.<init>(String)",
      "void JerseyApiBuilder.<init>(String, KeyManager[])"})
  void testNewJerseyApiBuilder_thenReturnKeyManagersIsNull() {
    // Arrange and Act
    JerseyApiBuilder actualJerseyApiBuilder = new JerseyApiBuilder();

    // Assert
    assertNull(actualJerseyApiBuilder.getKeyManagers());
    assertNull(actualJerseyApiBuilder.getTrustManagers());
  }

  /**
   * Test {@link JerseyApiBuilder#JerseyApiBuilder(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return KeyManagers is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JerseyApiBuilder#JerseyApiBuilder(String)}
   */
  @Test
  @DisplayName("Test new JerseyApiBuilder(String); when 'https://example.org/example'; then return KeyManagers is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JerseyApiBuilder.<init>()", "void JerseyApiBuilder.<init>(String)",
      "void JerseyApiBuilder.<init>(String, KeyManager[])"})
  void testNewJerseyApiBuilder_whenHttpsExampleOrgExample_thenReturnKeyManagersIsNull() {
    // Arrange and Act
    JerseyApiBuilder actualJerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");

    // Assert
    assertNull(actualJerseyApiBuilder.getKeyManagers());
    assertNull(actualJerseyApiBuilder.getTrustManagers());
  }

  /**
   * Test {@link JerseyApiBuilder#newWebTarget()}.
   * <p>
   * Method under test: {@link JerseyApiBuilder#newWebTarget()}
   */
  @Test
  @DisplayName("Test newWebTarget()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WebTarget JerseyApiBuilder.newWebTarget()"})
  void testNewWebTarget() {
    // Arrange and Act
    WebTarget actualNewWebTargetResult = (new JerseyApiBuilder("https://example.org/example")).newWebTarget();

    // Assert
    Configuration configuration = actualNewWebTargetResult.getConfiguration();
    assertTrue(((ClientConfig) configuration).getConnectorProvider() instanceof HttpUrlConnectorProvider);
    assertTrue(actualNewWebTargetResult instanceof JerseyWebTarget);
    UriBuilder uriBuilder = actualNewWebTargetResult.getUriBuilder();
    assertTrue(uriBuilder instanceof JerseyUriBuilder);
    assertEquals("https://example.org/example", actualNewWebTargetResult.getUri().toString());
    assertNull(((ClientConfig) configuration).getExecutorService());
    assertNull(((ClientConfig) configuration).getScheduledExecutorService());
    assertEquals(1, configuration.getClasses().size());
    assertEquals(RuntimeType.CLIENT, configuration.getRuntimeType());
    assertTrue(configuration.getPropertyNames().isEmpty());
    assertTrue(configuration.getProperties().isEmpty());
    assertTrue(configuration.getInstances().isEmpty());
    assertTrue(((JerseyUriBuilder) uriBuilder).isAbsolute());
  }

  /**
   * Test {@link JerseyApiBuilder#newWebTarget(String)} with {@code String}.
   * <p>
   * Method under test: {@link JerseyApiBuilder#newWebTarget(String)}
   */
  @Test
  @DisplayName("Test newWebTarget(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WebTarget JerseyApiBuilder.newWebTarget(String)"})
  void testNewWebTargetWithString() {
    // Arrange and Act
    WebTarget actualNewWebTargetResult = (new JerseyApiBuilder("https://example.org/example"))
        .newWebTarget("https://example.org/example");

    // Assert
    Configuration configuration = actualNewWebTargetResult.getConfiguration();
    assertTrue(((ClientConfig) configuration).getConnectorProvider() instanceof HttpUrlConnectorProvider);
    assertTrue(actualNewWebTargetResult instanceof JerseyWebTarget);
    UriBuilder uriBuilder = actualNewWebTargetResult.getUriBuilder();
    assertTrue(uriBuilder instanceof JerseyUriBuilder);
    assertEquals("https://example.org/example", actualNewWebTargetResult.getUri().toString());
    assertNull(((ClientConfig) configuration).getExecutorService());
    assertNull(((ClientConfig) configuration).getScheduledExecutorService());
    assertEquals(1, configuration.getClasses().size());
    assertEquals(RuntimeType.CLIENT, configuration.getRuntimeType());
    assertTrue(configuration.getPropertyNames().isEmpty());
    assertTrue(configuration.getProperties().isEmpty());
    assertTrue(configuration.getInstances().isEmpty());
    assertTrue(((JerseyUriBuilder) uriBuilder).isAbsolute());
  }

  /**
   * Test {@link JerseyApiBuilder#newWebTarget(String)} with {@code String}.
   * <ul>
   *   <li>Then return Configuration Properties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JerseyApiBuilder#newWebTarget(String)}
   */
  @Test
  @DisplayName("Test newWebTarget(String) with 'String'; then return Configuration Properties size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WebTarget JerseyApiBuilder.newWebTarget(String)"})
  void testNewWebTargetWithString_thenReturnConfigurationPropertiesSizeIsOne() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");
    jerseyApiBuilder.setConnectTimeout(1L);

    // Act
    WebTarget actualNewWebTargetResult = jerseyApiBuilder.newWebTarget("https://example.org/example");

    // Assert
    assertTrue(actualNewWebTargetResult instanceof JerseyWebTarget);
    Configuration configuration = actualNewWebTargetResult.getConfiguration();
    Map<String, Object> properties = configuration.getProperties();
    assertEquals(1, properties.size());
    assertEquals(1, ((Integer) properties.get("jersey.config.client.connectTimeout")).intValue());
    assertEquals(1, configuration.getPropertyNames().size());
  }

  /**
   * Test {@link JerseyApiBuilder#newWebTarget()}.
   * <ul>
   *   <li>Then return Configuration Properties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JerseyApiBuilder#newWebTarget()}
   */
  @Test
  @DisplayName("Test newWebTarget(); then return Configuration Properties size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WebTarget JerseyApiBuilder.newWebTarget()"})
  void testNewWebTarget_thenReturnConfigurationPropertiesSizeIsOne() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");
    jerseyApiBuilder.setConnectTimeout(1L);

    // Act
    WebTarget actualNewWebTargetResult = jerseyApiBuilder.newWebTarget();

    // Assert
    assertTrue(actualNewWebTargetResult instanceof JerseyWebTarget);
    Configuration configuration = actualNewWebTargetResult.getConfiguration();
    Map<String, Object> properties = configuration.getProperties();
    assertEquals(1, properties.size());
    assertEquals(1, ((Integer) properties.get("jersey.config.client.connectTimeout")).intValue());
    assertEquals(1, configuration.getPropertyNames().size());
  }

  /**
   * Test {@link JerseyApiBuilder#registerFeatures(JerseyClientBuilder)}.
   * <ul>
   *   <li>Then {@link JerseyClientBuilder} (default constructor) Configuration Classes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JerseyApiBuilder#registerFeatures(JerseyClientBuilder)}
   */
  @Test
  @DisplayName("Test registerFeatures(JerseyClientBuilder); then JerseyClientBuilder (default constructor) Configuration Classes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JerseyApiBuilder.registerFeatures(JerseyClientBuilder)"})
  void testRegisterFeatures_thenJerseyClientBuilderConfigurationClassesSizeIsOne() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");
    JerseyClientBuilder jcb = new JerseyClientBuilder();

    // Act
    jerseyApiBuilder.registerFeatures(jcb);

    // Assert
    assertEquals(1, jcb.getConfiguration().getClasses().size());
  }

  /**
   * Test {@link JerseyApiBuilder#createSSLContext()}.
   * <p>
   * Method under test: {@link JerseyApiBuilder#createSSLContext()}
   */
  @Test
  @DisplayName("Test createSSLContext()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SSLContext JerseyApiBuilder.createSSLContext()"})
  void testCreateSSLContext() throws KeyManagementException, NoSuchAlgorithmException {
    // Arrange and Act
    SSLContext actualCreateSSLContextResult = (new JerseyApiBuilder("https://example.org/example")).createSSLContext();

    // Assert
    assertEquals("TLSv1.2", actualCreateSSLContextResult.getProtocol());
    Provider provider = actualCreateSSLContextResult.getProvider();
    assertEquals(25, provider.size());
    assertTrue(provider.containsKey("Alg.Alias.SSLContext.SSL"));
    assertTrue(provider.containsKey("Alg.Alias.SSLContext.SSLv3"));
    assertTrue(provider.containsKey("Alg.Alias.TrustManagerFactory.X.509"));
    assertTrue(provider.containsKey("KeyManagerFactory.NewSunX509"));
    assertTrue(provider.containsKey("Provider.id version"));
    assertTrue(provider.containsKey("SSLContext.DTLS"));
  }

  /**
   * Test {@link JerseyApiBuilder#createConfig()}.
   * <ul>
   *   <li>Then ConnectorProvider return {@link HttpUrlConnectorProvider}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JerseyApiBuilder#createConfig()}
   */
  @Test
  @DisplayName("Test createConfig(); then ConnectorProvider return HttpUrlConnectorProvider")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClientConfig JerseyApiBuilder.createConfig()"})
  void testCreateConfig_thenConnectorProviderReturnHttpUrlConnectorProvider() {
    // Arrange and Act
    ClientConfig actualCreateConfigResult = (new JerseyApiBuilder("https://example.org/example")).createConfig();

    // Assert
    assertTrue(actualCreateConfigResult.getConnectorProvider() instanceof HttpUrlConnectorProvider);
    assertNull(actualCreateConfigResult.getExecutorService());
    assertNull(actualCreateConfigResult.getScheduledExecutorService());
    assertNull(actualCreateConfigResult.getClient());
    assertNull(actualCreateConfigResult.getConnector());
    assertEquals(RuntimeType.CLIENT, actualCreateConfigResult.getRuntimeType());
    assertTrue(actualCreateConfigResult.getPropertyNames().isEmpty());
    assertTrue(actualCreateConfigResult.getProperties().isEmpty());
    assertTrue(actualCreateConfigResult.getClasses().isEmpty());
    assertTrue(actualCreateConfigResult.getInstances().isEmpty());
  }

  /**
   * Test {@link JerseyApiBuilder#createConfig()}.
   * <ul>
   *   <li>Then return Properties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JerseyApiBuilder#createConfig()}
   */
  @Test
  @DisplayName("Test createConfig(); then return Properties size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClientConfig JerseyApiBuilder.createConfig()"})
  void testCreateConfig_thenReturnPropertiesSizeIsOne() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");
    jerseyApiBuilder.setConnectTimeout(1L);

    // Act
    ClientConfig actualCreateConfigResult = jerseyApiBuilder.createConfig();

    // Assert
    Map<String, Object> properties = actualCreateConfigResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(1, ((Integer) properties.get("jersey.config.client.connectTimeout")).intValue());
    assertEquals(1, actualCreateConfigResult.getPropertyNames().size());
  }

  /**
   * Test {@link JerseyApiBuilder#testConnection(String)}.
   * <p>
   * Method under test: {@link JerseyApiBuilder#testConnection(String)}
   */
  @Test
  @DisplayName("Test testConnection(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JerseyApiBuilder.testConnection(String)"})
  void testTestConnection() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");
    jerseyApiBuilder.setConnectTimeout(1L);

    // Act and Assert
    assertFalse(jerseyApiBuilder.testConnection("https://example.org/example"));
  }

  /**
   * Test {@link JerseyApiBuilder#testConnection(String)}.
   * <ul>
   *   <li>Given {@link JerseyApiBuilder#JerseyApiBuilder(String)} with url is {@code https://example.org/example}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JerseyApiBuilder#testConnection(String)}
   */
  @Test
  @DisplayName("Test testConnection(String); given JerseyApiBuilder(String) with url is 'https://example.org/example'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JerseyApiBuilder.testConnection(String)"})
  void testTestConnection_givenJerseyApiBuilderWithUrlIsHttpsExampleOrgExample_whenNull() {
    // Arrange, Act and Assert
    assertFalse((new JerseyApiBuilder("https://example.org/example")).testConnection(null));
  }
}
