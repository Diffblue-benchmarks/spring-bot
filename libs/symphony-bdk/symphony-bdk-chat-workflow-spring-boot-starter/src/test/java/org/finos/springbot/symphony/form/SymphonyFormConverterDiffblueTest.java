package org.finos.springbot.symphony.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.finos.springbot.workflow.form.FormSubmission;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SymphonyFormConverter.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class SymphonyFormConverterDiffblueTest {
  @MockitoBean private ObjectMapper objectMapper;

  @Autowired private SymphonyFormConverter symphonyFormConverter;

  /**
   * Test {@link SymphonyFormConverter#SymphonyFormConverter(ObjectMapper)}.
   *
   * <p>Method under test: {@link SymphonyFormConverter#SymphonyFormConverter(ObjectMapper)}
   */
  @Test
  @DisplayName("Test new SymphonyFormConverter(ObjectMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyFormConverter.<init>(ObjectMapper)"})
  void testNewSymphonyFormConverter() {
    // Arrange, Act and Assert
    assertSame(objectMapper, new SymphonyFormConverter(objectMapper).getObjectMapper());
  }

  /**
   * Test {@link SymphonyFormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code Value}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given '42'; when HashMap() '42' is 'Value'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SymphonyFormConverter.convert(Map, String)"})
  void testConvert_given42_whenHashMap42IsValue_thenThrowUnsupportedOperationException()
      throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    SymphonyFormConverter symphonyFormConverter = new SymphonyFormConverter(om);

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("42", "Value");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> symphonyFormConverter.convert(formValues, "Type"));
  }

  /**
   * Test {@link SymphonyFormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code action}.
   *   <li>When {@link HashMap#HashMap()} {@code action} is {@code Value}.
   *   <li>Then return {@link FormSubmission#structure} Empty.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given 'action'; when HashMap() 'action' is 'Value'; then return structure Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SymphonyFormConverter.convert(Map, String)"})
  void testConvert_givenAction_whenHashMapActionIsValue_thenReturnStructureEmpty()
      throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    SymphonyFormConverter symphonyFormConverter = new SymphonyFormConverter(om);

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("action", "Value");

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
   * Test {@link SymphonyFormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link HashMap#HashMap()} {@code .} is {@code Value}.
   *   <li>Then return {@link FormSubmission#structure} empty string is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given '.'; when HashMap() '.' is 'Value'; then return structure empty string is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SymphonyFormConverter.convert(Map, String)"})
  void testConvert_givenDot_whenHashMapDotIsValue_thenReturnStructureEmptyStringIsValue()
      throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    SymphonyFormConverter symphonyFormConverter = new SymphonyFormConverter(om);

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put(".", "Value");

    // Act
    Object actualConvertResult = symphonyFormConverter.convert(formValues, "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals("Type", ((FormSubmission) actualConvertResult).formName);
    assertEquals(1, ((Map<String, String>) object).size());
    assertEquals("Value", ((Map<String, String>) object).get(""));
  }

  /**
   * Test {@link SymphonyFormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code entity.formdata}.
   *   <li>Then return {@link FormSubmission#structure} {@code entity} size is one.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given 'entity.formdata'; then return structure 'entity' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SymphonyFormConverter.convert(Map, String)"})
  void testConvert_givenEntityFormdata_thenReturnStructureEntitySizeIsOne()
      throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    SymphonyFormConverter symphonyFormConverter = new SymphonyFormConverter(om);

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("entity.formdata", "Value");

    // Act
    Object actualConvertResult = symphonyFormConverter.convert(formValues, "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals(1, ((Map<String, LinkedHashMap>) object).size());
    LinkedHashMap getResult = ((Map<String, LinkedHashMap>) object).get("entity");
    assertEquals(1, getResult.size());
    assertEquals("Value", getResult.get("formdata"));
  }

  /**
   * Test {@link SymphonyFormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link FormSubmission#structure} Empty.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName("Test convert(Map, String); when HashMap(); then return structure Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SymphonyFormConverter.convert(Map, String)"})
  void testConvert_whenHashMap_thenReturnStructureEmpty() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    SymphonyFormConverter symphonyFormConverter = new SymphonyFormConverter(om);

    // Act
    Object actualConvertResult = symphonyFormConverter.convert(new HashMap<>(), "Type");

    // Assert
    Object object = ((FormSubmission) actualConvertResult).structure;
    assertTrue(object instanceof Map);
    assertTrue(actualConvertResult instanceof FormSubmission);
    assertEquals("Type", ((FormSubmission) actualConvertResult).formName);
    assertTrue(((Map<Object, Object>) object).isEmpty());
  }
}
