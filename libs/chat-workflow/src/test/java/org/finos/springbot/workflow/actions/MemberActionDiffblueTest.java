package org.finos.springbot.workflow.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;

class MemberActionDiffblueTest {
  /**
   * Method under test: {@link MemberAction#getAddressable()}
   */
  @Test
  void testGetAddressable() {
    // Arrange, Act and Assert
    assertNull((new MemberAction(null, null, MemberAction.Type.ADDED, "42")).getAddressable());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MemberAction#MemberAction(Chat, User, MemberAction.Type, Object)}
   *   <li>{@link MemberAction#getData()}
   *   <li>{@link MemberAction#getType()}
   *   <li>{@link MemberAction#getUser()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MemberAction actualMemberAction = new MemberAction(null, null, MemberAction.Type.ADDED, "42");
    Object actualData = actualMemberAction.getData();
    MemberAction.Type actualType = actualMemberAction.getType();
    User actualUser = actualMemberAction.getUser();

    // Assert
    assertEquals("42", actualData);
    assertNull(actualMemberAction.getAddressable());
    assertNull(actualUser);
    assertEquals(MemberAction.Type.ADDED, actualType);
  }
}
