package org.finos.springbot.workflow.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.entityjson.EntityJsonTypeResolverBuilder;
import org.finos.springbot.entityjson.VersionSpace;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.response.DataResponse;
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link VersionSpace#VersionSpace(Class)} with
   *       toUse is {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName(
      "Test readValue(String); given ArrayList() add VersionSpace(Class) with toUse is Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue_givenArrayListAddVersionSpaceWithToUseIsObject()
      throws JsonProcessingException {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any()))
        .thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any()))
        .thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.cacheProvider(cacheProvider);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, initial);
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();

    // Act
    EntityJson actualReadValueResult =
        entityJsonConverter.readValue(buildResult.writeValueAsString(new EntityJson()));

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    assertTrue(actualReadValueResult.isEmpty());
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
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue(
        entityJsonConverter.readValue(buildResult.writeValueAsString(new EntityJson())).isEmpty());
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
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue(
        entityJsonConverter.readValue(buildResult.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   *
   * <ul>
   *   <li>Given builder defaultLeniency {@code true}.
   *   <li>Then calls {@link CacheProvider#forDeserializerCache(DeserializationConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName(
      "Test readValue(String); given builder defaultLeniency 'true'; then calls forDeserializerCache(DeserializationConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue_givenBuilderDefaultLeniencyTrue_thenCallsForDeserializerCache()
      throws JsonProcessingException {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any()))
        .thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any()))
        .thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.defaultLeniency(true);
    builderResult.cacheProvider(cacheProvider);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();

    // Act
    EntityJson actualReadValueResult =
        entityJsonConverter.readValue(buildResult.writeValueAsString(new EntityJson()));

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    assertTrue(actualReadValueResult.isEmpty());
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
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue(
        entityJsonConverter.readValue(buildResult.writeValueAsString(new EntityJson())).isEmpty());
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
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue(
        entityJsonConverter.readValue(buildResult.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName("Test readValue(String); when '42'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue_when42_thenThrowUnsupportedOperationException() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new EntityJsonConverter(om, new ArrayList<>()).readValue("42"));
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName(
      "Test readValue(String); when empty string; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJson EntityJsonConverter.readValue(String)"})
  void testReadValue_whenEmptyString_thenThrowUnsupportedOperationException() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new EntityJsonConverter(om, new ArrayList<>()).readValue(""));
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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new EntityJsonConverter(om, new ArrayList<>()).readValue("Json"));
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

    // Act and Assert
    assertNull(new EntityJsonConverter(om, new ArrayList<>()).readValue(null));
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

    // Act and Assert
    assertEquals(
        "\"Ej\"",
        new EntityJsonConverter(JsonMapper.builder().findAndAddModules().build(), initial)
            .writeValue("Ej"));
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

    // Act and Assert
    assertEquals("19088743", new EntityJsonConverter(om, new ArrayList<>()).writeValue(19088743));
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

    // Act and Assert
    assertEquals("\"Ej\"", new EntityJsonConverter(om, new ArrayList<>()).writeValue("Ej"));
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

    // Act and Assert
    assertNull(new EntityJsonConverter(om, new ArrayList<>()).writeValue(null));
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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new EntityJsonConverter(om, new ArrayList<>()).fromJson("42", "Json"));
  }

  /**
   * Test {@link EntityJsonConverter#fromJson(String, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#fromJson(String, Object)}
   */
  @Test
  @DisplayName("Test fromJson(String, Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EntityJsonConverter.fromJson(String, Object)"})
  void testFromJson_whenNull_thenReturnNull() {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any()))
        .thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any()))
        .thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.cacheProvider(cacheProvider);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));

    // Act
    Object actualFromJsonResult =
        new EntityJsonConverter(om, initial)
            .fromJson("org.finos.springbot.workflow.data.EntityJsonConverter", null);

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    assertNull(actualFromJsonResult);
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

    // Act and Assert
    assertSame(entityJsonConverter.om, entityJsonConverter.getObjectMapper());
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
    EntityJsonConverter entityJsonConverter =
        new EntityJsonConverter(JsonMapper.builder().findAndAddModules().build(), initial);
    Class<Object> toUse = Object.class;

    // Act
    entityJsonConverter.addVersionSpace(new VersionSpace(toUse));

    // Assert
    verify(versionSpace).getToUse();
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
  void testAddVersionSpace_thenCallsGetToUse2() {
    // Arrange
    VersionSpace versionSpace = mock(VersionSpace.class);
    Class<EntityJsonConverter> forNameResult = EntityJsonConverter.class;
    Mockito.<Class<?>>when(versionSpace.getToUse()).thenReturn(forNameResult);

    ArrayList<VersionSpace> initial = new ArrayList<>();
    initial.add(versionSpace);
    EntityJsonConverter entityJsonConverter =
        new EntityJsonConverter(JsonMapper.builder().findAndAddModules().build(), initial);
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

    // Act and Assert
    assertEquals(
        "{}",
        entityJsonConverter.formatData(
            new DataResponse(resultTo, new HashMap<>(), "Template Name")));
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>Then calls {@link CacheProvider#forDeserializerCache(DeserializationConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName(
      "Test formatData(DataResponse); then calls forDeserializerCache(DeserializationConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_thenCallsForDeserializerCache() {
    // Arrange
    ContextAttributes attrs = mock(ContextAttributes.class);
    when(attrs.getAttribute(Mockito.<Object>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any()))
        .thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any()))
        .thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.defaultLeniency(true);
    builderResult.cacheProvider(cacheProvider);
    builderResult.defaultAttributes(attrs);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    Addressable resultTo = mock(Addressable.class);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityJsonConverter.formatData(
                new DataResponse(resultTo, new HashMap<>(), "Template Name")));
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    verify(attrs).getAttribute(isA(Object.class));
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

    // Act and Assert
    assertEquals(
        "{}",
        entityJsonConverter.formatData(
            new DataResponse(resultTo, new HashMap<>(), "Template Name")));
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
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    Addressable resultTo = mock(Addressable.class);

    // Act and Assert
    assertEquals(
        "{}",
        entityJsonConverter.formatData(
            new DataResponse(resultTo, new HashMap<>(), "Template Name")));
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

    // Act and Assert
    assertNull(
        entityJsonConverter.formatData(
            new DataResponse(mock(Addressable.class), null, "Template Name")));
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityJsonConverter.formatData(DataResponse)"})
  void testFormatData_thenThrowUnsupportedOperationException() {
    // Arrange
    ContextAttributes attrs = mock(ContextAttributes.class);
    when(attrs.getAttribute(Mockito.<Object>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    Builder builderResult = JsonMapper.builder();
    builderResult.defaultAttributes(attrs);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    Addressable resultTo = mock(Addressable.class);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityJsonConverter.formatData(
                new DataResponse(resultTo, new HashMap<>(), "Template Name")));
    verify(attrs).getAttribute(isA(Object.class));
  }
}
