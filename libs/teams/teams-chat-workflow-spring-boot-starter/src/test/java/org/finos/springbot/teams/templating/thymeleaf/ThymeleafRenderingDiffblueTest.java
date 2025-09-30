package org.finos.springbot.teams.templating.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Autowired private ThymeleafRendering thymeleafRendering;

  /**
   * Test {@link ThymeleafRendering#description(String)}.
   *
   * <p>Method under test: {@link ThymeleafRendering#description(String)}
   */
  @Test
  @DisplayName("Test description(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.description(String)"})
  void testDescription() {
    // Arrange, Act and Assert
    assertEquals("<span>foo</span>", thymeleafRendering.description("foo"));
  }

  /**
   * Test {@link ThymeleafRendering#list(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return <code>&lt;table&gt;42 foo&lt;/table&gt;</code>.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#list(List)}
   */
  @Test
  @DisplayName(
      "Test list(List); given '42'; when ArrayList() add '42'; then return '<table>42 foo</table>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.list(List)"})
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
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then return <code>&lt;table&gt; foo&lt;/table&gt;</code>.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#list(List)}
   */
  @Test
  @DisplayName(
      "Test list(List); given empty string; when ArrayList() add empty string; then return '<table> foo</table>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.list(List)"})
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
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return <code>&lt;table&gt;foo&lt;/table&gt;</code>.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#list(List)}
   */
  @Test
  @DisplayName(
      "Test list(List); given 'foo'; when ArrayList() add 'foo'; then return '<table>foo</table>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.list(List)"})
  void testList_givenFoo_whenArrayListAddFoo_thenReturnTableFooTable() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>foo</table>", thymeleafRendering.list(contents));
  }

  /**
   * Test {@link ThymeleafRendering#list(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return <code>&lt;table&gt;&lt;/table&gt;</code>.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#list(List)}
   */
  @Test
  @DisplayName("Test list(List); when ArrayList(); then return '<table></table>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.list(List)"})
  void testList_whenArrayList_thenReturnTableTable() {
    // Arrange, Act and Assert
    assertEquals("<table></table>", thymeleafRendering.list(new ArrayList<>()));
  }

  /**
   * Test {@link ThymeleafRendering#addFieldName(String, String)} with {@code String}, {@code
   * String}.
   *
   * <ul>
   *   <li>Then return <code>
   *       &lt;tr&gt;&lt;td style=&quot;width: 200px&quot;&gt;&lt;b&gt;Field:&lt;/b&gt;&lt;/td&gt;&lt;td&gt;42&lt;/td&gt;&lt;/tr&gt;
   *       </code>.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#addFieldName(String, String)}
   */
  @Test
  @DisplayName(
      "Test addFieldName(String, String) with 'String', 'String'; then return '<tr><td style=\"width: 200px\"><b>Field:</b></td><td>42</td></tr>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.addFieldName(String, String)"})
  void testAddFieldNameWithStringString_thenReturnTrTdStyleWidth200pxBFieldBTdTd42TdTr() {
    // Arrange, Act and Assert
    assertEquals(
        "<tr><td style=\"width: 200px\"><b>Field:</b></td><td>42</td></tr>",
        thymeleafRendering.addFieldName("Field", "42"));
  }

  /**
   * Test {@link ThymeleafRendering#addFieldName(String, String)} with {@code String}, {@code
   * String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#addFieldName(String, String)}
   */
  @Test
  @DisplayName(
      "Test addFieldName(String, String) with 'String', 'String'; when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.addFieldName(String, String)"})
  void testAddFieldNameWithStringString_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", thymeleafRendering.addFieldName(null, "42"));
  }

  /**
   * Test {@link ThymeleafRendering#renderDropdown(Variable, String, Map, boolean)} with {@code
   * variable}, {@code variableKey}, {@code options}, {@code editable}.
   *
   * <ul>
   *   <li>Then return lf space.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test renderDropdown(Variable, String, Map, boolean) with 'variable', 'variableKey', 'options', 'editable'; then return lf space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.renderDropdown(Variable, String, Map, boolean)"})
  void testRenderDropdownWithVariableVariableKeyOptionsEditable_thenReturnLfSpace() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");

    // Act and Assert
    assertEquals(
        "\n ", thymeleafRendering.renderDropdown(variable, "Variable Key", new HashMap<>(), true));
  }

  /**
   * Test {@link ThymeleafRendering#textField(Variable, boolean)}.
   *
   * <ul>
   *   <li>When {@link ThymeleafVariable#ThymeleafVariable(String)} with {@code Name}.
   *   <li>Then return {@code <span th:text="${Name}">text</span>}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#textField(Variable, boolean)}
   */
  @Test
  @DisplayName(
      "Test textField(Variable, boolean); when ThymeleafVariable(String) with 'Name'; then return '<span th:text=\"${Name}\">text</span>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.textField(Variable, boolean)"})
  void testTextField_whenThymeleafVariableWithName_thenReturnSpanThTextNameTextSpan() {
    // Arrange, Act and Assert
    assertEquals(
        "<span th:text=\"${Name}\">text</span>",
        thymeleafRendering.textField(new ThymeleafVariable("Name"), true));
  }

  /**
   * Test {@link ThymeleafRendering#checkBox(Variable, boolean)}.
   *
   * <ul>
   *   <li>When {@link ThymeleafVariable#ThymeleafVariable(String)} with {@code Name}.
   *   <li>Then return {@code <span th:text="${Name ? 'Y' : 'N'}">boolean</span>}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkBox(Variable, boolean); when ThymeleafVariable(String) with 'Name'; then return '<span th:text=\"${Name ? 'Y' : 'N'}\">boolean</span>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.checkBox(Variable, boolean)"})
  void testCheckBox_whenThymeleafVariableWithName_thenReturnSpanThTextNameYNBooleanSpan() {
    // Arrange, Act and Assert
    assertEquals(
        "<span th:text=\"${Name ? 'Y' : 'N'}\">boolean</span>",
        thymeleafRendering.checkBox(new ThymeleafVariable("Name"), true));
  }

  /**
   * Test {@link ThymeleafRendering#collection(Type, Variable, Variable, String, boolean)} with
   * {@code Type}, {@code Variable}, {@code Variable}, {@code String}, {@code boolean}.
   *
   * <p>Method under test: {@link ThymeleafRendering#collection(Type, Variable, Variable, String,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test collection(Type, Variable, Variable, String, boolean) with 'Type', 'Variable', 'Variable', 'String', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ThymeleafRendering.collection(Type, Variable, Variable, String, boolean)"
  })
  void testCollectionWithTypeVariableVariableStringBoolean() {
    // Arrange
    TypePlaceHolder t = new TypePlaceHolder(1);
    ThymeleafVariable v = new ThymeleafVariable("Name");

    // Act and Assert
    assertEquals(
        "<div th:each=\"Name : ${Name}\">In</div>",
        thymeleafRendering.collection(t, v, new ThymeleafVariable("Name"), "In", true));
  }

  /**
   * Test {@link ThymeleafRendering#button(String, String)}.
   *
   * <p>Method under test: {@link ThymeleafRendering#button(String, String)}
   */
  @Test
  @DisplayName("Test button(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.button(String, String)"})
  void testButton() {
    // Arrange, Act and Assert
    assertNull(thymeleafRendering.button("Name", "42"));
  }

  /**
   * Test {@link ThymeleafRendering#buttons(String)}.
   *
   * <p>Method under test: {@link ThymeleafRendering#buttons(String)}
   */
  @Test
  @DisplayName("Test buttons(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.buttons(String)"})
  void testButtons() {
    // Arrange, Act and Assert
    assertNull(thymeleafRendering.buttons("Location"));
  }

  /**
   * Test {@link ThymeleafRendering#indent(Variable)} with {@code variable}.
   *
   * <ul>
   *   <li>When {@link ThymeleafVariable#ThymeleafVariable(String)} with {@code Name}.
   *   <li>Then return lf space.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#indent(Variable)}
   */
  @Test
  @DisplayName(
      "Test indent(Variable) with 'variable'; when ThymeleafVariable(String) with 'Name'; then return lf space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.indent(Variable)"})
  void testIndentWithVariable_whenThymeleafVariableWithName_thenReturnLfSpace() {
    // Arrange, Act and Assert
    assertEquals("\n ", thymeleafRendering.indent(new ThymeleafVariable("Name")));
  }

  /**
   * Test {@link ThymeleafRendering#tableRow(Variable, Variable, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code <tr th:each="Name : ${Name}"> 42 foo </tr> }.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  @DisplayName(
      "Test tableRow(Variable, Variable, List); given '42'; when ArrayList() add '42'; then return '<tr th:each=\"Name : ${Name}\">42 foo </tr>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableRow(Variable, Variable, List)"})
  void testTableRow_given42_whenArrayListAdd42_thenReturnTrThEachNameName42FooTr() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");
    ThymeleafVariable subVar = new ThymeleafVariable("Name");

    ArrayList<String> cells = new ArrayList<>();
    cells.add("42");
    cells.add("");
    cells.add("foo");

    // Act and Assert
    assertEquals(
        "\n <tr th:each=\"Name : ${Name}\">42\n\nfoo\n </tr>",
        thymeleafRendering.tableRow(variable, subVar, cells));
  }

  /**
   * Test {@link ThymeleafRendering#tableRow(Variable, Variable, List)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then return {@code <tr th:each="Name : ${Name}"> foo </tr> }.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  @DisplayName(
      "Test tableRow(Variable, Variable, List); given empty string; then return '<tr th:each=\"Name : ${Name}\"> foo </tr>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableRow(Variable, Variable, List)"})
  void testTableRow_givenEmptyString_thenReturnTrThEachNameNameFooTr() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");
    ThymeleafVariable subVar = new ThymeleafVariable("Name");

    ArrayList<String> cells = new ArrayList<>();
    cells.add("");
    cells.add("foo");

    // Act and Assert
    assertEquals(
        "\n <tr th:each=\"Name : ${Name}\">\nfoo\n </tr>",
        thymeleafRendering.tableRow(variable, subVar, cells));
  }

  /**
   * Test {@link ThymeleafRendering#tableRow(Variable, Variable, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code <tr th:each="Name : ${Name}"> foo </tr> }.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  @DisplayName(
      "Test tableRow(Variable, Variable, List); given 'foo'; when ArrayList() add 'foo'; then return '<tr th:each=\"Name : ${Name}\">foo </tr>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableRow(Variable, Variable, List)"})
  void testTableRow_givenFoo_whenArrayListAddFoo_thenReturnTrThEachNameNameFooTr() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");
    ThymeleafVariable subVar = new ThymeleafVariable("Name");

    ArrayList<String> cells = new ArrayList<>();
    cells.add("foo");

    // Act and Assert
    assertEquals(
        "\n <tr th:each=\"Name : ${Name}\">foo\n </tr>",
        thymeleafRendering.tableRow(variable, subVar, cells));
  }

  /**
   * Test {@link ThymeleafRendering#tableRow(Variable, Variable, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code <tr th:each="Name : ${Name}"> </tr> }.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  @DisplayName(
      "Test tableRow(Variable, Variable, List); when ArrayList(); then return '<tr th:each=\"Name : ${Name}\"> </tr>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableRow(Variable, Variable, List)"})
  void testTableRow_whenArrayList_thenReturnTrThEachNameNameTr() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");
    ThymeleafVariable subVar = new ThymeleafVariable("Name");

    // Act and Assert
    assertEquals(
        "\n <tr th:each=\"Name : ${Name}\">\n </tr>",
        thymeleafRendering.tableRow(variable, subVar, new ArrayList<>()));
  }

  /**
   * Test {@link ThymeleafRendering#tableHeaderRow(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code 42 foo}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#tableHeaderRow(List)}
   */
  @Test
  @DisplayName(
      "Test tableHeaderRow(List); given '42'; when ArrayList() add '42'; then return '42 foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableHeaderRow(List)"})
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
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#tableHeaderRow(List)}
   */
  @Test
  @DisplayName(
      "Test tableHeaderRow(List); given empty string; when ArrayList() add empty string; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableHeaderRow(List)"})
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
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#tableHeaderRow(List)}
   */
  @Test
  @DisplayName(
      "Test tableHeaderRow(List); given 'foo'; when ArrayList() add 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableHeaderRow(List)"})
  void testTableHeaderRow_givenFoo_whenArrayListAddFoo_thenReturnFoo() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("foo");

    // Act and Assert
    assertEquals("foo", thymeleafRendering.tableHeaderRow(contents));
  }

  /**
   * Test {@link ThymeleafRendering#tableHeaderRow(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#tableHeaderRow(List)}
   */
  @Test
  @DisplayName("Test tableHeaderRow(List); when ArrayList(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableHeaderRow(List)"})
  void testTableHeaderRow_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", thymeleafRendering.tableHeaderRow(new ArrayList<>()));
  }

  /**
   * Test {@link ThymeleafRendering#tableRowCheckBox(Variable, Variable)}.
   *
   * <p>Method under test: {@link ThymeleafRendering#tableRowCheckBox(Variable, Variable)}
   */
  @Test
  @DisplayName("Test tableRowCheckBox(Variable, Variable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableRowCheckBox(Variable, Variable)"})
  void testTableRowCheckBox() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> thymeleafRendering.tableRowCheckBox(variable, new ThymeleafVariable("Name")));
  }

  /**
   * Test {@link ThymeleafRendering#tableRowEditButton(Variable, Variable)}.
   *
   * <p>Method under test: {@link ThymeleafRendering#tableRowEditButton(Variable, Variable)}
   */
  @Test
  @DisplayName("Test tableRowEditButton(Variable, Variable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableRowEditButton(Variable, Variable)"})
  void testTableRowEditButton() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> thymeleafRendering.tableRowEditButton(variable, new ThymeleafVariable("Name")));
  }

  /**
   * Test {@link ThymeleafRendering#userDisplay(Variable)}.
   *
   * <ul>
   *   <li>Then return {@code <at th:key="${Name?.key}" th:text="${Name?.name}">User Name</at>}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#userDisplay(Variable)}
   */
  @Test
  @DisplayName(
      "Test userDisplay(Variable); then return '<at th:key=\"${Name?.key}\" th:text=\"${Name?.name}\">User Name</at>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.userDisplay(Variable)"})
  void testUserDisplay_thenReturnAtThKeyNameKeyThTextNameNameUserNameAt() {
    // Arrange, Act and Assert
    assertEquals(
        "<at th:key=\"${Name?.key}\" th:text=\"${Name?.name}\">User Name</at>",
        thymeleafRendering.userDisplay(new ThymeleafVariable("Name")));
  }

  /**
   * Test {@link ThymeleafRendering#table(Variable, String, String)} with {@code Variable}, {@code
   * String}, {@code String}.
   *
   * <p>Method under test: {@link ThymeleafRendering#table(Variable, String, String)}
   */
  @Test
  @DisplayName("Test table(Variable, String, String) with 'Variable', 'String', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.table(Variable, String, String)"})
  void testTableWithVariableStringString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n <table><thead><tr>Headers\n </tr></thead><tbody>Not all who wander are lost\n </tbody></table>",
        thymeleafRendering.table(
            new ThymeleafVariable("Name"), "Headers", "Not all who wander are lost"));
  }

  /**
   * Test {@link ThymeleafRendering#tableCell(Map, String)} with {@code Map}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return {@code <td foo="foo">Not all who wander are lost</td>}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#tableCell(Map, String)}
   */
  @Test
  @DisplayName(
      "Test tableCell(Map, String) with 'Map', 'String'; given 'foo'; then return '<td foo=\"foo\">Not all who wander are lost</td>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableCell(Map, String)"})
  void testTableCellWithMapString_givenFoo_thenReturnTdFooFooNotAllWhoWanderAreLostTd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ThymeleafRendering thymeleafRendering = new ThymeleafRendering();

    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("foo", "foo");

    // Act and Assert
    assertEquals(
        "<td foo=\"foo\">Not all who wander are lost</td>",
        thymeleafRendering.tableCell(attributes, "Not all who wander are lost"));
  }

  /**
   * Test {@link ThymeleafRendering#tableCell(Map, String)} with {@code Map}, {@code String}.
   *
   * <ul>
   *   <li>Then return {@code <td ="" foo="foo">Not all who wander are lost</td>}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#tableCell(Map, String)}
   */
  @Test
  @DisplayName(
      "Test tableCell(Map, String) with 'Map', 'String'; then return '<td =\"\" foo=\"foo\">Not all who wander are lost</td>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableCell(Map, String)"})
  void testTableCellWithMapString_thenReturnTdFooFooNotAllWhoWanderAreLostTd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ThymeleafRendering thymeleafRendering = new ThymeleafRendering();

    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("", "");
    attributes.put("foo", "foo");

    // Act and Assert
    assertEquals(
        "<td =\"\" foo=\"foo\">Not all who wander are lost</td>",
        thymeleafRendering.tableCell(attributes, "Not all who wander are lost"));
  }

  /**
   * Test {@link ThymeleafRendering#tableCell(Map, String)} with {@code Map}, {@code String}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return <code>&lt;td&gt;Not all who wander are lost&lt;/td&gt;</code>.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafRendering#tableCell(Map, String)}
   */
  @Test
  @DisplayName(
      "Test tableCell(Map, String) with 'Map', 'String'; when HashMap(); then return '<td>Not all who wander are lost</td>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafRendering.tableCell(Map, String)"})
  void testTableCellWithMapString_whenHashMap_thenReturnTdNotAllWhoWanderAreLostTd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ThymeleafRendering thymeleafRendering = new ThymeleafRendering();

    // Act and Assert
    assertEquals(
        "<td>Not all who wander are lost</td>",
        thymeleafRendering.tableCell(new HashMap<>(), "Not all who wander are lost"));
  }
}
