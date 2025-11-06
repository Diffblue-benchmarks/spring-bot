package org.finos.springbot.teams.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.microsoft.bot.schema.Entity;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MarkupAndEntitiesDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MarkupAndEntities#MarkupAndEntities()}
   *   <li>{@link MarkupAndEntities#getContents()}
   *   <li>{@link MarkupAndEntities#getEntities()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MarkupAndEntities actualMarkupAndEntities = new MarkupAndEntities();
    String actualContents = actualMarkupAndEntities.getContents();

    // Assert
    assertNull(actualContents);
    assertTrue(actualMarkupAndEntities.getEntities().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MarkupAndEntities#MarkupAndEntities(String)}
   *   <li>{@link MarkupAndEntities#getContents()}
   *   <li>{@link MarkupAndEntities#getEntities()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    MarkupAndEntities actualMarkupAndEntities = new MarkupAndEntities("Not all who wander are lost");
    String actualContents = actualMarkupAndEntities.getContents();

    // Assert
    assertEquals("Not all who wander are lost", actualContents);
    assertTrue(actualMarkupAndEntities.getEntities().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MarkupAndEntities#MarkupAndEntities(String, List)}
   *   <li>{@link MarkupAndEntities#getContents()}
   *   <li>{@link MarkupAndEntities#getEntities()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange
    ArrayList<Entity> e = new ArrayList<>();

    // Act
    MarkupAndEntities actualMarkupAndEntities = new MarkupAndEntities("foo", e);
    String actualContents = actualMarkupAndEntities.getContents();
    List<Entity> actualEntities = actualMarkupAndEntities.getEntities();

    // Assert
    assertEquals("foo", actualContents);
    assertTrue(actualEntities.isEmpty());
    assertSame(e, actualEntities);
  }
}
