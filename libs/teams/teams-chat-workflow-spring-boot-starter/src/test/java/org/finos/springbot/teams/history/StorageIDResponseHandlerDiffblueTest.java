package org.finos.springbot.teams.history;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.finos.springbot.teams.content.TeamsChannel;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.Test;

class StorageIDResponseHandlerDiffblueTest {
  /**
   * Method under test: {@link StorageIDResponseHandler#apply(Response)}
   */
  @Test
  void testApply() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    StorageIDResponseHandler storageIDResponseHandler = new StorageIDResponseHandler(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertNull(storageIDResponseHandler
        .apply(new MessageResponse(new TeamsChannel("42", "Name"), "Not all who wander are lost")));
  }

  /**
   * Method under test: {@link StorageIDResponseHandler#apply(Response)}
   */
  @Test
  void testApply2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    StorageIDResponseHandler storageIDResponseHandler = new StorageIDResponseHandler(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    TeamsChannel stream = new TeamsChannel("42", "Name");

    // Act and Assert
    assertNull(storageIDResponseHandler.apply(new ErrorResponse(stream, new Throwable())));
  }

  /**
   * Method under test: {@link StorageIDResponseHandler#apply(Response)}
   */
  @Test
  void testApply3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    StorageIDResponseHandler storageIDResponseHandler = new StorageIDResponseHandler(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertNull(storageIDResponseHandler.apply(new WorkResponse(new TeamsChannel("42", "Name"), "42", WorkMode.BOTH)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link StorageIDResponseHandler#StorageIDResponseHandler(TeamsStateStorage)}
   *   <li>{@link StorageIDResponseHandler#getOrder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertEquals(Integer.MIN_VALUE,
        (new StorageIDResponseHandler(new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()))))
            .getOrder());
  }
}
