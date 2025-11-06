package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.function.Supplier;
import org.finos.springbot.workflow.actions.FormAction;
import org.finos.springbot.workflow.content.Addressable;
import org.junit.jupiter.api.Test;
import org.springframework.util.function.SingletonSupplier;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.CustomValidatorBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

class FormValidationProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link FormValidationProcessor#validationCheck(String, Addressable, Object, Supplier)}
   */
  @Test
  void testValidationCheck() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormValidationProcessor formValidationProcessor = new FormValidationProcessor(new LocalValidatorFactoryBean(),
        null);
    FormAction formAction = new FormAction(null, null, "Form Data", "Action", new HashMap<>());

    // Act and Assert
    assertSame(formAction,
        formValidationProcessor.validationCheck("Verb", null, "Form", new SingletonSupplier<>(formAction, null)));
  }

  /**
   * Method under test: {@link FormValidationProcessor#validated(Object, Errors)}
   */
  @Test
  void testValidated() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormValidationProcessor formValidationProcessor = new FormValidationProcessor(new CustomValidatorBean(), null);

    // Act and Assert
    assertTrue(formValidationProcessor.validated("Current Form", new BindException("Target", "Object Name")));
  }

  /**
   * Method under test: {@link FormValidationProcessor#validated(Object, Errors)}
   */
  @Test
  void testValidated2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormValidationProcessor formValidationProcessor = new FormValidationProcessor(new CustomValidatorBean(), null);

    // Act and Assert
    assertTrue(formValidationProcessor.validated(null, new BindException("Target", "Object Name")));
  }

  /**
   * Method under test: {@link FormValidationProcessor#validated(Object, Errors)}
   */
  @Test
  void testValidated3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormValidationProcessor formValidationProcessor = new FormValidationProcessor(new CustomValidatorBean(), null);
    FormSubmission formSubmission = new FormSubmission("Form Name", "Structure");

    // Act and Assert
    assertTrue(formValidationProcessor.validated(formSubmission, new BindException("Target", "Object Name")));
  }

  /**
   * Method under test: {@link FormValidationProcessor#validated(Object, Errors)}
   */
  @Test
  void testValidated4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormValidationProcessor formValidationProcessor = new FormValidationProcessor(new CustomValidatorBean(), null);

    BindException e = new BindException("Target", "Object Name");
    e.addError(new ObjectError("Object Name", "Default Message"));

    // Act and Assert
    assertFalse(formValidationProcessor.validated("Current Form", e));
  }

  /**
   * Method under test: {@link FormValidationProcessor#convertErrorsToMap(Errors)}
   */
  @Test
  void testConvertErrorsToMap() {
    // Arrange and Act
    ErrorMap actualConvertErrorsToMapResult = FormValidationProcessor
        .convertErrorsToMap(new BindException("Target", "Object Name"));

    // Assert
    assertEquals(0, actualConvertErrorsToMapResult.size());
    assertTrue(actualConvertErrorsToMapResult.getContents().isEmpty());
  }

  /**
   * Method under test: {@link FormValidationProcessor#convertErrorsToMap(Errors)}
   */
  @Test
  void testConvertErrorsToMap2() {
    // Arrange and Act
    ErrorMap actualConvertErrorsToMapResult = FormValidationProcessor.convertErrorsToMap(null);

    // Assert
    assertEquals(0, actualConvertErrorsToMapResult.size());
    assertTrue(actualConvertErrorsToMapResult.getContents().isEmpty());
  }
}
