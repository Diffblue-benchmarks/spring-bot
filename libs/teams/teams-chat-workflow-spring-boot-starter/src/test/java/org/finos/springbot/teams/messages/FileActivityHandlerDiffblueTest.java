package org.finos.springbot.teams.messages;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

class FileActivityHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link FileActivityHandler#FileActivityHandler(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)}
   */
  @Test
  void testNewFileActivityHandler() {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations teamsConversations = new StateStorageBasedTeamsConversations(bfa, mac,
        botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    ObjectMapper om2 = new ObjectMapper();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om2, new ArrayList<>()));
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    ObjectMapper om3 = new ObjectMapper();
    FormConverter formConverter = new FormConverter(om3);

    // Act
    FileActivityHandler actualFileActivityHandler = new FileActivityHandler(messageConsumers, teamsConversations,
        teamsStateStorage, parser, formConverter, new FormValidationProcessor(new CustomValidatorBean(), null));

    // Assert
    assertTrue(actualFileActivityHandler.messageConsumers.isEmpty());
    assertSame(om3, actualFileActivityHandler.formConverter.getObjectMapper());
  }
}
