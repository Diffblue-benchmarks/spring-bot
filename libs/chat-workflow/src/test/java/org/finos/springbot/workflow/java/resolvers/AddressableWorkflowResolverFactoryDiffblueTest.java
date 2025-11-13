package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AddressableWorkflowResolverFactory.class})
@ExtendWith(SpringExtension.class)
class AddressableWorkflowResolverFactoryDiffblueTest {
  @Autowired private AddressableWorkflowResolverFactory addressableWorkflowResolverFactory;

  /**
   * Test {@link AddressableWorkflowResolverFactory#getOrder()}.
   *
   * <p>Method under test: {@link AddressableWorkflowResolverFactory#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AddressableWorkflowResolverFactory.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(
        WorkflowResolverFactory.NORMAL_PRIORITY, addressableWorkflowResolverFactory.getOrder());
  }

  /**
   * Test new {@link AddressableWorkflowResolverFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AddressableWorkflowResolverFactory}
   */
  @Test
  @DisplayName("Test new AddressableWorkflowResolverFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddressableWorkflowResolverFactory.<init>()"})
  void testNewAddressableWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(
        WorkflowResolverFactory.NORMAL_PRIORITY,
        new AddressableWorkflowResolverFactory().getOrder());
  }
}
