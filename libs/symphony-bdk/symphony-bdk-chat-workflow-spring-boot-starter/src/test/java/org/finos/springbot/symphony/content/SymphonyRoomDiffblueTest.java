package org.finos.springbot.symphony.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.user.StreamID;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.symphonyoss.TaxonomyElement;

class SymphonyRoomDiffblueTest {
  /**
   * Test {@link SymphonyRoom#SymphonyRoom()}.
   *
   * <p>Method under test: {@link SymphonyRoom#SymphonyRoom()}
   */
  @Test
  @DisplayName("Test new SymphonyRoom()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyRoom.<init>()", "String SymphonyRoom.toString()"})
  void testNewSymphonyRoom() {
    // Arrange, Act and Assert
    assertNull(new SymphonyRoom().getId());
  }

  /**
   * Test {@link SymphonyRoom#SymphonyRoom(String, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then Id first return {@link StreamID}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyRoom#SymphonyRoom(String, String)}
   */
  @Test
  @DisplayName("Test new SymphonyRoom(String, String); when 'Name'; then Id first return StreamID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyRoom.<init>(String, String)"})
  void testNewSymphonyRoom_whenName_thenIdFirstReturnStreamID() {
    // Arrange and Act
    SymphonyRoom actualSymphonyRoom = new SymphonyRoom("Name", "42");

    // Assert
    List<TaxonomyElement> id = actualSymphonyRoom.getId();
    assertEquals(2, id.size());
    TaxonomyElement getResult = id.get(0);
    assertTrue(getResult instanceof StreamID);
    TaxonomyElement getResult2 = id.get(1);
    assertTrue(getResult2 instanceof RoomName);
    assertEquals("42", actualSymphonyRoom.getKey());
    assertEquals("42", getResult.getValue());
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("@", getResult2.getSymbolPrefix());
    assertEquals("Name", actualSymphonyRoom.getName());
    assertEquals("Name", getResult2.getValue());
  }

  /**
   * Test {@link SymphonyRoom#SymphonyRoom(String, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyRoom#SymphonyRoom(String, String)}
   */
  @Test
  @DisplayName("Test new SymphonyRoom(String, String); when 'Name'; then return Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyRoom.<init>(String, String)"})
  void testNewSymphonyRoom_whenName_thenReturnKeyIsNull() {
    // Arrange and Act
    SymphonyRoom actualSymphonyRoom = new SymphonyRoom("Name", null);

    // Assert
    List<TaxonomyElement> id = actualSymphonyRoom.getId();
    assertEquals(2, id.size());
    TaxonomyElement getResult = id.get(1);
    assertTrue(getResult instanceof RoomName);
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("Name", actualSymphonyRoom.getName());
    assertEquals("Name", getResult.getValue());
    assertNull(actualSymphonyRoom.getKey());
    assertNull(id.get(0));
  }

  /**
   * Test {@link SymphonyRoom#SymphonyRoom(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyRoom#SymphonyRoom(String, String)}
   */
  @Test
  @DisplayName("Test new SymphonyRoom(String, String); when 'null'; then return Name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyRoom.<init>(String, String)"})
  void testNewSymphonyRoom_whenNull_thenReturnNameIsNull() {
    // Arrange and Act
    SymphonyRoom actualSymphonyRoom = new SymphonyRoom(null, "42");

    // Assert
    List<TaxonomyElement> id = actualSymphonyRoom.getId();
    assertEquals(2, id.size());
    TaxonomyElement getResult = id.get(0);
    assertTrue(getResult instanceof StreamID);
    assertEquals("42", actualSymphonyRoom.getKey());
    assertEquals("42", getResult.getValue());
    assertEquals("@", getResult.getSymbolPrefix());
    assertNull(actualSymphonyRoom.getName());
    assertNull(id.get(1));
  }

  /**
   * Test {@link SymphonyRoom#getName()}.
   *
   * <ul>
   *   <li>Given {@link SymphonyRoom#SymphonyRoom(String, String)} with {@code Name} and id is
   *       {@code 42}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyRoom#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given SymphonyRoom(String, String) with 'Name' and id is '42'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyRoom.getName()"})
  void testGetName_givenSymphonyRoomWithNameAndIdIs42_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", new SymphonyRoom("Name", "42").getName());
  }

  /**
   * Test {@link SymphonyRoom#getKey()}.
   *
   * <ul>
   *   <li>Given {@link SymphonyRoom#SymphonyRoom(String, String)} with {@code Name} and id is
   *       {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyRoom#getKey()}
   */
  @Test
  @DisplayName(
      "Test getKey(); given SymphonyRoom(String, String) with 'Name' and id is '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyRoom.getKey()"})
  void testGetKey_givenSymphonyRoomWithNameAndIdIs42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", new SymphonyRoom("Name", "42").getKey());
  }
}
