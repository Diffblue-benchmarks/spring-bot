package org.finos.springbot.example.rooms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.workflow.content.Chat;
import org.junit.jupiter.api.Test;

class BroadcastDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Broadcast}
   *   <li>{@link Broadcast#setSend(String)}
   *   <li>{@link Broadcast#setTo(Chat)}
   *   <li>{@link Broadcast#getSend()}
   *   <li>{@link Broadcast#getTo()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Broadcast actualBroadcast = new Broadcast();
    actualBroadcast.setSend("Send");
    SymphonyRoom resultTo = new SymphonyRoom("Name", "42");

    actualBroadcast.setTo(resultTo);
    String actualSend = actualBroadcast.getSend();

    // Assert that nothing has changed
    assertEquals("Send", actualSend);
    assertSame(resultTo, actualBroadcast.getTo());
  }
}
