package org.finos.springbot.workflow.actions.consumers;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Supplier;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.ErrorAction;
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
   *
   * <p>Method under test: {@link InRoomAddressingChecker#InRoomAddressingChecker(Supplier,
   * boolean)}
   */
  @Test
  @DisplayName("Test new InRoomAddressingChecker(Supplier, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InRoomAddressingChecker.<init>(Supplier, boolean)"})
  void testNewInRoomAddressingChecker() {
    // Arrange, Act and Assert
    assertTrue(new InRoomAddressingChecker(mock(Supplier.class), true).allowSlash);
  }

  /**
   * Test {@link InRoomAddressingChecker#filter(Action)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InRoomAddressingChecker#filter(Action)}
   */
  @Test
  @DisplayName("Test filter(Action); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Action InRoomAddressingChecker.filter(Action)"})
  void testFilter_thenReturnNull() {
    // Arrange
    Supplier<User> theBot = mock(Supplier.class);
    when(theBot.get()).thenReturn(mock(User.class));
    InRoomAddressingChecker inRoomAddressingChecker = new InRoomAddressingChecker(theBot, false);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);

    SimpleMessageAction a2 =
        new SimpleMessageAction(a, u, new MessageImpl(new ArrayList<>()), "Ej");

    // Act
    Action actualFilterResult = inRoomAddressingChecker.filter(a2);

    // Assert
    verify(theBot).get();
    assertNull(actualFilterResult);
  }

  /**
   * Test {@link InRoomAddressingChecker#filter(Action)}.
   *
   * <ul>
   *   <li>When {@link ErrorAction#ErrorAction(Addressable, Object)} with a is {@link User} and
   *       {@code Ej}.
   *   <li>Then return {@link ErrorAction#ErrorAction(Addressable, Object)} with a is {@link User}
   *       and {@code Ej}.
   * </ul>
   *
   * <p>Method under test: {@link InRoomAddressingChecker#filter(Action)}
   */
  @Test
  @DisplayName(
      "Test filter(Action); when ErrorAction(Addressable, Object) with a is User and 'Ej'; then return ErrorAction(Addressable, Object) with a is User and 'Ej'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Action InRoomAddressingChecker.filter(Action)"})
  void testFilter_whenErrorActionWithAIsUserAndEj_thenReturnErrorActionWithAIsUserAndEj() {
    // Arrange
    InRoomAddressingChecker inRoomAddressingChecker =
        new InRoomAddressingChecker(mock(Supplier.class), false);
    ErrorAction a = new ErrorAction(mock(User.class), "Ej");

    // Act
    Action actualFilterResult = inRoomAddressingChecker.filter(a);

    // Assert
    assertSame(a, actualFilterResult);
  }

  /**
   * Test {@link InRoomAddressingChecker#filter(Action)}.
   *
   * <ul>
   *   <li>When {@link Message.MessageImpl#MessageImpl(List)} with c is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InRoomAddressingChecker#filter(Action)}
   */
  @Test
  @DisplayName(
      "Test filter(Action); when MessageImpl(List) with c is ArrayList(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Action InRoomAddressingChecker.filter(Action)"})
  void testFilter_whenMessageImplWithCIsArrayList_thenReturnNull() {
    // Arrange
    Supplier<User> theBot = mock(Supplier.class);
    when(theBot.get()).thenReturn(mock(User.class));
    InRoomAddressingChecker inRoomAddressingChecker = new InRoomAddressingChecker(theBot, true);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);

    SimpleMessageAction a2 =
        new SimpleMessageAction(a, u, new MessageImpl(new ArrayList<>()), "Ej");

    // Act
    Action actualFilterResult = inRoomAddressingChecker.filter(a2);

    // Assert
    verify(theBot).get();
    assertNull(actualFilterResult);
  }

  /**
   * Test {@link InRoomAddressingChecker#filter(Action)}.
   *
   * <ul>
   *   <li>When {@link Action#NULL_ACTION}.
   *   <li>Then return {@link Action#NULL_ACTION}.
   * </ul>
   *
   * <p>Method under test: {@link InRoomAddressingChecker#filter(Action)}
   */
  @Test
  @DisplayName("Test filter(Action); when NULL_ACTION; then return NULL_ACTION")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Action InRoomAddressingChecker.filter(Action)"})
  void testFilter_whenNull_action_thenReturnNull_action() {
    // Arrange
    Action a = Action.NULL_ACTION;

    // Act
    Action actualFilterResult = new InRoomAddressingChecker(mock(Supplier.class), true).filter(a);

    // Assert
    assertSame(a, actualFilterResult);
  }
}
