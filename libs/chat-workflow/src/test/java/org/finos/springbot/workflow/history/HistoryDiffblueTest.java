package org.finos.springbot.workflow.history;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AllHistory.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class HistoryDiffblueTest {
  @Autowired
  private History<Addressable> history;

  /**
   * Test {@link History#getLastFromHistory(Class, Tag, Addressable)} with {@code Class}, {@code Tag}, {@code Addressable}.
   * <p>
   * Method under test: {@link History#getLastFromHistory(Class, Tag, Addressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, Tag, Addressable) with 'Class', 'Tag', 'Addressable'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional History.getLastFromHistory(Class, Tag, Addressable)"})
  void testGetLastFromHistoryWithClassTagAddressable() {
    // Arrange
    Class<Object> type = Object.class;
    Tag t = mock(Tag.class);
    when(t.getName()).thenReturn("Name");

    // Act
    Optional<Object> actualLastFromHistory = history.getLastFromHistory(type, t, mock(Addressable.class));

    // Assert
    verify(t).getName();
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link History#getFromHistory(Class, Tag, Addressable, Instant)} with {@code Class}, {@code Tag}, {@code Addressable}, {@code Instant}.
   * <p>
   * Method under test: {@link History#getFromHistory(Class, Tag, Addressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, Tag, Addressable, Instant) with 'Class', 'Tag', 'Addressable', 'Instant'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List History.getFromHistory(Class, Tag, Addressable, Instant)"})
  void testGetFromHistoryWithClassTagAddressableInstant() {
    // Arrange
    Class<Object> type = Object.class;
    Tag t = mock(Tag.class);
    when(t.getName()).thenReturn("Name");
    Addressable addressable = mock(Addressable.class);

    // Act
    List<Object> actualFromHistory = history.getFromHistory(type, t, addressable,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(t).getName();
    assertTrue(actualFromHistory.isEmpty());
  }
}
