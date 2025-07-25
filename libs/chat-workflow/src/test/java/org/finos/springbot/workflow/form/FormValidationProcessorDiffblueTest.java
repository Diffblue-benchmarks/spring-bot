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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

@ContextConfiguration(classes = {FormValidationProcessor.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class FormValidationProcessorDiffblueTest {
  @Autowired private FormValidationProcessor formValidationProcessor;

  @MockitoBean private ResponseHandlers responseHandlers;

  @MockitoBean private Validator validator;

  /**
   * Test {@link FormValidationProcessor#validationCheck(String, Addressable, Object, Supplier)}.
   *
   * <ul>
   *   <li>Given {@link Validator} {@link Validator#validate(Object, Errors)} does nothing.
   *   <li>When {@code Form}.
   *   <li>Then calls {@link Validator#validate(Object, Errors)}.
   * </ul>
   *
   * <p>Method under test: {@link FormValidationProcessor#validationCheck(String, Addressable,
   * Object, Supplier)}
   */
  @Test
  @DisplayName(
      "Test validationCheck(String, Addressable, Object, Supplier); given Validator validate(Object, Errors) does nothing; when 'Form'; then calls validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FormAction FormValidationProcessor.validationCheck(String, Addressable, Object, Supplier)"
  })
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
    FormAction actualValidationCheckResult =
        formValidationProcessor.validationCheck("Verb", from, "Form", callback);

    // Assert
    verify(callback).get();
    verify(validator).validate(isA(Object.class), isA(Errors.class));
    assertSame(formAction, actualValidationCheckResult);
  }

  /**
   * Test {@link FormValidationProcessor#validationCheck(String, Addressable, Object, Supplier)}.
   *
   * <ul>
   *   <li>Given {@link Validator}.
   *   <li>When {@link FormSubmission#FormSubmission(String, Object)} with {@code Form Name} and
   *       {@code Structure}.
   * </ul>
   *
   * <p>Method under test: {@link FormValidationProcessor#validationCheck(String, Addressable,
   * Object, Supplier)}
   */
  @Test
  @DisplayName(
      "Test validationCheck(String, Addressable, Object, Supplier); given Validator; when FormSubmission(String, Object) with 'Form Name' and 'Structure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FormAction FormValidationProcessor.validationCheck(String, Addressable, Object, Supplier)"
  })
  void testValidationCheck_givenValidator_whenFormSubmissionWithFormNameAndStructure() {
    // Arrange
    Addressable from = mock(Addressable.class);
    FormSubmission formSubmission = new FormSubmission("Form Name", "Structure");

    Supplier<FormAction> callback = mock(Supplier.class);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    FormAction formAction = new FormAction(a, u, "Form Data", "Action", new HashMap<>());

    when(callback.get()).thenReturn(formAction);

    // Act
    FormAction actualValidationCheckResult =
        formValidationProcessor.validationCheck("Verb", from, formSubmission, callback);

    // Assert
    verify(callback).get();
    assertSame(formAction, actualValidationCheckResult);
  }

  /**
   * Test {@link FormValidationProcessor#validationCheck(String, Addressable, Object, Supplier)}.
   *
   * <ul>
   *   <li>Given {@link Validator}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormValidationProcessor#validationCheck(String, Addressable,
   * Object, Supplier)}
   */
  @Test
  @DisplayName(
      "Test validationCheck(String, Addressable, Object, Supplier); given Validator; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FormAction FormValidationProcessor.validationCheck(String, Addressable, Object, Supplier)"
  })
  void testValidationCheck_givenValidator_whenNull() {
    // Arrange
    Addressable from = mock(Addressable.class);
    Supplier<FormAction> callback = mock(Supplier.class);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    FormAction formAction = new FormAction(a, u, "Form Data", "Action", new HashMap<>());

    when(callback.get()).thenReturn(formAction);

    // Act
    FormAction actualValidationCheckResult =
        formValidationProcessor.validationCheck("Verb", from, null, callback);

    // Assert
    verify(callback).get();
    assertSame(formAction, actualValidationCheckResult);
  }

  /**
   * Test {@link FormValidationProcessor#validated(Object, Errors)}.
   *
   * <ul>
   *   <li>Given {@link ObjectError#ObjectError(String, String)} with {@code Object Name} and {@code
   *       Default Message}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormValidationProcessor#validated(Object, Errors)}
   */
  @Test
  @DisplayName(
      "Test validated(Object, Errors); given ObjectError(String, String) with 'Object Name' and 'Default Message'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormValidationProcessor.validated(Object, Errors)"})
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
   *
   * <ul>
   *   <li>Given {@link Validator} {@link Validator#validate(Object, Errors)} does nothing.
   *   <li>Then calls {@link Validator#validate(Object, Errors)}.
   * </ul>
   *
   * <p>Method under test: {@link FormValidationProcessor#validated(Object, Errors)}
   */
  @Test
  @DisplayName(
      "Test validated(Object, Errors); given Validator validate(Object, Errors) does nothing; then calls validate(Object, Errors)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormValidationProcessor.validated(Object, Errors)"})
  void testValidated_givenValidatorValidateDoesNothing_thenCallsValidate() {
    // Arrange
    doNothing().when(validator).validate(Mockito.<Object>any(), Mockito.<Errors>any());

    // Act
    boolean actualValidatedResult =
        formValidationProcessor.validated(
            "Current Form", new BindException("Target", "Object Name"));

    // Assert
    verify(validator).validate(isA(Object.class), isA(Errors.class));
    assertTrue(actualValidatedResult);
  }

  /**
   * Test {@link FormValidationProcessor#validated(Object, Errors)}.
   *
   * <ul>
   *   <li>Given {@link Validator}.
   *   <li>When {@link FormSubmission#FormSubmission(String, Object)} with {@code Form Name} and
   *       {@code Structure}.
   * </ul>
   *
   * <p>Method under test: {@link FormValidationProcessor#validated(Object, Errors)}
   */
  @Test
  @DisplayName(
      "Test validated(Object, Errors); given Validator; when FormSubmission(String, Object) with 'Form Name' and 'Structure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormValidationProcessor.validated(Object, Errors)"})
  void testValidated_givenValidator_whenFormSubmissionWithFormNameAndStructure() {
    // Arrange
    FormSubmission formSubmission = new FormSubmission("Form Name", "Structure");

    // Act and Assert
    assertTrue(
        formValidationProcessor.validated(
            formSubmission, new BindException("Target", "Object Name")));
  }

  /**
   * Test {@link FormValidationProcessor#validated(Object, Errors)}.
   *
   * <ul>
   *   <li>Given {@link Validator}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormValidationProcessor#validated(Object, Errors)}
   */
  @Test
  @DisplayName("Test validated(Object, Errors); given Validator; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormValidationProcessor.validated(Object, Errors)"})
  void testValidated_givenValidator_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(formValidationProcessor.validated(null, new BindException("Target", "Object Name")));
  }

  /**
   * Test {@link FormValidationProcessor#convertErrorsToMap(Errors)}.
   *
   * <ul>
   *   <li>Then return Contents size is one.
   * </ul>
   *
   * <p>Method under test: {@link FormValidationProcessor#convertErrorsToMap(Errors)}
   */
  @Test
  @DisplayName("Test convertErrorsToMap(Errors); then return Contents size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ErrorMap FormValidationProcessor.convertErrorsToMap(Errors)"})
  void testConvertErrorsToMap_thenReturnContentsSizeIsOne() {
    // Arrange
    ArrayList<ObjectError> objectErrorList = new ArrayList<>();
    objectErrorList.add(new FieldError("Object Name", "Field", "Default Message"));
    Errors e = mock(Errors.class);
    when(e.getAllErrors()).thenReturn(objectErrorList);

    // Act
    ErrorMap actualConvertErrorsToMapResult = FormValidationProcessor.convertErrorsToMap(e);

    // Assert
    verify(e).getAllErrors();
    Map<String, String> contents = actualConvertErrorsToMapResult.getContents();
    assertEquals(1, contents.size());
    assertEquals("Default Message", contents.get("Field"));
    assertEquals(1, actualConvertErrorsToMapResult.size());
  }

  /**
   * Test {@link FormValidationProcessor#convertErrorsToMap(Errors)}.
   *
   * <ul>
   *   <li>When {@link BindException#BindException(Object, String)} with {@code Target} and {@code
   *       Object Name}.
   * </ul>
   *
   * <p>Method under test: {@link FormValidationProcessor#convertErrorsToMap(Errors)}
   */
  @Test
  @DisplayName(
      "Test convertErrorsToMap(Errors); when BindException(Object, String) with 'Target' and 'Object Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ErrorMap FormValidationProcessor.convertErrorsToMap(Errors)"})
  void testConvertErrorsToMap_whenBindExceptionWithTargetAndObjectName() {
    // Arrange and Act
    ErrorMap actualConvertErrorsToMapResult =
        FormValidationProcessor.convertErrorsToMap(new BindException("Target", "Object Name"));

    // Assert
    assertEquals(0, actualConvertErrorsToMapResult.size());
    assertTrue(actualConvertErrorsToMapResult.getContents().isEmpty());
  }

  /**
   * Test {@link FormValidationProcessor#convertErrorsToMap(Errors)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link FormValidationProcessor#convertErrorsToMap(Errors)}
   */
  @Test
  @DisplayName("Test convertErrorsToMap(Errors); when 'null'; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ErrorMap FormValidationProcessor.convertErrorsToMap(Errors)"})
  void testConvertErrorsToMap_whenNull_thenReturnSizeIsZero() {
    // Arrange and Act
    ErrorMap actualConvertErrorsToMapResult = FormValidationProcessor.convertErrorsToMap(null);

    // Assert
    assertEquals(0, actualConvertErrorsToMapResult.size());
    assertTrue(actualConvertErrorsToMapResult.getContents().isEmpty());
  }
}
