package org.finos.springbot.symphony.messages;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.bdk.gen.api.model.V4Message;
import com.symphony.bdk.gen.api.model.V4MessageSent;
import com.symphony.bdk.gen.api.model.V4User;
import com.symphony.bdk.spring.events.RealTimeEvent;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.symphony.content.serialization.MessageMLParser;
import org.finos.springbot.symphony.conversations.SymphonyConversations;
import org.finos.springbot.workflow.actions.consumers.ActionConsumer;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PresentationMLHandler.class, String.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class PresentationMLHandlerDiffblueTest {
  @MockitoBean private ActionConsumer actionConsumer;

  @MockitoBean private EntityJsonConverter entityJsonConverter;

  @Autowired private List<ActionConsumer> list;

  @MockitoBean private MessageMLParser messageMLParser;

  @Autowired private PresentationMLHandler presentationMLHandler;

  @MockitoBean private SymphonyConversations symphonyConversations;

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_givenNull() {
    // Arrange
    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(null);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <ul>
   *   <li>Then calls {@link MessageMLParser#apply(String, EntityJson)}.
   * </ul>
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; then calls apply(String, EntityJson)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_thenCallsApply() {
    // Arrange
    when(messageMLParser.apply(Mockito.<String>any(), Mockito.<EntityJson>any()))
        .thenReturn(new MessageImpl(new ArrayList<>()));
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    V4Message message = new V4Message();
    message.user(new V4User());
    message.data(null);
    message.message("<messageML>");

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);
    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(v4MessageSent);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
    verify(messageMLParser).apply(eq("<messageML>"), isA(EntityJson.class));
    verify(entityJsonConverter).readValue(isNull());
  }
}
