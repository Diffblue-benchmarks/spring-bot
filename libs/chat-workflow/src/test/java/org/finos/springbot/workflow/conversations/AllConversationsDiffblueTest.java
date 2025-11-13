package org.finos.springbot.workflow.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AllConversations.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class AllConversationsDiffblueTest {
  @Autowired private AllConversations allConversations;

  /**
   * Test {@link AllConversations#getDelegates()}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getDelegates()}
   */
  @Test
  @DisplayName("Test getDelegates(); given AllConversations; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getDelegates()"})
  void testGetDelegates_givenAllConversations_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getDelegates().isEmpty());
  }

  /**
   * Test {@link AllConversations#getDelegates()}.
   *
   * <ul>
   *   <li>Given {@link ApplicationContext} {@link ApplicationContext#getBean(String)} return {@code
   *       null}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getDelegates()}
   */
  @Test
  @DisplayName(
      "Test getDelegates(); given ApplicationContext getBean(String) return 'null'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getDelegates()"})
  void testGetDelegates_givenApplicationContextGetBeanReturnNull_thenReturnSizeIsOne()
      throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(null);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);

    // Act
    List<PlatformConversations<Chat, User>> actualDelegates = allConversations.getDelegates();

    // Assert
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
    assertEquals(1, actualDelegates.size());
    assertNull(actualDelegates.get(0));
  }

  /**
   * Test {@link AllConversations#getDelegates()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getDelegates()}
   */
  @Test
  @DisplayName("Test getDelegates(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getDelegates()"})
  void testGetDelegates_thenReturnSizeIsTwo() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(null);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"foo", null});

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);

    // Act
    List<PlatformConversations<Chat, User>> actualDelegates = allConversations.getDelegates();

    // Assert
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any());
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
    assertEquals(2, actualDelegates.size());
    assertNull(actualDelegates.get(0));
    assertNull(actualDelegates.get(1));
  }

  /**
   * Test {@link AllConversations#getDelegates()}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getDelegates()}
   */
  @Test
  @DisplayName("Test getDelegates(); then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getDelegates()"})
  void testGetDelegates_thenThrowFactoryBeanNotInitializedException() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(FactoryBeanNotInitializedException.class, () -> allConversations.getDelegates());
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link AllConversations#getAllAddressables()}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getAllAddressables()}
   */
  @Test
  @DisplayName("Test getAllAddressables(); given AllConversations; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AllConversations.getAllAddressables()"})
  void testGetAllAddressables_givenAllConversations_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getAllAddressables().isEmpty());
  }

  /**
   * Test {@link AllConversations#getAllAddressables()}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getAllAddressables()}
   */
  @Test
  @DisplayName("Test getAllAddressables(); then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AllConversations.getAllAddressables()"})
  void testGetAllAddressables_thenThrowFactoryBeanNotInitializedException() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class, () -> allConversations.getAllAddressables());
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link AllConversations#getAllChats()}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getAllChats()}
   */
  @Test
  @DisplayName("Test getAllChats(); given AllConversations; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AllConversations.getAllChats()"})
  void testGetAllChats_givenAllConversations_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link AllConversations#getAllChats()}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getAllChats()}
   */
  @Test
  @DisplayName("Test getAllChats(); then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AllConversations.getAllChats()"})
  void testGetAllChats_thenThrowFactoryBeanNotInitializedException() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(FactoryBeanNotInitializedException.class, () -> allConversations.getAllChats());
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link AllConversations#getExistingChat(String)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getExistingChat(String)}
   */
  @Test
  @DisplayName(
      "Test getExistingChat(String); given AllConversations; when 'Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.getExistingChat(String)"})
  void testGetExistingChat_givenAllConversations_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(allConversations.getExistingChat("Name"));
  }

  /**
   * Test {@link AllConversations#getExistingChat(String)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getExistingChat(String)}
   */
  @Test
  @DisplayName(
      "Test getExistingChat(String); given AllConversations; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.getExistingChat(String)"})
  void testGetExistingChat_givenAllConversations_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(allConversations.getExistingChat(null));
  }

  /**
   * Test {@link AllConversations#getExistingChat(String)}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getExistingChat(String)}
   */
  @Test
  @DisplayName("Test getExistingChat(String); then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.getExistingChat(String)"})
  void testGetExistingChat_thenThrowFactoryBeanNotInitializedException() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class, () -> allConversations.getExistingChat("Name"));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link AllConversations#ensureChat(Chat, List, Map)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(Chat, List, Map); given AllConversations; when ArrayList(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.ensureChat(Chat, List, Map)"})
  void testEnsureChat_givenAllConversations_whenArrayList_thenReturnNull() {
    // Arrange
    Chat r = mock(Chat.class);
    ArrayList<User> users = new ArrayList<>();

    // Act and Assert
    assertNull(allConversations.ensureChat(r, users, new HashMap<>()));
  }

  /**
   * Test {@link AllConversations#ensureChat(Chat, List, Map)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(Chat, List, Map); given AllConversations; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.ensureChat(Chat, List, Map)"})
  void testEnsureChat_givenAllConversations_whenNull_thenReturnNull() {
    // Arrange
    ArrayList<User> users = new ArrayList<>();

    // Act and Assert
    assertNull(allConversations.ensureChat(null, users, new HashMap<>()));
  }

  /**
   * Test {@link AllConversations#ensureChat(Chat, List, Map)}.
   *
   * <ul>
   *   <li>Given {@link User}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link User}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(Chat, List, Map); given User; when ArrayList() add User; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.ensureChat(Chat, List, Map)"})
  void testEnsureChat_givenUser_whenArrayListAddUser_thenReturnNull() {
    // Arrange
    Chat r = mock(Chat.class);

    ArrayList<User> users = new ArrayList<>();
    users.add(mock(User.class));

    // Act and Assert
    assertNull(allConversations.ensureChat(r, users, new HashMap<>()));
  }

  /**
   * Test {@link AllConversations#ensureChat(Chat, List, Map)}.
   *
   * <ul>
   *   <li>Given {@link User}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link User}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(Chat, List, Map); given User; when ArrayList() add User; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.ensureChat(Chat, List, Map)"})
  void testEnsureChat_givenUser_whenArrayListAddUser_thenReturnNull2() {
    // Arrange
    Chat r = mock(Chat.class);

    ArrayList<User> users = new ArrayList<>();
    users.add(mock(User.class));
    users.add(mock(User.class));

    // Act and Assert
    assertNull(allConversations.ensureChat(r, users, new HashMap<>()));
  }

  /**
   * Test {@link AllConversations#ensureChat(Chat, List, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(Chat, List, Map); then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.ensureChat(Chat, List, Map)"})
  void testEnsureChat_thenThrowFactoryBeanNotInitializedException() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);
    Chat r = mock(Chat.class);
    ArrayList<User> users = new ArrayList<>();

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> allConversations.ensureChat(r, users, new HashMap<>()));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link AllConversations#getChatMembers(Chat)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@link Chat}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatMembers(Chat)}
   */
  @Test
  @DisplayName("Test getChatMembers(Chat); given AllConversations; when Chat; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getChatMembers(Chat)"})
  void testGetChatMembers_givenAllConversations_whenChat_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getChatMembers(mock(Chat.class)).isEmpty());
  }

  /**
   * Test {@link AllConversations#getChatMembers(Chat)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatMembers(Chat)}
   */
  @Test
  @DisplayName("Test getChatMembers(Chat); given AllConversations; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getChatMembers(Chat)"})
  void testGetChatMembers_givenAllConversations_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getChatMembers(null).isEmpty());
  }

  /**
   * Test {@link AllConversations#getChatMembers(Chat)}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatMembers(Chat)}
   */
  @Test
  @DisplayName("Test getChatMembers(Chat); then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getChatMembers(Chat)"})
  void testGetChatMembers_thenThrowFactoryBeanNotInitializedException() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> allConversations.getChatMembers(mock(Chat.class)));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link AllConversations#getChatAdmins(Chat)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@link Chat}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatAdmins(Chat)}
   */
  @Test
  @DisplayName("Test getChatAdmins(Chat); given AllConversations; when Chat; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getChatAdmins(Chat)"})
  void testGetChatAdmins_givenAllConversations_whenChat_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getChatAdmins(mock(Chat.class)).isEmpty());
  }

  /**
   * Test {@link AllConversations#getChatAdmins(Chat)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatAdmins(Chat)}
   */
  @Test
  @DisplayName("Test getChatAdmins(Chat); given AllConversations; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getChatAdmins(Chat)"})
  void testGetChatAdmins_givenAllConversations_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getChatAdmins(null).isEmpty());
  }

  /**
   * Test {@link AllConversations#getChatAdmins(Chat)}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatAdmins(Chat)}
   */
  @Test
  @DisplayName("Test getChatAdmins(Chat); then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getChatAdmins(Chat)"})
  void testGetChatAdmins_thenThrowFactoryBeanNotInitializedException() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> allConversations.getChatAdmins(mock(Chat.class)));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link AllConversations#getUserById(String)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String); given AllConversations; when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User AllConversations.getUserById(String)"})
  void testGetUserById_givenAllConversations_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(allConversations.getUserById("42"));
  }

  /**
   * Test {@link AllConversations#getUserById(String)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@code Id}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String); given AllConversations; when 'Id'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User AllConversations.getUserById(String)"})
  void testGetUserById_givenAllConversations_whenId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(allConversations.getUserById("Id"));
  }

  /**
   * Test {@link AllConversations#getUserById(String)}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String); then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User AllConversations.getUserById(String)"})
  void testGetUserById_thenThrowFactoryBeanNotInitializedException() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class, () -> allConversations.getUserById("42"));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link AllConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); given AllConversations; when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.getChatById(String)"})
  void testGetChatById_givenAllConversations_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(allConversations.getChatById("42"));
  }

  /**
   * Test {@link AllConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>Given {@link AllConversations}.
   *   <li>When {@code Id}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); given AllConversations; when 'Id'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.getChatById(String)"})
  void testGetChatById_givenAllConversations_whenId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(allConversations.getChatById("Id"));
  }

  /**
   * Test {@link AllConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.getChatById(String)"})
  void testGetChatById_thenThrowFactoryBeanNotInitializedException() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class, () -> allConversations.getChatById("42"));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }
}
