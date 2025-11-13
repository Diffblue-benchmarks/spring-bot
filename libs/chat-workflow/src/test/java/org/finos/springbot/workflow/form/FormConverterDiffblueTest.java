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
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code Value}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given '42'; when HashMap() '42' is 'Value'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_given42_whenHashMap42IsValue_thenThrowUnsupportedOperationException()
      throws ClassNotFoundException {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om);

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("42", "Value");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> formConverter.convert(formValues, "Type"));
  }

  /**
   * Test {@link FormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code action}.
   *   <li>When {@link HashMap#HashMap()} {@code action} is {@code Value}.
   *   <li>Then return {@link FormSubmission#structure} Empty.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given 'action'; when HashMap() 'action' is 'Value'; then return structure Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_givenAction_whenHashMapActionIsValue_thenReturnStructureEmpty()
      throws ClassNotFoundException {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om);

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("action", "Value");

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
   *   <li>Then return {@link FormSubmission#structure} {@code Couldn't convert {}} is {@code
   *       Value}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given 'Couldn't convert {}'; then return structure 'Couldn't convert {}' is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_givenCouldnTConvert_thenReturnStructureCouldnTConvertIsValue()
      throws ClassNotFoundException {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om);

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("Couldn't convert {} ", "Value");

    // Act
    Object actualConvertResult = formConverter.convert(formValues, "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals(1, ((Map<String, String>) object).size());
    assertEquals("Value", ((Map<String, String>) object).get("Couldn't convert {} "));
  }

  /**
   * Test {@link FormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link HashMap#HashMap()} {@code .} is {@code Value}.
   *   <li>Then return {@link FormSubmission#structure} empty string is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given '.'; when HashMap() '.' is 'Value'; then return structure empty string is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FormConverter.convert(Map, String)"})
  void testConvert_givenDot_whenHashMapDotIsValue_thenReturnStructureEmptyStringIsValue()
      throws ClassNotFoundException {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om);

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put(".", "Value");

    // Act
    Object actualConvertResult = formConverter.convert(formValues, "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals("Type", ((FormSubmission) actualConvertResult).formName);
    assertEquals(1, ((Map<String, String>) object).size());
    assertEquals("Value", ((Map<String, String>) object).get(""));
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
