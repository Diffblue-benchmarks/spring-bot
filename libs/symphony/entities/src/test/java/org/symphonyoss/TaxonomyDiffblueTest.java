package org.symphonyoss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.symphony.user.DisplayName;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.symphonyoss.fin.Security;
import org.symphonyoss.fin.security.id.Cusip;

class TaxonomyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Taxonomy#equals(Object)}
   *   <li>{@link Taxonomy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();
    Taxonomy taxonomy2 = new Taxonomy();

    // Act and Assert
    assertEquals(taxonomy, taxonomy2);
    int expectedHashCodeResult = taxonomy.hashCode();
    assertEquals(expectedHashCodeResult, taxonomy2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Taxonomy#equals(Object)}
   *   <li>{@link Taxonomy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    id.add(new DisplayName("42"));
    Taxonomy taxonomy = new Taxonomy(id);

    ArrayList<TaxonomyElement> id2 = new ArrayList<>();
    id2.add(new DisplayName("42"));

    Taxonomy taxonomy2 = new Taxonomy();
    taxonomy2.setId(id2);

    // Act and Assert
    assertEquals(taxonomy, taxonomy2);
    int expectedHashCodeResult = taxonomy.hashCode();
    assertEquals(expectedHashCodeResult, taxonomy2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Taxonomy#equals(Object)}
   *   <li>{@link Taxonomy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    // Act and Assert
    assertEquals(taxonomy, taxonomy);
    int expectedHashCodeResult = taxonomy.hashCode();
    assertEquals(expectedHashCodeResult, taxonomy.hashCode());
  }

  /**
   * Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  void testTaxonomyPartMatch() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();
    ArrayList<TaxonomyElement> a = new ArrayList<>();

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, new ArrayList<>()));
  }

  /**
   * Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  void testTaxonomyPartMatch2() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    ArrayList<TaxonomyElement> a = new ArrayList<>();
    a.add(new DisplayName("42"));

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, new ArrayList<>()));
  }

  /**
   * Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  void testTaxonomyPartMatch3() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    ArrayList<TaxonomyElement> a = new ArrayList<>();
    a.add(new DisplayName("42"));
    a.add(new DisplayName("42"));

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, new ArrayList<>()));
  }

  /**
   * Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  void testTaxonomyPartMatch4() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();
    ArrayList<TaxonomyElement> a = new ArrayList<>();

    ArrayList<TaxonomyElement> b = new ArrayList<>();
    b.add(new DisplayName("42"));

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, b));
  }

  /**
   * Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  void testTaxonomyPartMatch5() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();
    ArrayList<TaxonomyElement> a = new ArrayList<>();

    ArrayList<TaxonomyElement> b = new ArrayList<>();
    b.add(new DisplayName("42"));
    b.add(new DisplayName("42"));

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, b));
  }

  /**
   * Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  void testTaxonomyPartMatch6() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    ArrayList<TaxonomyElement> a = new ArrayList<>();
    a.add(new DisplayName("42"));

    ArrayList<TaxonomyElement> b = new ArrayList<>();
    b.add(new DisplayName("42"));

    // Act and Assert
    assertTrue(taxonomy.taxonomyPartMatch(a, b));
  }

  /**
   * Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  void testTaxonomyPartMatch7() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    ArrayList<TaxonomyElement> a = new ArrayList<>();
    a.add(new DisplayName("42"));

    ArrayList<TaxonomyElement> b = new ArrayList<>();
    b.add(new DisplayName("Value"));

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, b));
  }

  /**
   * Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  void testTaxonomyPartMatch8() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    ArrayList<TaxonomyElement> a = new ArrayList<>();
    a.add(new DisplayName(null));

    ArrayList<TaxonomyElement> b = new ArrayList<>();
    b.add(new DisplayName("42"));

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, b));
  }

  /**
   * Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  void testTaxonomyPartMatch9() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    ArrayList<TaxonomyElement> a = new ArrayList<>();
    a.add(new Cusip("42"));

    ArrayList<TaxonomyElement> b = new ArrayList<>();
    b.add(new DisplayName("42"));

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, b));
  }

  /**
   * Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  void testTaxonomyPartMatch10() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    ArrayList<TaxonomyElement> a = new ArrayList<>();
    a.add(null);

    ArrayList<TaxonomyElement> b = new ArrayList<>();
    b.add(new DisplayName("42"));

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, b));
  }

  /**
   * Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  void testTaxonomyPartMatch11() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    ArrayList<TaxonomyElement> a = new ArrayList<>();
    a.add(new DisplayName("42"));

    ArrayList<TaxonomyElement> b = new ArrayList<>();
    b.add(null);

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, b));
  }

  /**
   * Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  void testTaxonomyPartMatch12() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    ArrayList<TaxonomyElement> a = new ArrayList<>();
    a.add(new DisplayName(null));

    ArrayList<TaxonomyElement> b = new ArrayList<>();
    b.add(new DisplayName(null));

    // Act and Assert
    assertTrue(taxonomy.taxonomyPartMatch(a, b));
  }

  /**
   * Method under test: {@link Taxonomy#fromTaxonomy(Class)}
   */
  @Test
  void testFromTaxonomy() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    id.add(null);

    Taxonomy taxonomy = new Taxonomy();
    taxonomy.setId(id);
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNull(taxonomy.fromTaxonomy(class1));
  }

  /**
   * Method under test: {@link Taxonomy#fromTaxonomy(Class)}
   */
  @Test
  void testFromTaxonomy2() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    id.add(new DisplayName("42"));

    Taxonomy taxonomy = new Taxonomy();
    taxonomy.setId(id);
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertEquals("42", taxonomy.fromTaxonomy(class1));
  }

  /**
   * Method under test: {@link Taxonomy#fromTaxonomy(Class)}
   */
  @Test
  void testFromTaxonomy3() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();
    taxonomy.setId(new ArrayList<>());
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNull(taxonomy.fromTaxonomy(class1));
  }

  /**
   * Method under test: {@link Taxonomy#fromTaxonomy(Class)}
   */
  @Test
  void testFromTaxonomy4() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    id.add(null);
    id.add(null);

    Taxonomy taxonomy = new Taxonomy();
    taxonomy.setId(id);
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNull(taxonomy.fromTaxonomy(class1));
  }

  /**
   * Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy(new ArrayList<>());

    // Act and Assert
    assertNotEquals(taxonomy, new Taxonomy());
  }

  /**
   * Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    // Act and Assert
    assertNotEquals(taxonomy, new Taxonomy(new ArrayList<>()));
  }

  /**
   * Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new Taxonomy(), mock(Security.class));
  }

  /**
   * Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    id.add(new DisplayName("42"));
    Taxonomy taxonomy = new Taxonomy(id);

    Taxonomy taxonomy2 = new Taxonomy();
    taxonomy2.setId(new ArrayList<>());

    // Act and Assert
    assertNotEquals(taxonomy, taxonomy2);
  }

  /**
   * Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    id.add(new Cusip("42"));
    Taxonomy taxonomy = new Taxonomy(id);

    ArrayList<TaxonomyElement> id2 = new ArrayList<>();
    id2.add(new DisplayName("42"));

    Taxonomy taxonomy2 = new Taxonomy();
    taxonomy2.setId(id2);

    // Act and Assert
    assertNotEquals(taxonomy, taxonomy2);
  }

  /**
   * Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    id.add(null);
    Taxonomy taxonomy = new Taxonomy(id);

    ArrayList<TaxonomyElement> id2 = new ArrayList<>();
    id2.add(new DisplayName("42"));

    Taxonomy taxonomy2 = new Taxonomy();
    taxonomy2.setId(id2);

    // Act and Assert
    assertNotEquals(taxonomy, taxonomy2);
  }

  /**
   * Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    id.add(new DisplayName("42"));
    Taxonomy taxonomy = new Taxonomy(id);

    ArrayList<TaxonomyElement> id2 = new ArrayList<>();
    id2.add(null);

    Taxonomy taxonomy2 = new Taxonomy();
    taxonomy2.setId(id2);

    // Act and Assert
    assertNotEquals(taxonomy, taxonomy2);
  }

  /**
   * Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Taxonomy(), null);
  }

  /**
   * Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Taxonomy(), "Different type to Taxonomy");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Taxonomy#Taxonomy()}
   *   <li>{@link Taxonomy#setId(List)}
   *   <li>{@link Taxonomy#getId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Taxonomy actualTaxonomy = new Taxonomy();
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    actualTaxonomy.setId(id);
    List<TaxonomyElement> actualId = actualTaxonomy.getId();

    // Assert that nothing has changed
    assertTrue(actualId.isEmpty());
    assertSame(id, actualId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Taxonomy#Taxonomy(List)}
   *   <li>{@link Taxonomy#setId(List)}
   *   <li>{@link Taxonomy#getId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    Taxonomy actualTaxonomy = new Taxonomy(new ArrayList<>());
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    actualTaxonomy.setId(id);
    List<TaxonomyElement> actualId = actualTaxonomy.getId();

    // Assert that nothing has changed
    assertTrue(actualId.isEmpty());
    assertSame(id, actualId);
  }
}
