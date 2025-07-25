package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityMapResolverFactoryDiffblueTest {
  /**
   * Test new {@link EntityMapResolverFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EntityMapResolverFactory}
   */
  @Test
  @DisplayName("Test new EntityMapResolverFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityMapResolverFactory.<init>()"})
  void testNewEntityMapResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(
        WorkflowResolverFactory.NORMAL_PRIORITY, new EntityMapResolverFactory().getOrder());
  }
}
