package org.finos.springbot.workflow.conversations;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AllConversations.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AllConversationsDiffblueTest {
  @Autowired
  private AllConversations allConversations;

  /**
   * Method under test: {@link AllConversations#getDelegates()}
   */
  @Test
  void testGetDelegates() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getDelegates().isEmpty());
  }

  /**
   * Method under test: {@link AllConversations#getAllAddressables()}
   */
  @Test
  void testGetAllAddressables() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getAllAddressables().isEmpty());
  }

  /**
   * Method under test: {@link AllConversations#getAllChats()}
   */
  @Test
  void testGetAllChats() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getAllChats().isEmpty());
  }

  /**
   * Method under test: {@link AllConversations#getExistingChat(String)}
   */
  @Test
  void testGetExistingChat() {
    // Arrange, Act and Assert
    assertNull(allConversations.getExistingChat("Name"));
  }

  /**
   * Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  void testEnsureChat() {
    // Arrange
    ArrayList<User> users = new ArrayList<>();

    // Act and Assert
    assertNull(allConversations.ensureChat(null, users, new HashMap<>()));
  }

  /**
   * Method under test: {@link AllConversations#ensureChat(Chat, List, Map)}
   */
  @Test
  void testEnsureChat2() {
    // Arrange
    ArrayList<User> users = new ArrayList<>();

    HashMap<String, Object> meta = new HashMap<>();
    meta.put("foo", "42");

    // Act and Assert
    assertNull(allConversations.ensureChat(null, users, meta));
  }

  /**
   * Method under test: {@link AllConversations#getChatMembers(Chat)}
   */
  @Test
  void testGetChatMembers() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getChatMembers(null).isEmpty());
  }

  /**
   * Method under test: {@link AllConversations#getChatAdmins(Chat)}
   */
  @Test
  void testGetChatAdmins() {
    // Arrange, Act and Assert
    assertTrue(allConversations.getChatAdmins(null).isEmpty());
  }

  /**
   * Method under test: {@link AllConversations#getUserById(String)}
   */
  @Test
  void testGetUserById() {
    // Arrange, Act and Assert
    assertNull(allConversations.getUserById("42"));
  }

  /**
   * Method under test: {@link AllConversations#getChatById(String)}
   */
  @Test
  void testGetChatById() {
    // Arrange, Act and Assert
    assertNull(allConversations.getChatById("42"));
  }
}
