package org.finos.springbot.workflow.java.converters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
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
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CollectionResponseConverter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class CollectionResponseConverterDiffblueTest {
  @Autowired private CollectionResponseConverter collectionResponseConverter;

  @MockitoBean private ResponseHandlers responseHandlers;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CollectionResponseConverter#CollectionResponseConverter(ResponseHandlers)}
   *   <li>{@link CollectionResponseConverter#setApplicationContext(ApplicationContext)}
   *   <li>{@link CollectionResponseConverter#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CollectionResponseConverter.<init>(ResponseHandlers)",
    "int CollectionResponseConverter.getOrder()",
    "void CollectionResponseConverter.setApplicationContext(ApplicationContext)"
  })
  void testGettersAndSetters() throws BeansException {
    // Arrange and Act
    CollectionResponseConverter actualCollectionResponseConverter =
        new CollectionResponseConverter(mock(ResponseHandlers.class));
    actualCollectionResponseConverter.setApplicationContext(mock(ApplicationContext.class));

    // Assert
    assertEquals(Integer.MAX_VALUE, actualCollectionResponseConverter.getOrder());
  }

  /**
   * Test {@link CollectionResponseConverter#accept(Object, ChatHandlerExecutor)} with {@code
   * Object}, {@code ChatHandlerExecutor}.
   *
   * <p>Method under test: {@link CollectionResponseConverter#accept(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test accept(Object, ChatHandlerExecutor) with 'Object', 'ChatHandlerExecutor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CollectionResponseConverter.accept(Object, ChatHandlerExecutor)"})
  void testAcceptWithObjectChatHandlerExecutor() {
    // Arrange
    doThrow(new FactoryBeanNotInitializedException())
        .when(responseHandlers)
        .accept(Mockito.<Response>any());

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () ->
            collectionResponseConverter.accept(
                mock(Response.class), mock(ChatHandlerExecutor.class)));
    verify(responseHandlers).accept(isA(Response.class));
  }

  /**
   * Test {@link CollectionResponseConverter#accept(Object, ChatHandlerExecutor)} with {@code
   * Object}, {@code ChatHandlerExecutor}.
   *
   * <ul>
   *   <li>Given {@link ResponseHandlers} {@link ResponseHandlers#accept(Object)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link CollectionResponseConverter#accept(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName(
      "Test accept(Object, ChatHandlerExecutor) with 'Object', 'ChatHandlerExecutor'; given ResponseHandlers accept(Object) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CollectionResponseConverter.accept(Object, ChatHandlerExecutor)"})
  void testAcceptWithObjectChatHandlerExecutor_givenResponseHandlersAcceptDoesNothing() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    collectionResponseConverter.accept(mock(Response.class), mock(ChatHandlerExecutor.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
  }

  /**
   * Test {@link CollectionResponseConverter#accept(Object, ChatHandlerExecutor)} with {@code
   * Object}, {@code ChatHandlerExecutor}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationContext#getBean(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionResponseConverter#accept(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName(
      "Test accept(Object, ChatHandlerExecutor) with 'Object', 'ChatHandlerExecutor'; then calls getBean(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CollectionResponseConverter.accept(Object, ChatHandlerExecutor)"})
  void testAcceptWithObjectChatHandlerExecutor_thenCallsGetBean() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(ResponseConverters.class))
        .thenReturn(mock(ResponseConverters.class));

    CollectionResponseConverter collectionResponseConverter =
        new CollectionResponseConverter(mock(ResponseHandlers.class));
    collectionResponseConverter.setApplicationContext(applicationContext);

    // Act
    collectionResponseConverter.accept(new ArrayList<>(), mock(ChatHandlerExecutor.class));

    // Assert
    verify(applicationContext).getBean(isA(Class.class));
  }

  /**
   * Test {@link CollectionResponseConverter#accept(Object, ChatHandlerExecutor)} with {@code
   * Object}, {@code ChatHandlerExecutor}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CollectionResponseConverter#accept(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName(
      "Test accept(Object, ChatHandlerExecutor) with 'Object', 'ChatHandlerExecutor'; when '42'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CollectionResponseConverter.accept(Object, ChatHandlerExecutor)"})
  void testAcceptWithObjectChatHandlerExecutor_when42_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> collectionResponseConverter.accept("42", mock(ChatHandlerExecutor.class)));
  }
}
