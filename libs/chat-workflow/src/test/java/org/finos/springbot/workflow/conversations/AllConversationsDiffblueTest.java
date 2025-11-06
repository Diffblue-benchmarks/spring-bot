package org.finos.springbot.workflow.conversations;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AllConversations.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class AllConversationsDiffblueTest {
  @Autowired
  private AllConversations allConversations;

  /**
   * Test {@link AllConversations#getDelegates()}.
   * <p>
   * Method under test: {@link AllConversations#getDelegates()}
   */
  @Test
  @DisplayName("Test getDelegates()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AllConversations.getDelegates()"})
  void testGetDelegates() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getDelegates().isEmpty());
  }

  /**
   * Test {@link AllConversations#getAllAddressables()}.
   * <p>
   * Method under test: {@link AllConversations#getAllAddressables()}
   */
  @Test
  @DisplayName("Test getAllAddressables()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set AllConversations.getAllAddressables()"})
  void testGetAllAddressables() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getAllAddressables().isEmpty());
  }

  /**
   * Test {@link AllConversations#getAllChats()}.
   * <p>
   * Method under test: {@link AllConversations#getAllChats()}
   */
  @Test
  @DisplayName("Test getAllChats()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set AllConversations.getAllChats()"})
  void testGetAllChats() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link AllConversations#getExistingChat(String)}.
   * <p>
   * Method under test: {@link AllConversations#getExistingChat(String)}
   */
  @Test
  @DisplayName("Test getExistingChat(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Chat AllConversations.getExistingChat(String)"})
  void testGetExistingChat() {
    // Arrange, Act and Assert
    assertNull(allConversations.getExistingChat("Name"));
  }

  /**
   * Test {@link AllConversations#ensureChat(Chat, List, Map)}.
   * <ul>
   *   <li>Given {@link User}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link User}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(Chat, List, Map); given User; when ArrayList() add User")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link User}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link User}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(Chat, List, Map); given User; when ArrayList() add User")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(Chat, List, Map); when ArrayList()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(Chat, List, Map); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Chat AllConversations.ensureChat(Chat, List, Map)"})
  void testEnsureChat_whenNull() {
    // Arrange
    ArrayList<User> users = new ArrayList<>();

    // Act and Assert
    assertNull(allConversations.ensureChat(null, users, new HashMap<>()));
  }

  /**
   * Test {@link AllConversations#getChatMembers(Chat)}.
   * <p>
   * Method under test: {@link AllConversations#getChatMembers(Chat)}
   */
  @Test
  @DisplayName("Test getChatMembers(Chat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AllConversations.getChatMembers(Chat)"})
  void testGetChatMembers() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getChatMembers(mock(Chat.class)).isEmpty());
  }

  /**
   * Test {@link AllConversations#getChatAdmins(Chat)}.
   * <p>
   * Method under test: {@link AllConversations#getChatAdmins(Chat)}
   */
  @Test
  @DisplayName("Test getChatAdmins(Chat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AllConversations.getChatAdmins(Chat)"})
  void testGetChatAdmins() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getChatAdmins(mock(Chat.class)).isEmpty());
  }

  /**
   * Test {@link AllConversations#getUserById(String)}.
   * <p>
   * Method under test: {@link AllConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"User AllConversations.getUserById(String)"})
  void testGetUserById() {
    // Arrange, Act and Assert
    assertNull(allConversations.getUserById("42"));
  }

  /**
   * Test {@link AllConversations#getChatById(String)}.
   * <p>
   * Method under test: {@link AllConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Chat AllConversations.getChatById(String)"})
  void testGetChatById() {
    // Arrange, Act and Assert
    assertNull(allConversations.getChatById("42"));
  }
}
