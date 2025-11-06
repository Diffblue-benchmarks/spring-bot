package org.finos.springbot.symphony.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

@ContextConfiguration(classes = {FreemarkerRendering.class})
@ExtendWith(SpringExtension.class)
class FreemarkerRenderingDiffblueTest {
  @Autowired
  private FreemarkerRendering freemarkerRendering;

  /**
   * Test {@link FreemarkerRendering#description(String)}.
   * <p>
   * Method under test: {@link FreemarkerRendering#description(String)}
   */
  @Test
  @DisplayName("Test description(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.description(String)"})
  void testDescription() {
    // Arrange, Act and Assert
    assertEquals("<span>foo</span>", freemarkerRendering.description("foo"));
  }

  /**
   * Test {@link FreemarkerRendering#list(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return <code>&lt;table&gt;42 foo&lt;/table&gt;</code>.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#list(List)}
   */
  @Test
  @DisplayName("Test list(List); given '42'; when ArrayList() add '42'; then return '<table>42 foo</table>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.list(List)"})
  void testList_given42_whenArrayListAdd42_thenReturnTable42FooTable() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("42");
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>42\n\nfoo</table>", freemarkerRendering.list(contents));
  }

  /**
   * Test {@link FreemarkerRendering#list(List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link ArrayList#ArrayList()} add empty string.</li>
   *   <li>Then return <code>&lt;table&gt; foo&lt;/table&gt;</code>.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#list(List)}
   */
  @Test
  @DisplayName("Test list(List); given empty string; when ArrayList() add empty string; then return '<table> foo</table>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.list(List)"})
  void testList_givenEmptyString_whenArrayListAddEmptyString_thenReturnTableFooTable() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>\nfoo</table>", freemarkerRendering.list(contents));
  }

  /**
   * Test {@link FreemarkerRendering#list(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return <code>&lt;table&gt;foo&lt;/table&gt;</code>.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#list(List)}
   */
  @Test
  @DisplayName("Test list(List); given 'foo'; when ArrayList() add 'foo'; then return '<table>foo</table>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.list(List)"})
  void testList_givenFoo_whenArrayListAddFoo_thenReturnTableFooTable() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>foo</table>", freemarkerRendering.list(contents));
  }

  /**
   * Test {@link FreemarkerRendering#list(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return <code>&lt;table&gt;&lt;/table&gt;</code>.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#list(List)}
   */
  @Test
  @DisplayName("Test list(List); when ArrayList(); then return '<table></table>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.list(List)"})
  void testList_whenArrayList_thenReturnTableTable() {
    // Arrange, Act and Assert
    assertEquals("<table></table>", freemarkerRendering.list(new ArrayList<>()));
  }

  /**
   * Test {@link FreemarkerRendering#addFieldName(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>Then return <code>&lt;tr&gt;&lt;td style=&quot;width: 200px&quot;&gt;&lt;b&gt;Field:&lt;/b&gt;&lt;/td&gt;&lt;td&gt;42&lt;/td&gt;&lt;/tr&gt;</code>.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#addFieldName(String, String)}
   */
  @Test
  @DisplayName("Test addFieldName(String, String) with 'String', 'String'; then return '<tr><td style=\"width: 200px\"><b>Field:</b></td><td>42</td></tr>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.addFieldName(String, String)"})
  void testAddFieldNameWithStringString_thenReturnTrTdStyleWidth200pxBFieldBTdTd42TdTr() {
    // Arrange, Act and Assert
    assertEquals("<tr><td style=\"width: 200px\"><b>Field:</b></td><td>42</td></tr>",
        freemarkerRendering.addFieldName("Field", "42"));
  }

  /**
   * Test {@link FreemarkerRendering#addFieldName(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#addFieldName(String, String)}
   */
  @Test
  @DisplayName("Test addFieldName(String, String) with 'String', 'String'; when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.addFieldName(String, String)"})
  void testAddFieldNameWithStringString_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", freemarkerRendering.addFieldName(null, "42"));
  }

  /**
   * Test {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)} with {@code variable}, {@code variableKey}, {@code options}, {@code editable}.
   * <p>
   * Method under test: {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  @DisplayName("Test renderDropdown(Variable, String, Map, boolean) with 'variable', 'variableKey', 'options', 'editable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.renderDropdown(Variable, String, Map, boolean)"})
  void testRenderDropdownWithVariableVariableKeyOptionsEditable() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    // Act and Assert
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['Name']!''}</span>\n"
            + " <div style=\"min-height: 100px;\"><select \n" + "  name=\"Name\"\n"
            + "  data-placeholder=\"Choose name\">\n" + " \n" + " </select></div>",
        freemarkerRendering.renderDropdown(variable, "Variable Key", new HashMap<>(), true));
  }

  /**
   * Test {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)} with {@code variable}, {@code variableKey}, {@code options}, {@code editable}.
   * <p>
   * Method under test: {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  @DisplayName("Test renderDropdown(Variable, String, Map, boolean) with 'variable', 'variableKey', 'options', 'editable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.renderDropdown(Variable, String, Map, boolean)"})
  void testRenderDropdownWithVariableVariableKeyOptionsEditable2() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("UU");

    // Act and Assert
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UU']!''}</span>\n"
            + " <div style=\"min-height: 100px;\"><select \n" + "  name=\"UU\"\n"
            + "  data-placeholder=\"Choose u u\">\n" + " \n" + " </select></div>",
        freemarkerRendering.renderDropdown(variable, "Variable Key", new HashMap<>(), true));
  }

  /**
   * Test {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)} with {@code variable}, {@code variableKey}, {@code options}, {@code editable}.
   * <p>
   * Method under test: {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  @DisplayName("Test renderDropdown(Variable, String, Map, boolean) with 'variable', 'variableKey', 'options', 'editable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.renderDropdown(Variable, String, Map, boolean)"})
  void testRenderDropdownWithVariableVariableKeyOptionsEditable3() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("form.");

    // Act and Assert
    assertEquals(
        "\n" + " <div style=\"min-height: 100px;\"><select \n" + "  name=\"\"\n"
            + "  data-placeholder=\"Choose form.\">\n" + " \n" + " </select></div>",
        freemarkerRendering.renderDropdown(variable, "Variable Key", new HashMap<>(), true));
  }

  /**
   * Test {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)} with {@code variable}, {@code variableKey}, {@code options}, {@code editable}.
   * <p>
   * Method under test: {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  @DisplayName("Test renderDropdown(Variable, String, Map, boolean) with 'variable', 'variableKey', 'options', 'editable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.renderDropdown(Variable, String, Map, boolean)"})
  void testRenderDropdownWithVariableVariableKeyOptionsEditable4() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("(.)(\\p{Upper})");

    // Act and Assert
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['(.)(\\p{Upper})']!''}</span>\n"
            + " <div style=\"min-height: 100px;\"><select \n" + "  name=\"(.)(\\p{Upper})\"\n"
            + "  data-placeholder=\"Choose (.)(\\p{ upper})\">\n" + " \n" + " </select></div>",
        freemarkerRendering.renderDropdown(variable, "Variable Key", new HashMap<>(), true));
  }

  /**
   * Test {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)} with {@code variable}, {@code variableKey}, {@code options}, {@code editable}.
   * <ul>
   *   <li>Then return lf space.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  @DisplayName("Test renderDropdown(Variable, String, Map, boolean) with 'variable', 'variableKey', 'options', 'editable'; then return lf space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.renderDropdown(Variable, String, Map, boolean)"})
  void testRenderDropdownWithVariableVariableKeyOptionsEditable_thenReturnLfSpace() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    // Act and Assert
    assertEquals("\n ", freemarkerRendering.renderDropdown(variable, "Variable Key", new HashMap<>(), false));
  }

  /**
   * Test {@link FreemarkerRendering#textField(Variable, boolean)}.
   * <ul>
   *   <li>Then return {@code <text-field name="" placeholder="">${(form.)!''}</text-field>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#textField(Variable, boolean)}
   */
  @Test
  @DisplayName("Test textField(Variable, boolean); then return '<text-field name=\"\" placeholder=\"\">${(form.)!''}</text-field>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.textField(Variable, boolean)"})
  void testTextField_thenReturnTextFieldNamePlaceholderFormTextField() {
    // Arrange, Act and Assert
    assertEquals("\n <text-field \n  name=\"\"\n  placeholder=\"\">${(form.)!''}</text-field>",
        freemarkerRendering.textField(new FreemarkerVariable("form."), true));
  }

  /**
   * Test {@link FreemarkerRendering#textField(Variable, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code ${(Name)!''}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#textField(Variable, boolean)}
   */
  @Test
  @DisplayName("Test textField(Variable, boolean); when 'false'; then return '${(Name)!''}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.textField(Variable, boolean)"})
  void testTextField_whenFalse_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("${(Name)!''}", freemarkerRendering.textField(new FreemarkerVariable("Name"), false));
  }

  /**
   * Test {@link FreemarkerRendering#textField(Variable, boolean)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with {@code Name}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#textField(Variable, boolean)}
   */
  @Test
  @DisplayName("Test textField(Variable, boolean); when FreemarkerVariable(String) with 'Name'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.textField(Variable, boolean)"})
  void testTextField_whenFreemarkerVariableWithName_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['Name']!''}</span>\n"
            + " <text-field \n" + "  name=\"Name\"\n" + "  placeholder=\"\">${(Name)!''}</text-field>",
        freemarkerRendering.textField(new FreemarkerVariable("Name"), true));
  }

  /**
   * Test {@link FreemarkerRendering#checkBox(Variable, boolean)}.
   * <p>
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.checkBox(Variable, boolean)"})
  void testCheckBox() {
    // Arrange, Act and Assert
    assertEquals(
        "\n <checkbox \n  name=\"\"\n  checked=\"${form.?string('true', 'false')}\"\n  value=\"true\">form.</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("form."), true));
  }

  /**
   * Test {@link FreemarkerRendering#checkBox(Variable, boolean)}.
   * <p>
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.checkBox(Variable, boolean)"})
  void testCheckBox2() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + " <checkbox \n" + "  name=\"\"\n" + "  checked=\"${UUform.?string('true', 'false')}\"\n"
            + "  value=\"true\">u uform.</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UUform."), true));
  }

  /**
   * Test {@link FreemarkerRendering#checkBox(Variable, boolean)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code (.)(\p{Upper})}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean); when FreemarkerVariable(String) with name is '(.)(\\p{Upper})'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.checkBox(Variable, boolean)"})
  void testCheckBox_whenFreemarkerVariableWithNameIsPUpper_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['(.)(\\p{Upper})']!''}</span>\n"
            + " <checkbox \n" + "  name=\"(.)(\\p{Upper})\"\n"
            + "  checked=\"${(.)(\\p{Upper})?string('true', 'false')}\"\n"
            + "  value=\"true\">(.)(\\p{ upper})</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("(.)(\\p{Upper})"), true));
  }

  /**
   * Test {@link FreemarkerRendering#checkBox(Variable, boolean)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUName}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean); when FreemarkerVariable(String) with name is 'UUName'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.checkBox(Variable, boolean)"})
  void testCheckBox_whenFreemarkerVariableWithNameIsUUName_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UUName']!''}</span>\n"
            + " <checkbox \n" + "  name=\"UUName\"\n" + "  checked=\"${UUName?string('true', 'false')}\"\n"
            + "  value=\"true\">u uname</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UUName"), true));
  }

  /**
   * Test {@link FreemarkerRendering#checkBox(Variable, boolean)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUchecked}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean); when FreemarkerVariable(String) with name is 'UUchecked'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.checkBox(Variable, boolean)"})
  void testCheckBox_whenFreemarkerVariableWithNameIsUUchecked_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UUchecked']!''}</span>\n"
            + " <checkbox \n" + "  name=\"UUchecked\"\n" + "  checked=\"${UUchecked?string('true', 'false')}\"\n"
            + "  value=\"true\">u uchecked</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UUchecked"), true));
  }

  /**
   * Test {@link FreemarkerRendering#checkBox(Variable, boolean)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUname}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean); when FreemarkerVariable(String) with name is 'UUname'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.checkBox(Variable, boolean)"})
  void testCheckBox_whenFreemarkerVariableWithNameIsUUname_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UUname']!''}</span>\n"
            + " <checkbox \n" + "  name=\"UUname\"\n" + "  checked=\"${UUname?string('true', 'false')}\"\n"
            + "  value=\"true\">u uname</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UUname"), true));
  }

  /**
   * Test {@link FreemarkerRendering#checkBox(Variable, boolean)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUtrue}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean); when FreemarkerVariable(String) with name is 'UUtrue'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.checkBox(Variable, boolean)"})
  void testCheckBox_whenFreemarkerVariableWithNameIsUUtrue_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UUtrue']!''}</span>\n"
            + " <checkbox \n" + "  name=\"UUtrue\"\n" + "  checked=\"${UUtrue?string('true', 'false')}\"\n"
            + "  value=\"true\">u utrue</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UUtrue"), true));
  }

  /**
   * Test {@link FreemarkerRendering#checkBox(Variable, boolean)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUvalue}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean); when FreemarkerVariable(String) with name is 'UUvalue'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.checkBox(Variable, boolean)"})
  void testCheckBox_whenFreemarkerVariableWithNameIsUUvalue_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UUvalue']!''}</span>\n"
            + " <checkbox \n" + "  name=\"UUvalue\"\n" + "  checked=\"${UUvalue?string('true', 'false')}\"\n"
            + "  value=\"true\">u uvalue</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UUvalue"), true));
  }

  /**
   * Test {@link FreemarkerRendering#checkBox(Variable, boolean)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean); when FreemarkerVariable(String) with name is 'UU'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.checkBox(Variable, boolean)"})
  void testCheckBox_whenFreemarkerVariableWithNameIsUu_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UU']!''}</span>\n" + " <checkbox \n"
            + "  name=\"UU\"\n" + "  checked=\"${UU?string('true', 'false')}\"\n" + "  value=\"true\">u u</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UU"), true));
  }

  /**
   * Test {@link FreemarkerRendering#checkBox(Variable, boolean)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUUU}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean); when FreemarkerVariable(String) with name is 'UUUU'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.checkBox(Variable, boolean)"})
  void testCheckBox_whenFreemarkerVariableWithNameIsUuuu_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals("\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UUUU']!''}</span>\n"
        + " <checkbox \n" + "  name=\"UUUU\"\n" + "  checked=\"${UUUU?string('true', 'false')}\"\n"
        + "  value=\"true\">u uu u</checkbox>", freemarkerRendering.checkBox(new FreemarkerVariable("UUUU"), true));
  }

  /**
   * Test {@link FreemarkerRendering#checkBox(Variable, boolean)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with {@code Name}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean); when FreemarkerVariable(String) with 'Name'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.checkBox(Variable, boolean)"})
  void testCheckBox_whenFreemarkerVariableWithName_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals("\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['Name']!''}</span>\n"
        + " <checkbox \n" + "  name=\"Name\"\n" + "  checked=\"${Name?string('true', 'false')}\"\n"
        + "  value=\"true\">name</checkbox>", freemarkerRendering.checkBox(new FreemarkerVariable("Name"), true));
  }

  /**
   * Test {@link FreemarkerRendering#checkBox(Variable, boolean)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with {@code Name}.</li>
   *   <li>Then return {@code ${(Name)?string("Y", "N")}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName("Test checkBox(Variable, boolean); when FreemarkerVariable(String) with 'Name'; then return '${(Name)?string(\"Y\", \"N\")}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.checkBox(Variable, boolean)"})
  void testCheckBox_whenFreemarkerVariableWithName_thenReturnNameStringYN() {
    // Arrange, Act and Assert
    assertEquals("${(Name)?string(\"Y\", \"N\")}", freemarkerRendering.checkBox(new FreemarkerVariable("Name"), false));
  }

  /**
   * Test {@link FreemarkerRendering#collection(Type, Variable, Variable, String, boolean)} with {@code Type}, {@code Variable}, {@code Variable}, {@code String}, {@code boolean}.
   * <p>
   * Method under test: {@link FreemarkerRendering#collection(Type, Variable, Variable, String, boolean)}
   */
  @Test
  @DisplayName("Test collection(Type, Variable, Variable, String, boolean) with 'Type', 'Variable', 'Variable', 'String', 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.collection(Type, Variable, Variable, String, boolean)"})
  void testCollectionWithTypeVariableVariableStringBoolean() {
    // Arrange
    TypePlaceHolder t = new TypePlaceHolder(1);
    FreemarkerVariable v = new FreemarkerVariable("Name");

    // Act and Assert
    assertNull(freemarkerRendering.collection(t, v, new FreemarkerVariable("Name"), "In", true));
  }

  /**
   * Test {@link FreemarkerRendering#button(String, String)}.
   * <p>
   * Method under test: {@link FreemarkerRendering#button(String, String)}
   */
  @Test
  @DisplayName("Test button(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.button(String, String)"})
  void testButton() {
    // Arrange, Act and Assert
    assertEquals("<button name=\"42\">Text</button>", freemarkerRendering.button("Text", "42"));
  }

  /**
   * Test {@link FreemarkerRendering#buttons(String)}.
   * <p>
   * Method under test: {@link FreemarkerRendering#buttons(String)}
   */
  @Test
  @DisplayName("Test buttons(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.buttons(String)"})
  void testButtons() {
    // Arrange, Act and Assert
    assertNull(freemarkerRendering.buttons("Location"));
  }

  /**
   * Test {@link FreemarkerRendering#indent(Variable)} with {@code variable}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with {@code Name}.</li>
   *   <li>Then return lf space.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#indent(Variable)}
   */
  @Test
  @DisplayName("Test indent(Variable) with 'variable'; when FreemarkerVariable(String) with 'Name'; then return lf space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.indent(Variable)"})
  void testIndentWithVariable_whenFreemarkerVariableWithName_thenReturnLfSpace() {
    // Arrange, Act and Assert
    assertEquals("\n ", freemarkerRendering.indent(new FreemarkerVariable("Name")));
  }

  /**
   * Test {@link FreemarkerRendering#table(Variable, String, String)} with {@code Variable}, {@code String}, {@code String}.
   * <p>
   * Method under test: {@link FreemarkerRendering#table(Variable, String, String)}
   */
  @Test
  @DisplayName("Test table(Variable, String, String) with 'Variable', 'String', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.table(Variable, String, String)"})
  void testTableWithVariableStringString() {
    // Arrange, Act and Assert
    assertEquals("\n \n <table><thead><tr>Headers\n </tr></thead><tbody>Not all who wander are lost\n </tbody></table>",
        freemarkerRendering.table(new FreemarkerVariable("form."), "Headers", "Not all who wander are lost"));
  }

  /**
   * Test {@link FreemarkerRendering#table(Variable, String, String)} with {@code Variable}, {@code String}, {@code String}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#table(Variable, String, String)}
   */
  @Test
  @DisplayName("Test table(Variable, String, String) with 'Variable', 'String', 'String'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.table(Variable, String, String)"})
  void testTableWithVariableStringString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals("\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['Name']!''}</span>\n" + " \n"
        + " <table><thead><tr>Headers\n" + " </tr></thead><tbody>Not all who wander are lost\n" + " </tbody></table>",
        freemarkerRendering.table(new FreemarkerVariable("Name"), "Headers", "Not all who wander are lost"));
  }

  /**
   * Test {@link FreemarkerRendering#tableCell(Map, String)} with {@code Map}, {@code String}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@code
   * <td foo="foo">Not all who wander are lost</td>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#tableCell(Map, String)}
   */
  @Test
  @DisplayName("Test tableCell(Map, String) with 'Map', 'String'; given 'foo'; then return '<td foo=\"foo\">Not all who wander are lost</td>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.tableCell(Map, String)"})
  void testTableCellWithMapString_givenFoo_thenReturnTdFooFooNotAllWhoWanderAreLostTd() {
    // Arrange
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("foo", "foo");

    // Act and Assert
    assertEquals("<td foo=\"foo\">Not all who wander are lost</td>",
        freemarkerRendering.tableCell(attributes, "Not all who wander are lost"));
  }

  /**
   * Test {@link FreemarkerRendering#tableCell(Map, String)} with {@code Map}, {@code String}.
   * <ul>
   *   <li>Then return {@code <td ="" foo="foo">Not all who wander are lost</td>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#tableCell(Map, String)}
   */
  @Test
  @DisplayName("Test tableCell(Map, String) with 'Map', 'String'; then return '<td =\"\" foo=\"foo\">Not all who wander are lost</td>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.tableCell(Map, String)"})
  void testTableCellWithMapString_thenReturnTdFooFooNotAllWhoWanderAreLostTd() {
    // Arrange
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("", "");
    attributes.put("foo", "foo");

    // Act and Assert
    assertEquals("<td =\"\" foo=\"foo\">Not all who wander are lost</td>",
        freemarkerRendering.tableCell(attributes, "Not all who wander are lost"));
  }

  /**
   * Test {@link FreemarkerRendering#tableCell(Map, String)} with {@code Map}, {@code String}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return <code>&lt;td&gt;Not all who wander are lost&lt;/td&gt;</code>.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#tableCell(Map, String)}
   */
  @Test
  @DisplayName("Test tableCell(Map, String) with 'Map', 'String'; when HashMap(); then return '<td>Not all who wander are lost</td>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.tableCell(Map, String)"})
  void testTableCellWithMapString_whenHashMap_thenReturnTdNotAllWhoWanderAreLostTd() {
    // Arrange, Act and Assert
    assertEquals("<td>Not all who wander are lost</td>",
        freemarkerRendering.tableCell(new HashMap<>(), "Not all who wander are lost"));
  }

  /**
   * Test {@link FreemarkerRendering#beginIterator(Variable, Variable)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with {@code Name}.</li>
   *   <li>Then return {@code <#list Name as Name>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#beginIterator(Variable, Variable)}
   */
  @Test
  @DisplayName("Test beginIterator(Variable, Variable); when FreemarkerVariable(String) with 'Name'; then return '<#list Name as Name>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.beginIterator(Variable, Variable)"})
  void testBeginIterator_whenFreemarkerVariableWithName_thenReturnListNameAsName() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    // Act and Assert
    assertEquals("\n <#list Name as Name>",
        freemarkerRendering.beginIterator(variable, new FreemarkerVariable("Name")));
  }

  /**
   * Test {@link FreemarkerRendering#endIterator(Variable)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with {@code Name}.</li>
   *   <li>Then return {@code </#list>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#endIterator(Variable)}
   */
  @Test
  @DisplayName("Test endIterator(Variable); when FreemarkerVariable(String) with 'Name'; then return '</#list>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.endIterator(Variable)"})
  void testEndIterator_whenFreemarkerVariableWithName_thenReturnList() {
    // Arrange, Act and Assert
    assertEquals("\n </#list>", freemarkerRendering.endIterator(new FreemarkerVariable("Name")));
  }

  /**
   * Test {@link FreemarkerRendering#tableRow(Variable, Variable, List)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with {@code Name}.</li>
   *   <li>Then return {@code <#list Name as Name>
   * <tr>
   *
   * </tr>
   *  </#list>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  @DisplayName("Test tableRow(Variable, Variable, List); when FreemarkerVariable(String) with 'Name'; then return '<#list Name as Name> <tr> </tr> </#list>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.tableRow(Variable, Variable, List)"})
  void testTableRow_whenFreemarkerVariableWithName_thenReturnListNameAsNameTrTrList() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");
    FreemarkerVariable subVar = new FreemarkerVariable("Name");

    // Act and Assert
    assertEquals("\n <#list Name as Name>\n  <tr>\n </tr>\n </#list>",
        freemarkerRendering.tableRow(variable, subVar, new ArrayList<>()));
  }

  /**
   * Test {@link FreemarkerRendering#tableHeaderRow(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code 42 foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#tableHeaderRow(List)}
   */
  @Test
  @DisplayName("Test tableHeaderRow(List); given '42'; when ArrayList() add '42'; then return '42 foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.tableHeaderRow(List)"})
  void testTableHeaderRow_given42_whenArrayListAdd42_thenReturn42Foo() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("42");
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("42\n\nfoo", freemarkerRendering.tableHeaderRow(contents));
  }

  /**
   * Test {@link FreemarkerRendering#tableHeaderRow(List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link ArrayList#ArrayList()} add empty string.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#tableHeaderRow(List)}
   */
  @Test
  @DisplayName("Test tableHeaderRow(List); given empty string; when ArrayList() add empty string; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.tableHeaderRow(List)"})
  void testTableHeaderRow_givenEmptyString_whenArrayListAddEmptyString_thenReturnFoo() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("\nfoo", freemarkerRendering.tableHeaderRow(contents));
  }

  /**
   * Test {@link FreemarkerRendering#tableHeaderRow(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#tableHeaderRow(List)}
   */
  @Test
  @DisplayName("Test tableHeaderRow(List); given 'foo'; when ArrayList() add 'foo'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.tableHeaderRow(List)"})
  void testTableHeaderRow_givenFoo_whenArrayListAddFoo_thenReturnFoo() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("foo");

    // Act and Assert
    assertEquals("foo", freemarkerRendering.tableHeaderRow(contents));
  }

  /**
   * Test {@link FreemarkerRendering#tableHeaderRow(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#tableHeaderRow(List)}
   */
  @Test
  @DisplayName("Test tableHeaderRow(List); when ArrayList(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.tableHeaderRow(List)"})
  void testTableHeaderRow_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", freemarkerRendering.tableHeaderRow(new ArrayList<>()));
  }

  /**
   * Test {@link FreemarkerRendering#tableRowCheckBox(Variable, Variable)}.
   * <ul>
   *   <li>Then return {@code <checkbox name="Name.${Name?index}.selected" />}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#tableRowCheckBox(Variable, Variable)}
   */
  @Test
  @DisplayName("Test tableRowCheckBox(Variable, Variable); then return '<checkbox name=\"Name.${Name?index}.selected\" />'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.tableRowCheckBox(Variable, Variable)"})
  void testTableRowCheckBox_thenReturnCheckboxNameNameNameIndexSelected() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    // Act and Assert
    assertEquals("<checkbox name=\"Name.${Name?index}.selected\" />",
        freemarkerRendering.tableRowCheckBox(variable, new FreemarkerVariable("Name")));
  }

  /**
   * Test {@link FreemarkerRendering#tableRowEditButton(Variable, Variable)}.
   * <ul>
   *   <li>Then return {@code <button name="Name[${Name?index}].table-edit-row">Edit</button>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#tableRowEditButton(Variable, Variable)}
   */
  @Test
  @DisplayName("Test tableRowEditButton(Variable, Variable); then return '<button name=\"Name[${Name?index}].table-edit-row\">Edit</button>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.tableRowEditButton(Variable, Variable)"})
  void testTableRowEditButton_thenReturnButtonNameNameNameIndexTableEditRowEditButton() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    // Act and Assert
    assertEquals("<button name=\"Name[${Name?index}].table-edit-row\">Edit</button>",
        freemarkerRendering.tableRowEditButton(variable, new FreemarkerVariable("Name")));
  }

  /**
   * Test {@link FreemarkerRendering#userDisplay(Variable)}.
   * <ul>
   *   <li>When {@link FreemarkerVariable#FreemarkerVariable(String)} with {@code Name}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerRendering#userDisplay(Variable)}
   */
  @Test
  @DisplayName("Test userDisplay(Variable); when FreemarkerVariable(String) with 'Name'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerRendering.userDisplay(Variable)"})
  void testUserDisplay_whenFreemarkerVariableWithName_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + " <#if Name??><#if Name.id??><#list Name.id as id>\n" + "  <#if id??>\n"
            + "  <#if id.type == 'com.symphony.user.userId'><mention uid=\"${id.value}\" /><#break></#if>\n"
            + "  <#if id.type == 'com.symphony.user.emailAddress'><mention email=\"${id.value}\" /><#break></#if>\n"
            + "  </#if></#list>\n" + "  <#elseif Name.name??>\n" + "   ${Name.name}\n" + " </#if></#if>",
        freemarkerRendering.userDisplay(new FreemarkerVariable("Name")));
  }
}
