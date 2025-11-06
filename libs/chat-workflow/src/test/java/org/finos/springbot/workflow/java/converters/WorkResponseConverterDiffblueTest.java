package org.finos.springbot.workflow.java.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;

class WorkResponseConverterDiffblueTest {
  /**
   * Method under test: {@link WorkResponseConverter#canConvert(Object)}
   */
  @Test
  void testCanConvert() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new WorkResponseConverter(null)).canConvert("In"));
    assertFalse((new WorkResponseConverter(null)).canConvert(null));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WorkResponseConverter#WorkResponseConverter(ResponseHandlers)}
   *   <li>{@link WorkResponseConverter#getOrder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new WorkResponseConverter(null)).getOrder());
  }
}
