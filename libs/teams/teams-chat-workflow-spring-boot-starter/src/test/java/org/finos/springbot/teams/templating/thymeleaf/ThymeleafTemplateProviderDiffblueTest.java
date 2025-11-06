package org.finos.springbot.teams.templating.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.microsoft.bot.schema.Entity;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.finos.springbot.teams.content.TeamsChannel;
import org.finos.springbot.teams.response.templating.MarkupAndEntities;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.io.ApplicationResourceLoader;
import org.springframework.core.io.ResourceLoader;

class ThymeleafTemplateProviderDiffblueTest {
  /**
   * Method under test: {@link ThymeleafTemplateProvider#needsButtons(Response)}
   */
  @Test
  void testNeedsButtons() {
    // Arrange, Act and Assert
    assertFalse(ThymeleafTemplateProvider
        .needsButtons(new MessageResponse(new TeamsChannel("42", "Name"), "Not all who wander are lost")));
    assertFalse(
        ThymeleafTemplateProvider.needsButtons(new WorkResponse(new TeamsChannel("42", "Name"), "42", WorkMode.BOTH)));
  }

  /**
   * Method under test: {@link ThymeleafTemplateProvider#needsButtons(Response)}
   */
  @Test
  void testNeedsButtons2() {
    // Arrange
    TeamsChannel stream = new TeamsChannel("42", "Name");

    // Act and Assert
    assertFalse(ThymeleafTemplateProvider.needsButtons(new ErrorResponse(stream, new Throwable())));
  }

  /**
   * Method under test:
   * {@link ThymeleafTemplateProvider#deserializeTemplate(InputStream)}
   */
  @Test
  void testDeserializeTemplate() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplateProvider thymeleafTemplateProvider = new ThymeleafTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl,
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering()));
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("AXAXAXAX", thymeleafTemplateProvider.deserializeTemplate(is));
    assertEquals(-1, is.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ThymeleafTemplateProvider#applyTemplate(String, WorkResponse)}
   */
  @Test
  void testApplyTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplateProvider thymeleafTemplateProvider = new ThymeleafTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl,
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering()));

    // Act
    MarkupAndEntities actualApplyTemplateResult = thymeleafTemplateProvider.applyTemplate("Template",
        new WorkResponse(new TeamsChannel("42", "Name"), "42", WorkMode.BOTH));

    // Assert
    assertEquals("Template", actualApplyTemplateResult.getContents());
    assertTrue(actualApplyTemplateResult.getEntities().isEmpty());
  }

  /**
   * Method under test:
   * {@link ThymeleafTemplateProvider#applyTemplate(String, WorkResponse)}
   */
  @Test
  void testApplyTemplate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplateProvider thymeleafTemplateProvider = new ThymeleafTemplateProvider("$", "Template Suffix",
        "Default Template Name", rl, new ThymeleafTemplater(fieldConverters, new ThymeleafRendering()));

    // Act
    MarkupAndEntities actualApplyTemplateResult = thymeleafTemplateProvider.applyTemplate("Template",
        new WorkResponse(new TeamsChannel("42", "Name"), "42", WorkMode.BOTH));

    // Assert
    assertEquals("Template", actualApplyTemplateResult.getContents());
    assertTrue(actualApplyTemplateResult.getEntities().isEmpty());
  }

  /**
   * Method under test:
   * {@link ThymeleafTemplateProvider#applyTemplate(String, WorkResponse)}
   */
  @Test
  void testApplyTemplate3() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplateProvider thymeleafTemplateProvider = new ThymeleafTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl,
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering()));

    // Act
    MarkupAndEntities actualApplyTemplateResult = thymeleafTemplateProvider.applyTemplate("<at key=\"UU\">UU</at>",
        new WorkResponse(new TeamsChannel("42", "Name"), "42", WorkMode.BOTH));

    // Assert
    List<Entity> entities = actualApplyTemplateResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    Map<String, JsonNode> properties = getResult.getProperties();
    assertEquals(2, properties.size());
    JsonNode getResult2 = properties.get("mentioned");
    assertTrue(getResult2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = getResult2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode getResult3 = properties.get("text");
    assertTrue(getResult3 instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = getResult2.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonParser traverseResult3 = getResult3.traverse();
    assertTrue(traverseResult3 instanceof TreeTraversingParser);
    assertEquals("<at>UU</at>", actualApplyTemplateResult.getContents());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    JsonStreamContext parsingContext3 = traverseResult3.getParsingContext();
    assertEquals("ROOT", parsingContext3.getTypeDesc());
    assertEquals("\"<at>UU</at>\"", getResult3.toPrettyString());
    assertEquals("\"UU\"", nextResult.toPrettyString());
    Version versionResult = traverseResult3.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.16.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("mention", getResult.getType());
    assertEquals("{\n  \"id\" : \"UU\",\n  \"name\" : \"UU\"\n}", getResult2.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult3.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult3.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult3.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult3.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult3.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    assertNull(traverseResult3.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult3.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult3.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult3.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult3.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult3.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(traverseResult3.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(parsingContext3.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult3.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult3.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(traverseResult3.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult3.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult3.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult3.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult3.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, traverseResult3.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext3.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext3.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, parsingContext3.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0, getResult3.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0.0d, traverseResult2.getValueAsDouble());
    assertEquals(0.0d, traverseResult3.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, traverseResult3.getValueAsLong());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(2, getResult2.size());
    assertEquals(JsonNodeType.OBJECT, getResult2.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertEquals(JsonNodeType.STRING, getResult3.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult3.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult3.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult3.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult3.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult3.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult3.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult3.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(traverseResult3.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext3.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext3.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(parsingContext3.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(getResult2.isArray());
    assertFalse(getResult3.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(getResult2.isBigDecimal());
    assertFalse(getResult3.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(getResult2.isBigInteger());
    assertFalse(getResult3.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(getResult2.isBinary());
    assertFalse(getResult3.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(getResult2.isBoolean());
    assertFalse(getResult3.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(getResult3.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(getResult2.isDouble());
    assertFalse(getResult3.isDouble());
    assertFalse(getResult2.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(getResult2.isFloat());
    assertFalse(getResult3.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(getResult2.isFloatingPointNumber());
    assertFalse(getResult3.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(getResult2.isInt());
    assertFalse(getResult3.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(getResult2.isIntegralNumber());
    assertFalse(getResult3.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(getResult2.isLong());
    assertFalse(getResult3.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(getResult2.isMissingNode());
    assertFalse(getResult3.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(getResult2.isNull());
    assertFalse(getResult3.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(getResult2.isNumber());
    assertFalse(getResult3.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(getResult3.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(getResult2.isPojo());
    assertFalse(getResult3.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(getResult2.isShort());
    assertFalse(getResult3.isShort());
    assertFalse(getResult2.isTextual());
    assertFalse(getResult2.isValueNode());
    Iterator<JsonNode> iteratorResult2 = getResult3.iterator();
    assertFalse(iteratorResult2.hasNext());
    assertTrue(getResult2.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(getResult3.isEmpty());
    assertTrue(getResult2.isObject());
    assertTrue(nextResult.isTextual());
    assertTrue(getResult3.isTextual());
    assertTrue(nextResult.isValueNode());
    assertTrue(getResult3.isValueNode());
    assertTrue(iteratorResult.hasNext());
    assertEquals(Short.SIZE, versionResult.getMinorVersion());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult2.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(currentLocation, traverseResult3.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(versionResult, traverseResult2.version());
    assertSame(iteratorResult2, nextResult.iterator());
  }

  /**
   * Method under test:
   * {@link ThymeleafTemplateProvider#ThymeleafTemplateProvider(String, String, String, ResourceLoader, ThymeleafTemplater)}
   */
  @Test
  void testNewThymeleafTemplateProvider() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();

    // Act
    ThymeleafTemplateProvider actualThymeleafTemplateProvider = new ThymeleafTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl,
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering()));

    // Assert
    assertEquals("", actualThymeleafTemplateProvider.deserializeTemplate(null));
    assertNull(actualThymeleafTemplateProvider.getTemplateForName("Name"));
  }

  /**
   * Method under test:
   * {@link ThymeleafTemplateProvider#ThymeleafTemplateProvider(String, String, String, ResourceLoader, ThymeleafTemplater)}
   */
  @Test
  void testNewThymeleafTemplateProvider2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();

    // Act
    ThymeleafTemplateProvider actualThymeleafTemplateProvider = new ThymeleafTemplateProvider("default-edit",
        "Template Suffix", "Default Template Name", rl,
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering()));

    // Assert
    assertEquals("", actualThymeleafTemplateProvider.deserializeTemplate(null));
    assertNull(actualThymeleafTemplateProvider.getTemplateForName("Name"));
  }
}
