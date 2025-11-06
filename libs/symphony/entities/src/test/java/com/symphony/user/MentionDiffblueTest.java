package com.symphony.user;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.symphonyoss.TaxonomyElement;

class MentionDiffblueTest {
  /**
   * Method under test: {@link Mention#Mention()}
   */
  @Test
  void testNewMention() {
    // Arrange, Act and Assert
    assertNull((new Mention()).getId());
  }

  /**
   * Method under test: {@link Mention#Mention(List)}
   */
  @Test
  void testNewMention2() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();

    // Act and Assert
    List<TaxonomyElement> id2 = (new Mention(id)).getId();
    assertTrue(id2.isEmpty());
    assertSame(id, id2);
  }
}
