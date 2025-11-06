package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Type;
import java.util.Optional;
import org.aspectj.internal.lang.reflect.AjTypeImpl;
import org.junit.jupiter.api.Test;

class AbstractClassWorkflowResolverDiffblueTest {
  /**
   * Method under test: {@link AbstractClassWorkflowResolver#isOptional(Type)}
   */
  @Test
  void testIsOptional() {
    // Arrange, Act and Assert
    assertFalse(AbstractClassWorkflowResolver.isOptional(new TypePlaceHolder(1)));
  }

  /**
   * Method under test: {@link AbstractClassWorkflowResolver#isOptional(Type)}
   */
  @Test
  void testIsOptional2() {
    // Arrange
    Class<Optional> fromClass = Optional.class;

    // Act and Assert
    assertTrue(AbstractClassWorkflowResolver.isOptional(new AjTypeImpl<>(fromClass)));
  }
}
