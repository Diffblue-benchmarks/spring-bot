package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractTypeConverterDiffblueTest {
  /**
   * Test {@link AbstractTypeConverter#getPriority()}.
   * <p>
   * Method under test: {@link AbstractTypeConverter#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int org.finos.springbot.workflow.templating.AbstractTypeConverter.getPriority()"})
  void testGetPriority() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(mock(Rendering.class));

    // Act and Assert
    assertEquals(AbstractTypeConverter.BOTTOM_PRIORITY, beanConverter.getPriority());
  }
}
