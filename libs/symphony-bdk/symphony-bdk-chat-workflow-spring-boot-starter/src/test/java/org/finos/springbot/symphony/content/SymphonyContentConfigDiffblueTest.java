package org.finos.springbot.symphony.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SymphonyContentConfigDiffblueTest {
  /**
   * Test {@link SymphonyContentConfig#symphonyMessageMLParser()}.
   *
   * <p>Method under test: {@link SymphonyContentConfig#symphonyMessageMLParser()}
   */
  @Test
  @DisplayName("Test symphonyMessageMLParser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.symphony.content.serialization.MessageMLParser SymphonyContentConfig.symphonyMessageMLParser()"
  })
  void testSymphonyMessageMLParser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    Message applyResult = new SymphonyContentConfig().symphonyMessageMLParser().apply("Source");
    assertTrue(applyResult instanceof MessageImpl);
    List<Content> contents = applyResult.getContents();
    assertEquals(1, contents.size());
    Content expectedNextResult = contents.get(0);
    assertEquals("Source", applyResult.getText());
    Iterator<Content> iteratorResult = applyResult.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(expectedNextResult, actualNextResult);
    assertEquals(1, applyResult.size());
  }

  /**
   * Test {@link SymphonyContentConfig#symphonyMessageMLWriter()}.
   *
   * <p>Method under test: {@link SymphonyContentConfig#symphonyMessageMLWriter()}
   */
  @Test
  @DisplayName("Test symphonyMessageMLWriter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.symphony.content.serialization.SymphonyMarkupWriter SymphonyContentConfig.symphonyMessageMLWriter()"
  })
  void testSymphonyMessageMLWriter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals("", new SymphonyContentConfig().symphonyMessageMLWriter().apply(null, null));
  }
}
