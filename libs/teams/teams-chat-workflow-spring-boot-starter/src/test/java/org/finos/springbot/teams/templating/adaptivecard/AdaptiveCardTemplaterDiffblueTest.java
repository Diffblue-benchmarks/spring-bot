package org.finos.springbot.teams.templating.adaptivecard;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.templating.Rendering;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AdaptiveCardTemplater.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AdaptiveCardTemplaterDiffblueTest {
  @Autowired
  private AdaptiveCardTemplater adaptiveCardTemplater;

  @Autowired
  private List<TypeConverter<JsonNode>> list;

  @MockBean
  private Rendering<JsonNode> rendering;

  @MockBean
  private TypeConverter<JsonNode> typeConverter;

  /**
   * Test {@link AdaptiveCardTemplater#AdaptiveCardTemplater(List, Rendering)}.
   * <ul>
   *   <li>Then calls {@link TypeConverter#getPriority()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdaptiveCardTemplater#AdaptiveCardTemplater(List, Rendering)}
   */
  @Test
  @DisplayName("Test new AdaptiveCardTemplater(List, Rendering); then calls getPriority()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdaptiveCardTemplater.<init>(List, Rendering)"})
  void testNewAdaptiveCardTemplater_thenCallsGetPriority() {
    // Arrange
    when(typeConverter.getPriority()).thenReturn(1);

    ArrayList<TypeConverter<JsonNode>> fieldConverters = new ArrayList<>();
    fieldConverters.add(typeConverter);
    fieldConverters.add(typeConverter);

    // Act
    new AdaptiveCardTemplater(fieldConverters, rendering);

    // Assert
    verify(typeConverter, atLeast(1)).getPriority();
  }

  /**
   * Test {@link AdaptiveCardTemplater#AdaptiveCardTemplater(List, Rendering)}.
   * <ul>
   *   <li>Then calls {@link TypeConverter#getPriority()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdaptiveCardTemplater#AdaptiveCardTemplater(List, Rendering)}
   */
  @Test
  @DisplayName("Test new AdaptiveCardTemplater(List, Rendering); then calls getPriority()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdaptiveCardTemplater.<init>(List, Rendering)"})
  void testNewAdaptiveCardTemplater_thenCallsGetPriority2() {
    // Arrange
    when(typeConverter.getPriority()).thenReturn(1);

    ArrayList<TypeConverter<JsonNode>> fieldConverters = new ArrayList<>();
    fieldConverters.add(typeConverter);
    fieldConverters.add(typeConverter);
    fieldConverters.add(typeConverter);

    // Act
    new AdaptiveCardTemplater(fieldConverters, rendering);

    // Assert
    verify(typeConverter, atLeast(1)).getPriority();
  }
}
