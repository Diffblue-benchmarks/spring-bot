package org.finos.springbot.workflow.history;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
   * <p>Method under test: {@link AllHistory#getLastFromHistory(Class, Addressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, Addressable) with 'Class', 'Addressable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional AllHistory.getLastFromHistory(Class, Addressable)"})
  void testGetLastFromHistoryWithClassAddressable() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory allHistory = new AllHistory();
    allHistory.setApplicationContext(applicationContext);
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> allHistory.getLastFromHistory(type, mock(Addressable.class)));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link AllHistory#getLastFromHistory(Class, Addressable)} with {@code Class}, {@code
   * Addressable}.
   *
   * <ul>
   *   <li>Given {@link AllHistory}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getLastFromHistory(Class, Addressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, Addressable) with 'Class', 'Addressable'; given AllHistory; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional AllHistory.getLastFromHistory(Class, Addressable)"})
  void testGetLastFromHistoryWithClassAddressable_givenAllHistory_thenReturnNotPresent() {
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
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getLastFromHistory(Class, Addressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, Addressable) with 'Class', 'Addressable'; when 'java.util.List'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional AllHistory.getLastFromHistory(Class, Addressable)"})
  void testGetLastFromHistoryWithClassAddressable_whenJavaUtilList_thenReturnNotPresent() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertFalse(allHistory.getLastFromHistory(type, mock(Addressable.class)).isPresent());
  }

  /**
   * Test {@link AllHistory#getLastFromHistory(Class, String, Addressable)} with {@code Class},
   * {@code String}, {@code Addressable}.
   *
   * <p>Method under test: {@link AllHistory#getLastFromHistory(Class, String, Addressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, String, Addressable) with 'Class', 'String', 'Addressable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Optional AllHistory.getLastFromHistory(Class, String, Addressable)"
  })
  void testGetLastFromHistoryWithClassStringAddressable() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory allHistory = new AllHistory();
    allHistory.setApplicationContext(applicationContext);
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> allHistory.getLastFromHistory(type, "foo", mock(Addressable.class)));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link AllHistory#getLastFromHistory(Class, String, Addressable)} with {@code Class},
   * {@code String}, {@code Addressable}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getLastFromHistory(Class, String, Addressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, String, Addressable) with 'Class', 'String', 'Addressable'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Optional AllHistory.getLastFromHistory(Class, String, Addressable)"
  })
  void testGetLastFromHistoryWithClassStringAddressable_thenReturnNotPresent() {
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
   * <p>Method under test: {@link AllHistory#getFromHistory(Class, Addressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, Addressable, Instant) with 'Class', 'Addressable', 'Instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllHistory.getFromHistory(Class, Addressable, Instant)"})
  void testGetFromHistoryWithClassAddressableInstant() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory allHistory = new AllHistory();
    allHistory.setApplicationContext(applicationContext);
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () ->
            allHistory.getFromHistory(
                type,
                mock(Addressable.class),
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link AllHistory#getFromHistory(Class, Addressable, Instant)} with {@code Class}, {@code
   * Addressable}, {@code Instant}.
   *
   * <ul>
   *   <li>Given {@link AllHistory}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getFromHistory(Class, Addressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, Addressable, Instant) with 'Class', 'Addressable', 'Instant'; given AllHistory; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllHistory.getFromHistory(Class, Addressable, Instant)"})
  void testGetFromHistoryWithClassAddressableInstant_givenAllHistory_thenReturnEmpty() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(
        allHistory
            .getFromHistory(
                type,
                mock(Addressable.class),
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .isEmpty());
  }

  /**
   * Test {@link AllHistory#getFromHistory(Class, Addressable, Instant)} with {@code Class}, {@code
   * Addressable}, {@code Instant}.
   *
   * <ul>
   *   <li>When {@code List}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getFromHistory(Class, Addressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, Addressable, Instant) with 'Class', 'Addressable', 'Instant'; when 'java.util.List'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllHistory.getFromHistory(Class, Addressable, Instant)"})
  void testGetFromHistoryWithClassAddressableInstant_whenJavaUtilList_thenReturnEmpty() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertTrue(
        allHistory
            .getFromHistory(
                type,
                mock(Addressable.class),
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .isEmpty());
  }

  /**
   * Test {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)} with {@code Class},
   * {@code String}, {@code Addressable}, {@code Instant}.
   *
   * <p>Method under test: {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, String, Addressable, Instant) with 'Class', 'String', 'Addressable', 'Instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllHistory.getFromHistory(Class, String, Addressable, Instant)"})
  void testGetFromHistoryWithClassStringAddressableInstant() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory allHistory = new AllHistory();
    allHistory.setApplicationContext(applicationContext);
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () ->
            allHistory.getFromHistory(
                type,
                "foo",
                mock(Addressable.class),
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)} with {@code Class},
   * {@code String}, {@code Addressable}, {@code Instant}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, String, Addressable, Instant) with 'Class', 'String', 'Addressable', 'Instant'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllHistory.getFromHistory(Class, String, Addressable, Instant)"})
  void testGetFromHistoryWithClassStringAddressableInstant_thenReturnEmpty() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(
        allHistory
            .getFromHistory(
                type,
                "foo",
                mock(Addressable.class),
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

    // Act and Assert
    assertTrue(
        allHistory
            .getFromHistory(
                type,
                "foo",
                mock(Addressable.class),
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .isEmpty());
  }
}
