package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserConverterDiffblueTest {
  /**
   * Test {@link UserConverter#UserConverter(int, Rendering, Class[])}.
   *
   * <p>Method under test: {@link UserConverter#UserConverter(int, Rendering, Class[])}
   */
  @Test
  @DisplayName("Test new UserConverter(int, Rendering, Class[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserConverter.<init>(int, Rendering, Class[])"})
  void testNewUserConverter() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    Class<Object> forNameResult = Object.class;

    // Act
    UserConverter<Object> actualUserConverter = new UserConverter<>(1, r, forNameResult);

    // Assert
    assertEquals(1, actualUserConverter.getPriority());
  }

  /**
   * Test {@link UserConverter#apply(Field, Type, boolean, Variable)} with {@code ctx}, {@code t},
   * {@code editMode}, {@code v}.
   *
   * <ul>
   *   <li>Then return {@code Render User Dropdown}.
   * </ul>
   *
   * <p>Method under test: {@link UserConverter#apply(Field, Type, boolean, Variable)}
   */
  @Test
  @DisplayName(
      "Test apply(Field, Type, boolean, Variable) with 'ctx', 't', 'editMode', 'v'; then return 'Render User Dropdown'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object UserConverter.apply(Field, Type, boolean, Variable)"})
  void testApplyWithCtxTEditModeV_thenReturnRenderUserDropdown() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    when(r.renderUserDropdown(
            Mockito.<Variable>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean()))
        .thenReturn("Render User Dropdown");
    Class<Object> forNameResult = Object.class;

    UserConverter<Object> userConverter = new UserConverter<>(1, r, forNameResult);

    // Act
    Object actualApplyResult =
        userConverter.apply(null, new TypePlaceHolder(1), true, mock(Variable.class));

    // Assert
    verify(r)
        .renderUserDropdown(
            isA(Variable.class), eq("userlist.contents"), eq("key"), eq("name"), eq(true));
    assertEquals("Render User Dropdown", actualApplyResult);
  }

  /**
   * Test {@link UserConverter#apply(Field, Type, boolean, Variable)} with {@code ctx}, {@code t},
   * {@code editMode}, {@code v}.
   *
   * <ul>
   *   <li>Then return {@code User Display}.
   * </ul>
   *
   * <p>Method under test: {@link UserConverter#apply(Field, Type, boolean, Variable)}
   */
  @Test
  @DisplayName(
      "Test apply(Field, Type, boolean, Variable) with 'ctx', 't', 'editMode', 'v'; then return 'User Display'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object UserConverter.apply(Field, Type, boolean, Variable)"})
  void testApplyWithCtxTEditModeV_thenReturnUserDisplay() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    when(r.userDisplay(Mockito.<Variable>any())).thenReturn("User Display");
    Class<Object> forNameResult = Object.class;

    UserConverter<Object> userConverter = new UserConverter<>(1, r, forNameResult);

    // Act
    Object actualApplyResult =
        userConverter.apply(null, new TypePlaceHolder(1), false, mock(Variable.class));

    // Assert
    verify(r).userDisplay(isA(Variable.class));
    assertEquals("User Display", actualApplyResult);
  }

  /**
   * Test {@link UserConverter#getLocation(Field)}.
   *
   * <p>Method under test: {@link UserConverter#getLocation(Field)}
   */
  @Test
  @DisplayName("Test getLocation(Field)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UserConverter.getLocation(Field)"})
  void testGetLocation() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    Class<Object> forNameResult = Object.class;

    UserConverter<Object> userConverter = new UserConverter<>(1, r, forNameResult);

    // Act and Assert
    assertEquals("userlist.contents", userConverter.getLocation(null));
  }
}
