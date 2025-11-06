package org.finos.springbot.teams.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.springbot.teams.content.TeamsChannel;
import org.finos.springbot.teams.content.serialization.TeamsMarkupWriter;
import org.finos.springbot.workflow.response.MessageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.io.ApplicationResourceLoader;

class EntityMarkupTemplateProviderDiffblueTest {
  /**
   * Method under test:
   * {@link EntityMarkupTemplateProvider#toMarkup(String, MarkupAndEntities)}
   */
  @Test
  void testToMarkup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    EntityMarkupTemplateProvider entityMarkupTemplateProvider = new EntityMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl, new TeamsMarkupWriter());

    // Act
    MarkupAndEntities actualToMarkupResult = entityMarkupTemplateProvider.toMarkup("foo",
        new MarkupAndEntities("Not all who wander are lost"));

    // Assert
    assertEquals("foo", actualToMarkupResult.getContents());
    assertTrue(actualToMarkupResult.getEntities().isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityMarkupTemplateProvider#createContext(MessageResponse)}
   */
  @Test
  void testCreateContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    EntityMarkupTemplateProvider entityMarkupTemplateProvider = new EntityMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl, new TeamsMarkupWriter());

    // Act
    MarkupAndEntities actualCreateContextResult = entityMarkupTemplateProvider
        .createContext(new MessageResponse(new TeamsChannel("42", "Name"), "Not all who wander are lost"));

    // Assert
    assertNull(actualCreateContextResult.getContents());
    assertTrue(actualCreateContextResult.getEntities().isEmpty());
  }
}
