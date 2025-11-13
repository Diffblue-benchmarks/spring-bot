package org.finos.springbot.symphony.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.user.EmailAddress;
import com.symphony.user.UserId;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.symphonyoss.TaxonomyElement;

class SymphonyUserDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SymphonyUser#SymphonyUser()}
   *   <li>{@link SymphonyUser#toString()}
   *   <li>{@link SymphonyUser#getTagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SymphonyUser.<init>()",
    "org.finos.springbot.workflow.content.Tag.Type SymphonyUser.getTagType()",
    "String SymphonyUser.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SymphonyUser actualSymphonyUser = new SymphonyUser();
    String actualToStringResult = actualSymphonyUser.toString();
    actualSymphonyUser.getTagType();

    // Assert
    assertEquals("SymphonyUser [getId()=null]", actualToStringResult);
    assertNull(actualSymphonyUser.getId());
  }

  /**
   * Test {@link SymphonyUser#SymphonyUser(long)}.
   *
   * <p>Method under test: {@link SymphonyUser#SymphonyUser(long)}
   */
  @Test
  @DisplayName("Test new SymphonyUser(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyUser.<init>(long)"})
  void testNewSymphonyUser() {
    // Arrange and Act
    SymphonyUser actualSymphonyUser = new SymphonyUser(1L);

    // Assert
    List<TaxonomyElement> id = actualSymphonyUser.getId();
    assertEquals(3, id.size());
    TaxonomyElement getResult = id.get(0);
    assertTrue(getResult instanceof UserId);
    assertEquals("1", actualSymphonyUser.getKey());
    assertEquals("1", actualSymphonyUser.getUserId());
    assertEquals("1", getResult.getValue());
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("@null", actualSymphonyUser.getText());
    assertNull(actualSymphonyUser.getEmailAddress());
    assertNull(actualSymphonyUser.getName());
    assertNull(actualSymphonyUser.getStreamId());
    assertNull(id.get(1));
    assertNull(id.get(2));
  }

  /**
   * Test {@link SymphonyUser#SymphonyUser(long, String, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then Id second return {@link com.symphony.user.DisplayName}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyUser#SymphonyUser(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test new SymphonyUser(long, String, String); when 'Name'; then Id second return DisplayName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyUser.<init>(long, String, String)"})
  void testNewSymphonyUser_whenName_thenIdSecondReturnDisplayName() {
    // Arrange and Act
    SymphonyUser actualSymphonyUser = new SymphonyUser(1L, "Name", "42 Main St");

    // Assert
    List<TaxonomyElement> id = actualSymphonyUser.getId();
    assertEquals(3, id.size());
    TaxonomyElement getResult = id.get(1);
    assertTrue(getResult instanceof com.symphony.user.DisplayName);
    TaxonomyElement getResult2 = id.get(2);
    assertTrue(getResult2 instanceof EmailAddress);
    assertEquals("42 Main St", actualSymphonyUser.getEmailAddress());
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("@", getResult2.getSymbolPrefix());
    assertEquals("@Name", actualSymphonyUser.getText());
    assertEquals("Name", actualSymphonyUser.getName());
    assertEquals("Name", getResult.getValue());
  }

  /**
   * Test {@link SymphonyUser#SymphonyUser(String, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then Id second return {@link com.symphony.user.DisplayName}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyUser#SymphonyUser(String, String)}
   */
  @Test
  @DisplayName(
      "Test new SymphonyUser(String, String); when 'Name'; then Id second return DisplayName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyUser.<init>(String, String)"})
  void testNewSymphonyUser_whenName_thenIdSecondReturnDisplayName2() {
    // Arrange and Act
    SymphonyUser actualSymphonyUser = new SymphonyUser("Name", "42 Main St");

    // Assert
    List<TaxonomyElement> id = actualSymphonyUser.getId();
    assertEquals(3, id.size());
    TaxonomyElement getResult = id.get(1);
    assertTrue(getResult instanceof com.symphony.user.DisplayName);
    TaxonomyElement getResult2 = id.get(2);
    assertTrue(getResult2 instanceof EmailAddress);
    assertEquals("42 Main St", actualSymphonyUser.getEmailAddress());
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("@", getResult2.getSymbolPrefix());
    assertEquals("@Name", actualSymphonyUser.getText());
    assertEquals("Name", actualSymphonyUser.getName());
    assertEquals("Name", getResult.getValue());
  }

  /**
   * Test {@link SymphonyUser#SymphonyUser(long, String, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return EmailAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyUser#SymphonyUser(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test new SymphonyUser(long, String, String); when 'Name'; then return EmailAddress is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyUser.<init>(long, String, String)"})
  void testNewSymphonyUser_whenName_thenReturnEmailAddressIsNull() {
    // Arrange and Act
    SymphonyUser actualSymphonyUser = new SymphonyUser(1L, "Name", null);

    // Assert
    List<TaxonomyElement> id = actualSymphonyUser.getId();
    assertEquals(3, id.size());
    TaxonomyElement getResult = id.get(1);
    assertTrue(getResult instanceof com.symphony.user.DisplayName);
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("@Name", actualSymphonyUser.getText());
    assertEquals("Name", actualSymphonyUser.getName());
    assertEquals("Name", getResult.getValue());
    assertNull(actualSymphonyUser.getEmailAddress());
    assertNull(id.get(2));
  }

  /**
   * Test {@link SymphonyUser#SymphonyUser(String, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return EmailAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyUser#SymphonyUser(String, String)}
   */
  @Test
  @DisplayName(
      "Test new SymphonyUser(String, String); when 'Name'; then return EmailAddress is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyUser.<init>(String, String)"})
  void testNewSymphonyUser_whenName_thenReturnEmailAddressIsNull2() {
    // Arrange and Act
    SymphonyUser actualSymphonyUser = new SymphonyUser("Name", null);

    // Assert
    List<TaxonomyElement> id = actualSymphonyUser.getId();
    assertEquals(3, id.size());
    TaxonomyElement getResult = id.get(1);
    assertTrue(getResult instanceof com.symphony.user.DisplayName);
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("@Name", actualSymphonyUser.getText());
    assertEquals("Name", actualSymphonyUser.getName());
    assertEquals("Name", getResult.getValue());
    assertNull(actualSymphonyUser.getEmailAddress());
    assertNull(id.get(2));
  }

  /**
   * Test {@link SymphonyUser#SymphonyUser(long, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Text is {@code @null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyUser#SymphonyUser(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test new SymphonyUser(long, String, String); when 'null'; then return Text is '@null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyUser.<init>(long, String, String)"})
  void testNewSymphonyUser_whenNull_thenReturnTextIsNull() {
    // Arrange and Act
    SymphonyUser actualSymphonyUser = new SymphonyUser(1L, null, "42 Main St");

    // Assert
    List<TaxonomyElement> id = actualSymphonyUser.getId();
    assertEquals(3, id.size());
    TaxonomyElement getResult = id.get(2);
    assertTrue(getResult instanceof EmailAddress);
    assertEquals("42 Main St", actualSymphonyUser.getEmailAddress());
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("@null", actualSymphonyUser.getText());
    assertNull(actualSymphonyUser.getName());
    assertNull(id.get(1));
  }

  /**
   * Test {@link SymphonyUser#SymphonyUser(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Text is {@code @null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyUser#SymphonyUser(String, String)}
   */
  @Test
  @DisplayName("Test new SymphonyUser(String, String); when 'null'; then return Text is '@null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyUser.<init>(String, String)"})
  void testNewSymphonyUser_whenNull_thenReturnTextIsNull2() {
    // Arrange and Act
    SymphonyUser actualSymphonyUser = new SymphonyUser(null, "42 Main St");

    // Assert
    List<TaxonomyElement> id = actualSymphonyUser.getId();
    assertEquals(3, id.size());
    TaxonomyElement getResult = id.get(2);
    assertTrue(getResult instanceof EmailAddress);
    assertEquals("42 Main St", actualSymphonyUser.getEmailAddress());
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("@null", actualSymphonyUser.getText());
    assertNull(actualSymphonyUser.getName());
    assertNull(id.get(1));
  }

  /**
   * Test {@link SymphonyUser#getEmailAddress()}.
   *
   * <ul>
   *   <li>Given {@link SymphonyUser#SymphonyUser(long)} with userId is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyUser#getEmailAddress()}
   */
  @Test
  @DisplayName(
      "Test getEmailAddress(); given SymphonyUser(long) with userId is one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyUser.getEmailAddress()"})
  void testGetEmailAddress_givenSymphonyUserWithUserIdIsOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SymphonyUser(1L).getEmailAddress());
  }

  /**
   * Test {@link SymphonyUser#getStreamId()}.
   *
   * <ul>
   *   <li>Given {@link SymphonyUser#SymphonyUser(long)} with userId is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyUser#getStreamId()}
   */
  @Test
  @DisplayName(
      "Test getStreamId(); given SymphonyUser(long) with userId is one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyUser.getStreamId()"})
  void testGetStreamId_givenSymphonyUserWithUserIdIsOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SymphonyUser(1L).getStreamId());
  }

  /**
   * Test {@link SymphonyUser#getName()}.
   *
   * <ul>
   *   <li>Given {@link SymphonyUser#SymphonyUser(long)} with userId is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyUser#getName()}
   */
  @Test
  @DisplayName("Test getName(); given SymphonyUser(long) with userId is one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyUser.getName()"})
  void testGetName_givenSymphonyUserWithUserIdIsOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SymphonyUser(1L).getName());
  }

  /**
   * Test {@link SymphonyUser#getUserId()}.
   *
   * <ul>
   *   <li>Given {@link SymphonyUser#SymphonyUser(long)} with userId is one.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyUser#getUserId()}
   */
  @Test
  @DisplayName("Test getUserId(); given SymphonyUser(long) with userId is one; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyUser.getUserId()"})
  void testGetUserId_givenSymphonyUserWithUserIdIsOne_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("1", new SymphonyUser(1L).getUserId());
  }

  /**
   * Test {@link SymphonyUser#getKey()}.
   *
   * <ul>
   *   <li>Given {@link SymphonyUser#SymphonyUser(long)} with userId is one.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyUser#getKey()}
   */
  @Test
  @DisplayName("Test getKey(); given SymphonyUser(long) with userId is one; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyUser.getKey()"})
  void testGetKey_givenSymphonyUserWithUserIdIsOne_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("1", new SymphonyUser(1L).getKey());
  }
}
