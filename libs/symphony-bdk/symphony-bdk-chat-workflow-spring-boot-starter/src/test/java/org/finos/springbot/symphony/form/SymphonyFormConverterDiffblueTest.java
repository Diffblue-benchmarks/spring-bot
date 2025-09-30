package org.finos.springbot.symphony.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.form.FormSubmission;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
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
   *   <li>Given {@code action}.
   *   <li>When {@link HashMap#HashMap()} {@code action} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName("Test convert(Map, String); given 'action'; when HashMap() 'action' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SymphonyFormConverter.convert(Map, String)"})
  void testConvert_givenAction_whenHashMapActionIs42() throws ClassNotFoundException {
    // Arrange
    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("action", "42");
    formValues.put("42", "42");
    formValues.put("Couldn't convert {} ", "42");
    formValues.put("entity.formdata", "42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> symphonyFormConverter.convert(formValues, "Type"));
  }

  /**
   * Test {@link SymphonyFormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code \.}.
   *   <li>When {@link HashMap#HashMap()} {@code \.} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName("Test convert(Map, String); given '\\.'; when HashMap() '\\.' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SymphonyFormConverter.convert(Map, String)"})
  void testConvert_givenBackslashDot_whenHashMapBackslashDotIs42() throws ClassNotFoundException {
    // Arrange
    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("42", "42");
    formValues.put("\\.", "42");
    formValues.put("entity.formdata", "42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> symphonyFormConverter.convert(formValues, "Type"));
  }

  /**
   * Test {@link SymphonyFormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code Couldn't convert {}}.
   *   <li>When {@link HashMap#HashMap()} {@code Couldn't convert {}} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName(
      "Test convert(Map, String); given 'Couldn't convert {}'; when HashMap() 'Couldn't convert {}' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SymphonyFormConverter.convert(Map, String)"})
  void testConvert_givenCouldnTConvert_whenHashMapCouldnTConvertIs42()
      throws ClassNotFoundException {
    // Arrange
    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("42", "42");
    formValues.put("Couldn't convert {} ", "42");
    formValues.put("entity.formdata", "42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> symphonyFormConverter.convert(formValues, "Type"));
  }

  /**
   * Test {@link SymphonyFormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Then return {@code Convert Value}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName("Test convert(Map, String); then return 'Convert Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SymphonyFormConverter.convert(Map, String)"})
  void testConvert_thenReturnConvertValue()
      throws ClassNotFoundException, IllegalArgumentException {
    // Arrange
    when(objectMapper.convertValue(Mockito.<Object>any(), Mockito.<Class<Object>>any()))
        .thenReturn("Convert Value");

    HashMap<String, Object> formValues = new HashMap<>();
    formValues.put("entity.formdata", "42");

    // Act
    Object actualConvertResult = symphonyFormConverter.convert(formValues, "Type");

    // Assert
    verify(objectMapper).convertValue(isA(Object.class), (Class<Object>) isNull());
    assertEquals("Convert Value", actualConvertResult);
  }

  /**
   * Test {@link SymphonyFormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>Then {@link FormSubmission#structure} return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName("Test convert(Map, String); then structure return Map")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SymphonyFormConverter.convert(Map, String)"})
  void testConvert_thenStructureReturnMap() throws ClassNotFoundException {
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

  /**
   * Test {@link SymphonyFormConverter#convert(Map, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code Convert Value}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName("Test convert(Map, String); when HashMap(); then return 'Convert Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SymphonyFormConverter.convert(Map, String)"})
  void testConvert_whenHashMap_thenReturnConvertValue()
      throws ClassNotFoundException, IllegalArgumentException {
    // Arrange
    when(objectMapper.convertValue(Mockito.<Object>any(), Mockito.<Class<Object>>any()))
        .thenReturn("Convert Value");

    // Act
    Object actualConvertResult = symphonyFormConverter.convert(new HashMap<>(), "Type");

    // Assert
    verify(objectMapper).convertValue(isA(Object.class), (Class<Object>) isNull());
    assertEquals("Convert Value", actualConvertResult);
  }
}
