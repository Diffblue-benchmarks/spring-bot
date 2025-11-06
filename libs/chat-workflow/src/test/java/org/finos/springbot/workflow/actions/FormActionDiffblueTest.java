package org.finos.springbot.workflow.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;

class FormActionDiffblueTest {
  /**
   * Method under test: {@link FormAction#getData()}
   */
  @Test
  void testGetData() {
    // Arrange
    HashMap<String, Object> entityMap = new HashMap<>();

    // Act
    Map<String, Object> actualData = (new FormAction(null, null, "Form Data", "Action", entityMap)).getData();

    // Assert
    assertTrue(actualData.isEmpty());
    assertSame(entityMap, actualData);
  }

  /**
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
  void testGettersAndSetters() {
    // Arrange
    HashMap<String, Object> entityMap = new HashMap<>();

    // Act
    FormAction actualFormAction = new FormAction(null, null, "Form Data", "Action", entityMap);
    String actualToStringResult = actualFormAction.toString();
    String actualAction = actualFormAction.getAction();
    Addressable actualAddressable = actualFormAction.getAddressable();
    Object actualFormData = actualFormAction.getFormData();

    // Assert
    assertEquals("Action", actualAction);
    assertEquals("Form Data", actualFormData);
    assertEquals("FormAction [formData=Form Data, action=Action, entityMap={}]", actualToStringResult);
    assertNull(actualAddressable);
    assertNull(actualFormAction.getUser());
    Map<String, Object> data = actualFormAction.getData();
    assertTrue(data.isEmpty());
    assertSame(entityMap, data);
  }
}
