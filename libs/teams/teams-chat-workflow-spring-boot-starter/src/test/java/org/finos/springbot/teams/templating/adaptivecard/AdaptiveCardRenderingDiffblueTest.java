package org.finos.springbot.teams.templating.adaptivecard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable;
import org.finos.springbot.workflow.templating.Variable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AdaptiveCardRendering.class})
@ExtendWith(SpringExtension.class)
class AdaptiveCardRenderingDiffblueTest {
  @Autowired
  private AdaptiveCardRendering adaptiveCardRendering;

  /**
   * Test {@link AdaptiveCardRendering#nullProof(Variable)}.
   * <ul>
   *   <li>When {@link ThymeleafVariable#ThymeleafVariable(String)} with {@code Name}.</li>
   *   <li>Then return {@code ${if(Name,(Name),'')}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdaptiveCardRendering#nullProof(Variable)}
   */
  @Test
  @DisplayName("Test nullProof(Variable); when ThymeleafVariable(String) with 'Name'; then return '${if(Name,(Name),'')}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.adaptivecard.AdaptiveCardRendering.nullProof(org.finos.springbot.workflow.templating.Variable)"})
  void testNullProof_whenThymeleafVariableWithName_thenReturnIfNameName() {
    // Arrange, Act and Assert
    assertEquals("${if(Name,(Name),'')}", adaptiveCardRendering.nullProof(new ThymeleafVariable("Name")));
  }

  /**
   * Test {@link AdaptiveCardRendering#nullProofWithFunction(Variable, String)}.
   * <ul>
   *   <li>Then return {@code ${if(Name,Function(Name),'')}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdaptiveCardRendering#nullProofWithFunction(Variable, String)}
   */
  @Test
  @DisplayName("Test nullProofWithFunction(Variable, String); then return '${if(Name,Function(Name),'')}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.adaptivecard.AdaptiveCardRendering.nullProofWithFunction(org.finos.springbot.workflow.templating.Variable, java.lang.String)"})
  void testNullProofWithFunction_thenReturnIfNameFunctionName() {
    // Arrange, Act and Assert
    assertEquals("${if(Name,Function(Name),'')}",
        adaptiveCardRendering.nullProofWithFunction(new ThymeleafVariable("Name"), "Function"));
  }

  /**
   * Test {@link AdaptiveCardRendering#nullProofWithExtension(Variable, String)}.
   * <ul>
   *   <li>Then return {@code ${if(Name,Name.0123456789ABCDEF,'')}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdaptiveCardRendering#nullProofWithExtension(Variable, String)}
   */
  @Test
  @DisplayName("Test nullProofWithExtension(Variable, String); then return '${if(Name,Name.0123456789ABCDEF,'')}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.adaptivecard.AdaptiveCardRendering.nullProofWithExtension(org.finos.springbot.workflow.templating.Variable, java.lang.String)"})
  void testNullProofWithExtension_thenReturnIfNameName0123456789abcdef() {
    // Arrange, Act and Assert
    assertEquals("${if(Name,Name.0123456789ABCDEF,'')}",
        adaptiveCardRendering.nullProofWithExtension(new ThymeleafVariable("Name"), "0123456789ABCDEF"));
  }

  /**
   * Test {@link AdaptiveCardRendering#fromOption(Variable, String, String, String, String)}.
   * <ul>
   *   <li>Then return {@code ${if(Name.Ext,first(where(Options, o, o.Options Ext == Name)).Options Val,'')}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdaptiveCardRendering#fromOption(Variable, String, String, String, String)}
   */
  @Test
  @DisplayName("Test fromOption(Variable, String, String, String, String); then return '${if(Name.Ext,first(where(Options, o, o.Options Ext == Name)).Options Val,'')}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.adaptivecard.AdaptiveCardRendering.fromOption(org.finos.springbot.workflow.templating.Variable, java.lang.String, java.lang.String, java.lang.String, java.lang.String)"})
  void testFromOption_thenReturnIfNameExtFirstWhereOptionsOOOptionsExtNameOptionsVal() {
    // Arrange, Act and Assert
    assertEquals("${if(Name.Ext,first(where(Options, o, o.Options Ext == Name)).Options Val,'')}", adaptiveCardRendering
        .fromOption(new ThymeleafVariable("Name"), "Ext", "Options", "Options Ext", "Options Val"));
  }

  /**
   * Test {@link AdaptiveCardRendering#textField(Variable, boolean)}.
   * <ul>
   *   <li>Then return iterator next toPrettyString is {@code "${if(Data Path,(Data Path),'')}"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdaptiveCardRendering#textField(Variable, boolean)}
   */
  @Test
  @DisplayName("Test textField(Variable, boolean); then return iterator next toPrettyString is '\"${if(Data Path,(Data Path),'')}\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.fasterxml.jackson.databind.JsonNode org.finos.springbot.teams.templating.adaptivecard.AdaptiveCardRendering.textField(org.finos.springbot.workflow.templating.Variable, boolean)"})
  void testTextField_thenReturnIteratorNextToPrettyStringIsIfDataPathDataPath() {
    // Arrange
    ACVariable variable = mock(ACVariable.class);
    when(variable.getDataPath()).thenReturn("Data Path");

    // Act
    JsonNode actualTextFieldResult = adaptiveCardRendering.textField(variable, false);

    // Assert
    verify(variable, atLeast(1)).getDataPath();
    assertTrue(actualTextFieldResult instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = actualTextFieldResult.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(actualTextFieldResult.traverse() instanceof TreeTraversingParser);
    assertEquals("\"${if(Data Path,(Data Path),'')}\"", nextResult2.toPrettyString());
    assertEquals("\"TextBlock\"", nextResult.toPrettyString());
    assertEquals("{\r\n  \"type\" : \"TextBlock\",\r\n  \"text\" : \"${if(Data Path,(Data Path),'')}\"\r\n}",
        actualTextFieldResult.toPrettyString());
    assertEquals(2, actualTextFieldResult.size());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link AdaptiveCardRendering#addFieldName(String, JsonNode)} with {@code String}, {@code JsonNode}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdaptiveCardRendering#addFieldName(String, JsonNode)}
   */
  @Test
  @DisplayName("Test addFieldName(String, JsonNode) with 'String', 'JsonNode'; when empty string; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.fasterxml.jackson.databind.JsonNode org.finos.springbot.teams.templating.adaptivecard.AdaptiveCardRendering.addFieldName(java.lang.String, com.fasterxml.jackson.databind.JsonNode)"})
  void testAddFieldNameWithStringJsonNode_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(adaptiveCardRendering.addFieldName("", mock(ArrayNode.class)));
  }

  /**
   * Test {@link AdaptiveCardRendering#renderUserDropdown(Variable, String, String, String, boolean)}.
   * <ul>
   *   <li>Then iterator next traverse return {@link TreeTraversingParser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdaptiveCardRendering#renderUserDropdown(Variable, String, String, String, boolean)}
   */
  @Test
  @DisplayName("Test renderUserDropdown(Variable, String, String, String, boolean); then iterator next traverse return TreeTraversingParser")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.fasterxml.jackson.databind.JsonNode org.finos.springbot.teams.templating.adaptivecard.AdaptiveCardRendering.renderUserDropdown(org.finos.springbot.workflow.templating.Variable, java.lang.String, java.lang.String, java.lang.String, boolean)"})
  void testRenderUserDropdown_thenIteratorNextTraverseReturnTreeTraversingParser() {
    // Arrange
    ACVariable variable = mock(ACVariable.class);
    when(variable.getDataPath()).thenReturn("Data Path");

    // Act
    JsonNode actualRenderUserDropdownResult = adaptiveCardRendering.renderUserDropdown(variable, "Option Location",
        "Option Key", "42", false);

    // Assert
    verify(variable, atLeast(1)).getDataPath();
    assertTrue(actualRenderUserDropdownResult instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = actualRenderUserDropdownResult.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(actualRenderUserDropdownResult.traverse() instanceof TreeTraversingParser);
    assertEquals("\"${if(Data Path.key,first(where(Option Location, o, o.Option Key == Data Path)).42,'')}\"",
        nextResult2.toPrettyString());
    assertEquals("\"TextBlock\"", nextResult.toPrettyString());
    assertEquals("{\r\n" + "  \"type\" : \"TextBlock\",\r\n"
        + "  \"text\" : \"${if(Data Path.key,first(where(Option Location, o, o.Option Key == Data Path)).42,'')}\""
        + "\r\n" + "}", actualRenderUserDropdownResult.toPrettyString());
    assertEquals(2, actualRenderUserDropdownResult.size());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link AdaptiveCardRendering#renderDropdown(Variable, String, String, String, String, boolean)} with {@code variable}, {@code variableKey}, {@code location}, {@code key}, {@code value}, {@code editMode}.
   * <p>
   * Method under test: {@link AdaptiveCardRendering#renderDropdown(Variable, String, String, String, String, boolean)}
   */
  @Test
  @DisplayName("Test renderDropdown(Variable, String, String, String, String, boolean) with 'variable', 'variableKey', 'location', 'key', 'value', 'editMode'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.fasterxml.jackson.databind.JsonNode org.finos.springbot.teams.templating.adaptivecard.AdaptiveCardRendering.renderDropdown(org.finos.springbot.workflow.templating.Variable, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)"})
  void testRenderDropdownWithVariableVariableKeyLocationKeyValueEditMode() {
    // Arrange
    ACVariable variable = mock(ACVariable.class);
    when(variable.getDataPath()).thenReturn("Data Path");

    // Act
    JsonNode actualRenderDropdownResult = adaptiveCardRendering.renderDropdown(variable, "Variable Key", "Location",
        "Key", "42", false);

    // Assert
    verify(variable, atLeast(1)).getDataPath();
    assertTrue(actualRenderDropdownResult instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = actualRenderDropdownResult.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(actualRenderDropdownResult.traverse() instanceof TreeTraversingParser);
    assertEquals("\"${if(Data Path.Variable Key,first(where(Location, o, o.Key == Data Path)).42,'')}\"",
        nextResult2.toPrettyString());
    assertEquals("\"TextBlock\"", nextResult.toPrettyString());
    assertEquals("{\r\n" + "  \"type\" : \"TextBlock\",\r\n"
        + "  \"text\" : \"${if(Data Path.Variable Key,first(where(Location, o, o.Key == Data Path)).42,'')}\"\r\n"
        + "}", actualRenderDropdownResult.toPrettyString());
    assertEquals(2, actualRenderDropdownResult.size());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link AdaptiveCardRendering#renderDropdown(Variable, String, Map, boolean)} with {@code variable}, {@code variableKey}, {@code options}, {@code editMode}.
   * <p>
   * Method under test: {@link AdaptiveCardRendering#renderDropdown(Variable, String, Map, boolean)}
   */
  @Test
  @DisplayName("Test renderDropdown(Variable, String, Map, boolean) with 'variable', 'variableKey', 'options', 'editMode'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.fasterxml.jackson.databind.JsonNode org.finos.springbot.teams.templating.adaptivecard.AdaptiveCardRendering.renderDropdown(org.finos.springbot.workflow.templating.Variable, java.lang.String, java.util.Map, boolean)"})
  void testRenderDropdownWithVariableVariableKeyOptionsEditMode() {
    // Arrange
    ACVariable variable = mock(ACVariable.class);
    when(variable.getDataPath()).thenReturn("Data Path");

    // Act
    JsonNode actualRenderDropdownResult = adaptiveCardRendering.renderDropdown(variable, "Variable Key",
        new HashMap<>(), false);

    // Assert
    verify(variable, atLeast(1)).getDataPath();
    assertTrue(actualRenderDropdownResult instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = actualRenderDropdownResult.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(actualRenderDropdownResult.traverse() instanceof TreeTraversingParser);
    assertEquals("\"${if(Data Path,Data Path.Variable Key,'')}\"", nextResult2.toPrettyString());
    assertEquals("\"TextBlock\"", nextResult.toPrettyString());
    assertEquals("{\r\n  \"type\" : \"TextBlock\",\r\n  \"text\" : \"${if(Data Path,Data Path.Variable Key,'')}\"\r\n}",
        actualRenderDropdownResult.toPrettyString());
    assertEquals(2, actualRenderDropdownResult.size());
    assertFalse(iteratorResult.hasNext());
  }
}
