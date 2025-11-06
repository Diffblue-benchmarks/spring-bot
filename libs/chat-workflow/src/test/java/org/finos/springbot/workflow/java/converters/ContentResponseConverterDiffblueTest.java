package org.finos.springbot.workflow.java.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;

class ContentResponseConverterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ContentResponseConverter#ContentResponseConverter(ResponseHandlers)}
   *   <li>{@link ContentResponseConverter#getOrder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new ContentResponseConverter(null)).getOrder());
  }
}
