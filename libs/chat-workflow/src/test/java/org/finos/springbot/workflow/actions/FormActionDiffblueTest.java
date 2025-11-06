package org.finos.springbot.workflow.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FormActionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FormAction#FormAction(Addressable, User, Object, String, Map)}
   *   <li>{@link FormAction#toString()}
   *   <li>{@link FormAction#getAction()}
   *   <li>{@link FormAction#getAddressable()}
   *   <li>{@link FormAction#getFormData()}
   *   <li>{@link FormAction#getUser()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FormAction.<init>(Addressable, User, Object, String, Map)", "String FormAction.getAction()",
      "Addressable FormAction.getAddressable()", "Object FormAction.getFormData()", "User FormAction.getUser()",
      "String FormAction.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    HashMap<String, Object> entityMap = new HashMap<>();

    // Act
    FormAction actualFormAction = new FormAction(a, u, "Form Data", "Action", entityMap);
    String actualToStringResult = actualFormAction.toString();
    String actualAction = actualFormAction.getAction();
    Addressable actualAddressable = actualFormAction.getAddressable();
    Object actualFormData = actualFormAction.getFormData();
    User actualUser = actualFormAction.getUser();

    // Assert
    assertEquals("Action", actualAction);
    assertEquals("Form Data", actualFormData);
    assertEquals("FormAction [formData=Form Data, action=Action, entityMap={}]", actualToStringResult);
    Map<String, Object> data = actualFormAction.getData();
    assertTrue(data.isEmpty());
    assertSame(entityMap, data);
    assertSame(a, actualAddressable);
    assertSame(u, actualUser);
  }

  /**
   * Test {@link FormAction#getData()}.
   * <p>
   * Method under test: {@link FormAction#getData()}
   */
  @Test
  @DisplayName("Test getData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map FormAction.getData()"})
  void testGetData() {
    // Arrange
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);

    // Act and Assert
    assertTrue((new FormAction(a, u, "Form Data", "Action", new HashMap<>())).getData().isEmpty());
  }
}
