package org.finos.springbot.teams.form;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TeamsFormConverter.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class TeamsFormConverterDiffblueTest {
  @MockitoBean private ObjectMapper objectMapper;

  @Autowired private TeamsFormConverter teamsFormConverter;

  /**
   * Test {@link TeamsFormConverter#TeamsFormConverter(ObjectMapper)}.
   *
   * <p>Method under test: {@link TeamsFormConverter#TeamsFormConverter(ObjectMapper)}
   */
  @Test
  @DisplayName("Test new TeamsFormConverter(ObjectMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TeamsFormConverter.<init>(ObjectMapper)"})
  void testNewTeamsFormConverter() {
    // Arrange, Act and Assert
    assertSame(objectMapper, new TeamsFormConverter(objectMapper).getObjectMapper());
  }
}
