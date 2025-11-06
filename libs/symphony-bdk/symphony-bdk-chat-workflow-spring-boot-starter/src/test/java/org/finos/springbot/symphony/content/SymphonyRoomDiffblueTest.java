package org.finos.springbot.symphony.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.symphony.user.StreamID;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.symphonyoss.TaxonomyElement;

class SymphonyRoomDiffblueTest {
  /**
   * Method under test: {@link SymphonyRoom#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new SymphonyRoom("Name", "42")).getName());
  }

  /**
   * Method under test: {@link SymphonyRoom#getKey()}
   */
  @Test
  void testGetKey() {
    // Arrange, Act and Assert
    assertEquals("42", (new SymphonyRoom("Name", "42")).getKey());
  }

  /**
   * Method under test: {@link SymphonyRoom#SymphonyRoom()}
   */
  @Test
  void testNewSymphonyRoom() {
    // Arrange, Act and Assert
    assertNull((new SymphonyRoom()).getId());
  }

  /**
   * Method under test: {@link SymphonyRoom#SymphonyRoom(String, String)}
   */
  @Test
  void testNewSymphonyRoom2() {
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
   * Method under test: {@link SymphonyRoom#SymphonyRoom(String, String)}
   */
  @Test
  void testNewSymphonyRoom3() {
    // Arrange and Act
    SymphonyRoom actualSymphonyRoom = new SymphonyRoom(null, null);

    // Assert
    assertNull(actualSymphonyRoom.getKey());
    assertNull(actualSymphonyRoom.getName());
    List<TaxonomyElement> id = actualSymphonyRoom.getId();
    assertEquals(2, id.size());
    assertNull(id.get(0));
    assertNull(id.get(1));
  }
}
