package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.function.Supplier;
import org.finos.springbot.workflow.actions.FormAction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
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
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

@DisabledInAotMode
@ContextConfiguration(classes = {FormValidationProcessor.class})
@ExtendWith(SpringExtension.class)
class FormValidationProcessorDiffblueTest {
  @MockBean
  private ResponseHandlers responseHandlers;

  @MockBean
  private Validator validator;

  @Autowired
  private FormValidationProcessor formValidationProcessor;

  /**
   * Test {@link FormValidationProcessor#validationCheck(String, Addressable, Object, Supplier)}.
   * <ul>
   *   <li>Given {@link Validator} {@link Validator#validate(Object, Errors)} does nothing.</li>
   *   <li>When {@code Form}.</li>
   *   <li>Then calls {@link Validator#validate(Object, Errors)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormValidationProcessor#validationCheck(String, Addressable, Object, Supplier)}
   */
  @Test
  @DisplayName("Test validationCheck(String, Addressable, Object, Supplier); given Validator validate(Object, Errors) does nothing; when 'Form'; then calls validate(Object, Errors)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.FormAction org.finos.springbot.workflow.form.FormValidationProcessor.validationCheck(java.lang.String, org.finos.springbot.workflow.content.Addressable, java.lang.Object, java.util.function.Supplier)"})
  void testValidationCheck_givenValidatorValidateDoesNothing_whenForm_thenCallsValidate() {
    // Arrange
    doNothing().when(validator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    Addressable from = mock(Addressable.class);
    Supplier<FormAction> callback = mock(Supplier.class);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    FormAction formAction = new FormAction(a, u, "Form Data", "Action", new HashMap<>());

    when(callback.get()).thenReturn(formAction);

    // Act
    FormAction actualValidationCheckResult = formValidationProcessor.validationCheck("Verb", from, "Form", callback);

    // Assert
    verify(callback).get();
    verify(validator).validate(isA(Object.class), isA(Errors.class));
    assertSame(formAction, actualValidationCheckResult);
  }

  /**
   * Test {@link FormValidationProcessor#validationCheck(String, Addressable, Object, Supplier)}.
   * <ul>
   *   <li>When {@link FormSubmission#FormSubmission(String, Object)} with {@code Form Name} and {@code Structure}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormValidationProcessor#validationCheck(String, Addressable, Object, Supplier)}
   */
  @Test
  @DisplayName("Test validationCheck(String, Addressable, Object, Supplier); when FormSubmission(String, Object) with 'Form Name' and 'Structure'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.FormAction org.finos.springbot.workflow.form.FormValidationProcessor.validationCheck(java.lang.String, org.finos.springbot.workflow.content.Addressable, java.lang.Object, java.util.function.Supplier)"})
  void testValidationCheck_whenFormSubmissionWithFormNameAndStructure() {
    // Arrange
    Addressable from = mock(Addressable.class);
    FormSubmission formSubmission = new FormSubmission("Form Name", "Structure");

    Supplier<FormAction> callback = mock(Supplier.class);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    FormAction formAction = new FormAction(a, u, "Form Data", "Action", new HashMap<>());

    when(callback.get()).thenReturn(formAction);

    // Act
    FormAction actualValidationCheckResult = formValidationProcessor.validationCheck("Verb", from, formSubmission,
        callback);

    // Assert
    verify(callback).get();
    assertSame(formAction, actualValidationCheckResult);
  }

  /**
   * Test {@link FormValidationProcessor#validationCheck(String, Addressable, Object, Supplier)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormValidationProcessor#validationCheck(String, Addressable, Object, Supplier)}
   */
  @Test
  @DisplayName("Test validationCheck(String, Addressable, Object, Supplier); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.FormAction org.finos.springbot.workflow.form.FormValidationProcessor.validationCheck(java.lang.String, org.finos.springbot.workflow.content.Addressable, java.lang.Object, java.util.function.Supplier)"})
  void testValidationCheck_whenNull() {
    // Arrange
    Addressable from = mock(Addressable.class);
    Supplier<FormAction> callback = mock(Supplier.class);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    FormAction formAction = new FormAction(a, u, "Form Data", "Action", new HashMap<>());

    when(callback.get()).thenReturn(formAction);

    // Act
    FormAction actualValidationCheckResult = formValidationProcessor.validationCheck("Verb", from, null, callback);

    // Assert
    verify(callback).get();
    assertSame(formAction, actualValidationCheckResult);
  }

  /**
   * Test {@link FormValidationProcessor#validated(Object, Errors)}.
   * <ul>
   *   <li>Given {@link ObjectError#ObjectError(String, String)} with {@code Object Name} and {@code Default Message}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormValidationProcessor#validated(Object, Errors)}
   */
  @Test
  @DisplayName("Test validated(Object, Errors); given ObjectError(String, String) with 'Object Name' and 'Default Message'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.form.FormValidationProcessor.validated(java.lang.Object, org.springframework.validation.Errors)"})
  void testValidated_givenObjectErrorWithObjectNameAndDefaultMessage_thenReturnFalse() {
    // Arrange
    doNothing().when(validator).validate(Mockito.<Object>any(), Mockito.<Errors>any());

    BindException e = new BindException("Target", "Object Name");
    e.addError(new ObjectError("Object Name", "Default Message"));

    // Act
    boolean actualValidatedResult = formValidationProcessor.validated("Current Form", e);

    // Assert
    verify(validator).validate(isA(Object.class), isA(Errors.class));
    assertFalse(actualValidatedResult);
  }

  /**
   * Test {@link FormValidationProcessor#validated(Object, Errors)}.
   * <ul>
   *   <li>Given {@link Validator} {@link Validator#validate(Object, Errors)} does nothing.</li>
   *   <li>Then calls {@link Validator#validate(Object, Errors)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormValidationProcessor#validated(Object, Errors)}
   */
  @Test
  @DisplayName("Test validated(Object, Errors); given Validator validate(Object, Errors) does nothing; then calls validate(Object, Errors)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.form.FormValidationProcessor.validated(java.lang.Object, org.springframework.validation.Errors)"})
  void testValidated_givenValidatorValidateDoesNothing_thenCallsValidate() {
    // Arrange
    doNothing().when(validator).validate(Mockito.<Object>any(), Mockito.<Errors>any());

    // Act
    boolean actualValidatedResult = formValidationProcessor.validated("Current Form",
        new BindException("Target", "Object Name"));

    // Assert
    verify(validator).validate(isA(Object.class), isA(Errors.class));
    assertTrue(actualValidatedResult);
  }

  /**
   * Test {@link FormValidationProcessor#validated(Object, Errors)}.
   * <ul>
   *   <li>When {@link FormSubmission#FormSubmission(String, Object)} with {@code Form Name} and {@code Structure}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormValidationProcessor#validated(Object, Errors)}
   */
  @Test
  @DisplayName("Test validated(Object, Errors); when FormSubmission(String, Object) with 'Form Name' and 'Structure'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.form.FormValidationProcessor.validated(java.lang.Object, org.springframework.validation.Errors)"})
  void testValidated_whenFormSubmissionWithFormNameAndStructure_thenReturnTrue() {
    // Arrange
    FormSubmission formSubmission = new FormSubmission("Form Name", "Structure");

    // Act and Assert
    assertTrue(formValidationProcessor.validated(formSubmission, new BindException("Target", "Object Name")));
  }

  /**
   * Test {@link FormValidationProcessor#validated(Object, Errors)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormValidationProcessor#validated(Object, Errors)}
   */
  @Test
  @DisplayName("Test validated(Object, Errors); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.form.FormValidationProcessor.validated(java.lang.Object, org.springframework.validation.Errors)"})
  void testValidated_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(formValidationProcessor.validated(null, new BindException("Target", "Object Name")));
  }

  /**
   * Test {@link FormValidationProcessor#convertErrorsToMap(Errors)}.
   * <ul>
   *   <li>When {@link BindException#BindException(Object, String)} with {@code Target} and {@code Object Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormValidationProcessor#convertErrorsToMap(Errors)}
   */
  @Test
  @DisplayName("Test convertErrorsToMap(Errors); when BindException(Object, String) with 'Target' and 'Object Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.form.ErrorMap org.finos.springbot.workflow.form.FormValidationProcessor.convertErrorsToMap(org.springframework.validation.Errors)"})
  void testConvertErrorsToMap_whenBindExceptionWithTargetAndObjectName() {
    // Arrange and Act
    ErrorMap actualConvertErrorsToMapResult = FormValidationProcessor
        .convertErrorsToMap(new BindException("Target", "Object Name"));

    // Assert
    assertEquals(0, actualConvertErrorsToMapResult.size());
    assertTrue(actualConvertErrorsToMapResult.getContents().isEmpty());
  }

  /**
   * Test {@link FormValidationProcessor#convertErrorsToMap(Errors)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormValidationProcessor#convertErrorsToMap(Errors)}
   */
  @Test
  @DisplayName("Test convertErrorsToMap(Errors); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.form.ErrorMap org.finos.springbot.workflow.form.FormValidationProcessor.convertErrorsToMap(org.springframework.validation.Errors)"})
  void testConvertErrorsToMap_whenNull() {
    // Arrange and Act
    ErrorMap actualConvertErrorsToMapResult = FormValidationProcessor.convertErrorsToMap(null);

    // Assert
    assertEquals(0, actualConvertErrorsToMapResult.size());
    assertTrue(actualConvertErrorsToMapResult.getContents().isEmpty());
  }
}
