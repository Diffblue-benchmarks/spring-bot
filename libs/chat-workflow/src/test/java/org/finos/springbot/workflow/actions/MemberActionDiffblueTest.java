package org.finos.springbot.workflow.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.actions.MemberAction.Type;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MemberActionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MemberAction#MemberAction(Chat, User, Type, Object)}
   *   <li>{@link MemberAction#getData()}
   *   <li>{@link MemberAction#getType()}
   *   <li>{@link MemberAction#getUser()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MemberAction.<init>(Chat, User, Type, Object)", "Object MemberAction.getData()",
      "Type MemberAction.getType()", "User MemberAction.getUser()"})
  void testGettersAndSetters() {
    // Arrange
    Chat a = mock(Chat.class);
    User u = mock(User.class);

    // Act
    MemberAction actualMemberAction = new MemberAction(a, u, Type.ADDED, "42");
    Object actualData = actualMemberAction.getData();
    Type actualType = actualMemberAction.getType();
    User actualUser = actualMemberAction.getUser();

    // Assert
    assertEquals("42", actualData);
    assertEquals(Type.ADDED, actualType);
    assertSame(a, actualMemberAction.getAddressable());
    assertSame(u, actualUser);
  }
}
