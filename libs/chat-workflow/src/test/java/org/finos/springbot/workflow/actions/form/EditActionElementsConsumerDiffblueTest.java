package org.finos.springbot.workflow.actions.form;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.function.Consumer;
import org.finos.springbot.workflow.actions.FormAction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ErrorHandler;

@ContextConfiguration(classes = {EditActionElementsConsumer.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class EditActionElementsConsumerDiffblueTest {
  @Autowired
  private EditActionElementsConsumer editActionElementsConsumer;

  @MockBean
  private ErrorHandler errorHandler;

  @MockBean
  private ResponseHandlers responseHandlers;

  /**
   * Test {@link EditActionElementsConsumer#acceptFormAction(FormAction)}.
   * <ul>
   *   <li>Given {@link ResponseHandlers} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EditActionElementsConsumer#acceptFormAction(FormAction)}
   */
  @Test
  @DisplayName("Test acceptFormAction(FormAction); given ResponseHandlers accept(Object) does nothing; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EditActionElementsConsumer.acceptFormAction(FormAction)"})
  void testAcceptFormAction_givenResponseHandlersAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    HashMap<String, Object> entityMap = new HashMap<>();
    entityMap.put("form", "42");

    // Act
    editActionElementsConsumer.acceptFormAction(new FormAction(mock(Addressable.class), mock(User.class), "Form Data",
        EditActionElementsConsumer.EDIT, entityMap));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
  }
}
