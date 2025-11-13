package org.finos.springbot.example.rooms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.workflow.content.Chat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BroadcastDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Broadcast}
   *   <li>{@link Broadcast#setSend(String)}
   *   <li>{@link Broadcast#setTo(Chat)}
   *   <li>{@link Broadcast#getSend()}
   *   <li>{@link Broadcast#getTo()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Broadcast.<init>()",
    "String Broadcast.getSend()",
    "Chat Broadcast.getTo()",
    "void Broadcast.setSend(String)",
    "void Broadcast.setTo(Chat)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Broadcast actualBroadcast = new Broadcast();
    actualBroadcast.setSend("Send");
    SymphonyRoom resultTo = new SymphonyRoom();
    actualBroadcast.setTo(resultTo);
    String actualSend = actualBroadcast.getSend();
    Chat actualTo = actualBroadcast.getTo();

    // Assert
    assertTrue(actualTo instanceof SymphonyRoom);
    assertEquals("Send", actualSend);
    assertSame(resultTo, actualTo);
  }
}
