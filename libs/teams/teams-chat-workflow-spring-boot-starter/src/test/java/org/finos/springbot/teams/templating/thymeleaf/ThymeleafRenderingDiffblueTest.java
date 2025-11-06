package org.finos.springbot.teams.templating.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

@ContextConfiguration(classes = {ThymeleafRendering.class})
@ExtendWith(SpringExtension.class)
class ThymeleafRenderingDiffblueTest {
  @Autowired
  private ThymeleafRendering thymeleafRendering;

  /**
   * Method under test: {@link ThymeleafRendering#description(String)}
   */
  @Test
  void testDescription() {
    // Arrange, Act and Assert
    assertEquals("<span>foo</span>", thymeleafRendering.description("foo"));
  }

  /**
   * Method under test: {@link ThymeleafRendering#list(List)}
   */
  @Test
  void testList() {
    // Arrange, Act and Assert
    assertEquals("<table></table>", thymeleafRendering.list(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ThymeleafRendering#list(List)}
   */
  @Test
  void testList2() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>foo</table>", thymeleafRendering.list(contents));
  }

  /**
   * Method under test: {@link ThymeleafRendering#list(List)}
   */
  @Test
  void testList3() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>\nfoo</table>", thymeleafRendering.list(contents));
  }

  /**
   * Method under test: {@link ThymeleafRendering#list(List)}
   */
  @Test
  void testList4() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("42");
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("<table>42\n\nfoo</table>", thymeleafRendering.list(contents));
  }

  /**
   * Method under test: {@link ThymeleafRendering#addFieldName(String, String)}
   */
  @Test
  void testAddFieldName() {
    // Arrange, Act and Assert
    assertEquals("<tr><td style=\"width: 200px\"><b>Field:</b></td><td>42</td></tr>",
        thymeleafRendering.addFieldName("Field", "42"));
    assertEquals("", thymeleafRendering.addFieldName("", "42"));
  }

  /**
   * Method under test:
   * {@link ThymeleafRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  void testRenderDropdown() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");

    // Act and Assert
    assertEquals("\n ", thymeleafRendering.renderDropdown(variable, "Variable Key", new HashMap<>(), true));
  }

  /**
   * Method under test: {@link ThymeleafRendering#textField(Variable, boolean)}
   */
  @Test
  void testTextField() {
    // Arrange, Act and Assert
    assertEquals("<span th:text=\"${Name}\">text</span>",
        thymeleafRendering.textField(new ThymeleafVariable("Name"), true));
  }

  /**
   * Method under test: {@link ThymeleafRendering#checkBox(Variable, boolean)}
   */
  @Test
  void testCheckBox() {
    // Arrange, Act and Assert
    assertEquals("<span th:text=\"${Name ? 'Y' : 'N'}\">boolean</span>",
        thymeleafRendering.checkBox(new ThymeleafVariable("Name"), true));
  }

  /**
   * Method under test:
   * {@link ThymeleafRendering#collection(Type, Variable, Variable, String, boolean)}
   */
  @Test
  void testCollection() {
    // Arrange
    TypePlaceHolder t = new TypePlaceHolder(1);
    ThymeleafVariable v = new ThymeleafVariable("Name");

    // Act and Assert
    assertEquals("<div th:each=\"Name : ${Name}\">In</div>",
        thymeleafRendering.collection(t, v, new ThymeleafVariable("Name"), "In", true));
  }

  /**
   * Method under test: {@link ThymeleafRendering#button(String, String)}
   */
  @Test
  void testButton() {
    // Arrange, Act and Assert
    assertNull(thymeleafRendering.button("Name", "42"));
  }

  /**
   * Method under test: {@link ThymeleafRendering#buttons(String)}
   */
  @Test
  void testButtons() {
    // Arrange, Act and Assert
    assertNull(thymeleafRendering.buttons("Location"));
  }

  /**
   * Method under test: {@link ThymeleafRendering#indent(Variable)}
   */
  @Test
  void testIndent() {
    // Arrange, Act and Assert
    assertEquals("\n ", thymeleafRendering.indent(new ThymeleafVariable("Name")));
  }

  /**
   * Method under test:
   * {@link ThymeleafRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  void testTableRow() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");
    ThymeleafVariable subVar = new ThymeleafVariable("Name");

    // Act and Assert
    assertEquals("\n <tr th:each=\"Name : ${Name}\">\n </tr>",
        thymeleafRendering.tableRow(variable, subVar, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ThymeleafRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  void testTableRow2() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");
    ThymeleafVariable subVar = new ThymeleafVariable("Name");

    ArrayList<String> cells = new ArrayList<>();
    cells.add("foo");

    // Act and Assert
    assertEquals("\n <tr th:each=\"Name : ${Name}\">foo\n </tr>", thymeleafRendering.tableRow(variable, subVar, cells));
  }

  /**
   * Method under test:
   * {@link ThymeleafRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  void testTableRow3() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");
    ThymeleafVariable subVar = new ThymeleafVariable("Name");

    ArrayList<String> cells = new ArrayList<>();
    cells.add("");
    cells.add("foo");

    // Act and Assert
    assertEquals("\n <tr th:each=\"Name : ${Name}\">\nfoo\n </tr>",
        thymeleafRendering.tableRow(variable, subVar, cells));
  }

  /**
   * Method under test:
   * {@link ThymeleafRendering#tableRow(Variable, Variable, List)}
   */
  @Test
  void testTableRow4() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");
    ThymeleafVariable subVar = new ThymeleafVariable("Name");

    ArrayList<String> cells = new ArrayList<>();
    cells.add("42");
    cells.add("");
    cells.add("foo");

    // Act and Assert
    assertEquals("\n <tr th:each=\"Name : ${Name}\">42\n\nfoo\n </tr>",
        thymeleafRendering.tableRow(variable, subVar, cells));
  }

  /**
   * Method under test: {@link ThymeleafRendering#tableHeaderRow(List)}
   */
  @Test
  void testTableHeaderRow() {
    // Arrange, Act and Assert
    assertEquals("", thymeleafRendering.tableHeaderRow(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ThymeleafRendering#tableHeaderRow(List)}
   */
  @Test
  void testTableHeaderRow2() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("foo");

    // Act and Assert
    assertEquals("foo", thymeleafRendering.tableHeaderRow(contents));
  }

  /**
   * Method under test: {@link ThymeleafRendering#tableHeaderRow(List)}
   */
  @Test
  void testTableHeaderRow3() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("\nfoo", thymeleafRendering.tableHeaderRow(contents));
  }

  /**
   * Method under test: {@link ThymeleafRendering#tableHeaderRow(List)}
   */
  @Test
  void testTableHeaderRow4() {
    // Arrange
    ArrayList<String> contents = new ArrayList<>();
    contents.add("42");
    contents.add("");
    contents.add("foo");

    // Act and Assert
    assertEquals("42\n\nfoo", thymeleafRendering.tableHeaderRow(contents));
  }

  /**
   * Method under test:
   * {@link ThymeleafRendering#tableRowCheckBox(Variable, Variable)}
   */
  @Test
  void testTableRowCheckBox() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> thymeleafRendering.tableRowCheckBox(variable, new ThymeleafVariable("Name")));
  }

  /**
   * Method under test:
   * {@link ThymeleafRendering#tableRowEditButton(Variable, Variable)}
   */
  @Test
  void testTableRowEditButton() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> thymeleafRendering.tableRowEditButton(variable, new ThymeleafVariable("Name")));
  }

  /**
   * Method under test: {@link ThymeleafRendering#userDisplay(Variable)}
   */
  @Test
  void testUserDisplay() {
    // Arrange, Act and Assert
    assertEquals("<at th:key=\"${Name?.key}\" th:text=\"${Name?.name}\">User Name</at>",
        thymeleafRendering.userDisplay(new ThymeleafVariable("Name")));
  }

  /**
   * Method under test: {@link ThymeleafRendering#table(Variable, String, String)}
   */
  @Test
  void testTable() {
    // Arrange, Act and Assert
    assertEquals("\n <table><thead><tr>Headers\n </tr></thead><tbody>Not all who wander are lost\n </tbody></table>",
        thymeleafRendering.table(new ThymeleafVariable("Name"), "Headers", "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link ThymeleafRendering#tableCell(Map, String)}
   */
  @Test
  void testTableCell() {
    // Arrange, Act and Assert
    assertEquals("<td>Not all who wander are lost</td>",
        thymeleafRendering.tableCell(new HashMap<>(), "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link ThymeleafRendering#tableCell(Map, String)}
   */
  @Test
  void testTableCell2() {
    // Arrange
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("foo", "foo");

    // Act and Assert
    assertEquals("<td foo=\"foo\">Not all who wander are lost</td>",
        thymeleafRendering.tableCell(attributes, "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link ThymeleafRendering#tableCell(Map, String)}
   */
  @Test
  void testTableCell3() {
    // Arrange
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put("", "");
    attributes.put("foo", "foo");

    // Act and Assert
    assertEquals("<td =\"\" foo=\"foo\">Not all who wander are lost</td>",
        thymeleafRendering.tableCell(attributes, "Not all who wander are lost"));
  }
}
