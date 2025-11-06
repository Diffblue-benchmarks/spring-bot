package org.finos.springbot.tool.rssbot.feed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.finos.springbot.tool.rssbot.ProxyProperties;
import org.junit.jupiter.api.Test;

class FeedDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Feed#equals(Object)}
   *   <li>{@link Feed#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = feed.hashCode();
    assertEquals(expectedHashCodeResult, feed2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Feed#equals(Object)}
   *   <li>{@link Feed#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = feed.hashCode();
    assertEquals(expectedHashCodeResult, feed2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Feed#equals(Object)}
   *   <li>{@link Feed#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link Feed#equals(Object)}
   */
  @Test
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
   * Method under test: {@link Feed#equals(Object)}
   */
  @Test
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
   * Method under test: {@link Feed#equals(Object)}
   */
  @Test
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
   * Method under test: {@link Feed#equals(Object)}
   */
  @Test
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
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("https://example.org/example", actualFeed.getUrl());
    assertSame(proxy, actualProxy);
  }
}
