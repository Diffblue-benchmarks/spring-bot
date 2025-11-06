package org.finos.springbot.teams;

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
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.builder.DelegatingTurnContext;
import com.microsoft.bot.builder.TurnContextImpl;
import com.microsoft.bot.builder.teams.TeamsActivityHandler;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.ChannelAccount;
import com.microsoft.bot.schema.ConversationAccount;
import com.microsoft.bot.schema.ConversationReference;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.finos.springbot.teams.content.TeamsChannel;
import org.finos.springbot.teams.content.serialization.TeamsHTMLParser;
import org.finos.springbot.teams.content.serialization.TeamsMarkupWriter;
import org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations;
import org.finos.springbot.teams.conversations.TeamsConversations;
import org.finos.springbot.teams.form.TeamsFormConverter;
import org.finos.springbot.teams.handlers.ActivityHandler;
import org.finos.springbot.teams.handlers.SimpleActivityHandler;
import org.finos.springbot.teams.history.StateStorageBasedTeamsHistory;
import org.finos.springbot.teams.history.TeamsHistory;
import org.finos.springbot.teams.messages.FileActivityHandler;
import org.finos.springbot.teams.state.FileStateStorage;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplater;
import org.finos.springbot.workflow.actions.ErrorAction;
import org.finos.springbot.workflow.actions.consumers.ActionConsumer;
import org.finos.springbot.workflow.actions.consumers.AddressingChecker;
import org.finos.springbot.workflow.actions.consumers.InRoomAddressingChecker;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.finos.springbot.workflow.form.FormValidationProcessor;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.finos.springbot.workflow.welcome.RoomWelcomeEventConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

class TeamsWorkflowConfigDiffblueTest {
  /**
   * Method under test:
   * {@link TeamsWorkflowConfig#teamsMarkupTemplater(String, String, String, TeamsMarkupWriter)}
   */
  @Test
  void testTeamsMarkupTemplater() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();

    // Act and Assert
    assertNull(teamsWorkflowConfig.teamsMarkupTemplater("Prefix", "Suffix", "Default Name", new TeamsMarkupWriter())
        .getTemplateForName("Name"));
  }

  /**
   * Method under test:
   * {@link TeamsWorkflowConfig#thymeleafWorkTemplater(String, String, String, ThymeleafTemplater)}
   */
  @Test
  void testThymeleafWorkTemplater() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();

    // Act and Assert
    assertNull(
        teamsWorkflowConfig
            .thymeleafWorkTemplater("Prefix", "Suffix", "Default Name",
                new ThymeleafTemplater(fieldConverters, new ThymeleafRendering()))
            .getTemplateForName("Name"));
  }

  /**
   * Method under test:
   * {@link TeamsWorkflowConfig#thymeleafWorkTemplater(String, String, String, ThymeleafTemplater)}
   */
  @Test
  void testThymeleafWorkTemplater2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();

    // Act and Assert
    assertNull(
        teamsWorkflowConfig
            .thymeleafWorkTemplater("org.finos.springbot.teams.TeamsWorkflowConfig", "Suffix", "Default Name",
                new ThymeleafTemplater(fieldConverters, new ThymeleafRendering()))
            .getTemplateForName("Name"));
  }

  /**
   * Method under test:
   * {@link TeamsWorkflowConfig#activityHandler(TeamsConversations)}
   */
  @Test
  void testActivityHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act
    ActivityHandler actualActivityHandlerResult = teamsWorkflowConfig
        .activityHandler(new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
            new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()))));
    Activity createContactRelationUpdateActivityResult = Activity.createContactRelationUpdateActivity();
    actualActivityHandlerResult.handleActivity(createContactRelationUpdateActivityResult,
        new TeamsChannel("42", "Name"));

    // Assert
    assertTrue(actualActivityHandlerResult instanceof SimpleActivityHandler);
    ChannelAccount recipient = createContactRelationUpdateActivityResult.getRecipient();
    assertEquals("42", recipient.getId());
    ConversationAccount conversation = createContactRelationUpdateActivityResult.getConversation();
    assertEquals("42", conversation.getId());
    assertEquals("botframework.com", conversation.getTenantId());
    assertEquals("channel", conversation.getConversationType());
    ConversationReference conversationReference = createContactRelationUpdateActivityResult.getConversationReference();
    Activity continuationActivity = conversationReference.getContinuationActivity();
    ConversationReference conversationReference2 = continuationActivity.getConversationReference();
    Activity continuationActivity2 = conversationReference2.getContinuationActivity();
    ConversationReference conversationReference3 = continuationActivity2.getConversationReference();
    Activity continuationActivity3 = conversationReference3.getContinuationActivity();
    ConversationReference conversationReference4 = continuationActivity3.getConversationReference();
    Activity continuationActivity4 = conversationReference4.getContinuationActivity();
    assertEquals("en-GB", continuationActivity4.getLocale());
    assertEquals("en-GB", continuationActivity3.getLocale());
    assertEquals("en-GB", continuationActivity2.getLocale());
    assertEquals("en-GB", continuationActivity.getLocale());
    assertEquals("en-GB", createContactRelationUpdateActivityResult.getLocale());
    assertEquals("en-GB", conversationReference4.getLocale());
    assertEquals("en-GB", conversationReference3.getLocale());
    assertEquals("en-GB", conversationReference2.getLocale());
    assertEquals("en-GB", conversationReference.getLocale());
    assertEquals("https://smba.trafficmanager.net/uk/", continuationActivity4.getServiceUrl());
    assertEquals("https://smba.trafficmanager.net/uk/", continuationActivity3.getServiceUrl());
    assertEquals("https://smba.trafficmanager.net/uk/", continuationActivity2.getServiceUrl());
    assertEquals("https://smba.trafficmanager.net/uk/", continuationActivity.getServiceUrl());
    assertEquals("https://smba.trafficmanager.net/uk/", createContactRelationUpdateActivityResult.getServiceUrl());
    assertEquals("https://smba.trafficmanager.net/uk/", conversationReference4.getServiceUrl());
    assertEquals("https://smba.trafficmanager.net/uk/", conversationReference3.getServiceUrl());
    assertEquals("https://smba.trafficmanager.net/uk/", conversationReference2.getServiceUrl());
    assertEquals("https://smba.trafficmanager.net/uk/", conversationReference.getServiceUrl());
    assertEquals("msteams", continuationActivity4.getChannelId());
    assertEquals("msteams", continuationActivity3.getChannelId());
    assertEquals("msteams", continuationActivity2.getChannelId());
    assertEquals("msteams", continuationActivity.getChannelId());
    assertEquals("msteams", createContactRelationUpdateActivityResult.getChannelId());
    assertEquals("msteams", conversationReference4.getChannelId());
    assertEquals("msteams", conversationReference3.getChannelId());
    assertEquals("msteams", conversationReference2.getChannelId());
    assertEquals("msteams", conversationReference.getChannelId());
    assertNull(recipient.getRole());
    assertNull(conversation.getRole());
    assertNull(recipient.getAadObjectId());
    assertNull(recipient.getName());
    assertNull(conversation.getAadObjectId());
    assertNull(conversation.getName());
    assertFalse(conversation.isGroup());
    assertTrue(continuationActivity4.isTeamsActivity());
    assertTrue(continuationActivity3.isTeamsActivity());
    assertTrue(continuationActivity2.isTeamsActivity());
    assertTrue(continuationActivity.isTeamsActivity());
    assertTrue(createContactRelationUpdateActivityResult.isTeamsActivity());
    assertTrue(recipient.getProperties().isEmpty());
    assertTrue(conversation.getProperties().isEmpty());
    assertSame(botAccount, continuationActivity4.getFrom());
    assertSame(botAccount, continuationActivity3.getFrom());
    assertSame(botAccount, continuationActivity2.getFrom());
    assertSame(botAccount, continuationActivity.getFrom());
    assertSame(botAccount, createContactRelationUpdateActivityResult.getFrom());
    assertSame(botAccount, conversationReference4.getUser());
    assertSame(botAccount, conversationReference3.getUser());
    assertSame(botAccount, conversationReference2.getUser());
    assertSame(botAccount, conversationReference.getUser());
    assertSame(conversation, continuationActivity4.getConversation());
    assertSame(conversation, continuationActivity3.getConversation());
    assertSame(conversation, continuationActivity2.getConversation());
    assertSame(conversation, continuationActivity.getConversation());
    assertSame(conversation, conversationReference4.getConversation());
    assertSame(conversation, conversationReference3.getConversation());
    assertSame(conversation, conversationReference2.getConversation());
    assertSame(conversation, conversationReference.getConversation());
    assertSame(recipient, continuationActivity4.getRecipient());
    assertSame(recipient, continuationActivity3.getRecipient());
    assertSame(recipient, continuationActivity2.getRecipient());
    assertSame(recipient, continuationActivity.getRecipient());
    assertSame(recipient, conversationReference4.getBot());
    assertSame(recipient, conversationReference3.getBot());
    assertSame(recipient, conversationReference2.getBot());
    assertSame(recipient, conversationReference.getBot());
  }

  /**
   * Method under test:
   * {@link TeamsWorkflowConfig#teamsStorageIDResponseHandler(TeamsStateStorage)}
   */
  @Test
  void testTeamsStorageIDResponseHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertEquals(Integer.MIN_VALUE,
        teamsWorkflowConfig
            .teamsStorageIDResponseHandler(new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))
            .getOrder());
  }

  /**
   * Method under test: {@link TeamsWorkflowConfig#teamsInMemoryStateStorage()}
   */
  @Test
  void testTeamsInMemoryStateStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TeamsWorkflowConfig()).teamsInMemoryStateStorage() instanceof MemoryStateStorage);
  }

  /**
   * Method under test:
   * {@link TeamsWorkflowConfig#teamsInFileStateStorage(String)}
   */
  @Test
  void testTeamsInFileStateStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TeamsWorkflowConfig()).teamsInFileStateStorage("/directory/foo.txt") instanceof FileStateStorage);
  }

  /**
   * Method under test:
   * {@link TeamsWorkflowConfig#teamsHistory(TeamsStateStorage)}
   */
  @Test
  void testTeamsHistory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    ObjectMapper om = new ObjectMapper();

    // Act
    TeamsHistory actualTeamsHistoryResult = teamsWorkflowConfig
        .teamsHistory(new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Assert
    assertTrue(actualTeamsHistoryResult instanceof StateStorageBasedTeamsHistory);
    assertTrue(((StateStorageBasedTeamsHistory) actualTeamsHistoryResult).tss instanceof MemoryStateStorage);
  }

  /**
   * Method under test:
   * {@link TeamsWorkflowConfig#teamsFormConverter(AllConversations)}
   */
  @Test
  void testTeamsFormConverter() throws MissingResourceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();

    // Act and Assert
    ObjectMapper objectMapper = teamsWorkflowConfig.teamsFormConverter(new AllConversations()).getObjectMapper();
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
    SerializerFactory serializerFactory = objectMapper.getSerializerFactory();
    SerializerFactoryConfig factoryConfig = ((BeanSerializerFactory) serializerFactory).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig.serializers();
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
    DeserializerFactoryConfig factoryConfig2 = ((BeanDeserializerFactory) factory2).getFactoryConfig();
    Iterable<Deserializers> deserializersResult = factoryConfig2.deserializers();
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
    assertNull(deserializationConfig.getProblemHandlers());
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
    TypeFactory typeFactory = objectMapper.getTypeFactory();
    assertNull(typeFactory.getClassLoader());
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
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult2.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(2, versionResult2.getPatchLevel());
    assertEquals(2, objectMapper.getRegisteredModuleIds().size());
    assertEquals(2079, factory.getGeneratorFeatures());
    assertEquals(21771068, serializationConfig.getSerializationFeatures());
    assertEquals(237020304, deserializationConfig.getDeserializationFeatures());
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
    assertFalse(factoryConfig2.hasAbstractTypeResolvers());
    assertFalse(deserializationConfig.hasExplicitTimeZone());
    assertFalse(serializationConfig.hasExplicitTimeZone());
    assertFalse(((ArrayIterator<Serializers>) serializersResult).hasNext());
    assertFalse(locale.hasExtensions());
    assertTrue(factoryConfig2.hasDeserializerModifiers());
    assertTrue(factoryConfig2.hasDeserializers());
    assertTrue(factoryConfig2.hasKeyDeserializers());
    assertTrue(factoryConfig2.hasValueInstantiators());
    assertTrue(deserializationConfig.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig.isAnnotationProcessingEnabled());
    assertTrue(factoryConfig.hasKeySerializers());
    assertTrue(factoryConfig.hasSerializerModifiers());
    assertTrue(factoryConfig.hasSerializers());
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).hasNext());
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
    assertSame(typeFactory, serializerProviderInstance.getTypeFactory());
    assertSame(typeFactory, deserializationConfig.getTypeFactory());
    assertSame(typeFactory, serializationConfig.getTypeFactory());
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
   * Method under test:
   * {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  void testTeamsActivityHandler() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormValidationProcessor fvp = new FormValidationProcessor(new CustomValidatorBean(), null);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations tc = new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    ObjectMapper om2 = new ObjectMapper();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om2, new ArrayList<>()));

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult = teamsWorkflowConfig.teamsActivityHandler(messageConsumers,
        parser, fvp, tc, teamsStateStorage, new TeamsFormConverter(new ObjectMapper()));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    CompletableFuture<Void> actualOnTurnResult = actualTeamsActivityHandlerResult.onTurn(
        new DelegatingTurnContext(new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity())));

    // Assert
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(actualOnTurnResult.get());
    assertTrue(actualOnTurnResult.isDone());
  }

  /**
   * Method under test:
   * {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  void testTeamsActivityHandler2() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    messageConsumers.add(new RoomWelcomeEventConsumer(null));
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormValidationProcessor fvp = new FormValidationProcessor(new CustomValidatorBean(), null);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations tc = new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    ObjectMapper om2 = new ObjectMapper();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om2, new ArrayList<>()));

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult = teamsWorkflowConfig.teamsActivityHandler(messageConsumers,
        parser, fvp, tc, teamsStateStorage, new TeamsFormConverter(new ObjectMapper()));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    CompletableFuture<Void> actualOnTurnResult = actualTeamsActivityHandlerResult.onTurn(
        new DelegatingTurnContext(new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity())));

    // Assert
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(actualOnTurnResult.get());
    assertTrue(actualOnTurnResult.isDone());
  }

  /**
   * Method under test:
   * {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  void testTeamsActivityHandler3() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    messageConsumers.add(new RoomWelcomeEventConsumer(null));
    messageConsumers.add(new RoomWelcomeEventConsumer(null));
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormValidationProcessor fvp = new FormValidationProcessor(new CustomValidatorBean(), null);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations tc = new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    ObjectMapper om2 = new ObjectMapper();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om2, new ArrayList<>()));

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult = teamsWorkflowConfig.teamsActivityHandler(messageConsumers,
        parser, fvp, tc, teamsStateStorage, new TeamsFormConverter(new ObjectMapper()));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    CompletableFuture<Void> actualOnTurnResult = actualTeamsActivityHandlerResult.onTurn(
        new DelegatingTurnContext(new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity())));

    // Assert
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(actualOnTurnResult.get());
    assertTrue(actualOnTurnResult.isDone());
  }

  /**
   * Method under test:
   * {@link TeamsWorkflowConfig#teamsAddressingChecker(TeamsConversations)}
   */
  @Test
  void testTeamsAddressingChecker() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act
    AddressingChecker actualTeamsAddressingCheckerResult = teamsWorkflowConfig
        .teamsAddressingChecker(new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
            new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()))));
    ErrorAction errorAction = new ErrorAction(new TeamsChannel("42", "Name"), "Ej");

    // Assert
    assertTrue(actualTeamsAddressingCheckerResult instanceof InRoomAddressingChecker);
    assertSame(errorAction, actualTeamsAddressingCheckerResult.filter(errorAction));
  }
}
