package org.finos.springbot.workflow.tags;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {HeaderTagResponseHandler.class})
@ExtendWith(SpringExtension.class)
class HeaderTagResponseHandlerDiffblueTest {
  @Autowired
  private HeaderTagResponseHandler headerTagResponseHandler;

  /**
   * Method under test: {@link HeaderTagResponseHandler#apply(Response)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertNull(headerTagResponseHandler.apply(new MessageResponse(null, "Not all who wander are lost")));
  }

  /**
   * Method under test: {@link HeaderTagResponseHandler#apply(Response)}
   */
  @Test
  void testApply2() {
    // Arrange
    ErrorResponse t = new ErrorResponse(null, new Throwable());

    // Act
    Void actualApplyResult = headerTagResponseHandler.apply(t);

    // Assert
    Map<String, Object> data = t.getData();
    assertEquals(3, data.size());
    Object getResult = data.get(HeaderDetails.KEY);
    assertTrue(getResult instanceof HeaderDetails);
    assertNull(((HeaderDetails) getResult).getDescription());
    assertNull(((HeaderDetails) getResult).getName());
    assertNull(actualApplyResult);
    assertTrue(((HeaderDetails) getResult).getTags().isEmpty());
    assertTrue(data.containsKey("error"));
    assertTrue(data.containsKey("message"));
  }

  /**
   * Method under test: {@link HeaderTagResponseHandler#getOrder()}
   */
  @Test
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(100, headerTagResponseHandler.getOrder());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link HeaderTagResponseHandler}
   */
  @Test
  void testNewHeaderTagResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(100, (new HeaderTagResponseHandler()).getOrder());
  }
}
