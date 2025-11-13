package org.finos.springbot.tool.rssbot.feed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.tool.rssbot.ProxyProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FeedDiffblueTest {
  /**
   * Test {@link Feed#equals(Object)}, and {@link Feed#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Feed#equals(Object)}
   *   <li>{@link Feed#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Feed.equals(Object)", "int Feed.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");

    Feed feed2 = new Feed();
    feed2.setDescription("The characteristics of someone or something");
    feed2.setName("Name");
    feed2.setProxy(new ProxyProperties());
    feed2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(feed, feed2);
    assertEquals(feed.hashCode(), feed2.hashCode());
  }

  /**
   * Test {@link Feed#equals(Object)}, and {@link Feed#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Feed#equals(Object)}
   *   <li>{@link Feed#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Feed.equals(Object)", "int Feed.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl(null);

    Feed feed2 = new Feed();
    feed2.setDescription("The characteristics of someone or something");
    feed2.setName("Name");
    feed2.setProxy(new ProxyProperties());
    feed2.setUrl(null);

    // Act and Assert
    assertEquals(feed, feed2);
    assertEquals(feed.hashCode(), feed2.hashCode());
  }

  /**
   * Test {@link Feed#equals(Object)}, and {@link Feed#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Feed#equals(Object)}
   *   <li>{@link Feed#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Feed.equals(Object)", "int Feed.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(feed, feed);
    int expectedHashCodeResult = feed.hashCode();
    assertEquals(expectedHashCodeResult, feed.hashCode());
  }

  /**
   * Test {@link Feed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Feed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Feed.equals(Object)", "int Feed.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("Url");

    Feed feed2 = new Feed();
    feed2.setDescription("The characteristics of someone or something");
    feed2.setName("Name");
    feed2.setProxy(new ProxyProperties());
    feed2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(feed, feed2);
  }

  /**
   * Test {@link Feed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Feed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Feed.equals(Object)", "int Feed.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl(null);

    Feed feed2 = new Feed();
    feed2.setDescription("The characteristics of someone or something");
    feed2.setName("Name");
    feed2.setProxy(new ProxyProperties());
    feed2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(feed, feed2);
  }

  /**
   * Test {@link Feed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Feed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Feed.equals(Object)", "int Feed.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(feed, null);
  }

  /**
   * Test {@link Feed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Feed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Feed.equals(Object)", "int Feed.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(feed, "Different type to Feed");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Feed}
   *   <li>{@link Feed#setDescription(String)}
   *   <li>{@link Feed#setName(String)}
   *   <li>{@link Feed#setProxy(ProxyProperties)}
   *   <li>{@link Feed#setUrl(String)}
   *   <li>{@link Feed#getDescription()}
   *   <li>{@link Feed#getName()}
   *   <li>{@link Feed#getProxy()}
   *   <li>{@link Feed#getUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Feed.<init>()",
    "String Feed.getDescription()",
    "String Feed.getName()",
    "ProxyProperties Feed.getProxy()",
    "String Feed.getUrl()",
    "void Feed.setDescription(String)",
    "void Feed.setName(String)",
    "void Feed.setProxy(ProxyProperties)",
    "void Feed.setUrl(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Feed actualFeed = new Feed();
    actualFeed.setDescription("The characteristics of someone or something");
    actualFeed.setName("Name");
    ProxyProperties proxy = new ProxyProperties();
    actualFeed.setProxy(proxy);
    actualFeed.setUrl("https://example.org/example");
    String actualDescription = actualFeed.getDescription();
    String actualName = actualFeed.getName();
    ProxyProperties actualProxy = actualFeed.getProxy();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("https://example.org/example", actualFeed.getUrl());
    assertSame(proxy, actualProxy);
  }
}
