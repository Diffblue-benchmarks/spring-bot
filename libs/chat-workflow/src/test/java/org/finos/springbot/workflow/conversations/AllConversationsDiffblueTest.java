package org.finos.springbot.workflow.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getDelegates()}
   */
  @Test
  @DisplayName("Test getDelegates(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getDelegates()"})
  void testGetDelegates_thenReturnSizeIsOne() throws BeansException {
    // Arrange
    ClassPathXmlApplicationContext applicationContext = mock(ClassPathXmlApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(null);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});
    doNothing()
        .when(applicationContext)
        .addBeanFactoryPostProcessor(Mockito.<BeanFactoryPostProcessor>any());
    applicationContext.addBeanFactoryPostProcessor(new CustomAutowireConfigurer());

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);

    // Act
    List<PlatformConversations<Chat, User>> actualDelegates = allConversations.getDelegates();

    // Assert
    verify(applicationContext).addBeanFactoryPostProcessor(isA(BeanFactoryPostProcessor.class));
    verify(applicationContext).getBean(eq("Bean Names For Type"));
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
    ClassPathXmlApplicationContext applicationContext = mock(ClassPathXmlApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(null);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"foo", null});
    doNothing()
        .when(applicationContext)
        .addBeanFactoryPostProcessor(Mockito.<BeanFactoryPostProcessor>any());
    applicationContext.addBeanFactoryPostProcessor(new CustomAutowireConfigurer());

    AllConversations allConversations = new AllConversations();
    allConversations.setApplicationContext(applicationContext);

    // Act
    List<PlatformConversations<Chat, User>> actualDelegates = allConversations.getDelegates();

    // Assert
    verify(applicationContext).addBeanFactoryPostProcessor(isA(BeanFactoryPostProcessor.class));
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any());
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
    assertEquals(2, actualDelegates.size());
    assertNull(actualDelegates.get(0));
    assertNull(actualDelegates.get(1));
  }

  /**
   * Test {@link AllConversations#getAllAddressables()}.
   *
   * <p>Method under test: {@link AllConversations#getAllAddressables()}
   */
  @Test
  @DisplayName("Test getAllAddressables()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AllConversations.getAllAddressables()"})
  void testGetAllAddressables() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getAllAddressables().isEmpty());
  }

  /**
   * Test {@link AllConversations#getAllChats()}.
   *
   * <p>Method under test: {@link AllConversations#getAllChats()}
   */
  @Test
  @DisplayName("Test getAllChats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AllConversations.getAllChats()"})
  void testGetAllChats() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link AllConversations#getExistingChat(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getExistingChat(String)}
   */
  @Test
  @DisplayName("Test getExistingChat(String); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.getExistingChat(String)"})
  void testGetExistingChat_whenName() {
    // Arrange, Act and Assert
    assertNull(allConversations.getExistingChat("Name"));
  }

  /**
   * Test {@link AllConversations#getExistingChat(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getExistingChat(String)}
   */
  @Test
  @DisplayName("Test getExistingChat(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.getExistingChat(String)"})
  void testGetExistingChat_whenNull() {
    // Arrange, Act and Assert
    assertNull(allConversations.getExistingChat(null));
  }

  /**
   * Test {@link AllConversations#ensureChat(Chat, List, Map)}.
   *
   * <ul>
   *   <li>Given {@link User}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link User}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(Chat, List, Map); given User; when ArrayList() add User")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.ensureChat(Chat, List, Map)"})
  void testEnsureChat_givenUser_whenArrayListAddUser() {
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
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(Chat, List, Map); given User; when ArrayList() add User")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.ensureChat(Chat, List, Map)"})
  void testEnsureChat_givenUser_whenArrayListAddUser2() {
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
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(Chat, List, Map); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.ensureChat(Chat, List, Map)"})
  void testEnsureChat_whenArrayList() {
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
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(Chat, List, Map); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.ensureChat(Chat, List, Map)"})
  void testEnsureChat_whenNull() {
    // Arrange
    ArrayList<User> users = new ArrayList<>();

    // Act and Assert
    assertNull(allConversations.ensureChat(null, users, new HashMap<>()));
  }

  /**
   * Test {@link AllConversations#getChatMembers(Chat)}.
   *
   * <ul>
   *   <li>When {@link Chat}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatMembers(Chat)}
   */
  @Test
  @DisplayName("Test getChatMembers(Chat); when Chat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getChatMembers(Chat)"})
  void testGetChatMembers_whenChat() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getChatMembers(mock(Chat.class)).isEmpty());
  }

  /**
   * Test {@link AllConversations#getChatMembers(Chat)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatMembers(Chat)}
   */
  @Test
  @DisplayName("Test getChatMembers(Chat); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getChatMembers(Chat)"})
  void testGetChatMembers_whenNull() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getChatMembers(null).isEmpty());
  }

  /**
   * Test {@link AllConversations#getChatAdmins(Chat)}.
   *
   * <ul>
   *   <li>When {@link Chat}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatAdmins(Chat)}
   */
  @Test
  @DisplayName("Test getChatAdmins(Chat); when Chat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getChatAdmins(Chat)"})
  void testGetChatAdmins_whenChat() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getChatAdmins(mock(Chat.class)).isEmpty());
  }

  /**
   * Test {@link AllConversations#getChatAdmins(Chat)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatAdmins(Chat)}
   */
  @Test
  @DisplayName("Test getChatAdmins(Chat); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllConversations.getChatAdmins(Chat)"})
  void testGetChatAdmins_whenNull() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getChatAdmins(null).isEmpty());
  }

  /**
   * Test {@link AllConversations#getUserById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User AllConversations.getUserById(String)"})
  void testGetUserById_when42() {
    // Arrange, Act and Assert
    assertNull(allConversations.getUserById("42"));
  }

  /**
   * Test {@link AllConversations#getUserById(String)}.
   *
   * <ul>
   *   <li>When {@code Id}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String); when 'Id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User AllConversations.getUserById(String)"})
  void testGetUserById_whenId() {
    // Arrange, Act and Assert
    assertNull(allConversations.getUserById("Id"));
  }

  /**
   * Test {@link AllConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.getChatById(String)"})
  void testGetChatById_when42() {
    // Arrange, Act and Assert
    assertNull(allConversations.getChatById("42"));
  }

  /**
   * Test {@link AllConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@code Id}.
   * </ul>
   *
   * <p>Method under test: {@link AllConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when 'Id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chat AllConversations.getChatById(String)"})
  void testGetChatById_whenId() {
    // Arrange, Act and Assert
    assertNull(allConversations.getChatById("Id"));
  }
}
