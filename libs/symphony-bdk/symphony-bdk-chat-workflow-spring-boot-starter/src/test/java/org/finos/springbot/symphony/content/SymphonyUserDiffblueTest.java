package org.finos.springbot.symphony.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.symphony.user.DisplayName;
import com.symphony.user.EmailAddress;
import com.symphony.user.UserId;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.symphonyoss.TaxonomyElement;

class SymphonyUserDiffblueTest {
  /**
   * Method under test: {@link SymphonyUser#getEmailAddress()}
   */
  @Test
  void testGetEmailAddress() {
    // Arrange, Act and Assert
    assertNull((new SymphonyUser(1L)).getEmailAddress());
  }

  /**
   * Method under test: {@link SymphonyUser#getStreamId()}
   */
  @Test
  void testGetStreamId() {
    // Arrange, Act and Assert
    assertNull((new SymphonyUser(1L)).getStreamId());
  }

  /**
   * Method under test: {@link SymphonyUser#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new SymphonyUser(1L)).getName());
  }

  /**
   * Method under test: {@link SymphonyUser#getUserId()}
   */
  @Test
  void testGetUserId() {
    // Arrange, Act and Assert
    assertEquals("1", (new SymphonyUser(1L)).getUserId());
  }

  /**
   * Method under test: {@link SymphonyUser#getKey()}
   */
  @Test
  void testGetKey() {
    // Arrange, Act and Assert
    assertEquals("1", (new SymphonyUser(1L)).getKey());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SymphonyUser#SymphonyUser()}
   *   <li>{@link SymphonyUser#toString()}
   *   <li>{@link SymphonyUser#getTagType()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link SymphonyUser#SymphonyUser(long)}
   */
  @Test
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
   * Method under test: {@link SymphonyUser#SymphonyUser(long, String, String)}
   */
  @Test
  void testNewSymphonyUser2() {
    // Arrange and Act
    SymphonyUser actualSymphonyUser = new SymphonyUser(1L, "Name", "42 Main St");

    // Assert
    List<TaxonomyElement> id = actualSymphonyUser.getId();
    assertEquals(3, id.size());
    TaxonomyElement getResult = id.get(1);
    assertTrue(getResult instanceof DisplayName);
    TaxonomyElement getResult2 = id.get(2);
    assertTrue(getResult2 instanceof EmailAddress);
    TaxonomyElement getResult3 = id.get(0);
    assertTrue(getResult3 instanceof UserId);
    assertEquals("1", actualSymphonyUser.getKey());
    assertEquals("1", actualSymphonyUser.getUserId());
    assertEquals("1", getResult3.getValue());
    assertEquals("42 Main St", actualSymphonyUser.getEmailAddress());
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("@", getResult3.getSymbolPrefix());
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("@", getResult2.getSymbolPrefix());
    assertEquals("@Name", actualSymphonyUser.getText());
    assertEquals("Name", actualSymphonyUser.getName());
    assertEquals("Name", getResult.getValue());
    assertNull(actualSymphonyUser.getStreamId());
  }

  /**
   * Method under test: {@link SymphonyUser#SymphonyUser(long, String, String)}
   */
  @Test
  void testNewSymphonyUser3() {
    // Arrange and Act
    SymphonyUser actualSymphonyUser = new SymphonyUser(1L, null, null);

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
   * Method under test: {@link SymphonyUser#SymphonyUser(String, String)}
   */
  @Test
  void testNewSymphonyUser4() {
    // Arrange and Act
    SymphonyUser actualSymphonyUser = new SymphonyUser("Name", "42 Main St");

    // Assert
    List<TaxonomyElement> id = actualSymphonyUser.getId();
    assertEquals(3, id.size());
    TaxonomyElement getResult = id.get(1);
    assertTrue(getResult instanceof DisplayName);
    TaxonomyElement getResult2 = id.get(2);
    assertTrue(getResult2 instanceof EmailAddress);
    assertEquals("42 Main St", actualSymphonyUser.getEmailAddress());
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("@", getResult2.getSymbolPrefix());
    assertEquals("@Name", actualSymphonyUser.getText());
    assertEquals("Name", actualSymphonyUser.getName());
    assertEquals("Name", getResult.getValue());
    assertNull(actualSymphonyUser.getKey());
    assertNull(actualSymphonyUser.getStreamId());
    assertNull(actualSymphonyUser.getUserId());
    assertNull(id.get(0));
  }

  /**
   * Method under test: {@link SymphonyUser#SymphonyUser(String, String)}
   */
  @Test
  void testNewSymphonyUser5() {
    // Arrange and Act
    SymphonyUser actualSymphonyUser = new SymphonyUser(null, null);

    // Assert
    assertEquals("@null", actualSymphonyUser.getText());
    assertNull(actualSymphonyUser.getEmailAddress());
    assertNull(actualSymphonyUser.getKey());
    assertNull(actualSymphonyUser.getName());
    assertNull(actualSymphonyUser.getStreamId());
    assertNull(actualSymphonyUser.getUserId());
    List<TaxonomyElement> id = actualSymphonyUser.getId();
    assertEquals(3, id.size());
    assertNull(id.get(0));
    assertNull(id.get(1));
    assertNull(id.get(2));
  }
}
