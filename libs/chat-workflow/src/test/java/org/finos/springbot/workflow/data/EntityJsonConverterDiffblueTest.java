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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
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
   * <ul>
   *   <li>Given {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}
   */
  @Test
  @DisplayName("Test new EntityJsonConverter(ObjectMapper, List); given 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.data.EntityJsonConverter.<init>(com.fasterxml.jackson.databind.ObjectMapper, java.util.List)"})
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
   * <ul>
   *   <li>Given {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}
   */
  @Test
  @DisplayName("Test new EntityJsonConverter(ObjectMapper, List); given 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.data.EntityJsonConverter.<init>(com.fasterxml.jackson.databind.ObjectMapper, java.util.List)"})
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}
   */
  @Test
  @DisplayName("Test new EntityJsonConverter(ObjectMapper, List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.data.EntityJsonConverter.<init>(com.fasterxml.jackson.databind.ObjectMapper, java.util.List)"})
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link VersionSpace#VersionSpace(Class)} with toUse is {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName("Test readValue(String); given ArrayList() add VersionSpace(Class) with toUse is Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.entityjson.EntityJson org.finos.springbot.workflow.data.EntityJsonConverter.readValue(java.lang.String)"})
  void testReadValue_givenArrayListAddVersionSpaceWithToUseIsObject() throws JsonProcessingException {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
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
    EntityJson actualReadValueResult = entityJsonConverter.readValue(buildResult.writeValueAsString(new EntityJson()));

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    assertTrue(actualReadValueResult.isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   * <ul>
   *   <li>Given builder addMixIn {@link Object} and {@link Object}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName("Test readValue(String); given builder addMixIn Object and Object; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.entityjson.EntityJson org.finos.springbot.workflow.data.EntityJsonConverter.readValue(java.lang.String)"})
  void testReadValue_givenBuilderAddMixInObjectAndObject_thenReturnEmpty() throws JsonProcessingException {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue(entityJsonConverter.readValue(buildResult.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   * <ul>
   *   <li>Given builder defaultLeniency {@code true}.</li>
   *   <li>Then calls {@link CacheProvider#forDeserializerCache(DeserializationConfig)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName("Test readValue(String); given builder defaultLeniency 'true'; then calls forDeserializerCache(DeserializationConfig)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.entityjson.EntityJson org.finos.springbot.workflow.data.EntityJsonConverter.readValue(java.lang.String)"})
  void testReadValue_givenBuilderDefaultLeniencyTrue_thenCallsForDeserializerCache() throws JsonProcessingException {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
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
    EntityJson actualReadValueResult = entityJsonConverter.readValue(buildResult.writeValueAsString(new EntityJson()));

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    assertTrue(actualReadValueResult.isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   * <ul>
   *   <li>Given {@code EntityJsonConverter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName("Test readValue(String); given 'org.finos.springbot.workflow.data.EntityJsonConverter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.entityjson.EntityJson org.finos.springbot.workflow.data.EntityJsonConverter.readValue(java.lang.String)"})
  void testReadValue_givenOrgFinosSpringbotWorkflowDataEntityJsonConverter() throws JsonProcessingException {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<EntityJsonConverter> mixinSource = EntityJsonConverter.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue(entityJsonConverter.readValue(buildResult.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#readValue(String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#readValue(String)}
   */
  @Test
  @DisplayName("Test readValue(String); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.entityjson.EntityJson org.finos.springbot.workflow.data.EntityJsonConverter.readValue(java.lang.String)"})
  void testReadValue_thenReturnEmpty() throws JsonProcessingException {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue(entityJsonConverter.readValue(buildResult.writeValueAsString(new EntityJson())).isEmpty());
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@code Ej}.</li>
   *   <li>Then return {@code "Ej"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object); given 'java.lang.Object'; when 'Ej'; then return '\"Ej\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.data.EntityJsonConverter.writeValue(java.lang.Object)"})
  void testWriteValue_givenJavaLangObject_whenEj_thenReturnEj() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));

    // Act and Assert
    assertEquals("\"Ej\"",
        (new EntityJsonConverter(JsonMapper.builder().findAndAddModules().build(), initial)).writeValue("Ej"));
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   * <ul>
   *   <li>When {@code 19088743}.</li>
   *   <li>Then return {@code 19088743}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object); when '19088743'; then return '19088743'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.data.EntityJsonConverter.writeValue(java.lang.Object)"})
  void testWriteValue_when19088743_thenReturn19088743() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertEquals("19088743", (new EntityJsonConverter(om, new ArrayList<>())).writeValue(19088743));
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   * <ul>
   *   <li>When {@code Ej}.</li>
   *   <li>Then return {@code "Ej"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object); when 'Ej'; then return '\"Ej\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.data.EntityJsonConverter.writeValue(java.lang.Object)"})
  void testWriteValue_whenEj_thenReturnEj() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertEquals("\"Ej\"", (new EntityJsonConverter(om, new ArrayList<>())).writeValue("Ej"));
  }

  /**
   * Test {@link EntityJsonConverter#writeValue(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#writeValue(Object)}
   */
  @Test
  @DisplayName("Test writeValue(Object); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.data.EntityJsonConverter.writeValue(java.lang.Object)"})
  void testWriteValue_whenNull_thenReturnNull() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertNull((new EntityJsonConverter(om, new ArrayList<>())).writeValue(null));
  }

  /**
   * Test {@link EntityJsonConverter#fromJson(String, Object)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#fromJson(String, Object)}
   */
  @Test
  @DisplayName("Test fromJson(String, Object); when '42'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Object org.finos.springbot.workflow.data.EntityJsonConverter.fromJson(java.lang.String, java.lang.Object)"})
  void testFromJson_when42_thenThrowUnsupportedOperationException() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new EntityJsonConverter(om, new ArrayList<>())).fromJson("42", "Json"));
  }

  /**
   * Test {@link EntityJsonConverter#fromJson(String, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#fromJson(String, Object)}
   */
  @Test
  @DisplayName("Test fromJson(String, Object); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Object org.finos.springbot.workflow.data.EntityJsonConverter.fromJson(java.lang.String, java.lang.Object)"})
  void testFromJson_whenNull_thenReturnNull() {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
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
    Object actualFromJsonResult = (new EntityJsonConverter(om, initial))
        .fromJson("org.finos.springbot.workflow.data.EntityJsonConverter", null);

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    assertNull(actualFromJsonResult);
  }

  /**
   * Test {@link EntityJsonConverter#getObjectMapper()}.
   * <p>
   * Method under test: {@link EntityJsonConverter#getObjectMapper()}
   */
  @Test
  @DisplayName("Test getObjectMapper()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.fasterxml.jackson.databind.ObjectMapper org.finos.springbot.workflow.data.EntityJsonConverter.getObjectMapper()"})
  void testGetObjectMapper() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertSame(entityJsonConverter.om, entityJsonConverter.getObjectMapper());
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   * <p>
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.data.EntityJsonConverter.formatData(org.finos.springbot.workflow.response.DataResponse)"})
  void testFormatData() throws JsonMappingException {
    // Arrange
    SerializerFactory serializerFactory = mock(SerializerFactory.class);
    when(serializerFactory.createSerializer(Mockito.<SerializerProvider>any(), Mockito.<JavaType>any()))
        .thenThrow(new UnsupportedOperationException("Map Fail"));
    SerializerFactory serializerFactory2 = mock(SerializerFactory.class);
    when(serializerFactory2.withAdditionalKeySerializers(Mockito.<Serializers>any())).thenReturn(serializerFactory);
    SerializerFactory serializerFactory3 = mock(SerializerFactory.class);
    when(serializerFactory3.withAdditionalSerializers(Mockito.<Serializers>any())).thenReturn(serializerFactory2);
    SerializerFactory serializerFactory4 = mock(SerializerFactory.class);
    when(serializerFactory4.withSerializerModifier(Mockito.<BeanSerializerModifier>any()))
        .thenReturn(serializerFactory3);
    SerializerFactory f = mock(SerializerFactory.class);
    when(f.withAdditionalSerializers(Mockito.<Serializers>any())).thenReturn(serializerFactory4);
    Builder builderResult = JsonMapper.builder();
    builderResult.serializerFactory(f);
    builderResult.defaultAttributes(mock(ContextAttributes.class));
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    Addressable resultTo = mock(Addressable.class);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> entityJsonConverter.formatData(new DataResponse(resultTo, new HashMap<>(), "Template Name")));
    verify(serializerFactory).createSerializer(isA(SerializerProvider.class), isA(JavaType.class));
    verify(serializerFactory2).withAdditionalKeySerializers(isA(Serializers.class));
    verify(f).withAdditionalSerializers(isA(Serializers.class));
    verify(serializerFactory3).withAdditionalSerializers(isA(Serializers.class));
    verify(serializerFactory4).withSerializerModifier(isA(BeanSerializerModifier.class));
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   * <p>
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.data.EntityJsonConverter.formatData(org.finos.springbot.workflow.response.DataResponse)"})
  void testFormatData2() throws JsonMappingException {
    // Arrange
    SerializerFactory serializerFactory = mock(SerializerFactory.class);
    Class<Object> type = Object.class;
    when(serializerFactory.createSerializer(Mockito.<SerializerProvider>any(), Mockito.<JavaType>any()))
        .thenReturn(new Default(1, type));
    when(serializerFactory.createTypeSerializer(Mockito.<SerializationConfig>any(), Mockito.<JavaType>any()))
        .thenReturn(AsDeductionTypeSerializer.instance());
    SerializerFactory serializerFactory2 = mock(SerializerFactory.class);
    when(serializerFactory2.withAdditionalKeySerializers(Mockito.<Serializers>any())).thenReturn(serializerFactory);
    SerializerFactory serializerFactory3 = mock(SerializerFactory.class);
    when(serializerFactory3.withAdditionalSerializers(Mockito.<Serializers>any())).thenReturn(serializerFactory2);
    SerializerFactory serializerFactory4 = mock(SerializerFactory.class);
    when(serializerFactory4.withSerializerModifier(Mockito.<BeanSerializerModifier>any()))
        .thenReturn(serializerFactory3);
    SerializerFactory f = mock(SerializerFactory.class);
    when(f.withAdditionalSerializers(Mockito.<Serializers>any())).thenReturn(serializerFactory4);
    Builder builderResult = JsonMapper.builder();
    builderResult.serializerFactory(f);
    builderResult.defaultAttributes(mock(ContextAttributes.class));
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    Addressable resultTo = mock(Addressable.class);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> entityJsonConverter.formatData(new DataResponse(resultTo, new HashMap<>(), "Template Name")));
    verify(serializerFactory).createSerializer(isA(SerializerProvider.class), isA(JavaType.class));
    verify(serializerFactory).createTypeSerializer(isA(SerializationConfig.class), isA(JavaType.class));
    verify(serializerFactory2).withAdditionalKeySerializers(isA(Serializers.class));
    verify(f).withAdditionalSerializers(isA(Serializers.class));
    verify(serializerFactory3).withAdditionalSerializers(isA(Serializers.class));
    verify(serializerFactory4).withSerializerModifier(isA(BeanSerializerModifier.class));
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   * <ul>
   *   <li>Given {@code EntityJsonConverter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse); given 'org.finos.springbot.workflow.data.EntityJsonConverter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.data.EntityJsonConverter.formatData(org.finos.springbot.workflow.response.DataResponse)"})
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
    assertEquals("{}", entityJsonConverter.formatData(new DataResponse(resultTo, new HashMap<>(), "Template Name")));
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   * <ul>
   *   <li>Given {@link SerializerFactory} {@link SerializerFactory#createSerializer(SerializerProvider, JavaType)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse); given SerializerFactory createSerializer(SerializerProvider, JavaType) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.data.EntityJsonConverter.formatData(org.finos.springbot.workflow.response.DataResponse)"})
  void testFormatData_givenSerializerFactoryCreateSerializerReturnNull() throws JsonMappingException {
    // Arrange
    SerializerFactory serializerFactory = mock(SerializerFactory.class);
    when(serializerFactory.createSerializer(Mockito.<SerializerProvider>any(), Mockito.<JavaType>any()))
        .thenReturn(null);
    when(serializerFactory.createTypeSerializer(Mockito.<SerializationConfig>any(), Mockito.<JavaType>any()))
        .thenReturn(AsDeductionTypeSerializer.instance());
    SerializerFactory serializerFactory2 = mock(SerializerFactory.class);
    when(serializerFactory2.withAdditionalKeySerializers(Mockito.<Serializers>any())).thenReturn(serializerFactory);
    SerializerFactory serializerFactory3 = mock(SerializerFactory.class);
    when(serializerFactory3.withAdditionalSerializers(Mockito.<Serializers>any())).thenReturn(serializerFactory2);
    SerializerFactory serializerFactory4 = mock(SerializerFactory.class);
    when(serializerFactory4.withSerializerModifier(Mockito.<BeanSerializerModifier>any()))
        .thenReturn(serializerFactory3);
    SerializerFactory f = mock(SerializerFactory.class);
    when(f.withAdditionalSerializers(Mockito.<Serializers>any())).thenReturn(serializerFactory4);
    Builder builderResult = JsonMapper.builder();
    builderResult.serializerFactory(f);
    builderResult.defaultAttributes(mock(ContextAttributes.class));
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper om = builderResult.findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    Addressable resultTo = mock(Addressable.class);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> entityJsonConverter.formatData(new DataResponse(resultTo, new HashMap<>(), "Template Name")));
    verify(serializerFactory).createSerializer(isA(SerializerProvider.class), isA(JavaType.class));
    verify(serializerFactory).createTypeSerializer(isA(SerializationConfig.class), isA(JavaType.class));
    verify(serializerFactory2).withAdditionalKeySerializers(isA(Serializers.class));
    verify(f).withAdditionalSerializers(isA(Serializers.class));
    verify(serializerFactory3).withAdditionalSerializers(isA(Serializers.class));
    verify(serializerFactory4).withSerializerModifier(isA(BeanSerializerModifier.class));
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse); then return '{}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.data.EntityJsonConverter.formatData(org.finos.springbot.workflow.response.DataResponse)"})
  void testFormatData_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter entityJsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    Addressable resultTo = mock(Addressable.class);

    // Act and Assert
    assertEquals("{}", entityJsonConverter.formatData(new DataResponse(resultTo, new HashMap<>(), "Template Name")));
  }

  /**
   * Test {@link EntityJsonConverter#formatData(DataResponse)}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonConverter#formatData(DataResponse)}
   */
  @Test
  @DisplayName("Test formatData(DataResponse); then return '{}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.data.EntityJsonConverter.formatData(org.finos.springbot.workflow.response.DataResponse)"})
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
    assertEquals("{}", entityJsonConverter.formatData(new DataResponse(resultTo, new HashMap<>(), "Template Name")));
  }
}
