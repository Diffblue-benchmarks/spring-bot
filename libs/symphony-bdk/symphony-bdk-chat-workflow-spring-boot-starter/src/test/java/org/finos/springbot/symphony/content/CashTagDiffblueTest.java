package org.finos.springbot.symphony.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.symphonyoss.TaxonomyElement;
import org.symphonyoss.fin.security.id.Ticker;

class CashTagDiffblueTest {
  /**
   * Method under test: {@link CashTag#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("42", (new CashTag("42")).getName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CashTag#CashTag()}
   *   <li>{@link CashTag#getTagType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CashTag actualCashTag = new CashTag();
    actualCashTag.getTagType();

    // Assert
    assertNull(actualCashTag.getId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CashTag#CashTag(List)}
   *   <li>{@link CashTag#getTagType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();

    // Act
    CashTag actualCashTag = new CashTag(id);
    actualCashTag.getTagType();

    // Assert
    List<TaxonomyElement> id2 = actualCashTag.getId();
    assertTrue(id2.isEmpty());
    assertSame(id, id2);
  }

  /**
   * Method under test: {@link CashTag#CashTag(String)}
   */
  @Test
  void testNewCashTag() {
    // Arrange and Act
    CashTag actualCashTag = new CashTag("42");

    // Assert
    List<TaxonomyElement> id = actualCashTag.getId();
    assertEquals(1, id.size());
    TaxonomyElement getResult = id.get(0);
    assertTrue(getResult instanceof Ticker);
    assertEquals("$", getResult.getSymbolPrefix());
    assertEquals("$42", actualCashTag.getText());
    assertEquals("42", actualCashTag.getName());
    assertEquals("42", getResult.getValue());
  }
}
