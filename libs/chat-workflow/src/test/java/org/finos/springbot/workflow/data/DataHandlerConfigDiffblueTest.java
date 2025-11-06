package org.finos.springbot.workflow.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.DefaultCacheProvider;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TimeZone;
import org.finos.springbot.entityjson.EntityJsonTypeResolverBuilder;
import org.finos.springbot.entityjson.VersionSpace;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.DropdownList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.finos.springbot.workflow.help.CommandDescription;
import org.finos.springbot.workflow.help.HelpPage;
import org.finos.springbot.workflow.tags.HeaderDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DataHandlerConfig.class})
@ExtendWith(SpringExtension.class)
class DataHandlerConfigDiffblueTest {
  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private DataHandlerConfig dataHandlerConfig;

  /**
   * Method under test: {@link DataHandlerConfig#scanForWorkClasses()}
   */
  @Test
  void testScanForWorkClasses() {
    // Arrange and Act
    List<VersionSpace> actualScanForWorkClassesResult = dataHandlerConfig.scanForWorkClasses();

    // Assert
    assertEquals(8, actualScanForWorkClassesResult.size());
    VersionSpace getResult = actualScanForWorkClassesResult.get(0);
    assertEquals("1.0", getResult.writeVersion);
    VersionSpace getResult2 = actualScanForWorkClassesResult.get(1);
    assertEquals("1.0", getResult2.writeVersion);
    VersionSpace getResult3 = actualScanForWorkClassesResult.get(2);
    assertEquals("1.0", getResult3.writeVersion);
    VersionSpace getResult4 = actualScanForWorkClassesResult.get(3);
    assertEquals("1.0", getResult4.writeVersion);
    VersionSpace getResult5 = actualScanForWorkClassesResult.get(4);
    assertEquals("1.0", getResult5.writeVersion);
    VersionSpace getResult6 = actualScanForWorkClassesResult.get(5);
    assertEquals("1.0", getResult6.writeVersion);
    VersionSpace getResult7 = actualScanForWorkClassesResult.get(6);
    assertEquals("1.0", getResult7.writeVersion);
    assertEquals("1.0, , 1.0", getResult.getVersions());
    assertEquals("1.0, , 1.0", getResult2.getVersions());
    assertEquals("1.0, , 1.0", getResult3.getVersions());
    assertEquals("1.0, , 1.0", getResult4.getVersions());
    assertEquals("1.0, , 1.0", getResult5.getVersions());
    assertEquals("1.0, , 1.0", getResult6.getVersions());
    assertEquals("1.0, , 1.0", getResult7.getVersions());
    VersionSpace getResult8 = actualScanForWorkClassesResult.get(7);
    assertEquals("null, , 1.0", getResult8.getVersions());
    assertEquals("org.finos.springbot.workflow.form.button", getResult.typeName);
    assertEquals("org.finos.springbot.workflow.form.buttonList", getResult2.typeName);
    assertEquals("org.finos.springbot.workflow.form.dropdownList", getResult3.typeName);
    assertEquals("org.finos.springbot.workflow.form.errorMap", getResult4.typeName);
    assertEquals("org.finos.springbot.workflow.help.commandDescription", getResult5.typeName);
    assertEquals("org.finos.springbot.workflow.help.helpPage", getResult6.typeName);
    assertEquals("org.finos.springbot.workflow.tags.headerDetails", getResult7.typeName);
    assertEquals("org.finos.symphony.toolkit.workflow.form.headerDetails", getResult8.typeName);
    assertNull(getResult8.writeVersion);
    Class<Button> expectedToUse = Button.class;
    assertEquals(expectedToUse, getResult.getToUse());
    Class<ButtonList> expectedToUse2 = ButtonList.class;
    assertEquals(expectedToUse2, getResult2.getToUse());
    Class<DropdownList> expectedToUse3 = DropdownList.class;
    assertEquals(expectedToUse3, getResult3.getToUse());
    Class<ErrorMap> expectedToUse4 = ErrorMap.class;
    assertEquals(expectedToUse4, getResult4.getToUse());
    Class<CommandDescription> expectedToUse5 = CommandDescription.class;
    assertEquals(expectedToUse5, getResult5.getToUse());
    Class<HelpPage> expectedToUse6 = HelpPage.class;
    assertEquals(expectedToUse6, getResult6.getToUse());
    Class<HeaderDetails> expectedToUse7 = HeaderDetails.class;
    Class<?> toUse = getResult7.getToUse();
    assertEquals(expectedToUse7, toUse);
    assertSame(toUse, getResult8.getToUse());
  }

  /**
   * Method under test:
   * {@link DataHandlerConfig#scanForWorkClasses(ApplicationContext)}
   */
  @Test
  void testScanForWorkClasses2() {
    // Arrange and Act
    List<VersionSpace> actualScanForWorkClassesResult = DataHandlerConfig.scanForWorkClasses(applicationContext);

    // Assert
    assertEquals(8, actualScanForWorkClassesResult.size());
    VersionSpace getResult = actualScanForWorkClassesResult.get(0);
    assertEquals("1.0", getResult.writeVersion);
    VersionSpace getResult2 = actualScanForWorkClassesResult.get(1);
    assertEquals("1.0", getResult2.writeVersion);
    VersionSpace getResult3 = actualScanForWorkClassesResult.get(2);
    assertEquals("1.0", getResult3.writeVersion);
    VersionSpace getResult4 = actualScanForWorkClassesResult.get(3);
    assertEquals("1.0", getResult4.writeVersion);
    VersionSpace getResult5 = actualScanForWorkClassesResult.get(4);
    assertEquals("1.0", getResult5.writeVersion);
    VersionSpace getResult6 = actualScanForWorkClassesResult.get(5);
    assertEquals("1.0", getResult6.writeVersion);
    VersionSpace getResult7 = actualScanForWorkClassesResult.get(6);
    assertEquals("1.0", getResult7.writeVersion);
    assertEquals("1.0, , 1.0", getResult.getVersions());
    assertEquals("1.0, , 1.0", getResult2.getVersions());
    assertEquals("1.0, , 1.0", getResult3.getVersions());
    assertEquals("1.0, , 1.0", getResult4.getVersions());
    assertEquals("1.0, , 1.0", getResult5.getVersions());
    assertEquals("1.0, , 1.0", getResult6.getVersions());
    assertEquals("1.0, , 1.0", getResult7.getVersions());
    VersionSpace getResult8 = actualScanForWorkClassesResult.get(7);
    assertEquals("null, , 1.0", getResult8.getVersions());
    assertEquals("org.finos.springbot.workflow.form.button", getResult.typeName);
    assertEquals("org.finos.springbot.workflow.form.buttonList", getResult2.typeName);
    assertEquals("org.finos.springbot.workflow.form.dropdownList", getResult3.typeName);
    assertEquals("org.finos.springbot.workflow.form.errorMap", getResult4.typeName);
    assertEquals("org.finos.springbot.workflow.help.commandDescription", getResult5.typeName);
    assertEquals("org.finos.springbot.workflow.help.helpPage", getResult6.typeName);
    assertEquals("org.finos.springbot.workflow.tags.headerDetails", getResult7.typeName);
    assertEquals("org.finos.symphony.toolkit.workflow.form.headerDetails", getResult8.typeName);
    assertNull(getResult8.writeVersion);
    Class<Button> expectedToUse = Button.class;
    assertEquals(expectedToUse, getResult.getToUse());
    Class<ButtonList> expectedToUse2 = ButtonList.class;
    assertEquals(expectedToUse2, getResult2.getToUse());
    Class<DropdownList> expectedToUse3 = DropdownList.class;
    assertEquals(expectedToUse3, getResult3.getToUse());
    Class<ErrorMap> expectedToUse4 = ErrorMap.class;
    assertEquals(expectedToUse4, getResult4.getToUse());
    Class<CommandDescription> expectedToUse5 = CommandDescription.class;
    assertEquals(expectedToUse5, getResult5.getToUse());
    Class<HelpPage> expectedToUse6 = HelpPage.class;
    assertEquals(expectedToUse6, getResult6.getToUse());
    Class<HeaderDetails> expectedToUse7 = HeaderDetails.class;
    Class<?> toUse = getResult7.getToUse();
    assertEquals(expectedToUse7, toUse);
    assertSame(toUse, getResult8.getToUse());
  }

  /**
   * Method under test: {@link DataHandlerConfig#entityJsonConverter()}
   */
  @Test
  void testEntityJsonConverter() throws MissingResourceException {
    // Arrange and Act
    EntityJsonConverter actualEntityJsonConverterResult = dataHandlerConfig.entityJsonConverter();

    // Assert
    ObjectMapper objectMapper = actualEntityJsonConverterResult.getObjectMapper();
    SerializationConfig serializationConfig = objectMapper.getSerializationConfig();
    assertTrue(serializationConfig.getDefaultPrettyPrinter() instanceof DefaultPrettyPrinter);
    JsonFactory factory = objectMapper.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    DeserializationConfig deserializationConfig = objectMapper.getDeserializationConfig();
    ContextAttributes attributes = deserializationConfig.getAttributes();
    assertTrue(attributes instanceof ContextAttributes.Impl);
    CacheProvider cacheProvider = deserializationConfig.getCacheProvider();
    assertTrue(cacheProvider instanceof DefaultCacheProvider);
    DeserializationContext deserializationContext = objectMapper.getDeserializationContext();
    DeserializerFactory factory2 = deserializationContext.getFactory();
    assertTrue(factory2 instanceof BeanDeserializerFactory);
    assertTrue(deserializationContext instanceof DefaultDeserializationContext.Impl);
    ClassIntrospector classIntrospector = deserializationConfig.getClassIntrospector();
    assertTrue(classIntrospector instanceof BasicClassIntrospector);
    AccessorNamingStrategy.Provider accessorNaming = deserializationConfig.getAccessorNaming();
    assertTrue(accessorNaming instanceof DefaultAccessorNamingStrategy.Provider);
    AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
    assertTrue(annotationIntrospector instanceof JacksonAnnotationIntrospector);
    VisibilityChecker<?> visibilityChecker = objectMapper.getVisibilityChecker();
    assertTrue(visibilityChecker instanceof VisibilityChecker.Std);
    PolymorphicTypeValidator polymorphicTypeValidator = objectMapper.getPolymorphicTypeValidator();
    assertTrue(polymorphicTypeValidator instanceof LaissezFaireSubTypeValidator);
    SubtypeResolver subtypeResolver = objectMapper.getSubtypeResolver();
    assertTrue(subtypeResolver instanceof StdSubtypeResolver);
    DeserializerFactoryConfig factoryConfig = ((BeanDeserializerFactory) factory2).getFactoryConfig();
    Iterable<Deserializers> deserializersResult = factoryConfig.deserializers();
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).next() instanceof SimpleDeserializers);
    SerializerFactory serializerFactory = objectMapper.getSerializerFactory();
    SerializerFactoryConfig factoryConfig2 = ((BeanSerializerFactory) serializerFactory).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig2.serializers();
    assertTrue(((ArrayIterator<Serializers>) serializersResult).next() instanceof SimpleSerializers);
    assertTrue(serializerFactory instanceof BeanSerializerFactory);
    SerializerProvider serializerProvider = objectMapper.getSerializerProvider();
    assertTrue(serializerProvider instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProviderInstance = objectMapper.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance instanceof DefaultSerializerProvider.Impl);
    JsonSerializer<Object> defaultNullKeySerializer = serializerProvider.getDefaultNullKeySerializer();
    assertTrue(defaultNullKeySerializer instanceof FailingSerializer);
    JsonSerializer<Object> defaultNullValueSerializer = serializerProvider.getDefaultNullValueSerializer();
    assertTrue(defaultNullValueSerializer instanceof NullSerializer);
    assertTrue(deserializersResult instanceof ArrayIterator);
    assertTrue(serializersResult instanceof ArrayIterator);
    DateFormat dateFormat = objectMapper.getDateFormat();
    assertTrue(dateFormat instanceof StdDateFormat);
    assertEquals(" ", factory.getRootValueSeparator());
    Locale locale = deserializationConfig.getLocale();
    assertEquals("", locale.getCountry());
    assertEquals("", locale.getDisplayCountry());
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getISO3Country());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    TimeZone timeZone = deserializationConfig.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("English", locale.getDisplayName());
    assertEquals("JSON", factory.getFormatName());
    Base64Variant base64Variant = deserializationConfig.getBase64Variant();
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.getName());
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.toString());
    assertEquals("UTC", timeZone.getID());
    assertEquals("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSX', 'EEE, dd MMM yyyy HH:mm:ss zzz' (lenient)]",
        ((StdDateFormat) dateFormat).toPattern());
    Version versionResult = factory.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    Version versionResult2 = objectMapper.version();
    assertEquals("com.fasterxml.jackson.core", versionResult2.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-core/2.16.2", versionResult.toFullString());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.16.2", versionResult2.toFullString());
    assertEquals("en", locale.getLanguage());
    assertEquals("eng", locale.getISO3Language());
    assertEquals("jackson-core", versionResult.getArtifactId());
    assertEquals("jackson-databind", versionResult2.getArtifactId());
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder = actualEntityJsonConverterResult.ejtsb;
    assertEquals("type", entityJsonTypeResolverBuilder.getTypeProperty());
    assertEquals('=', base64Variant.getPaddingChar());
    assertNull(serializerProvider.getGenerator());
    assertNull(serializerProviderInstance.getGenerator());
    assertNull(deserializationContext.getParser());
    assertNull(factory.getCharacterEscapes());
    assertNull(factory.getInputDecorator());
    assertNull(factory.getOutputDecorator());
    assertNull(deserializationContext.getConfig());
    assertNull(objectMapper.getInjectableValues());
    assertNull(deserializationContext.getContextualType());
    assertNull(defaultNullKeySerializer.getDelegatee());
    assertNull(defaultNullValueSerializer.getDelegatee());
    assertNull(deserializationConfig.getFullRootName());
    assertNull(serializationConfig.getFullRootName());
    assertNull(objectMapper.getPropertyNamingStrategy());
    assertNull(deserializationConfig.getPropertyNamingStrategy());
    assertNull(serializationConfig.getPropertyNamingStrategy());
    assertNull(serializerProvider.getConfig());
    assertNull(deserializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig.getFilterProvider());
    assertNull(serializerProviderInstance.getFilterProvider());
    assertNull(deserializationConfig.getProblemHandlers().next());
    assertNull(deserializationConfig.getDefaultMergeable());
    assertNull(serializationConfig.getDefaultMergeable());
    assertNull(factory.getFormatReadFeatureType());
    assertNull(factory.getFormatWriteFeatureType());
    JsonInclude.Value defaultPropertyInclusion = deserializationConfig.getDefaultPropertyInclusion();
    assertNull(defaultPropertyInclusion.getContentFilter());
    assertNull(defaultPropertyInclusion.getValueFilter());
    assertNull(deserializationContext.getActiveView());
    assertNull(serializerProvider.getActiveView());
    assertNull(serializerProviderInstance.getActiveView());
    assertNull(deserializationConfig.getActiveView());
    assertNull(serializationConfig.getActiveView());
    assertNull(entityJsonTypeResolverBuilder.getDefaultImpl());
    assertNull(deserializationConfig.getRootName());
    assertNull(serializationConfig.getRootName());
    assertNull(dateFormat.getNumberFormat());
    assertNull(dateFormat.getCalendar());
    assertNull(dateFormat.getTimeZone());
    assertEquals(0, factory.getFormatGeneratorFeatures());
    assertEquals(0, factory.getFormatParserFeatures());
    assertEquals(0, deserializationContext.getDeserializationFeatures());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, factory.getParserFeatures());
    assertEquals(1, objectMapper.getRegisteredModuleIds().size());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult2.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(2, versionResult2.getPatchLevel());
    assertEquals(2079, factory.getGeneratorFeatures());
    assertEquals(21771070, serializationConfig.getSerializationFeatures());
    assertEquals(237020289, deserializationConfig.getDeserializationFeatures());
    assertEquals(31, factory.getFactoryFeatures());
    JsonNodeFactory nodeFactory = objectMapper.getNodeFactory();
    assertEquals(9999, nodeFactory.getMaxElementIndexForInsert());
    assertEquals(JsonInclude.Include.ALWAYS, serializationConfig.getSerializationInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getContentInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getValueInclusion());
    JsonSetter.Value defaultSetterInfo = deserializationConfig.getDefaultSetterInfo();
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getContentNulls());
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getValueNulls());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult2.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult2.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(versionResult2.isUnknownVersion());
    assertFalse(defaultNullKeySerializer.isUnwrappingSerializer());
    assertFalse(defaultNullValueSerializer.isUnwrappingSerializer());
    assertFalse(factoryConfig.hasAbstractTypeResolvers());
    assertFalse(deserializationConfig.hasExplicitTimeZone());
    assertFalse(serializationConfig.hasExplicitTimeZone());
    assertFalse(entityJsonTypeResolverBuilder.isTypeIdVisible());
    assertFalse(((ArrayIterator<Deserializers>) deserializersResult).hasNext());
    assertFalse(((ArrayIterator<Serializers>) serializersResult).hasNext());
    assertFalse(locale.hasExtensions());
    assertTrue(factoryConfig.hasDeserializerModifiers());
    assertTrue(factoryConfig.hasDeserializers());
    assertTrue(factoryConfig.hasKeyDeserializers());
    assertTrue(factoryConfig.hasValueInstantiators());
    assertTrue(deserializationConfig.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig.isAnnotationProcessingEnabled());
    assertTrue(factoryConfig2.hasKeySerializers());
    assertTrue(factoryConfig2.hasSerializerModifiers());
    assertTrue(factoryConfig2.hasSerializers());
    assertTrue(((StdDateFormat) dateFormat).isColonIncludedInTimeZone());
    assertTrue(dateFormat.isLenient());
    Set<Character> extensionKeys = locale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertEquals(Integer.MAX_VALUE, base64Variant.getMaxLineLength());
    assertEquals(Short.SIZE, versionResult.getMinorVersion());
    assertEquals(Short.SIZE, versionResult2.getMinorVersion());
    assertEquals('=', base64Variant.getPaddingByte());
    assertSame(nodeFactory, deserializationConfig.getNodeFactory());
    assertSame(serializationConfig, serializerProviderInstance.getConfig());
    assertSame(versionResult2, annotationIntrospector.version());
    assertSame(base64Variant, serializationConfig.getBase64Variant());
    assertSame(locale, serializerProviderInstance.getLocale());
    assertSame(locale, serializationConfig.getLocale());
    assertSame(timeZone, serializerProviderInstance.getTimeZone());
    assertSame(timeZone, serializationConfig.getTimeZone());
    assertSame(defaultPropertyInclusion, serializationConfig.getDefaultPropertyInclusion());
    assertSame(defaultSetterInfo, serializationConfig.getDefaultSetterInfo());
    assertSame(extensionKeys, locale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, locale.getUnicodeLocaleKeys());
    assertSame(objectMapper, factory.getCodec());
    assertSame(factory, objectMapper.getJsonFactory());
    assertSame(attributes, serializationConfig.getAttributes());
    assertSame(cacheProvider, serializationConfig.getCacheProvider());
    assertSame(classIntrospector, serializationConfig.getClassIntrospector());
    assertSame(accessorNaming, serializationConfig.getAccessorNaming());
    assertSame(annotationIntrospector, serializerProviderInstance.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializationConfig.getAnnotationIntrospector());
    assertSame(visibilityChecker, deserializationConfig.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, serializationConfig.getDefaultVisibilityChecker());
    assertSame(polymorphicTypeValidator, deserializationConfig.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, serializationConfig.getPolymorphicTypeValidator());
    assertSame(subtypeResolver, deserializationConfig.getSubtypeResolver());
    assertSame(subtypeResolver, serializationConfig.getSubtypeResolver());
    assertSame(defaultNullKeySerializer, serializerProviderInstance.getDefaultNullKeySerializer());
    assertSame(defaultNullValueSerializer, serializerProviderInstance.getDefaultNullValueSerializer());
    assertSame(dateFormat, deserializationConfig.getDateFormat());
    assertSame(dateFormat, serializationConfig.getDateFormat());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link DataHandlerConfig}
   */
  @Test
  void testNewDataHandlerConfig() {
    // Arrange, Act and Assert
    assertNull((new DataHandlerConfig()).ac);
  }
}
