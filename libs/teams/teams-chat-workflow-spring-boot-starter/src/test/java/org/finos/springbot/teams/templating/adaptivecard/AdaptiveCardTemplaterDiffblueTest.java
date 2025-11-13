package org.finos.springbot.teams.templating.adaptivecard;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.templating.Mode;
import org.finos.springbot.workflow.templating.Rendering;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AdaptiveCardTemplater.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class AdaptiveCardTemplaterDiffblueTest {
  @Autowired private AdaptiveCardTemplater adaptiveCardTemplater;

  @Autowired private List<TypeConverter<JsonNode>> list;

  @MockitoBean private Rendering<JsonNode> rendering;

  @MockitoBean private TypeConverter<JsonNode> typeConverter;

  /**
   * Test {@link AdaptiveCardTemplater#AdaptiveCardTemplater(List, Rendering)}.
   *
   * <ul>
   *   <li>Then calls {@link TypeConverter#getPriority()}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCardTemplater#AdaptiveCardTemplater(List, Rendering)}
   */
  @Test
  @DisplayName("Test new AdaptiveCardTemplater(List, Rendering); then calls getPriority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then calls {@link TypeConverter#getPriority()}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCardTemplater#AdaptiveCardTemplater(List, Rendering)}
   */
  @Test
  @DisplayName("Test new AdaptiveCardTemplater(List, Rendering); then calls getPriority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

  /**
   * Test {@link AdaptiveCardTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCardTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName("Test convert(Class, Mode); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AdaptiveCardTemplater.convert(Class, Mode)"})
  void testConvert_thenThrowUnsupportedOperationException() {
    // Arrange
    when(typeConverter.canConvert(Mockito.<Field>any(), Mockito.<Type>any())).thenReturn(false);
    Class<Object> c = Object.class;

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> adaptiveCardTemplater.convert(c, Mode.DISPLAY));
    verify(typeConverter).canConvert(isNull(), isA(Type.class));
  }
}
