package org.finos.springbot.teams.templating.adaptivecard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ACVariableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ACVariable#ACVariable(String, String)}
   *   <li>{@link ACVariable#getDataPath()}
   *   <li>{@link ACVariable#getDepth()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.templating.adaptivecard.ACVariable.<init>(java.lang.String, java.lang.String)",
      "java.lang.String org.finos.springbot.teams.templating.adaptivecard.ACVariable.getDataPath()",
      "int org.finos.springbot.teams.templating.adaptivecard.ACVariable.getDepth()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ACVariable actualAcVariable = new ACVariable("Form Path", "Data Path");
    String actualDataPath = actualAcVariable.getDataPath();

    // Assert
    assertEquals("Data Path", actualDataPath);
    assertEquals(1, actualAcVariable.getDepth());
  }

  /**
   * Test {@link ACVariable#field(String)}.
   * <ul>
   *   <li>Then return FormIncrement is {@code #incrementForm Path.Seg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ACVariable#field(String)}
   */
  @Test
  @DisplayName("Test field(String); then return FormIncrement is '#incrementForm Path.Seg'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.templating.adaptivecard.ACVariable org.finos.springbot.teams.templating.adaptivecard.ACVariable.field(java.lang.String)"})
  void testField_thenReturnFormIncrementIsIncrementFormPathSeg() {
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
   * Test {@link ACVariable#field(String)}.
   * <ul>
   *   <li>Then return FormIncrement is {@code #incrementSeg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ACVariable#field(String)}
   */
  @Test
  @DisplayName("Test field(String); then return FormIncrement is '#incrementSeg'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.templating.adaptivecard.ACVariable org.finos.springbot.teams.templating.adaptivecard.ACVariable.field(java.lang.String)"})
  void testField_thenReturnFormIncrementIsIncrementSeg() {
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
   * Test {@link ACVariable#index()}.
   * <p>
   * Method under test: {@link ACVariable#index()}
   */
  @Test
  @DisplayName("Test index()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.templating.adaptivecard.ACVariable org.finos.springbot.teams.templating.adaptivecard.ACVariable.index()"})
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
   * Test {@link ACVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ACVariable#ACVariable(String, String)} with {@code Form Path} and dataPath is {@code UU}.</li>
   *   <li>Then return {@code u u}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ACVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ACVariable(String, String) with 'Form Path' and dataPath is 'UU'; then return 'u u'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.teams.templating.adaptivecard.ACVariable.getDisplayName()"})
  void testGetDisplayName_givenACVariableWithFormPathAndDataPathIsUu_thenReturnUU() {
    // Arrange, Act and Assert
    assertEquals("u u", (new ACVariable("Form Path", "UU")).getDisplayName());
  }

  /**
   * Test {@link ACVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ACVariable#ACVariable(String, String)} with {@code Form Path} and {@code Data Path}.</li>
   *   <li>Then return {@code data path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ACVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ACVariable(String, String) with 'Form Path' and 'Data Path'; then return 'data path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.teams.templating.adaptivecard.ACVariable.getDisplayName()"})
  void testGetDisplayName_givenACVariableWithFormPathAndDataPath_thenReturnDataPath() {
    // Arrange, Act and Assert
    assertEquals("data  path", (new ACVariable("Form Path", "Data Path")).getDisplayName());
  }

  /**
   * Test {@link ACVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ACVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.teams.templating.adaptivecard.ACVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new ACVariable("Form Path", ".")).getDisplayName());
  }

  /**
   * Test {@link ACVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code )(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ACVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return ')(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.teams.templating.adaptivecard.ACVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper() {
    // Arrange, Act and Assert
    assertEquals(")(\\p{ upper})", (new ACVariable("Form Path", "(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ACVariable#getFormFieldName()}.
   * <p>
   * Method under test: {@link ACVariable#getFormFieldName()}
   */
  @Test
  @DisplayName("Test getFormFieldName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.adaptivecard.ACVariable.getFormFieldName()"})
  void testGetFormFieldName() {
    // Arrange, Act and Assert
    assertEquals("form-field:Form Path", (new ACVariable("Form Path", "Data Path")).getFormFieldName());
  }

  /**
   * Test {@link ACVariable#getFormIncrement()}.
   * <p>
   * Method under test: {@link ACVariable#getFormIncrement()}
   */
  @Test
  @DisplayName("Test getFormIncrement()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.adaptivecard.ACVariable.getFormIncrement()"})
  void testGetFormIncrement() {
    // Arrange, Act and Assert
    assertEquals("#incrementForm Path", (new ACVariable("Form Path", "Data Path")).getFormIncrement());
  }

  /**
   * Test {@link ACVariable#getErrorPath()}.
   * <p>
   * Method under test: {@link ACVariable#getErrorPath()}
   */
  @Test
  @DisplayName("Test getErrorPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.teams.templating.adaptivecard.ACVariable.getErrorPath()"})
  void testGetErrorPath() {
    // Arrange, Act and Assert
    assertEquals("Data Path.error", (new ACVariable("Form Path", "Data Path")).getErrorPath());
  }
}
