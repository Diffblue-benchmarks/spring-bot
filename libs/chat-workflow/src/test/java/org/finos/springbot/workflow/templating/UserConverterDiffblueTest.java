package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

class UserConverterDiffblueTest {
  /**
   * Method under test: {@link UserConverter#getLocation(Field)}
   */
  @Test
  void testGetLocation() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    UserConverter<Object> userConverter = new UserConverter<>(1, null, forNameResult);

    // Act and Assert
    assertEquals("userlist.contents", userConverter.getLocation(null));
  }

  /**
   * Method under test:
   * {@link UserConverter#UserConverter(int, Rendering, Class[])}
   */
  @Test
  void testNewUserConverter() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    UserConverter<Object> actualUserConverter = new UserConverter<>(1, null, forNameResult);

    // Assert
    assertEquals(1, actualUserConverter.getPriority());
  }
}
