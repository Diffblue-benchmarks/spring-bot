package org.finos.springbot.workflow.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WorkResponseDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WorkResponse#WorkResponse(Addressable, Map, String, WorkMode, Class)}
   *   <li>{@link WorkResponse#toString()}
   *   <li>{@link WorkResponse#getFormClass()}
   *   <li>{@link WorkResponse#getMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WorkResponse.<init>(Addressable, Map, String, WorkMode, Class)",
    "Class WorkResponse.getFormClass()",
    "WorkMode WorkResponse.getMode()",
    "String WorkResponse.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Addressable resultTo = mock(Addressable.class);
    HashMap<String, Object> data = new HashMap<>();
    Class<Object> formClass = Object.class;

    // Act
    WorkResponse actualWorkResponse =
        new WorkResponse(resultTo, data, "Template Name", WorkMode.BOTH, formClass);
    actualWorkResponse.toString();
    Class<?> actualFormClass = actualWorkResponse.getFormClass();
    WorkMode actualMode = actualWorkResponse.getMode();

    // Assert
    assertEquals("Template Name", actualWorkResponse.getTemplateName());
    assertEquals(WorkMode.BOTH, actualMode);
    Map<String, Object> data2 = actualWorkResponse.getData();
    assertTrue(data2.isEmpty());
    Class<Object> expectedFormClass = Object.class;
    assertEquals(expectedFormClass, actualFormClass);
    assertSame(data, data2);
    assertSame(formClass, actualFormClass);
    assertSame(resultTo, actualWorkResponse.getAddress());
  }

  /**
   * Test {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Mode is {@code BOTH}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)}
   */
  @Test
  @DisplayName(
      "Test new WorkResponse(Addressable, Object, WorkMode); when '42'; then return Mode is 'BOTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorkResponse.<init>(Addressable, Object, WorkMode)"})
  void testNewWorkResponse_when42_thenReturnModeIsBoth() {
    // Arrange
    Addressable resultTo = mock(Addressable.class);

    // Act
    WorkResponse actualWorkResponse = new WorkResponse(resultTo, "42", WorkMode.BOTH);

    // Assert
    ButtonList buttons = actualWorkResponse.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = actualWorkResponse.getData();
    assertEquals(3, data.size());
    assertTrue(data.get(WorkResponse.ERRORS_KEY) instanceof ErrorMap);
    assertEquals("42", data.get(WorkResponse.OBJECT_KEY));
    assertEquals("42", actualWorkResponse.getFormObject());
    assertEquals(0, buttons.size());
    assertEquals(WorkMode.BOTH, actualWorkResponse.getMode());
    assertTrue(contents.isEmpty());
    Class<String> expectedFormClass = String.class;
    assertEquals(expectedFormClass, actualWorkResponse.getFormClass());
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_VIEW, actualWorkResponse.getTemplateName());
    assertSame(buttons, data.get("buttons"));
    assertSame(resultTo, actualWorkResponse.getAddress());
  }

  /**
   * Test {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Mode is {@code BOTH}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode, String)}
   */
  @Test
  @DisplayName(
      "Test new WorkResponse(Addressable, Object, WorkMode, String); when '42'; then return Mode is 'BOTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorkResponse.<init>(Addressable, Object, WorkMode, String)"})
  void testNewWorkResponse_when42_thenReturnModeIsBoth2() {
    // Arrange
    Addressable resultTo = mock(Addressable.class);

    // Act
    WorkResponse actualWorkResponse = new WorkResponse(resultTo, "42", WorkMode.BOTH, "Summary");

    // Assert
    ButtonList buttons = actualWorkResponse.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = actualWorkResponse.getData();
    assertEquals(4, data.size());
    assertTrue(data.get(WorkResponse.ERRORS_KEY) instanceof ErrorMap);
    assertEquals("42", data.get(WorkResponse.OBJECT_KEY));
    assertEquals("42", actualWorkResponse.getFormObject());
    assertEquals("Summary", data.get(WorkResponse.SUMMARY_KEY));
    assertEquals(0, buttons.size());
    assertEquals(WorkMode.BOTH, actualWorkResponse.getMode());
    assertTrue(contents.isEmpty());
    Class<String> expectedFormClass = String.class;
    assertEquals(expectedFormClass, actualWorkResponse.getFormClass());
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_VIEW, actualWorkResponse.getTemplateName());
    assertSame(buttons, data.get("buttons"));
    assertSame(resultTo, actualWorkResponse.getAddress());
  }

  /**
   * Test {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode, ButtonList, ErrorMap)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Mode is {@code BOTH}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode,
   * ButtonList, ErrorMap)}
   */
  @Test
  @DisplayName(
      "Test new WorkResponse(Addressable, Object, WorkMode, ButtonList, ErrorMap); when '42'; then return Mode is 'BOTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WorkResponse.<init>(Addressable, Object, WorkMode, ButtonList, ErrorMap)"
  })
  void testNewWorkResponse_when42_thenReturnModeIsBoth3() {
    // Arrange
    Addressable resultTo = mock(Addressable.class);
    ButtonList buttons = new ButtonList();
    ErrorMap errors = new ErrorMap();

    // Act
    WorkResponse actualWorkResponse =
        new WorkResponse(resultTo, "42", WorkMode.BOTH, buttons, errors);

    // Assert
    Map<String, Object> data = actualWorkResponse.getData();
    assertEquals(3, data.size());
    assertEquals(WorkMode.BOTH, actualWorkResponse.getMode());
    assertTrue(data.containsKey(WorkResponse.OBJECT_KEY));
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_VIEW, actualWorkResponse.getTemplateName());
    assertSame(buttons, data.get("buttons"));
    assertSame(buttons, actualWorkResponse.getButtons());
    assertSame(errors, data.get(WorkResponse.ERRORS_KEY));
  }

  /**
   * Test {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode, ButtonList, ErrorMap)}.
   *
   * <ul>
   *   <li>When {@link WorkMode#EDIT}.
   *   <li>Then Buttons Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode,
   * ButtonList, ErrorMap)}
   */
  @Test
  @DisplayName(
      "Test new WorkResponse(Addressable, Object, WorkMode, ButtonList, ErrorMap); when EDIT; then Buttons Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WorkResponse.<init>(Addressable, Object, WorkMode, ButtonList, ErrorMap)"
  })
  void testNewWorkResponse_whenEdit_thenButtonsContentsReturnList() {
    // Arrange
    Addressable resultTo = mock(Addressable.class);

    // Act
    WorkResponse actualWorkResponse = new WorkResponse(resultTo, "42", WorkMode.EDIT, null, null);

    // Assert
    ButtonList buttons = actualWorkResponse.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = actualWorkResponse.getData();
    assertEquals(3, data.size());
    assertTrue(data.get(WorkResponse.ERRORS_KEY) instanceof ErrorMap);
    assertEquals("42", data.get(WorkResponse.OBJECT_KEY));
    assertEquals("42", actualWorkResponse.getFormObject());
    assertEquals(0, buttons.size());
    assertEquals(WorkMode.EDIT, actualWorkResponse.getMode());
    assertTrue(contents.isEmpty());
    Class<String> expectedFormClass = String.class;
    assertEquals(expectedFormClass, actualWorkResponse.getFormClass());
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_EDIT, actualWorkResponse.getTemplateName());
    assertSame(buttons, data.get("buttons"));
    assertSame(resultTo, actualWorkResponse.getAddress());
  }

  /**
   * Test {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)}.
   *
   * <ul>
   *   <li>When {@link WorkMode#EDIT}.
   *   <li>Then return Mode is {@code EDIT}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)}
   */
  @Test
  @DisplayName(
      "Test new WorkResponse(Addressable, Object, WorkMode); when EDIT; then return Mode is 'EDIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorkResponse.<init>(Addressable, Object, WorkMode)"})
  void testNewWorkResponse_whenEdit_thenReturnModeIsEdit() {
    // Arrange
    Addressable resultTo = mock(Addressable.class);

    // Act
    WorkResponse actualWorkResponse = new WorkResponse(resultTo, "42", WorkMode.EDIT);

    // Assert
    ButtonList buttons = actualWorkResponse.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = actualWorkResponse.getData();
    assertEquals(3, data.size());
    assertTrue(data.get(WorkResponse.ERRORS_KEY) instanceof ErrorMap);
    assertEquals("42", data.get(WorkResponse.OBJECT_KEY));
    assertEquals("42", actualWorkResponse.getFormObject());
    assertEquals(0, buttons.size());
    assertEquals(WorkMode.EDIT, actualWorkResponse.getMode());
    assertTrue(contents.isEmpty());
    Class<String> expectedFormClass = String.class;
    assertEquals(expectedFormClass, actualWorkResponse.getFormClass());
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_EDIT, actualWorkResponse.getTemplateName());
    assertSame(buttons, data.get("buttons"));
    assertSame(resultTo, actualWorkResponse.getAddress());
  }

  /**
   * Test {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode, String)}.
   *
   * <ul>
   *   <li>When {@link WorkMode#EDIT}.
   *   <li>Then return Mode is {@code EDIT}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode, String)}
   */
  @Test
  @DisplayName(
      "Test new WorkResponse(Addressable, Object, WorkMode, String); when EDIT; then return Mode is 'EDIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorkResponse.<init>(Addressable, Object, WorkMode, String)"})
  void testNewWorkResponse_whenEdit_thenReturnModeIsEdit2() {
    // Arrange
    Addressable resultTo = mock(Addressable.class);

    // Act
    WorkResponse actualWorkResponse = new WorkResponse(resultTo, "42", WorkMode.EDIT, "Summary");

    // Assert
    ButtonList buttons = actualWorkResponse.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = actualWorkResponse.getData();
    assertEquals(4, data.size());
    assertTrue(data.get(WorkResponse.ERRORS_KEY) instanceof ErrorMap);
    assertEquals("42", data.get(WorkResponse.OBJECT_KEY));
    assertEquals("42", actualWorkResponse.getFormObject());
    assertEquals("Summary", data.get(WorkResponse.SUMMARY_KEY));
    assertEquals(0, buttons.size());
    assertEquals(WorkMode.EDIT, actualWorkResponse.getMode());
    assertTrue(contents.isEmpty());
    Class<String> expectedFormClass = String.class;
    assertEquals(expectedFormClass, actualWorkResponse.getFormClass());
    assertEquals(WorkResponse.DEFAULT_FORM_TEMPLATE_EDIT, actualWorkResponse.getTemplateName());
    assertSame(buttons, data.get("buttons"));
    assertSame(resultTo, actualWorkResponse.getAddress());
  }

  /**
   * Test {@link WorkResponse#createEntityMap(Object, ButtonList, ErrorMap)}.
   *
   * <ul>
   *   <li>When {@link ButtonList#ButtonList()}.
   *   <li>Then return {@code buttons} is {@link ButtonList#ButtonList()}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#createEntityMap(Object, ButtonList, ErrorMap)}
   */
  @Test
  @DisplayName(
      "Test createEntityMap(Object, ButtonList, ErrorMap); when ButtonList(); then return 'buttons' is ButtonList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map WorkResponse.createEntityMap(Object, ButtonList, ErrorMap)"})
  void testCreateEntityMap_whenButtonList_thenReturnButtonsIsButtonList() {
    // Arrange
    ButtonList buttons = new ButtonList();
    ErrorMap errors = new ErrorMap();

    // Act
    Map<String, Object> actualCreateEntityMapResult =
        WorkResponse.createEntityMap("42", buttons, errors);

    // Assert
    assertEquals(3, actualCreateEntityMapResult.size());
    assertEquals("42", actualCreateEntityMapResult.get(WorkResponse.OBJECT_KEY));
    assertSame(buttons, actualCreateEntityMapResult.get("buttons"));
    assertSame(errors, actualCreateEntityMapResult.get(WorkResponse.ERRORS_KEY));
  }

  /**
   * Test {@link WorkResponse#createEntityMap(Object, ButtonList, ErrorMap)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@code buttons} Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#createEntityMap(Object, ButtonList, ErrorMap)}
   */
  @Test
  @DisplayName(
      "Test createEntityMap(Object, ButtonList, ErrorMap); when 'null'; then 'buttons' Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map WorkResponse.createEntityMap(Object, ButtonList, ErrorMap)"})
  void testCreateEntityMap_whenNull_thenButtonsContentsReturnList() {
    // Arrange and Act
    Map<String, Object> actualCreateEntityMapResult =
        WorkResponse.createEntityMap("42", null, null);

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
   * Test {@link WorkResponse#createEntityMapWithSummay(Object, ButtonList, ErrorMap, String)}.
   *
   * <ul>
   *   <li>When {@link ButtonList#ButtonList()}.
   *   <li>Then return {@code buttons} is {@link ButtonList#ButtonList()}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#createEntityMapWithSummay(Object, ButtonList,
   * ErrorMap, String)}
   */
  @Test
  @DisplayName(
      "Test createEntityMapWithSummay(Object, ButtonList, ErrorMap, String); when ButtonList(); then return 'buttons' is ButtonList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map WorkResponse.createEntityMapWithSummay(Object, ButtonList, ErrorMap, String)"
  })
  void testCreateEntityMapWithSummay_whenButtonList_thenReturnButtonsIsButtonList() {
    // Arrange
    ButtonList buttons = new ButtonList();
    ErrorMap errors = new ErrorMap();

    // Act
    Map<String, Object> actualCreateEntityMapWithSummayResult =
        WorkResponse.createEntityMapWithSummay("42", buttons, errors, "Summary");

    // Assert
    assertEquals(4, actualCreateEntityMapWithSummayResult.size());
    assertEquals("42", actualCreateEntityMapWithSummayResult.get(WorkResponse.OBJECT_KEY));
    assertEquals("Summary", actualCreateEntityMapWithSummayResult.get(WorkResponse.SUMMARY_KEY));
    assertSame(buttons, actualCreateEntityMapWithSummayResult.get("buttons"));
    assertSame(errors, actualCreateEntityMapWithSummayResult.get(WorkResponse.ERRORS_KEY));
  }

  /**
   * Test {@link WorkResponse#createEntityMapWithSummay(Object, ButtonList, ErrorMap, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@code buttons} Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#createEntityMapWithSummay(Object, ButtonList,
   * ErrorMap, String)}
   */
  @Test
  @DisplayName(
      "Test createEntityMapWithSummay(Object, ButtonList, ErrorMap, String); when 'null'; then 'buttons' Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map WorkResponse.createEntityMapWithSummay(Object, ButtonList, ErrorMap, String)"
  })
  void testCreateEntityMapWithSummay_whenNull_thenButtonsContentsReturnList() {
    // Arrange and Act
    Map<String, Object> actualCreateEntityMapWithSummayResult =
        WorkResponse.createEntityMapWithSummay("42", null, null, "Summary");

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
   * Test {@link WorkResponse#getTemplateNameForObject(WorkMode, Object)}.
   *
   * <ul>
   *   <li>When {@code BOTH}.
   *   <li>Then return {@link WorkResponse#DEFAULT_FORM_TEMPLATE_VIEW}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#getTemplateNameForObject(WorkMode, Object)}
   */
  @Test
  @DisplayName(
      "Test getTemplateNameForObject(WorkMode, Object); when 'BOTH'; then return DEFAULT_FORM_TEMPLATE_VIEW")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WorkResponse.getTemplateNameForObject(WorkMode, Object)"})
  void testGetTemplateNameForObject_whenBoth_thenReturnDefault_form_template_view() {
    // Arrange, Act and Assert
    assertEquals(
        WorkResponse.DEFAULT_FORM_TEMPLATE_VIEW,
        WorkResponse.getTemplateNameForObject(WorkMode.BOTH, "42"));
  }

  /**
   * Test {@link WorkResponse#getTemplateNameForObject(WorkMode, Object)}.
   *
   * <ul>
   *   <li>When {@link WorkMode#EDIT}.
   *   <li>Then return {@link WorkResponse#DEFAULT_FORM_TEMPLATE_EDIT}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#getTemplateNameForObject(WorkMode, Object)}
   */
  @Test
  @DisplayName(
      "Test getTemplateNameForObject(WorkMode, Object); when EDIT; then return DEFAULT_FORM_TEMPLATE_EDIT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WorkResponse.getTemplateNameForObject(WorkMode, Object)"})
  void testGetTemplateNameForObject_whenEdit_thenReturnDefault_form_template_edit() {
    // Arrange, Act and Assert
    assertEquals(
        WorkResponse.DEFAULT_FORM_TEMPLATE_EDIT,
        WorkResponse.getTemplateNameForObject(WorkMode.EDIT, "42"));
  }

  /**
   * Test {@link WorkResponse#getTemplateNameForClass(WorkMode, Class)}.
   *
   * <ul>
   *   <li>When {@code BOTH}.
   *   <li>Then return {@link WorkResponse#DEFAULT_FORM_TEMPLATE_VIEW}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#getTemplateNameForClass(WorkMode, Class)}
   */
  @Test
  @DisplayName(
      "Test getTemplateNameForClass(WorkMode, Class); when 'BOTH'; then return DEFAULT_FORM_TEMPLATE_VIEW")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WorkResponse.getTemplateNameForClass(WorkMode, Class)"})
  void testGetTemplateNameForClass_whenBoth_thenReturnDefault_form_template_view() {
    // Arrange
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals(
        WorkResponse.DEFAULT_FORM_TEMPLATE_VIEW,
        WorkResponse.getTemplateNameForClass(WorkMode.BOTH, c));
  }

  /**
   * Test {@link WorkResponse#getTemplateNameForClass(WorkMode, Class)}.
   *
   * <ul>
   *   <li>When {@link WorkMode#EDIT}.
   *   <li>Then return {@link WorkResponse#DEFAULT_FORM_TEMPLATE_EDIT}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponse#getTemplateNameForClass(WorkMode, Class)}
   */
  @Test
  @DisplayName(
      "Test getTemplateNameForClass(WorkMode, Class); when EDIT; then return DEFAULT_FORM_TEMPLATE_EDIT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WorkResponse.getTemplateNameForClass(WorkMode, Class)"})
  void testGetTemplateNameForClass_whenEdit_thenReturnDefault_form_template_edit() {
    // Arrange
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals(
        WorkResponse.DEFAULT_FORM_TEMPLATE_EDIT,
        WorkResponse.getTemplateNameForClass(WorkMode.EDIT, c));
  }

  /**
   * Test {@link WorkResponse#getData()}.
   *
   * <p>Method under test: {@link WorkResponse#getData()}
   */
  @Test
  @DisplayName("Test getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map WorkResponse.getData()"})
  void testGetData() {
    // Arrange and Act
    Map<String, Object> actualData =
        new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH).getData();

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
   * Test {@link WorkResponse#getFormObject()}.
   *
   * <p>Method under test: {@link WorkResponse#getFormObject()}
   */
  @Test
  @DisplayName("Test getFormObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object WorkResponse.getFormObject()"})
  void testGetFormObject() {
    // Arrange, Act and Assert
    assertEquals(
        "42", new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH).getFormObject());
  }

  /**
   * Test {@link WorkResponse#getButtons()}.
   *
   * <p>Method under test: {@link WorkResponse#getButtons()}
   */
  @Test
  @DisplayName("Test getButtons()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ButtonList WorkResponse.getButtons()"})
  void testGetButtons() {
    // Arrange and Act
    ButtonList actualButtons =
        new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH).getButtons();

    // Assert
    Collection<Button> contents = actualButtons.getContents();
    assertTrue(contents instanceof List);
    assertEquals(0, actualButtons.size());
    assertTrue(contents.isEmpty());
  }
}
