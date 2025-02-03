package org.finos.springbot.workflow.history;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
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
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AllHistory.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class AllHistoryDiffblueTest {
  @Autowired
  private AllHistory allHistory;

  /**
   * Test {@link AllHistory#getLastFromHistory(Class, Addressable)} with {@code Class}, {@code Addressable}.
   * <ul>
   *   <li>Given {@link AllHistory}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllHistory#getLastFromHistory(Class, Addressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, Addressable) with 'Class', 'Addressable'; given AllHistory; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.workflow.history.AllHistory.getLastFromHistory(java.lang.Class, org.finos.springbot.workflow.content.Addressable)"})
  void testGetLastFromHistoryWithClassAddressable_givenAllHistory_thenReturnNotPresent() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(allHistory.getLastFromHistory(type, mock(Addressable.class)).isPresent());
  }

  /**
   * Test {@link AllHistory#getLastFromHistory(Class, Addressable)} with {@code Class}, {@code Addressable}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllHistory#getLastFromHistory(Class, Addressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, Addressable) with 'Class', 'Addressable'; given 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.workflow.history.AllHistory.getLastFromHistory(java.lang.Class, org.finos.springbot.workflow.content.Addressable)"})
  void testGetLastFromHistoryWithClassAddressable_givenJavaLangObject() throws BeansException {
    // Arrange
    AllHistory allHistory2 = new AllHistory();
    Class<Object> forNameResult = Object.class;
    allHistory2.setApplicationContext(new AnnotationConfigApplicationContext(forNameResult));
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(allHistory2.getLastFromHistory(type, mock(Addressable.class)).isPresent());
  }

  /**
   * Test {@link AllHistory#getLastFromHistory(Class, String, Addressable)} with {@code Class}, {@code String}, {@code Addressable}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllHistory#getLastFromHistory(Class, String, Addressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, String, Addressable) with 'Class', 'String', 'Addressable'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.workflow.history.AllHistory.getLastFromHistory(java.lang.Class, java.lang.String, org.finos.springbot.workflow.content.Addressable)"})
  void testGetLastFromHistoryWithClassStringAddressable_thenReturnNotPresent() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(allHistory.getLastFromHistory(type, "foo", mock(Addressable.class)).isPresent());
  }

  /**
   * Test {@link AllHistory#getLastFromHistory(Class, String, Addressable)} with {@code Class}, {@code String}, {@code Addressable}.
   * <ul>
   *   <li>When {@code List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllHistory#getLastFromHistory(Class, String, Addressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, String, Addressable) with 'Class', 'String', 'Addressable'; when 'java.util.List'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.workflow.history.AllHistory.getLastFromHistory(java.lang.Class, java.lang.String, org.finos.springbot.workflow.content.Addressable)"})
  void testGetLastFromHistoryWithClassStringAddressable_whenJavaUtilList() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertFalse(allHistory.getLastFromHistory(type, "foo", mock(Addressable.class)).isPresent());
  }

  /**
   * Test {@link AllHistory#getFromHistory(Class, Addressable, Instant)} with {@code Class}, {@code Addressable}, {@code Instant}.
   * <ul>
   *   <li>Given {@link AllHistory}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllHistory#getFromHistory(Class, Addressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, Addressable, Instant) with 'Class', 'Addressable', 'Instant'; given AllHistory; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.workflow.history.AllHistory.getFromHistory(java.lang.Class, org.finos.springbot.workflow.content.Addressable, java.time.Instant)"})
  void testGetFromHistoryWithClassAddressableInstant_givenAllHistory_thenReturnEmpty() {
    // Arrange
    Class<Object> type = Object.class;
    Addressable address = mock(Addressable.class);

    // Act and Assert
    assertTrue(allHistory
        .getFromHistory(type, address, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .isEmpty());
  }

  /**
   * Test {@link AllHistory#getFromHistory(Class, Addressable, Instant)} with {@code Class}, {@code Addressable}, {@code Instant}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllHistory#getFromHistory(Class, Addressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, Addressable, Instant) with 'Class', 'Addressable', 'Instant'; given 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.workflow.history.AllHistory.getFromHistory(java.lang.Class, org.finos.springbot.workflow.content.Addressable, java.time.Instant)"})
  void testGetFromHistoryWithClassAddressableInstant_givenJavaLangObject() throws BeansException {
    // Arrange
    AllHistory allHistory2 = new AllHistory();
    Class<Object> forNameResult = Object.class;
    allHistory2.setApplicationContext(new AnnotationConfigApplicationContext(forNameResult));
    Class<Object> type = Object.class;
    Addressable address = mock(Addressable.class);

    // Act and Assert
    assertTrue(allHistory2
        .getFromHistory(type, address, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .isEmpty());
  }

  /**
   * Test {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)} with {@code Class}, {@code String}, {@code Addressable}, {@code Instant}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, String, Addressable, Instant) with 'Class', 'String', 'Addressable', 'Instant'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.workflow.history.AllHistory.getFromHistory(java.lang.Class, java.lang.String, org.finos.springbot.workflow.content.Addressable, java.time.Instant)"})
  void testGetFromHistoryWithClassStringAddressableInstant_thenReturnEmpty() {
    // Arrange
    Class<Object> type = Object.class;
    Addressable address = mock(Addressable.class);

    // Act and Assert
    assertTrue(
        allHistory
            .getFromHistory(type, "foo", address,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .isEmpty());
  }

  /**
   * Test {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)} with {@code Class}, {@code String}, {@code Addressable}, {@code Instant}.
   * <ul>
   *   <li>When {@code List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, String, Addressable, Instant) with 'Class', 'String', 'Addressable', 'Instant'; when 'java.util.List'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.workflow.history.AllHistory.getFromHistory(java.lang.Class, java.lang.String, org.finos.springbot.workflow.content.Addressable, java.time.Instant)"})
  void testGetFromHistoryWithClassStringAddressableInstant_whenJavaUtilList() {
    // Arrange
    Class<List> type = List.class;
    Addressable address = mock(Addressable.class);

    // Act and Assert
    assertTrue(
        allHistory
            .getFromHistory(type, "foo", address,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .isEmpty());
  }
}
