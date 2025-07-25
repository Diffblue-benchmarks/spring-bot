package org.finos.springbot.tool.rssbot.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rometools.rome.io.FeedException;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.tool.rssbot.ProxyProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FeedLoader.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class FeedLoaderDiffblueTest {
  @Autowired private FeedLoader feedLoader;

  @Autowired private List<ProxyProperties> list;

  @MockitoBean private ProxyProperties proxyProperties;

  /**
   * Test {@link FeedLoader#FeedLoader(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProxyProperties}.
   *   <li>Then return {@link FeedLoader#pp} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FeedLoader#FeedLoader(List)}
   */
  @Test
  @DisplayName(
      "Test new FeedLoader(List); when ArrayList() add ProxyProperties; then return pp size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeedLoader.<init>(List)"})
  void testNewFeedLoader_whenArrayListAddProxyProperties_thenReturnPpSizeIsOne() {
    // Arrange
    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    proxy.add(proxyProperties);

    // Act and Assert
    assertEquals(1, new FeedLoader(proxy).pp.size());
  }

  /**
   * Test {@link FeedLoader#FeedLoader(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProxyProperties}.
   *   <li>Then return {@link FeedLoader#pp} size is two.
   * </ul>
   *
   * <p>Method under test: {@link FeedLoader#FeedLoader(List)}
   */
  @Test
  @DisplayName(
      "Test new FeedLoader(List); when ArrayList() add ProxyProperties; then return pp size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeedLoader.<init>(List)"})
  void testNewFeedLoader_whenArrayListAddProxyProperties_thenReturnPpSizeIsTwo() {
    // Arrange
    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    proxy.add(proxyProperties);
    proxy.add(proxyProperties);

    // Act and Assert
    List<ProxyProperties> proxyPropertiesList = new FeedLoader(proxy).pp;
    assertEquals(2, proxyPropertiesList.size());
    assertSame(proxyPropertiesList.get(0), proxyPropertiesList.get(1));
  }

  /**
   * Test {@link FeedLoader#FeedLoader(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link FeedLoader#pp} first Host is {@code <none>}.
   * </ul>
   *
   * <p>Method under test: {@link FeedLoader#FeedLoader(List)}
   */
  @Test
  @DisplayName("Test new FeedLoader(List); when ArrayList(); then return pp first Host is '<none>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeedLoader.<init>(List)"})
  void testNewFeedLoader_whenArrayList_thenReturnPpFirstHostIsNone() {
    // Arrange, Act and Assert
    List<ProxyProperties> proxyPropertiesList = new FeedLoader(new ArrayList<>()).pp;
    assertEquals(1, proxyPropertiesList.size());
    ProxyProperties getResult = proxyPropertiesList.get(0);
    assertEquals("<none>", getResult.getHost());
    assertNull(getResult.getPassword());
    assertNull(getResult.getUser());
    assertEquals(8080, getResult.getPort());
  }

  /**
   * Test {@link FeedLoader#FeedLoader(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link FeedLoader#pp} first Host is {@code <none>}.
   * </ul>
   *
   * <p>Method under test: {@link FeedLoader#FeedLoader(List)}
   */
  @Test
  @DisplayName("Test new FeedLoader(List); when 'null'; then return pp first Host is '<none>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeedLoader.<init>(List)"})
  void testNewFeedLoader_whenNull_thenReturnPpFirstHostIsNone() {
    // Arrange, Act and Assert
    List<ProxyProperties> proxyPropertiesList = new FeedLoader(null).pp;
    assertEquals(1, proxyPropertiesList.size());
    ProxyProperties getResult = proxyPropertiesList.get(0);
    assertEquals("<none>", getResult.getHost());
    assertNull(getResult.getPassword());
    assertNull(getResult.getUser());
    assertEquals(8080, getResult.getPort());
  }

  /**
   * Test {@link FeedLoader#createFeed(String, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProxyProperties} (default constructor).
   *   <li>When {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link FeedLoader#createFeed(String, String)}
   */
  @Test
  @DisplayName(
      "Test createFeed(String, String); given ArrayList() add ProxyProperties (default constructor); when 'not blank'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.tool.rssbot.feed.Feed FeedLoader.createFeed(String, String)"
  })
  void testCreateFeed_givenArrayListAddProxyProperties_whenNotBlank() throws FeedException {
    // Arrange
    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    proxy.add(new ProxyProperties());

    // Act and Assert
    assertThrows(
        FeedException.class,
        () -> new FeedLoader(proxy).createFeed("https://example.org/example", "not blank"));
  }

  /**
   * Test {@link FeedLoader#createFeed(String, String)}.
   *
   * <ul>
   *   <li>Given {@link FeedLoader#FeedLoader(List)} with proxy is {@link ArrayList#ArrayList()}.
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link FeedLoader#createFeed(String, String)}
   */
  @Test
  @DisplayName(
      "Test createFeed(String, String); given FeedLoader(List) with proxy is ArrayList(); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.tool.rssbot.feed.Feed FeedLoader.createFeed(String, String)"
  })
  void testCreateFeed_givenFeedLoaderWithProxyIsArrayList_whenName() throws FeedException {
    // Arrange, Act and Assert
    assertThrows(
        FeedException.class,
        () -> new FeedLoader(new ArrayList<>()).createFeed("https://example.org/example", "Name"));
  }

  /**
   * Test {@link FeedLoader#createFeed(String, String)}.
   *
   * <ul>
   *   <li>Given {@link ProxyProperties} {@link ProxyProperties#getHost()} return {@code localhost}.
   *   <li>Then calls {@link ProxyProperties#configure(ConfigurableApiBuilder)}.
   * </ul>
   *
   * <p>Method under test: {@link FeedLoader#createFeed(String, String)}
   */
  @Test
  @DisplayName(
      "Test createFeed(String, String); given ProxyProperties getHost() return 'localhost'; then calls configure(ConfigurableApiBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.tool.rssbot.feed.Feed FeedLoader.createFeed(String, String)"
  })
  void testCreateFeed_givenProxyPropertiesGetHostReturnLocalhost_thenCallsConfigure()
      throws FeedException {
    // Arrange
    when(proxyProperties.getHost()).thenReturn("localhost");
    doNothing().when(proxyProperties).configure(Mockito.<ConfigurableApiBuilder>any());

    // Act and Assert
    assertThrows(
        FeedException.class, () -> feedLoader.createFeed("https://example.org/example", "Name"));
    verify(proxyProperties).configure(isA(ConfigurableApiBuilder.class));
    verify(proxyProperties).getHost();
  }

  /**
   * Test {@link FeedLoader#createFeed(String, String)}.
   *
   * <ul>
   *   <li>Given {@link ProxyProperties} (default constructor) Host is empty string.
   *   <li>When {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link FeedLoader#createFeed(String, String)}
   */
  @Test
  @DisplayName(
      "Test createFeed(String, String); given ProxyProperties (default constructor) Host is empty string; when 'not blank'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.tool.rssbot.feed.Feed FeedLoader.createFeed(String, String)"
  })
  void testCreateFeed_givenProxyPropertiesHostIsEmptyString_whenNotBlank() throws FeedException {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();
    proxyProperties.setHost("");

    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    proxy.add(proxyProperties);

    // Act and Assert
    assertThrows(
        FeedException.class,
        () -> new FeedLoader(proxy).createFeed("https://example.org/example", "not blank"));
  }

  /**
   * Test {@link FeedLoader#createFeed(String, String)}.
   *
   * <ul>
   *   <li>Given {@link ProxyProperties} (default constructor) Host is {@code localhost<none>}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FeedLoader#createFeed(String, String)}
   */
  @Test
  @DisplayName(
      "Test createFeed(String, String); given ProxyProperties (default constructor) Host is 'localhost<none>'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.tool.rssbot.feed.Feed FeedLoader.createFeed(String, String)"
  })
  void testCreateFeed_givenProxyPropertiesHostIsLocalhostNone_whenNull() throws FeedException {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();
    proxyProperties.setHost("localhost<none>");

    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    proxy.add(proxyProperties);

    // Act and Assert
    assertThrows(
        FeedException.class,
        () -> new FeedLoader(proxy).createFeed("https://example.org/example", null));
  }

  /**
   * Test {@link FeedLoader#createFeed(String, String)}.
   *
   * <ul>
   *   <li>Given {@link ProxyProperties} (default constructor) Host is {@code localhost}.
   *   <li>When {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link FeedLoader#createFeed(String, String)}
   */
  @Test
  @DisplayName(
      "Test createFeed(String, String); given ProxyProperties (default constructor) Host is 'localhost'; when 'not blank'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.tool.rssbot.feed.Feed FeedLoader.createFeed(String, String)"
  })
  void testCreateFeed_givenProxyPropertiesHostIsLocalhost_whenNotBlank() throws FeedException {
    // Arrange
    ProxyProperties proxyProperties = new ProxyProperties();
    proxyProperties.setHost("localhost");

    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    proxy.add(proxyProperties);

    // Act and Assert
    assertThrows(
        FeedException.class,
        () -> new FeedLoader(proxy).createFeed("https://example.org/example", "not blank"));
  }
}
