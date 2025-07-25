package org.finos.springbot.workflow.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.Paragraph;
import org.finos.springbot.workflow.content.Paragraph.ParagraphImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MessageResponseDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Addressable}.
   *   <li>Then return TemplateName is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageResponse#MessageResponse(Addressable, Content)}
   *   <li>{@link MessageResponse#toString()}
   *   <li>{@link MessageResponse#getMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Addressable; then return TemplateName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageResponse.<init>(Addressable, Map, Content, String)",
    "void MessageResponse.<init>(Addressable, Content)",
    "void MessageResponse.<init>(Addressable, Content, String)",
    "Content MessageResponse.getMessage()",
    "String MessageResponse.toString()"
  })
  void testGettersAndSetters_whenAddressable_thenReturnTemplateNameIsNull() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    Content m = mock(Content.class);

    // Act
    MessageResponse actualMessageResponse = new MessageResponse(stream, m);
    actualMessageResponse.toString();
    Content actualMessage = actualMessageResponse.getMessage();

    // Assert
    assertNull(actualMessageResponse.getTemplateName());
    assertTrue(actualMessageResponse.getData().isEmpty());
    assertSame(stream, actualMessageResponse.getAddress());
    assertSame(m, actualMessage);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code Template Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageResponse#MessageResponse(Addressable, Map, Content, String)}
   *   <li>{@link MessageResponse#toString()}
   *   <li>{@link MessageResponse#getMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashMap(); then return 'Template Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageResponse.<init>(Addressable, Map, Content, String)",
    "void MessageResponse.<init>(Addressable, Content)",
    "void MessageResponse.<init>(Addressable, Content, String)",
    "Content MessageResponse.getMessage()",
    "String MessageResponse.toString()"
  })
  void testGettersAndSetters_whenHashMap_thenReturnTemplateName() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    HashMap<String, Object> data = new HashMap<>();
    Content m = mock(Content.class);

    // Act
    MessageResponse actualMessageResponse = new MessageResponse(stream, data, m, "Template Name");
    actualMessageResponse.toString();
    Content actualMessage = actualMessageResponse.getMessage();

    // Assert
    assertEquals("Template Name", actualMessageResponse.getTemplateName());
    Map<String, Object> data2 = actualMessageResponse.getData();
    assertTrue(data2.isEmpty());
    assertSame(data, data2);
    assertSame(stream, actualMessageResponse.getAddress());
    assertSame(m, actualMessage);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Template}.
   *   <li>Then return TemplateName is {@code Template}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageResponse#MessageResponse(Addressable, Content, String)}
   *   <li>{@link MessageResponse#toString()}
   *   <li>{@link MessageResponse#getMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Template'; then return TemplateName is 'Template'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageResponse.<init>(Addressable, Map, Content, String)",
    "void MessageResponse.<init>(Addressable, Content)",
    "void MessageResponse.<init>(Addressable, Content, String)",
    "Content MessageResponse.getMessage()",
    "String MessageResponse.toString()"
  })
  void testGettersAndSetters_whenTemplate_thenReturnTemplateNameIsTemplate() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    Content m = mock(Content.class);

    // Act
    MessageResponse actualMessageResponse = new MessageResponse(stream, m, "Template");
    actualMessageResponse.toString();
    Content actualMessage = actualMessageResponse.getMessage();

    // Assert
    assertEquals("Template", actualMessageResponse.getTemplateName());
    assertTrue(actualMessageResponse.getData().isEmpty());
    assertSame(stream, actualMessageResponse.getAddress());
    assertSame(m, actualMessage);
  }

  /**
   * Test {@link MessageResponse#MessageResponse(Addressable, String)}.
   *
   * <p>Method under test: {@link MessageResponse#MessageResponse(Addressable, String)}
   */
  @Test
  @DisplayName("Test new MessageResponse(Addressable, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageResponse.<init>(Addressable, String)"})
  void testNewMessageResponse() {
    // Arrange
    Addressable stream = mock(Addressable.class);

    // Act
    MessageResponse actualMessageResponse =
        new MessageResponse(stream, "Not all who wander are lost");

    // Assert
    assertSame(stream, actualMessageResponse.getAddress());
    assertTrue(actualMessageResponse.getData().isEmpty());
    Content message = actualMessageResponse.getMessage();
    assertTrue(message instanceof MessageImpl);
    List<Content> contents = ((MessageImpl) message).getContents();
    assertEquals(1, contents.size());
    Content getResult = contents.get(0);
    assertTrue(getResult instanceof ParagraphImpl);
    assertEquals("Not all who wander are lost", message.getText());
    Iterator<Content> iteratorResult = ((MessageImpl) message).iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(getResult, actualNextResult);
    assertEquals(1, ((MessageImpl) message).size());
    assertNull(actualMessageResponse.getTemplateName());
  }
}
