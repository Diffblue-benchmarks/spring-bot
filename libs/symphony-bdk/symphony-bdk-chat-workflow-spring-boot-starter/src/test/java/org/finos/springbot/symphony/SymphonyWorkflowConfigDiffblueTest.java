package org.finos.springbot.symphony;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.symphony.bdk.core.config.model.BdkBotConfig;
import com.symphony.bdk.core.config.model.BdkCertificateConfig;
import com.symphony.bdk.core.config.model.BdkConfig;
import com.symphony.bdk.core.config.model.BdkRsaKeyConfig;
import com.symphony.bdk.gen.api.model.V4Initiator;
import com.symphony.bdk.gen.api.model.V4MessageSent;
import com.symphony.bdk.spring.events.RealTimeEvent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import org.finos.springbot.symphony.content.serialization.SymphonyMarkupWriter;
import org.finos.springbot.symphony.conversations.StreamResolver;
import org.finos.springbot.symphony.conversations.SymphonyConversations;
import org.finos.springbot.symphony.history.SymphonyHistoryImpl;
import org.finos.springbot.symphony.messages.PresentationMLHandler;
import org.finos.springbot.symphony.response.templating.SymphonyMarkupTemplateProvider;
import org.finos.springbot.symphony.templating.FreemarkerRendering;
import org.finos.springbot.symphony.templating.FreemarkerWorkTemplater;
import org.finos.springbot.symphony.templating.SymphonyTemplateProvider;
import org.finos.springbot.workflow.actions.consumers.ActionConsumer;
import org.finos.springbot.workflow.response.templating.AbstractMarkupTemplateProvider;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ResourceLoader;

@ExtendWith(MockitoExtension.class)
class SymphonyWorkflowConfigDiffblueTest {
  @InjectMocks
  private SymphonyWorkflowConfig symphonyWorkflowConfig;

  @Mock
  private ResourceLoader resourceLoader;

  /**
   * Test {@link SymphonyWorkflowConfig#symphonyMarkupTemplater(String, String, String, SymphonyMarkupWriter)}.
   * <p>
   * Method under test: {@link SymphonyWorkflowConfig#symphonyMarkupTemplater(String, String, String, SymphonyMarkupWriter)}
   */
  @Test
  @DisplayName("Test symphonyMarkupTemplater(String, String, String, SymphonyMarkupWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "SymphonyMarkupTemplateProvider SymphonyWorkflowConfig.symphonyMarkupTemplater(String, String, String, SymphonyMarkupWriter)"})
  void testSymphonyMarkupTemplater() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    SymphonyWorkflowConfig symphonyWorkflowConfig = new SymphonyWorkflowConfig();

    // Act and Assert
    assertNull(symphonyWorkflowConfig
        .symphonyMarkupTemplater("Prefix", "Suffix", "Message Default", new SymphonyMarkupWriter())
        .getTemplateForName("Name"));
  }

  /**
   * Test {@link SymphonyWorkflowConfig#symphonyWorkTemplater(String, String, String, FreemarkerWorkTemplater)}.
   * <p>
   * Method under test: {@link SymphonyWorkflowConfig#symphonyWorkTemplater(String, String, String, FreemarkerWorkTemplater)}
   */
  @Test
  @DisplayName("Test symphonyWorkTemplater(String, String, String, FreemarkerWorkTemplater)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "SymphonyTemplateProvider SymphonyWorkflowConfig.symphonyWorkTemplater(String, String, String, FreemarkerWorkTemplater)"})
  void testSymphonyWorkTemplater() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    SymphonyWorkflowConfig symphonyWorkflowConfig = new SymphonyWorkflowConfig();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();

    // Act and Assert
    assertNull(
        symphonyWorkflowConfig
            .symphonyWorkTemplater("Prefix", "Suffix", "Work Default",
                new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering()))
            .getTemplateForName("Name"));
  }

  /**
   * Test {@link SymphonyWorkflowConfig#symphonyResponseHandler(AbstractMarkupTemplateProvider, SymphonyTemplateProvider, StreamResolver)}.
   * <p>
   * Method under test: {@link SymphonyWorkflowConfig#symphonyResponseHandler(AbstractMarkupTemplateProvider, SymphonyTemplateProvider, StreamResolver)}
   */
  @Test
  @DisplayName("Test symphonyResponseHandler(AbstractMarkupTemplateProvider, SymphonyTemplateProvider, StreamResolver)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.symphony.response.handlers.SymphonyResponseHandler SymphonyWorkflowConfig.symphonyResponseHandler(AbstractMarkupTemplateProvider, SymphonyTemplateProvider, StreamResolver)"})
  void testSymphonyResponseHandler() {
    // Arrange
    SymphonyMarkupTemplateProvider markupTemplater = new SymphonyMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", resourceLoader, mock(BiFunction.class));

    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();

    // Act and Assert
    assertEquals(Integer.MAX_VALUE, symphonyWorkflowConfig
        .symphonyResponseHandler(markupTemplater,
            new SymphonyTemplateProvider("Template Prefix", "Template Suffix", "Default Template Name", resourceLoader,
                new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering())),
            mock(StreamResolver.class))
        .getOrder());
  }

  /**
   * Test {@link SymphonyWorkflowConfig#symphonyHistory(StreamResolver)}.
   * <p>
   * Method under test: {@link SymphonyWorkflowConfig#symphonyHistory(StreamResolver)}
   */
  @Test
  @DisplayName("Test symphonyHistory(StreamResolver)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.symphony.history.SymphonyHistory SymphonyWorkflowConfig.symphonyHistory(StreamResolver)"})
  void testSymphonyHistory() {
    // Arrange, Act and Assert
    assertTrue(symphonyWorkflowConfig.symphonyHistory(mock(StreamResolver.class)) instanceof SymphonyHistoryImpl);
  }

  /**
   * Test {@link SymphonyWorkflowConfig#symphonyPresentationMLHandler(List, SymphonyConversations, BdkConfig)}.
   * <ul>
   *   <li>Given {@link ActionConsumer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyWorkflowConfig#symphonyPresentationMLHandler(List, SymphonyConversations, BdkConfig)}
   */
  @Test
  @DisplayName("Test symphonyPresentationMLHandler(List, SymphonyConversations, BdkConfig); given ActionConsumer")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PresentationMLHandler SymphonyWorkflowConfig.symphonyPresentationMLHandler(List, SymphonyConversations, BdkConfig)"})
  void testSymphonyPresentationMLHandler_givenActionConsumer() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    SymphonyWorkflowConfig symphonyWorkflowConfig = new SymphonyWorkflowConfig();

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    messageConsumers.add(mock(ActionConsumer.class));
    SymphonyConversations sc = mock(SymphonyConversations.class);

    BdkRsaKeyConfig privateKey = new BdkRsaKeyConfig();
    privateKey.setContent("AXAXAXAX".getBytes("UTF-8"));
    privateKey.setPath("Path");

    BdkBotConfig bdkBotConfig = new BdkBotConfig();
    bdkBotConfig.setCertificate(new BdkCertificateConfig("Path", "iloveyou"));
    bdkBotConfig.setCertificateContent("AXAXAXAX".getBytes("UTF-8"));
    bdkBotConfig.setCertificatePassword("iloveyou");
    bdkBotConfig.setCertificatePath("Certificate Path");
    bdkBotConfig.setPrivateKey(privateKey);
    bdkBotConfig.setPrivateKeyContent("AXAXAXAX".getBytes("UTF-8"));
    bdkBotConfig.setPrivateKeyPath("Private Key Path");
    bdkBotConfig.setUsername("janedoe");
    BdkConfig config = mock(BdkConfig.class);
    when(config.getBot()).thenReturn(bdkBotConfig);

    // Act
    PresentationMLHandler actualSymphonyPresentationMLHandlerResult = symphonyWorkflowConfig
        .symphonyPresentationMLHandler(messageConsumers, sc, config);
    V4Initiator initiator = new V4Initiator();
    actualSymphonyPresentationMLHandlerResult.onApplicationEvent(new RealTimeEvent<>(initiator, new V4MessageSent()));

    // Assert
    verify(config).getBot();
    assertTrue(actualSymphonyPresentationMLHandlerResult.supportsAsyncExecution());
  }

  /**
   * Test {@link SymphonyWorkflowConfig#symphonyPresentationMLHandler(List, SymphonyConversations, BdkConfig)}.
   * <ul>
   *   <li>Given {@link ActionConsumer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyWorkflowConfig#symphonyPresentationMLHandler(List, SymphonyConversations, BdkConfig)}
   */
  @Test
  @DisplayName("Test symphonyPresentationMLHandler(List, SymphonyConversations, BdkConfig); given ActionConsumer")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PresentationMLHandler SymphonyWorkflowConfig.symphonyPresentationMLHandler(List, SymphonyConversations, BdkConfig)"})
  void testSymphonyPresentationMLHandler_givenActionConsumer2() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    SymphonyWorkflowConfig symphonyWorkflowConfig = new SymphonyWorkflowConfig();

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    messageConsumers.add(mock(ActionConsumer.class));
    messageConsumers.add(mock(ActionConsumer.class));
    SymphonyConversations sc = mock(SymphonyConversations.class);

    BdkRsaKeyConfig privateKey = new BdkRsaKeyConfig();
    privateKey.setContent("AXAXAXAX".getBytes("UTF-8"));
    privateKey.setPath("Path");

    BdkBotConfig bdkBotConfig = new BdkBotConfig();
    bdkBotConfig.setCertificate(new BdkCertificateConfig("Path", "iloveyou"));
    bdkBotConfig.setCertificateContent("AXAXAXAX".getBytes("UTF-8"));
    bdkBotConfig.setCertificatePassword("iloveyou");
    bdkBotConfig.setCertificatePath("Certificate Path");
    bdkBotConfig.setPrivateKey(privateKey);
    bdkBotConfig.setPrivateKeyContent("AXAXAXAX".getBytes("UTF-8"));
    bdkBotConfig.setPrivateKeyPath("Private Key Path");
    bdkBotConfig.setUsername("janedoe");
    BdkConfig config = mock(BdkConfig.class);
    when(config.getBot()).thenReturn(bdkBotConfig);

    // Act
    PresentationMLHandler actualSymphonyPresentationMLHandlerResult = symphonyWorkflowConfig
        .symphonyPresentationMLHandler(messageConsumers, sc, config);
    V4Initiator initiator = new V4Initiator();
    actualSymphonyPresentationMLHandlerResult.onApplicationEvent(new RealTimeEvent<>(initiator, new V4MessageSent()));

    // Assert
    verify(config).getBot();
    assertTrue(actualSymphonyPresentationMLHandlerResult.supportsAsyncExecution());
  }

  /**
   * Test {@link SymphonyWorkflowConfig#symphonyPresentationMLHandler(List, SymphonyConversations, BdkConfig)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyWorkflowConfig#symphonyPresentationMLHandler(List, SymphonyConversations, BdkConfig)}
   */
  @Test
  @DisplayName("Test symphonyPresentationMLHandler(List, SymphonyConversations, BdkConfig); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PresentationMLHandler SymphonyWorkflowConfig.symphonyPresentationMLHandler(List, SymphonyConversations, BdkConfig)"})
  void testSymphonyPresentationMLHandler_whenArrayList() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    SymphonyWorkflowConfig symphonyWorkflowConfig = new SymphonyWorkflowConfig();
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    SymphonyConversations sc = mock(SymphonyConversations.class);

    BdkRsaKeyConfig privateKey = new BdkRsaKeyConfig();
    privateKey.setContent("AXAXAXAX".getBytes("UTF-8"));
    privateKey.setPath("Path");

    BdkBotConfig bdkBotConfig = new BdkBotConfig();
    bdkBotConfig.setCertificate(new BdkCertificateConfig("Path", "iloveyou"));
    bdkBotConfig.setCertificateContent("AXAXAXAX".getBytes("UTF-8"));
    bdkBotConfig.setCertificatePassword("iloveyou");
    bdkBotConfig.setCertificatePath("Certificate Path");
    bdkBotConfig.setPrivateKey(privateKey);
    bdkBotConfig.setPrivateKeyContent("AXAXAXAX".getBytes("UTF-8"));
    bdkBotConfig.setPrivateKeyPath("Private Key Path");
    bdkBotConfig.setUsername("janedoe");
    BdkConfig config = mock(BdkConfig.class);
    when(config.getBot()).thenReturn(bdkBotConfig);

    // Act
    PresentationMLHandler actualSymphonyPresentationMLHandlerResult = symphonyWorkflowConfig
        .symphonyPresentationMLHandler(messageConsumers, sc, config);
    V4Initiator initiator = new V4Initiator();
    actualSymphonyPresentationMLHandlerResult.onApplicationEvent(new RealTimeEvent<>(initiator, new V4MessageSent()));

    // Assert
    verify(config).getBot();
    assertTrue(actualSymphonyPresentationMLHandlerResult.supportsAsyncExecution());
  }

  /**
   * Test {@link SymphonyWorkflowConfig#symphonyFormConverter()}.
   * <p>
   * Method under test: {@link SymphonyWorkflowConfig#symphonyFormConverter()}
   */
  @Test
  @DisplayName("Test symphonyFormConverter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.symphony.form.SymphonyFormConverter SymphonyWorkflowConfig.symphonyFormConverter()"})
  void testSymphonyFormConverter() {
    // Arrange, Act and Assert
    ObjectMapper objectMapper = symphonyWorkflowConfig.symphonyFormConverter().getObjectMapper();
    JsonFactory factory = objectMapper.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(objectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(objectMapper.getVisibilityChecker() instanceof Std);
    assertTrue(objectMapper.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(objectMapper.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(objectMapper.getSerializerFactory() instanceof BeanSerializerFactory);
    assertTrue(objectMapper.getSerializerProvider() instanceof Impl);
    assertTrue(objectMapper.getSerializerProviderInstance() instanceof Impl);
    assertTrue(objectMapper.getDateFormat() instanceof StdDateFormat);
    assertNull(objectMapper.getInjectableValues());
    assertNull(objectMapper.getPropertyNamingStrategy());
    assertEquals(2, objectMapper.getRegisteredModuleIds().size());
    assertSame(factory, objectMapper.getJsonFactory());
  }
}
