package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;

class NullWorkflowResolverDiffblueTest {
  /**
   * Method under test: {@link NullWorkflowResolver#canResolve(MethodParameter)}
   */
  @Test
  void testCanResolve() {
    // Arrange, Act and Assert
    assertFalse((new NullWorkflowResolver()).canResolve(null));
  }

  /**
   * Method under test: {@link NullWorkflowResolver#resolve(MethodParameter)}
   */
  @Test
  void testResolve() {
    // Arrange, Act and Assert
    assertFalse((new NullWorkflowResolver()).resolve(null).isPresent());
  }
}
