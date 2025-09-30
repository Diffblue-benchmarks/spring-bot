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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator.Builder;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.type.ArrayType;
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
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}
   */
  @Test
  @DisplayName("Test addVersionSpace(VersionSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.addVersionSpace(VersionSpace)"})
  void testAddVersionSpace() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);
    Class<Object> toUse = Object.class;
    VersionSpace vs = new VersionSpace(toUse, "1.0.2", "1.0.2");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> entityJsonTypeResolverBuilder.addVersionSpace(vs));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}.
   *
   * <ul>
   *   <li>When {@link VersionSpace#VersionSpace(Class)} with toUse is {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}
   */
  @Test
  @DisplayName("Test addVersionSpace(VersionSpace); when VersionSpace(Class) with toUse is Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.addVersionSpace(VersionSpace)"})
  void testAddVersionSpace_whenVersionSpaceWithToUseIsObject() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);
    Class<Object> toUse = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityJsonTypeResolverBuilder.addVersionSpace(new VersionSpace(toUse)));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}
   */
  @Test
  @DisplayName(
      "Test new EntityJsonTypeResolverBuilder(TypeFactory, List); given 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.<init>(TypeFactory, List)"})
  void testNewEntityJsonTypeResolverBuilder_givenJavaLangObject() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));

    // Act
    EntityJsonTypeResolverBuilder actualEntityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, allowed);

    // Assert
    assertEquals("type", actualEntityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(actualEntityJsonTypeResolverBuilder.getDefaultImpl());
    assertFalse(actualEntityJsonTypeResolverBuilder.isTypeIdVisible());
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}
   */
  @Test
  @DisplayName(
      "Test new EntityJsonTypeResolverBuilder(TypeFactory, List); given 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    EntityJsonTypeResolverBuilder actualEntityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, allowed);

    // Assert
    assertEquals("type", actualEntityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(actualEntityJsonTypeResolverBuilder.getDefaultImpl());
    assertFalse(actualEntityJsonTypeResolverBuilder.isTypeIdVisible());
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return TypeProperty is {@code type}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}
   */
  @Test
  @DisplayName(
      "Test new EntityJsonTypeResolverBuilder(TypeFactory, List); when ArrayList(); then return TypeProperty is 'type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.<init>(TypeFactory, List)"})
  void testNewEntityJsonTypeResolverBuilder_whenArrayList_thenReturnTypePropertyIsType() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    // Act
    EntityJsonTypeResolverBuilder actualEntityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());

    // Assert
    assertEquals("type", actualEntityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(actualEntityJsonTypeResolverBuilder.getDefaultImpl());
    assertFalse(actualEntityJsonTypeResolverBuilder.isTypeIdVisible());
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#getVersionHandler()}.
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#getVersionHandler()}
   */
  @Test
  @DisplayName("Test getVersionHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeserializationProblemHandler EntityJsonTypeResolverBuilder.getVersionHandler()"
  })
  void testGetVersionHandler() throws IOException {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());

    // Act
    DeserializationProblemHandler actualVersionHandler =
        entityJsonTypeResolverBuilder.getVersionHandler();

    // Assert
    assertNull(actualVersionHandler.handleMissingTypeId(null, null, null, "Failure Msg"));
    Object object = DeserializationProblemHandler.NOT_HANDLED;
    assertSame(object, actualVersionHandler.handleInstantiationProblem(null, null, null, null));
    assertSame(object, actualVersionHandler.handleMissingInstantiator(null, null, null, "Msg"));
    assertSame(object, actualVersionHandler.handleWeirdKey(null, null, "42", "Failure Msg"));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>Given {@code JsonNode}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName("Test useForType(JavaType); given 'com.fasterxml.jackson.databind.JsonNode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_givenComFasterxmlJacksonDatabindJsonNode() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);

    ArrayType t = mock(ArrayType.class);
    when(t.isEnumType()).thenReturn(false);
    when(t.isJavaLangObject()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(false);
    Class<JsonNode> forNameResult = JsonNode.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isJavaLangObject();
    verify(t).isPrimitive();
    assertFalse(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>When {@link ArrayType} {@link ArrayType#getRawClass()} return {@link Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName(
      "Test useForType(JavaType); given Object; when ArrayType getRawClass() return Object; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_givenObject_whenArrayTypeGetRawClassReturnObject_thenReturnFalse() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());

    ArrayType t = mock(ArrayType.class);
    when(t.isEnumType()).thenReturn(false);
    when(t.isJavaLangObject()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isJavaLangObject();
    verify(t).isPrimitive();
    assertFalse(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link ArrayType} {@link ArrayType#isEnumType()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName(
      "Test useForType(JavaType); given 'true'; when ArrayType isEnumType() return 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_givenTrue_whenArrayTypeIsEnumTypeReturnTrue_thenReturnFalse() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());

    ArrayType t = mock(ArrayType.class);
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
   *
   * <ul>
   *   <li>Then calls {@link ArrayType#isTypeOrSuperTypeOf(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName("Test useForType(JavaType); then calls isTypeOrSuperTypeOf(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_thenCallsIsTypeOrSuperTypeOf() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);

    ArrayType t = mock(ArrayType.class);
    when(t.isTypeOrSuperTypeOf(Mockito.<Class<?>>any())).thenReturn(false);
    when(t.isEnumType()).thenReturn(false);
    when(t.isJavaLangObject()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isJavaLangObject();
    verify(t).isPrimitive();
    verify(t).isTypeOrSuperTypeOf(isA(Class.class));
    assertFalse(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>When {@link ArrayType} {@link ArrayType#isPrimitive()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName(
      "Test useForType(JavaType); when ArrayType isPrimitive() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_whenArrayTypeIsPrimitiveThrowIllegalArgumentException() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());

    ArrayType t = mock(ArrayType.class);
    when(t.isPrimitive()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityJsonTypeResolverBuilder.useForType(t));
    verify(t).isPrimitive();
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>When {@link ArrayType} {@link ArrayType#isTypeOrSuperTypeOf(Class)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName(
      "Test useForType(JavaType); when ArrayType isTypeOrSuperTypeOf(Class) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_whenArrayTypeIsTypeOrSuperTypeOfReturnTrue_thenReturnTrue() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);

    ArrayType t = mock(ArrayType.class);
    when(t.isTypeOrSuperTypeOf(Mockito.<Class<?>>any())).thenReturn(true);
    when(t.isEnumType()).thenReturn(false);
    when(t.isJavaLangObject()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isJavaLangObject();
    verify(t).isPrimitive();
    verify(t).isTypeOrSuperTypeOf(isA(Class.class));
    assertTrue(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>When {@link ArrayType} {@link ArrayType#isTypeOrSuperTypeOf(Class)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName(
      "Test useForType(JavaType); when ArrayType isTypeOrSuperTypeOf(Class) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_whenArrayTypeIsTypeOrSuperTypeOfThrowIllegalArgumentException() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);

    ArrayType t = mock(ArrayType.class);
    when(t.isTypeOrSuperTypeOf(Mockito.<Class<?>>any())).thenThrow(new IllegalArgumentException());
    when(t.isEnumType()).thenReturn(false);
    when(t.isJavaLangObject()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityJsonTypeResolverBuilder.useForType(t));
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isJavaLangObject();
    verify(t).isPrimitive();
    verify(t).isTypeOrSuperTypeOf(isA(Class.class));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName(
      "Test useForType(JavaType); when PlaceholderForType(int) with ordinal is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_whenPlaceholderForTypeWithOrdinalIsOne_thenReturnTrue() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());

    // Act
    boolean actualUseForTypeResult =
        entityJsonTypeResolverBuilder.useForType(new PlaceholderForType(1));

    // Assert
    assertTrue(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType,
   * Collection)}.
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName("Test buildTypeSerializer(SerializationConfig, JavaType, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"
  })
  void testBuildTypeSerializer() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    ArrayType baseType = mock(ArrayType.class);
    when(baseType.isTypeOrSuperTypeOf(Mockito.<Class<?>>any()))
        .thenThrow(new IllegalArgumentException());
    when(baseType.isEnumType()).thenReturn(false);
    when(baseType.isJavaLangObject()).thenReturn(false);
    when(baseType.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(baseType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType, new ArrayList<>()));
    verify(baseType).getRawClass();
    verify(baseType).isEnumType();
    verify(baseType).isJavaLangObject();
    verify(baseType).isPrimitive();
    verify(baseType).isTypeOrSuperTypeOf(isA(Class.class));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType,
   * Collection)}.
   *
   * <ul>
   *   <li>Given {@code JsonNode}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName(
      "Test buildTypeSerializer(SerializationConfig, JavaType, Collection); given 'com.fasterxml.jackson.databind.JsonNode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"
  })
  void testBuildTypeSerializer_givenComFasterxmlJacksonDatabindJsonNode() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    ArrayType baseType = mock(ArrayType.class);
    when(baseType.isEnumType()).thenReturn(false);
    when(baseType.isJavaLangObject()).thenReturn(false);
    when(baseType.isPrimitive()).thenReturn(false);
    Class<JsonNode> forNameResult = JsonNode.class;
    Mockito.<Class<?>>when(baseType.getRawClass()).thenReturn(forNameResult);

    // Act
    TypeSerializer actualBuildTypeSerializerResult =
        entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType, new ArrayList<>());

    // Assert
    verify(baseType).getRawClass();
    verify(baseType).isEnumType();
    verify(baseType).isJavaLangObject();
    verify(baseType).isPrimitive();
    assertNull(actualBuildTypeSerializerResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType,
   * Collection)}.
   *
   * <ul>
   *   <li>Given {@link NamedType#NamedType(Class)} with c is {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName(
      "Test buildTypeSerializer(SerializationConfig, JavaType, Collection); given NamedType(Class) with c is Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"
  })
  void testBuildTypeSerializer_givenNamedTypeWithCIsObject() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    ArrayType baseType = mock(ArrayType.class);
    when(baseType.isTypeOrSuperTypeOf(Mockito.<Class<?>>any())).thenReturn(false);
    when(baseType.isEnumType()).thenReturn(false);
    when(baseType.isJavaLangObject()).thenReturn(false);
    when(baseType.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(baseType.getRawClass()).thenReturn(forNameResult);

    ArrayList<NamedType> subtypes = new ArrayList<>();
    Class<Object> c = Object.class;
    subtypes.add(new NamedType(c));

    // Act
    TypeSerializer actualBuildTypeSerializerResult =
        entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType, subtypes);

    // Assert
    verify(baseType).getRawClass();
    verify(baseType).isEnumType();
    verify(baseType).isJavaLangObject();
    verify(baseType).isPrimitive();
    verify(baseType).isTypeOrSuperTypeOf(isA(Class.class));
    assertNull(actualBuildTypeSerializerResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType,
   * Collection)}.
   *
   * <ul>
   *   <li>Given {@link NamedType#NamedType(Class)} with c is {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName(
      "Test buildTypeSerializer(SerializationConfig, JavaType, Collection); given NamedType(Class) with c is Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"
  })
  void testBuildTypeSerializer_givenNamedTypeWithCIsObject2() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    ArrayType baseType = mock(ArrayType.class);
    when(baseType.isTypeOrSuperTypeOf(Mockito.<Class<?>>any())).thenReturn(false);
    when(baseType.isEnumType()).thenReturn(false);
    when(baseType.isJavaLangObject()).thenReturn(false);
    when(baseType.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(baseType.getRawClass()).thenReturn(forNameResult);

    ArrayList<NamedType> subtypes = new ArrayList<>();
    Class<Object> c = Object.class;
    subtypes.add(new NamedType(c));
    Class<Object> c2 = Object.class;
    subtypes.add(new NamedType(c2));

    // Act
    TypeSerializer actualBuildTypeSerializerResult =
        entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType, subtypes);

    // Assert
    verify(baseType).getRawClass();
    verify(baseType).isEnumType();
    verify(baseType).isJavaLangObject();
    verify(baseType).isPrimitive();
    verify(baseType).isTypeOrSuperTypeOf(isA(Class.class));
    assertNull(actualBuildTypeSerializerResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType,
   * Collection)}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName(
      "Test buildTypeSerializer(SerializationConfig, JavaType, Collection); given Object; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"
  })
  void testBuildTypeSerializer_givenObject_thenReturnNull() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    ArrayType baseType = mock(ArrayType.class);
    when(baseType.isEnumType()).thenReturn(false);
    when(baseType.isJavaLangObject()).thenReturn(false);
    when(baseType.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(baseType.getRawClass()).thenReturn(forNameResult);

    // Act
    TypeSerializer actualBuildTypeSerializerResult =
        entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType, new ArrayList<>());

    // Assert
    verify(baseType).getRawClass();
    verify(baseType).isEnumType();
    verify(baseType).isJavaLangObject();
    verify(baseType).isPrimitive();
    assertNull(actualBuildTypeSerializerResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType,
   * Collection)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link ArrayType} {@link ArrayType#isEnumType()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName(
      "Test buildTypeSerializer(SerializationConfig, JavaType, Collection); given 'true'; when ArrayType isEnumType() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"
  })
  void testBuildTypeSerializer_givenTrue_whenArrayTypeIsEnumTypeReturnTrue() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    ArrayType baseType = mock(ArrayType.class);
    when(baseType.isEnumType()).thenReturn(true);
    when(baseType.isPrimitive()).thenReturn(true);

    // Act
    TypeSerializer actualBuildTypeSerializerResult =
        entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType, new ArrayList<>());

    // Assert
    verify(baseType).isEnumType();
    verify(baseType).isPrimitive();
    assertNull(actualBuildTypeSerializerResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType,
   * Collection)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link ArrayType} {@link ArrayType#isTypeOrSuperTypeOf(Class)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName(
      "Test buildTypeSerializer(SerializationConfig, JavaType, Collection); given 'true'; when ArrayType isTypeOrSuperTypeOf(Class) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"
  })
  void testBuildTypeSerializer_givenTrue_whenArrayTypeIsTypeOrSuperTypeOfReturnTrue() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    ArrayType baseType = mock(ArrayType.class);
    when(baseType.isTypeOrSuperTypeOf(Mockito.<Class<?>>any())).thenReturn(true);
    when(baseType.isEnumType()).thenReturn(false);
    when(baseType.isJavaLangObject()).thenReturn(false);
    when(baseType.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(baseType.getRawClass()).thenReturn(forNameResult);

    // Act
    entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType, new ArrayList<>());

    // Assert
    verify(baseType).getRawClass();
    verify(baseType).isEnumType();
    verify(baseType).isJavaLangObject();
    verify(baseType).isPrimitive();
    verify(baseType).isTypeOrSuperTypeOf(isA(Class.class));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType,
   * Collection)}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayType#isTypeOrSuperTypeOf(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName(
      "Test buildTypeSerializer(SerializationConfig, JavaType, Collection); then calls isTypeOrSuperTypeOf(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"
  })
  void testBuildTypeSerializer_thenCallsIsTypeOrSuperTypeOf() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    ArrayType baseType = mock(ArrayType.class);
    when(baseType.isTypeOrSuperTypeOf(Mockito.<Class<?>>any())).thenReturn(false);
    when(baseType.isEnumType()).thenReturn(false);
    when(baseType.isJavaLangObject()).thenReturn(false);
    when(baseType.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(baseType.getRawClass()).thenReturn(forNameResult);

    // Act
    TypeSerializer actualBuildTypeSerializerResult =
        entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType, new ArrayList<>());

    // Assert
    verify(baseType).getRawClass();
    verify(baseType).isEnumType();
    verify(baseType).isJavaLangObject();
    verify(baseType).isPrimitive();
    verify(baseType).isTypeOrSuperTypeOf(isA(Class.class));
    assertNull(actualBuildTypeSerializerResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType,
   * Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayType} {@link ArrayType#isPrimitive()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  @DisplayName(
      "Test buildTypeSerializer(SerializationConfig, JavaType, Collection); when ArrayType isPrimitive() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TypeSerializer EntityJsonTypeResolverBuilder.buildTypeSerializer(SerializationConfig, JavaType, Collection)"
  })
  void testBuildTypeSerializer_whenArrayTypeIsPrimitiveThrowIllegalArgumentException() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    ArrayType baseType = mock(ArrayType.class);
    when(baseType.isPrimitive()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            entityJsonTypeResolverBuilder.buildTypeSerializer(config, baseType, new ArrayList<>()));
    verify(baseType).isPrimitive();
  }
}
