package org.finos.springbot.teams.history;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.ArrayList;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StorageIDResponseHandler.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class StorageIDResponseHandlerDiffblueTest {
  @Autowired
  private StorageIDResponseHandler storageIDResponseHandler;

  @MockBean
  private TeamsStateStorage teamsStateStorage;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StorageIDResponseHandler#StorageIDResponseHandler(TeamsStateStorage)}
   *   <li>{@link StorageIDResponseHandler#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StorageIDResponseHandler.<init>(TeamsStateStorage)",
      "int StorageIDResponseHandler.getOrder()"})
  void testGettersAndSetters() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertEquals(Integer.MIN_VALUE,
        (new StorageIDResponseHandler(new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()))))
            .getOrder());
  }

  /**
   * Test {@link StorageIDResponseHandler#apply(Response)} with {@code Response}.
   * <ul>
   *   <li>When {@link ErrorResponse#ErrorResponse(Addressable, Throwable)} with stream is {@link Addressable} and e is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIDResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; when ErrorResponse(Addressable, Throwable) with stream is Addressable and e is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String StorageIDResponseHandler.apply(Response)"})
  void testApplyWithResponse_whenErrorResponseWithStreamIsAddressableAndEIsThrowable() {
    // Arrange
    Addressable stream = mock(Addressable.class);

    // Act and Assert
    assertNull(storageIDResponseHandler.apply(new ErrorResponse(stream, new Throwable())));
  }

  /**
   * Test {@link StorageIDResponseHandler#apply(Response)} with {@code Response}.
   * <ul>
   *   <li>When {@link Response}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIDResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; when Response")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String StorageIDResponseHandler.apply(Response)"})
  void testApplyWithResponse_whenResponse() {
    // Arrange, Act and Assert
    assertNull(storageIDResponseHandler.apply(mock(Response.class)));
  }

  /**
   * Test {@link StorageIDResponseHandler#apply(Response)} with {@code Response}.
   * <ul>
   *   <li>When {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)} with to is {@link Addressable} and o is {@code 42} and m is {@code BOTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageIDResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; when WorkResponse(Addressable, Object, WorkMode) with to is Addressable and o is '42' and m is 'BOTH'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String StorageIDResponseHandler.apply(Response)"})
  void testApplyWithResponse_whenWorkResponseWithToIsAddressableAndOIs42AndMIsBoth() {
    // Arrange, Act and Assert
    assertNull(storageIDResponseHandler.apply(new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH)));
  }
}
