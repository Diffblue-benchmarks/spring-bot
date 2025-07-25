package org.finos.springbot.example.todo;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.workflow.content.Chat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SendToRoomDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SendToRoom}
   *   <li>{@link SendToRoom#setRoom(Chat)}
   *   <li>{@link SendToRoom#getRoom()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SendToRoom.<init>()",
    "Chat SendToRoom.getRoom()",
    "void SendToRoom.setRoom(Chat)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SendToRoom actualSendToRoom = new SendToRoom();
    SymphonyRoom room = new SymphonyRoom("Name", "42");

    actualSendToRoom.setRoom(room);

    // Assert
    assertSame(room, actualSendToRoom.getRoom());
  }
}
