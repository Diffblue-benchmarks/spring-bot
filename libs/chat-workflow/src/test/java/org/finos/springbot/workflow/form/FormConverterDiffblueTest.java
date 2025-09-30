package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om);

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
   *   <li>Then return {@link FormSubmission#structure} Empty.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given 'action'; when HashMap() 'action' is '42'; then return structure Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_givenAction_whenHashMapActionIs42_thenReturnStructureEmpty()
      throws ClassNotFoundException {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om);

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
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om);

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
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om);

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
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link FormSubmission#structure} Empty.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName("Test convert(Map, String); when HashMap(); then return structure Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_whenHashMap_thenReturnStructureEmpty() throws ClassNotFoundException {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om);

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
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om);

    // Act
    ObjectMapper actualObjectMapper = formConverter.getObjectMapper();

    // Assert
    assertSame(formConverter.om, actualObjectMapper);
  }
}
