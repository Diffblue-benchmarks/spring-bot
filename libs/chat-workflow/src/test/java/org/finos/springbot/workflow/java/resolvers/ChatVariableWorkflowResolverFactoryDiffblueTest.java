package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChatVariableWorkflowResolverFactoryDiffblueTest {
  /**
   * Test new {@link ChatVariableWorkflowResolverFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ChatVariableWorkflowResolverFactory}
   */
  @Test
  @DisplayName("Test new ChatVariableWorkflowResolverFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChatVariableWorkflowResolverFactory.<init>()"})
  void testNewChatVariableWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(
        WorkflowResolverFactory.NORMAL_PRIORITY,
        new ChatVariableWorkflowResolverFactory().getOrder());
  }
}
