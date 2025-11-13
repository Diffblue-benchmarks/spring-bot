package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.SynthesizingMethodParameter;

class NullWorkflowResolverDiffblueTest {
  /**
   * Test {@link NullWorkflowResolver#canResolve(MethodParameter)}.
   *
   * <ul>
   *   <li>When {@link SynthesizingMethodParameter}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NullWorkflowResolver#canResolve(MethodParameter)}
   */
  @Test
  @DisplayName(
      "Test canResolve(MethodParameter); when SynthesizingMethodParameter; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NullWorkflowResolver.canResolve(MethodParameter)"})
  void testCanResolve_whenSynthesizingMethodParameter_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new NullWorkflowResolver().canResolve(mock(SynthesizingMethodParameter.class)));
  }

  /**
   * Test {@link NullWorkflowResolver#resolve(MethodParameter)}.
   *
   * <ul>
   *   <li>When {@link SynthesizingMethodParameter}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link NullWorkflowResolver#resolve(MethodParameter)}
   */
  @Test
  @DisplayName(
      "Test resolve(MethodParameter); when SynthesizingMethodParameter; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional NullWorkflowResolver.resolve(MethodParameter)"})
  void testResolve_whenSynthesizingMethodParameter_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(
        new NullWorkflowResolver().resolve(mock(SynthesizingMethodParameter.class)).isPresent());
  }
}
