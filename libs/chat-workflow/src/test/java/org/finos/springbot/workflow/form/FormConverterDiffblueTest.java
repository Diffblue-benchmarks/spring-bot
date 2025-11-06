package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FormConverterDiffblueTest {
  /**
   * Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  void testConvert() throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter = new FormConverter(new ObjectMapper());

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
   * Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  void testConvert2() throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter = new FormConverter(null);

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
   * Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  void testConvert3() throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter = new FormConverter(new ObjectMapper());

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
   * Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  void testConvert4() throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter = new FormConverter(new ObjectMapper());

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
   * Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  void testConvert5() throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter = new FormConverter(new ObjectMapper());

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
   * Method under test: {@link FormConverter#convert(Map, String)}
   */
  @Test
  void testConvert6() throws ClassNotFoundException {
    // Arrange
    FormConverter formConverter = new FormConverter(new ObjectMapper());

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("42", "42");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> formConverter.convert(formValues, "Type"));
  }

  /**
   * Method under test: {@link FormConverter#getObjectMapper()}
   */
  @Test
  void testGetObjectMapper() {
    // Arrange
    FormConverter formConverter = new FormConverter(new ObjectMapper());

    // Act and Assert
    assertSame(formConverter.om, formConverter.getObjectMapper());
  }

  /**
   * Method under test: {@link FormConverter#FormConverter(ObjectMapper)}
   */
  @Test
  void testNewFormConverter() {
    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertSame(om, (new FormConverter(om)).getObjectMapper());
  }
}
