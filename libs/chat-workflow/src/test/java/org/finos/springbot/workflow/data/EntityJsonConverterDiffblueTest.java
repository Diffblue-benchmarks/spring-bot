package org.finos.springbot.workflow.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.entityjson.EntityJsonTypeResolverBuilder;
import org.finos.springbot.entityjson.VersionSpace;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.response.DataResponse;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.http.converter.json.SpringHandlerInstantiator;

class EntityJsonConverterDiffblueTest {
  /**
   * Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  void testReadValue() throws JsonProcessingException {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    ObjectMapper objectMapper = new ObjectMapper();

    // Act and Assert
    assertTrue(entityJsonConverter.readValue(objectMapper.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  void testReadValue2() throws JsonProcessingException {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    ObjectMapper objectMapper = new ObjectMapper();

    // Act and Assert
    assertTrue(entityJsonConverter.readValue(objectMapper.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  void testReadValue3() throws JsonProcessingException {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    om.setDefaultLeniency(true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    ObjectMapper objectMapper = new ObjectMapper();

    // Act and Assert
    assertTrue(entityJsonConverter.readValue(objectMapper.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  void testReadValue4() throws JsonProcessingException {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    Class<Object> target = Object.class;
    Class<EntityJsonConverter> mixinSource = EntityJsonConverter.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    ObjectMapper objectMapper = new ObjectMapper();

    // Act and Assert
    assertTrue(entityJsonConverter.readValue(objectMapper.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  void testReadValue5() throws JsonProcessingException {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(new ObjectMapper(), initial);

    ObjectMapper objectMapper = new ObjectMapper();

    // Act and Assert
    assertTrue(entityJsonConverter.readValue(objectMapper.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  void testReadValue6() throws JsonProcessingException {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    EntityJson entityJson = new EntityJson();
    entityJson.put("foo", 42);

    // Act
    EntityJson actualReadValueResult = entityJsonConverter
        .readValue((new ObjectMapper()).writeValueAsString(entityJson));

    // Assert
    assertEquals(1, actualReadValueResult.size());
    assertTrue(actualReadValueResult.containsKey("foo"));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue() {
    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertEquals("\"Ej\"", (new EntityJsonConverter(om, new ArrayList<>())).writeValue("Ej"));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue2() {
    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new EntityJsonConverter(om, new ArrayList<>())).writeValue(null));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue3() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));

    // Act and Assert
    assertEquals("\"Ej\"", (new EntityJsonConverter(new ObjectMapper(), initial)).writeValue("Ej"));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue4() {
    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertEquals("19088743", (new EntityJsonConverter(om, new ArrayList<>())).writeValue(19088743));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue5() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    om.configure(SerializationFeature.WRAP_ROOT_VALUE, true);

    // Act and Assert
    assertEquals("{\"String\":\"Ej\"}", (new EntityJsonConverter(om, new ArrayList<>())).writeValue("Ej"));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue6() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(new ObjectMapper(), initial);
    Class<Object> toUse2 = Object.class;

    // Act and Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0, \"}",
        entityJsonConverter.writeValue(new VersionSpace(toUse2)));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue7() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(new ObjectMapper(), initial);
    Class<Object> toUse2 = Object.class;

    // Act and Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0.2\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0.2,"
            + " , 1.0.2\"}",
        entityJsonConverter.writeValue(new VersionSpace(toUse2, "1.0.2", "1.0.2")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue8() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    om.configure(SerializationFeature.INDENT_OUTPUT, true);

    // Act and Assert
    assertEquals("\"Ej\"", (new EntityJsonConverter(om, new ArrayList<>())).writeValue("Ej"));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue9() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Class<Object> toUse2 = Object.class;

    // Act and Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0, \"}",
        entityJsonConverter.writeValue(new VersionSpace(toUse2)));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue10() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    Class<Object> target = Object.class;
    Class<EntityJsonConverter> mixinSource = EntityJsonConverter.class;
    om.addMixIn(target, mixinSource);

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Class<Object> toUse2 = Object.class;

    // Act and Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0, \"}",
        entityJsonConverter.writeValue(new VersionSpace(toUse2)));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue11() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    om.setDefaultLeniency(true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Class<Object> toUse2 = Object.class;

    // Act and Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0, \"}",
        entityJsonConverter.writeValue(new VersionSpace(toUse2)));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue12() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    om.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Class<Object> toUse2 = Object.class;

    // Act and Assert
    assertEquals(
        "{\"VersionSpace\":{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0\",\"toUse\":\"java.lang.Object\",\"versions"
            + "\":\"1.0, \"}}",
        entityJsonConverter.writeValue(new VersionSpace(toUse2)));
  }

  /**
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  void testWriteValue13() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(new ObjectMapper(), initial);
    Class<Object> toUse2 = Object.class;

    // Act and Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0.2\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0.2, ,"
            + " 1.0.2, Read Versions\"}",
        entityJsonConverter.writeValue(new VersionSpace(toUse2, "1.0.2", "1.0.2", "Read Versions")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#fromJson(String, Object)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new EntityJsonConverter(om, new ArrayList<>())).fromJson("42", "Json"));
  }

  /**
   * Method under test: {@link EntityJsonConverter#fromJson(String, Object)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));

    // Act and Assert
    assertNull((new EntityJsonConverter(new ObjectMapper(), initial))
        .fromJson("org.finos.springbot.workflow.data.EntityJsonConverter", null));
  }

  /**
   * Method under test: {@link EntityJsonConverter#getObjectMapper()}
   */
  @Test
  void testGetObjectMapper() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertSame(entityJsonConverter.om, entityJsonConverter.getObjectMapper());
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals("{}", entityJsonConverter.formatData(new DataResponse(null, new HashMap<>(), "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData2() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals("{}", entityJsonConverter.formatData(new DataResponse(null, new HashMap<>(), "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData3() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    om.setDefaultLeniency(true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals("{}", entityJsonConverter.formatData(new DataResponse(null, new HashMap<>(), "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData4() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    om.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals("{\"HashMap\":{}}",
        entityJsonConverter.formatData(new DataResponse(null, new HashMap<>(), "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData5() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    Class<Object> target = Object.class;
    Class<EntityJsonConverter> mixinSource = EntityJsonConverter.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals("{}", entityJsonConverter.formatData(new DataResponse(null, new HashMap<>(), "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData6() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(new ObjectMapper(), initial);

    // Act and Assert
    assertEquals("{}", entityJsonConverter.formatData(new DataResponse(null, new HashMap<>(), "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData7() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    HashMap<String, Object> data = new HashMap<>();
    data.put("foo", "42");

    // Act and Assert
    assertEquals("{\"foo\":\"42\"}", entityJsonConverter.formatData(new DataResponse(null, data, "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData8() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    HashMap<String, Object> data = new HashMap<>();
    data.put(null, "42");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> entityJsonConverter.formatData(new DataResponse(null, data, "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData9() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    HashMap<String, Object> data = new HashMap<>();
    data.put("foo", 1);

    // Act and Assert
    assertEquals("{\"foo\":1}", entityJsonConverter.formatData(new DataResponse(null, data, "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData10() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals(
        "{\"buttons\":{\"type\":\"org.finos.springbot.workflow.form.buttonList\",\"contents\":[]},\"form\":\"42\",\"errors"
            + "\":{\"type\":\"org.finos.springbot.workflow.form.errorMap\",\"contents\":{}}}",
        entityJsonConverter.formatData(new WorkResponse(null, "42", WorkMode.BOTH)));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData11() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals(
        "{\"buttons\":{\"type\":\"org.finos.springbot.workflow.form.buttonList\",\"contents\":[]},\"form\":\"42\",\"errors"
            + "\":{\"type\":\"org.finos.springbot.workflow.form.errorMap\",\"contents\":{}}}",
        entityJsonConverter.formatData(new WorkResponse(null, "42", WorkMode.BOTH)));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData12() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    SpringHandlerInstantiator hi = new SpringHandlerInstantiator(new DefaultListableBeanFactory());
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    BasicClassIntrospector ci2 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns2 = new PropertyNamingStrategy();
    TypeFactory tf2 = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer2 = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/mm/dd");
    SpringHandlerInstantiator hi2 = new SpringHandlerInstantiator(new DefaultListableBeanFactory());
    Locale locale2 = Locale.getDefault();
    TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase642 = Base64Variants.getDefaultVariant();
    BaseSettings base2 = new BaseSettings(ci2, ai2, pns2, tf2, typer2, dateFormat2, hi2, locale2, tz2, defaultBase642,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(null);
    RootNameLookup rootNames = new RootNameLookup();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(
        new SerializationConfig(base2, str2, mixins, rootNames, new ConfigOverrides()));
    RootNameLookup rootNames2 = new RootNameLookup();
    om.setConfig(new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides()));
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals("{}", entityJsonConverter.formatData(new DataResponse(null, new HashMap<>(), "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData13() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    om.configure(SerializationFeature.INDENT_OUTPUT, true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals("{ }", entityJsonConverter.formatData(new DataResponse(null, new HashMap<>(), "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData14() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    om.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    HashMap<String, Object> data = new HashMap<>();
    data.put("foo", "42");

    // Act and Assert
    assertEquals("{\"HashMap\":{\"foo\":\"42\"}}",
        entityJsonConverter.formatData(new DataResponse(null, data, "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData15() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    om.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    HashMap<String, Object> data = new HashMap<>();
    data.put(null, "42");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> entityJsonConverter.formatData(new DataResponse(null, data, "Template Name")));
  }

  /**
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  void testFormatData16() {
    // Arrange
    ObjectMapper om = new ObjectMapper();
    Class<Object> target = Object.class;
    Class<EntityJsonConverter> mixinSource = EntityJsonConverter.class;
    om.addMixIn(target, mixinSource);
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals(
        "{\"buttons\":{\"type\":\"org.finos.springbot.workflow.form.buttonList\",\"contents\":[]},\"form\":\"42\",\"errors"
            + "\":{\"type\":\"org.finos.springbot.workflow.form.errorMap\",\"contents\":{}}}",
        entityJsonConverter.formatData(new WorkResponse(null, "42", WorkMode.BOTH)));
  }

  /**
   * Method under test:
   * {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}
   */
  @Test
  void testNewEntityJsonConverter() {
    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act
    EntityJsonConverter actualEntityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Assert
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = actualEntityJsonConverter.ejtsb;
    assertEquals("type", entityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(entityJsonTypeResolverBuilder.getDefaultImpl());
    assertFalse(entityJsonTypeResolverBuilder.isTypeIdVisible());
    assertSame(om, actualEntityJsonConverter.getObjectMapper());
  }

  /**
   * Method under test:
   * {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}
   */
  @Test
  void testNewEntityJsonConverter2() {
    // Arrange
    ObjectMapper om = new ObjectMapper();

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));

    // Act
    EntityJsonConverter actualEntityJsonConverter = new EntityJsonConverter(om, initial);

    // Assert
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = actualEntityJsonConverter.ejtsb;
    assertEquals("type", entityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(entityJsonTypeResolverBuilder.getDefaultImpl());
    assertFalse(entityJsonTypeResolverBuilder.isTypeIdVisible());
    assertSame(om, actualEntityJsonConverter.getObjectMapper());
  }

  /**
   * Method under test:
   * {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}
   */
  @Test
  void testNewEntityJsonConverter3() {
    // Arrange
    ObjectMapper om = new ObjectMapper();

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    Class<Object> toUse2 = Object.class;
    initial.add(new VersionSpace(toUse2));

    // Act
    EntityJsonConverter actualEntityJsonConverter = new EntityJsonConverter(om, initial);

    // Assert
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = actualEntityJsonConverter.ejtsb;
    assertEquals("type", entityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(entityJsonTypeResolverBuilder.getDefaultImpl());
    assertFalse(entityJsonTypeResolverBuilder.isTypeIdVisible());
    assertSame(om, actualEntityJsonConverter.getObjectMapper());
  }
}
