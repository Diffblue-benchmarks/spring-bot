package org.finos.springbot.workflow.actions.consumers;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Supplier;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.SimpleMessageAction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InRoomAddressingCheckerDiffblueTest {
  /**
   * Test {@link InRoomAddressingChecker#InRoomAddressingChecker(Supplier, boolean)}.
   * <p>
   * Method under test: {@link InRoomAddressingChecker#InRoomAddressingChecker(Supplier, boolean)}
   */
  @Test
  @DisplayName("Test new InRoomAddressingChecker(Supplier, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.actions.consumers.InRoomAddressingChecker.<init>(java.util.function.Supplier, boolean)"})
  void testNewInRoomAddressingChecker() {
    // Arrange, Act and Assert
    assertTrue((new InRoomAddressingChecker(mock(Supplier.class), true)).allowSlash);
  }

  /**
   * Test {@link InRoomAddressingChecker#filter(Action)}.
   * <ul>
   *   <li>Given {@link InRoomAddressingChecker#InRoomAddressingChecker(Supplier, boolean)} with theBot is {@link Supplier} and allowSlash is {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InRoomAddressingChecker#filter(Action)}
   */
  @Test
  @DisplayName("Test filter(Action); given InRoomAddressingChecker(Supplier, boolean) with theBot is Supplier and allowSlash is 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.Action org.finos.springbot.workflow.actions.consumers.InRoomAddressingChecker.filter(org.finos.springbot.workflow.actions.Action)"})
  void testFilter_givenInRoomAddressingCheckerWithTheBotIsSupplierAndAllowSlashIsFalse() {
    // Arrange
    Supplier<User> theBot = mock(Supplier.class);
    when(theBot.get()).thenReturn(mock(User.class));
    InRoomAddressingChecker inRoomAddressingChecker = new InRoomAddressingChecker(theBot, false);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);

    // Act
    Action actualFilterResult = inRoomAddressingChecker
        .filter(new SimpleMessageAction(a, u, new MessageImpl(new ArrayList<>()), "Ej"));

    // Assert
    verify(theBot).get();
    assertNull(actualFilterResult);
  }

  /**
   * Test {@link InRoomAddressingChecker#filter(Action)}.
   * <ul>
   *   <li>When {@link Message.MessageImpl#MessageImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InRoomAddressingChecker#filter(Action)}
   */
  @Test
  @DisplayName("Test filter(Action); when MessageImpl(List) with c is ArrayList(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.Action org.finos.springbot.workflow.actions.consumers.InRoomAddressingChecker.filter(org.finos.springbot.workflow.actions.Action)"})
  void testFilter_whenMessageImplWithCIsArrayList_thenReturnNull() {
    // Arrange
    Supplier<User> theBot = mock(Supplier.class);
    when(theBot.get()).thenReturn(mock(User.class));
    InRoomAddressingChecker inRoomAddressingChecker = new InRoomAddressingChecker(theBot, true);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);

    // Act
    Action actualFilterResult = inRoomAddressingChecker
        .filter(new SimpleMessageAction(a, u, new MessageImpl(new ArrayList<>()), "Ej"));

    // Assert
    verify(theBot).get();
    assertNull(actualFilterResult);
  }

  /**
   * Test {@link InRoomAddressingChecker#filter(Action)}.
   * <ul>
   *   <li>When {@link Action#NULL_ACTION}.</li>
   *   <li>Then return {@link Action#NULL_ACTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InRoomAddressingChecker#filter(Action)}
   */
  @Test
  @DisplayName("Test filter(Action); when NULL_ACTION; then return NULL_ACTION")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.Action org.finos.springbot.workflow.actions.consumers.InRoomAddressingChecker.filter(org.finos.springbot.workflow.actions.Action)"})
  void testFilter_whenNull_action_thenReturnNull_action() {
    // Arrange
    Action a = Action.NULL_ACTION;

    // Act and Assert
    assertSame(a, (new InRoomAddressingChecker(mock(Supplier.class), true)).filter(a));
  }
}
