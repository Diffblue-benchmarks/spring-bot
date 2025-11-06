package org.finos.springbot.symphony.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.finos.springbot.workflow.form.FormSubmission;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SymphonyFormConverter.class, ObjectMapper.class})
@ExtendWith(SpringExtension.class)
class SymphonyFormConverterDiffblueTest {
  @Autowired
  private SymphonyFormConverter symphonyFormConverter;

  /**
   * Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  void testConvert() throws ClassNotFoundException {
    // Arrange and Act
    Object actualConvertResult = symphonyFormConverter.convert(new HashMap<>(), "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals("Type", ((FormSubmission) actualConvertResult).formName);
    assertTrue(((Map<Object, Object>) object).isEmpty());
  }

  /**
   * Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  void testConvert2() throws ClassNotFoundException {
    // Arrange
    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("entity.formdata", "42");

    // Act
    Object actualConvertResult = symphonyFormConverter.convert(formValues, "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals(1, ((Map<String, LinkedHashMap>) object).size());
    LinkedHashMap getResult = ((Map<String, LinkedHashMap>) object).get("entity");
    assertEquals(1, getResult.size());
    assertEquals("42", getResult.get("formdata"));
    assertEquals("Type", ((FormSubmission) actualConvertResult).formName);
  }

  /**
   * Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  void testConvert3() throws ClassNotFoundException {
    // Arrange
    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("action", "42");

    // Act
    Object actualConvertResult = symphonyFormConverter.convert(formValues, "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals("Type", ((FormSubmission) actualConvertResult).formName);
    assertTrue(((Map<Object, Object>) object).isEmpty());
  }

  /**
   * Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  void testConvert4() throws ClassNotFoundException {
    // Arrange
    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put(".", "42");

    // Act
    Object actualConvertResult = symphonyFormConverter.convert(formValues, "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals(1, ((Map<String, String>) object).size());
    assertEquals("42", ((Map<String, String>) object).get(""));
    assertEquals("Type", ((FormSubmission) actualConvertResult).formName);
  }
}
