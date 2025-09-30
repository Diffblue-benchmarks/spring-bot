package org.finos.springbot.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.help.HelpPage;
import org.finos.springbot.workflow.java.converters.ResponseConverters;
import org.finos.springbot.workflow.java.mapping.ChatButtonChatHandlerMapping;
import org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomHelpController.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class CustomHelpControllerDiffblueTest {
  @Autowired private CustomHelpController customHelpController;

  /**
   * Test {@link CustomHelpController#handleHelp(Addressable, User)}.
   *
   * <p>Method under test: {@link CustomHelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName("Test handleHelp(Addressable, User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HelpPage CustomHelpController.handleHelp(Addressable, User)"})
  void testHandleHelp() throws BeansException {
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

    CustomHelpController customHelpController = new CustomHelpController();
    customHelpController.setApplicationContext(applicationContext);
    Addressable a = mock(Addressable.class);

    // Act
    HelpPage actualHandleHelpResult = customHelpController.handleHelp(a, new SymphonyUser(1L));

    // Assert
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(ResolvableType.class));
    assertTrue(actualHandleHelpResult.getCommands().isEmpty());
  }

  /**
   * Test {@link CustomHelpController#handleHelp(Addressable, User)}.
   *
   * <p>Method under test: {@link CustomHelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName("Test handleHelp(Addressable, User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HelpPage CustomHelpController.handleHelp(Addressable, User)"})
  void testHandleHelp2() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);

    ChatButtonChatHandlerMapping chatButtonChatHandlerMapping =
        new ChatButtonChatHandlerMapping(wrf, converters, new AllConversations());
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenReturn(chatButtonChatHandlerMapping);
    when(applicationContext.getBeanNamesForType(Mockito.<ResolvableType>any()))
        .thenReturn(new String[] {"foo", "42"});

    CustomHelpController customHelpController = new CustomHelpController();
    customHelpController.setApplicationContext(applicationContext);
    Addressable a = mock(Addressable.class);

    // Act
    HelpPage actualHandleHelpResult = customHelpController.handleHelp(a, new SymphonyUser(1L));

    // Assert
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any());
    verify(applicationContext).getBeanNamesForType(isA(ResolvableType.class));
    assertTrue(actualHandleHelpResult.getCommands().isEmpty());
  }

  /**
   * Test {@link CustomHelpController#handleHelp(Addressable, User)}.
   *
   * <ul>
   *   <li>Given {@link CustomHelpController}.
   *   <li>When {@link SymphonyUser#SymphonyUser(long)} with userId is one.
   * </ul>
   *
   * <p>Method under test: {@link CustomHelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName(
      "Test handleHelp(Addressable, User); given CustomHelpController; when SymphonyUser(long) with userId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HelpPage CustomHelpController.handleHelp(Addressable, User)"})
  void testHandleHelp_givenCustomHelpController_whenSymphonyUserWithUserIdIsOne() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act and Assert
    assertTrue(customHelpController.handleHelp(a, new SymphonyUser(1L)).getCommands().isEmpty());
  }

  /**
   * Test {@link CustomHelpController#handleHelp(Addressable, User)}.
   *
   * <ul>
   *   <li>Given {@link CustomHelpController}.
   *   <li>When {@link SymphonyUser#SymphonyUser(long)} with userId is two.
   * </ul>
   *
   * <p>Method under test: {@link CustomHelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName(
      "Test handleHelp(Addressable, User); given CustomHelpController; when SymphonyUser(long) with userId is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HelpPage CustomHelpController.handleHelp(Addressable, User)"})
  void testHandleHelp_givenCustomHelpController_whenSymphonyUserWithUserIdIsTwo() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act and Assert
    assertTrue(customHelpController.handleHelp(a, new SymphonyUser(2L)).getCommands().isEmpty());
  }
}
