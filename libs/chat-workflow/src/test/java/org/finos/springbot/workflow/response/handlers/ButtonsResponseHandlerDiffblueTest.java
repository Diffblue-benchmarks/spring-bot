package org.finos.springbot.workflow.response.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.finos.springbot.workflow.annotations.ChatButton;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {ButtonsResponseHandler.class})
@ExtendWith(SpringExtension.class)
class ButtonsResponseHandlerDiffblueTest {
  @Autowired
  private ButtonsResponseHandler buttonsResponseHandler;

  /**
   * Method under test: {@link ButtonsResponseHandler#formatFieldName(String)}
   */
  @Test
  void testFormatFieldName() {
    // Arrange, Act and Assert
    assertEquals("Field  Name", ButtonsResponseHandler.formatFieldName("Field Name"));
    assertEquals("", ButtonsResponseHandler.formatFieldName(" "));
  }

  /**
   * Method under test: {@link ButtonsResponseHandler#apply(Response)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertNull(buttonsResponseHandler.apply(new MessageResponse(null, "Not all who wander are lost")));
    assertNull(buttonsResponseHandler.apply(new WorkResponse(null, "42", WorkMode.BOTH)));
  }

  /**
   * Method under test: {@link ButtonsResponseHandler#apply(Response)}
   */
  @Test
  void testApply2() {
    // Arrange
    ErrorResponse t = new ErrorResponse(null, new Throwable());

    // Act
    Void actualApplyResult = buttonsResponseHandler.apply(t);

    // Assert
    ButtonList buttons = t.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    assertNull(actualApplyResult);
    assertEquals(0, buttons.size());
    Map<String, Object> data = t.getData();
    assertEquals(3, data.size());
    assertTrue(contents.isEmpty());
    assertTrue(data.containsKey("error"));
    assertTrue(data.containsKey("message"));
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Method under test: {@link ButtonsResponseHandler#apply(Response)}
   */
  @Test
  void testApply3() {
    // Arrange
    ErrorResponse t = new ErrorResponse(null, new Throwable(), "Template Name");

    // Act
    Void actualApplyResult = buttonsResponseHandler.apply(t);

    // Assert
    ButtonList buttons = t.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    assertNull(actualApplyResult);
    assertEquals(0, buttons.size());
    Map<String, Object> data = t.getData();
    assertEquals(3, data.size());
    assertTrue(contents.isEmpty());
    assertTrue(data.containsKey("error"));
    assertTrue(data.containsKey("message"));
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Method under test: {@link ButtonsResponseHandler#apply(Response)}
   */
  @Test
  void testApply4() {
    // Arrange
    ButtonList buttons = new ButtonList();
    buttons.add(new Button("Name", Button.Type.ACTION, "Text"));

    // Act and Assert
    assertNull(buttonsResponseHandler.apply(new WorkResponse(null, "42", WorkMode.BOTH, buttons, new ErrorMap())));
  }

  /**
   * Method under test:
   * {@link ButtonsResponseHandler#exposedMatchesObject(ChatButton, Object)}
   */
  @Test
  void testExposedMatchesObject() {
    // Arrange, Act and Assert
    assertFalse(buttonsResponseHandler.exposedMatchesObject(null, null));
  }

  /**
   * Method under test: {@link ButtonsResponseHandler#getOrder()}
   */
  @Test
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(ResponseHandler.MEDIUM_PRIORITY, buttonsResponseHandler.getOrder());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ButtonsResponseHandler}
   *   <li>{@link ButtonsResponseHandler#setApplicationContext(ApplicationContext)}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws BeansException {
    // Arrange and Act
    ButtonsResponseHandler actualButtonsResponseHandler = new ButtonsResponseHandler();
    actualButtonsResponseHandler.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Assert
    assertEquals(ResponseHandler.MEDIUM_PRIORITY, actualButtonsResponseHandler.getOrder());
  }
}
