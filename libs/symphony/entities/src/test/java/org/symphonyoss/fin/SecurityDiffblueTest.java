package org.symphonyoss.fin;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.symphonyoss.TaxonomyElement;

class SecurityDiffblueTest {
  /**
   * Method under test: {@link Security#Security()}
   */
  @Test
  void testNewSecurity() {
    // Arrange, Act and Assert
    assertNull((new Security()).getId());
  }

  /**
   * Method under test: {@link Security#Security(List)}
   */
  @Test
  void testNewSecurity2() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();

    // Act and Assert
    List<TaxonomyElement> id2 = (new Security(id)).getId();
    assertTrue(id2.isEmpty());
    assertSame(id, id2);
  }
}
