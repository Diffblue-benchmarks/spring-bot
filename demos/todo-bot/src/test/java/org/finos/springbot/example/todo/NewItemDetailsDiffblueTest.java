package org.finos.springbot.example.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;

class NewItemDetailsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NewItemDetails}
   *   <li>{@link NewItemDetails#setAssignTo(User)}
   *   <li>{@link NewItemDetails#setDescription(String)}
   *   <li>{@link NewItemDetails#getAssignTo()}
   *   <li>{@link NewItemDetails#getDescription()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NewItemDetails actualNewItemDetails = new NewItemDetails();
    SymphonyUser assignTo = new SymphonyUser(1L);
    actualNewItemDetails.setAssignTo(assignTo);
    actualNewItemDetails.setDescription("The characteristics of someone or something");
    User actualAssignTo = actualNewItemDetails.getAssignTo();

    // Assert that nothing has changed
    assertEquals("The characteristics of someone or something", actualNewItemDetails.getDescription());
    assertSame(assignTo, actualAssignTo);
  }
}
