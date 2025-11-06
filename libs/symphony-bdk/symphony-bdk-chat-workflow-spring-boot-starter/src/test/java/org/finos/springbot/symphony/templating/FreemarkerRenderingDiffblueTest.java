package org.finos.springbot.symphony.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.springbot.workflow.templating.Variable;
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
   * Method under test: {@link FreemarkerRendering#description(String)}
   */
  @Test
  void testDescription() {
    // Arrange, Act and Assert
    assertEquals("<span>foo</span>", freemarkerRendering.description("foo"));
  }

  /**
   * Method under test: {@link FreemarkerRendering#list(List)}
   */
  @Test
  void testList() {
    // Arrange, Act and Assert
    assertEquals("<table></table>", freemarkerRendering.list(new ArrayList<>()));
  }

  /**
   * Method under test: {@link FreemarkerRendering#list(List)}
   */
  @Test
  void testList2() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>foo</table>", freemarkerRendering.list(contents));
  }

  /**
   * Method under test: {@link FreemarkerRendering#list(List)}
   */
  @Test
  void testList3() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>\nfoo</table>", freemarkerRendering.list(contents));
  }

  /**
   * Method under test: {@link FreemarkerRendering#list(List)}
   */
  @Test
  void testList4() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("42");
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>42\n\nfoo</table>", freemarkerRendering.list(contents));
  }

  /**
   * Method under test: {@link FreemarkerRendering#addFieldName(String, String)}
   */
  @Test
  void testAddFieldName() {
    // Arrange, Act and Assert
    assertEquals("<tr><td style=\"width: 200px\"><b>Field:</b></td><td>42</td></tr>",
        freemarkerRendering.addFieldName("Field", "42"));
    assertEquals("", freemarkerRendering.addFieldName("", "42"));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  void testRenderDropdown() {
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
   * Method under test:
   * {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  void testRenderDropdown2() {
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
   * Method under test:
   * {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  void testRenderDropdown3() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("form.");

    // Act and Assert
    assertEquals(
        "\n" + " <div style=\"min-height: 100px;\"><select \n" + "  name=\"\"\n"
            + "  data-placeholder=\"Choose form.\">\n" + " \n" + " </select></div>",
        freemarkerRendering.renderDropdown(variable, "Variable Key", new HashMap<>(), true));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  void testRenderDropdown4() {
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
   * Method under test:
   * {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  void testRenderDropdown5() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    HashMap<String, String> options = new HashMap<>();
    options.put("UU", "UU");

    // Act and Assert
    assertEquals("\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['Name']!''}</span>\n"
        + " <div style=\"min-height: 100px;\"><select \n" + "  name=\"Name\"\n"
        + "  data-placeholder=\"Choose name\">\n"
        + "    <option value=\"UU\" selected=\"${(((NameVariable Key)!'') == 'UU')?string('true','false')}\">UU</option>"
        + "\n" + " </select></div>", freemarkerRendering.renderDropdown(variable, "Variable Key", options, true));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  void testRenderDropdown6() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    HashMap<String, String> options = new HashMap<>();
    options.put("form.", "form.");
    options.put("UU", "UU");

    // Act and Assert
    assertEquals("\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['Name']!''}</span>\n"
        + " <div style=\"min-height: 100px;\"><select \n" + "  name=\"Name\"\n"
        + "  data-placeholder=\"Choose name\">\n"
        + "    <option value=\"UU\" selected=\"${(((NameVariable Key)!'') == 'UU')?string('true','false')}\">UU</option>"
        + "\n"
        + "   <option value=\"form.\" selected=\"${(((NameVariable Key)!'') == 'form.')?string('true','false')}\""
        + ">form.</option>\n" + " </select></div>",
        freemarkerRendering.renderDropdown(variable, "Variable Key", options, true));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  void testRenderDropdown7() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    // Act and Assert
    assertEquals("\n ", freemarkerRendering.renderDropdown(variable, "Variable Key", new HashMap<>(), false));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  void testRenderDropdown8() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    HashMap<String, String> options = new HashMap<>();
    options.put("UU", "UU");

    // Act and Assert
    assertEquals("\n    <#if ((NameVariable Key)!'') == 'UU'>UU</#if>",
        freemarkerRendering.renderDropdown(variable, "Variable Key", options, false));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  void testRenderDropdown9() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    HashMap<String, String> options = new HashMap<>();
    options.put("form.", "form.");
    options.put("UU", "UU");

    // Act and Assert
    assertEquals(
        "\n" + "    <#if ((NameVariable Key)!'') == 'UU'>UU</#if>\n"
            + "   <#if ((NameVariable Key)!'') == 'form.'>form.</#if>",
        freemarkerRendering.renderDropdown(variable, "Variable Key", options, false));
  }

  /**
   * Method under test: {@link FreemarkerRendering#textField(Variable, boolean)}
   */
  @Test
  void testTextField() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['Name']!''}</span>\n"
            + " <text-field \n" + "  name=\"Name\"\n" + "  placeholder=\"\">${(Name)!''}</text-field>",
        freemarkerRendering.textField(new FreemarkerVariable("Name"), true));
    assertEquals("\n <text-field \n  name=\"\"\n  placeholder=\"\">${(form.)!''}</text-field>",
        freemarkerRendering.textField(new FreemarkerVariable("form."), true));
    assertEquals("${(Name)!''}", freemarkerRendering.textField(new FreemarkerVariable("Name"), false));
  }

  /**
   * Method under test: {@link FreemarkerRendering#checkBox(Variable, boolean)}
   */
  @Test
  void testCheckBox() {
    // Arrange, Act and Assert
    assertEquals("\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['Name']!''}</span>\n"
        + " <checkbox \n" + "  name=\"Name\"\n" + "  checked=\"${Name?string('true', 'false')}\"\n"
        + "  value=\"true\">name</checkbox>", freemarkerRendering.checkBox(new FreemarkerVariable("Name"), true));
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UU']!''}</span>\n" + " <checkbox \n"
            + "  name=\"UU\"\n" + "  checked=\"${UU?string('true', 'false')}\"\n" + "  value=\"true\">u u</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UU"), true));
    assertEquals(
        "\n <checkbox \n  name=\"\"\n  checked=\"${form.?string('true', 'false')}\"\n  value=\"true\">form.</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("form."), true));
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['(.)(\\p{Upper})']!''}</span>\n"
            + " <checkbox \n" + "  name=\"(.)(\\p{Upper})\"\n"
            + "  checked=\"${(.)(\\p{Upper})?string('true', 'false')}\"\n"
            + "  value=\"true\">(.)(\\p{ upper})</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("(.)(\\p{Upper})"), true));
    assertEquals("${(Name)?string(\"Y\", \"N\")}", freemarkerRendering.checkBox(new FreemarkerVariable("Name"), false));
    assertEquals("\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UUUU']!''}</span>\n"
        + " <checkbox \n" + "  name=\"UUUU\"\n" + "  checked=\"${UUUU?string('true', 'false')}\"\n"
        + "  value=\"true\">u uu u</checkbox>", freemarkerRendering.checkBox(new FreemarkerVariable("UUUU"), true));
    assertEquals(
        "\n" + " <checkbox \n" + "  name=\"\"\n" + "  checked=\"${UUform.?string('true', 'false')}\"\n"
            + "  value=\"true\">u uform.</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UUform."), true));
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UUname']!''}</span>\n"
            + " <checkbox \n" + "  name=\"UUname\"\n" + "  checked=\"${UUname?string('true', 'false')}\"\n"
            + "  value=\"true\">u uname</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UUname"), true));
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UUchecked']!''}</span>\n"
            + " <checkbox \n" + "  name=\"UUchecked\"\n" + "  checked=\"${UUchecked?string('true', 'false')}\"\n"
            + "  value=\"true\">u uchecked</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UUchecked"), true));
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UUvalue']!''}</span>\n"
            + " <checkbox \n" + "  name=\"UUvalue\"\n" + "  checked=\"${UUvalue?string('true', 'false')}\"\n"
            + "  value=\"true\">u uvalue</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UUvalue"), true));
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UUName']!''}</span>\n"
            + " <checkbox \n" + "  name=\"UUName\"\n" + "  checked=\"${UUName?string('true', 'false')}\"\n"
            + "  value=\"true\">u uname</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UUName"), true));
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['UUtrue']!''}</span>\n"
            + " <checkbox \n" + "  name=\"UUtrue\"\n" + "  checked=\"${UUtrue?string('true', 'false')}\"\n"
            + "  value=\"true\">u utrue</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("UUtrue"), true));
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['?string(\"Y\", \"N\")']!''}</span>\n"
            + " <checkbox \n" + "  name=\"?string(\"Y\", \"N\")\"\n"
            + "  checked=\"${?string(\"Y\", \"N\")?string('true', 'false')}\"\n"
            + "  value=\"true\">?string(\" y\", \" n\")</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("?string(\"Y\", \"N\")"), true));
    assertEquals(
        "\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['?string(\"Y\", \"N\")?string(\"Y\","
            + " \"N\")']!''}</span>\n" + " <checkbox \n" + "  name=\"?string(\"Y\", \"N\")?string(\"Y\", \"N\")\"\n"
            + "  checked=\"${?string(\"Y\", \"N\")?string(\"Y\", \"N\")?string('true', 'false')}\"\n"
            + "  value=\"true\">?string(\" y\", \" n\")?string(\" y\", \" n\")</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("?string(\"Y\", \"N\")?string(\"Y\", \"N\")"), true));
    assertEquals("\n"
        + " <span class=\"tempo-text-color--red\">${entity.errors.contents['?string(\"Y\", \"N\")Name']!''}</span>\n"
        + " <checkbox \n" + "  name=\"?string(\"Y\", \"N\")Name\"\n"
        + "  checked=\"${?string(\"Y\", \"N\")Name?string('true', 'false')}\"\n"
        + "  value=\"true\">?string(\" y\", \" n\") name</checkbox>",
        freemarkerRendering.checkBox(new FreemarkerVariable("?string(\"Y\", \"N\")Name"), true));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#collection(Type, Variable, Variable, String, boolean)}
   */
  @Test
  void testCollection() {
    // Arrange
    TypePlaceHolder t = new TypePlaceHolder(1);
    FreemarkerVariable v = new FreemarkerVariable("Name");

    // Act and Assert
    assertNull(freemarkerRendering.collection(t, v, new FreemarkerVariable("Name"), "In", true));
  }

  /**
   * Method under test: {@link FreemarkerRendering#button(String, String)}
   */
  @Test
  void testButton() {
    // Arrange, Act and Assert
    assertEquals("<button name=\"42\">Text</button>", freemarkerRendering.button("Text", "42"));
  }

  /**
   * Method under test: {@link FreemarkerRendering#buttons(String)}
   */
  @Test
  void testButtons() {
    // Arrange, Act and Assert
    assertNull(freemarkerRendering.buttons("Location"));
  }

  /**
   * Method under test: {@link FreemarkerRendering#indent(Variable)}
   */
  @Test
  void testIndent() {
    // Arrange, Act and Assert
    assertEquals("\n ", freemarkerRendering.indent(new FreemarkerVariable("Name")));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#table(Variable, String, String)}
   */
  @Test
  void testTable() {
    // Arrange, Act and Assert
    assertEquals("\n" + " <span class=\"tempo-text-color--red\">${entity.errors.contents['Name']!''}</span>\n" + " \n"
        + " <table><thead><tr>Headers\n" + " </tr></thead><tbody>Not all who wander are lost\n" + " </tbody></table>",
        freemarkerRendering.table(new FreemarkerVariable("Name"), "Headers", "Not all who wander are lost"));
    assertEquals("\n \n <table><thead><tr>Headers\n </tr></thead><tbody>Not all who wander are lost\n </tbody></table>",
        freemarkerRendering.table(new FreemarkerVariable("form."), "Headers", "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link FreemarkerRendering#tableCell(Map, String)}
   */
  @Test
  void testTableCell() {
    // Arrange, Act and Assert
    assertEquals("<td>Not all who wander are lost</td>",
        freemarkerRendering.tableCell(new HashMap<>(), "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link FreemarkerRendering#tableCell(Map, String)}
   */
  @Test
  void testTableCell2() {
    // Arrange
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("foo", "foo");

    // Act and Assert
    assertEquals("<td foo=\"foo\">Not all who wander are lost</td>",
        freemarkerRendering.tableCell(attributes, "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link FreemarkerRendering#tableCell(Map, String)}
   */
  @Test
  void testTableCell3() {
    // Arrange
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("", "");
    attributes.put("foo", "foo");

    // Act and Assert
    assertEquals("<td =\"\" foo=\"foo\">Not all who wander are lost</td>",
        freemarkerRendering.tableCell(attributes, "Not all who wander are lost"));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#beginIterator(Variable, Variable)}
   */
  @Test
  void testBeginIterator() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    // Act and Assert
    assertEquals("\n <#list Name as Name>",
        freemarkerRendering.beginIterator(variable, new FreemarkerVariable("Name")));
  }

  /**
   * Method under test: {@link FreemarkerRendering#endIterator(Variable)}
   */
  @Test
  void testEndIterator() {
    // Arrange, Act and Assert
    assertEquals("\n </#list>", freemarkerRendering.endIterator(new FreemarkerVariable("Name")));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  void testTableRow() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");
    FreemarkerVariable subVar = new FreemarkerVariable("Name");

    // Act and Assert
    assertEquals("\n <#list Name as Name>\n  <tr>\n </tr>\n </#list>",
        freemarkerRendering.tableRow(variable, subVar, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  void testTableRow2() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");
    FreemarkerVariable subVar = new FreemarkerVariable("Name");

    ArrayList<String> cells = new ArrayList<>();
    cells.add("foo");

    // Act and Assert
    assertEquals("\n <#list Name as Name>\n  <tr>foo\n </tr>\n </#list>",
        freemarkerRendering.tableRow(variable, subVar, cells));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  void testTableRow3() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");
    FreemarkerVariable subVar = new FreemarkerVariable("Name");

    ArrayList<String> cells = new ArrayList<>();
    cells.add("");
    cells.add("foo");

    // Act and Assert
    assertEquals("\n <#list Name as Name>\n  <tr>\nfoo\n </tr>\n </#list>",
        freemarkerRendering.tableRow(variable, subVar, cells));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  void testTableRow4() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");
    FreemarkerVariable subVar = new FreemarkerVariable("Name");

    ArrayList<String> cells = new ArrayList<>();
    cells.add("42");
    cells.add("");
    cells.add("foo");

    // Act and Assert
    assertEquals("\n <#list Name as Name>\n  <tr>42\n\nfoo\n </tr>\n </#list>",
        freemarkerRendering.tableRow(variable, subVar, cells));
  }

  /**
   * Method under test: {@link FreemarkerRendering#tableHeaderRow(List)}
   */
  @Test
  void testTableHeaderRow() {
    // Arrange, Act and Assert
    assertEquals("", freemarkerRendering.tableHeaderRow(new ArrayList<>()));
  }

  /**
   * Method under test: {@link FreemarkerRendering#tableHeaderRow(List)}
   */
  @Test
  void testTableHeaderRow2() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("foo");

    // Act and Assert
    assertEquals("foo", freemarkerRendering.tableHeaderRow(contents));
  }

  /**
   * Method under test: {@link FreemarkerRendering#tableHeaderRow(List)}
   */
  @Test
  void testTableHeaderRow3() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("\nfoo", freemarkerRendering.tableHeaderRow(contents));
  }

  /**
   * Method under test: {@link FreemarkerRendering#tableHeaderRow(List)}
   */
  @Test
  void testTableHeaderRow4() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("42");
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("42\n\nfoo", freemarkerRendering.tableHeaderRow(contents));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#tableRowCheckBox(Variable, Variable)}
   */
  @Test
  void testTableRowCheckBox() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    // Act and Assert
    assertEquals("<checkbox name=\"Name.${Name?index}.selected\" />",
        freemarkerRendering.tableRowCheckBox(variable, new FreemarkerVariable("Name")));
  }

  /**
   * Method under test:
   * {@link FreemarkerRendering#tableRowEditButton(Variable, Variable)}
   */
  @Test
  void testTableRowEditButton() {
    // Arrange
    FreemarkerVariable variable = new FreemarkerVariable("Name");

    // Act and Assert
    assertEquals("<button name=\"Name[${Name?index}].table-edit-row\">Edit</button>",
        freemarkerRendering.tableRowEditButton(variable, new FreemarkerVariable("Name")));
  }

  /**
   * Method under test: {@link FreemarkerRendering#userDisplay(Variable)}
   */
  @Test
  void testUserDisplay() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + " <#if Name??><#if Name.id??><#list Name.id as id>\n" + "  <#if id??>\n"
            + "  <#if id.type == 'com.symphony.user.userId'><mention uid=\"${id.value}\" /><#break></#if>\n"
            + "  <#if id.type == 'com.symphony.user.emailAddress'><mention email=\"${id.value}\" /><#break></#if>\n"
            + "  </#if></#list>\n" + "  <#elseif Name.name??>\n" + "   ${Name.name}\n" + " </#if></#if>",
        freemarkerRendering.userDisplay(new FreemarkerVariable("Name")));
  }
}
