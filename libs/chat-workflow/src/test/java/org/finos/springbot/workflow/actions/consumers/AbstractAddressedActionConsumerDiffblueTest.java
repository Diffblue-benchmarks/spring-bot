package org.finos.springbot.workflow.actions.consumers;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.java.mapping.ChatHandlerMapping;
import org.finos.springbot.workflow.java.mapping.ChatHandlerMappingActionConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ErrorHandler;

@ContextConfiguration(classes = {ChatHandlerMappingActionConsumer.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AbstractAddressedActionConsumerDiffblueTest {
  @Autowired
  private AbstractAddressedActionConsumer abstractAddressedActionConsumer;

  @MockBean
  private AddressingChecker addressingChecker;

  @MockBean
  private ChatHandlerMapping<Object> chatHandlerMapping;

  @MockBean
  private ErrorHandler errorHandler;

  @Autowired
  private List<ChatHandlerMapping<Object>> list;

  @Autowired
  private List<AddressingChecker> list2;

  /**
   * Test {@link AbstractAddressedActionConsumer#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Given {@link AddressingChecker} {@link AddressingChecker#filter(Action)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAddressedActionConsumer#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; given AddressingChecker filter(Action) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.actions.consumers.AbstractAddressedActionConsumer.accept(org.finos.springbot.workflow.actions.Action)"})
  void testAcceptWithAction_givenAddressingCheckerFilterReturnNull() {
    // Arrange
    when(addressingChecker.filter(Mockito.<Action>any())).thenReturn(null);

    // Act
    abstractAddressedActionConsumer.accept(Action.NULL_ACTION);

    // Assert
    verify(addressingChecker).filter(isA(Action.class));
  }

  /**
   * Test {@link AbstractAddressedActionConsumer#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Then calls {@link ChatHandlerMapping#getExecutors(Action)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAddressedActionConsumer#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; then calls getExecutors(Action)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.actions.consumers.AbstractAddressedActionConsumer.accept(org.finos.springbot.workflow.actions.Action)"})
  void testAcceptWithAction_thenCallsGetExecutors() {
    // Arrange
    when(chatHandlerMapping.getExecutors(Mockito.<Action>any())).thenReturn(new ArrayList<>());
    when(addressingChecker.filter(Mockito.<Action>any())).thenReturn(Action.NULL_ACTION);

    // Act
    abstractAddressedActionConsumer.accept(Action.NULL_ACTION);

    // Assert
    verify(addressingChecker).filter(isA(Action.class));
    verify(chatHandlerMapping).getExecutors(isA(Action.class));
  }

  /**
   * Test {@link AbstractAddressedActionConsumer#performFilters(Action)}.
   * <ul>
   *   <li>Given {@link AddressingChecker} {@link AddressingChecker#filter(Action)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAddressedActionConsumer#performFilters(Action)}
   */
  @Test
  @DisplayName("Test performFilters(Action); given AddressingChecker filter(Action) return 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.Action org.finos.springbot.workflow.actions.consumers.AbstractAddressedActionConsumer.performFilters(org.finos.springbot.workflow.actions.Action)"})
  void testPerformFilters_givenAddressingCheckerFilterReturnNull_thenReturnNull() {
    // Arrange
    when(addressingChecker.filter(Mockito.<Action>any())).thenReturn(null);

    // Act
    Action actualPerformFiltersResult = abstractAddressedActionConsumer.performFilters(Action.NULL_ACTION);

    // Assert
    verify(addressingChecker).filter(isA(Action.class));
    assertNull(actualPerformFiltersResult);
  }

  /**
   * Test {@link AbstractAddressedActionConsumer#performFilters(Action)}.
   * <ul>
   *   <li>Then return {@link Action#NULL_ACTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAddressedActionConsumer#performFilters(Action)}
   */
  @Test
  @DisplayName("Test performFilters(Action); then return NULL_ACTION")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.Action org.finos.springbot.workflow.actions.consumers.AbstractAddressedActionConsumer.performFilters(org.finos.springbot.workflow.actions.Action)"})
  void testPerformFilters_thenReturnNull_action() {
    // Arrange
    when(addressingChecker.filter(Mockito.<Action>any())).thenReturn(Action.NULL_ACTION);
    Action in = Action.NULL_ACTION;

    // Act
    Action actualPerformFiltersResult = abstractAddressedActionConsumer.performFilters(in);

    // Assert
    verify(addressingChecker).filter(isA(Action.class));
    assertSame(in, actualPerformFiltersResult);
  }

  /**
   * Test {@link AbstractAddressedActionConsumer#addressCheckingFilters(Action)}.
   * <ul>
   *   <li>Given {@link AddressingChecker} {@link AddressingChecker#filter(Action)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAddressedActionConsumer#addressCheckingFilters(Action)}
   */
  @Test
  @DisplayName("Test addressCheckingFilters(Action); given AddressingChecker filter(Action) return 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.Action org.finos.springbot.workflow.actions.consumers.AbstractAddressedActionConsumer.addressCheckingFilters(org.finos.springbot.workflow.actions.Action)"})
  void testAddressCheckingFilters_givenAddressingCheckerFilterReturnNull_thenReturnNull() {
    // Arrange
    when(addressingChecker.filter(Mockito.<Action>any())).thenReturn(null);

    // Act
    Action actualAddressCheckingFiltersResult = abstractAddressedActionConsumer
        .addressCheckingFilters(Action.NULL_ACTION);

    // Assert
    verify(addressingChecker).filter(isA(Action.class));
    assertNull(actualAddressCheckingFiltersResult);
  }

  /**
   * Test {@link AbstractAddressedActionConsumer#addressCheckingFilters(Action)}.
   * <ul>
   *   <li>Then return {@link Action#NULL_ACTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAddressedActionConsumer#addressCheckingFilters(Action)}
   */
  @Test
  @DisplayName("Test addressCheckingFilters(Action); then return NULL_ACTION")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.Action org.finos.springbot.workflow.actions.consumers.AbstractAddressedActionConsumer.addressCheckingFilters(org.finos.springbot.workflow.actions.Action)"})
  void testAddressCheckingFilters_thenReturnNull_action() {
    // Arrange
    when(addressingChecker.filter(Mockito.<Action>any())).thenReturn(Action.NULL_ACTION);
    Action in = Action.NULL_ACTION;

    // Act
    Action actualAddressCheckingFiltersResult = abstractAddressedActionConsumer.addressCheckingFilters(in);

    // Assert
    verify(addressingChecker).filter(isA(Action.class));
    assertSame(in, actualAddressCheckingFiltersResult);
  }
}
