package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;

class NullWorkflowResolverDiffblueTest {
  /**
   * Test {@link NullWorkflowResolver#canResolve(MethodParameter)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullWorkflowResolver#canResolve(MethodParameter)}
   */
  @Test
  @DisplayName("Test canResolve(MethodParameter); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.java.resolvers.NullWorkflowResolver.canResolve(org.springframework.core.MethodParameter)"})
  void testCanResolve_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new NullWorkflowResolver()).canResolve(null));
  }

  /**
   * Test {@link NullWorkflowResolver#resolve(MethodParameter)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullWorkflowResolver#resolve(MethodParameter)}
   */
  @Test
  @DisplayName("Test resolve(MethodParameter); when 'null'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.workflow.java.resolvers.NullWorkflowResolver.resolve(org.springframework.core.MethodParameter)"})
  void testResolve_whenNull_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse((new NullWorkflowResolver()).resolve(null).isPresent());
  }
}
