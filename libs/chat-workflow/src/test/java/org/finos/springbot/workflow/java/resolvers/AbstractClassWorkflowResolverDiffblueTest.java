package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Type;
import java.util.Optional;
import org.aspectj.internal.lang.reflect.AjTypeImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractClassWorkflowResolverDiffblueTest {
  /**
   * Test {@link AbstractClassWorkflowResolver#isOptional(Type)}.
   *
   * <ul>
   *   <li>When {@code Optional}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractClassWorkflowResolver#isOptional(Type)}
   */
  @Test
  @DisplayName("Test isOptional(Type); when 'java.util.Optional'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractClassWorkflowResolver.isOptional(Type)"})
  void testIsOptional_whenJavaUtilOptional_thenReturnTrue() {
    // Arrange
    Class<Optional> fromClass = Optional.class;

    // Act and Assert
    assertTrue(AbstractClassWorkflowResolver.isOptional(new AjTypeImpl<>(fromClass)));
  }

  /**
   * Test {@link AbstractClassWorkflowResolver#isOptional(Type)}.
   *
   * <ul>
   *   <li>When {@link TypePlaceHolder#TypePlaceHolder(int)} with ordinal is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractClassWorkflowResolver#isOptional(Type)}
   */
  @Test
  @DisplayName(
      "Test isOptional(Type); when TypePlaceHolder(int) with ordinal is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractClassWorkflowResolver.isOptional(Type)"})
  void testIsOptional_whenTypePlaceHolderWithOrdinalIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AbstractClassWorkflowResolver.isOptional(new TypePlaceHolder(1)));
  }
}
