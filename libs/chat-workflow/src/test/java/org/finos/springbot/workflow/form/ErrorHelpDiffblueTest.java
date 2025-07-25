package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
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
import org.springframework.validation.BindException;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.Validator;

@ContextConfiguration(classes = {ErrorHelp.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ErrorHelpDiffblueTest {
  @Autowired private ErrorHelp errorHelp;

  @MockitoBean private Validator validator;

  /**
   * Test {@link ErrorHelp#createErrorHolder()}.
   *
   * <p>Method under test: {@link ErrorHelp#createErrorHolder()}
   */
  @Test
  @DisplayName("Test createErrorHolder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Errors ErrorHelp.createErrorHolder()"})
  void testCreateErrorHolder() {
    // Arrange and Act
    Errors actualCreateErrorHolderResult = ErrorHelp.createErrorHolder();

    // Assert
    Object target = ((MapBindingResult) actualCreateErrorHolderResult).getTarget();
    assertTrue(target instanceof Map);
    assertTrue(
        ((MapBindingResult) actualCreateErrorHolderResult).getMessageCodesResolver()
            instanceof DefaultMessageCodesResolver);
    assertTrue(actualCreateErrorHolderResult instanceof MapBindingResult);
    assertEquals("", actualCreateErrorHolderResult.getNestedPath());
    assertEquals("", actualCreateErrorHolderResult.getObjectName());
    assertNull(((MapBindingResult) actualCreateErrorHolderResult).getPropertyEditorRegistry());
    assertNull(actualCreateErrorHolderResult.getFieldError());
    assertNull(actualCreateErrorHolderResult.getGlobalError());
    assertEquals(0, actualCreateErrorHolderResult.getErrorCount());
    assertEquals(0, actualCreateErrorHolderResult.getFieldErrorCount());
    assertEquals(0, actualCreateErrorHolderResult.getGlobalErrorCount());
    assertEquals(
        0, ((MapBindingResult) actualCreateErrorHolderResult).getSuppressedFields().length);
    Map<String, Object> model = ((MapBindingResult) actualCreateErrorHolderResult).getModel();
    assertEquals(2, model.size());
    assertFalse(actualCreateErrorHolderResult.hasErrors());
    assertFalse(actualCreateErrorHolderResult.hasFieldErrors());
    assertFalse(actualCreateErrorHolderResult.hasGlobalErrors());
    assertTrue(actualCreateErrorHolderResult.getAllErrors().isEmpty());
    assertTrue(actualCreateErrorHolderResult.getFieldErrors().isEmpty());
    assertTrue(actualCreateErrorHolderResult.getGlobalErrors().isEmpty());
    assertTrue(model.containsKey(""));
    assertTrue(model.containsKey("org.springframework.validation.BindingResult."));
    assertTrue(((Map<Object, Object>) target).isEmpty());
    assertSame(target, ((MapBindingResult) actualCreateErrorHolderResult).getTargetMap());
  }

  /**
   * Test {@link ErrorHelp#errors(Errors)}.
   *
   * <ul>
   *   <li>When {@link BindException#BindException(Object, String)} with {@code Target} and {@code
   *       Object Name}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ErrorHelp#errors(Errors)}
   */
  @Test
  @DisplayName(
      "Test errors(Errors); when BindException(Object, String) with 'Target' and 'Object Name'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ErrorHelp.errors(Errors)"})
  void testErrors_whenBindExceptionWithTargetAndObjectName_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ErrorHelp.errors(new BindException("Target", "Object Name")));
  }

  /**
   * Test {@link ErrorHelp#performErrorHandling(Object)}.
   *
   * <ul>
   *   <li>Given {@link Validator} {@link Validator#validate(Object, Errors)} does nothing.
   *   <li>Then Target return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link ErrorHelp#performErrorHandling(Object)}
   */
  @Test
  @DisplayName(
      "Test performErrorHandling(Object); given Validator validate(Object, Errors) does nothing; then Target return Map")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Errors ErrorHelp.performErrorHandling(Object)"})
  void testPerformErrorHandling_givenValidatorValidateDoesNothing_thenTargetReturnMap() {
    // Arrange
    doNothing().when(validator).validate(Mockito.<Object>any(), Mockito.<Errors>any());

    // Act
    Errors actualPerformErrorHandlingResult = errorHelp.performErrorHandling("Current Form");

    // Assert
    verify(validator).validate(isA(Object.class), isA(Errors.class));
    Object target = ((MapBindingResult) actualPerformErrorHandlingResult).getTarget();
    assertTrue(target instanceof Map);
    assertTrue(
        ((MapBindingResult) actualPerformErrorHandlingResult).getMessageCodesResolver()
            instanceof DefaultMessageCodesResolver);
    assertTrue(actualPerformErrorHandlingResult instanceof MapBindingResult);
    assertEquals("", actualPerformErrorHandlingResult.getNestedPath());
    assertEquals("", actualPerformErrorHandlingResult.getObjectName());
    assertNull(((MapBindingResult) actualPerformErrorHandlingResult).getPropertyEditorRegistry());
    assertNull(actualPerformErrorHandlingResult.getFieldError());
    assertNull(actualPerformErrorHandlingResult.getGlobalError());
    assertEquals(0, actualPerformErrorHandlingResult.getErrorCount());
    assertEquals(0, actualPerformErrorHandlingResult.getFieldErrorCount());
    assertEquals(0, actualPerformErrorHandlingResult.getGlobalErrorCount());
    assertEquals(
        0, ((MapBindingResult) actualPerformErrorHandlingResult).getSuppressedFields().length);
    Map<String, Object> model = ((MapBindingResult) actualPerformErrorHandlingResult).getModel();
    assertEquals(2, model.size());
    assertFalse(actualPerformErrorHandlingResult.hasErrors());
    assertFalse(actualPerformErrorHandlingResult.hasFieldErrors());
    assertFalse(actualPerformErrorHandlingResult.hasGlobalErrors());
    assertTrue(actualPerformErrorHandlingResult.getAllErrors().isEmpty());
    assertTrue(actualPerformErrorHandlingResult.getFieldErrors().isEmpty());
    assertTrue(actualPerformErrorHandlingResult.getGlobalErrors().isEmpty());
    assertTrue(model.containsKey(""));
    assertTrue(model.containsKey("org.springframework.validation.BindingResult."));
    assertTrue(((Map<Object, Object>) target).isEmpty());
    assertSame(target, ((MapBindingResult) actualPerformErrorHandlingResult).getTargetMap());
  }

  /**
   * Test {@link ErrorHelp#performErrorHandling(Object)}.
   *
   * <ul>
   *   <li>Given {@link Validator}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ErrorHelp#performErrorHandling(Object)}
   */
  @Test
  @DisplayName(
      "Test performErrorHandling(Object); given Validator; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Errors ErrorHelp.performErrorHandling(Object)"})
  void testPerformErrorHandling_givenValidator_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(errorHelp.performErrorHandling(null));
  }
}
