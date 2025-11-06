package org.finos.springbot.entityjson;

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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityJsonTypeResolverBuilderDiffblueTest {
  /**
   * Test {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}.
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}
   */
  @Test
  @DisplayName("Test addVersionSpace(VersionSpace)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.addVersionSpace(VersionSpace)"})
  void testAddVersionSpace() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> toUse = Object.class;
    allowed.add(new VersionSpace(toUse, "1.0.2", "1.0.2"));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(
        TypeFactory.defaultInstance(), allowed);
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> entityJsonTypeResolverBuilder.addVersionSpace(ObjectMapperFactory.noVersion(class1)));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link VersionSpace#VersionSpace(Class)} with toUse is {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}
   */
  @Test
  @DisplayName("Test addVersionSpace(VersionSpace); given ArrayList() add VersionSpace(Class) with toUse is Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.addVersionSpace(VersionSpace)"})
  void testAddVersionSpace_givenArrayListAddVersionSpaceWithToUseIsObject() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> toUse = Object.class;
    allowed.add(new VersionSpace(toUse));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(
        TypeFactory.defaultInstance(), allowed);
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> entityJsonTypeResolverBuilder.addVersionSpace(ObjectMapperFactory.noVersion(class1)));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}
   */
  @Test
  @DisplayName("Test new EntityJsonTypeResolverBuilder(TypeFactory, List); given 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.<init>(TypeFactory, List)"})
  void testNewEntityJsonTypeResolverBuilder_givenJavaLangObject() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));

    // Act
    EntityJsonTypeResolverBuilder actualEntityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        allowed);

    // Assert
    assertEquals("type", actualEntityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(actualEntityJsonTypeResolverBuilder.getDefaultImpl());
    assertFalse(actualEntityJsonTypeResolverBuilder.isTypeIdVisible());
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}
   */
  @Test
  @DisplayName("Test new EntityJsonTypeResolverBuilder(TypeFactory, List); given 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.<init>(TypeFactory, List)"})
  void testNewEntityJsonTypeResolverBuilder_givenJavaLangObject2() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    Class<Object> class12 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class12));

    // Act
    EntityJsonTypeResolverBuilder actualEntityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        allowed);

    // Assert
    assertEquals("type", actualEntityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(actualEntityJsonTypeResolverBuilder.getDefaultImpl());
    assertFalse(actualEntityJsonTypeResolverBuilder.isTypeIdVisible());
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return TypeProperty is {@code type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}
   */
  @Test
  @DisplayName("Test new EntityJsonTypeResolverBuilder(TypeFactory, List); when ArrayList(); then return TypeProperty is 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.<init>(TypeFactory, List)"})
  void testNewEntityJsonTypeResolverBuilder_whenArrayList_thenReturnTypePropertyIsType() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    // Act
    EntityJsonTypeResolverBuilder actualEntityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());

    // Assert
    assertEquals("type", actualEntityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(actualEntityJsonTypeResolverBuilder.getDefaultImpl());
    assertFalse(actualEntityJsonTypeResolverBuilder.isTypeIdVisible());
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#getVersionHandler()}.
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#getVersionHandler()}
   */
  @Test
  @DisplayName("Test getVersionHandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeserializationProblemHandler EntityJsonTypeResolverBuilder.getVersionHandler()"})
  void testGetVersionHandler() throws IOException {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    // Act
    DeserializationProblemHandler actualVersionHandler = (new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>())).getVersionHandler();

    // Assert
    assertNull(actualVersionHandler.handleMissingTypeId(null, null, null, "Failure Msg"));
    Object object = actualVersionHandler.NOT_HANDLED;
    assertSame(object, actualVersionHandler.handleInstantiationProblem(null, null, "Argument", null));
    assertSame(object, actualVersionHandler.handleMissingInstantiator(null, null, null, "Msg"));
    assertSame(object, actualVersionHandler.handleWeirdKey(null, null, "42", "Failure Msg"));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   * <ul>
   *   <li>Given {@code JsonNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName("Test useForType(JavaType); given 'com.fasterxml.jackson.databind.JsonNode'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_givenComFasterxmlJacksonDatabindJsonNode() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(
        TypeFactory.defaultInstance(), allowed);
    CollectionLikeType t = mock(CollectionLikeType.class);
    when(t.isEnumType()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(true);
    Class<JsonNode> forNameResult = JsonNode.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isPrimitive();
    assertFalse(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   * <ul>
   *   <li>Given {@link Object}.</li>
   *   <li>Then calls {@link JavaType#getRawClass()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName("Test useForType(JavaType); given Object; then calls getRawClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_givenObject_thenCallsGetRawClass() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    CollectionLikeType t = mock(CollectionLikeType.class);
    when(t.isEnumType()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isPrimitive();
    assertFalse(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   * <ul>
   *   <li>Then calls {@link JavaType#isJavaLangObject()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName("Test useForType(JavaType); then calls isJavaLangObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_thenCallsIsJavaLangObject() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    CollectionLikeType t = mock(CollectionLikeType.class);
    when(t.isEnumType()).thenReturn(true);
    when(t.isJavaLangObject()).thenReturn(true);
    when(t.isPrimitive()).thenReturn(false);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).isEnumType();
    verify(t).isJavaLangObject();
    verify(t).isPrimitive();
    assertFalse(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName("Test useForType(JavaType); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_thenReturnTrue() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(
        TypeFactory.defaultInstance(), allowed);
    CollectionLikeType t = mock(CollectionLikeType.class);
    when(t.isTypeOrSuperTypeOf(Mockito.<Class<Object>>any())).thenReturn(true);
    when(t.isEnumType()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isPrimitive();
    verify(t).isTypeOrSuperTypeOf(isA(Class.class));
    assertTrue(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   * <ul>
   *   <li>When {@link CollectionLikeType} {@link JavaType#isEnumType()} return {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName("Test useForType(JavaType); when CollectionLikeType isEnumType() return 'true'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_whenCollectionLikeTypeIsEnumTypeReturnTrue_thenReturnFalse() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    CollectionLikeType t = mock(CollectionLikeType.class);
    when(t.isEnumType()).thenReturn(true);
    when(t.isPrimitive()).thenReturn(true);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).isEnumType();
    verify(t).isPrimitive();
    assertFalse(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   * <ul>
   *   <li>When {@link CollectionLikeType} {@link JavaType#isTypeOrSuperTypeOf(Class)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName("Test useForType(JavaType); when CollectionLikeType isTypeOrSuperTypeOf(Class) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_whenCollectionLikeTypeIsTypeOrSuperTypeOfReturnFalse() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(
        TypeFactory.defaultInstance(), allowed);
    CollectionLikeType t = mock(CollectionLikeType.class);
    when(t.isTypeOrSuperTypeOf(Mockito.<Class<Object>>any())).thenReturn(false);
    when(t.isEnumType()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isPrimitive();
    verify(t).isTypeOrSuperTypeOf(isA(Class.class));
    assertFalse(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName("Test useForType(JavaType); when PlaceholderForType(int) with ordinal is one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_whenPlaceholderForTypeWithOrdinalIsOne_thenReturnTrue() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());

    // Act and Assert
    assertTrue(entityJsonTypeResolverBuilder.useForType(new PlaceholderForType(1)));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}.
   * <ul>
   *   <li>Given {@code JsonNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName("Test buildTypeSerializer(SerializationConfig, JavaType, Collection); given 'com.fasterxml.jackson.databind.JsonNode'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"})
  void testBuildTypeSerializer_givenComFasterxmlJacksonDatabindJsonNode() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(
        TypeFactory.defaultInstance(), allowed);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    CollectionLikeType baseType = mock(CollectionLikeType.class);
    when(baseType.isEnumType()).thenReturn(false);
    when(baseType.isPrimitive()).thenReturn(true);
    Class<JsonNode> forNameResult = JsonNode.class;
    Mockito.<Class<?>>when(baseType.getRawClass()).thenReturn(forNameResult);

    // Act
    TypeSerializer actualBuildTypeSerializerResult = entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType,
        new ArrayList<>());

    // Assert
    verify(baseType).getRawClass();
    verify(baseType).isEnumType();
    verify(baseType).isPrimitive();
    assertNull(actualBuildTypeSerializerResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}.
   * <ul>
   *   <li>Given {@link NamedType#NamedType(Class)} with c is {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName("Test buildTypeSerializer(SerializationConfig, JavaType, Collection); given NamedType(Class) with c is Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"})
  void testBuildTypeSerializer_givenNamedTypeWithCIsObject() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    CollectionLikeType baseType = mock(CollectionLikeType.class);
    when(baseType.isEnumType()).thenReturn(true);
    when(baseType.isPrimitive()).thenReturn(true);

    ArrayList<NamedType> subtypes = new ArrayList<>();
    Class<Object> c = Object.class;
    subtypes.add(new NamedType(c));

    // Act
    TypeSerializer actualBuildTypeSerializerResult = entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType,
        subtypes);

    // Assert
    verify(baseType).isEnumType();
    verify(baseType).isPrimitive();
    assertNull(actualBuildTypeSerializerResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}.
   * <ul>
   *   <li>Given {@link NamedType#NamedType(Class)} with c is {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName("Test buildTypeSerializer(SerializationConfig, JavaType, Collection); given NamedType(Class) with c is Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"})
  void testBuildTypeSerializer_givenNamedTypeWithCIsObject2() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    CollectionLikeType baseType = mock(CollectionLikeType.class);
    when(baseType.isEnumType()).thenReturn(true);
    when(baseType.isPrimitive()).thenReturn(true);

    ArrayList<NamedType> subtypes = new ArrayList<>();
    Class<Object> c = Object.class;
    subtypes.add(new NamedType(c));
    Class<Object> c2 = Object.class;
    subtypes.add(new NamedType(c2));

    // Act
    TypeSerializer actualBuildTypeSerializerResult = entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType,
        subtypes);

    // Assert
    verify(baseType).isEnumType();
    verify(baseType).isPrimitive();
    assertNull(actualBuildTypeSerializerResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}.
   * <ul>
   *   <li>Given {@link Object}.</li>
   *   <li>Then calls {@link JavaType#getRawClass()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName("Test buildTypeSerializer(SerializationConfig, JavaType, Collection); given Object; then calls getRawClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"})
  void testBuildTypeSerializer_givenObject_thenCallsGetRawClass() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    CollectionLikeType baseType = mock(CollectionLikeType.class);
    when(baseType.isEnumType()).thenReturn(false);
    when(baseType.isPrimitive()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(baseType.getRawClass()).thenReturn(forNameResult);

    // Act
    TypeSerializer actualBuildTypeSerializerResult = entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType,
        new ArrayList<>());

    // Assert
    verify(baseType).getRawClass();
    verify(baseType).isEnumType();
    verify(baseType).isPrimitive();
    assertNull(actualBuildTypeSerializerResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}.
   * <ul>
   *   <li>Then calls {@link JavaType#isJavaLangObject()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName("Test buildTypeSerializer(SerializationConfig, JavaType, Collection); then calls isJavaLangObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"})
  void testBuildTypeSerializer_thenCallsIsJavaLangObject() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    CollectionLikeType baseType = mock(CollectionLikeType.class);
    when(baseType.isEnumType()).thenReturn(true);
    when(baseType.isJavaLangObject()).thenReturn(true);
    when(baseType.isPrimitive()).thenReturn(false);

    // Act
    TypeSerializer actualBuildTypeSerializerResult = entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType,
        new ArrayList<>());

    // Assert
    verify(baseType).isEnumType();
    verify(baseType).isJavaLangObject();
    verify(baseType).isPrimitive();
    assertNull(actualBuildTypeSerializerResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}.
   * <ul>
   *   <li>Then calls {@link JavaType#isTypeOrSuperTypeOf(Class)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName("Test buildTypeSerializer(SerializationConfig, JavaType, Collection); then calls isTypeOrSuperTypeOf(Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"})
  void testBuildTypeSerializer_thenCallsIsTypeOrSuperTypeOf() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(
        TypeFactory.defaultInstance(), allowed);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    CollectionLikeType baseType = mock(CollectionLikeType.class);
    when(baseType.isTypeOrSuperTypeOf(Mockito.<Class<Object>>any())).thenReturn(true);
    when(baseType.isEnumType()).thenReturn(false);
    when(baseType.isPrimitive()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(baseType.getRawClass()).thenReturn(forNameResult);

    // Act
    entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType, new ArrayList<>());

    // Assert
    verify(baseType).getRawClass();
    verify(baseType).isEnumType();
    verify(baseType).isPrimitive();
    verify(baseType).isTypeOrSuperTypeOf(isA(Class.class));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}.
   * <ul>
   *   <li>When {@link CollectionLikeType} {@link JavaType#isEnumType()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName("Test buildTypeSerializer(SerializationConfig, JavaType, Collection); when CollectionLikeType isEnumType() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"})
  void testBuildTypeSerializer_whenCollectionLikeTypeIsEnumTypeReturnTrue() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    CollectionLikeType baseType = mock(CollectionLikeType.class);
    when(baseType.isEnumType()).thenReturn(true);
    when(baseType.isPrimitive()).thenReturn(true);

    // Act
    TypeSerializer actualBuildTypeSerializerResult = entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType,
        new ArrayList<>());

    // Assert
    verify(baseType).isEnumType();
    verify(baseType).isPrimitive();
    assertNull(actualBuildTypeSerializerResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}.
   * <ul>
   *   <li>When {@link CollectionLikeType} {@link JavaType#isTypeOrSuperTypeOf(Class)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName("Test buildTypeSerializer(SerializationConfig, JavaType, Collection); when CollectionLikeType isTypeOrSuperTypeOf(Class) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"})
  void testBuildTypeSerializer_whenCollectionLikeTypeIsTypeOrSuperTypeOfReturnFalse() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(
        TypeFactory.defaultInstance(), allowed);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    CollectionLikeType baseType = mock(CollectionLikeType.class);
    when(baseType.isTypeOrSuperTypeOf(Mockito.<Class<Object>>any())).thenReturn(false);
    when(baseType.isEnumType()).thenReturn(false);
    when(baseType.isPrimitive()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(baseType.getRawClass()).thenReturn(forNameResult);

    // Act
    TypeSerializer actualBuildTypeSerializerResult = entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType,
        new ArrayList<>());

    // Assert
    verify(baseType).getRawClass();
    verify(baseType).isEnumType();
    verify(baseType).isPrimitive();
    verify(baseType).isTypeOrSuperTypeOf(isA(Class.class));
    assertNull(actualBuildTypeSerializerResult);
  }
}
