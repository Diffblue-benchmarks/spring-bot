package org.finos.springbot.workflow.java.mapping;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.annotations.ChatButton;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.java.converters.ResponseConverters;
import org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ChatButtonChatHandlerMapping.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AbstractSpringComponentHandlerMappingDiffblueTest {
  @Autowired
  private AbstractSpringComponentHandlerMapping<ChatButton> abstractSpringComponentHandlerMapping;

  @MockBean
  private AllConversations allConversations;

  @MockBean
  private ResponseConverters responseConverters;

  @MockBean
  private WorkflowResolversFactory workflowResolversFactory;

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#getCandidateBeanNames()}.
   * <p>
   * Method under test: {@link AbstractSpringComponentHandlerMapping#getCandidateBeanNames()}
   */
  @Test
  @DisplayName("Test getCandidateBeanNames()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] AbstractSpringComponentHandlerMapping.getCandidateBeanNames()"})
  void testGetCandidateBeanNames() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"org.springframework.context.annotation.internalConfigurationAnnotationProcessor",
        "org.springframework.context.annotation.internalAutowiredAnnotationProcessor",
        "org.springframework.context.annotation.internalCommonAnnotationProcessor",
        "org.springframework.context.event.internalEventListenerProcessor",
        "org.springframework.context.event.internalEventListenerFactory", "chatButtonChatHandlerMapping",
        "org.springframework.boot.test.mock.mockito.MockitoPostProcessor$SpyPostProcessor",
        "org.springframework.boot.test.mock.mockito.MockitoPostProcessor",
        "org.springframework.test.context.support.internalDynamicPropertyRegistrarBeanInitializer",
        "org.finos.springbot.workflow.conversations.AllConversations#0",
        "org.finos.springbot.workflow.java.converters.ResponseConverters#0",
        "org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory#0",
        "org.springframework.boot.test.context.filter.TestTypeExcludeFilter",
        "org.springframework.boot.test.web.reactor.netty.DisableReactorResourceFactoryGlobalResourcesBeanPos"
            + "tProcessor",
        "autoConfigurationReport",
        "org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer$PropertyMapp"
            + "ingCheckBeanPostProcessor",
        "environment", "systemProperties", "systemEnvironment", "applicationStartup",
        "org.springframework.context.annotation.ConfigurationClassPostProcessor.importRegistry",
        "org.springframework.boot.test.mock.mockito.MockitoBeans", "messageSource", "applicationEventMulticaster",
        "lifecycleProcessor"}, abstractSpringComponentHandlerMapping.getCandidateBeanNames());
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#getHandlerMethods()}.
   * <p>
   * Method under test: {@link AbstractSpringComponentHandlerMapping#getHandlerMethods()}
   */
  @Test
  @DisplayName("Test getHandlerMethods()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map AbstractSpringComponentHandlerMapping.getHandlerMethods()"})
  void testGetHandlerMethods() {
    // Arrange, Act and Assert
    assertTrue(abstractSpringComponentHandlerMapping.getHandlerMethods().isEmpty());
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>When array of {@link String} with {@code Name}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}
   */
  @Test
  @DisplayName("Test roomMatched(String[], Chat); given 'Name'; when array of String with 'Name'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSpringComponentHandlerMapping.roomMatched(String[], Chat)"})
  void testRoomMatched_givenName_whenArrayOfStringWithName_thenReturnTrue() {
    // Arrange
    Chat addressable = mock(Chat.class);
    when(addressable.getName()).thenReturn("Name");

    // Act
    boolean actualRoomMatchedResult = abstractSpringComponentHandlerMapping.roomMatched(new String[]{"Name"},
        addressable);

    // Assert
    verify(addressable).getName();
    assertTrue(actualRoomMatchedResult);
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>When array of {@link String} with {@code Rooms}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}
   */
  @Test
  @DisplayName("Test roomMatched(String[], Chat); given 'Name'; when array of String with 'Rooms'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSpringComponentHandlerMapping.roomMatched(String[], Chat)"})
  void testRoomMatched_givenName_whenArrayOfStringWithRooms_thenReturnFalse() {
    // Arrange
    Chat addressable = mock(Chat.class);
    when(addressable.getName()).thenReturn("Name");

    // Act
    boolean actualRoomMatchedResult = abstractSpringComponentHandlerMapping.roomMatched(new String[]{"Rooms"},
        addressable);

    // Assert
    verify(addressable).getName();
    assertFalse(actualRoomMatchedResult);
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}
   */
  @Test
  @DisplayName("Test roomMatched(String[], Chat); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSpringComponentHandlerMapping.roomMatched(String[], Chat)"})
  void testRoomMatched_thenThrowIllegalStateException() {
    // Arrange
    Chat addressable = mock(Chat.class);
    when(addressable.getName()).thenThrow(new IllegalStateException("Rooms"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> abstractSpringComponentHandlerMapping.roomMatched(new String[]{"Rooms"}, addressable));
    verify(addressable).getName();
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[], String[], boolean)}.
   * <ul>
   *   <li>When array of {@link String} with {@code Include Rooms}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[], String[], boolean)}
   */
  @Test
  @DisplayName("Test canBePerformed(Addressable, User, String[], String[], boolean); when array of String with 'Include Rooms'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean AbstractSpringComponentHandlerMapping.canBePerformed(Addressable, User, String[], String[], boolean)"})
  void testCanBePerformed_whenArrayOfStringWithIncludeRooms_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(abstractSpringComponentHandlerMapping.canBePerformed(mock(Addressable.class), mock(User.class),
        new String[]{"Exclude Rooms"}, new String[]{"Include Rooms"}, true));
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[], String[], boolean)}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[], String[], boolean)}
   */
  @Test
  @DisplayName("Test canBePerformed(Addressable, User, String[], String[], boolean); when empty array of String; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean AbstractSpringComponentHandlerMapping.canBePerformed(Addressable, User, String[], String[], boolean)"})
  void testCanBePerformed_whenEmptyArrayOfString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(abstractSpringComponentHandlerMapping.canBePerformed(mock(Addressable.class), mock(User.class),
        new String[]{"Exclude Rooms"}, new String[]{}, true));
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[], String[], boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[], String[], boolean)}
   */
  @Test
  @DisplayName("Test canBePerformed(Addressable, User, String[], String[], boolean); when 'false'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean AbstractSpringComponentHandlerMapping.canBePerformed(Addressable, User, String[], String[], boolean)"})
  void testCanBePerformed_whenFalse_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(abstractSpringComponentHandlerMapping.canBePerformed(mock(Addressable.class), mock(User.class),
        new String[]{"Exclude Rooms"}, new String[]{}, false));
  }
}
