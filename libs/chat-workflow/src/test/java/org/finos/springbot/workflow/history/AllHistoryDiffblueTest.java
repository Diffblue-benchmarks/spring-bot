package org.finos.springbot.workflow.history;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import org.finos.springbot.workflow.content.Addressable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AllHistory.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AllHistoryDiffblueTest {
  @Autowired
  private AllHistory allHistory;

  /**
   * Method under test:
   * {@link AllHistory#getLastFromHistory(Class, String, Addressable)}
   */
  @Test
  void testGetLastFromHistory() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(allHistory.getLastFromHistory(type, "foo", null).isPresent());
  }

  /**
   * Method under test:
   * {@link AllHistory#getLastFromHistory(Class, String, Addressable)}
   */
  @Test
  void testGetLastFromHistory2() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertFalse(allHistory.getLastFromHistory(type, "foo", null).isPresent());
  }

  /**
   * Method under test: {@link AllHistory#getLastFromHistory(Class, Addressable)}
   */
  @Test
  void testGetLastFromHistory3() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(allHistory.getLastFromHistory(type, null).isPresent());
  }

  /**
   * Method under test: {@link AllHistory#getLastFromHistory(Class, Addressable)}
   */
  @Test
  void testGetLastFromHistory4() throws BeansException {
    // Arrange
    AllHistory allHistory2 = new AllHistory();
    Class<Object> forNameResult = Object.class;
    allHistory2.setApplicationContext(new AnnotationConfigApplicationContext(forNameResult));
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(allHistory2.getLastFromHistory(type, null).isPresent());
  }

  /**
   * Method under test:
   * {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)}
   */
  @Test
  void testGetFromHistory() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(allHistory
        .getFromHistory(type, "foo", null, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)}
   */
  @Test
  void testGetFromHistory2() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertTrue(allHistory
        .getFromHistory(type, "foo", null, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link AllHistory#getFromHistory(Class, Addressable, Instant)}
   */
  @Test
  void testGetFromHistory3() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(allHistory
        .getFromHistory(type, null, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link AllHistory#getFromHistory(Class, Addressable, Instant)}
   */
  @Test
  void testGetFromHistory4() throws BeansException {
    // Arrange
    AllHistory allHistory2 = new AllHistory();
    Class<Object> forNameResult = Object.class;
    allHistory2.setApplicationContext(new AnnotationConfigApplicationContext(forNameResult));
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(allHistory2
        .getFromHistory(type, null, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .isEmpty());
  }
}
