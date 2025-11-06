package org.finos.springbot.workflow.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.junit.jupiter.api.Test;

class WorkResponseDiffblueTest {
  /**
   * Method under test:
   * {@link WorkResponse#createEntityMap(Object, ButtonList, ErrorMap)}
   */
  @Test
  void testCreateEntityMap() {
    // Arrange
    ButtonList buttons = new ButtonList();
    ErrorMap errors = new ErrorMap();

    // Act
    Map<String, Object> actualCreateEntityMapResult = WorkResponse.createEntityMap("42", buttons, errors);

    // Assert
    assertEquals(3, actualCreateEntityMapResult.size());
    assertEquals("42", actualCreateEntityMapResult.get(WorkResponse.OBJECT_KEY));
    assertSame(buttons, actualCreateEntityMapResult.get("buttons"));
    assertSame(errors, actualCreateEntityMapResult.get(WorkResponse.ERRORS_KEY));
  }

  /**
   * Method under test:
   * {@link WorkResponse#createEntityMap(Object, ButtonList, ErrorMap)}
   */
  @Test
  void testCreateEntityMap2() {
    // Arrange and Act
    Map<String, Object> actualCreateEntityMapResult = WorkResponse.createEntityMap("42", null, null);

    // Assert
    assertEquals(3, actualCreateEntityMapResult.size());
    Object getResult = actualCreateEntityMapResult.get("buttons");
    Collection<Button> contents = ((ButtonList) getResult).getContents();
    assertTrue(contents instanceof List);
    assertTrue(getResult instanceof ButtonList);
    Object getResult2 = actualCreateEntityMapResult.get(WorkResponse.ERRORS_KEY);
    assertTrue(getResult2 instanceof ErrorMap);
    assertEquals("42", actualCreateEntityMapResult.get(WorkResponse.OBJECT_KEY));
    assertEquals(0, ((ButtonList) getResult).size());
    assertEquals(0, ((ErrorMap) getResult2).size());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult2).getContents().isEmpty());
  }

  /**
   * Method under test:
   * {@link WorkResponse#createEntityMapWithSummay(Object, ButtonList, ErrorMap, String)}
   */
  @Test
  void testCreateEntityMapWithSummay() {
    // Arrange
    ButtonList buttons = new ButtonList();
    ErrorMap errors = new ErrorMap();

    // Act
    Map<String, Object> actualCreateEntityMapWithSummayResult = WorkResponse.createEntityMapWithSummay("42", buttons,
        errors, "Summary");

    // Assert
    assertEquals(4, actualCreateEntityMapWithSummayResult.size());
    assertEquals("42", actualCreateEntityMapWithSummayResult.get(WorkResponse.OBJECT_KEY));
    assertEquals("Summary", actualCreateEntityMapWithSummayResult.get(WorkResponse.SUMMARY_KEY));
    assertSame(buttons, actualCreateEntityMapWithSummayResult.get("buttons"));
    assertSame(errors, actualCreateEntityMapWithSummayResult.get(WorkResponse.ERRORS_KEY));
  }

  /**
   * Method under test:
   * {@link WorkResponse#createEntityMapWithSummay(Object, ButtonList, ErrorMap, String)}
   */
  @Test
  void testCreateEntityMapWithSummay2() {
    // Arrange and Act
    Map<String, Object> actualCreateEntityMapWithSummayResult = WorkResponse.createEntityMapWithSummay("42", null, null,
        "Summary");

    // Assert
    assertEquals(4, actualCreateEntityMapWithSummayResult.size());
    Object getResult = actualCreateEntityMapWithSummayResult.get("buttons");
    Collection<Button> contents = ((ButtonList) getResult).getContents();
    assertTrue(contents instanceof List);
    assertTrue(getResult instanceof ButtonList);
    Object getResult2 = actualCreateEntityMapWithSummayResult.get(WorkResponse.ERRORS_KEY);
    assertTrue(getResult2 instanceof ErrorMap);
    assertEquals("42", actualCreateEntityMapWithSummayResult.get(WorkResponse.OBJECT_KEY));
    assertEquals("Summary", actualCreateEntityMapWithSummayResult.get(WorkResponse.SUMMARY_KEY));
    assertEquals(0, ((ButtonList) getResult).size());
    assertEquals(0, ((ErrorMap) getResult2).size());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult2).getContents().isEmpty());
  }

  /**
   * Method under test:
   * {@link WorkResponse#getTemplateNameForObject(WorkMode, Object)}
   */
  @Test
  void testGetTemplateNameForObject() {
    // Arrange, Act and Assert
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_VIEW, WorkResponse.getTemplateNameForObject(WorkMode.BOTH, "42"));
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_EDIT, WorkResponse.getTemplateNameForObject(WorkMode.EDIT, "42"));
  }

  /**
   * Method under test:
   * {@link WorkResponse#getTemplateNameForClass(WorkMode, Class)}
   */
  @Test
  void testGetTemplateNameForClass() {
    // Arrange
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_VIEW, WorkResponse.getTemplateNameForClass(WorkMode.BOTH, c));
  }

  /**
   * Method under test:
   * {@link WorkResponse#getTemplateNameForClass(WorkMode, Class)}
   */
  @Test
  void testGetTemplateNameForClass2() {
    // Arrange
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_EDIT, WorkResponse.getTemplateNameForClass(WorkMode.EDIT, c));
  }

  /**
   * Method under test: {@link WorkResponse#getData()}
   */
  @Test
  void testGetData() {
    // Arrange and Act
    Map<String, Object> actualData = (new WorkResponse(null, "42", WorkMode.BOTH)).getData();

    // Assert
    assertEquals(3, actualData.size());
    Object getResult = actualData.get("buttons");
    Collection<Button> contents = ((ButtonList) getResult).getContents();
    assertTrue(contents instanceof List);
    assertTrue(getResult instanceof ButtonList);
    Object getResult2 = actualData.get(WorkResponse.ERRORS_KEY);
    assertTrue(getResult2 instanceof ErrorMap);
    assertEquals("42", actualData.get(WorkResponse.OBJECT_KEY));
    assertEquals(0, ((ButtonList) getResult).size());
    assertEquals(0, ((ErrorMap) getResult2).size());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult2).getContents().isEmpty());
  }

  /**
   * Method under test: {@link WorkResponse#getFormObject()}
   */
  @Test
  void testGetFormObject() {
    // Arrange, Act and Assert
    assertEquals("42", (new WorkResponse(null, "42", WorkMode.BOTH)).getFormObject());
  }

  /**
   * Method under test: {@link WorkResponse#getButtons()}
   */
  @Test
  void testGetButtons() {
    // Arrange and Act
    ButtonList actualButtons = (new WorkResponse(null, "42", WorkMode.BOTH)).getButtons();

    // Assert
    Collection<Button> contents = actualButtons.getContents();
    assertTrue(contents instanceof List);
    assertEquals(0, actualButtons.size());
    assertTrue(contents.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link WorkResponse#WorkResponse(Addressable, Map, String, WorkMode, Class)}
   *   <li>{@link WorkResponse#toString()}
   *   <li>{@link WorkResponse#getFormClass()}
   *   <li>{@link WorkResponse#getMode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    Class<Object> formClass = Object.class;

    // Act
    WorkResponse actualWorkResponse = new WorkResponse(null, data, "Template Name", WorkMode.BOTH, formClass);
    String actualToStringResult = actualWorkResponse.toString();
    Class<?> actualFormClass = actualWorkResponse.getFormClass();
    WorkMode actualMode = actualWorkResponse.getMode();

    // Assert
    assertEquals("Template Name", actualWorkResponse.getTemplateName());
    assertEquals("WorkResponse [getData()={}, getTemplateName()=Template Name, getAddress()=null]",
        actualToStringResult);
    assertNull(actualWorkResponse.getAddress());
    assertEquals(WorkMode.BOTH, actualMode);
    Map<String, Object> data2 = actualWorkResponse.getData();
    assertTrue(data2.isEmpty());
    Class<Object> expectedFormClass = Object.class;
    assertEquals(expectedFormClass, actualFormClass);
    assertSame(data, data2);
    assertSame(formClass, actualFormClass);
  }

  /**
   * Method under test:
   * {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)}
   */
  @Test
  void testNewWorkResponse() {
    // Arrange and Act
    WorkResponse actualWorkResponse = new WorkResponse(null, "42", WorkMode.BOTH);

    // Assert
    ButtonList buttons = actualWorkResponse.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = actualWorkResponse.getData();
    assertEquals(3, data.size());
    Object getResult = data.get(WorkResponse.ERRORS_KEY);
    assertTrue(getResult instanceof ErrorMap);
    assertEquals("42", data.get(WorkResponse.OBJECT_KEY));
    assertEquals("42", actualWorkResponse.getFormObject());
    assertNull(actualWorkResponse.getAddress());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(WorkMode.BOTH, actualWorkResponse.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<String> expectedFormClass = String.class;
    assertEquals(expectedFormClass, actualWorkResponse.getFormClass());
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_VIEW, actualWorkResponse.getTemplateName());
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Method under test:
   * {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)}
   */
  @Test
  void testNewWorkResponse2() {
    // Arrange and Act
    WorkResponse actualWorkResponse = new WorkResponse(null, "42", WorkMode.EDIT);

    // Assert
    ButtonList buttons = actualWorkResponse.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = actualWorkResponse.getData();
    assertEquals(3, data.size());
    Object getResult = data.get(WorkResponse.ERRORS_KEY);
    assertTrue(getResult instanceof ErrorMap);
    assertEquals("42", data.get(WorkResponse.OBJECT_KEY));
    assertEquals("42", actualWorkResponse.getFormObject());
    assertNull(actualWorkResponse.getAddress());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(WorkMode.EDIT, actualWorkResponse.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<String> expectedFormClass = String.class;
    assertEquals(expectedFormClass, actualWorkResponse.getFormClass());
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_EDIT, actualWorkResponse.getTemplateName());
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Method under test:
   * {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode, String)}
   */
  @Test
  void testNewWorkResponse3() {
    // Arrange and Act
    WorkResponse actualWorkResponse = new WorkResponse(null, "42", WorkMode.BOTH, "Summary");

    // Assert
    ButtonList buttons = actualWorkResponse.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = actualWorkResponse.getData();
    assertEquals(4, data.size());
    Object getResult = data.get(WorkResponse.ERRORS_KEY);
    assertTrue(getResult instanceof ErrorMap);
    assertEquals("42", data.get(WorkResponse.OBJECT_KEY));
    assertEquals("42", actualWorkResponse.getFormObject());
    assertEquals("Summary", data.get(WorkResponse.SUMMARY_KEY));
    assertNull(actualWorkResponse.getAddress());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(WorkMode.BOTH, actualWorkResponse.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<String> expectedFormClass = String.class;
    assertEquals(expectedFormClass, actualWorkResponse.getFormClass());
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_VIEW, actualWorkResponse.getTemplateName());
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Method under test:
   * {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode, String)}
   */
  @Test
  void testNewWorkResponse4() {
    // Arrange and Act
    WorkResponse actualWorkResponse = new WorkResponse(null, "42", WorkMode.EDIT, "Summary");

    // Assert
    ButtonList buttons = actualWorkResponse.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = actualWorkResponse.getData();
    assertEquals(4, data.size());
    Object getResult = data.get(WorkResponse.ERRORS_KEY);
    assertTrue(getResult instanceof ErrorMap);
    assertEquals("42", data.get(WorkResponse.OBJECT_KEY));
    assertEquals("42", actualWorkResponse.getFormObject());
    assertEquals("Summary", data.get(WorkResponse.SUMMARY_KEY));
    assertNull(actualWorkResponse.getAddress());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(WorkMode.EDIT, actualWorkResponse.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<String> expectedFormClass = String.class;
    assertEquals(expectedFormClass, actualWorkResponse.getFormClass());
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_EDIT, actualWorkResponse.getTemplateName());
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Method under test:
   * {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode, ButtonList, ErrorMap)}
   */
  @Test
  void testNewWorkResponse5() {
    // Arrange
    ButtonList buttons = new ButtonList();
    ErrorMap errors = new ErrorMap();

    // Act
    WorkResponse actualWorkResponse = new WorkResponse(null, "42", WorkMode.BOTH, buttons, errors);

    // Assert
    Map<String, Object> data = actualWorkResponse.getData();
    assertEquals(3, data.size());
    assertEquals("42", data.get(WorkResponse.OBJECT_KEY));
    assertEquals("42", actualWorkResponse.getFormObject());
    assertNull(actualWorkResponse.getAddress());
    assertEquals(WorkMode.BOTH, actualWorkResponse.getMode());
    Class<String> expectedFormClass = String.class;
    assertEquals(expectedFormClass, actualWorkResponse.getFormClass());
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_VIEW, actualWorkResponse.getTemplateName());
    assertSame(buttons, data.get("buttons"));
    assertSame(buttons, actualWorkResponse.getButtons());
    assertSame(errors, data.get(WorkResponse.ERRORS_KEY));
  }

  /**
   * Method under test:
   * {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode, ButtonList, ErrorMap)}
   */
  @Test
  void testNewWorkResponse6() {
    // Arrange and Act
    WorkResponse actualWorkResponse = new WorkResponse(null, "42", WorkMode.EDIT, null, null);

    // Assert
    ButtonList buttons = actualWorkResponse.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = actualWorkResponse.getData();
    assertEquals(3, data.size());
    Object getResult = data.get(WorkResponse.ERRORS_KEY);
    assertTrue(getResult instanceof ErrorMap);
    assertEquals("42", data.get(WorkResponse.OBJECT_KEY));
    assertEquals("42", actualWorkResponse.getFormObject());
    assertNull(actualWorkResponse.getAddress());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(WorkMode.EDIT, actualWorkResponse.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<String> expectedFormClass = String.class;
    assertEquals(expectedFormClass, actualWorkResponse.getFormClass());
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_EDIT, actualWorkResponse.getTemplateName());
    assertSame(buttons, data.get("buttons"));
  }
}
