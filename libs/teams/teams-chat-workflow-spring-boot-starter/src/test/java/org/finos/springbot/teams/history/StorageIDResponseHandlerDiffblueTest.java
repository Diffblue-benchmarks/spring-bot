package org.finos.springbot.teams.history;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StorageIDResponseHandler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class StorageIDResponseHandlerDiffblueTest {
  @Autowired private StorageIDResponseHandler storageIDResponseHandler;

  @MockitoBean private TeamsStateStorage teamsStateStorage;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StorageIDResponseHandler#StorageIDResponseHandler(TeamsStateStorage)}
   *   <li>{@link StorageIDResponseHandler#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StorageIDResponseHandler.<init>(TeamsStateStorage)",
    "int StorageIDResponseHandler.getOrder()"
  })
  void testGettersAndSetters() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals(
        Integer.MIN_VALUE, new StorageIDResponseHandler(new MemoryStateStorage(ejc)).getOrder());
  }

  /**
   * Test {@link StorageIDResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link StorageIDResponseHandler#STORAGE_ID_KEY} is {@code
   *       Data}.
   * </ul>
   *
   * <p>Method under test: {@link StorageIDResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; given HashMap() STORAGE_ID_KEY is 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StorageIDResponseHandler.apply(Response)"})
  void testApplyWithResponse_givenHashMapStorage_id_keyIsData() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(StorageIDResponseHandler.STORAGE_ID_KEY, "Data");
    stringObjectMap.put(StorageIDResponseHandler.STORAGE_ID_KEY, "Data");

    ErrorResponse t = mock(ErrorResponse.class);
    when(t.getData()).thenReturn(stringObjectMap);

    // Act
    String actualApplyResult = storageIDResponseHandler.apply(t);

    // Assert
    verify(t).getData();
    assertNull(actualApplyResult);
  }

  /**
   * Test {@link StorageIDResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ErrorResponse} {@link ErrorResponse#getData()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StorageIDResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName(
      "Test apply(Response) with 'Response'; given 'null'; when ErrorResponse getData() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StorageIDResponseHandler.apply(Response)"})
  void testApplyWithResponse_givenNull_whenErrorResponseGetDataReturnNull() {
    // Arrange
    ErrorResponse t = mock(ErrorResponse.class);
    when(t.getData()).thenReturn(null);

    // Act
    String actualApplyResult = storageIDResponseHandler.apply(t);

    // Assert
    verify(t).getData();
    assertNull(actualApplyResult);
  }

  /**
   * Test {@link StorageIDResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>When {@link ErrorResponse#ErrorResponse(Addressable, Throwable)} with stream is {@link
   *       Addressable} and e is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link StorageIDResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName(
      "Test apply(Response) with 'Response'; when ErrorResponse(Addressable, Throwable) with stream is Addressable and e is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StorageIDResponseHandler.apply(Response)"})
  void testApplyWithResponse_whenErrorResponseWithStreamIsAddressableAndEIsThrowable() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    ErrorResponse t = new ErrorResponse(stream, new Throwable());

    // Act and Assert
    assertNull(storageIDResponseHandler.apply(t));
  }

  /**
   * Test {@link StorageIDResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>When {@link Response}.
   * </ul>
   *
   * <p>Method under test: {@link StorageIDResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; when Response")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StorageIDResponseHandler.apply(Response)"})
  void testApplyWithResponse_whenResponse() {
    // Arrange, Act and Assert
    assertNull(storageIDResponseHandler.apply(mock(Response.class)));
  }

  /**
   * Test {@link StorageIDResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>When {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)} with to is {@link
   *       Addressable} and o is {@code 42} and m is {@code BOTH}.
   * </ul>
   *
   * <p>Method under test: {@link StorageIDResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName(
      "Test apply(Response) with 'Response'; when WorkResponse(Addressable, Object, WorkMode) with to is Addressable and o is '42' and m is 'BOTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StorageIDResponseHandler.apply(Response)"})
  void testApplyWithResponse_whenWorkResponseWithToIsAddressableAndOIs42AndMIsBoth() {
    // Arrange, Act and Assert
    assertNull(
        storageIDResponseHandler.apply(
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH)));
  }
}
