package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;

class ErrorHelpDiffblueTest {
  /**
   * Method under test: {@link ErrorHelp#createErrorHolder()}
   */
  @Test
  void testCreateErrorHolder() {
    // Arrange and Act
    Errors actualCreateErrorHolderResult = ErrorHelp.createErrorHolder();

    // Assert
    Object target = ((MapBindingResult) actualCreateErrorHolderResult).getTarget();
    assertTrue(target instanceof Map);
    assertTrue(((MapBindingResult) actualCreateErrorHolderResult)
        .getMessageCodesResolver() instanceof DefaultMessageCodesResolver);
    assertTrue(actualCreateErrorHolderResult instanceof MapBindingResult);
    assertEquals("", actualCreateErrorHolderResult.getNestedPath());
    assertEquals("", actualCreateErrorHolderResult.getObjectName());
    assertNull(((MapBindingResult) actualCreateErrorHolderResult).getPropertyEditorRegistry());
    assertNull(actualCreateErrorHolderResult.getFieldError());
    assertNull(actualCreateErrorHolderResult.getGlobalError());
    assertEquals(0, actualCreateErrorHolderResult.getErrorCount());
    assertEquals(0, actualCreateErrorHolderResult.getFieldErrorCount());
    assertEquals(0, actualCreateErrorHolderResult.getGlobalErrorCount());
    assertEquals(0, ((MapBindingResult) actualCreateErrorHolderResult).getSuppressedFields().length);
    Map<String, Object> model = ((MapBindingResult) actualCreateErrorHolderResult).getModel();
    assertEquals(2, model.size());
    assertFalse(actualCreateErrorHolderResult.hasErrors());
    assertFalse(actualCreateErrorHolderResult.hasFieldErrors());
    assertFalse(actualCreateErrorHolderResult.hasGlobalErrors());
    assertTrue(actualCreateErrorHolderResult.getAllErrors().isEmpty());
    assertTrue(actualCreateErrorHolderResult.getFieldErrors().isEmpty());
    assertTrue(actualCreateErrorHolderResult.getGlobalErrors().isEmpty());
    assertTrue(((Map<Object, Object>) target).isEmpty());
    assertSame(actualCreateErrorHolderResult, model.get("org.springframework.validation.BindingResult."));
    assertSame(target, model.get(""));
    assertSame(target, ((MapBindingResult) actualCreateErrorHolderResult).getTargetMap());
  }

  /**
   * Method under test: {@link ErrorHelp#errors(Errors)}
   */
  @Test
  void testErrors() {
    // Arrange, Act and Assert
    assertEquals("", ErrorHelp.errors(new BindException("Target", "Object Name")));
  }

  /**
   * Method under test: {@link ErrorHelp#performErrorHandling(Object)}
   */
  @Test
  void testPerformErrorHandling() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ErrorHelp()).performErrorHandling(null));
  }
}
