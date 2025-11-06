package org.finos.springbot.tool.rssbot.feed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class FeedControllerDiffblueTest {
  /**
   * Method under test: {@link FeedController#newSubscribeRequest()}
   */
  @Test
  void testNewSubscribeRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SubscribeRequest actualNewSubscribeRequestResult = (new FeedController()).newSubscribeRequest();

    // Assert
    assertNull(actualNewSubscribeRequestResult.getName());
    assertNull(actualNewSubscribeRequestResult.getUrl());
  }

  /**
   * Method under test: {@link FeedController#createFilterForm()}
   */
  @Test
  void testCreateFilterForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Filter actualCreateFilterFormResult = (new FeedController()).createFilterForm();

    // Assert
    assertNull(actualCreateFilterFormResult.getToMatch());
    assertEquals(Filter.Type.EXCLUDE, actualCreateFilterFormResult.getUsage());
  }
}
