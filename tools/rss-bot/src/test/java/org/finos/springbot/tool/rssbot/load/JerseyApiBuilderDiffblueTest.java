package org.finos.springbot.tool.rssbot.load;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import javax.net.ssl.SSLParameters;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyWebTarget;
import org.glassfish.jersey.uri.internal.JerseyUriBuilder;
import org.junit.jupiter.api.Test;

class JerseyApiBuilderDiffblueTest {
  /**
   * Method under test: {@link JerseyApiBuilder#newWebTarget()}
   */
  @Test
  void testNewWebTarget() {
    // Arrange and Act
    WebTarget actualNewWebTargetResult = (new JerseyApiBuilder("https://example.org/example")).newWebTarget();

    // Assert
    Configuration configuration = actualNewWebTargetResult.getConfiguration();
    assertTrue(((ClientConfig) configuration).getConnectorProvider() instanceof HttpUrlConnectorProvider);
    assertTrue(actualNewWebTargetResult instanceof JerseyWebTarget);
    UriBuilder uriBuilder = actualNewWebTargetResult.getUriBuilder();
    assertTrue(uriBuilder instanceof JerseyUriBuilder);
    JerseyClient client = ((ClientConfig) configuration).getClient();
    SSLContext sslContext = client.getSslContext();
    Provider provider = sslContext.getProvider();
    assertEquals(25, provider.size());
    assertEquals("PKIX", provider.get("Alg.Alias.TrustManagerFactory.X.509"));
    assertEquals("TLSv1", provider.get("Alg.Alias.SSLContext.SSLv3"));
    assertEquals("TLSv1.2", sslContext.getProtocol());
    assertEquals("https://example.org/example", actualNewWebTargetResult.getUri().toString());
    assertEquals("sun.security.ssl.KeyManagerFactoryImpl$X509", provider.get("KeyManagerFactory.NewSunX509"));
    SSLParameters defaultSSLParameters = sslContext.getDefaultSSLParameters();
    assertNull(defaultSSLParameters.getEndpointIdentificationAlgorithm());
    SSLParameters supportedSSLParameters = sslContext.getSupportedSSLParameters();
    assertNull(supportedSSLParameters.getEndpointIdentificationAlgorithm());
    assertNull(defaultSSLParameters.getSNIMatchers());
    assertNull(supportedSSLParameters.getSNIMatchers());
    assertNull(defaultSSLParameters.getServerNames());
    assertNull(supportedSSLParameters.getServerNames());
    assertNull(((ClientConfig) configuration).getExecutorService());
    assertNull(client.getExecutorService());
    assertNull(((ClientConfig) configuration).getScheduledExecutorService());
    assertNull(client.getScheduledExecutorService());
    assertNull(client.getHostnameVerifier());
    assertEquals(0, defaultSSLParameters.getApplicationProtocols().length);
    assertEquals(0, supportedSSLParameters.getApplicationProtocols().length);
    assertEquals(1, configuration.getClasses().size());
    assertEquals(RuntimeType.CLIENT, configuration.getRuntimeType());
    assertFalse(defaultSSLParameters.getNeedClientAuth());
    assertFalse(supportedSSLParameters.getNeedClientAuth());
    assertFalse(defaultSSLParameters.getWantClientAuth());
    assertFalse(supportedSSLParameters.getWantClientAuth());
    assertFalse(client.isClosed());
    assertFalse(client.isDefaultSslContext());
    assertTrue(configuration.getPropertyNames().isEmpty());
    assertTrue(configuration.getProperties().isEmpty());
    assertTrue(configuration.getInstances().isEmpty());
    assertTrue(defaultSSLParameters.getUseCipherSuitesOrder());
    assertTrue(supportedSSLParameters.getUseCipherSuitesOrder());
    assertTrue(((JerseyUriBuilder) uriBuilder).isAbsolute());
    assertEquals(configuration, client.getConfiguration());
    assertArrayEquals(new String[]{"TLSv1.2"}, defaultSSLParameters.getProtocols());
    assertArrayEquals(new String[]{"TLSv1.3", "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3", "SSLv2Hello"},
        supportedSSLParameters.getProtocols());
    assertArrayEquals(new String[]{"TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
        "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"},
        defaultSSLParameters.getCipherSuites());
    assertArrayEquals(new String[]{"TLS_AES_256_GCM_SHA384", "TLS_AES_128_GCM_SHA256", "TLS_CHACHA20_POLY1305_SHA256",
        "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
        "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"},
        supportedSSLParameters.getCipherSuites());
  }

  /**
   * Method under test: {@link JerseyApiBuilder#newWebTarget()}
   */
  @Test
  void testNewWebTarget2() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");
    jerseyApiBuilder.setConnectTimeout(1L);

    // Act
    WebTarget actualNewWebTargetResult = jerseyApiBuilder.newWebTarget();

    // Assert
    Configuration configuration = actualNewWebTargetResult.getConfiguration();
    assertTrue(((ClientConfig) configuration).getConnectorProvider() instanceof HttpUrlConnectorProvider);
    assertTrue(actualNewWebTargetResult instanceof JerseyWebTarget);
    UriBuilder uriBuilder = actualNewWebTargetResult.getUriBuilder();
    assertTrue(uriBuilder instanceof JerseyUriBuilder);
    JerseyClient client = ((ClientConfig) configuration).getClient();
    SSLContext sslContext = client.getSslContext();
    Provider provider = sslContext.getProvider();
    assertEquals(25, provider.size());
    assertEquals("PKIX", provider.get("Alg.Alias.TrustManagerFactory.X.509"));
    assertEquals("TLSv1", provider.get("Alg.Alias.SSLContext.SSLv3"));
    assertEquals("TLSv1.2", sslContext.getProtocol());
    assertEquals("https://example.org/example", actualNewWebTargetResult.getUri().toString());
    assertEquals("sun.security.ssl.KeyManagerFactoryImpl$X509", provider.get("KeyManagerFactory.NewSunX509"));
    SSLParameters defaultSSLParameters = sslContext.getDefaultSSLParameters();
    assertNull(defaultSSLParameters.getEndpointIdentificationAlgorithm());
    SSLParameters supportedSSLParameters = sslContext.getSupportedSSLParameters();
    assertNull(supportedSSLParameters.getEndpointIdentificationAlgorithm());
    assertNull(defaultSSLParameters.getSNIMatchers());
    assertNull(supportedSSLParameters.getSNIMatchers());
    assertNull(defaultSSLParameters.getServerNames());
    assertNull(supportedSSLParameters.getServerNames());
    assertNull(((ClientConfig) configuration).getExecutorService());
    assertNull(client.getExecutorService());
    assertNull(((ClientConfig) configuration).getScheduledExecutorService());
    assertNull(client.getScheduledExecutorService());
    assertNull(client.getHostnameVerifier());
    assertEquals(0, defaultSSLParameters.getApplicationProtocols().length);
    assertEquals(0, supportedSSLParameters.getApplicationProtocols().length);
    assertEquals(1, configuration.getPropertyNames().size());
    Map<String, Object> properties = configuration.getProperties();
    assertEquals(1, properties.size());
    assertEquals(1, configuration.getClasses().size());
    assertEquals(RuntimeType.CLIENT, configuration.getRuntimeType());
    assertFalse(defaultSSLParameters.getNeedClientAuth());
    assertFalse(supportedSSLParameters.getNeedClientAuth());
    assertFalse(defaultSSLParameters.getWantClientAuth());
    assertFalse(supportedSSLParameters.getWantClientAuth());
    assertFalse(client.isClosed());
    assertFalse(client.isDefaultSslContext());
    assertTrue(properties.containsKey("jersey.config.client.connectTimeout"));
    assertTrue(configuration.getInstances().isEmpty());
    assertTrue(defaultSSLParameters.getUseCipherSuitesOrder());
    assertTrue(supportedSSLParameters.getUseCipherSuitesOrder());
    assertTrue(((JerseyUriBuilder) uriBuilder).isAbsolute());
    assertEquals(configuration, client.getConfiguration());
    assertArrayEquals(new String[]{"TLSv1.2"}, defaultSSLParameters.getProtocols());
    assertArrayEquals(new String[]{"TLSv1.3", "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3", "SSLv2Hello"},
        supportedSSLParameters.getProtocols());
    assertArrayEquals(new String[]{"TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
        "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"},
        defaultSSLParameters.getCipherSuites());
    assertArrayEquals(new String[]{"TLS_AES_256_GCM_SHA384", "TLS_AES_128_GCM_SHA256", "TLS_CHACHA20_POLY1305_SHA256",
        "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
        "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"},
        supportedSSLParameters.getCipherSuites());
  }

  /**
   * Method under test: {@link JerseyApiBuilder#newWebTarget(String)}
   */
  @Test
  void testNewWebTarget3() {
    // Arrange and Act
    WebTarget actualNewWebTargetResult = (new JerseyApiBuilder("https://example.org/example"))
        .newWebTarget("https://example.org/example");

    // Assert
    Configuration configuration = actualNewWebTargetResult.getConfiguration();
    assertTrue(((ClientConfig) configuration).getConnectorProvider() instanceof HttpUrlConnectorProvider);
    assertTrue(actualNewWebTargetResult instanceof JerseyWebTarget);
    UriBuilder uriBuilder = actualNewWebTargetResult.getUriBuilder();
    assertTrue(uriBuilder instanceof JerseyUriBuilder);
    JerseyClient client = ((ClientConfig) configuration).getClient();
    SSLContext sslContext = client.getSslContext();
    Provider provider = sslContext.getProvider();
    assertEquals(25, provider.size());
    assertEquals("PKIX", provider.get("Alg.Alias.TrustManagerFactory.X.509"));
    assertEquals("TLSv1", provider.get("Alg.Alias.SSLContext.SSLv3"));
    assertEquals("TLSv1.2", sslContext.getProtocol());
    assertEquals("https://example.org/example", actualNewWebTargetResult.getUri().toString());
    assertEquals("sun.security.ssl.KeyManagerFactoryImpl$X509", provider.get("KeyManagerFactory.NewSunX509"));
    SSLParameters defaultSSLParameters = sslContext.getDefaultSSLParameters();
    assertNull(defaultSSLParameters.getEndpointIdentificationAlgorithm());
    SSLParameters supportedSSLParameters = sslContext.getSupportedSSLParameters();
    assertNull(supportedSSLParameters.getEndpointIdentificationAlgorithm());
    assertNull(defaultSSLParameters.getSNIMatchers());
    assertNull(supportedSSLParameters.getSNIMatchers());
    assertNull(defaultSSLParameters.getServerNames());
    assertNull(supportedSSLParameters.getServerNames());
    assertNull(((ClientConfig) configuration).getExecutorService());
    assertNull(client.getExecutorService());
    assertNull(((ClientConfig) configuration).getScheduledExecutorService());
    assertNull(client.getScheduledExecutorService());
    assertNull(client.getHostnameVerifier());
    assertEquals(0, defaultSSLParameters.getApplicationProtocols().length);
    assertEquals(0, supportedSSLParameters.getApplicationProtocols().length);
    assertEquals(1, configuration.getClasses().size());
    assertEquals(RuntimeType.CLIENT, configuration.getRuntimeType());
    assertFalse(defaultSSLParameters.getNeedClientAuth());
    assertFalse(supportedSSLParameters.getNeedClientAuth());
    assertFalse(defaultSSLParameters.getWantClientAuth());
    assertFalse(supportedSSLParameters.getWantClientAuth());
    assertFalse(client.isClosed());
    assertFalse(client.isDefaultSslContext());
    assertTrue(configuration.getPropertyNames().isEmpty());
    assertTrue(configuration.getProperties().isEmpty());
    assertTrue(configuration.getInstances().isEmpty());
    assertTrue(defaultSSLParameters.getUseCipherSuitesOrder());
    assertTrue(supportedSSLParameters.getUseCipherSuitesOrder());
    assertTrue(((JerseyUriBuilder) uriBuilder).isAbsolute());
    assertEquals(configuration, client.getConfiguration());
    assertArrayEquals(new String[]{"TLSv1.2"}, defaultSSLParameters.getProtocols());
    assertArrayEquals(new String[]{"TLSv1.3", "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3", "SSLv2Hello"},
        supportedSSLParameters.getProtocols());
    assertArrayEquals(new String[]{"TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
        "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"},
        defaultSSLParameters.getCipherSuites());
    assertArrayEquals(new String[]{"TLS_AES_256_GCM_SHA384", "TLS_AES_128_GCM_SHA256", "TLS_CHACHA20_POLY1305_SHA256",
        "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
        "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"},
        supportedSSLParameters.getCipherSuites());
  }

  /**
   * Method under test: {@link JerseyApiBuilder#newWebTarget(String)}
   */
  @Test
  void testNewWebTarget4() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");
    jerseyApiBuilder.setConnectTimeout(1L);

    // Act
    WebTarget actualNewWebTargetResult = jerseyApiBuilder.newWebTarget("https://example.org/example");

    // Assert
    Configuration configuration = actualNewWebTargetResult.getConfiguration();
    assertTrue(((ClientConfig) configuration).getConnectorProvider() instanceof HttpUrlConnectorProvider);
    assertTrue(actualNewWebTargetResult instanceof JerseyWebTarget);
    UriBuilder uriBuilder = actualNewWebTargetResult.getUriBuilder();
    assertTrue(uriBuilder instanceof JerseyUriBuilder);
    JerseyClient client = ((ClientConfig) configuration).getClient();
    SSLContext sslContext = client.getSslContext();
    Provider provider = sslContext.getProvider();
    assertEquals(25, provider.size());
    assertEquals("PKIX", provider.get("Alg.Alias.TrustManagerFactory.X.509"));
    assertEquals("TLSv1", provider.get("Alg.Alias.SSLContext.SSLv3"));
    assertEquals("TLSv1.2", sslContext.getProtocol());
    assertEquals("https://example.org/example", actualNewWebTargetResult.getUri().toString());
    assertEquals("sun.security.ssl.KeyManagerFactoryImpl$X509", provider.get("KeyManagerFactory.NewSunX509"));
    SSLParameters defaultSSLParameters = sslContext.getDefaultSSLParameters();
    assertNull(defaultSSLParameters.getEndpointIdentificationAlgorithm());
    SSLParameters supportedSSLParameters = sslContext.getSupportedSSLParameters();
    assertNull(supportedSSLParameters.getEndpointIdentificationAlgorithm());
    assertNull(defaultSSLParameters.getSNIMatchers());
    assertNull(supportedSSLParameters.getSNIMatchers());
    assertNull(defaultSSLParameters.getServerNames());
    assertNull(supportedSSLParameters.getServerNames());
    assertNull(((ClientConfig) configuration).getExecutorService());
    assertNull(client.getExecutorService());
    assertNull(((ClientConfig) configuration).getScheduledExecutorService());
    assertNull(client.getScheduledExecutorService());
    assertNull(client.getHostnameVerifier());
    assertEquals(0, defaultSSLParameters.getApplicationProtocols().length);
    assertEquals(0, supportedSSLParameters.getApplicationProtocols().length);
    assertEquals(1, configuration.getPropertyNames().size());
    Map<String, Object> properties = configuration.getProperties();
    assertEquals(1, properties.size());
    assertEquals(1, configuration.getClasses().size());
    assertEquals(RuntimeType.CLIENT, configuration.getRuntimeType());
    assertFalse(defaultSSLParameters.getNeedClientAuth());
    assertFalse(supportedSSLParameters.getNeedClientAuth());
    assertFalse(defaultSSLParameters.getWantClientAuth());
    assertFalse(supportedSSLParameters.getWantClientAuth());
    assertFalse(client.isClosed());
    assertFalse(client.isDefaultSslContext());
    assertTrue(properties.containsKey("jersey.config.client.connectTimeout"));
    assertTrue(configuration.getInstances().isEmpty());
    assertTrue(defaultSSLParameters.getUseCipherSuitesOrder());
    assertTrue(supportedSSLParameters.getUseCipherSuitesOrder());
    assertTrue(((JerseyUriBuilder) uriBuilder).isAbsolute());
    assertEquals(configuration, client.getConfiguration());
    assertArrayEquals(new String[]{"TLSv1.2"}, defaultSSLParameters.getProtocols());
    assertArrayEquals(new String[]{"TLSv1.3", "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3", "SSLv2Hello"},
        supportedSSLParameters.getProtocols());
    assertArrayEquals(new String[]{"TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
        "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"},
        defaultSSLParameters.getCipherSuites());
    assertArrayEquals(new String[]{"TLS_AES_256_GCM_SHA384", "TLS_AES_128_GCM_SHA256", "TLS_CHACHA20_POLY1305_SHA256",
        "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
        "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"},
        supportedSSLParameters.getCipherSuites());
  }

  /**
   * Method under test:
   * {@link JerseyApiBuilder#registerFeatures(JerseyClientBuilder)}
   */
  @Test
  void testRegisterFeatures() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");
    JerseyClientBuilder jcb = new JerseyClientBuilder();

    // Act
    jerseyApiBuilder.registerFeatures(jcb);

    // Assert
    assertEquals(1, jcb.getConfiguration().getClasses().size());
  }

  /**
   * Method under test: {@link JerseyApiBuilder#createSSLContext()}
   */
  @Test
  void testCreateSSLContext() throws KeyManagementException, NoSuchAlgorithmException {
    // Arrange and Act
    SSLContext actualCreateSSLContextResult = (new JerseyApiBuilder("https://example.org/example")).createSSLContext();

    // Assert
    Provider provider = actualCreateSSLContextResult.getProvider();
    assertEquals(25, provider.size());
    assertEquals("17", provider.get("Provider.id version"));
    assertEquals("PKIX", provider.get("Alg.Alias.TrustManagerFactory.X.509"));
    assertEquals("TLS", provider.get("Alg.Alias.SSLContext.SSL"));
    assertEquals("TLSv1", provider.get("Alg.Alias.SSLContext.SSLv3"));
    assertEquals("TLSv1.2", actualCreateSSLContextResult.getProtocol());
    assertEquals("sun.security.ssl.KeyManagerFactoryImpl$X509", provider.get("KeyManagerFactory.NewSunX509"));
    assertEquals("sun.security.ssl.SSLContextImpl$DTLSContext", provider.get("SSLContext.DTLS"));
    SSLParameters defaultSSLParameters = actualCreateSSLContextResult.getDefaultSSLParameters();
    assertNull(defaultSSLParameters.getEndpointIdentificationAlgorithm());
    SSLParameters supportedSSLParameters = actualCreateSSLContextResult.getSupportedSSLParameters();
    assertNull(supportedSSLParameters.getEndpointIdentificationAlgorithm());
    assertNull(defaultSSLParameters.getSNIMatchers());
    assertNull(supportedSSLParameters.getSNIMatchers());
    assertNull(defaultSSLParameters.getServerNames());
    assertNull(supportedSSLParameters.getServerNames());
    assertEquals(0, defaultSSLParameters.getApplicationProtocols().length);
    assertEquals(0, supportedSSLParameters.getApplicationProtocols().length);
    assertFalse(defaultSSLParameters.getNeedClientAuth());
    assertFalse(supportedSSLParameters.getNeedClientAuth());
    assertFalse(defaultSSLParameters.getWantClientAuth());
    assertFalse(supportedSSLParameters.getWantClientAuth());
    assertTrue(defaultSSLParameters.getUseCipherSuitesOrder());
    assertTrue(supportedSSLParameters.getUseCipherSuitesOrder());
    assertArrayEquals(new String[]{"TLSv1.2"}, defaultSSLParameters.getProtocols());
    assertArrayEquals(new String[]{"TLSv1.3", "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3", "SSLv2Hello"},
        supportedSSLParameters.getProtocols());
    assertArrayEquals(new String[]{"TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
        "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"},
        defaultSSLParameters.getCipherSuites());
    assertArrayEquals(new String[]{"TLS_AES_256_GCM_SHA384", "TLS_AES_128_GCM_SHA256", "TLS_CHACHA20_POLY1305_SHA256",
        "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
        "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"},
        supportedSSLParameters.getCipherSuites());
  }

  /**
   * Method under test: {@link JerseyApiBuilder#createConfig()}
   */
  @Test
  void testCreateConfig() {
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
   * Method under test: {@link JerseyApiBuilder#createConfig()}
   */
  @Test
  void testCreateConfig2() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");
    jerseyApiBuilder.setConnectTimeout(1L);

    // Act
    ClientConfig actualCreateConfigResult = jerseyApiBuilder.createConfig();

    // Assert
    assertTrue(actualCreateConfigResult.getConnectorProvider() instanceof HttpUrlConnectorProvider);
    assertNull(actualCreateConfigResult.getExecutorService());
    assertNull(actualCreateConfigResult.getScheduledExecutorService());
    assertNull(actualCreateConfigResult.getClient());
    assertNull(actualCreateConfigResult.getConnector());
    assertEquals(1, actualCreateConfigResult.getPropertyNames().size());
    Map<String, Object> properties = actualCreateConfigResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(RuntimeType.CLIENT, actualCreateConfigResult.getRuntimeType());
    assertTrue(properties.containsKey("jersey.config.client.connectTimeout"));
    assertTrue(actualCreateConfigResult.getClasses().isEmpty());
    assertTrue(actualCreateConfigResult.getInstances().isEmpty());
  }

  /**
   * Method under test: {@link JerseyApiBuilder#testConnection(String)}
   */
  @Test
  void testTestConnection() {
    // Arrange, Act and Assert
    assertFalse((new JerseyApiBuilder("https://example.org/example")).testConnection(null));
  }

  /**
   * Method under test: {@link JerseyApiBuilder#testConnection(String)}
   */
  @Test
  void testTestConnection2() {
    // Arrange
    JerseyApiBuilder jerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");
    jerseyApiBuilder.setConnectTimeout(1L);

    // Act and Assert
    assertFalse(jerseyApiBuilder.testConnection("https://example.org/example"));
  }

  /**
   * Method under test: {@link JerseyApiBuilder#JerseyApiBuilder()}
   */
  @Test
  void testNewJerseyApiBuilder() {
    // Arrange and Act
    JerseyApiBuilder actualJerseyApiBuilder = new JerseyApiBuilder();

    // Assert
    assertNull(actualJerseyApiBuilder.getKeyManagers());
    assertNull(actualJerseyApiBuilder.getTrustManagers());
  }

  /**
   * Method under test: {@link JerseyApiBuilder#JerseyApiBuilder(String)}
   */
  @Test
  void testNewJerseyApiBuilder2() {
    // Arrange and Act
    JerseyApiBuilder actualJerseyApiBuilder = new JerseyApiBuilder("https://example.org/example");

    // Assert
    assertNull(actualJerseyApiBuilder.getKeyManagers());
    assertNull(actualJerseyApiBuilder.getTrustManagers());
  }

  /**
   * Method under test:
   * {@link JerseyApiBuilder#JerseyApiBuilder(String, KeyManager[])}
   */
  @Test
  void testNewJerseyApiBuilder3() {
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
}
