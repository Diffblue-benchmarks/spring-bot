package org.finos.springbot.tool.rssbot.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.tool.rssbot.ProxyProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
    ProxyProperties expectedGetResult = proxyPropertiesList.get(0);
    assertSame(expectedGetResult, proxyPropertiesList.get(1));
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
}
