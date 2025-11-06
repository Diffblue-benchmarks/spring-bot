package org.finos.springbot.teams.templating.adaptivecard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ACVariableDiffblueTest {
  /**
   * Method under test: {@link ACVariable#field(String)}
   */
  @Test
  void testField() {
    // Arrange and Act
    ACVariable actualFieldResult = (new ACVariable("Form Path", "Data Path")).field("Seg");

    // Assert
    assertEquals("#incrementForm Path.Seg", actualFieldResult.getFormIncrement());
    assertEquals("Data Path.Seg", actualFieldResult.getDataPath());
    assertEquals("Data Path.Seg.error", actualFieldResult.getErrorPath());
    assertEquals("Form Path.Seg", actualFieldResult.formPath);
    assertEquals("form-field:Form Path.Seg", actualFieldResult.getFormFieldName());
    assertEquals("seg", actualFieldResult.getDisplayName());
    assertEquals(2, actualFieldResult.getDepth());
  }

  /**
   * Method under test: {@link ACVariable#field(String)}
   */
  @Test
  void testField2() {
    // Arrange and Act
    ACVariable actualFieldResult = (new ACVariable("", "Data Path")).field("Seg");

    // Assert
    assertEquals("#incrementSeg", actualFieldResult.getFormIncrement());
    assertEquals("Data Path.Seg", actualFieldResult.getDataPath());
    assertEquals("Data Path.Seg.error", actualFieldResult.getErrorPath());
    assertEquals("Seg", actualFieldResult.formPath);
    assertEquals("form-field:Seg", actualFieldResult.getFormFieldName());
    assertEquals("seg", actualFieldResult.getDisplayName());
    assertEquals(2, actualFieldResult.getDepth());
  }

  /**
   * Method under test: {@link ACVariable#index()}
   */
  @Test
  void testIndex() {
    // Arrange and Act
    ACVariable actualIndexResult = (new ACVariable("Form Path", "Data Path")).index();

    // Assert
    assertEquals("#incrementForm Path[[index:Data Path]]", actualIndexResult.getFormIncrement());
    assertEquals("$data", actualIndexResult.getDataPath());
    assertEquals("$data", actualIndexResult.getDisplayName());
    assertEquals("$data.error", actualIndexResult.getErrorPath());
    assertEquals("Form Path[[index:Data Path]]", actualIndexResult.formPath);
    assertEquals("form-field:Form Path[[index:Data Path]]", actualIndexResult.getFormFieldName());
    assertEquals(2, actualIndexResult.getDepth());
  }

  /**
   * Method under test: {@link ACVariable#getDisplayName()}
   */
  @Test
  void testGetDisplayName() {
    // Arrange, Act and Assert
    assertEquals("data  path", (new ACVariable("Form Path", "Data Path")).getDisplayName());
    assertEquals("u u", (new ACVariable("Form Path", "UU")).getDisplayName());
    assertEquals("", (new ACVariable("Form Path", ".")).getDisplayName());
    assertEquals(")(\\p{ upper})", (new ACVariable("Form Path", "(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Method under test: {@link ACVariable#getFormFieldName()}
   */
  @Test
  void testGetFormFieldName() {
    // Arrange, Act and Assert
    assertEquals("form-field:Form Path", (new ACVariable("Form Path", "Data Path")).getFormFieldName());
  }

  /**
   * Method under test: {@link ACVariable#getFormIncrement()}
   */
  @Test
  void testGetFormIncrement() {
    // Arrange, Act and Assert
    assertEquals("#incrementForm Path", (new ACVariable("Form Path", "Data Path")).getFormIncrement());
  }

  /**
   * Method under test: {@link ACVariable#getErrorPath()}
   */
  @Test
  void testGetErrorPath() {
    // Arrange, Act and Assert
    assertEquals("Data Path.error", (new ACVariable("Form Path", "Data Path")).getErrorPath());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ACVariable#ACVariable(String, String)}
   *   <li>{@link ACVariable#getDataPath()}
   *   <li>{@link ACVariable#getDepth()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ACVariable actualAcVariable = new ACVariable("Form Path", "Data Path");
    String actualDataPath = actualAcVariable.getDataPath();

    // Assert
    assertEquals("Data Path", actualDataPath);
    assertEquals(1, actualAcVariable.getDepth());
  }
}
