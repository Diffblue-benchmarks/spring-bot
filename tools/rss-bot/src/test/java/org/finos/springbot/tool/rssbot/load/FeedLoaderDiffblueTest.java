package org.finos.springbot.tool.rssbot.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FeedLoader.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class FeedLoaderDiffblueTest {
  @Autowired
  private FeedLoader feedLoader;

  @Autowired
  private List<ProxyProperties> list;

  @MockBean
  private ProxyProperties proxyProperties;

  /**
   * Test {@link FeedLoader#FeedLoader(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProxyProperties}.</li>
   *   <li>Then return {@link FeedLoader#pp} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeedLoader#FeedLoader(List)}
   */
  @Test
  @DisplayName("Test new FeedLoader(List); when ArrayList() add ProxyProperties; then return pp size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FeedLoader.<init>(List)"})
  void testNewFeedLoader_whenArrayListAddProxyProperties_thenReturnPpSizeIsOne() {
    // Arrange
    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    proxy.add(proxyProperties);

    // Act and Assert
    assertEquals(1, (new FeedLoader(proxy)).pp.size());
  }

  /**
   * Test {@link FeedLoader#FeedLoader(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProxyProperties}.</li>
   *   <li>Then return {@link FeedLoader#pp} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeedLoader#FeedLoader(List)}
   */
  @Test
  @DisplayName("Test new FeedLoader(List); when ArrayList() add ProxyProperties; then return pp size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FeedLoader.<init>(List)"})
  void testNewFeedLoader_whenArrayListAddProxyProperties_thenReturnPpSizeIsTwo() {
    // Arrange
    ArrayList<ProxyProperties> proxy = new ArrayList<>();
    proxy.add(proxyProperties);
    proxy.add(proxyProperties);

    // Act and Assert
    List<ProxyProperties> proxyPropertiesList = (new FeedLoader(proxy)).pp;
    assertEquals(2, proxyPropertiesList.size());
    assertSame(proxyPropertiesList.get(0), proxyPropertiesList.get(1));
  }

  /**
   * Test {@link FeedLoader#FeedLoader(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link FeedLoader#pp} first Host is {@code <none>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeedLoader#FeedLoader(List)}
   */
  @Test
  @DisplayName("Test new FeedLoader(List); when ArrayList(); then return pp first Host is '<none>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FeedLoader.<init>(List)"})
  void testNewFeedLoader_whenArrayList_thenReturnPpFirstHostIsNone() {
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
   * Test {@link FeedLoader#FeedLoader(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link FeedLoader#pp} first Host is {@code <none>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeedLoader#FeedLoader(List)}
   */
  @Test
  @DisplayName("Test new FeedLoader(List); when 'null'; then return pp first Host is '<none>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FeedLoader.<init>(List)"})
  void testNewFeedLoader_whenNull_thenReturnPpFirstHostIsNone() {
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
   * Test {@link FeedLoader#createFeed(String, String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then throw {@link FeedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeedLoader#createFeed(String, String)}
   */
  @Test
  @DisplayName("Test createFeed(String, String); when 'https://example.org/example'; then throw FeedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.springbot.tool.rssbot.feed.Feed FeedLoader.createFeed(String, String)"})
  void testCreateFeed_whenHttpsExampleOrgExample_thenThrowFeedException() throws FeedException {
    // Arrange
    when(proxyProperties.getHost()).thenReturn("localhost");
    doNothing().when(proxyProperties).configure(Mockito.<ConfigurableApiBuilder>any());

    // Act and Assert
    assertThrows(FeedException.class, () -> feedLoader.createFeed("https://example.org/example", "Name"));
    verify(proxyProperties).configure(isA(ConfigurableApiBuilder.class));
    verify(proxyProperties).getHost();
  }
}
