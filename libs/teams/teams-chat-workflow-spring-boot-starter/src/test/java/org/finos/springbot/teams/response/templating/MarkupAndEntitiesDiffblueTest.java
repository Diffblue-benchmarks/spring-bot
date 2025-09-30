package org.finos.springbot.teams.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.microsoft.bot.schema.Entity;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MarkupAndEntitiesDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Contents is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MarkupAndEntities#MarkupAndEntities(String)}
   *   <li>{@link MarkupAndEntities#getContents()}
   *   <li>{@link MarkupAndEntities#getEntities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Contents is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MarkupAndEntities.<init>()",
    "void MarkupAndEntities.<init>(String)",
    "void MarkupAndEntities.<init>(String, List)",
    "String MarkupAndEntities.getContents()",
    "List MarkupAndEntities.getEntities()"
  })
  void testGettersAndSetters_thenReturnContentsIsNotAllWhoWanderAreLost() {
    // Arrange and Act
    MarkupAndEntities actualMarkupAndEntities =
        new MarkupAndEntities("Not all who wander are lost");
    String actualContents = actualMarkupAndEntities.getContents();

    // Assert
    assertEquals("Not all who wander are lost", actualContents);
    assertTrue(actualMarkupAndEntities.getEntities().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Contents is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MarkupAndEntities#MarkupAndEntities()}
   *   <li>{@link MarkupAndEntities#getContents()}
   *   <li>{@link MarkupAndEntities#getEntities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Contents is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MarkupAndEntities.<init>()",
    "void MarkupAndEntities.<init>(String)",
    "void MarkupAndEntities.<init>(String, List)",
    "String MarkupAndEntities.getContents()",
    "List MarkupAndEntities.getEntities()"
  })
  void testGettersAndSetters_thenReturnContentsIsNull() {
    // Arrange and Act
    MarkupAndEntities actualMarkupAndEntities = new MarkupAndEntities();
    String actualContents = actualMarkupAndEntities.getContents();

    // Assert
    assertNull(actualContents);
    assertTrue(actualMarkupAndEntities.getEntities().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return Contents is {@code foo}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MarkupAndEntities#MarkupAndEntities(String, List)}
   *   <li>{@link MarkupAndEntities#getContents()}
   *   <li>{@link MarkupAndEntities#getEntities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'foo'; then return Contents is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MarkupAndEntities.<init>()",
    "void MarkupAndEntities.<init>(String)",
    "void MarkupAndEntities.<init>(String, List)",
    "String MarkupAndEntities.getContents()",
    "List MarkupAndEntities.getEntities()"
  })
  void testGettersAndSetters_whenFoo_thenReturnContentsIsFoo() {
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
