package org.finos.springbot.workflow.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.content.Addressable;
import org.junit.jupiter.api.Test;

class DataResponseDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataResponse#DataResponse(Addressable, Map, String)}
   *   <li>{@link DataResponse#toString()}
   *   <li>{@link DataResponse#getAddress()}
   *   <li>{@link DataResponse#getData()}
   *   <li>{@link DataResponse#getTemplateName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();

    // Act
    DataResponse actualDataResponse = new DataResponse(null, data, "Template Name");
    String actualToStringResult = actualDataResponse.toString();
    Addressable actualAddress = actualDataResponse.getAddress();
    Map<String, Object> actualData = actualDataResponse.getData();

    // Assert
    assertEquals("DataResponse [data={}, template=Template Name]", actualToStringResult);
    assertEquals("Template Name", actualDataResponse.getTemplateName());
    assertNull(actualAddress);
    assertTrue(actualData.isEmpty());
    assertSame(data, actualData);
  }
}
