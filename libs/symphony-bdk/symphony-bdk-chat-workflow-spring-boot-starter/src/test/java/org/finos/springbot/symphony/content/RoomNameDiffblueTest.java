package org.finos.springbot.symphony.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class RoomNameDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RoomName#RoomName()}
   *   <li>{@link RoomName#getSymbolPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RoomName actualRoomName = new RoomName();

    // Assert
    assertEquals("@", actualRoomName.getSymbolPrefix());
    assertNull(actualRoomName.getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RoomName#RoomName(String)}
   *   <li>{@link RoomName#getSymbolPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    RoomName actualRoomName = new RoomName("42");
    String actualSymbolPrefix = actualRoomName.getSymbolPrefix();

    // Assert
    assertEquals("42", actualRoomName.getValue());
    assertEquals("@", actualSymbolPrefix);
  }
}
