package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserWorkDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UserWork}
   *   <li>{@link UserWork#setB(User)}
   *   <li>{@link UserWork#setS(User)}
   *   <li>{@link UserWork#getB()}
   *   <li>{@link UserWork#getS()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserWork.<init>()", "User UserWork.getB()", "User UserWork.getS()",
      "void UserWork.setB(User)", "void UserWork.setS(User)"})
  void testGettersAndSetters() {
    // Arrange and Act
    UserWork actualUserWork = new UserWork();
    User b = mock(User.class);
    actualUserWork.setB(b);
    User s = mock(User.class);
    actualUserWork.setS(s);
    User actualB = actualUserWork.getB();

    // Assert
    assertSame(b, actualB);
    assertSame(s, actualUserWork.getS());
  }
}
