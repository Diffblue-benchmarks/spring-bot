package org.finos.springbot.workflow.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.content.Addressable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataResponseDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DataResponse.<init>(Addressable, Map, String)", "Addressable DataResponse.getAddress()",
      "Map DataResponse.getData()", "String DataResponse.getTemplateName()", "String DataResponse.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Addressable resultTo = mock(Addressable.class);
    HashMap<String, Object> data = new HashMap<>();

    // Act
    DataResponse actualDataResponse = new DataResponse(resultTo, data, "Template Name");
    String actualToStringResult = actualDataResponse.toString();
    Addressable actualAddress = actualDataResponse.getAddress();
    Map<String, Object> actualData = actualDataResponse.getData();

    // Assert
    assertEquals("DataResponse [data={}, template=Template Name]", actualToStringResult);
    assertEquals("Template Name", actualDataResponse.getTemplateName());
    assertTrue(actualData.isEmpty());
    assertSame(data, actualData);
    assertSame(resultTo, actualAddress);
  }
}
