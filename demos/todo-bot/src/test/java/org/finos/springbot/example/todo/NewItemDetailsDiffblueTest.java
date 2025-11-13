package org.finos.springbot.example.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NewItemDetailsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NewItemDetails}
   *   <li>{@link NewItemDetails#setAssignTo(User)}
   *   <li>{@link NewItemDetails#setDescription(String)}
   *   <li>{@link NewItemDetails#getAssignTo()}
   *   <li>{@link NewItemDetails#getDescription()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NewItemDetails.<init>()",
    "User NewItemDetails.getAssignTo()",
    "String NewItemDetails.getDescription()",
    "void NewItemDetails.setAssignTo(User)",
    "void NewItemDetails.setDescription(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NewItemDetails actualNewItemDetails = new NewItemDetails();
    SymphonyUser assignTo = new SymphonyUser();
    actualNewItemDetails.setAssignTo(assignTo);
    actualNewItemDetails.setDescription("The characteristics of someone or something");
    User actualAssignTo = actualNewItemDetails.getAssignTo();

    // Assert
    assertEquals(
        "The characteristics of someone or something", actualNewItemDetails.getDescription());
    assertSame(assignTo, actualAssignTo);
  }
}
