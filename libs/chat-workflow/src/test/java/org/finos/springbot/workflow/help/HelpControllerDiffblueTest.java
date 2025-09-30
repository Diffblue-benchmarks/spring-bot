package org.finos.springbot.workflow.help;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.finos.springbot.workflow.annotations.ChatRequest;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.java.converters.ResponseConverters;
import org.finos.springbot.workflow.java.mapping.ChatButtonChatHandlerMapping;
import org.finos.springbot.workflow.java.mapping.ChatHandlerMapping;
import org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {HelpController.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class HelpControllerDiffblueTest {
  @Autowired private HelpController helpController;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link HelpController}
   *   <li>{@link HelpController#setApplicationContext(ApplicationContext)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HelpController.<init>()",
    "void HelpController.setApplicationContext(ApplicationContext)"
  })
  void testGettersAndSetters() throws BeansException {
    // Arrange and Act
    HelpController actualHelpController = new HelpController();
    actualHelpController.setApplicationContext(mock(ApplicationContext.class));

    // Assert
    assertNull(actualHelpController.exposedHandlers);
  }

  /**
   * Test {@link HelpController#handleHelp(Addressable, User)}.
   *
   * <ul>
   *   <li>Given {@link HelpController}.
   *   <li>When {@link Addressable}.
   *   <li>Then return Commands Empty.
   * </ul>
   *
   * <p>Method under test: {@link HelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName(
      "Test handleHelp(Addressable, User); given HelpController; when Addressable; then return Commands Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.help.HelpPage HelpController.handleHelp(Addressable, User)"
  })
  void testHandleHelp_givenHelpController_whenAddressable_thenReturnCommandsEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        helpController
            .handleHelp(mock(Addressable.class), mock(User.class))
            .getCommands()
            .isEmpty());
    assertTrue(helpController.exposedHandlers.isEmpty());
  }

  /**
   * Test {@link HelpController#handleHelp(Addressable, User)}.
   *
   * <ul>
   *   <li>Given {@link HelpController}.
   *   <li>When {@code null}.
   *   <li>Then return Commands Empty.
   * </ul>
   *
   * <p>Method under test: {@link HelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName(
      "Test handleHelp(Addressable, User); given HelpController; when 'null'; then return Commands Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.help.HelpPage HelpController.handleHelp(Addressable, User)"
  })
  void testHandleHelp_givenHelpController_whenNull_thenReturnCommandsEmpty() {
    // Arrange, Act and Assert
    assertTrue(helpController.handleHelp(null, mock(User.class)).getCommands().isEmpty());
    assertTrue(helpController.exposedHandlers.isEmpty());
  }

  /**
   * Test {@link HelpController#handleHelp(Addressable, User)}.
   *
   * <ul>
   *   <li>Then {@link HelpController} (default constructor) {@link HelpController#exposedHandlers}
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link HelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName(
      "Test handleHelp(Addressable, User); then HelpController (default constructor) exposedHandlers size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.help.HelpPage HelpController.handleHelp(Addressable, User)"
  })
  void testHandleHelp_thenHelpControllerExposedHandlersSizeIsOne() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);

    ChatButtonChatHandlerMapping chatButtonChatHandlerMapping =
        new ChatButtonChatHandlerMapping(wrf, converters, new AllConversations());
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenReturn(chatButtonChatHandlerMapping);
    when(applicationContext.getBeanNamesForType(Mockito.<ResolvableType>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    HelpController helpController = new HelpController();
    helpController.setApplicationContext(applicationContext);

    // Act
    helpController.handleHelp(mock(Addressable.class), mock(User.class));

    // Assert
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(ResolvableType.class));
    List<ChatHandlerMapping<ChatRequest>> chatHandlerMappingList = helpController.exposedHandlers;
    assertEquals(1, chatHandlerMappingList.size());
    assertSame(chatButtonChatHandlerMapping, chatHandlerMappingList.get(0));
  }

  /**
   * Test {@link HelpController#handleHelp(Addressable, User)}.
   *
   * <ul>
   *   <li>Then {@link HelpController} (default constructor) {@link HelpController#exposedHandlers}
   *       size is two.
   * </ul>
   *
   * <p>Method under test: {@link HelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName(
      "Test handleHelp(Addressable, User); then HelpController (default constructor) exposedHandlers size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.help.HelpPage HelpController.handleHelp(Addressable, User)"
  })
  void testHandleHelp_thenHelpControllerExposedHandlersSizeIsTwo() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);

    ChatButtonChatHandlerMapping chatButtonChatHandlerMapping =
        new ChatButtonChatHandlerMapping(wrf, converters, new AllConversations());
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenReturn(chatButtonChatHandlerMapping);
    when(applicationContext.getBeanNamesForType(Mockito.<ResolvableType>any()))
        .thenReturn(new String[] {"foo", null});

    HelpController helpController = new HelpController();
    helpController.setApplicationContext(applicationContext);

    // Act
    helpController.handleHelp(mock(Addressable.class), mock(User.class));

    // Assert
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any());
    verify(applicationContext).getBeanNamesForType(isA(ResolvableType.class));
    List<ChatHandlerMapping<ChatRequest>> chatHandlerMappingList = helpController.exposedHandlers;
    assertEquals(2, chatHandlerMappingList.size());
    assertSame(chatButtonChatHandlerMapping, chatHandlerMappingList.get(0));
    assertSame(chatButtonChatHandlerMapping, chatHandlerMappingList.get(1));
  }

  /**
   * Test {@link HelpController#handleHelp(Addressable, User)}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link HelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName("Test handleHelp(Addressable, User); then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.help.HelpPage HelpController.handleHelp(Addressable, User)"
  })
  void testHandleHelp_thenThrowFactoryBeanNotInitializedException() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));
    when(applicationContext.getBeanNamesForType(Mockito.<ResolvableType>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    HelpController helpController = new HelpController();
    helpController.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> helpController.handleHelp(mock(Addressable.class), mock(User.class)));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(ResolvableType.class));
  }

  /**
   * Test {@link HelpController#initExposedHandlers()}.
   *
   * <ul>
   *   <li>Then {@link HelpController} {@link HelpController#exposedHandlers} Empty.
   * </ul>
   *
   * <p>Method under test: {@link HelpController#initExposedHandlers()}
   */
  @Test
  @DisplayName("Test initExposedHandlers(); then HelpController exposedHandlers Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpController.initExposedHandlers()"})
  void testInitExposedHandlers_thenHelpControllerExposedHandlersEmpty() {
    // Arrange and Act
    helpController.initExposedHandlers();

    // Assert
    assertTrue(helpController.exposedHandlers.isEmpty());
  }

  /**
   * Test {@link HelpController#initExposedHandlers()}.
   *
   * <ul>
   *   <li>Then {@link HelpController} (default constructor) {@link HelpController#exposedHandlers}
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link HelpController#initExposedHandlers()}
   */
  @Test
  @DisplayName(
      "Test initExposedHandlers(); then HelpController (default constructor) exposedHandlers size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpController.initExposedHandlers()"})
  void testInitExposedHandlers_thenHelpControllerExposedHandlersSizeIsOne() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);

    ChatButtonChatHandlerMapping chatButtonChatHandlerMapping =
        new ChatButtonChatHandlerMapping(wrf, converters, new AllConversations());
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenReturn(chatButtonChatHandlerMapping);
    when(applicationContext.getBeanNamesForType(Mockito.<ResolvableType>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    HelpController helpController = new HelpController();
    helpController.setApplicationContext(applicationContext);

    // Act
    helpController.initExposedHandlers();

    // Assert
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(ResolvableType.class));
    List<ChatHandlerMapping<ChatRequest>> chatHandlerMappingList = helpController.exposedHandlers;
    assertEquals(1, chatHandlerMappingList.size());
    assertSame(chatButtonChatHandlerMapping, chatHandlerMappingList.get(0));
  }

  /**
   * Test {@link HelpController#initExposedHandlers()}.
   *
   * <ul>
   *   <li>Then {@link HelpController} (default constructor) {@link HelpController#exposedHandlers}
   *       size is two.
   * </ul>
   *
   * <p>Method under test: {@link HelpController#initExposedHandlers()}
   */
  @Test
  @DisplayName(
      "Test initExposedHandlers(); then HelpController (default constructor) exposedHandlers size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpController.initExposedHandlers()"})
  void testInitExposedHandlers_thenHelpControllerExposedHandlersSizeIsTwo() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);

    ChatButtonChatHandlerMapping chatButtonChatHandlerMapping =
        new ChatButtonChatHandlerMapping(wrf, converters, new AllConversations());
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenReturn(chatButtonChatHandlerMapping);
    when(applicationContext.getBeanNamesForType(Mockito.<ResolvableType>any()))
        .thenReturn(new String[] {"foo", null});

    HelpController helpController = new HelpController();
    helpController.setApplicationContext(applicationContext);

    // Act
    helpController.initExposedHandlers();

    // Assert
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any());
    verify(applicationContext).getBeanNamesForType(isA(ResolvableType.class));
    List<ChatHandlerMapping<ChatRequest>> chatHandlerMappingList = helpController.exposedHandlers;
    assertEquals(2, chatHandlerMappingList.size());
    assertSame(chatButtonChatHandlerMapping, chatHandlerMappingList.get(0));
    assertSame(chatButtonChatHandlerMapping, chatHandlerMappingList.get(1));
  }

  /**
   * Test {@link HelpController#initExposedHandlers()}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link HelpController#initExposedHandlers()}
   */
  @Test
  @DisplayName("Test initExposedHandlers(); then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpController.initExposedHandlers()"})
  void testInitExposedHandlers_thenThrowFactoryBeanNotInitializedException() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));
    when(applicationContext.getBeanNamesForType(Mockito.<ResolvableType>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    HelpController helpController = new HelpController();
    helpController.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class, () -> helpController.initExposedHandlers());
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(ResolvableType.class));
  }
}
