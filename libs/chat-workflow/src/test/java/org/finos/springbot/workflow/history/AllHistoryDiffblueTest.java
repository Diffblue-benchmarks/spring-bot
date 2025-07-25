package org.finos.springbot.workflow.history;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import org.finos.springbot.workflow.content.Addressable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AllHistory.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class AllHistoryDiffblueTest {
  @Autowired private AllHistory allHistory;

  /**
   * Test {@link AllHistory#getLastFromHistory(Class, Addressable)} with {@code Class}, {@code
   * Addressable}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getLastFromHistory(Class, Addressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, Addressable) with 'Class', 'Addressable'; when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional AllHistory.getLastFromHistory(Class, Addressable)"})
  void testGetLastFromHistoryWithClassAddressable_whenJavaLangObject() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(allHistory.getLastFromHistory(type, mock(Addressable.class)).isPresent());
  }

  /**
   * Test {@link AllHistory#getLastFromHistory(Class, Addressable)} with {@code Class}, {@code
   * Addressable}.
   *
   * <ul>
   *   <li>When {@code List}.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getLastFromHistory(Class, Addressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, Addressable) with 'Class', 'Addressable'; when 'java.util.List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional AllHistory.getLastFromHistory(Class, Addressable)"})
  void testGetLastFromHistoryWithClassAddressable_whenJavaUtilList() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertFalse(allHistory.getLastFromHistory(type, mock(Addressable.class)).isPresent());
  }

  /**
   * Test {@link AllHistory#getLastFromHistory(Class, String, Addressable)} with {@code Class},
   * {@code String}, {@code Addressable}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getLastFromHistory(Class, String, Addressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, String, Addressable) with 'Class', 'String', 'Addressable'; when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Optional AllHistory.getLastFromHistory(Class, String, Addressable)"
  })
  void testGetLastFromHistoryWithClassStringAddressable_whenJavaLangObject() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(allHistory.getLastFromHistory(type, "foo", mock(Addressable.class)).isPresent());
  }

  /**
   * Test {@link AllHistory#getLastFromHistory(Class, String, Addressable)} with {@code Class},
   * {@code String}, {@code Addressable}.
   *
   * <ul>
   *   <li>When {@code List}.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getLastFromHistory(Class, String, Addressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, String, Addressable) with 'Class', 'String', 'Addressable'; when 'java.util.List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Optional AllHistory.getLastFromHistory(Class, String, Addressable)"
  })
  void testGetLastFromHistoryWithClassStringAddressable_whenJavaUtilList() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertFalse(allHistory.getLastFromHistory(type, "foo", mock(Addressable.class)).isPresent());
  }

  /**
   * Test {@link AllHistory#getFromHistory(Class, Addressable, Instant)} with {@code Class}, {@code
   * Addressable}, {@code Instant}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getFromHistory(Class, Addressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, Addressable, Instant) with 'Class', 'Addressable', 'Instant'; when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllHistory.getFromHistory(Class, Addressable, Instant)"})
  void testGetFromHistoryWithClassAddressableInstant_whenJavaLangObject() {
    // Arrange
    Class<Object> type = Object.class;
    Addressable address = mock(Addressable.class);

    // Act and Assert
    assertTrue(
        allHistory
            .getFromHistory(
                type,
                address,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .isEmpty());
  }

  /**
   * Test {@link AllHistory#getFromHistory(Class, Addressable, Instant)} with {@code Class}, {@code
   * Addressable}, {@code Instant}.
   *
   * <ul>
   *   <li>When {@code List}.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getFromHistory(Class, Addressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, Addressable, Instant) with 'Class', 'Addressable', 'Instant'; when 'java.util.List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllHistory.getFromHistory(Class, Addressable, Instant)"})
  void testGetFromHistoryWithClassAddressableInstant_whenJavaUtilList() {
    // Arrange
    Class<List> type = List.class;
    Addressable address = mock(Addressable.class);

    // Act and Assert
    assertTrue(
        allHistory
            .getFromHistory(
                type,
                address,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .isEmpty());
  }

  /**
   * Test {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)} with {@code Class},
   * {@code String}, {@code Addressable}, {@code Instant}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, String, Addressable, Instant) with 'Class', 'String', 'Addressable', 'Instant'; when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllHistory.getFromHistory(Class, String, Addressable, Instant)"})
  void testGetFromHistoryWithClassStringAddressableInstant_whenJavaLangObject() {
    // Arrange
    Class<Object> type = Object.class;
    Addressable address = mock(Addressable.class);

    // Act and Assert
    assertTrue(
        allHistory
            .getFromHistory(
                type,
                "foo",
                address,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .isEmpty());
  }

  /**
   * Test {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)} with {@code Class},
   * {@code String}, {@code Addressable}, {@code Instant}.
   *
   * <ul>
   *   <li>When {@code List}.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, String, Addressable, Instant) with 'Class', 'String', 'Addressable', 'Instant'; when 'java.util.List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllHistory.getFromHistory(Class, String, Addressable, Instant)"})
  void testGetFromHistoryWithClassStringAddressableInstant_whenJavaUtilList() {
    // Arrange
    Class<List> type = List.class;
    Addressable address = mock(Addressable.class);

    // Act and Assert
    assertTrue(
        allHistory
            .getFromHistory(
                type,
                "foo",
                address,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .isEmpty());
  }
}
