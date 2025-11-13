package org.finos.springbot.example.rooms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.Paragraph;
import org.finos.springbot.workflow.content.Paragraph.ParagraphImpl;
import org.finos.springbot.workflow.response.MessageResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BroadcastController.class})
@ExtendWith(SpringExtension.class)
class BroadcastControllerDiffblueTest {
  @Autowired private BroadcastController broadcastController;

  /**
   * Test {@link BroadcastController#createForm()}.
   *
   * <p>Method under test: {@link BroadcastController#createForm()}
   */
  @Test
  @DisplayName("Test createForm()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Broadcast BroadcastController.createForm()"})
  void testCreateForm() {
    // Arrange and Act
    Broadcast actualCreateFormResult = broadcastController.createForm();

    // Assert
    assertNull(actualCreateFormResult.getSend());
    assertNull(actualCreateFormResult.getTo());
  }

  /**
   * Test {@link BroadcastController#broadcast(Broadcast)}.
   *
   * <ul>
   *   <li>Given {@code Send}.
   *   <li>When {@link Broadcast} (default constructor) Send is {@code Send}.
   *   <li>Then Address return {@link SymphonyRoom}.
   * </ul>
   *
   * <p>Method under test: {@link BroadcastController#broadcast(Broadcast)}
   */
  @Test
  @DisplayName(
      "Test broadcast(Broadcast); given 'Send'; when Broadcast (default constructor) Send is 'Send'; then Address return SymphonyRoom")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageResponse BroadcastController.broadcast(Broadcast)"})
  void testBroadcast_givenSend_whenBroadcastSendIsSend_thenAddressReturnSymphonyRoom() {
    // Arrange
    Broadcast br = new Broadcast();
    br.setSend("Send");
    SymphonyRoom resultTo = new SymphonyRoom();
    br.setTo(resultTo);

    // Act
    MessageResponse actualBroadcastResult = broadcastController.broadcast(br);

    // Assert
    Addressable address = actualBroadcastResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    assertNull(((SymphonyRoom) address).getId());
    assertSame(resultTo, address);
    assertTrue(actualBroadcastResult.getData().isEmpty());
    Content message = actualBroadcastResult.getMessage();
    assertTrue(message instanceof MessageImpl);
    List<Content> contents = ((MessageImpl) message).getContents();
    assertEquals(1, contents.size());
    Content getResult = contents.get(0);
    assertTrue(getResult instanceof ParagraphImpl);
    assertEquals("Send", message.getText());
    Iterator<Content> iteratorResult = ((MessageImpl) message).iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(getResult, actualNextResult);
    assertEquals(1, ((MessageImpl) message).size());
    assertNull(actualBroadcastResult.getTemplateName());
  }
}
