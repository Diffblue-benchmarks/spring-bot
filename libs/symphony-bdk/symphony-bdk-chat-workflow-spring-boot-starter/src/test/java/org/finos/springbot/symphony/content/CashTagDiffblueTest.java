package org.finos.springbot.symphony.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.symphonyoss.fin.security.id.Ticker;

class CashTagDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CashTag#CashTag()}
   *   <li>{@link CashTag#getTagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CashTag.<init>()",
    "void CashTag.<init>(List)",
    "org.finos.springbot.workflow.content.Tag.Type CashTag.getTagType()"
  })
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    CashTag actualCashTag = new CashTag();
    actualCashTag.getTagType();

    // Assert
    assertNull(actualCashTag.getId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Id Empty.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CashTag#CashTag(List)}
   *   <li>{@link CashTag#getTagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList(); then return Id Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CashTag.<init>()",
    "void CashTag.<init>(List)",
    "org.finos.springbot.workflow.content.Tag.Type CashTag.getTagType()"
  })
  void testGettersAndSetters_whenArrayList_thenReturnIdEmpty() {
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
   * Test {@link CashTag#CashTag(String)}.
   *
   * <p>Method under test: {@link CashTag#CashTag(String)}
   */
  @Test
  @DisplayName("Test new CashTag(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CashTag.<init>(String)"})
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

  /**
   * Test {@link CashTag#getName()}.
   *
   * <ul>
   *   <li>Given {@link CashTag#CashTag(String)} with id is {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link CashTag#getName()}
   */
  @Test
  @DisplayName("Test getName(); given CashTag(String) with id is '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CashTag.getName()"})
  void testGetName_givenCashTagWithIdIs42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", new CashTag("42").getName());
  }
}
