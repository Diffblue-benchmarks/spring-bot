package org.symphonyoss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.user.DisplayName;
import com.symphony.user.Mention;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.symphonyoss.fin.security.id.Cusip;

class TaxonomyDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Taxonomy#Taxonomy()}
   *   <li>{@link Taxonomy#setId(List)}
   *   <li>{@link Taxonomy#getId()}
   * </ul>
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Taxonomy.<init>()",
    "void Taxonomy.<init>(List)",
    "List Taxonomy.getId()",
    "void Taxonomy.setId(List)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Taxonomy actualTaxonomy = new Taxonomy();
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    actualTaxonomy.setId(id);
    List<TaxonomyElement> actualId = actualTaxonomy.getId();

    // Assert
    assertTrue(actualId.isEmpty());
    assertSame(id, actualId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Taxonomy#Taxonomy(List)}
   *   <li>{@link Taxonomy#setId(List)}
   *   <li>{@link Taxonomy#getId()}
   * </ul>
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test getters and setters; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Taxonomy.<init>()",
    "void Taxonomy.<init>(List)",
    "List Taxonomy.getId()",
    "void Taxonomy.setId(List)"
  })
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    Taxonomy actualTaxonomy = new Taxonomy(new ArrayList<>());
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    actualTaxonomy.setId(id);
    List<TaxonomyElement> actualId = actualTaxonomy.getId();

    // Assert
    assertTrue(actualId.isEmpty());
    assertSame(id, actualId);
  }

  /**
   * Test {@link Taxonomy#equals(Object)}, and {@link Taxonomy#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Taxonomy#equals(Object)}
   *   <li>{@link Taxonomy#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.equals(Object)", "int Taxonomy.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();
    Taxonomy taxonomy2 = new Taxonomy();

    // Act and Assert
    assertEquals(taxonomy, taxonomy2);
    assertEquals(taxonomy.hashCode(), taxonomy2.hashCode());
  }

  /**
   * Test {@link Taxonomy#equals(Object)}, and {@link Taxonomy#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Taxonomy#equals(Object)}
   *   <li>{@link Taxonomy#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.equals(Object)", "int Taxonomy.hashCode()"})
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
    assertEquals(taxonomy.hashCode(), taxonomy2.hashCode());
  }

  /**
   * Test {@link Taxonomy#equals(Object)}, and {@link Taxonomy#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Taxonomy#equals(Object)}
   *   <li>{@link Taxonomy#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.equals(Object)", "int Taxonomy.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    // Act and Assert
    assertEquals(taxonomy, taxonomy);
    int expectedHashCodeResult = taxonomy.hashCode();
    assertEquals(expectedHashCodeResult, taxonomy.hashCode());
  }

  /**
   * Test {@link Taxonomy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.equals(Object)", "int Taxonomy.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy(new ArrayList<>());

    // Act and Assert
    assertNotEquals(taxonomy, new Taxonomy());
  }

  /**
   * Test {@link Taxonomy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.equals(Object)", "int Taxonomy.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    // Act and Assert
    assertNotEquals(taxonomy, new Taxonomy(new ArrayList<>()));
  }

  /**
   * Test {@link Taxonomy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.equals(Object)", "int Taxonomy.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
   * Test {@link Taxonomy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.equals(Object)", "int Taxonomy.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   * Test {@link Taxonomy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.equals(Object)", "int Taxonomy.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
   * Test {@link Taxonomy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.equals(Object)", "int Taxonomy.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
   * Test {@link Taxonomy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.equals(Object)", "int Taxonomy.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Taxonomy(), null);
  }

  /**
   * Test {@link Taxonomy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#equals(Object)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.equals(Object)", "int Taxonomy.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Taxonomy(), "Different type to Taxonomy");
  }

  /**
   * Test {@link Taxonomy#taxonomyPartMatch(List, List)}.
   *
   * <ul>
   *   <li>Given {@link Cusip#Cusip(String)} with value is {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Cusip#Cusip(String)} with value is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test taxonomyPartMatch(List, List); given Cusip(String) with value is '42'; when ArrayList() add Cusip(String) with value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.taxonomyPartMatch(List, List)"})
  void testTaxonomyPartMatch_givenCusipWithValueIs42_whenArrayListAddCusipWithValueIs42() {
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
   * Test {@link Taxonomy#taxonomyPartMatch(List, List)}.
   *
   * <ul>
   *   <li>Given {@link DisplayName#DisplayName(String)} with value is {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test taxonomyPartMatch(List, List); given DisplayName(String) with value is '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.taxonomyPartMatch(List, List)"})
  void testTaxonomyPartMatch_givenDisplayNameWithValueIs42_thenReturnTrue() {
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
   * Test {@link Taxonomy#taxonomyPartMatch(List, List)}.
   *
   * <ul>
   *   <li>Given {@link DisplayName#DisplayName(String)} with value is {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test taxonomyPartMatch(List, List); given DisplayName(String) with value is '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.taxonomyPartMatch(List, List)"})
  void testTaxonomyPartMatch_givenDisplayNameWithValueIs42_thenReturnTrue2() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    ArrayList<TaxonomyElement> a = new ArrayList<>();
    a.add(new DisplayName("42"));
    a.add(new DisplayName("42"));

    ArrayList<TaxonomyElement> b = new ArrayList<>();
    b.add(new DisplayName("42"));
    b.add(new DisplayName("42"));

    // Act and Assert
    assertTrue(taxonomy.taxonomyPartMatch(a, b));
  }

  /**
   * Test {@link Taxonomy#taxonomyPartMatch(List, List)}.
   *
   * <ul>
   *   <li>Given {@link DisplayName#DisplayName(String)} with value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test taxonomyPartMatch(List, List); given DisplayName(String) with value is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.taxonomyPartMatch(List, List)"})
  void testTaxonomyPartMatch_givenDisplayNameWithValueIsNull() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    ArrayList<TaxonomyElement> a = new ArrayList<>();
    a.add(new DisplayName("42"));

    ArrayList<TaxonomyElement> b = new ArrayList<>();
    b.add(new DisplayName(null));

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, b));
  }

  /**
   * Test {@link Taxonomy#taxonomyPartMatch(List, List)}.
   *
   * <ul>
   *   <li>Given {@link DisplayName#DisplayName(String)} with value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test taxonomyPartMatch(List, List); given DisplayName(String) with value is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.taxonomyPartMatch(List, List)"})
  void testTaxonomyPartMatch_givenDisplayNameWithValueIsNull2() {
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
   * Test {@link Taxonomy#taxonomyPartMatch(List, List)}.
   *
   * <ul>
   *   <li>Given {@link DisplayName#DisplayName(String)} with value is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test taxonomyPartMatch(List, List); given DisplayName(String) with value is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.taxonomyPartMatch(List, List)"})
  void testTaxonomyPartMatch_givenDisplayNameWithValueIsNull_thenReturnTrue() {
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
   * Test {@link Taxonomy#taxonomyPartMatch(List, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test taxonomyPartMatch(List, List); given 'null'; when ArrayList() add 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.taxonomyPartMatch(List, List)"})
  void testTaxonomyPartMatch_givenNull_whenArrayListAddNull_thenReturnFalse() {
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
   * Test {@link Taxonomy#taxonomyPartMatch(List, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test taxonomyPartMatch(List, List); given 'null'; when ArrayList() add 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.taxonomyPartMatch(List, List)"})
  void testTaxonomyPartMatch_givenNull_whenArrayListAddNull_thenReturnFalse2() {
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
   * Test {@link Taxonomy#taxonomyPartMatch(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test taxonomyPartMatch(List, List); when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.taxonomyPartMatch(List, List)"})
  void testTaxonomyPartMatch_whenArrayList_thenReturnFalse() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();
    ArrayList<TaxonomyElement> a = new ArrayList<>();

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, new ArrayList<>()));
  }

  /**
   * Test {@link Taxonomy#taxonomyPartMatch(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#taxonomyPartMatch(List, List)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test taxonomyPartMatch(List, List); when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Taxonomy.taxonomyPartMatch(List, List)"})
  void testTaxonomyPartMatch_whenArrayList_thenReturnFalse2() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();

    ArrayList<TaxonomyElement> a = new ArrayList<>();
    a.add(new DisplayName("42"));
    a.add(new DisplayName("42"));

    // Act and Assert
    assertFalse(taxonomy.taxonomyPartMatch(a, new ArrayList<>()));
  }

  /**
   * Test {@link Taxonomy#fromTaxonomy(Class)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DisplayName#DisplayName(String)} with
   *       value is {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#fromTaxonomy(Class)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test fromTaxonomy(Class); given ArrayList() add DisplayName(String) with value is '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Taxonomy.fromTaxonomy(Class)"})
  void testFromTaxonomy_givenArrayListAddDisplayNameWithValueIs42_thenReturn42() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    id.add(new DisplayName("42"));
    Mention mention = new Mention(id);
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertEquals("42", mention.fromTaxonomy(class1));
  }

  /**
   * Test {@link Taxonomy#fromTaxonomy(Class)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>When {@code Object}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#fromTaxonomy(Class)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test fromTaxonomy(Class); given ArrayList() add 'null'; when 'java.lang.Object'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Taxonomy.fromTaxonomy(Class)"})
  void testFromTaxonomy_givenArrayListAddNull_whenJavaLangObject_thenReturn42() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    id.add(null);
    id.add(new DisplayName("42"));
    Mention mention = new Mention(id);
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertEquals("42", mention.fromTaxonomy(class1));
  }

  /**
   * Test {@link Taxonomy#fromTaxonomy(Class)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#fromTaxonomy(Class)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test fromTaxonomy(Class); given ArrayList() add 'null'; when 'java.lang.Object'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Taxonomy.fromTaxonomy(Class)"})
  void testFromTaxonomy_givenArrayListAddNull_whenJavaLangObject_thenReturnNull() {
    // Arrange
    ArrayList<TaxonomyElement> id = new ArrayList<>();
    id.add(null);
    Mention mention = new Mention(id);
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNull(mention.fromTaxonomy(class1));
  }

  /**
   * Test {@link Taxonomy#fromTaxonomy(Class)}.
   *
   * <ul>
   *   <li>Given {@link Taxonomy#Taxonomy()} Id is {@link ArrayList#ArrayList()}.
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Taxonomy#fromTaxonomy(Class)}
   */
  @Test
  @org.junit.jupiter.api.DisplayName(
      "Test fromTaxonomy(Class); given Taxonomy() Id is ArrayList(); when 'java.lang.Object'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Taxonomy.fromTaxonomy(Class)"})
  void testFromTaxonomy_givenTaxonomyIdIsArrayList_whenJavaLangObject_thenReturnNull() {
    // Arrange
    Taxonomy taxonomy = new Taxonomy();
    taxonomy.setId(new ArrayList<>());
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNull(taxonomy.fromTaxonomy(class1));
  }
}
