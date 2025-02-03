package org.finos.springbot.teams.messages;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.schema.ChannelAccount;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.teams.content.serialization.TeamsHTMLParser;
import org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations;
import org.finos.springbot.teams.conversations.TeamsConversations;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.workflow.actions.consumers.ActionConsumer;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.finos.springbot.workflow.form.FormConverter;
import org.finos.springbot.workflow.form.FormValidationProcessor;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

class FileActivityHandlerDiffblueTest {
  /**
   * Test {@link FileActivityHandler#FileActivityHandler(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)}.
   * <p>
   * Method under test: {@link FileActivityHandler#FileActivityHandler(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)}
   */
  @Test
  @DisplayName("Test new FileActivityHandler(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.messages.FileActivityHandler.<init>(java.util.List, org.finos.springbot.teams.conversations.TeamsConversations, org.finos.springbot.teams.state.TeamsStateStorage, org.finos.springbot.teams.content.serialization.TeamsHTMLParser, org.finos.springbot.workflow.form.FormConverter, org.finos.springbot.workflow.form.FormValidationProcessor)"})
  void testNewFileActivityHandler() {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations teamsConversations = new StateStorageBasedTeamsConversations(bfa, mac,
        botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om2, new ArrayList<>()));
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormConverter formConverter = new FormConverter(JsonMapper.builder().findAndAddModules().build());

    // Act
    FileActivityHandler actualFileActivityHandler = new FileActivityHandler(messageConsumers, teamsConversations,
        teamsStateStorage, parser, formConverter,
        new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class)));

    // Assert
    assertTrue(actualFileActivityHandler.formConverter.getObjectMapper() instanceof JsonMapper);
    assertTrue(actualFileActivityHandler.messageConsumers.isEmpty());
  }
}
