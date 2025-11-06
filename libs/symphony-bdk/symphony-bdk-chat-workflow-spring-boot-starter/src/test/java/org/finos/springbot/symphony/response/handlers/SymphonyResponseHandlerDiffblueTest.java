package org.finos.springbot.symphony.response.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.symphony.bdk.core.retry.RetryWithRecoveryBuilder;
import com.symphony.bdk.core.service.session.SessionService;
import com.symphony.bdk.core.service.stream.StreamService;
import com.symphony.bdk.core.service.user.UserService;
import com.symphony.bdk.gen.api.AuditTrailApi;
import com.symphony.bdk.gen.api.RoomMembershipApi;
import com.symphony.bdk.gen.api.SessionApi;
import com.symphony.bdk.gen.api.ShareApi;
import com.symphony.bdk.gen.api.StreamsApi;
import com.symphony.bdk.gen.api.UserApi;
import com.symphony.bdk.gen.api.UsersApi;
import java.util.ArrayList;
import java.util.HashMap;
import org.finos.springbot.symphony.SymphonyException;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.serialization.SymphonyMarkupWriter;
import org.finos.springbot.symphony.conversations.SymphonyConversationsImpl;
import org.finos.springbot.symphony.response.templating.SymphonyMarkupTemplateProvider;
import org.finos.springbot.symphony.templating.FreemarkerRendering;
import org.finos.springbot.symphony.templating.FreemarkerWorkTemplater;
import org.finos.springbot.symphony.templating.SymphonyTemplateProvider;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.finos.springbot.workflow.response.DataResponse;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.io.ApplicationResourceLoader;

class SymphonyResponseHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  void testBuildTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter dataHandler = new EntityJsonConverter(om, new ArrayList<>());

    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    SymphonyMarkupTemplateProvider messageTemplater = new SymphonyMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl, new SymphonyMarkupWriter());

    ApplicationResourceLoader rl2 = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    SymphonyTemplateProvider workTemplater = new SymphonyTemplateProvider("Template Prefix", "Template Suffix",
        "Default Template Name", rl2, new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering()));

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyResponseHandler symphonyResponseHandler = new SymphonyResponseHandler(null, dataHandler, messageTemplater,
        workTemplater, new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));
    SymphonyRoom resultTo = new SymphonyRoom("Name", "42");

    // Act and Assert
    assertThrows(SymphonyException.class,
        () -> symphonyResponseHandler.buildTemplate(new DataResponse(resultTo, new HashMap<>(), "Template Name")));
  }

  /**
   * Method under test:
   * {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  void testBuildTemplate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter dataHandler = new EntityJsonConverter(om, new ArrayList<>());

    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    SymphonyMarkupTemplateProvider messageTemplater = new SymphonyMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl, new SymphonyMarkupWriter());

    ApplicationResourceLoader rl2 = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    SymphonyTemplateProvider workTemplater = new SymphonyTemplateProvider("Template Prefix", "Template Suffix",
        "Default Template Name", rl2, new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering()));

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyResponseHandler symphonyResponseHandler = new SymphonyResponseHandler(null, dataHandler, messageTemplater,
        workTemplater, new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    // Act and Assert
    assertEquals("", symphonyResponseHandler
        .buildTemplate(new MessageResponse(new SymphonyRoom("Name", "42"), "Not all who wander are lost")));
  }
}
