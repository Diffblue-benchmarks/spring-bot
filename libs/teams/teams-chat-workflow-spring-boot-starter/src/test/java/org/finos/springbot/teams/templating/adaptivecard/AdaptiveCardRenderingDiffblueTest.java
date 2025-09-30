package org.finos.springbot.teams.templating.adaptivecard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable;
import org.finos.springbot.workflow.templating.Variable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AdaptiveCardRendering.class})
@ExtendWith(SpringExtension.class)
class AdaptiveCardRenderingDiffblueTest {
  @Autowired private AdaptiveCardRendering adaptiveCardRendering;

  /**
   * Test {@link AdaptiveCardRendering#nullProof(Variable)}.
   *
   * <ul>
   *   <li>When {@link ThymeleafVariable#ThymeleafVariable(String)} with {@code Name}.
   *   <li>Then return {@code ${if(Name,(Name),'')}}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCardRendering#nullProof(Variable)}
   */
  @Test
  @DisplayName(
      "Test nullProof(Variable); when ThymeleafVariable(String) with 'Name'; then return '${if(Name,(Name),'')}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdaptiveCardRendering.nullProof(Variable)"})
  void testNullProof_whenThymeleafVariableWithName_thenReturnIfNameName() {
    // Arrange, Act and Assert
    assertEquals(
        "${if(Name,(Name),'')}", adaptiveCardRendering.nullProof(new ThymeleafVariable("Name")));
  }

  /**
   * Test {@link AdaptiveCardRendering#nullProofWithFunction(Variable, String)}.
   *
   * <ul>
   *   <li>Then return {@code ${if(Name,Function(Name),'')}}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCardRendering#nullProofWithFunction(Variable, String)}
   */
  @Test
  @DisplayName(
      "Test nullProofWithFunction(Variable, String); then return '${if(Name,Function(Name),'')}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdaptiveCardRendering.nullProofWithFunction(Variable, String)"})
  void testNullProofWithFunction_thenReturnIfNameFunctionName() {
    // Arrange, Act and Assert
    assertEquals(
        "${if(Name,Function(Name),'')}",
        adaptiveCardRendering.nullProofWithFunction(new ThymeleafVariable("Name"), "Function"));
  }

  /**
   * Test {@link AdaptiveCardRendering#nullProofWithExtension(Variable, String)}.
   *
   * <ul>
   *   <li>Then return {@code ${if(Name,Name.0123456789ABCDEF,'')}}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCardRendering#nullProofWithExtension(Variable, String)}
   */
  @Test
  @DisplayName(
      "Test nullProofWithExtension(Variable, String); then return '${if(Name,Name.0123456789ABCDEF,'')}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdaptiveCardRendering.nullProofWithExtension(Variable, String)"})
  void testNullProofWithExtension_thenReturnIfNameName0123456789abcdef() {
    // Arrange, Act and Assert
    assertEquals(
        "${if(Name,Name.0123456789ABCDEF,'')}",
        adaptiveCardRendering.nullProofWithExtension(
            new ThymeleafVariable("Name"), "0123456789ABCDEF"));
  }

  /**
   * Test {@link AdaptiveCardRendering#fromOption(Variable, String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code ${if(Name.Ext,first(where(Options, o, o.Options Ext == Name)).Options
   *       Val,'')}}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCardRendering#fromOption(Variable, String, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test fromOption(Variable, String, String, String, String); then return '${if(Name.Ext,first(where(Options, o, o.Options Ext == Name)).Options Val,'')}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdaptiveCardRendering.fromOption(Variable, String, String, String, String)"
  })
  void testFromOption_thenReturnIfNameExtFirstWhereOptionsOOOptionsExtNameOptionsVal() {
    // Arrange, Act and Assert
    assertEquals(
        "${if(Name.Ext,first(where(Options, o, o.Options Ext == Name)).Options Val,'')}",
        adaptiveCardRendering.fromOption(
            new ThymeleafVariable("Name"), "Ext", "Options", "Options Ext", "Options Val"));
  }

  /**
   * Test {@link AdaptiveCardRendering#textField(Variable, boolean)}.
   *
   * <ul>
   *   <li>Then return iterator next toPrettyString is {@code "TextBlock"}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCardRendering#textField(Variable, boolean)}
   */
  @Test
  @DisplayName(
      "Test textField(Variable, boolean); then return iterator next toPrettyString is '\"TextBlock\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AdaptiveCardRendering.textField(Variable, boolean)"})
  void testTextField_thenReturnIteratorNextToPrettyStringIsTextBlock() {
    // Arrange and Act
    JsonNode actualTextFieldResult =
        adaptiveCardRendering.textField(new ThymeleafVariable("Name"), false);

    // Assert
    assertTrue(actualTextFieldResult instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = actualTextFieldResult.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(actualTextFieldResult.traverse() instanceof TreeTraversingParser);
    assertEquals("\"TextBlock\"", nextResult.toPrettyString());
    assertEquals(
        "{\n  \"type\" : \"TextBlock\",\n  \"text\" : \"${if(Name,(Name),'')}\"\n}",
        actualTextFieldResult.toPrettyString());
    assertEquals(2, actualTextFieldResult.size());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link AdaptiveCardRendering#addFieldName(String, JsonNode)} with {@code String}, {@code
   * JsonNode}.
   *
   * <ul>
   *   <li>Given {@code title}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCardRendering#addFieldName(String, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test addFieldName(String, JsonNode) with 'String', 'JsonNode'; given 'title'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AdaptiveCardRendering.addFieldName(String, JsonNode)"})
  void testAddFieldNameWithStringJsonNode_givenTitle_thenReturnNull() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode value = new ObjectNode(nc);
    value.put("title", DoubleNode.valueOf(10.0d));
    value.put("label", DoubleNode.valueOf(10.0d));

    // Act
    JsonNode actualAddFieldNameResult = adaptiveCardRendering.addFieldName(null, value);

    // Assert
    assertNull(actualAddFieldNameResult);
  }

  /**
   * Test {@link AdaptiveCardRendering#renderUserDropdown(Variable, String, String, String,
   * boolean)}.
   *
   * <ul>
   *   <li>Then iterator next traverse return {@link TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCardRendering#renderUserDropdown(Variable, String, String,
   * String, boolean)}
   */
  @Test
  @DisplayName(
      "Test renderUserDropdown(Variable, String, String, String, boolean); then iterator next traverse return TreeTraversingParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode AdaptiveCardRendering.renderUserDropdown(Variable, String, String, String, boolean)"
  })
  void testRenderUserDropdown_thenIteratorNextTraverseReturnTreeTraversingParser() {
    // Arrange and Act
    JsonNode actualRenderUserDropdownResult =
        adaptiveCardRendering.renderUserDropdown(
            new ThymeleafVariable("Name"), "Option Location", "Option Key", "42", false);

    // Assert
    assertTrue(actualRenderUserDropdownResult instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = actualRenderUserDropdownResult.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(actualRenderUserDropdownResult.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "\"${if(Name.key,first(where(Option Location, o, o.Option Key == Name)).42,'')}\"",
        nextResult2.toPrettyString());
    assertEquals("\"TextBlock\"", nextResult.toPrettyString());
    assertEquals(
        "{\n"
            + "  \"type\" : \"TextBlock\",\n"
            + "  \"text\" : \"${if(Name.key,first(where(Option Location, o, o.Option Key == Name)).42,'')}\"\n"
            + "}",
        actualRenderUserDropdownResult.toPrettyString());
    assertEquals(2, actualRenderUserDropdownResult.size());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link AdaptiveCardRendering#renderDropdown(Variable, String, String, String, String,
   * boolean)} with {@code variable}, {@code variableKey}, {@code location}, {@code key}, {@code
   * value}, {@code editMode}.
   *
   * <p>Method under test: {@link AdaptiveCardRendering#renderDropdown(Variable, String, String,
   * String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test renderDropdown(Variable, String, String, String, String, boolean) with 'variable', 'variableKey', 'location', 'key', 'value', 'editMode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode AdaptiveCardRendering.renderDropdown(Variable, String, String, String, String, boolean)"
  })
  void testRenderDropdownWithVariableVariableKeyLocationKeyValueEditMode() {
    // Arrange and Act
    JsonNode actualRenderDropdownResult =
        adaptiveCardRendering.renderDropdown(
            new ThymeleafVariable("Name"), "Variable Key", "Location", "Key", "42", false);

    // Assert
    assertTrue(actualRenderDropdownResult instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = actualRenderDropdownResult.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(actualRenderDropdownResult.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "\"${if(Name.Variable Key,first(where(Location, o, o.Key == Name)).42,'')}\"",
        nextResult2.toPrettyString());
    assertEquals("\"TextBlock\"", nextResult.toPrettyString());
    assertEquals(
        "{\n"
            + "  \"type\" : \"TextBlock\",\n"
            + "  \"text\" : \"${if(Name.Variable Key,first(where(Location, o, o.Key == Name)).42,'')}\"\n"
            + "}",
        actualRenderDropdownResult.toPrettyString());
    assertEquals(2, actualRenderDropdownResult.size());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link AdaptiveCardRendering#renderDropdown(Variable, String, Map, boolean)} with {@code
   * variable}, {@code variableKey}, {@code options}, {@code editMode}.
   *
   * <p>Method under test: {@link AdaptiveCardRendering#renderDropdown(Variable, String, Map,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test renderDropdown(Variable, String, Map, boolean) with 'variable', 'variableKey', 'options', 'editMode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode AdaptiveCardRendering.renderDropdown(Variable, String, Map, boolean)"
  })
  void testRenderDropdownWithVariableVariableKeyOptionsEditMode() {
    // Arrange
    ThymeleafVariable variable = new ThymeleafVariable("Name");

    // Act
    JsonNode actualRenderDropdownResult =
        adaptiveCardRendering.renderDropdown(variable, "Variable Key", new HashMap<>(), false);

    // Assert
    assertTrue(actualRenderDropdownResult instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = actualRenderDropdownResult.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(actualRenderDropdownResult.traverse() instanceof TreeTraversingParser);
    assertEquals("\"${if(Name,Name.Variable Key,'')}\"", nextResult2.toPrettyString());
    assertEquals("\"TextBlock\"", nextResult.toPrettyString());
    assertEquals(
        "{\n  \"type\" : \"TextBlock\",\n  \"text\" : \"${if(Name,Name.Variable Key,'')}\"\n}",
        actualRenderDropdownResult.toPrettyString());
    assertEquals(2, actualRenderDropdownResult.size());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link AdaptiveCardRendering#checkBox(Variable, boolean)}.
   *
   * <ul>
   *   <li>Then return iterator next toPrettyString is &quot;${if(Name,' ballot box with check ','
   *       ballot box ')}&quot;.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCardRendering#checkBox(Variable, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkBox(Variable, boolean); then return iterator next toPrettyString is \"${if(Name,' ballot box with check ',' ballot box ')}\"")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AdaptiveCardRendering.checkBox(Variable, boolean)"})
  void testCheckBox_thenReturnIteratorNextToPrettyStringIs$If() {
    // Arrange and Act
    JsonNode actualCheckBoxResult =
        adaptiveCardRendering.checkBox(new ThymeleafVariable("Name"), false);

    // Assert
    assertTrue(actualCheckBoxResult instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = actualCheckBoxResult.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(actualCheckBoxResult.traverse() instanceof TreeTraversingParser);
    assertEquals("\"${if(Name,'☑','☐')}\"", nextResult2.toPrettyString());
    assertEquals("\"TextBlock\"", nextResult.toPrettyString());
    assertEquals(
        "{\n  \"type\" : \"TextBlock\",\n  \"text\" : \"${if(Name,'☑','☐')}\"\n}",
        actualCheckBoxResult.toPrettyString());
    assertEquals(2, actualCheckBoxResult.size());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link AdaptiveCardRendering#collection(Type, Variable, Variable, JsonNode, boolean)} with
   * {@code Type}, {@code Variable}, {@code Variable}, {@code JsonNode}, {@code boolean}.
   *
   * <p>Method under test: {@link AdaptiveCardRendering#collection(Type, Variable, Variable,
   * JsonNode, boolean)}
   */
  @Test
  @DisplayName(
      "Test collection(Type, Variable, Variable, JsonNode, boolean) with 'Type', 'Variable', 'Variable', 'JsonNode', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode AdaptiveCardRendering.collection(Type, Variable, Variable, JsonNode, boolean)"
  })
  void testCollectionWithTypeVariableVariableJsonNodeBoolean() {
    // Arrange
    TypePlaceHolder t = new TypePlaceHolder(1);
    ThymeleafVariable v = new ThymeleafVariable("Name");
    ACVariable i = new ACVariable(null, "Data Path");
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode in = new ObjectNode(nc);
    in.put("$data", DoubleNode.valueOf(10.0d));

    // Act
    JsonNode actualCollectionResult = adaptiveCardRendering.collection(t, v, i, in, false);

    // Assert
    assertEquals("{\n  \"$data\" : \"${Name}\"\n}", in.toPrettyString());
    assertSame(in, actualCollectionResult);
  }

  /**
   * Test {@link AdaptiveCardRendering#collection(Type, Variable, Variable, JsonNode, boolean)} with
   * {@code Type}, {@code Variable}, {@code Variable}, {@code JsonNode}, {@code boolean}.
   *
   * <p>Method under test: {@link AdaptiveCardRendering#collection(Type, Variable, Variable,
   * JsonNode, boolean)}
   */
  @Test
  @DisplayName(
      "Test collection(Type, Variable, Variable, JsonNode, boolean) with 'Type', 'Variable', 'Variable', 'JsonNode', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode AdaptiveCardRendering.collection(Type, Variable, Variable, JsonNode, boolean)"
  })
  void testCollectionWithTypeVariableVariableJsonNodeBoolean2() {
    // Arrange
    AdaptiveCardRendering adaptiveCardRendering = new AdaptiveCardRendering();
    TypePlaceHolder t = new TypePlaceHolder(1);
    ThymeleafVariable v = new ThymeleafVariable("Name");
    ACVariable i = new ACVariable(null, "Data Path");
    TextNode textNode = new TextNode("foo");

    JsonNodeFactory nc = mock(JsonNodeFactory.class);
    when(nc.textNode(Mockito.<String>any())).thenReturn(textNode);

    ObjectNode in = new ObjectNode(nc);
    in.put("$data", BooleanNode.getFalse());

    // Act
    JsonNode actualCollectionResult = adaptiveCardRendering.collection(t, v, i, in, false);

    // Assert
    assertSame(in, actualCollectionResult);
    verify(nc).textNode("${Name}");
    Iterator<JsonNode> iteratorResult = in.iterator();
    JsonNode actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(textNode, actualNextResult);
    assertEquals("{\n  \"$data\" : \"foo\"\n}", in.toPrettyString());
  }
}
