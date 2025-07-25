package org.finos.springbot.workflow.java.mapping;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.springbot.workflow.annotations.ChatButton;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.java.converters.ResponseConverters;
import org.finos.springbot.workflow.java.mapping.AbstractSpringComponentHandlerMapping.MappingRegistry;
import org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory;
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

@ContextConfiguration(classes = {ChatButtonChatHandlerMapping.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class AbstractSpringComponentHandlerMappingDiffblueTest {
  @Autowired
  private AbstractSpringComponentHandlerMapping<ChatButton> abstractSpringComponentHandlerMapping;

  @MockitoBean private AllConversations allConversations;

  @MockitoBean private ResponseConverters responseConverters;

  @MockitoBean private WorkflowResolversFactory workflowResolversFactory;

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#getHandlerMethods()}.
   *
   * <p>Method under test: {@link AbstractSpringComponentHandlerMapping#getHandlerMethods()}
   */
  @Test
  @DisplayName("Test getHandlerMethods()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map AbstractSpringComponentHandlerMapping.getHandlerMethods()"})
  void testGetHandlerMethods() {
    // Arrange, Act and Assert
    assertTrue(abstractSpringComponentHandlerMapping.getHandlerMethods().isEmpty());
  }

  /**
   * Test MappingRegistry getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MappingRegistry#MappingRegistry(AbstractSpringComponentHandlerMapping)}
   *   <li>{@link MappingRegistry#getRegistrations()}
   * </ul>
   */
  @Test
  @DisplayName("Test MappingRegistry getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingRegistry.<init>(AbstractSpringComponentHandlerMapping)",
    "java.util.Map MappingRegistry.getRegistrations()"
  })
  void testMappingRegistryGettersAndSetters() {
    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);

    // Act and Assert
    assertTrue(
        new ChatButtonChatHandlerMapping(wrf, converters, new AllConversations())
            .new MappingRegistry()
            .getRegistrations()
            .isEmpty());
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When array of {@link String} with {@code Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}
   */
  @Test
  @DisplayName(
      "Test roomMatched(String[], Chat); given 'Name'; when array of String with 'Name'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractSpringComponentHandlerMapping.roomMatched(String[], Chat)"})
  void testRoomMatched_givenName_whenArrayOfStringWithName_thenReturnTrue() {
    // Arrange
    Chat addressable = mock(Chat.class);
    when(addressable.getName()).thenReturn("Name");

    // Act
    boolean actualRoomMatchedResult =
        abstractSpringComponentHandlerMapping.roomMatched(new String[] {"Name"}, addressable);

    // Assert
    verify(addressable).getName();
    assertTrue(actualRoomMatchedResult);
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When array of {@link String} with {@code Rooms}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}
   */
  @Test
  @DisplayName(
      "Test roomMatched(String[], Chat); given 'Name'; when array of String with 'Rooms'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractSpringComponentHandlerMapping.roomMatched(String[], Chat)"})
  void testRoomMatched_givenName_whenArrayOfStringWithRooms_thenReturnFalse() {
    // Arrange
    Chat addressable = mock(Chat.class);
    when(addressable.getName()).thenReturn("Name");

    // Act
    boolean actualRoomMatchedResult =
        abstractSpringComponentHandlerMapping.roomMatched(new String[] {"Rooms"}, addressable);

    // Assert
    verify(addressable).getName();
    assertFalse(actualRoomMatchedResult);
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}
   */
  @Test
  @DisplayName("Test roomMatched(String[], Chat); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractSpringComponentHandlerMapping.roomMatched(String[], Chat)"})
  void testRoomMatched_thenThrowIllegalStateException() {
    // Arrange
    Chat addressable = mock(Chat.class);
    when(addressable.getName()).thenThrow(new IllegalStateException("Rooms"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            abstractSpringComponentHandlerMapping.roomMatched(new String[] {"Rooms"}, addressable));
    verify(addressable).getName();
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[],
   * String[], boolean)}.
   *
   * <p>Method under test: {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable,
   * User, String[], String[], boolean)}
   */
  @Test
  @DisplayName("Test canBePerformed(Addressable, User, String[], String[], boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractSpringComponentHandlerMapping.canBePerformed(Addressable, User, String[], String[], boolean)"
  })
  void testCanBePerformed() {
    // Arrange
    when(allConversations.getChatAdmins(Mockito.<Chat>any()))
        .thenThrow(new IllegalStateException("Include Rooms"));
    Chat a = mock(Chat.class);
    when(a.getName()).thenReturn("Include Rooms");

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            abstractSpringComponentHandlerMapping.canBePerformed(
                a,
                mock(User.class),
                new String[] {"Exclude Rooms"},
                new String[] {"Include Rooms"},
                true));
    verify(a, atLeast(1)).getName();
    verify(allConversations).getChatAdmins(isA(Chat.class));
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[],
   * String[], boolean)}.
   *
   * <p>Method under test: {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable,
   * User, String[], String[], boolean)}
   */
  @Test
  @DisplayName("Test canBePerformed(Addressable, User, String[], String[], boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractSpringComponentHandlerMapping.canBePerformed(Addressable, User, String[], String[], boolean)"
  })
  void testCanBePerformed2() {
    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);

    // Act and Assert
    assertTrue(
        new ChatButtonChatHandlerMapping(wrf, converters, new AllConversations())
            .canBePerformed(
                mock(Addressable.class),
                mock(User.class),
                new String[] {"Exclude Rooms"},
                new String[] {},
                true));
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[],
   * String[], boolean)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations} {@link AllConversations#getChatAdmins(Chat)} return {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable,
   * User, String[], String[], boolean)}
   */
  @Test
  @DisplayName(
      "Test canBePerformed(Addressable, User, String[], String[], boolean); given AllConversations getChatAdmins(Chat) return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractSpringComponentHandlerMapping.canBePerformed(Addressable, User, String[], String[], boolean)"
  })
  void testCanBePerformed_givenAllConversationsGetChatAdminsReturnArrayList() {
    // Arrange
    when(allConversations.getChatAdmins(Mockito.<Chat>any())).thenReturn(new ArrayList<>());
    Chat a = mock(Chat.class);
    when(a.getName()).thenReturn("Include Rooms");

    // Act
    boolean actualCanBePerformedResult =
        abstractSpringComponentHandlerMapping.canBePerformed(
            a,
            mock(User.class),
            new String[] {"Exclude Rooms"},
            new String[] {"Include Rooms"},
            true);

    // Assert
    verify(a, atLeast(1)).getName();
    verify(allConversations).getChatAdmins(isA(Chat.class));
    assertFalse(actualCanBePerformedResult);
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[],
   * String[], boolean)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@link Addressable}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable,
   * User, String[], String[], boolean)}
   */
  @Test
  @DisplayName(
      "Test canBePerformed(Addressable, User, String[], String[], boolean); given AllConversations; when Addressable; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractSpringComponentHandlerMapping.canBePerformed(Addressable, User, String[], String[], boolean)"
  })
  void testCanBePerformed_givenAllConversations_whenAddressable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        abstractSpringComponentHandlerMapping.canBePerformed(
            mock(Addressable.class),
            mock(User.class),
            new String[] {"Exclude Rooms"},
            new String[] {"Include Rooms"},
            true));
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[],
   * String[], boolean)}.
   *
   * <ul>
   *   <li>Given {@code Exclude Rooms}.
   *   <li>When {@link Chat} {@link Chat#getName()} return {@code Exclude Rooms}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable,
   * User, String[], String[], boolean)}
   */
  @Test
  @DisplayName(
      "Test canBePerformed(Addressable, User, String[], String[], boolean); given 'Exclude Rooms'; when Chat getName() return 'Exclude Rooms'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractSpringComponentHandlerMapping.canBePerformed(Addressable, User, String[], String[], boolean)"
  })
  void testCanBePerformed_givenExcludeRooms_whenChatGetNameReturnExcludeRooms() {
    // Arrange
    Chat a = mock(Chat.class);
    when(a.getName()).thenReturn("Exclude Rooms");

    // Act
    boolean actualCanBePerformedResult =
        abstractSpringComponentHandlerMapping.canBePerformed(
            a,
            mock(User.class),
            new String[] {"Exclude Rooms"},
            new String[] {"Include Rooms"},
            false);

    // Assert
    verify(a).getName();
    assertFalse(actualCanBePerformedResult);
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[],
   * String[], boolean)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException(String)} with {@code Exclude
   *       Rooms}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable,
   * User, String[], String[], boolean)}
   */
  @Test
  @DisplayName(
      "Test canBePerformed(Addressable, User, String[], String[], boolean); given IllegalStateException(String) with 'Exclude Rooms'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractSpringComponentHandlerMapping.canBePerformed(Addressable, User, String[], String[], boolean)"
  })
  void testCanBePerformed_givenIllegalStateExceptionWithExcludeRooms() {
    // Arrange
    Chat a = mock(Chat.class);
    when(a.getName()).thenThrow(new IllegalStateException("Exclude Rooms"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            abstractSpringComponentHandlerMapping.canBePerformed(
                a,
                mock(User.class),
                new String[] {"Exclude Rooms"},
                new String[] {"Include Rooms"},
                false));
    verify(a).getName();
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[],
   * String[], boolean)}.
   *
   * <ul>
   *   <li>Given {@code Include Rooms}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable,
   * User, String[], String[], boolean)}
   */
  @Test
  @DisplayName(
      "Test canBePerformed(Addressable, User, String[], String[], boolean); given 'Include Rooms'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractSpringComponentHandlerMapping.canBePerformed(Addressable, User, String[], String[], boolean)"
  })
  void testCanBePerformed_givenIncludeRooms_thenReturnTrue() {
    // Arrange
    Chat a = mock(Chat.class);
    when(a.getName()).thenReturn("Include Rooms");

    // Act
    boolean actualCanBePerformedResult =
        abstractSpringComponentHandlerMapping.canBePerformed(
            a,
            mock(User.class),
            new String[] {"Exclude Rooms"},
            new String[] {"Include Rooms"},
            false);

    // Assert
    verify(a, atLeast(1)).getName();
    assertTrue(actualCanBePerformedResult);
  }

  /**
   * Test {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[],
   * String[], boolean)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Chat} {@link Chat#getName()} return {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable,
   * User, String[], String[], boolean)}
   */
  @Test
  @DisplayName(
      "Test canBePerformed(Addressable, User, String[], String[], boolean); given 'Name'; when Chat getName() return 'Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractSpringComponentHandlerMapping.canBePerformed(Addressable, User, String[], String[], boolean)"
  })
  void testCanBePerformed_givenName_whenChatGetNameReturnName_thenReturnFalse() {
    // Arrange
    Chat a = mock(Chat.class);
    when(a.getName()).thenReturn("Name");

    // Act
    boolean actualCanBePerformedResult =
        abstractSpringComponentHandlerMapping.canBePerformed(
            a,
            mock(User.class),
            new String[] {"Exclude Rooms"},
            new String[] {"Include Rooms"},
            false);

    // Assert
    verify(a, atLeast(1)).getName();
    assertFalse(actualCanBePerformedResult);
  }
}
