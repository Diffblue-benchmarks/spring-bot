package org.finos.springbot.testing.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestRoomDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestRoom#TestRoom(String, String)}
   *   <li>{@link TestRoom#getKey()}
   *   <li>{@link TestRoom#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TestRoom actualTestRoom = new TestRoom("Key", "Name");
    String actualKey = actualTestRoom.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("Name", actualTestRoom.getName());
  }
}
