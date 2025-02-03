package org.finos.springbot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MeterRegistryConfig.class})
@ExtendWith(SpringExtension.class)
class MeterRegistryConfigDiffblueTest {
  @Autowired
  private MeterRegistryConfig meterRegistryConfig;

  /**
   * Test {@link MeterRegistryConfig#countedAspect(MeterRegistry)}.
   * <p>
   * Method under test: {@link MeterRegistryConfig#countedAspect(MeterRegistry)}
   */
  @Test
  @DisplayName("Test countedAspect(MeterRegistry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "io.micrometer.core.aop.CountedAspect org.finos.springbot.MeterRegistryConfig.countedAspect(io.micrometer.core.instrument.MeterRegistry)"})
  void testCountedAspect() {
    // Arrange and Act
    CountedAspect actualCountedAspectResult = meterRegistryConfig.countedAspect(new CompositeMeterRegistry());

    // Assert
    assertEquals("failure", actualCountedAspectResult.RESULT_TAG_FAILURE_VALUE);
    assertEquals("none", actualCountedAspectResult.DEFAULT_EXCEPTION_TAG_VALUE);
    assertEquals("success", actualCountedAspectResult.RESULT_TAG_SUCCESS_VALUE);
  }
}
