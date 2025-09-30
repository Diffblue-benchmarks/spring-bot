package org.finos.springbot.symphony.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.finos.springbot.symphony.SymphonyException;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.finos.springbot.workflow.templating.Mode;
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

@ContextConfiguration(classes = {SymphonyTemplateProvider.class, String.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class SymphonyTemplateProviderDiffblueTest {
  @MockitoBean private FreemarkerWorkTemplater freemarkerWorkTemplater;

  @Autowired private SymphonyTemplateProvider symphonyTemplateProvider;

  /**
   * Test {@link SymphonyTemplateProvider#getDefaultTemplate(WorkResponse)} with {@code
   * WorkResponse}.
   *
   * <p>Method under test: {@link SymphonyTemplateProvider#getDefaultTemplate(WorkResponse)}
   */
  @Test
  @DisplayName("Test getDefaultTemplate(WorkResponse) with 'WorkResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTemplateProvider.getDefaultTemplate(WorkResponse)"})
  void testGetDefaultTemplateWithWorkResponse() {
    // Arrange
    when(freemarkerWorkTemplater.convert(Mockito.<Class<?>>any(), Mockito.<Mode>any()))
        .thenThrow(new SymphonyException("An error occurred"));

    // Act and Assert
    assertThrows(
        SymphonyException.class,
        () ->
            symphonyTemplateProvider.getDefaultTemplate(
                new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH)));
    verify(freemarkerWorkTemplater).convert(isA(Class.class), eq(Mode.DISPLAY));
  }

  /**
   * Test {@link SymphonyTemplateProvider#getDefaultTemplate(WorkResponse)} with {@code
   * WorkResponse}.
   *
   * <p>Method under test: {@link SymphonyTemplateProvider#getDefaultTemplate(WorkResponse)}
   */
  @Test
  @DisplayName("Test getDefaultTemplate(WorkResponse) with 'WorkResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTemplateProvider.getDefaultTemplate(WorkResponse)"})
  void testGetDefaultTemplateWithWorkResponse2() {
    // Arrange
    when(freemarkerWorkTemplater.convert(Mockito.<Class<?>>any(), Mockito.<Mode>any()))
        .thenThrow(new SymphonyException("An error occurred"));
    Addressable stream = mock(Addressable.class);
    ErrorResponse r = new ErrorResponse(stream, new Throwable(), "default-edit");

    // Act and Assert
    assertThrows(SymphonyException.class, () -> symphonyTemplateProvider.getDefaultTemplate(r));
    verify(freemarkerWorkTemplater).convert(isA(Class.class), eq(Mode.FORM));
  }

  /**
   * Test {@link SymphonyTemplateProvider#getDefaultTemplate(WorkResponse)} with {@code
   * WorkResponse}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerWorkTemplater}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTemplateProvider#getDefaultTemplate(WorkResponse)}
   */
  @Test
  @DisplayName(
      "Test getDefaultTemplate(WorkResponse) with 'WorkResponse'; given FreemarkerWorkTemplater")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTemplateProvider.getDefaultTemplate(WorkResponse)"})
  void testGetDefaultTemplateWithWorkResponse_givenFreemarkerWorkTemplater() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    ErrorResponse r = new ErrorResponse(stream, new Throwable());

    // Act and Assert
    assertThrows(SymphonyException.class, () -> symphonyTemplateProvider.getDefaultTemplate(r));
  }

  /**
   * Test {@link SymphonyTemplateProvider#needsButtons(Response)}.
   *
   * <ul>
   *   <li>Then throw {@link SymphonyException}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTemplateProvider#needsButtons(Response)}
   */
  @Test
  @DisplayName("Test needsButtons(Response); then throw SymphonyException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SymphonyTemplateProvider.needsButtons(Response)"})
  void testNeedsButtons_thenThrowSymphonyException() {
    // Arrange
    ErrorResponse r = mock(ErrorResponse.class);
    when(r.getData()).thenThrow(new SymphonyException("An error occurred"));

    // Act and Assert
    assertThrows(SymphonyException.class, () -> symphonyTemplateProvider.needsButtons(r));
    verify(r).getData();
  }

  /**
   * Test {@link SymphonyTemplateProvider#needsButtons(Response)}.
   *
   * <ul>
   *   <li>When {@link ErrorResponse#ErrorResponse(Addressable, Throwable)} with stream is {@link
   *       Addressable} and e is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTemplateProvider#needsButtons(Response)}
   */
  @Test
  @DisplayName(
      "Test needsButtons(Response); when ErrorResponse(Addressable, Throwable) with stream is Addressable and e is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SymphonyTemplateProvider.needsButtons(Response)"})
  void testNeedsButtons_whenErrorResponseWithStreamIsAddressableAndEIsThrowable() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    ErrorResponse r = new ErrorResponse(stream, new Throwable());

    // Act and Assert
    assertFalse(symphonyTemplateProvider.needsButtons(r));
  }

  /**
   * Test {@link SymphonyTemplateProvider#needsButtons(Response)}.
   *
   * <ul>
   *   <li>When {@link Response}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTemplateProvider#needsButtons(Response)}
   */
  @Test
  @DisplayName("Test needsButtons(Response); when Response; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SymphonyTemplateProvider.needsButtons(Response)"})
  void testNeedsButtons_whenResponse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(symphonyTemplateProvider.needsButtons(mock(Response.class)));
  }

  /**
   * Test {@link SymphonyTemplateProvider#needsButtons(Response)}.
   *
   * <ul>
   *   <li>When {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)} with to is {@link
   *       Addressable} and o is {@code 42} and m is {@code BOTH}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyTemplateProvider#needsButtons(Response)}
   */
  @Test
  @DisplayName(
      "Test needsButtons(Response); when WorkResponse(Addressable, Object, WorkMode) with to is Addressable and o is '42' and m is 'BOTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SymphonyTemplateProvider.needsButtons(Response)"})
  void testNeedsButtons_whenWorkResponseWithToIsAddressableAndOIs42AndMIsBoth() {
    // Arrange, Act and Assert
    assertFalse(
        symphonyTemplateProvider.needsButtons(
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH)));
  }

  /**
   * Test {@link SymphonyTemplateProvider#deserializeTemplate(InputStream)}.
   *
   * <p>Method under test: {@link SymphonyTemplateProvider#deserializeTemplate(InputStream)}
   */
  @Test
  @DisplayName("Test deserializeTemplate(InputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTemplateProvider.deserializeTemplate(InputStream)"})
  void testDeserializeTemplate() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("AXAXAXAX", symphonyTemplateProvider.deserializeTemplate(is));
    int actualReadResult = is.read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link SymphonyTemplateProvider#applyTemplate(String, WorkResponse)} with {@code String},
   * {@code WorkResponse}.
   *
   * <p>Method under test: {@link SymphonyTemplateProvider#applyTemplate(String, WorkResponse)}
   */
  @Test
  @DisplayName("Test applyTemplate(String, WorkResponse) with 'String', 'WorkResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyTemplateProvider.applyTemplate(String, WorkResponse)"})
  void testApplyTemplateWithStringWorkResponse() {
    // Arrange and Act
    String actualApplyTemplateResult =
        symphonyTemplateProvider.applyTemplate(
            "Template", new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    assertEquals("Template", actualApplyTemplateResult);
  }
}
