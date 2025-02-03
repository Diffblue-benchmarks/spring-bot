package org.finos.springbot.symphony.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SymphonyFormConverter.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class SymphonyFormConverterDiffblueTest {
  @MockBean
  private ObjectMapper objectMapper;

  @Autowired
  private SymphonyFormConverter symphonyFormConverter;

  /**
   * Test {@link SymphonyFormConverter#SymphonyFormConverter(ObjectMapper)}.
   * <p>
   * Method under test: {@link SymphonyFormConverter#SymphonyFormConverter(ObjectMapper)}
   */
  @Test
  @DisplayName("Test new SymphonyFormConverter(ObjectMapper)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.symphony.form.SymphonyFormConverter.<init>(com.fasterxml.jackson.databind.ObjectMapper)"})
  void testNewSymphonyFormConverter() {
    // Arrange, Act and Assert
    assertSame(objectMapper, (new SymphonyFormConverter(objectMapper)).getObjectMapper());
  }

  /**
   * Test {@link SymphonyFormConverter#convert(Map, String)}.
   * <ul>
   *   <li>Given {@code entity.formdata}.</li>
   *   <li>Then return {@code Convert Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName("Test convert(Map, String); given 'entity.formdata'; then return 'Convert Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Object org.finos.springbot.symphony.form.SymphonyFormConverter.convert(java.util.Map, java.lang.String)"})
  void testConvert_givenEntityFormdata_thenReturnConvertValue()
      throws ClassNotFoundException, IllegalArgumentException {
    // Arrange
    when(objectMapper.convertValue(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Convert Value");

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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code Convert Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyFormConverter#convert(Map, String)}
   */
  @Test
  @DisplayName("Test convert(Map, String); when HashMap(); then return 'Convert Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Object org.finos.springbot.symphony.form.SymphonyFormConverter.convert(java.util.Map, java.lang.String)"})
  void testConvert_whenHashMap_thenReturnConvertValue() throws ClassNotFoundException, IllegalArgumentException {
    // Arrange
    when(objectMapper.convertValue(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Convert Value");

    // Act
    Object actualConvertResult = symphonyFormConverter.convert(new HashMap<>(), "Type");

    // Assert
    verify(objectMapper).convertValue(isA(Object.class), (Class<Object>) isNull());
    assertEquals("Convert Value", actualConvertResult);
  }
}
