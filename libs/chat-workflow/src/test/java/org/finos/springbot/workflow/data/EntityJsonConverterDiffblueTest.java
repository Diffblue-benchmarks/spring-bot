package org.finos.springbot.workflow.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.ConstructorDetector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.entityjson.EntityJsonTypeResolverBuilder;
import org.finos.springbot.entityjson.VersionSpace;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.response.DataResponse;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityJsonConverterDiffblueTest {
  /**
   * Test {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}
   */
  @Test
  @DisplayName("Test new EntityJsonConverter(ObjectMapper, List); given 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonConverter.<init>(ObjectMapper, List)"})
  void testNewEntityJsonConverter_givenJavaLangObject() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

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
   * Test {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}
   */
  @Test
  @DisplayName("Test new EntityJsonConverter(ObjectMapper, List); given 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonConverter.<init>(ObjectMapper, List)"})
  void testNewEntityJsonConverter_givenJavaLangObject2() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

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

  /**
   * Test {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}
   */
  @Test
  @DisplayName("Test new EntityJsonConverter(ObjectMapper, List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonConverter.<init>(ObjectMapper, List)"})
  void testNewEntityJsonConverter_whenArrayList() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

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
   * Test {@link EntityJsonConverter#readValue(String)}.
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName("Test readValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue() throws JsonProcessingException {
    // Arrange
    ConstructorDetector cd = mock(ConstructorDetector.class);
    when(cd.requireCtorAnnotation()).thenThrow(new UnsupportedOperationException());

    Builder builderResult = JsonMapper.builder();
    builderResult.constructorDetector(cd);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> entityJsonConverter.readValue(jsonMapper.writeValueAsString(new EntityJson())));
    verify(cd).requireCtorAnnotation();
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link VersionSpace#VersionSpace(Class)} with
   *       toUse is {@link Object}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName(
      "Test readValue(String); given ArrayList() add VersionSpace(Class) with toUse is Object; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue_givenArrayListAddVersionSpaceWithToUseIsObject_thenReturnEmpty()
      throws JsonProcessingException {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue(
        entityJsonConverter.readValue(jsonMapper.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   *
   * <ul>
   *   <li>Given builder addMixIn {@link Object} and {@link Object}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName(
      "Test readValue(String); given builder addMixIn Object and Object; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue_givenBuilderAddMixInObjectAndObject_thenReturnEmpty()
      throws JsonProcessingException {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue(
        entityJsonConverter.readValue(jsonMapper.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   *
   * <ul>
   *   <li>Given builder annotationIntrospector {@link JacksonAnnotationIntrospector} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName(
      "Test readValue(String); given builder annotationIntrospector JacksonAnnotationIntrospector (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue_givenBuilderAnnotationIntrospectorJacksonAnnotationIntrospector()
      throws JsonProcessingException {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    builderResult.annotationIntrospector(new JacksonAnnotationIntrospector());
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue(
        entityJsonConverter.readValue(jsonMapper.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   *
   * <ul>
   *   <li>Given {@code EntityJsonConverter}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName(
      "Test readValue(String); given 'org.finos.springbot.workflow.data.EntityJsonConverter'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue_givenOrgFinosSpringbotWorkflowDataEntityJsonConverter()
      throws JsonProcessingException {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<EntityJsonConverter> mixinSource = EntityJsonConverter.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue(
        entityJsonConverter.readValue(jsonMapper.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstructorDetector#shouldIntrospectorImplicitConstructors(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName("Test readValue(String); then calls shouldIntrospectorImplicitConstructors(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue_thenCallsShouldIntrospectorImplicitConstructors()
      throws JsonProcessingException {
    // Arrange
    ConstructorDetector cd = mock(ConstructorDetector.class);
    when(cd.singleArgCreatorDefaultsToProperties()).thenReturn(true);
    when(cd.requireCtorAnnotation()).thenReturn(true);
    when(cd.shouldIntrospectorImplicitConstructors(Mockito.<Class<?>>any())).thenReturn(true);

    Builder builderResult = JsonMapper.builder();
    builderResult.defaultLeniency(true);
    builderResult.constructorDetector(cd);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    EntityJson actualReadValueResult =
        entityJsonConverter.readValue(jsonMapper.writeValueAsString(new EntityJson()));

    // Assert
    verify(cd).requireCtorAnnotation();
    verify(cd).shouldIntrospectorImplicitConstructors(isA(Class.class));
    verify(cd).singleArgCreatorDefaultsToProperties();
    assertTrue(actualReadValueResult.isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName("Test readValue(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue_thenReturnEmpty() throws JsonProcessingException {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue(
        entityJsonConverter.readValue(jsonMapper.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   *
   * <ul>
   *   <li>When {@code Json}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName("Test readValue(String); when 'Json'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue_whenJson_thenThrowUnsupportedOperationException() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> entityJsonConverter.readValue("Json"));
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName("Test readValue(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue_whenNull_thenReturnNull() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertNull(entityJsonConverter.readValue(null));
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   *
   * <p>Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.writeValue(Object)"})
  void testWriteValue() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Class<Object> toUse2 = Object.class;

    // Act
    String actualWriteValueResult = entityJsonConverter.writeValue(new VersionSpace(toUse2));

    // Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0, \"}",
        actualWriteValueResult);
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   *
   * <p>Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.writeValue(Object)"})
  void testWriteValue2() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Class<Object> toUse2 = Object.class;
    VersionSpace versionSpace = new VersionSpace(toUse2, "1.0.2", "1.0.2");

    // Act
    String actualWriteValueResult = entityJsonConverter.writeValue(versionSpace);

    // Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0.2\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0.2,"
            + " , 1.0.2\"}",
        actualWriteValueResult);
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   *
   * <p>Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.writeValue(Object)"})
  void testWriteValue3() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Class<Object> toUse2 = Object.class;
    VersionSpace versionSpace = new VersionSpace(toUse2, "1.0.2", "1.0.2", "Read Versions");

    // Act
    String actualWriteValueResult = entityJsonConverter.writeValue(versionSpace);

    // Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0.2\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0.2, ,"
            + " 1.0.2, Read Versions\"}",
        actualWriteValueResult);
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   *
   * <ul>
   *   <li>Given builder addMixIn {@link Object} and {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object); given builder addMixIn Object and Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.writeValue(Object)"})
  void testWriteValue_givenBuilderAddMixInObjectAndObject() {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Class<Object> toUse2 = Object.class;

    // Act
    String actualWriteValueResult = entityJsonConverter.writeValue(new VersionSpace(toUse2));

    // Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0, \"}",
        actualWriteValueResult);
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   *
   * <ul>
   *   <li>Given builder annotationIntrospector {@link JacksonAnnotationIntrospector} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValue(Object); given builder annotationIntrospector JacksonAnnotationIntrospector (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.writeValue(Object)"})
  void testWriteValue_givenBuilderAnnotationIntrospectorJacksonAnnotationIntrospector() {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    builderResult.annotationIntrospector(new JacksonAnnotationIntrospector());
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Class<Object> toUse2 = Object.class;

    // Act
    String actualWriteValueResult = entityJsonConverter.writeValue(new VersionSpace(toUse2));

    // Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0, \"}",
        actualWriteValueResult);
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   *
   * <ul>
   *   <li>Given builder defaultLeniency {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object); given builder defaultLeniency 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.writeValue(Object)"})
  void testWriteValue_givenBuilderDefaultLeniencyTrue() {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    builderResult.defaultLeniency(true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Class<Object> toUse2 = Object.class;

    // Act
    String actualWriteValueResult = entityJsonConverter.writeValue(new VersionSpace(toUse2));

    // Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0, \"}",
        actualWriteValueResult);
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@code Ej}.
   *   <li>Then return {@code "Ej"}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object); given 'java.lang.Object'; when 'Ej'; then return '\"Ej\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.writeValue(Object)"})
  void testWriteValue_givenJavaLangObject_whenEj_thenReturnEj() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);

    // Act and Assert
    assertEquals("\"Ej\"", entityJsonConverter.writeValue("Ej"));
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   *
   * <ul>
   *   <li>Given {@code EntityJsonConverter}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValue(Object); given 'org.finos.springbot.workflow.data.EntityJsonConverter'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.writeValue(Object)"})
  void testWriteValue_givenOrgFinosSpringbotWorkflowDataEntityJsonConverter() {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<EntityJsonConverter> mixinSource = EntityJsonConverter.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Class<Object> toUse2 = Object.class;

    // Act
    String actualWriteValueResult = entityJsonConverter.writeValue(new VersionSpace(toUse2));

    // Assert
    assertEquals(
        "{\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0\",\"toUse\":\"java.lang.Object\",\"versions\":\"1.0, \"}",
        actualWriteValueResult);
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   *
   * <ul>
   *   <li>When {@code 19088743}.
   *   <li>Then return {@code 19088743}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object); when '19088743'; then return '19088743'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.writeValue(Object)"})
  void testWriteValue_when19088743_thenReturn19088743() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals("19088743", entityJsonConverter.writeValue(19088743));
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   *
   * <ul>
   *   <li>When {@code Ej}.
   *   <li>Then return {@code "Ej"}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object); when 'Ej'; then return '\"Ej\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.writeValue(Object)"})
  void testWriteValue_whenEj_thenReturnEj() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals("\"Ej\"", entityJsonConverter.writeValue("Ej"));
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.writeValue(Object)"})
  void testWriteValue_whenNull_thenReturnNull() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertNull(entityJsonConverter.writeValue(null));
  }

  /**
   * Test {@link EntityJsonConverter#fromJson(String, Object)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstructorDetector#requireCtorAnnotation()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#fromJson(String, Object)}
   */
  @Test
  @DisplayName("Test fromJson(String, Object); then calls requireCtorAnnotation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EntityJsonConverter.fromJson(String, Object)"})
  void testFromJson_thenCallsRequireCtorAnnotation() {
    // Arrange
    ConstructorDetector cd = mock(ConstructorDetector.class);
    when(cd.requireCtorAnnotation()).thenThrow(new UnsupportedOperationException());

    Builder builderResult = JsonMapper.builder();
    builderResult.constructorDetector(cd);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityJsonConverter.fromJson(
                "org.finos.springbot.workflow.data.EntityJsonConverter", "Json"));
    verify(cd).requireCtorAnnotation();
  }

  /**
   * Test {@link EntityJsonConverter#fromJson(String, Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#fromJson(String, Object)}
   */
  @Test
  @DisplayName("Test fromJson(String, Object); when '42'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EntityJsonConverter.fromJson(String, Object)"})
  void testFromJson_when42_thenThrowUnsupportedOperationException() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> entityJsonConverter.fromJson("42", "Json"));
  }

  /**
   * Test {@link EntityJsonConverter#getObjectMapper()}.
   *
   * <p>Method under test: {@link EntityJsonConverter#getObjectMapper()}
   */
  @Test
  @DisplayName("Test getObjectMapper()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper EntityJsonConverter.getObjectMapper()"})
  void testGetObjectMapper() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act
    ObjectMapper actualObjectMapper = entityJsonConverter.getObjectMapper();

    // Assert
    assertSame(entityJsonConverter.om, actualObjectMapper);
  }

  /**
   * Test {@link EntityJsonConverter#addVersionSpace(VersionSpace)}.
   *
   * <ul>
   *   <li>Then calls {@link VersionSpace#getToUse()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#addVersionSpace(VersionSpace)}
   */
  @Test
  @DisplayName("Test addVersionSpace(VersionSpace); then calls getToUse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonConverter.addVersionSpace(VersionSpace)"})
  void testAddVersionSpace_thenCallsGetToUse() {
    // Arrange
    VersionSpace versionSpace = mock(VersionSpace.class);
    Class<EntityJsonConverter> forNameResult = EntityJsonConverter.class;
    Mockito.<Class<?>>when(versionSpace.getToUse()).thenReturn(forNameResult);

    ArrayList<VersionSpace> initial = new ArrayList<>();
    initial.add(versionSpace);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);

    VersionSpace vs = mock(VersionSpace.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(vs.getToUse()).thenReturn(forNameResult2);

    // Act
    entityJsonConverter.addVersionSpace(vs);

    // Assert
    verify(versionSpace).getToUse();
    verify(vs).getToUse();
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Addressable resultTo = mock(Addressable.class);
    Class<Object> toUse2 = Object.class;
    VersionSpace versionSpace = new VersionSpace(toUse2, "1.0.2", "1.0.2");

    WorkResponse dr = new WorkResponse(resultTo, versionSpace, WorkMode.BOTH);

    // Act
    String actualFormatDataResult = entityJsonConverter.formatData(dr);

    // Assert
    assertEquals(
        "{\"buttons\":{\"type\":\"org.finos.springbot.workflow.form.buttonList\",\"contents\":[]},\"form\":{\"type\":\"org"
            + ".finos.springbot.entityjson.versionSpace\",\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0.2\",\"toUse"
            + "\":\"java.lang.Object\",\"versions\":\"1.0.2, , 1.0.2\"},\"errors\":{\"type\":\"org.finos.springbot.workflow.form"
            + ".errorMap\",\"contents\":{}}}",
        actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData2() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Addressable resultTo = mock(Addressable.class);
    Class<Object> toUse2 = Object.class;
    VersionSpace versionSpace = new VersionSpace(toUse2, "1.0.2", "1.0.2", ".");

    WorkResponse dr = new WorkResponse(resultTo, versionSpace, WorkMode.BOTH);

    // Act
    String actualFormatDataResult = entityJsonConverter.formatData(dr);

    // Assert
    assertEquals(
        "{\"buttons\":{\"type\":\"org.finos.springbot.workflow.form.buttonList\",\"contents\":[]},\"form\":{\"type\":\"org"
            + ".finos.springbot.entityjson.versionSpace\",\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0.2\",\"toUse"
            + "\":\"java.lang.Object\",\"versions\":\"1.0.2, , 1.0.2, .\"},\"errors\":{\"type\":\"org.finos.springbot.workflow"
            + ".form.errorMap\",\"contents\":{}}}",
        actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>Given builder addMixIn {@link Object} and {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse); given builder addMixIn Object and Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_givenBuilderAddMixInObjectAndObject() {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    Addressable resultTo = mock(Addressable.class);
    DataResponse dr = new DataResponse(resultTo, new HashMap<>(), "Template Name");

    // Act
    String actualFormatDataResult = entityJsonConverter.formatData(dr);

    // Assert
    assertEquals("{}", actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>Given builder addMixIn {@link Object} and {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse); given builder addMixIn Object and Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_givenBuilderAddMixInObjectAndObject2() {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act
    String actualFormatDataResult =
        entityJsonConverter.formatData(
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    assertEquals(
        "{\"buttons\":{\"type\":\"org.finos.springbot.workflow.form.buttonList\",\"contents\":[]},\"form\":\"42\",\"errors"
            + "\":{\"type\":\"org.finos.springbot.workflow.form.errorMap\",\"contents\":{}}}",
        actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>Given builder defaultLeniency {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse); given builder defaultLeniency 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_givenBuilderDefaultLeniencyTrue() {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    builderResult.defaultLeniency(true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    Addressable resultTo = mock(Addressable.class);
    DataResponse dr = new DataResponse(resultTo, new HashMap<>(), "Template Name");

    // Act
    String actualFormatDataResult = entityJsonConverter.formatData(dr);

    // Assert
    assertEquals("{}", actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.
   *   <li>Then return {@code {"foo":"42"}}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName(
      "Test formatData(DataResponse); given 'foo'; when HashMap() 'foo' is '42'; then return '{\"foo\":\"42\"}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_givenFoo_whenHashMapFooIs42_thenReturnFoo42() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    HashMap<String, Object> data = new HashMap<>();
    data.put("foo", "42");
    DataResponse dr = new DataResponse(mock(Addressable.class), data, "Template Name");

    // Act
    String actualFormatDataResult = entityJsonConverter.formatData(dr);

    // Assert
    assertEquals("{\"foo\":\"42\"}", actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName(
      "Test formatData(DataResponse); given 'null'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_givenNull_thenThrowUnsupportedOperationException() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    HashMap<String, Object> data = new HashMap<>();
    data.put(null, "42");
    DataResponse dr = new DataResponse(mock(Addressable.class), data, "Template Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> entityJsonConverter.formatData(dr));
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>Given {@code EntityJsonConverter}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName(
      "Test formatData(DataResponse); given 'org.finos.springbot.workflow.data.EntityJsonConverter'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_givenOrgFinosSpringbotWorkflowDataEntityJsonConverter() {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<EntityJsonConverter> mixinSource = EntityJsonConverter.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    Addressable resultTo = mock(Addressable.class);
    DataResponse dr = new DataResponse(resultTo, new HashMap<>(), "Template Name");

    // Act
    String actualFormatDataResult = entityJsonConverter.formatData(dr);

    // Assert
    assertEquals("{}", actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>Given {@code EntityJsonConverter}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName(
      "Test formatData(DataResponse); given 'org.finos.springbot.workflow.data.EntityJsonConverter'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_givenOrgFinosSpringbotWorkflowDataEntityJsonConverter2() {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<EntityJsonConverter> mixinSource = EntityJsonConverter.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act
    String actualFormatDataResult =
        entityJsonConverter.formatData(
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    assertEquals(
        "{\"buttons\":{\"type\":\"org.finos.springbot.workflow.form.buttonList\",\"contents\":[]},\"form\":\"42\",\"errors"
            + "\":{\"type\":\"org.finos.springbot.workflow.form.errorMap\",\"contents\":{}}}",
        actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse); then return '{}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    Addressable resultTo = mock(Addressable.class);
    DataResponse dr = new DataResponse(resultTo, new HashMap<>(), "Template Name");

    // Act
    String actualFormatDataResult = entityJsonConverter.formatData(dr);

    // Assert
    assertEquals("{}", actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse); then return '{}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_thenReturnLeftCurlyBracketRightCurlyBracket2() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Addressable resultTo = mock(Addressable.class);
    DataResponse dr = new DataResponse(resultTo, new HashMap<>(), "Template Name");

    // Act
    String actualFormatDataResult = entityJsonConverter.formatData(dr);

    // Assert
    assertEquals("{}", actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_thenReturnNull() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    DataResponse dr = new DataResponse(mock(Addressable.class), null, "Template Name");

    // Act
    String actualFormatDataResult = entityJsonConverter.formatData(dr);

    // Assert
    assertNull(actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>When {@link VersionSpace#VersionSpace(Class)} with toUse is {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse); when VersionSpace(Class) with toUse is Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_whenVersionSpaceWithToUseIsObject() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    Addressable resultTo = mock(Addressable.class);
    Class<Object> toUse2 = Object.class;
    WorkResponse dr = new WorkResponse(resultTo, new VersionSpace(toUse2), WorkMode.BOTH);

    // Act
    String actualFormatDataResult = entityJsonConverter.formatData(dr);

    // Assert
    assertEquals(
        "{\"buttons\":{\"type\":\"org.finos.springbot.workflow.form.buttonList\",\"contents\":[]},\"form\":{\"type\":\"org"
            + ".finos.springbot.entityjson.versionSpace\",\"typeName\":\"java.lang.object\",\"writeVersion\":\"1.0\",\"toUse\""
            + ":\"java.lang.Object\",\"versions\":\"1.0, \"},\"errors\":{\"type\":\"org.finos.springbot.workflow.form.errorMap"
            + "\",\"contents\":{}}}",
        actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>When {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)} with to is {@link
   *       Addressable} and o is {@code 42} and m is {@code BOTH}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName(
      "Test formatData(DataResponse); when WorkResponse(Addressable, Object, WorkMode) with to is Addressable and o is '42' and m is 'BOTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_whenWorkResponseWithToIsAddressableAndOIs42AndMIsBoth() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act
    String actualFormatDataResult =
        entityJsonConverter.formatData(
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    assertEquals(
        "{\"buttons\":{\"type\":\"org.finos.springbot.workflow.form.buttonList\",\"contents\":[]},\"form\":\"42\",\"errors"
            + "\":{\"type\":\"org.finos.springbot.workflow.form.errorMap\",\"contents\":{}}}",
        actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>When {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)} with to is {@link
   *       Addressable} and o is {@code 42} and m is {@code BOTH}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName(
      "Test formatData(DataResponse); when WorkResponse(Addressable, Object, WorkMode) with to is Addressable and o is '42' and m is 'BOTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_whenWorkResponseWithToIsAddressableAndOIs42AndMIsBoth2() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);

    // Act
    String actualFormatDataResult =
        entityJsonConverter.formatData(
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    assertEquals(
        "{\"buttons\":{\"type\":\"org.finos.springbot.workflow.form.buttonList\",\"contents\":[]},\"form\":\"42\",\"errors"
            + "\":{\"type\":\"org.finos.springbot.workflow.form.errorMap\",\"contents\":{}}}",
        actualFormatDataResult);
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>When {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)} with to is {@link
   *       Addressable} and o is {@code 42} and m is {@code BOTH}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName(
      "Test formatData(DataResponse); when WorkResponse(Addressable, Object, WorkMode) with to is Addressable and o is '42' and m is 'BOTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_whenWorkResponseWithToIsAddressableAndOIs42AndMIsBoth3() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    Class<Object> toUse2 = Object.class;
    initial.add(new VersionSpace(toUse2));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);

    // Act
    String actualFormatDataResult =
        entityJsonConverter.formatData(
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    assertEquals(
        "{\"buttons\":{\"type\":\"org.finos.springbot.workflow.form.buttonList\",\"contents\":[]},\"form\":\"42\",\"errors"
            + "\":{\"type\":\"org.finos.springbot.workflow.form.errorMap\",\"contents\":{}}}",
        actualFormatDataResult);
  }
}
