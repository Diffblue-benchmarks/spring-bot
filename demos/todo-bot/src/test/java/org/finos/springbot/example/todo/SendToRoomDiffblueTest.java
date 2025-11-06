package org.finos.springbot.example.todo;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.workflow.content.Chat;
import org.junit.jupiter.api.Test;

class SendToRoomDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SendToRoom}
   *   <li>{@link SendToRoom#setRoom(Chat)}
   *   <li>{@link SendToRoom#getRoom()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SendToRoom actualSendToRoom = new SendToRoom();
    SymphonyRoom room = new SymphonyRoom("Name", "42");

    actualSendToRoom.setRoom(room);

    // Assert that nothing has changed
    assertSame(room, actualSendToRoom.getRoom());
  }
}
