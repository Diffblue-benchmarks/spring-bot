package org.finos.springbot.workflow.java.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
import org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CollectionResponseConverter.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class CollectionResponseConverterDiffblueTest {
  @Autowired
  private CollectionResponseConverter collectionResponseConverter;

  @MockBean
  private ResponseHandlers responseHandlers;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CollectionResponseConverter#CollectionResponseConverter(ResponseHandlers)}
   *   <li>{@link CollectionResponseConverter#setApplicationContext(ApplicationContext)}
   *   <li>{@link CollectionResponseConverter#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CollectionResponseConverter.<init>(ResponseHandlers)",
      "int CollectionResponseConverter.getOrder()",
      "void CollectionResponseConverter.setApplicationContext(ApplicationContext)"})
  void testGettersAndSetters() throws BeansException {
    // Arrange and Act
    CollectionResponseConverter actualCollectionResponseConverter = new CollectionResponseConverter(
        mock(ResponseHandlers.class));
    actualCollectionResponseConverter.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Assert
    assertEquals(Integer.MAX_VALUE, actualCollectionResponseConverter.getOrder());
  }

  /**
   * Test {@link CollectionResponseConverter#accept(Object, ChatHandlerExecutor)} with {@code Object}, {@code ChatHandlerExecutor}.
   * <p>
   * Method under test: {@link CollectionResponseConverter#accept(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test accept(Object, ChatHandlerExecutor) with 'Object', 'ChatHandlerExecutor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CollectionResponseConverter.accept(Object, ChatHandlerExecutor)"})
  void testAcceptWithObjectChatHandlerExecutor() {
    // Arrange
    doThrow(new FactoryBeanNotInitializedException("Msg")).when(responseHandlers).accept(Mockito.<Response>any());

    // Act and Assert
    assertThrows(FactoryBeanNotInitializedException.class,
        () -> collectionResponseConverter.accept(mock(Response.class), mock(ChatHandlerExecutor.class)));
    verify(responseHandlers).accept(isA(Response.class));
  }

  /**
   * Test {@link CollectionResponseConverter#accept(Object, ChatHandlerExecutor)} with {@code Object}, {@code ChatHandlerExecutor}.
   * <ul>
   *   <li>Given {@link ResponseHandlers} {@link Consumer#accept(Object)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionResponseConverter#accept(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test accept(Object, ChatHandlerExecutor) with 'Object', 'ChatHandlerExecutor'; given ResponseHandlers accept(Object) does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CollectionResponseConverter.accept(Object, ChatHandlerExecutor)"})
  void testAcceptWithObjectChatHandlerExecutor_givenResponseHandlersAcceptDoesNothing() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    collectionResponseConverter.accept(mock(Response.class), mock(ChatHandlerExecutor.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
  }
}
