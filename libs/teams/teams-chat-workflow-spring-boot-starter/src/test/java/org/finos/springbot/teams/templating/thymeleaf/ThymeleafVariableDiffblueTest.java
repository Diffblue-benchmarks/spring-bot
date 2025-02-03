package org.finos.springbot.teams.templating.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThymeleafVariableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ThymeleafVariable#ThymeleafVariable(String)}
   *   <li>{@link ThymeleafVariable#toString()}
   *   <li>{@link ThymeleafVariable#getDepth()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.<init>(java.lang.String)",
      "int org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDepth()",
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ThymeleafVariable actualThymeleafVariable = new ThymeleafVariable("Name");
    String actualToStringResult = actualThymeleafVariable.toString();

    // Assert
    assertEquals("Name", actualToStringResult);
    assertEquals(1, actualThymeleafVariable.getDepth());
  }

  /**
   * Test {@link ThymeleafVariable#field(String)}.
   * <p>
   * Method under test: {@link ThymeleafVariable#field(String)}
   */
  @Test
  @DisplayName("Test field(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.field(java.lang.String)"})
  void testField() {
    // Arrange and Act
    ThymeleafVariable actualFieldResult = (new ThymeleafVariable("Name")).field("Seg");

    // Assert
    assertEquals("Name?.Seg", actualFieldResult.getDataPath());
    assertEquals("Name?.Seg?.error", actualFieldResult.getErrorPath());
    assertEquals("Seg", actualFieldResult.getFormFieldName());
    assertEquals("Seg", actualFieldResult.segment);
    assertEquals("seg", actualFieldResult.getDisplayName());
    assertEquals(2, actualFieldResult.getDepth());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2Name$1 $2}.</li>
   *   <li>Then return {@code $1 $2 name$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2Name$1 $2'; then return '$1 $2 name$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs12Name12_thenReturn12Name12() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 name$1 $2", (new ThymeleafVariable("$1 $2Name$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2Name42}.</li>
   *   <li>Then return {@code $1 $2 name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2Name42'; then return '$1 $2 name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs12Name42_thenReturn12Name42() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 name42", (new ThymeleafVariable("$1 $2Name42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2NameUU}.</li>
   *   <li>Then return {@code $1 $2 name uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2NameUU'; then return '$1 $2 name uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs12NameUU_thenReturn12NameUu() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 name uu", (new ThymeleafVariable("$1 $2NameUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2Name}.</li>
   *   <li>Then return {@code $1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2Name'; then return '$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs12Name_thenReturn12Name() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 name", (new ThymeleafVariable("$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2(.)(\p{Upper})}.</li>
   *   <li>Then return {@code $1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2(.)(\\p{Upper})'; then return '$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs12PUpper_thenReturn12PUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper})", (new ThymeleafVariable("$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2UUName}.</li>
   *   <li>Then return {@code $1 $2 uu name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2UUName'; then return '$1 $2 uu name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs12UUName_thenReturn12UuName() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uu name", (new ThymeleafVariable("$1 $2UUName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2UUform.}.</li>
   *   <li>Then return {@code $1 $2 uuform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2UUform.'; then return '$1 $2 uuform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs12UUform_thenReturn12Uuform() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uuform.", (new ThymeleafVariable("$1 $2UUform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2form.UU}.</li>
   *   <li>Then return {@code $1 $2form. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2form.UU'; then return '$1 $2form. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs12formUu_thenReturn12formUu() {
    // Arrange, Act and Assert
    assertEquals("$1 $2form. uu", (new ThymeleafVariable("$1 $2form.UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2UU$1 $2}.</li>
   *   <li>Then return {@code $1 $2 uu$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2UU$1 $2'; then return '$1 $2 uu$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs12uu12_thenReturn12Uu12() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uu$1 $2", (new ThymeleafVariable("$1 $2UU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2UU42}.</li>
   *   <li>Then return {@code $1 $2 uu42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2UU42'; then return '$1 $2 uu42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs12uu42_thenReturn12Uu42() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uu42", (new ThymeleafVariable("$1 $2UU42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2UU}.</li>
   *   <li>Then return {@code $1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2UU'; then return '$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs12uu_thenReturn12Uu() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uu", (new ThymeleafVariable("$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2UUUU}.</li>
   *   <li>Then return {@code $1 $2 uu uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2UUUU'; then return '$1 $2 uu uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs12uuuu_thenReturn12UuUu() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uu uu", (new ThymeleafVariable("$1 $2UUUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42Name$1 $2}.</li>
   *   <li>Then return {@code 42 name$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42Name$1 $2'; then return '42 name$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs42Name12_thenReturn42Name12() {
    // Arrange, Act and Assert
    assertEquals("42 name$1 $2", (new ThymeleafVariable("42Name$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42Name42}.</li>
   *   <li>Then return {@code 42 name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42Name42'; then return '42 name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs42Name42_thenReturn42Name42() {
    // Arrange, Act and Assert
    assertEquals("42 name42", (new ThymeleafVariable("42Name42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42NameUU}.</li>
   *   <li>Then return {@code 42 name uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42NameUU'; then return '42 name uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs42NameUU_thenReturn42NameUu() {
    // Arrange, Act and Assert
    assertEquals("42 name uu", (new ThymeleafVariable("42NameUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42Name}.</li>
   *   <li>Then return {@code 42 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42Name'; then return '42 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs42Name_thenReturn42Name() {
    // Arrange, Act and Assert
    assertEquals("42 name", (new ThymeleafVariable("42Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42(.)(\p{Upper})}.</li>
   *   <li>Then return {@code 42(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42(.)(\\p{Upper})'; then return '42(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs42PUpper_thenReturn42PUpper() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper})", (new ThymeleafVariable("42(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42UUName}.</li>
   *   <li>Then return {@code 42 uu name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42UUName'; then return '42 uu name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs42UUName_thenReturn42UuName() {
    // Arrange, Act and Assert
    assertEquals("42 uu name", (new ThymeleafVariable("42UUName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42UUform.}.</li>
   *   <li>Then return {@code 42 uuform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42UUform.'; then return '42 uuform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs42UUform_thenReturn42Uuform() {
    // Arrange, Act and Assert
    assertEquals("42 uuform.", (new ThymeleafVariable("42UUform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42form.UU}.</li>
   *   <li>Then return {@code 42form. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42form.UU'; then return '42form. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs42formUu_thenReturn42formUu() {
    // Arrange, Act and Assert
    assertEquals("42form. uu", (new ThymeleafVariable("42form.UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42UU$1 $2}.</li>
   *   <li>Then return {@code 42 uu$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42UU$1 $2'; then return '42 uu$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs42uu12_thenReturn42Uu12() {
    // Arrange, Act and Assert
    assertEquals("42 uu$1 $2", (new ThymeleafVariable("42UU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42UU42}.</li>
   *   <li>Then return {@code 42 uu42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42UU42'; then return '42 uu42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs42uu42_thenReturn42Uu42() {
    // Arrange, Act and Assert
    assertEquals("42 uu42", (new ThymeleafVariable("42UU42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42UU}.</li>
   *   <li>Then return {@code 42 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42UU'; then return '42 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs42uu_thenReturn42Uu() {
    // Arrange, Act and Assert
    assertEquals("42 uu", (new ThymeleafVariable("42UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42UUUU}.</li>
   *   <li>Then return {@code 42 uu uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42UUUU'; then return '42 uu uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs42uuuu_thenReturn42UuUu() {
    // Arrange, Act and Assert
    assertEquals("42 uu uu", (new ThymeleafVariable("42UUUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2$1 $2Name}.</li>
   *   <li>Then return {@code $1 $2$1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2$1 $2Name'; then return '$1 $2$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs1212Name_thenReturn1212Name() {
    // Arrange, Act and Assert
    assertEquals("$1 $2$1 $2 name", (new ThymeleafVariable("$1 $2$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $2$1 $2UU}.</li>
   *   <li>Then return {@code $1 $2$1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $2$1 $2UU'; then return '$1 $2$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs1212uu_thenReturn1212Uu() {
    // Arrange, Act and Assert
    assertEquals("$1 $2$1 $2 uu", (new ThymeleafVariable("$1 $2$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $242Name}.</li>
   *   <li>Then return {@code $1 $242 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $242Name'; then return '$1 $242 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs1242Name_thenReturn1242Name() {
    // Arrange, Act and Assert
    assertEquals("$1 $242 name", (new ThymeleafVariable("$1 $242Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code $1 $242UU}.</li>
   *   <li>Then return {@code $1 $242 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '$1 $242UU'; then return '$1 $242 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs1242uu_thenReturn1242Uu() {
    // Arrange, Act and Assert
    assertEquals("$1 $242 uu", (new ThymeleafVariable("$1 $242UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42$1 $2Name}.</li>
   *   <li>Then return {@code 42$1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42$1 $2Name'; then return '42$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs4212Name_thenReturn4212Name() {
    // Arrange, Act and Assert
    assertEquals("42$1 $2 name", (new ThymeleafVariable("42$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 42$1 $2UU}.</li>
   *   <li>Then return {@code 42$1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '42$1 $2UU'; then return '42$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs4212uu_thenReturn4212Uu() {
    // Arrange, Act and Assert
    assertEquals("42$1 $2 uu", (new ThymeleafVariable("42$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 4242Name}.</li>
   *   <li>Then return {@code 4242 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '4242Name'; then return '4242 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs4242Name_thenReturn4242Name() {
    // Arrange, Act and Assert
    assertEquals("4242 name", (new ThymeleafVariable("4242Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code 4242UU}.</li>
   *   <li>Then return {@code 4242 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '4242UU'; then return '4242 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIs4242uu_thenReturn4242Uu() {
    // Arrange, Act and Assert
    assertEquals("4242 uu", (new ThymeleafVariable("4242UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code form.$1 $2UU}.</li>
   *   <li>Then return {@code form.$1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'form.$1 $2UU'; then return 'form.$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsForm12uu_thenReturnForm12Uu() {
    // Arrange, Act and Assert
    assertEquals("form.$1 $2 uu", (new ThymeleafVariable("form.$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code form.42UU}.</li>
   *   <li>Then return {@code form.42 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'form.42UU'; then return 'form.42 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsForm42uu_thenReturnForm42Uu() {
    // Arrange, Act and Assert
    assertEquals("form.42 uu", (new ThymeleafVariable("form.42UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code form.Name}.</li>
   *   <li>Then return {@code form. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'form.Name'; then return 'form. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsFormName_thenReturnFormName() {
    // Arrange, Act and Assert
    assertEquals("form. name", (new ThymeleafVariable("form.Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code form.UU$1 $2}.</li>
   *   <li>Then return {@code form. uu$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'form.UU$1 $2'; then return 'form. uu$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsFormUu12_thenReturnFormUu12() {
    // Arrange, Act and Assert
    assertEquals("form. uu$1 $2", (new ThymeleafVariable("form.UU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code form.UU42}.</li>
   *   <li>Then return {@code form. uu42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'form.UU42'; then return 'form. uu42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsFormUu42_thenReturnFormUu42() {
    // Arrange, Act and Assert
    assertEquals("form. uu42", (new ThymeleafVariable("form.UU42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code form.UU}.</li>
   *   <li>Then return {@code form. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'form.UU'; then return 'form. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsFormUu_thenReturnFormUu() {
    // Arrange, Act and Assert
    assertEquals("form. uu", (new ThymeleafVariable("form.UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code form.UUUU}.</li>
   *   <li>Then return {@code form. uu uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'form.UUUU'; then return 'form. uu uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsFormUuuu_thenReturnFormUuUu() {
    // Arrange, Act and Assert
    assertEquals("form. uu uu", (new ThymeleafVariable("form.UUUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code Name$1 $2UU}.</li>
   *   <li>Then return {@code name$1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'Name$1 $2UU'; then return 'name$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsName12uu_thenReturnName12Uu() {
    // Arrange, Act and Assert
    assertEquals("name$1 $2 uu", (new ThymeleafVariable("Name$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code Name42UU}.</li>
   *   <li>Then return {@code name42 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'Name42UU'; then return 'name42 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsName42UU_thenReturnName42Uu() {
    // Arrange, Act and Assert
    assertEquals("name42 uu", (new ThymeleafVariable("Name42UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code NameName}.</li>
   *   <li>Then return {@code name name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'NameName'; then return 'name name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsNameName_thenReturnNameName() {
    // Arrange, Act and Assert
    assertEquals("name name", (new ThymeleafVariable("NameName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code NameUU$1 $2}.</li>
   *   <li>Then return {@code name uu$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'NameUU$1 $2'; then return 'name uu$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsNameUU12_thenReturnNameUu12() {
    // Arrange, Act and Assert
    assertEquals("name uu$1 $2", (new ThymeleafVariable("NameUU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code NameUU42}.</li>
   *   <li>Then return {@code name uu42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'NameUU42'; then return 'name uu42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsNameUU42_thenReturnNameUu42() {
    // Arrange, Act and Assert
    assertEquals("name uu42", (new ThymeleafVariable("NameUU42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code NameUUUU}.</li>
   *   <li>Then return {@code name uu uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'NameUUUU'; then return 'name uu uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsNameUUUU_thenReturnNameUuUu() {
    // Arrange, Act and Assert
    assertEquals("name uu uu", (new ThymeleafVariable("NameUUUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code NameUU}.</li>
   *   <li>Then return {@code name uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'NameUU'; then return 'name uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsNameUU_thenReturnNameUu() {
    // Arrange, Act and Assert
    assertEquals("name uu", (new ThymeleafVariable("NameUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code (.)(\p{Upper})$1 $2}.</li>
   *   <li>Then return {@code (.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '(.)(\\p{Upper})$1 $2'; then return '(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsPUpper12_thenReturnPUpper12() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $2", (new ThymeleafVariable("(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code (.)(\p{Upper})42}.</li>
   *   <li>Then return {@code (.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '(.)(\\p{Upper})42'; then return '(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsPUpper42_thenReturnPUpper42() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})42", (new ThymeleafVariable("(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code (.)(\p{Upper})UU}.</li>
   *   <li>Then return {@code (.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '(.)(\\p{Upper})UU'; then return '(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsPUpperUu_thenReturnPUpperUu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uu", (new ThymeleafVariable("(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code (.)(\p{Upper})}.</li>
   *   <li>Then return {@code (.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is '(.)(\\p{Upper})'; then return '(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsPUpper_thenReturnPUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})", (new ThymeleafVariable("(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU42Name}.</li>
   *   <li>Then return {@code u u42 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU42Name'; then return 'u u42 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUU42Name_thenReturnUU42Name() {
    // Arrange, Act and Assert
    assertEquals("u u42 name", (new ThymeleafVariable("UU42Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU42form.}.</li>
   *   <li>Then return {@code u u42form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU42form.'; then return 'u u42form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUU42form_thenReturnUU42form() {
    // Arrange, Act and Assert
    assertEquals("u u42form.", (new ThymeleafVariable("UU42form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUName$1 $2}.</li>
   *   <li>Then return {@code u uname$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUName$1 $2'; then return 'u uname$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUUName12_thenReturnUUname12() {
    // Arrange, Act and Assert
    assertEquals("u uname$1 $2", (new ThymeleafVariable("UUName$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUName42}.</li>
   *   <li>Then return {@code u uname42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUName42'; then return 'u uname42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUUName42_thenReturnUUname42() {
    // Arrange, Act and Assert
    assertEquals("u uname42", (new ThymeleafVariable("UUName42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUNameUU}.</li>
   *   <li>Then return {@code u uname uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUNameUU'; then return 'u uname uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUUNameUU_thenReturnUUnameUu() {
    // Arrange, Act and Assert
    assertEquals("u uname uu", (new ThymeleafVariable("UUNameUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUName}.</li>
   *   <li>Then return {@code u uname}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUName'; then return 'u uname'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUUName_thenReturnUUname() {
    // Arrange, Act and Assert
    assertEquals("u uname", (new ThymeleafVariable("UUName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUUUName}.</li>
   *   <li>Then return {@code u uu uname}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUUUName'; then return 'u uu uname'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUUUUName_thenReturnUUuUname() {
    // Arrange, Act and Assert
    assertEquals("u uu uname", (new ThymeleafVariable("UUUUName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUUUform.}.</li>
   *   <li>Then return {@code u uu uform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUUUform.'; then return 'u uu uform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUUUUform_thenReturnUUuUform() {
    // Arrange, Act and Assert
    assertEquals("u uu uform.", (new ThymeleafVariable("UUUUform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUform.$1 $2}.</li>
   *   <li>Then return {@code u uform.$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUform.$1 $2'; then return 'u uform.$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUUform12_thenReturnUUform12() {
    // Arrange, Act and Assert
    assertEquals("u uform.$1 $2", (new ThymeleafVariable("UUform.$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUform.42}.</li>
   *   <li>Then return {@code u uform.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUform.42'; then return 'u uform.42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUUform42_thenReturnUUform42() {
    // Arrange, Act and Assert
    assertEquals("u uform.42", (new ThymeleafVariable("UUform.42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUform.UU}.</li>
   *   <li>Then return {@code u uform. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUform.UU'; then return 'u uform. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUUformUu_thenReturnUUformUu() {
    // Arrange, Act and Assert
    assertEquals("u uform. uu", (new ThymeleafVariable("UUform.UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUform.}.</li>
   *   <li>Then return {@code u uform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUform.'; then return 'u uform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUUform_thenReturnUUform() {
    // Arrange, Act and Assert
    assertEquals("u uform.", (new ThymeleafVariable("UUform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU$1 $2Name}.</li>
   *   <li>Then return {@code u u$1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU$1 $2Name'; then return 'u u$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUu12Name_thenReturnUU12Name() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $2 name", (new ThymeleafVariable("UU$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU$1 $2}.</li>
   *   <li>Then return {@code u u$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU$1 $2'; then return 'u u$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUu12_thenReturnUU12() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $2", (new ThymeleafVariable("UU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU$1 $2form.}.</li>
   *   <li>Then return {@code u u$1 $2form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU$1 $2form.'; then return 'u u$1 $2form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUu12form_thenReturnUU12form() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $2form.", (new ThymeleafVariable("UU$1 $2form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU$1 $2UU}.</li>
   *   <li>Then return {@code u u$1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU$1 $2UU'; then return 'u u$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUu12uu_thenReturnUU12Uu() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $2 uu", (new ThymeleafVariable("UU$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU42}.</li>
   *   <li>Then return {@code u u42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU42'; then return 'u u42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUu42_thenReturnUU42() {
    // Arrange, Act and Assert
    assertEquals("u u42", (new ThymeleafVariable("UU42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU42UU}.</li>
   *   <li>Then return {@code u u42 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU42UU'; then return 'u u42 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUu42uu_thenReturnUU42Uu() {
    // Arrange, Act and Assert
    assertEquals("u u42 uu", (new ThymeleafVariable("UU42UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU$1 $2$1 $2}.</li>
   *   <li>Then return {@code u u$1 $2$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU$1 $2$1 $2'; then return 'u u$1 $2$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUu1212_thenReturnUU1212() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $2$1 $2", (new ThymeleafVariable("UU$1 $2$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU$1 $242}.</li>
   *   <li>Then return {@code u u$1 $242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU$1 $242'; then return 'u u$1 $242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUu1242_thenReturnUU1242() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $242", (new ThymeleafVariable("UU$1 $242")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU42$1 $2}.</li>
   *   <li>Then return {@code u u42$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU42$1 $2'; then return 'u u42$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUu4212_thenReturnUU4212() {
    // Arrange, Act and Assert
    assertEquals("u u42$1 $2", (new ThymeleafVariable("UU42$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU4242}.</li>
   *   <li>Then return {@code u u4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU4242'; then return 'u u4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUu4242_thenReturnUU4242() {
    // Arrange, Act and Assert
    assertEquals("u u4242", (new ThymeleafVariable("UU4242")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU(.)(\p{Upper})}.</li>
   *   <li>Then return {@code u u(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU(.)(\\p{Upper})'; then return 'u u(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUuPUpper_thenReturnUUPUpper() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper})", (new ThymeleafVariable("UU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UU}.</li>
   *   <li>Then return {@code u u}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UU'; then return 'u u'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUu_thenReturnUU() {
    // Arrange, Act and Assert
    assertEquals("u u", (new ThymeleafVariable("UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUUU$1 $2}.</li>
   *   <li>Then return {@code u uu u$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUUU$1 $2'; then return 'u uu u$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUuuu12_thenReturnUUuU12() {
    // Arrange, Act and Assert
    assertEquals("u uu u$1 $2", (new ThymeleafVariable("UUUU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUUU42}.</li>
   *   <li>Then return {@code u uu u42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUUU42'; then return 'u uu u42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUuuu42_thenReturnUUuU42() {
    // Arrange, Act and Assert
    assertEquals("u uu u42", (new ThymeleafVariable("UUUU42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUUU}.</li>
   *   <li>Then return {@code u uu u}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUUU'; then return 'u uu u'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUuuu_thenReturnUUuU() {
    // Arrange, Act and Assert
    assertEquals("u uu u", (new ThymeleafVariable("UUUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code UUUUUU}.</li>
   *   <li>Then return {@code u uu uu u}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with name is 'UUUUUU'; then return 'u uu uu u'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithNameIsUuuuuu_thenReturnUUuUuU() {
    // Arrange, Act and Assert
    assertEquals("u uu uu u", (new ThymeleafVariable("UUUUUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with {@code Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given ThymeleafVariable(String) with 'Name'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_givenThymeleafVariableWithName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("name", (new ThymeleafVariable("Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2 name name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2 name name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12NameName() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 name name", (new ThymeleafVariable("$1 $2NameName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2 name(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2 name(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12NamePUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 name(.)(\\p{ upper})", (new ThymeleafVariable("$1 $2Name(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2 nameform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2 nameform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12Nameform() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 nameform.", (new ThymeleafVariable("$1 $2Nameform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2(.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12PUpper12() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper})$1 $2", (new ThymeleafVariable("$1 $2(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2(.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12PUpper42() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper})42", (new ThymeleafVariable("$1 $2(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2(.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12PUpperForm() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper})form.", (new ThymeleafVariable("$1 $2(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2(.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12PUpperName() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper}) name", (new ThymeleafVariable("$1 $2(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2(.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12PUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("$1 $2(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2(.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12PUpperUu() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper}) uu", (new ThymeleafVariable("$1 $2(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2 uu(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2 uu(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12UuPUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uu(.)(\\p{ upper})", (new ThymeleafVariable("$1 $2UU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2form. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2form. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12formName() {
    // Arrange, Act and Assert
    assertEquals("$1 $2form. name", (new ThymeleafVariable("$1 $2form.Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2form.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2form.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12formPUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $2form.(.)(\\p{ upper})", (new ThymeleafVariable("$1 $2form.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42 name name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42 name name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42NameName() {
    // Arrange, Act and Assert
    assertEquals("42 name name", (new ThymeleafVariable("42NameName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42 name(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42 name(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42NamePUpper() {
    // Arrange, Act and Assert
    assertEquals("42 name(.)(\\p{ upper})", (new ThymeleafVariable("42Name(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42 nameform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42 nameform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42Nameform() {
    // Arrange, Act and Assert
    assertEquals("42 nameform.", (new ThymeleafVariable("42Nameform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42(.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42PUpper12() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper})$1 $2", (new ThymeleafVariable("42(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42(.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42PUpper42() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper})42", (new ThymeleafVariable("42(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42(.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42PUpperForm() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper})form.", (new ThymeleafVariable("42(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42(.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42PUpperName() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper}) name", (new ThymeleafVariable("42(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42(.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42PUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("42(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42(.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42PUpperUu() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper}) uu", (new ThymeleafVariable("42(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42 uu(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42 uu(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42UuPUpper() {
    // Arrange, Act and Assert
    assertEquals("42 uu(.)(\\p{ upper})", (new ThymeleafVariable("42UU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42form. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42form. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42formName() {
    // Arrange, Act and Assert
    assertEquals("42form. name", (new ThymeleafVariable("42form.Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42form.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42form.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42formPUpper() {
    // Arrange, Act and Assert
    assertEquals("42form.(.)(\\p{ upper})", (new ThymeleafVariable("42form.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2$1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn1212PUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $2$1 $2(.)(\\p{ upper})", (new ThymeleafVariable("$1 $2$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $242(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $242(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn1242PUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $242(.)(\\p{ upper})", (new ThymeleafVariable("$1 $242(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42$1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn4212PUpper() {
    // Arrange, Act and Assert
    assertEquals("42$1 $2(.)(\\p{ upper})", (new ThymeleafVariable("42$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 4242(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '4242(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn4242PUpper() {
    // Arrange, Act and Assert
    assertEquals("4242(.)(\\p{ upper})", (new ThymeleafVariable("4242(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.$1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnForm12Name() {
    // Arrange, Act and Assert
    assertEquals("form.$1 $2 name", (new ThymeleafVariable("form.$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.$1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnForm12PUpper() {
    // Arrange, Act and Assert
    assertEquals("form.$1 $2(.)(\\p{ upper})", (new ThymeleafVariable("form.$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.42 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.42 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnForm42Name() {
    // Arrange, Act and Assert
    assertEquals("form.42 name", (new ThymeleafVariable("form.42Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.42(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.42(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnForm42PUpper() {
    // Arrange, Act and Assert
    assertEquals("form.42(.)(\\p{ upper})", (new ThymeleafVariable("form.42(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.form. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.form. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormFormName() {
    // Arrange, Act and Assert
    assertEquals("form.form. name", (new ThymeleafVariable("form.form.Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.form.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.form.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormFormPUpper() {
    // Arrange, Act and Assert
    assertEquals("form.form.(.)(\\p{ upper})", (new ThymeleafVariable("form.form.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.form. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.form. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormFormUu() {
    // Arrange, Act and Assert
    assertEquals("form.form. uu", (new ThymeleafVariable("form.form.UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. name$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. name$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormName12() {
    // Arrange, Act and Assert
    assertEquals("form. name$1 $2", (new ThymeleafVariable("form.Name$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormName42() {
    // Arrange, Act and Assert
    assertEquals("form. name42", (new ThymeleafVariable("form.Name42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. name name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. name name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormNameName() {
    // Arrange, Act and Assert
    assertEquals("form. name name", (new ThymeleafVariable("form.NameName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. name(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. name(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormNamePUpper() {
    // Arrange, Act and Assert
    assertEquals("form. name(.)(\\p{ upper})", (new ThymeleafVariable("form.Name(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. name uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. name uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormNameUu() {
    // Arrange, Act and Assert
    assertEquals("form. name uu", (new ThymeleafVariable("form.NameUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. nameform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. nameform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormNameform() {
    // Arrange, Act and Assert
    assertEquals("form. nameform.", (new ThymeleafVariable("form.Nameform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpper() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper})", (new ThymeleafVariable("form.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpper12() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper})$1 $2", (new ThymeleafVariable("form.(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpper42() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper})42", (new ThymeleafVariable("form.(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpperForm() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper})form.", (new ThymeleafVariable("form.(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpperName() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper}) name", (new ThymeleafVariable("form.(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("form.(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpperUu() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper}) uu", (new ThymeleafVariable("form.(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. uu name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. uu name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormUuName() {
    // Arrange, Act and Assert
    assertEquals("form. uu name", (new ThymeleafVariable("form.UUName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. uu(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. uu(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormUuPUpper() {
    // Arrange, Act and Assert
    assertEquals("form. uu(.)(\\p{ upper})", (new ThymeleafVariable("form.UU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. uuform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. uuform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormUuform() {
    // Arrange, Act and Assert
    assertEquals("form. uuform.", (new ThymeleafVariable("form.UUform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name$1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnName12Name() {
    // Arrange, Act and Assert
    assertEquals("name$1 $2 name", (new ThymeleafVariable("Name$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name$1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnName12PUpper() {
    // Arrange, Act and Assert
    assertEquals("name$1 $2(.)(\\p{ upper})", (new ThymeleafVariable("Name$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name42 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name42 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnName42Name() {
    // Arrange, Act and Assert
    assertEquals("name42 name", (new ThymeleafVariable("Name42Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name42(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name42(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnName42PUpper() {
    // Arrange, Act and Assert
    assertEquals("name42(.)(\\p{ upper})", (new ThymeleafVariable("Name42(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name name$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name name$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameName12() {
    // Arrange, Act and Assert
    assertEquals("name name$1 $2", (new ThymeleafVariable("NameName$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameName42() {
    // Arrange, Act and Assert
    assertEquals("name name42", (new ThymeleafVariable("NameName42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name name name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name name name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameNameName() {
    // Arrange, Act and Assert
    assertEquals("name name name", (new ThymeleafVariable("NameNameName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name name(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name name(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameNamePUpper() {
    // Arrange, Act and Assert
    assertEquals("name name(.)(\\p{ upper})", (new ThymeleafVariable("NameName(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name name uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name name uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameNameUu() {
    // Arrange, Act and Assert
    assertEquals("name name uu", (new ThymeleafVariable("NameNameUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name nameform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name nameform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameNameform() {
    // Arrange, Act and Assert
    assertEquals("name nameform.", (new ThymeleafVariable("NameNameform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpper() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper})", (new ThymeleafVariable("Name(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpper12() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper})$1 $2", (new ThymeleafVariable("Name(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpper42() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper})42", (new ThymeleafVariable("Name(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpperForm() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper})form.", (new ThymeleafVariable("Name(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpperName() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper}) name", (new ThymeleafVariable("Name(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("Name(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpperUu() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper}) uu", (new ThymeleafVariable("Name(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name uu name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name uu name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameUuName() {
    // Arrange, Act and Assert
    assertEquals("name uu name", (new ThymeleafVariable("NameUUName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name uu(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name uu(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameUuPUpper() {
    // Arrange, Act and Assert
    assertEquals("name uu(.)(\\p{ upper})", (new ThymeleafVariable("NameUU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name uuform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name uuform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameUuform() {
    // Arrange, Act and Assert
    assertEquals("name uuform.", (new ThymeleafVariable("NameUUform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code nameform. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'nameform. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameformName() {
    // Arrange, Act and Assert
    assertEquals("nameform. name", (new ThymeleafVariable("Nameform.Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code nameform.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'nameform.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameformPUpper() {
    // Arrange, Act and Assert
    assertEquals("nameform.(.)(\\p{ upper})", (new ThymeleafVariable("Nameform.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code nameform. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'nameform. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameformUu() {
    // Arrange, Act and Assert
    assertEquals("nameform. uu", (new ThymeleafVariable("Nameform.UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})$1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper12Name() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $2 name", (new ThymeleafVariable("(.)(\\p{Upper})$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})$1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper12PUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $2(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})$1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper12Uu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $2 uu", (new ThymeleafVariable("(.)(\\p{Upper})$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})$1 $2form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})$1 $2form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper12form() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $2form.", (new ThymeleafVariable("(.)(\\p{Upper})$1 $2form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})42 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})42 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper42Name() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})42 name", (new ThymeleafVariable("(.)(\\p{Upper})42Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})42(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})42(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper42PUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})42(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})42(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})42 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})42 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper42Uu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})42 uu", (new ThymeleafVariable("(.)(\\p{Upper})42UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})42form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})42form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper42form() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})42form.", (new ThymeleafVariable("(.)(\\p{Upper})42form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})$1 $2$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})$1 $2$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper1212() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $2$1 $2", (new ThymeleafVariable("(.)(\\p{Upper})$1 $2$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})$1 $242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})$1 $242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper1242() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $242", (new ThymeleafVariable("(.)(\\p{Upper})$1 $242")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})42$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})42$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper4212() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})42$1 $2", (new ThymeleafVariable("(.)(\\p{Upper})42$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper4242() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})4242", (new ThymeleafVariable("(.)(\\p{Upper})4242")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperForm() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form.", (new ThymeleafVariable("(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form.$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form.$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperForm12() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form.$1 $2", (new ThymeleafVariable("(.)(\\p{Upper})form.$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form.42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperForm42() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form.42", (new ThymeleafVariable("(.)(\\p{Upper})form.42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form.form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form.form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperFormForm() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form.form.", (new ThymeleafVariable("(.)(\\p{Upper})form.form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperFormName() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form. name", (new ThymeleafVariable("(.)(\\p{Upper})form.Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperFormPUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form.(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})form.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperFormUu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form. uu", (new ThymeleafVariable("(.)(\\p{Upper})form.UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperName() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) name", (new ThymeleafVariable("(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) name$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) name$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperName12() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) name$1 $2", (new ThymeleafVariable("(.)(\\p{Upper})Name$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperName42() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) name42", (new ThymeleafVariable("(.)(\\p{Upper})Name42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) name name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) name name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperNameName() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) name name", (new ThymeleafVariable("(.)(\\p{Upper})NameName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) name(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) name(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperNamePUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) name(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})Name(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) name uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) name uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperNameUu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) name uu", (new ThymeleafVariable("(.)(\\p{Upper})NameUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) nameform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) nameform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperNameform() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) nameform.", (new ThymeleafVariable("(.)(\\p{Upper})Nameform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpper12() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})$1 $2",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpper42() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})42",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpperForm() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})form.",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpperName() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper}) name",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpperUu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper}) uu",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) uu$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) uu$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperUu12() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uu$1 $2", (new ThymeleafVariable("(.)(\\p{Upper})UU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) uu42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) uu42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperUu42() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uu42", (new ThymeleafVariable("(.)(\\p{Upper})UU42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) uu name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) uu name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperUuName() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uu name", (new ThymeleafVariable("(.)(\\p{Upper})UUName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) uu(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) uu(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperUuPUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uu(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})UU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) uu uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) uu uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperUuUu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uu uu", (new ThymeleafVariable("(.)(\\p{Upper})UUUU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) uuform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) uuform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperUuform() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uuform.", (new ThymeleafVariable("(.)(\\p{Upper})UUform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u$1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUU12PUpper() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $2(.)(\\p{ upper})", (new ThymeleafVariable("UU$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u42(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u42(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUU42PUpper() {
    // Arrange, Act and Assert
    assertEquals("u u42(.)(\\p{ upper})", (new ThymeleafVariable("UU42(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u(.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUPUpper12() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper})$1 $2", (new ThymeleafVariable("UU(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u(.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUPUpper42() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper})42", (new ThymeleafVariable("UU(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u(.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUPUpperForm() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper})form.", (new ThymeleafVariable("UU(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u(.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUPUpperName() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper}) name", (new ThymeleafVariable("UU(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u(.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUPUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("UU(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u(.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUPUpperUu() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper}) uu", (new ThymeleafVariable("UU(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u uform.form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u uform.form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUformForm() {
    // Arrange, Act and Assert
    assertEquals("u uform.form.", (new ThymeleafVariable("UUform.form.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u uform. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u uform. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUformName() {
    // Arrange, Act and Assert
    assertEquals("u uform. name", (new ThymeleafVariable("UUform.Name")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u uform.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u uform.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUformPUpper() {
    // Arrange, Act and Assert
    assertEquals("u uform.(.)(\\p{ upper})", (new ThymeleafVariable("UUform.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u uname name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u uname name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUnameName() {
    // Arrange, Act and Assert
    assertEquals("u uname name", (new ThymeleafVariable("UUNameName")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u uname(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u uname(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUnamePUpper() {
    // Arrange, Act and Assert
    assertEquals("u uname(.)(\\p{ upper})", (new ThymeleafVariable("UUName(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u unameform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u unameform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUnameform() {
    // Arrange, Act and Assert
    assertEquals("u unameform.", (new ThymeleafVariable("UUNameform.")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u uu u(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u uu u(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUuUPUpper() {
    // Arrange, Act and Assert
    assertEquals("u uu u(.)(\\p{ upper})", (new ThymeleafVariable("UUUU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link ThymeleafVariable#getFormFieldName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with name is {@code form.}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getFormFieldName()}
   */
  @Test
  @DisplayName("Test getFormFieldName(); given ThymeleafVariable(String) with name is 'form.'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getFormFieldName()"})
  void testGetFormFieldName_givenThymeleafVariableWithNameIsForm_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new ThymeleafVariable("form.")).getFormFieldName());
  }

  /**
   * Test {@link ThymeleafVariable#getFormFieldName()}.
   * <ul>
   *   <li>Given {@link ThymeleafVariable#ThymeleafVariable(String)} with {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafVariable#getFormFieldName()}
   */
  @Test
  @DisplayName("Test getFormFieldName(); given ThymeleafVariable(String) with 'Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getFormFieldName()"})
  void testGetFormFieldName_givenThymeleafVariableWithName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new ThymeleafVariable("Name")).getFormFieldName());
  }

  /**
   * Test {@link ThymeleafVariable#getDataPath()}.
   * <p>
   * Method under test: {@link ThymeleafVariable#getDataPath()}
   */
  @Test
  @DisplayName("Test getDataPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getDataPath()"})
  void testGetDataPath() {
    // Arrange, Act and Assert
    assertEquals("Name", (new ThymeleafVariable("Name")).getDataPath());
  }

  /**
   * Test {@link ThymeleafVariable#getErrorPath()}.
   * <p>
   * Method under test: {@link ThymeleafVariable#getErrorPath()}
   */
  @Test
  @DisplayName("Test getErrorPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafVariable.getErrorPath()"})
  void testGetErrorPath() {
    // Arrange, Act and Assert
    assertEquals("Name?.error", (new ThymeleafVariable("Name")).getErrorPath());
  }
}
