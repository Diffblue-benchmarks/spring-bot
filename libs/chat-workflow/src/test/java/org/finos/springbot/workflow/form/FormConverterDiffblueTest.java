package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FormConverterDiffblueTest {
  /**
   * Test {@link FormConverter#FormConverter(ObjectMapper)}.
   *
   * <p>Method under test: {@link FormConverter#FormConverter(ObjectMapper)}
   */
  @Test
  @DisplayName("Test new FormConverter(ObjectMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormConverter.<init>(ObjectMapper)"})
  void testNewFormConverter() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertSame(om, new FormConverter(om).getObjectMapper());
  }

  /**
   * Test {@link FormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given '42'; when HashMap() '42' is '42'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_given42_whenHashMap42Is42_thenThrowUnsupportedOperationException()
      throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter =
        new FormConverter(JsonMapper.builder().findAndAddModules().build());

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("42", "42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> formConverter.convert(formValues, "Type"));
  }

  /**
   * Test {@link FormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code action}.
   *   <li>When {@link HashMap#HashMap()} {@code action} is {@code 42}.
   *   <li>Then return {@link FormSubmission#formName} is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given 'action'; when HashMap() 'action' is '42'; then return formName is 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_givenAction_whenHashMapActionIs42_thenReturnFormNameIsType()
      throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter =
        new FormConverter(JsonMapper.builder().findAndAddModules().build());

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("action", "42");

    // Act
    Object actualConvertResult = formConverter.convert(formValues, "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals("Type", ((FormSubmission) actualConvertResult).formName);
    assertTrue(((Map<Object, Object>) object).isEmpty());
  }

  /**
   * Test {@link FormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code Couldn't convert {}}.
   *   <li>Then return {@link FormSubmission#structure} {@code Couldn't convert {}} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given 'Couldn't convert {}'; then return structure 'Couldn't convert {}' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_givenCouldnTConvert_thenReturnStructureCouldnTConvertIs42()
      throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter =
        new FormConverter(JsonMapper.builder().findAndAddModules().build());

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("Couldn't convert {} ", "42");

    // Act
    Object actualConvertResult = formConverter.convert(formValues, "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals(1, ((Map<String, String>) object).size());
    assertEquals("42", ((Map<String, String>) object).get("Couldn't convert {} "));
    assertEquals("Type", ((FormSubmission) actualConvertResult).formName);
  }

  /**
   * Test {@link FormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code Couldn't convert {}}.
   *   <li>Then return {@link FormSubmission#structure} {@code Couldn't convert {}} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given 'Couldn't convert {}'; then return structure 'Couldn't convert {}' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_givenCouldnTConvert_thenReturnStructureCouldnTConvertIs422()
      throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter =
        new FormConverter(JsonMapper.builder().findAndAddModules().build());

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("Couldn't convert {} ", "42");

    // Act
    Object actualConvertResult = formConverter.convert(formValues, "java.lang.String");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals(1, ((Map<String, String>) object).size());
    assertEquals("42", ((Map<String, String>) object).get("Couldn't convert {} "));
    assertEquals("java.lang.String", ((FormSubmission) actualConvertResult).formName);
  }

  /**
   * Test {@link FormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link HashMap#HashMap()} {@code .} is {@code 42}.
   *   <li>Then return {@link FormSubmission#structure} empty string is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given '.'; when HashMap() '.' is '42'; then return structure empty string is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_givenDot_whenHashMapDotIs42_thenReturnStructureEmptyStringIs42()
      throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter =
        new FormConverter(JsonMapper.builder().findAndAddModules().build());

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put(".", "42");

    // Act
    Object actualConvertResult = formConverter.convert(formValues, "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals(1, ((Map<String, String>) object).size());
    assertEquals("42", ((Map<String, String>) object).get(""));
    assertEquals("Type", ((FormSubmission) actualConvertResult).formName);
  }

  /**
   * Test {@link FormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link FormSubmission#formName} is {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given 'java.lang.Object'; when HashMap(); then return formName is 'java.lang.String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_givenJavaLangObject_whenHashMap_thenReturnFormNameIsJavaLangString()
      throws ClassNotFoundException {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    FormConverter formConverter = new FormConverter(builderResult.findAndAddModules().build());

    // Act
    Object actualConvertResult = formConverter.convert(new HashMap<>(), "java.lang.String");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals("java.lang.String", ((FormSubmission) actualConvertResult).formName);
    assertTrue(((Map<Object, Object>) object).isEmpty());
  }

  /**
   * Test {@link FormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Then calls {@link CacheProvider#forDeserializerCache(DeserializationConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName("Test convert(Map, String); then calls forDeserializerCache(DeserializationConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_thenCallsForDeserializerCache() throws ClassNotFoundException {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any()))
        .thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(null);
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.cacheProvider(cacheProvider);
    builderResult.defaultAttributes(mock(ContextAttributes.class));
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    FormConverter formConverter = new FormConverter(builderResult.findAndAddModules().build());

    // Act
    Object actualConvertResult = formConverter.convert(new HashMap<>(), "java.lang.String");

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals("java.lang.String", ((FormSubmission) actualConvertResult).formName);
    assertTrue(((Map<Object, Object>) object).isEmpty());
  }

  /**
   * Test {@link FormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ContextAttributes#getAttribute(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName("Test convert(Map, String); then calls getAttribute(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_thenCallsGetAttribute() throws ClassNotFoundException {
    // Arrange
    ContextAttributes attrs = mock(ContextAttributes.class);
    when(attrs.getAttribute(Mockito.<Object>any())).thenThrow(new NumberFormatException("foo"));
    Builder builderResult = JsonMapper.builder();
    builderResult.defaultAttributes(attrs);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    FormConverter formConverter = new FormConverter(builderResult.findAndAddModules().build());

    // Act
    Object actualConvertResult = formConverter.convert(new HashMap<>(), "java.lang.String");

    // Assert
    verify(attrs).getAttribute(isA(Object.class));
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals("java.lang.String", ((FormSubmission) actualConvertResult).formName);
    assertTrue(((Map<Object, Object>) object).isEmpty());
  }

  /**
   * Test {@link FormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link FormSubmission#formName} is {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); when HashMap(); then return formName is 'java.lang.String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_whenHashMap_thenReturnFormNameIsJavaLangString() throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter =
        new FormConverter(JsonMapper.builder().findAndAddModules().build());

    // Act
    Object actualConvertResult = formConverter.convert(new HashMap<>(), "java.lang.String");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals("java.lang.String", ((FormSubmission) actualConvertResult).formName);
    assertTrue(((Map<Object, Object>) object).isEmpty());
  }

  /**
   * Test {@link FormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link FormSubmission#formName} is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName("Test convert(Map, String); when HashMap(); then return formName is 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_whenHashMap_thenReturnFormNameIsType() throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter =
        new FormConverter(JsonMapper.builder().findAndAddModules().build());

    // Act
    Object actualConvertResult = formConverter.convert(new HashMap<>(), "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals("Type", ((FormSubmission) actualConvertResult).formName);
    assertTrue(((Map<Object, Object>) object).isEmpty());
  }

  /**
   * Test {@link FormConverter#getObjectMapper()}.
   *
   * <p>Method under test: {@link FormConverter#getObjectMapper()}
   */
  @Test
  @DisplayName("Test getObjectMapper()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper FormConverter.getObjectMapper()"})
  void testGetObjectMapper() {
    // Arrange
    FormConverter formConverter =
        new FormConverter(JsonMapper.builder().findAndAddModules().build());

    // Act and Assert
    assertSame(formConverter.om, formConverter.getObjectMapper());
  }
}
