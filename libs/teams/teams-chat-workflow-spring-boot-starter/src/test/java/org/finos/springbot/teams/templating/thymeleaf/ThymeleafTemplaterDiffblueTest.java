package org.finos.springbot.teams.templating.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import org.finos.springbot.workflow.templating.BeanConverter;
import org.finos.springbot.workflow.templating.BooleanConverter;
import org.finos.springbot.workflow.templating.Mode;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.junit.jupiter.api.Test;

class ThymeleafTemplaterDiffblueTest {
  /**
   * Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  void testConvert() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplater thymeleafTemplater = new ThymeleafTemplater(fieldConverters, new ThymeleafRendering());
    Class<Object> c = Object.class;

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> thymeleafTemplater.convert(c, Mode.FORM));
  }

  /**
   * Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  void testConvert2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplater thymeleafTemplater = new ThymeleafTemplater(fieldConverters, new ThymeleafRendering());
    Class<Object> c = Object.class;

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> thymeleafTemplater.convert(c, Mode.DISPLAY_WITH_BUTTONS));
  }

  /**
   * Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  void testConvert3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(new BeanConverter<>(new ThymeleafRendering()));
    ThymeleafTemplater thymeleafTemplater = new ThymeleafTemplater(fieldConverters, new ThymeleafRendering());
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals("<div xmlns:th=\"http://www.thymeleaf.org\"><table></table></div>",
        thymeleafTemplater.convert(c, Mode.DISPLAY));
  }

  /**
   * Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  void testConvert4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafRendering r = new ThymeleafRendering();
    Class<Object> forNameResult = Object.class;
    fieldConverters.add(new BooleanConverter<>(1, r, forNameResult));
    ThymeleafTemplater thymeleafTemplater = new ThymeleafTemplater(fieldConverters, new ThymeleafRendering());
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals(
        "<div xmlns:th=\"http://www.thymeleaf.org\"><span th:text=\"${form ? 'Y' : 'N'}\">boolean</span></div>",
        thymeleafTemplater.convert(c, Mode.DISPLAY));
  }
}
