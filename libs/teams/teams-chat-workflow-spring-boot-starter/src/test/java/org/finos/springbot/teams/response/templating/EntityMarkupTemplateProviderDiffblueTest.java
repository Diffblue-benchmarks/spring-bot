package org.finos.springbot.teams.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.BiFunction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.response.MessageResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EntityMarkupTemplateProvider.class, String.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class EntityMarkupTemplateProviderDiffblueTest {
  @MockitoBean private BiFunction<Content, MarkupAndEntities, String> biFunction;

  @Autowired private EntityMarkupTemplateProvider entityMarkupTemplateProvider;

  /**
   * Test {@link EntityMarkupTemplateProvider#toMarkup(String, MarkupAndEntities)} with {@code
   * String}, {@code MarkupAndEntities}.
   *
   * <ul>
   *   <li>Then return Contents is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMarkupTemplateProvider#toMarkup(String, MarkupAndEntities)}
   */
  @Test
  @DisplayName(
      "Test toMarkup(String, MarkupAndEntities) with 'String', 'MarkupAndEntities'; then return Contents is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MarkupAndEntities EntityMarkupTemplateProvider.toMarkup(String, MarkupAndEntities)"
  })
  void testToMarkupWithStringMarkupAndEntities_thenReturnContentsIsFoo() {
    // Arrange and Act
    MarkupAndEntities actualToMarkupResult =
        entityMarkupTemplateProvider.toMarkup(
            "foo", new MarkupAndEntities("Not all who wander are lost"));

    // Assert
    assertEquals("foo", actualToMarkupResult.getContents());
    assertTrue(actualToMarkupResult.getEntities().isEmpty());
  }

  /**
   * Test {@link EntityMarkupTemplateProvider#createContext(MessageResponse)}.
   *
   * <p>Method under test: {@link EntityMarkupTemplateProvider#createContext(MessageResponse)}
   */
  @Test
  @DisplayName("Test createContext(MessageResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MarkupAndEntities EntityMarkupTemplateProvider.createContext(MessageResponse)"
  })
  void testCreateContext() {
    // Arrange and Act
    MarkupAndEntities actualCreateContextResult =
        entityMarkupTemplateProvider.createContext(
            new MessageResponse(mock(Addressable.class), "Not all who wander are lost"));

    // Assert
    assertNull(actualCreateContextResult.getContents());
    assertTrue(actualCreateContextResult.getEntities().isEmpty());
  }
}
