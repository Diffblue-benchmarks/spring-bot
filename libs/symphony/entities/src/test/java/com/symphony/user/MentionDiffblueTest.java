package com.symphony.user;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.symphonyoss.TaxonomyElement;

class MentionDiffblueTest {
  /**
   * Test {@link Mention#Mention()}.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Mention#Mention()}
   */
  @Test
  @DisplayName("Test new Mention(); then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mention.<init>()", "void Mention.<init>(List)"})
  void testNewMention_thenReturnIdIsNull() {
    // Arrange, Act and Assert
    assertNull(new Mention().getId());
  }

  /**
   * Test {@link Mention#Mention(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Id Empty.
   * </ul>
   *
   * <p>Method under test: {@link Mention#Mention(List)}
   */
  @Test
  @DisplayName("Test new Mention(List); when ArrayList(); then return Id Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mention.<init>()", "void Mention.<init>(List)"})
  void testNewMention_whenArrayList_thenReturnIdEmpty() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();

    // Act and Assert
    List<TaxonomyElement> id2 = new Mention(id).getId();
    assertTrue(id2.isEmpty());
    assertSame(id, id2);
  }
}
