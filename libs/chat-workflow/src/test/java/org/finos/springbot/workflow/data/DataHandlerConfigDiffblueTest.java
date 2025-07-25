package org.finos.springbot.workflow.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import java.util.List;
import org.finos.springbot.entityjson.EntityJsonTypeResolverBuilder;
import org.finos.springbot.entityjson.VersionSpace;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.DropdownList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.finos.springbot.workflow.help.CommandDescription;
import org.finos.springbot.workflow.help.HelpPage;
import org.finos.springbot.workflow.tags.HeaderDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DataHandlerConfig.class})
@ExtendWith(SpringExtension.class)
class DataHandlerConfigDiffblueTest {
  @Autowired private ApplicationContext applicationContext;

  @Autowired private DataHandlerConfig dataHandlerConfig;

  /**
   * Test {@link DataHandlerConfig#scanForWorkClasses()}.
   *
   * <p>Method under test: {@link DataHandlerConfig#scanForWorkClasses()}
   */
  @Test
  @DisplayName("Test scanForWorkClasses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataHandlerConfig.scanForWorkClasses()"})
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
   * Test {@link DataHandlerConfig#entityJsonConverter()}.
   *
   * <p>Method under test: {@link DataHandlerConfig#entityJsonConverter()}
   */
  @Test
  @DisplayName("Test entityJsonConverter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityJsonConverter DataHandlerConfig.entityJsonConverter()"})
  void testEntityJsonConverter() {
    // Arrange and Act
    EntityJsonConverter actualEntityJsonConverterResult = dataHandlerConfig.entityJsonConverter();

    // Assert
    ObjectMapper objectMapper = actualEntityJsonConverterResult.getObjectMapper();
    JsonFactory factory = objectMapper.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(
        objectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(objectMapper.getVisibilityChecker() instanceof Std);
    assertTrue(objectMapper.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(objectMapper.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(objectMapper.getSerializerFactory() instanceof BeanSerializerFactory);
    assertTrue(objectMapper.getSerializerProvider() instanceof Impl);
    assertTrue(objectMapper.getSerializerProviderInstance() instanceof Impl);
    assertTrue(objectMapper.getDateFormat() instanceof StdDateFormat);
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        actualEntityJsonConverterResult.ejtsb;
    assertEquals("type", entityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(objectMapper.getInjectableValues());
    assertNull(objectMapper.getPropertyNamingStrategy());
    assertNull(entityJsonTypeResolverBuilder.getDefaultImpl());
    assertEquals(1, objectMapper.getRegisteredModuleIds().size());
    assertFalse(entityJsonTypeResolverBuilder.isTypeIdVisible());
    assertSame(factory, objectMapper.getJsonFactory());
  }

  /**
   * Test new {@link DataHandlerConfig} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DataHandlerConfig}
   */
  @Test
  @DisplayName("Test new DataHandlerConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataHandlerConfig.<init>()"})
  void testNewDataHandlerConfig() {
    // Arrange, Act and Assert
    assertNull(new DataHandlerConfig().ac);
  }
}
