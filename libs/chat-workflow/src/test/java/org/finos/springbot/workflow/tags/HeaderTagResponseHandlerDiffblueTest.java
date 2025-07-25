package org.finos.springbot.workflow.tags;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {HeaderTagResponseHandler.class})
@ExtendWith(SpringExtension.class)
class HeaderTagResponseHandlerDiffblueTest {
  @Autowired private HeaderTagResponseHandler headerTagResponseHandler;

  /**
   * Test {@link HeaderTagResponseHandler#apply(Response)} with {@code Response}.
   *
   * <p>Method under test: {@link HeaderTagResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void HeaderTagResponseHandler.apply(Response)"})
  void testApplyWithResponse() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    ErrorResponse t = new ErrorResponse(stream, new Throwable());

    // Act
    headerTagResponseHandler.apply(t);

    // Assert
    Map<String, Object> data = t.getData();
    assertEquals(3, data.size());
    Object getResult = data.get(HeaderDetails.KEY);
    assertTrue(getResult instanceof HeaderDetails);
    assertNull(((HeaderDetails) getResult).getDescription());
    assertNull(((HeaderDetails) getResult).getName());
    assertTrue(((HeaderDetails) getResult).getTags().isEmpty());
    assertTrue(data.containsKey("error"));
    assertTrue(data.containsKey("message"));
  }

  /**
   * Test {@link HeaderTagResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link HeaderDetails#KEY} is {@link
   *       HeaderDetails#HeaderDetails()}.
   *   <li>Then calls {@link ErrorResponse#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link HeaderTagResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName(
      "Test apply(Response) with 'Response'; given HashMap() KEY is HeaderDetails(); then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void HeaderTagResponseHandler.apply(Response)"})
  void testApplyWithResponse_givenHashMapKeyIsHeaderDetails_thenCallsGetData() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(HeaderDetails.KEY, new HeaderDetails());
    ErrorResponse t = mock(ErrorResponse.class);
    when(t.getData()).thenReturn(stringObjectMap);

    // Act
    Void actualApplyResult = headerTagResponseHandler.apply(t);

    // Assert
    verify(t, atLeast(1)).getData();
    assertNull(actualApplyResult);
  }

  /**
   * Test {@link HeaderTagResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>When {@link Response}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HeaderTagResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; when Response; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Void HeaderTagResponseHandler.apply(Response)"})
  void testApplyWithResponse_whenResponse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(headerTagResponseHandler.apply(mock(Response.class)));
  }

  /**
   * Test {@link HeaderTagResponseHandler#getOrder()}.
   *
   * <p>Method under test: {@link HeaderTagResponseHandler#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HeaderTagResponseHandler.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(100, headerTagResponseHandler.getOrder());
  }

  /**
   * Test new {@link HeaderTagResponseHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link HeaderTagResponseHandler}
   */
  @Test
  @DisplayName("Test new HeaderTagResponseHandler (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HeaderTagResponseHandler.<init>()"})
  void testNewHeaderTagResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(100, new HeaderTagResponseHandler().getOrder());
  }
}
