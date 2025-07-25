package org.finos.springbot.testing.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TestRoomDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TestRoom#TestRoom(String, String)}
   *   <li>{@link TestRoom#getKey()}
   *   <li>{@link TestRoom#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TestRoom.<init>(String, String)",
    "String TestRoom.getKey()",
    "String TestRoom.getName()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TestRoom actualTestRoom = new TestRoom("Key", "Name");
    String actualKey = actualTestRoom.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("Name", actualTestRoom.getName());
  }
}
