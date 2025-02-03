package org.finos.springbot.teams.templating.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.springbot.workflow.templating.Variable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ThymeleafRendering.class})
@ExtendWith(SpringExtension.class)
class ThymeleafRenderingDiffblueTest {
  @Autowired
  private ThymeleafRendering thymeleafRendering;

  /**
   * Test {@link ThymeleafRendering#description(String)}.
   * <p>
   * Method under test: {@link ThymeleafRendering#description(String)}
   */
  @Test
  @DisplayName("Test description(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.description(java.lang.String)"})
  void testDescription() {
    // Arrange, Act and Assert
    assertEquals("<span>foo</span>", thymeleafRendering.description("foo"));
  }

  /**
   * Test {@link ThymeleafRendering#list(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return <code>&lt;table&gt;42 foo&lt;/table&gt;</code>.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#list(List)}
   */
  @Test
  @DisplayName("Test list(List); given '42'; when ArrayList() add '42'; then return '<table>42 foo</table>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.list(java.util.List)"})
  void testList_given42_whenArrayListAdd42_thenReturnTable42FooTable() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("42");
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>42\n\nfoo</table>", thymeleafRendering.list(contents));
  }

  /**
   * Test {@link ThymeleafRendering#list(List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link ArrayList#ArrayList()} add empty string.</li>
   *   <li>Then return <code>&lt;table&gt; foo&lt;/table&gt;</code>.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#list(List)}
   */
  @Test
  @DisplayName("Test list(List); given empty string; when ArrayList() add empty string; then return '<table> foo</table>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.list(java.util.List)"})
  void testList_givenEmptyString_whenArrayListAddEmptyString_thenReturnTableFooTable() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>\nfoo</table>", thymeleafRendering.list(contents));
  }

  /**
   * Test {@link ThymeleafRendering#list(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return <code>&lt;table&gt;foo&lt;/table&gt;</code>.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#list(List)}
   */
  @Test
  @DisplayName("Test list(List); given 'foo'; when ArrayList() add 'foo'; then return '<table>foo</table>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.list(java.util.List)"})
  void testList_givenFoo_whenArrayListAddFoo_thenReturnTableFooTable() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>foo</table>", thymeleafRendering.list(contents));
  }

  /**
   * Test {@link ThymeleafRendering#list(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return <code>&lt;table&gt;&lt;/table&gt;</code>.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#list(List)}
   */
  @Test
  @DisplayName("Test list(List); when ArrayList(); then return '<table></table>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.list(java.util.List)"})
  void testList_whenArrayList_thenReturnTableTable() {
    // Arrange, Act and Assert
    assertEquals("<table></table>", thymeleafRendering.list(new ArrayList<>()));
  }

  /**
   * Test {@link ThymeleafRendering#addFieldName(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>Then return <code>&lt;tr&gt;&lt;td style=&quot;width: 200px&quot;&gt;&lt;b&gt;Field:&lt;/b&gt;&lt;/td&gt;&lt;td&gt;42&lt;/td&gt;&lt;/tr&gt;</code>.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#addFieldName(String, String)}
   */
  @Test
  @DisplayName("Test addFieldName(String, String) with 'String', 'String'; then return '<tr><td style=\"width: 200px\"><b>Field:</b></td><td>42</td></tr>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.addFieldName(java.lang.String, java.lang.String)"})
  void testAddFieldNameWithStringString_thenReturnTrTdStyleWidth200pxBFieldBTdTd42TdTr() {
    // Arrange, Act and Assert
    assertEquals("<tr><td style=\"width: 200px\"><b>Field:</b></td><td>42</td></tr>",
        thymeleafRendering.addFieldName("Field", "42"));
  }

  /**
   * Test {@link ThymeleafRendering#addFieldName(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#addFieldName(String, String)}
   */
  @Test
  @DisplayName("Test addFieldName(String, String) with 'String', 'String'; when empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.addFieldName(java.lang.String, java.lang.String)"})
  void testAddFieldNameWithStringString_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", thymeleafRendering.addFieldName("", "42"));
  }

  /**
   * Test {@link ThymeleafRendering#renderDropdown(Variable, String, Map, boolean)} with {@code variable}, {@code variableKey}, {@code options}, {@code editable}.
   * <ul>
   *   <li>Then return lf space.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  @DisplayName("Test renderDropdown(Variable, String, Map, boolean) with 'variable', 'variableKey', 'options', 'editable'; then return lf space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.renderDropdown(org.finos.springbot.workflow.templating.Variable, java.lang.String, java.util.Map, boolean)"})
  void testRenderDropdownWithVariableVariableKeyOptionsEditable_thenReturnLfSpace() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");

    // Act and Assert
    assertEquals("\n ", thymeleafRendering.renderDropdown(variable, "Variable Key", new HashMap<>(), true));
  }

  /**
   * Test {@link ThymeleafRendering#textField(Variable, boolean)}.
   * <ul>
   *   <li>When {@link ThymeleafVariable#ThymeleafVariable(String)} with {@code Name}.</li>
   *   <li>Then return {@code <span th:text="${Name}">text</span>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#textField(Variable, boolean)}
   */
  @Test
  @DisplayName("Test textField(Variable, boolean); when ThymeleafVariable(String) with 'Name'; then return '<span th:text=\"${Name}\">text</span>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.textField(org.finos.springbot.workflow.templating.Variable, boolean)"})
  void testTextField_whenThymeleafVariableWithName_thenReturnSpanThTextNameTextSpan() {
    // Arrange, Act and Assert
    assertEquals("<span th:text=\"${Name}\">text</span>",
        thymeleafRendering.textField(new ThymeleafVariable("Name"), true));
  }

  /**
   * Test {@link ThymeleafRendering#checkBox(Variable, boolean)}.
   * <ul>
   *   <li>When {@link ThymeleafVariable#ThymeleafVariable(String)} with {@code Name}.</li>
   *   <li>Then return {@code <span th:text="${Name ? 'Y' : 'N'}">boolean</span>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean); when ThymeleafVariable(String) with 'Name'; then return '<span th:text=\"${Name ? 'Y' : 'N'}\">boolean</span>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.checkBox(org.finos.springbot.workflow.templating.Variable, boolean)"})
  void testCheckBox_whenThymeleafVariableWithName_thenReturnSpanThTextNameYNBooleanSpan() {
    // Arrange, Act and Assert
    assertEquals("<span th:text=\"${Name ? 'Y' : 'N'}\">boolean</span>",
        thymeleafRendering.checkBox(new ThymeleafVariable("Name"), true));
  }

  /**
   * Test {@link ThymeleafRendering#collection(Type, Variable, Variable, String, boolean)} with {@code Type}, {@code Variable}, {@code Variable}, {@code String}, {@code boolean}.
   * <p>
   * Method under test: {@link ThymeleafRendering#collection(Type, Variable, Variable, String, boolean)}
   */
  @Test
  @DisplayName("Test collection(Type, Variable, Variable, String, boolean) with 'Type', 'Variable', 'Variable', 'String', 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.collection(java.lang.reflect.Type, org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.Variable, java.lang.String, boolean)"})
  void testCollectionWithTypeVariableVariableStringBoolean() {
    // Arrange
    TypePlaceHolder t = new TypePlaceHolder(1);
    ThymeleafVariable v = new ThymeleafVariable("Name");

    // Act and Assert
    assertEquals("<div th:each=\"Name : ${Name}\">In</div>",
        thymeleafRendering.collection(t, v, new ThymeleafVariable("Name"), "In", true));
  }

  /**
   * Test {@link ThymeleafRendering#button(String, String)}.
   * <p>
   * Method under test: {@link ThymeleafRendering#button(String, String)}
   */
  @Test
  @DisplayName("Test button(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.button(java.lang.String, java.lang.String)"})
  void testButton() {
    // Arrange, Act and Assert
    assertNull(thymeleafRendering.button("Name", "42"));
  }

  /**
   * Test {@link ThymeleafRendering#buttons(String)}.
   * <p>
   * Method under test: {@link ThymeleafRendering#buttons(String)}
   */
  @Test
  @DisplayName("Test buttons(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.buttons(java.lang.String)"})
  void testButtons() {
    // Arrange, Act and Assert
    assertNull(thymeleafRendering.buttons("Location"));
  }

  /**
   * Test {@link ThymeleafRendering#indent(Variable)} with {@code variable}.
   * <ul>
   *   <li>When {@link ThymeleafVariable#ThymeleafVariable(String)} with {@code Name}.</li>
   *   <li>Then return lf space.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#indent(Variable)}
   */
  @Test
  @DisplayName("Test indent(Variable) with 'variable'; when ThymeleafVariable(String) with 'Name'; then return lf space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.indent(org.finos.springbot.workflow.templating.Variable)"})
  void testIndentWithVariable_whenThymeleafVariableWithName_thenReturnLfSpace() {
    // Arrange, Act and Assert
    assertEquals("\n ", thymeleafRendering.indent(new ThymeleafVariable("Name")));
  }

  /**
   * Test {@link ThymeleafRendering#tableRow(Variable, Variable, List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then return {@code
   * <tr th:each="Data Path : ${Name}">
   * foo foo
   * </tr>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  @DisplayName("Test tableRow(Variable, Variable, List); given empty string; then return '<tr th:each=\"Data Path : ${Name}\">foo foo </tr>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableRow(org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.Variable, java.util.List)"})
  void testTableRow_givenEmptyString_thenReturnTrThEachDataPathNameFooFooTr() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");
    Variable subVar = mock(Variable.class);
    when(subVar.getDepth()).thenReturn(2);
    when(subVar.getDataPath()).thenReturn("Data Path");

    ArrayList<String> cells = new ArrayList<>();
    cells.add("foo");
    cells.add("");
    cells.add("foo");

    // Act
    String actualTableRowResult = thymeleafRendering.tableRow(variable, subVar, cells);

    // Assert
    verify(subVar).getDataPath();
    verify(subVar, atLeast(1)).getDepth();
    assertEquals("\n  <tr th:each=\"Data Path : ${Name}\">foo\n\nfoo\n  </tr>", actualTableRowResult);
  }

  /**
   * Test {@link ThymeleafRendering#tableRow(Variable, Variable, List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then return {@code
   * <tr th:each="Data Path : ${Name}">
   * foo
   * </tr>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  @DisplayName("Test tableRow(Variable, Variable, List); given empty string; then return '<tr th:each=\"Data Path : ${Name}\"> foo </tr>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableRow(org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.Variable, java.util.List)"})
  void testTableRow_givenEmptyString_thenReturnTrThEachDataPathNameFooTr() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");
    Variable subVar = mock(Variable.class);
    when(subVar.getDepth()).thenReturn(2);
    when(subVar.getDataPath()).thenReturn("Data Path");

    ArrayList<String> cells = new ArrayList<>();
    cells.add("");
    cells.add("foo");

    // Act
    String actualTableRowResult = thymeleafRendering.tableRow(variable, subVar, cells);

    // Assert
    verify(subVar).getDataPath();
    verify(subVar, atLeast(1)).getDepth();
    assertEquals("\n  <tr th:each=\"Data Path : ${Name}\">\nfoo\n  </tr>", actualTableRowResult);
  }

  /**
   * Test {@link ThymeleafRendering#tableRow(Variable, Variable, List)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>Then return {@code
   * <tr th:each="Data Path : ${Name}">
   * foo
   * </tr>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  @DisplayName("Test tableRow(Variable, Variable, List); given two; then return '<tr th:each=\"Data Path : ${Name}\">foo </tr>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableRow(org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.Variable, java.util.List)"})
  void testTableRow_givenTwo_thenReturnTrThEachDataPathNameFooTr() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");
    Variable subVar = mock(Variable.class);
    when(subVar.getDepth()).thenReturn(2);
    when(subVar.getDataPath()).thenReturn("Data Path");

    ArrayList<String> cells = new ArrayList<>();
    cells.add("foo");

    // Act
    String actualTableRowResult = thymeleafRendering.tableRow(variable, subVar, cells);

    // Assert
    verify(subVar).getDataPath();
    verify(subVar, atLeast(1)).getDepth();
    assertEquals("\n  <tr th:each=\"Data Path : ${Name}\">foo\n  </tr>", actualTableRowResult);
  }

  /**
   * Test {@link ThymeleafRendering#tableRow(Variable, Variable, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code
   * <tr th:each="Name : ${Name}">
   * </tr>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  @DisplayName("Test tableRow(Variable, Variable, List); when ArrayList(); then return '<tr th:each=\"Name : ${Name}\"> </tr>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableRow(org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.Variable, java.util.List)"})
  void testTableRow_whenArrayList_thenReturnTrThEachNameNameTr() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");
    ThymeleafVariable subVar = new ThymeleafVariable("Name");

    // Act and Assert
    assertEquals("\n <tr th:each=\"Name : ${Name}\">\n </tr>",
        thymeleafRendering.tableRow(variable, subVar, new ArrayList<>()));
  }

  /**
   * Test {@link ThymeleafRendering#tableHeaderRow(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code 42 foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#tableHeaderRow(List)}
   */
  @Test
  @DisplayName("Test tableHeaderRow(List); given '42'; when ArrayList() add '42'; then return '42 foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableHeaderRow(java.util.List)"})
  void testTableHeaderRow_given42_whenArrayListAdd42_thenReturn42Foo() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("42");
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("42\n\nfoo", thymeleafRendering.tableHeaderRow(contents));
  }

  /**
   * Test {@link ThymeleafRendering#tableHeaderRow(List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link ArrayList#ArrayList()} add empty string.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#tableHeaderRow(List)}
   */
  @Test
  @DisplayName("Test tableHeaderRow(List); given empty string; when ArrayList() add empty string; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableHeaderRow(java.util.List)"})
  void testTableHeaderRow_givenEmptyString_whenArrayListAddEmptyString_thenReturnFoo() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("\nfoo", thymeleafRendering.tableHeaderRow(contents));
  }

  /**
   * Test {@link ThymeleafRendering#tableHeaderRow(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#tableHeaderRow(List)}
   */
  @Test
  @DisplayName("Test tableHeaderRow(List); given 'foo'; when ArrayList() add 'foo'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableHeaderRow(java.util.List)"})
  void testTableHeaderRow_givenFoo_whenArrayListAddFoo_thenReturnFoo() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("foo");

    // Act and Assert
    assertEquals("foo", thymeleafRendering.tableHeaderRow(contents));
  }

  /**
   * Test {@link ThymeleafRendering#tableHeaderRow(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#tableHeaderRow(List)}
   */
  @Test
  @DisplayName("Test tableHeaderRow(List); when ArrayList(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableHeaderRow(java.util.List)"})
  void testTableHeaderRow_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", thymeleafRendering.tableHeaderRow(new ArrayList<>()));
  }

  /**
   * Test {@link ThymeleafRendering#tableRowCheckBox(Variable, Variable)}.
   * <p>
   * Method under test: {@link ThymeleafRendering#tableRowCheckBox(Variable, Variable)}
   */
  @Test
  @DisplayName("Test tableRowCheckBox(Variable, Variable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableRowCheckBox(org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.Variable)"})
  void testTableRowCheckBox() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> thymeleafRendering.tableRowCheckBox(variable, new ThymeleafVariable("Name")));
  }

  /**
   * Test {@link ThymeleafRendering#tableRowEditButton(Variable, Variable)}.
   * <p>
   * Method under test: {@link ThymeleafRendering#tableRowEditButton(Variable, Variable)}
   */
  @Test
  @DisplayName("Test tableRowEditButton(Variable, Variable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableRowEditButton(org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.Variable)"})
  void testTableRowEditButton() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> thymeleafRendering.tableRowEditButton(variable, new ThymeleafVariable("Name")));
  }

  /**
   * Test {@link ThymeleafRendering#userDisplay(Variable)}.
   * <ul>
   *   <li>Then return {@code <at th:key="${Name?.key}" th:text="${Name?.name}">User Name</at>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#userDisplay(Variable)}
   */
  @Test
  @DisplayName("Test userDisplay(Variable); then return '<at th:key=\"${Name?.key}\" th:text=\"${Name?.name}\">User Name</at>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.userDisplay(org.finos.springbot.workflow.templating.Variable)"})
  void testUserDisplay_thenReturnAtThKeyNameKeyThTextNameNameUserNameAt() {
    // Arrange, Act and Assert
    assertEquals("<at th:key=\"${Name?.key}\" th:text=\"${Name?.name}\">User Name</at>",
        thymeleafRendering.userDisplay(new ThymeleafVariable("Name")));
  }

  /**
   * Test {@link ThymeleafRendering#table(Variable, String, String)} with {@code Variable}, {@code String}, {@code String}.
   * <p>
   * Method under test: {@link ThymeleafRendering#table(Variable, String, String)}
   */
  @Test
  @DisplayName("Test table(Variable, String, String) with 'Variable', 'String', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.table(org.finos.springbot.workflow.templating.Variable, java.lang.String, java.lang.String)"})
  void testTableWithVariableStringString() {
    // Arrange, Act and Assert
    assertEquals("\n <table><thead><tr>Headers\n </tr></thead><tbody>Not all who wander are lost\n </tbody></table>",
        thymeleafRendering.table(new ThymeleafVariable("Name"), "Headers", "Not all who wander are lost"));
  }

  /**
   * Test {@link ThymeleafRendering#tableCell(Map, String)} with {@code Map}, {@code String}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@code
   * <td foo="foo">Not all who wander are lost</td>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#tableCell(Map, String)}
   */
  @Test
  @DisplayName("Test tableCell(Map, String) with 'Map', 'String'; given 'foo'; then return '<td foo=\"foo\">Not all who wander are lost</td>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableCell(java.util.Map, java.lang.String)"})
  void testTableCellWithMapString_givenFoo_thenReturnTdFooFooNotAllWhoWanderAreLostTd() {
    // Arrange
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("foo", "foo");

    // Act and Assert
    assertEquals("<td foo=\"foo\">Not all who wander are lost</td>",
        thymeleafRendering.tableCell(attributes, "Not all who wander are lost"));
  }

  /**
   * Test {@link ThymeleafRendering#tableCell(Map, String)} with {@code Map}, {@code String}.
   * <ul>
   *   <li>Then return {@code <td ="" foo="foo">Not all who wander are lost</td>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#tableCell(Map, String)}
   */
  @Test
  @DisplayName("Test tableCell(Map, String) with 'Map', 'String'; then return '<td =\"\" foo=\"foo\">Not all who wander are lost</td>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableCell(java.util.Map, java.lang.String)"})
  void testTableCellWithMapString_thenReturnTdFooFooNotAllWhoWanderAreLostTd() {
    // Arrange
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("", "");
    attributes.put("foo", "foo");

    // Act and Assert
    assertEquals("<td =\"\" foo=\"foo\">Not all who wander are lost</td>",
        thymeleafRendering.tableCell(attributes, "Not all who wander are lost"));
  }

  /**
   * Test {@link ThymeleafRendering#tableCell(Map, String)} with {@code Map}, {@code String}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return <code>&lt;td&gt;Not all who wander are lost&lt;/td&gt;</code>.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafRendering#tableCell(Map, String)}
   */
  @Test
  @DisplayName("Test tableCell(Map, String) with 'Map', 'String'; when HashMap(); then return '<td>Not all who wander are lost</td>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering.tableCell(java.util.Map, java.lang.String)"})
  void testTableCellWithMapString_whenHashMap_thenReturnTdNotAllWhoWanderAreLostTd() {
    // Arrange, Act and Assert
    assertEquals("<td>Not all who wander are lost</td>",
        thymeleafRendering.tableCell(new HashMap<>(), "Not all who wander are lost"));
  }
}
