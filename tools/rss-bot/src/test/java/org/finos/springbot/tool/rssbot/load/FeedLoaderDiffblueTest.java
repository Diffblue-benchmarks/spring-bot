package org.finos.springbot.tool.rssbot.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.rometools.rome.io.FeedException;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.tool.rssbot.ProxyProperties;
import org.junit.jupiter.api.Test;

class FeedLoaderDiffblueTest {
  /**
   * Method under test: {@link FeedLoader#createFeed(String, String)}
   */
  @Test
  void testCreateFeed() throws FeedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(FeedException.class,
        () -> (new FeedLoader(new ArrayList<>())).createFeed("https://example.org/example", "Name"));
  }

  /**
   * Method under test: {@link FeedLoader#createFeed(String, String)}
   */
  @Test
  void testCreateFeed2() throws FeedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    proxy.add(new ProxyProperties());

    // Act and Assert
    assertThrows(FeedException.class, () -> (new FeedLoader(proxy)).createFeed("https://example.org/example", "Name"));
  }

  /**
   * Method under test: {@link FeedLoader#createFeed(String, String)}
   */
  @Test
  void testCreateFeed3() throws FeedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();
    proxyProperties.setHost("localhost");

    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    proxy.add(proxyProperties);

    // Act and Assert
    assertThrows(FeedException.class, () -> (new FeedLoader(proxy)).createFeed("https://example.org/example", "Name"));
  }

  /**
   * Method under test: {@link FeedLoader#createFeed(String, String)}
   */
  @Test
  void testCreateFeed4() throws FeedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();
    proxyProperties.setHost("TLSv1.2");

    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    proxy.add(proxyProperties);

    // Act and Assert
    assertThrows(FeedException.class, () -> (new FeedLoader(proxy)).createFeed("https://example.org/example", "Name"));
  }

  /**
   * Method under test: {@link FeedLoader#createFeed(String, String)}
   */
  @Test
  void testCreateFeed5() throws FeedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();
    proxyProperties.setHost("");

    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    proxy.add(proxyProperties);

    // Act and Assert
    assertThrows(FeedException.class, () -> (new FeedLoader(proxy)).createFeed("https://example.org/example", "Name"));
  }

  /**
   * Method under test: {@link FeedLoader#FeedLoader(List)}
   */
  @Test
  void testNewFeedLoader() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    List<ProxyProperties> proxyPropertiesList = (new FeedLoader(new ArrayList<>())).pp;
    assertEquals(1, proxyPropertiesList.size());
    ProxyProperties getResult = proxyPropertiesList.get(0);
    assertEquals("<none>", getResult.getHost());
    assertNull(getResult.getPassword());
    assertNull(getResult.getUser());
    assertEquals(8080, getResult.getPort());
  }

  /**
   * Method under test: {@link FeedLoader#FeedLoader(List)}
   */
  @Test
  void testNewFeedLoader2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    List<ProxyProperties> proxyPropertiesList = (new FeedLoader(null)).pp;
    assertEquals(1, proxyPropertiesList.size());
    ProxyProperties getResult = proxyPropertiesList.get(0);
    assertEquals("<none>", getResult.getHost());
    assertNull(getResult.getPassword());
    assertNull(getResult.getUser());
    assertEquals(8080, getResult.getPort());
  }

  /**
   * Method under test: {@link FeedLoader#FeedLoader(List)}
   */
  @Test
  void testNewFeedLoader3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    ProxyProperties proxyProperties = new ProxyProperties();
    proxy.add(proxyProperties);

    // Act and Assert
    List<ProxyProperties> proxyPropertiesList = (new FeedLoader(proxy)).pp;
    assertEquals(1, proxyPropertiesList.size());
    assertSame(proxyProperties, proxyPropertiesList.get(0));
  }

  /**
   * Method under test: {@link FeedLoader#FeedLoader(List)}
   */
  @Test
  void testNewFeedLoader4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    ProxyProperties proxyProperties = new ProxyProperties();
    proxy.add(proxyProperties);
    ProxyProperties proxyProperties2 = new ProxyProperties();
    proxy.add(proxyProperties2);

    // Act and Assert
    List<ProxyProperties> proxyPropertiesList = (new FeedLoader(proxy)).pp;
    assertEquals(2, proxyPropertiesList.size());
    assertSame(proxyProperties, proxyPropertiesList.get(0));
    assertSame(proxyProperties2, proxyPropertiesList.get(1));
  }
}
