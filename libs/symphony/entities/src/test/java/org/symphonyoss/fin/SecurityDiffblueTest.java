package org.symphonyoss.fin;

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

class SecurityDiffblueTest {
  /**
   * Test {@link Security#Security()}.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Security#Security()}
   */
  @Test
  @DisplayName("Test new Security(); then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Security.<init>()", "void Security.<init>(List)"})
  void testNewSecurity_thenReturnIdIsNull() {
    // Arrange, Act and Assert
    assertNull(new Security().getId());
  }

  /**
   * Test {@link Security#Security(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Id Empty.
   * </ul>
   *
   * <p>Method under test: {@link Security#Security(List)}
   */
  @Test
  @DisplayName("Test new Security(List); when ArrayList(); then return Id Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Security.<init>()", "void Security.<init>(List)"})
  void testNewSecurity_whenArrayList_thenReturnIdEmpty() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();

    // Act and Assert
    List<TaxonomyElement> id2 = new Security(id).getId();
    assertTrue(id2.isEmpty());
    assertSame(id, id2);
  }
}
