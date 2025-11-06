package org.finos.springbot.symphony.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.finos.springbot.workflow.templating.BeanConverter;
import org.finos.springbot.workflow.templating.BooleanConverter;
import org.finos.springbot.workflow.templating.Mode;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.junit.jupiter.api.Test;

class FreemarkerWorkTemplaterDiffblueTest {
  /**
   * Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  void testConvert() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(new BeanConverter<>(new FreemarkerRendering()));
    FreemarkerWorkTemplater freemarkerWorkTemplater = new FreemarkerWorkTemplater(fieldConverters,
        new FreemarkerRendering());
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals("\n<#-- starting template --><table></table>\n<#-- ending template -->\n",
        freemarkerWorkTemplater.convert(c, Mode.DISPLAY));
  }

  /**
   * Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  void testConvert2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    FreemarkerRendering r = new FreemarkerRendering();
    Class<Object> forNameResult = Object.class;
    fieldConverters.add(new BooleanConverter<>(1, r, forNameResult));
    FreemarkerWorkTemplater freemarkerWorkTemplater = new FreemarkerWorkTemplater(fieldConverters,
        new FreemarkerRendering());
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals("\n<#-- starting template -->${(entity.form)?string(\"Y\", \"N\")}\n<#-- ending template -->\n",
        freemarkerWorkTemplater.convert(c, Mode.DISPLAY));
  }

  /**
   * Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  void testConvert3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(new BeanConverter<>(new FreemarkerRendering()));
    FreemarkerWorkTemplater freemarkerWorkTemplater = new FreemarkerWorkTemplater(fieldConverters,
        new FreemarkerRendering());
    Class<String> c = String.class;

    // Act and Assert
    assertEquals("\n"
        + "<#-- starting template --><table><tr><td style=\"width: 200px\"><b>Value:</b></td><td><table></table></td></tr>"
        + "\n" + "<tr><td style=\"width: 200px\"><b>Coder:</b></td><td><table></table></td></tr>\n"
        + "<tr><td style=\"width: 200px\"><b>Hash:</b></td><td><table></table></td></tr>\n"
        + "<tr><td style=\"width: 200px\"><b>Hash Is Zero:</b></td><td><table></table></td></tr></table>\n"
        + "<#-- ending template -->\n", freemarkerWorkTemplater.convert(c, Mode.DISPLAY));
  }

  /**
   * Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  void testConvert4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(new BeanConverter<>(new FreemarkerRendering()));
    FreemarkerWorkTemplater freemarkerWorkTemplater = new FreemarkerWorkTemplater(fieldConverters,
        new FreemarkerRendering());
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals("\n" + "<#-- starting template --><table></table>\n" + "<form id=\"just-buttons-form\">\n"
        + "  <p><#list entity.buttons.contents as button>\n" + "    <button \n" + "         name=\"${button.name}\"\n"
        + "         type=\"${button.buttonType?lower_case}\">\n" + "      ${button.text}\n" + "    </button>\n"
        + "  </#list></p>\n" + "</form>\n" + "<#-- ending template -->\n",
        freemarkerWorkTemplater.convert(c, Mode.DISPLAY_WITH_BUTTONS));
  }

  /**
   * Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  void testConvert5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(new BeanConverter<>(new FreemarkerRendering()));
    FreemarkerWorkTemplater freemarkerWorkTemplater = new FreemarkerWorkTemplater(fieldConverters,
        new FreemarkerRendering());
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals("\n" + "<#-- starting template -->\n" + "<form id=\"java.lang.Object\"><table></table>\n"
        + "  <p><#list entity.buttons.contents as button>\n" + "    <button \n" + "         name=\"${button.name}\"\n"
        + "         type=\"${button.buttonType?lower_case}\">\n" + "      ${button.text}\n" + "    </button>\n"
        + "  </#list></p>\n" + "</form>\n" + "<#-- ending template -->\n",
        freemarkerWorkTemplater.convert(c, Mode.FORM));
  }

  /**
   * Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  void testConvert6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    FreemarkerRendering r = new FreemarkerRendering();
    Class<Object> forNameResult = Object.class;
    fieldConverters.add(new BooleanConverter<>(1, r, forNameResult));
    FreemarkerWorkTemplater freemarkerWorkTemplater = new FreemarkerWorkTemplater(fieldConverters,
        new FreemarkerRendering());
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals(
        "\n" + "<#-- starting template -->\n" + "<form id=\"java.lang.Object\">\n"
            + " <span class=\"tempo-text-color--red\">${entity.errors.contents['entity.form']!''}</span>\n"
            + " <checkbox \n" + "  name=\"entity.form\"\n" + "  checked=\"${entity.form?string('true', 'false')}\"\n"
            + "  value=\"true\">entity.form</checkbox>\n" + "  <p><#list entity.buttons.contents as button>\n"
            + "    <button \n" + "         name=\"${button.name}\"\n"
            + "         type=\"${button.buttonType?lower_case}\">\n" + "      ${button.text}\n" + "    </button>\n"
            + "  </#list></p>\n" + "</form>\n" + "<#-- ending template -->\n",
        freemarkerWorkTemplater.convert(c, Mode.FORM));
  }
}
