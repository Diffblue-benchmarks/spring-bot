package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;

class UserWorkDiffblueTest {
  /**
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
  void testGettersAndSetters() {
    // Arrange and Act
    UserWork actualUserWork = new UserWork();
    actualUserWork.setB(null);
    actualUserWork.setS(null);
    User actualB = actualUserWork.getB();

    // Assert that nothing has changed
    assertNull(actualB);
    assertNull(actualUserWork.getS());
  }
}
