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
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityJsonTypeResolverBuilderDiffblueTest {
  /**
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}
   */
  @Test
  void testAddVersionSpace() {
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
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}
   */
  @Test
  void testAddVersionSpace2() {
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
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}
   */
  @Test
  void testAddVersionSpace3() {
    // Arrange
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.NONE);
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory2 = TypeFactory.defaultInstance();
    entityJsonTypeResolverBuilder.init(settings,
        new ClassNameIdResolver(baseType, typeFactory2, new DefaultBaseTypeLimitingValidator()));
    Class<Object> class1 = Object.class;

    // Act
    entityJsonTypeResolverBuilder.addVersionSpace(ObjectMapperFactory.noVersion(class1));

    // Assert
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
  }

  /**
   * Method under test: {@link EntityJsonTypeResolverBuilder#getVersionHandler()}
   */
  @Test
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
   * Method under test: {@link EntityJsonTypeResolverBuilder#getVersionHandler()}
   */
  @Test
  void testGetVersionHandler2() throws IOException {
    // Arrange
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.NONE);
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory2 = TypeFactory.defaultInstance();
    entityJsonTypeResolverBuilder.init(settings,
        new ClassNameIdResolver(baseType, typeFactory2, new DefaultBaseTypeLimitingValidator()));

    // Act
    DeserializationProblemHandler actualVersionHandler = entityJsonTypeResolverBuilder.getVersionHandler();

    // Assert
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    assertNull(actualVersionHandler.handleMissingTypeId(null, null, null, "Failure Msg"));
    Object object = actualVersionHandler.NOT_HANDLED;
    assertSame(object, actualVersionHandler.handleInstantiationProblem(null, null, "Argument", null));
    assertSame(object, actualVersionHandler.handleMissingInstantiator(null, null, null, "Msg"));
    assertSame(object, actualVersionHandler.handleWeirdKey(null, null, "42", "Failure Msg"));
  }

  /**
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  void testUseForType() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());

    // Act and Assert
    assertTrue(entityJsonTypeResolverBuilder.useForType(new PlaceholderForType(1)));
  }

  /**
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  void testUseForType2() {
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
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  void testUseForType3() {
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
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  void testUseForType4() {
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
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  void testUseForType5() {
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
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  void testUseForType6() {
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
   * Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  void testUseForType7() {
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
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  void testBuildTypeSerializer() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  void testBuildTypeSerializer2() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  void testBuildTypeSerializer3() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  void testBuildTypeSerializer4() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  void testBuildTypeSerializer5() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = new EntityJsonTypeResolverBuilder(typeFactory,
        new ArrayList<>());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  void testBuildTypeSerializer6() {
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
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  void testBuildTypeSerializer7() {
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
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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

  /**
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#buildTypeSerializer(SerializationConfig, JavaType, Collection)}
   */
  @Test
  void testBuildTypeSerializer8() {
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
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}
   */
  @Test
  void testNewEntityJsonTypeResolverBuilder() {
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
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}
   */
  @Test
  void testNewEntityJsonTypeResolverBuilder2() {
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
   * Method under test:
   * {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}
   */
  @Test
  void testNewEntityJsonTypeResolverBuilder3() {
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
}
