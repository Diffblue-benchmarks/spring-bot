package org.finos.springbot.symphony.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FreemarkerVariableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FreemarkerVariable#FreemarkerVariable(String)}
   *   <li>{@link FreemarkerVariable#getDepth()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.symphony.templating.FreemarkerVariable.<init>(java.lang.String)",
      "int org.finos.springbot.symphony.templating.FreemarkerVariable.getDepth()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(1, (new FreemarkerVariable("Name")).getDepth());
  }

  /**
   * Test {@link FreemarkerVariable#field(String)}.
   * <p>
   * Method under test: {@link FreemarkerVariable#field(String)}
   */
  @Test
  @DisplayName("Test field(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.symphony.templating.FreemarkerVariable org.finos.springbot.symphony.templating.FreemarkerVariable.field(java.lang.String)"})
  void testField() {
    // Arrange and Act
    FreemarkerVariable actualFieldResult = (new FreemarkerVariable("Name")).field("Seg");

    // Assert
    assertEquals("Name.Seg", actualFieldResult.getDataPath());
    assertEquals("Name.Seg.error", actualFieldResult.getErrorPath());
    assertEquals("Seg", actualFieldResult.getFormFieldName());
    assertEquals("Seg", actualFieldResult.segment);
    assertEquals("seg", actualFieldResult.getDisplayName());
    assertEquals(2, actualFieldResult.getDepth());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2Name$1 $2}.</li>
   *   <li>Then return {@code $1 $2 name$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2Name$1 $2'; then return '$1 $2 name$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs12Name12_thenReturn12Name12() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 name$1 $2", (new FreemarkerVariable("$1 $2Name$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2Name42}.</li>
   *   <li>Then return {@code $1 $2 name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2Name42'; then return '$1 $2 name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs12Name42_thenReturn12Name42() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 name42", (new FreemarkerVariable("$1 $2Name42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2NameUU}.</li>
   *   <li>Then return {@code $1 $2 name uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2NameUU'; then return '$1 $2 name uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs12NameUU_thenReturn12NameUu() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 name uu", (new FreemarkerVariable("$1 $2NameUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2Name}.</li>
   *   <li>Then return {@code $1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2Name'; then return '$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs12Name_thenReturn12Name() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 name", (new FreemarkerVariable("$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2(.)(\p{Upper})}.</li>
   *   <li>Then return {@code $1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2(.)(\\p{Upper})'; then return '$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs12PUpper_thenReturn12PUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper})", (new FreemarkerVariable("$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2UUName}.</li>
   *   <li>Then return {@code $1 $2 uu name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2UUName'; then return '$1 $2 uu name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs12UUName_thenReturn12UuName() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uu name", (new FreemarkerVariable("$1 $2UUName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2UUform.}.</li>
   *   <li>Then return {@code $1 $2 uuform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2UUform.'; then return '$1 $2 uuform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs12UUform_thenReturn12Uuform() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uuform.", (new FreemarkerVariable("$1 $2UUform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2form.UU}.</li>
   *   <li>Then return {@code $1 $2form. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2form.UU'; then return '$1 $2form. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs12formUu_thenReturn12formUu() {
    // Arrange, Act and Assert
    assertEquals("$1 $2form. uu", (new FreemarkerVariable("$1 $2form.UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2UU$1 $2}.</li>
   *   <li>Then return {@code $1 $2 uu$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2UU$1 $2'; then return '$1 $2 uu$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs12uu12_thenReturn12Uu12() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uu$1 $2", (new FreemarkerVariable("$1 $2UU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2UU42}.</li>
   *   <li>Then return {@code $1 $2 uu42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2UU42'; then return '$1 $2 uu42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs12uu42_thenReturn12Uu42() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uu42", (new FreemarkerVariable("$1 $2UU42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2UU}.</li>
   *   <li>Then return {@code $1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2UU'; then return '$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs12uu_thenReturn12Uu() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uu", (new FreemarkerVariable("$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2UUUU}.</li>
   *   <li>Then return {@code $1 $2 uu uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2UUUU'; then return '$1 $2 uu uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs12uuuu_thenReturn12UuUu() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uu uu", (new FreemarkerVariable("$1 $2UUUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42Name$1 $2}.</li>
   *   <li>Then return {@code 42 name$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42Name$1 $2'; then return '42 name$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs42Name12_thenReturn42Name12() {
    // Arrange, Act and Assert
    assertEquals("42 name$1 $2", (new FreemarkerVariable("42Name$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42Name42}.</li>
   *   <li>Then return {@code 42 name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42Name42'; then return '42 name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs42Name42_thenReturn42Name42() {
    // Arrange, Act and Assert
    assertEquals("42 name42", (new FreemarkerVariable("42Name42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42NameUU}.</li>
   *   <li>Then return {@code 42 name uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42NameUU'; then return '42 name uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs42NameUU_thenReturn42NameUu() {
    // Arrange, Act and Assert
    assertEquals("42 name uu", (new FreemarkerVariable("42NameUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42Name}.</li>
   *   <li>Then return {@code 42 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42Name'; then return '42 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs42Name_thenReturn42Name() {
    // Arrange, Act and Assert
    assertEquals("42 name", (new FreemarkerVariable("42Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42(.)(\p{Upper})}.</li>
   *   <li>Then return {@code 42(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42(.)(\\p{Upper})'; then return '42(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs42PUpper_thenReturn42PUpper() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper})", (new FreemarkerVariable("42(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42UUName}.</li>
   *   <li>Then return {@code 42 uu name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42UUName'; then return '42 uu name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs42UUName_thenReturn42UuName() {
    // Arrange, Act and Assert
    assertEquals("42 uu name", (new FreemarkerVariable("42UUName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42UUform.}.</li>
   *   <li>Then return {@code 42 uuform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42UUform.'; then return '42 uuform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs42UUform_thenReturn42Uuform() {
    // Arrange, Act and Assert
    assertEquals("42 uuform.", (new FreemarkerVariable("42UUform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42form.UU}.</li>
   *   <li>Then return {@code 42form. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42form.UU'; then return '42form. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs42formUu_thenReturn42formUu() {
    // Arrange, Act and Assert
    assertEquals("42form. uu", (new FreemarkerVariable("42form.UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42UU$1 $2}.</li>
   *   <li>Then return {@code 42 uu$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42UU$1 $2'; then return '42 uu$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs42uu12_thenReturn42Uu12() {
    // Arrange, Act and Assert
    assertEquals("42 uu$1 $2", (new FreemarkerVariable("42UU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42UU42}.</li>
   *   <li>Then return {@code 42 uu42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42UU42'; then return '42 uu42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs42uu42_thenReturn42Uu42() {
    // Arrange, Act and Assert
    assertEquals("42 uu42", (new FreemarkerVariable("42UU42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42UU}.</li>
   *   <li>Then return {@code 42 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42UU'; then return '42 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs42uu_thenReturn42Uu() {
    // Arrange, Act and Assert
    assertEquals("42 uu", (new FreemarkerVariable("42UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42UUUU}.</li>
   *   <li>Then return {@code 42 uu uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42UUUU'; then return '42 uu uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs42uuuu_thenReturn42UuUu() {
    // Arrange, Act and Assert
    assertEquals("42 uu uu", (new FreemarkerVariable("42UUUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2$1 $2Name}.</li>
   *   <li>Then return {@code $1 $2$1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2$1 $2Name'; then return '$1 $2$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs1212Name_thenReturn1212Name() {
    // Arrange, Act and Assert
    assertEquals("$1 $2$1 $2 name", (new FreemarkerVariable("$1 $2$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $2$1 $2UU}.</li>
   *   <li>Then return {@code $1 $2$1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $2$1 $2UU'; then return '$1 $2$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs1212uu_thenReturn1212Uu() {
    // Arrange, Act and Assert
    assertEquals("$1 $2$1 $2 uu", (new FreemarkerVariable("$1 $2$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $242Name}.</li>
   *   <li>Then return {@code $1 $242 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $242Name'; then return '$1 $242 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs1242Name_thenReturn1242Name() {
    // Arrange, Act and Assert
    assertEquals("$1 $242 name", (new FreemarkerVariable("$1 $242Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code $1 $242UU}.</li>
   *   <li>Then return {@code $1 $242 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '$1 $242UU'; then return '$1 $242 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs1242uu_thenReturn1242Uu() {
    // Arrange, Act and Assert
    assertEquals("$1 $242 uu", (new FreemarkerVariable("$1 $242UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42$1 $2Name}.</li>
   *   <li>Then return {@code 42$1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42$1 $2Name'; then return '42$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs4212Name_thenReturn4212Name() {
    // Arrange, Act and Assert
    assertEquals("42$1 $2 name", (new FreemarkerVariable("42$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 42$1 $2UU}.</li>
   *   <li>Then return {@code 42$1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '42$1 $2UU'; then return '42$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs4212uu_thenReturn4212Uu() {
    // Arrange, Act and Assert
    assertEquals("42$1 $2 uu", (new FreemarkerVariable("42$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 4242Name}.</li>
   *   <li>Then return {@code 4242 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '4242Name'; then return '4242 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs4242Name_thenReturn4242Name() {
    // Arrange, Act and Assert
    assertEquals("4242 name", (new FreemarkerVariable("4242Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code 4242UU}.</li>
   *   <li>Then return {@code 4242 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '4242UU'; then return '4242 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIs4242uu_thenReturn4242Uu() {
    // Arrange, Act and Assert
    assertEquals("4242 uu", (new FreemarkerVariable("4242UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code form.$1 $2UU}.</li>
   *   <li>Then return {@code form.$1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'form.$1 $2UU'; then return 'form.$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsForm12uu_thenReturnForm12Uu() {
    // Arrange, Act and Assert
    assertEquals("form.$1 $2 uu", (new FreemarkerVariable("form.$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code form.42UU}.</li>
   *   <li>Then return {@code form.42 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'form.42UU'; then return 'form.42 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsForm42uu_thenReturnForm42Uu() {
    // Arrange, Act and Assert
    assertEquals("form.42 uu", (new FreemarkerVariable("form.42UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code form.Name}.</li>
   *   <li>Then return {@code form. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'form.Name'; then return 'form. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsFormName_thenReturnFormName() {
    // Arrange, Act and Assert
    assertEquals("form. name", (new FreemarkerVariable("form.Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code form.UU$1 $2}.</li>
   *   <li>Then return {@code form. uu$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'form.UU$1 $2'; then return 'form. uu$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsFormUu12_thenReturnFormUu12() {
    // Arrange, Act and Assert
    assertEquals("form. uu$1 $2", (new FreemarkerVariable("form.UU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code form.UU42}.</li>
   *   <li>Then return {@code form. uu42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'form.UU42'; then return 'form. uu42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsFormUu42_thenReturnFormUu42() {
    // Arrange, Act and Assert
    assertEquals("form. uu42", (new FreemarkerVariable("form.UU42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code form.UU}.</li>
   *   <li>Then return {@code form. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'form.UU'; then return 'form. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsFormUu_thenReturnFormUu() {
    // Arrange, Act and Assert
    assertEquals("form. uu", (new FreemarkerVariable("form.UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code form.UUUU}.</li>
   *   <li>Then return {@code form. uu uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'form.UUUU'; then return 'form. uu uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsFormUuuu_thenReturnFormUuUu() {
    // Arrange, Act and Assert
    assertEquals("form. uu uu", (new FreemarkerVariable("form.UUUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code Name$1 $2UU}.</li>
   *   <li>Then return {@code name$1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'Name$1 $2UU'; then return 'name$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsName12uu_thenReturnName12Uu() {
    // Arrange, Act and Assert
    assertEquals("name$1 $2 uu", (new FreemarkerVariable("Name$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code Name42UU}.</li>
   *   <li>Then return {@code name42 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'Name42UU'; then return 'name42 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsName42UU_thenReturnName42Uu() {
    // Arrange, Act and Assert
    assertEquals("name42 uu", (new FreemarkerVariable("Name42UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code NameName}.</li>
   *   <li>Then return {@code name name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'NameName'; then return 'name name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsNameName_thenReturnNameName() {
    // Arrange, Act and Assert
    assertEquals("name name", (new FreemarkerVariable("NameName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code NameUU$1 $2}.</li>
   *   <li>Then return {@code name uu$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'NameUU$1 $2'; then return 'name uu$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsNameUU12_thenReturnNameUu12() {
    // Arrange, Act and Assert
    assertEquals("name uu$1 $2", (new FreemarkerVariable("NameUU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code NameUU42}.</li>
   *   <li>Then return {@code name uu42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'NameUU42'; then return 'name uu42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsNameUU42_thenReturnNameUu42() {
    // Arrange, Act and Assert
    assertEquals("name uu42", (new FreemarkerVariable("NameUU42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code NameUUUU}.</li>
   *   <li>Then return {@code name uu uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'NameUUUU'; then return 'name uu uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsNameUUUU_thenReturnNameUuUu() {
    // Arrange, Act and Assert
    assertEquals("name uu uu", (new FreemarkerVariable("NameUUUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code NameUU}.</li>
   *   <li>Then return {@code name uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'NameUU'; then return 'name uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsNameUU_thenReturnNameUu() {
    // Arrange, Act and Assert
    assertEquals("name uu", (new FreemarkerVariable("NameUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code (.)(\p{Upper})$1 $2}.</li>
   *   <li>Then return {@code (.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '(.)(\\p{Upper})$1 $2'; then return '(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsPUpper12_thenReturnPUpper12() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $2", (new FreemarkerVariable("(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code (.)(\p{Upper})42}.</li>
   *   <li>Then return {@code (.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '(.)(\\p{Upper})42'; then return '(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsPUpper42_thenReturnPUpper42() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})42", (new FreemarkerVariable("(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code (.)(\p{Upper})UU}.</li>
   *   <li>Then return {@code (.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '(.)(\\p{Upper})UU'; then return '(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsPUpperUu_thenReturnPUpperUu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uu", (new FreemarkerVariable("(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code (.)(\p{Upper})}.</li>
   *   <li>Then return {@code (.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is '(.)(\\p{Upper})'; then return '(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsPUpper_thenReturnPUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})", (new FreemarkerVariable("(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU42Name}.</li>
   *   <li>Then return {@code u u42 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU42Name'; then return 'u u42 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUU42Name_thenReturnUU42Name() {
    // Arrange, Act and Assert
    assertEquals("u u42 name", (new FreemarkerVariable("UU42Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU42form.}.</li>
   *   <li>Then return {@code u u42form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU42form.'; then return 'u u42form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUU42form_thenReturnUU42form() {
    // Arrange, Act and Assert
    assertEquals("u u42form.", (new FreemarkerVariable("UU42form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUName$1 $2}.</li>
   *   <li>Then return {@code u uname$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUName$1 $2'; then return 'u uname$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUUName12_thenReturnUUname12() {
    // Arrange, Act and Assert
    assertEquals("u uname$1 $2", (new FreemarkerVariable("UUName$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUName42}.</li>
   *   <li>Then return {@code u uname42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUName42'; then return 'u uname42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUUName42_thenReturnUUname42() {
    // Arrange, Act and Assert
    assertEquals("u uname42", (new FreemarkerVariable("UUName42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUNameUU}.</li>
   *   <li>Then return {@code u uname uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUNameUU'; then return 'u uname uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUUNameUU_thenReturnUUnameUu() {
    // Arrange, Act and Assert
    assertEquals("u uname uu", (new FreemarkerVariable("UUNameUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUName}.</li>
   *   <li>Then return {@code u uname}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUName'; then return 'u uname'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUUName_thenReturnUUname() {
    // Arrange, Act and Assert
    assertEquals("u uname", (new FreemarkerVariable("UUName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUUUName}.</li>
   *   <li>Then return {@code u uu uname}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUUUName'; then return 'u uu uname'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUUUUName_thenReturnUUuUname() {
    // Arrange, Act and Assert
    assertEquals("u uu uname", (new FreemarkerVariable("UUUUName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUUUform.}.</li>
   *   <li>Then return {@code u uu uform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUUUform.'; then return 'u uu uform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUUUUform_thenReturnUUuUform() {
    // Arrange, Act and Assert
    assertEquals("u uu uform.", (new FreemarkerVariable("UUUUform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUform.$1 $2}.</li>
   *   <li>Then return {@code u uform.$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUform.$1 $2'; then return 'u uform.$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUUform12_thenReturnUUform12() {
    // Arrange, Act and Assert
    assertEquals("u uform.$1 $2", (new FreemarkerVariable("UUform.$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUform.42}.</li>
   *   <li>Then return {@code u uform.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUform.42'; then return 'u uform.42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUUform42_thenReturnUUform42() {
    // Arrange, Act and Assert
    assertEquals("u uform.42", (new FreemarkerVariable("UUform.42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUform.UU}.</li>
   *   <li>Then return {@code u uform. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUform.UU'; then return 'u uform. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUUformUu_thenReturnUUformUu() {
    // Arrange, Act and Assert
    assertEquals("u uform. uu", (new FreemarkerVariable("UUform.UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUform.}.</li>
   *   <li>Then return {@code u uform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUform.'; then return 'u uform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUUform_thenReturnUUform() {
    // Arrange, Act and Assert
    assertEquals("u uform.", (new FreemarkerVariable("UUform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU$1 $2Name}.</li>
   *   <li>Then return {@code u u$1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU$1 $2Name'; then return 'u u$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUu12Name_thenReturnUU12Name() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $2 name", (new FreemarkerVariable("UU$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU$1 $2}.</li>
   *   <li>Then return {@code u u$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU$1 $2'; then return 'u u$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUu12_thenReturnUU12() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $2", (new FreemarkerVariable("UU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU$1 $2form.}.</li>
   *   <li>Then return {@code u u$1 $2form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU$1 $2form.'; then return 'u u$1 $2form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUu12form_thenReturnUU12form() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $2form.", (new FreemarkerVariable("UU$1 $2form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU$1 $2UU}.</li>
   *   <li>Then return {@code u u$1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU$1 $2UU'; then return 'u u$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUu12uu_thenReturnUU12Uu() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $2 uu", (new FreemarkerVariable("UU$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU42}.</li>
   *   <li>Then return {@code u u42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU42'; then return 'u u42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUu42_thenReturnUU42() {
    // Arrange, Act and Assert
    assertEquals("u u42", (new FreemarkerVariable("UU42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU42UU}.</li>
   *   <li>Then return {@code u u42 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU42UU'; then return 'u u42 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUu42uu_thenReturnUU42Uu() {
    // Arrange, Act and Assert
    assertEquals("u u42 uu", (new FreemarkerVariable("UU42UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU$1 $2$1 $2}.</li>
   *   <li>Then return {@code u u$1 $2$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU$1 $2$1 $2'; then return 'u u$1 $2$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUu1212_thenReturnUU1212() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $2$1 $2", (new FreemarkerVariable("UU$1 $2$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU$1 $242}.</li>
   *   <li>Then return {@code u u$1 $242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU$1 $242'; then return 'u u$1 $242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUu1242_thenReturnUU1242() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $242", (new FreemarkerVariable("UU$1 $242")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU42$1 $2}.</li>
   *   <li>Then return {@code u u42$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU42$1 $2'; then return 'u u42$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUu4212_thenReturnUU4212() {
    // Arrange, Act and Assert
    assertEquals("u u42$1 $2", (new FreemarkerVariable("UU42$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU4242}.</li>
   *   <li>Then return {@code u u4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU4242'; then return 'u u4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUu4242_thenReturnUU4242() {
    // Arrange, Act and Assert
    assertEquals("u u4242", (new FreemarkerVariable("UU4242")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU(.)(\p{Upper})}.</li>
   *   <li>Then return {@code u u(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU(.)(\\p{Upper})'; then return 'u u(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUuPUpper_thenReturnUUPUpper() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper})", (new FreemarkerVariable("UU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UU}.</li>
   *   <li>Then return {@code u u}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UU'; then return 'u u'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUu_thenReturnUU() {
    // Arrange, Act and Assert
    assertEquals("u u", (new FreemarkerVariable("UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUUU$1 $2}.</li>
   *   <li>Then return {@code u uu u$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUUU$1 $2'; then return 'u uu u$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUuuu12_thenReturnUUuU12() {
    // Arrange, Act and Assert
    assertEquals("u uu u$1 $2", (new FreemarkerVariable("UUUU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUUU42}.</li>
   *   <li>Then return {@code u uu u42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUUU42'; then return 'u uu u42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUuuu42_thenReturnUUuU42() {
    // Arrange, Act and Assert
    assertEquals("u uu u42", (new FreemarkerVariable("UUUU42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUUU}.</li>
   *   <li>Then return {@code u uu u}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUUU'; then return 'u uu u'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUuuu_thenReturnUUuU() {
    // Arrange, Act and Assert
    assertEquals("u uu u", (new FreemarkerVariable("UUUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code UUUUUU}.</li>
   *   <li>Then return {@code u uu uu u}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with name is 'UUUUUU'; then return 'u uu uu u'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithNameIsUuuuuu_thenReturnUUuUuU() {
    // Arrange, Act and Assert
    assertEquals("u uu uu u", (new FreemarkerVariable("UUUUUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with {@code Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given FreemarkerVariable(String) with 'Name'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_givenFreemarkerVariableWithName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("name", (new FreemarkerVariable("Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2 name name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2 name name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12NameName() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 name name", (new FreemarkerVariable("$1 $2NameName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2 name(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2 name(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12NamePUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 name(.)(\\p{ upper})", (new FreemarkerVariable("$1 $2Name(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2 nameform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2 nameform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12Nameform() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 nameform.", (new FreemarkerVariable("$1 $2Nameform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2(.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12PUpper12() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper})$1 $2", (new FreemarkerVariable("$1 $2(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2(.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12PUpper42() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper})42", (new FreemarkerVariable("$1 $2(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2(.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12PUpperForm() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper})form.", (new FreemarkerVariable("$1 $2(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2(.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12PUpperName() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper}) name", (new FreemarkerVariable("$1 $2(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2(.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12PUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("$1 $2(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2(.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12PUpperUu() {
    // Arrange, Act and Assert
    assertEquals("$1 $2(.)(\\p{ upper}) uu", (new FreemarkerVariable("$1 $2(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2 uu(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2 uu(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12UuPUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $2 uu(.)(\\p{ upper})", (new FreemarkerVariable("$1 $2UU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2form. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2form. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12formName() {
    // Arrange, Act and Assert
    assertEquals("$1 $2form. name", (new FreemarkerVariable("$1 $2form.Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2form.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2form.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn12formPUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $2form.(.)(\\p{ upper})", (new FreemarkerVariable("$1 $2form.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42 name name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42 name name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42NameName() {
    // Arrange, Act and Assert
    assertEquals("42 name name", (new FreemarkerVariable("42NameName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42 name(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42 name(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42NamePUpper() {
    // Arrange, Act and Assert
    assertEquals("42 name(.)(\\p{ upper})", (new FreemarkerVariable("42Name(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42 nameform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42 nameform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42Nameform() {
    // Arrange, Act and Assert
    assertEquals("42 nameform.", (new FreemarkerVariable("42Nameform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42(.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42PUpper12() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper})$1 $2", (new FreemarkerVariable("42(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42(.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42PUpper42() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper})42", (new FreemarkerVariable("42(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42(.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42PUpperForm() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper})form.", (new FreemarkerVariable("42(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42(.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42PUpperName() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper}) name", (new FreemarkerVariable("42(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42(.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42PUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("42(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42(.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42PUpperUu() {
    // Arrange, Act and Assert
    assertEquals("42(.)(\\p{ upper}) uu", (new FreemarkerVariable("42(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42 uu(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42 uu(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42UuPUpper() {
    // Arrange, Act and Assert
    assertEquals("42 uu(.)(\\p{ upper})", (new FreemarkerVariable("42UU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42form. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42form. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42formName() {
    // Arrange, Act and Assert
    assertEquals("42form. name", (new FreemarkerVariable("42form.Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42form.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42form.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn42formPUpper() {
    // Arrange, Act and Assert
    assertEquals("42form.(.)(\\p{ upper})", (new FreemarkerVariable("42form.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $2$1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $2$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn1212PUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $2$1 $2(.)(\\p{ upper})", (new FreemarkerVariable("$1 $2$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code $1 $242(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '$1 $242(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn1242PUpper() {
    // Arrange, Act and Assert
    assertEquals("$1 $242(.)(\\p{ upper})", (new FreemarkerVariable("$1 $242(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 42$1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '42$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn4212PUpper() {
    // Arrange, Act and Assert
    assertEquals("42$1 $2(.)(\\p{ upper})", (new FreemarkerVariable("42$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code 4242(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '4242(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturn4242PUpper() {
    // Arrange, Act and Assert
    assertEquals("4242(.)(\\p{ upper})", (new FreemarkerVariable("4242(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.$1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnForm12Name() {
    // Arrange, Act and Assert
    assertEquals("form.$1 $2 name", (new FreemarkerVariable("form.$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.$1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnForm12PUpper() {
    // Arrange, Act and Assert
    assertEquals("form.$1 $2(.)(\\p{ upper})", (new FreemarkerVariable("form.$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.42 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.42 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnForm42Name() {
    // Arrange, Act and Assert
    assertEquals("form.42 name", (new FreemarkerVariable("form.42Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.42(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.42(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnForm42PUpper() {
    // Arrange, Act and Assert
    assertEquals("form.42(.)(\\p{ upper})", (new FreemarkerVariable("form.42(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.form. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.form. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormFormName() {
    // Arrange, Act and Assert
    assertEquals("form.form. name", (new FreemarkerVariable("form.form.Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.form.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.form.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormFormPUpper() {
    // Arrange, Act and Assert
    assertEquals("form.form.(.)(\\p{ upper})", (new FreemarkerVariable("form.form.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.form. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.form. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormFormUu() {
    // Arrange, Act and Assert
    assertEquals("form.form. uu", (new FreemarkerVariable("form.form.UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. name$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. name$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormName12() {
    // Arrange, Act and Assert
    assertEquals("form. name$1 $2", (new FreemarkerVariable("form.Name$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormName42() {
    // Arrange, Act and Assert
    assertEquals("form. name42", (new FreemarkerVariable("form.Name42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. name name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. name name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormNameName() {
    // Arrange, Act and Assert
    assertEquals("form. name name", (new FreemarkerVariable("form.NameName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. name(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. name(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormNamePUpper() {
    // Arrange, Act and Assert
    assertEquals("form. name(.)(\\p{ upper})", (new FreemarkerVariable("form.Name(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. name uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. name uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormNameUu() {
    // Arrange, Act and Assert
    assertEquals("form. name uu", (new FreemarkerVariable("form.NameUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. nameform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. nameform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormNameform() {
    // Arrange, Act and Assert
    assertEquals("form. nameform.", (new FreemarkerVariable("form.Nameform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpper() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper})", (new FreemarkerVariable("form.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpper12() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper})$1 $2", (new FreemarkerVariable("form.(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpper42() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper})42", (new FreemarkerVariable("form.(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpperForm() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper})form.", (new FreemarkerVariable("form.(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpperName() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper}) name", (new FreemarkerVariable("form.(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("form.(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form.(.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form.(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormPUpperUu() {
    // Arrange, Act and Assert
    assertEquals("form.(.)(\\p{ upper}) uu", (new FreemarkerVariable("form.(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. uu name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. uu name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormUuName() {
    // Arrange, Act and Assert
    assertEquals("form. uu name", (new FreemarkerVariable("form.UUName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. uu(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. uu(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormUuPUpper() {
    // Arrange, Act and Assert
    assertEquals("form. uu(.)(\\p{ upper})", (new FreemarkerVariable("form.UU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code form. uuform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'form. uuform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnFormUuform() {
    // Arrange, Act and Assert
    assertEquals("form. uuform.", (new FreemarkerVariable("form.UUform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name$1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnName12Name() {
    // Arrange, Act and Assert
    assertEquals("name$1 $2 name", (new FreemarkerVariable("Name$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name$1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnName12PUpper() {
    // Arrange, Act and Assert
    assertEquals("name$1 $2(.)(\\p{ upper})", (new FreemarkerVariable("Name$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name42 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name42 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnName42Name() {
    // Arrange, Act and Assert
    assertEquals("name42 name", (new FreemarkerVariable("Name42Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name42(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name42(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnName42PUpper() {
    // Arrange, Act and Assert
    assertEquals("name42(.)(\\p{ upper})", (new FreemarkerVariable("Name42(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name name$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name name$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameName12() {
    // Arrange, Act and Assert
    assertEquals("name name$1 $2", (new FreemarkerVariable("NameName$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameName42() {
    // Arrange, Act and Assert
    assertEquals("name name42", (new FreemarkerVariable("NameName42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name name name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name name name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameNameName() {
    // Arrange, Act and Assert
    assertEquals("name name name", (new FreemarkerVariable("NameNameName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name name(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name name(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameNamePUpper() {
    // Arrange, Act and Assert
    assertEquals("name name(.)(\\p{ upper})", (new FreemarkerVariable("NameName(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name name uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name name uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameNameUu() {
    // Arrange, Act and Assert
    assertEquals("name name uu", (new FreemarkerVariable("NameNameUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name nameform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name nameform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameNameform() {
    // Arrange, Act and Assert
    assertEquals("name nameform.", (new FreemarkerVariable("NameNameform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpper() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper})", (new FreemarkerVariable("Name(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpper12() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper})$1 $2", (new FreemarkerVariable("Name(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpper42() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper})42", (new FreemarkerVariable("Name(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpperForm() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper})form.", (new FreemarkerVariable("Name(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpperName() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper}) name", (new FreemarkerVariable("Name(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("Name(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name(.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNamePUpperUu() {
    // Arrange, Act and Assert
    assertEquals("name(.)(\\p{ upper}) uu", (new FreemarkerVariable("Name(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name uu name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name uu name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameUuName() {
    // Arrange, Act and Assert
    assertEquals("name uu name", (new FreemarkerVariable("NameUUName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name uu(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name uu(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameUuPUpper() {
    // Arrange, Act and Assert
    assertEquals("name uu(.)(\\p{ upper})", (new FreemarkerVariable("NameUU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code name uuform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'name uuform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameUuform() {
    // Arrange, Act and Assert
    assertEquals("name uuform.", (new FreemarkerVariable("NameUUform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code nameform. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'nameform. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameformName() {
    // Arrange, Act and Assert
    assertEquals("nameform. name", (new FreemarkerVariable("Nameform.Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code nameform.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'nameform.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameformPUpper() {
    // Arrange, Act and Assert
    assertEquals("nameform.(.)(\\p{ upper})", (new FreemarkerVariable("Nameform.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code nameform. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'nameform. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnNameformUu() {
    // Arrange, Act and Assert
    assertEquals("nameform. uu", (new FreemarkerVariable("Nameform.UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})$1 $2 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})$1 $2 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper12Name() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $2 name", (new FreemarkerVariable("(.)(\\p{Upper})$1 $2Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})$1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper12PUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $2(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})$1 $2 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})$1 $2 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper12Uu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $2 uu", (new FreemarkerVariable("(.)(\\p{Upper})$1 $2UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})$1 $2form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})$1 $2form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper12form() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $2form.", (new FreemarkerVariable("(.)(\\p{Upper})$1 $2form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})42 name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})42 name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper42Name() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})42 name", (new FreemarkerVariable("(.)(\\p{Upper})42Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})42(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})42(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper42PUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})42(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})42(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})42 uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})42 uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper42Uu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})42 uu", (new FreemarkerVariable("(.)(\\p{Upper})42UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})42form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})42form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper42form() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})42form.", (new FreemarkerVariable("(.)(\\p{Upper})42form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})$1 $2$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})$1 $2$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper1212() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $2$1 $2", (new FreemarkerVariable("(.)(\\p{Upper})$1 $2$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})$1 $242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})$1 $242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper1242() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})$1 $242", (new FreemarkerVariable("(.)(\\p{Upper})$1 $242")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})42$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})42$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper4212() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})42$1 $2", (new FreemarkerVariable("(.)(\\p{Upper})42$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpper4242() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})4242", (new FreemarkerVariable("(.)(\\p{Upper})4242")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperForm() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form.", (new FreemarkerVariable("(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form.$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form.$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperForm12() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form.$1 $2", (new FreemarkerVariable("(.)(\\p{Upper})form.$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form.42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperForm42() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form.42", (new FreemarkerVariable("(.)(\\p{Upper})form.42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form.form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form.form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperFormForm() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form.form.", (new FreemarkerVariable("(.)(\\p{Upper})form.form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperFormName() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form. name", (new FreemarkerVariable("(.)(\\p{Upper})form.Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperFormPUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form.(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})form.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})form. uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})form. uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperFormUu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})form. uu", (new FreemarkerVariable("(.)(\\p{Upper})form.UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperName() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) name", (new FreemarkerVariable("(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) name$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) name$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperName12() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) name$1 $2", (new FreemarkerVariable("(.)(\\p{Upper})Name$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperName42() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) name42", (new FreemarkerVariable("(.)(\\p{Upper})Name42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) name name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) name name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperNameName() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) name name", (new FreemarkerVariable("(.)(\\p{Upper})NameName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) name(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) name(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperNamePUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) name(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})Name(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) name uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) name uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperNameUu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) name uu", (new FreemarkerVariable("(.)(\\p{Upper})NameUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) nameform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) nameform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperNameform() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) nameform.", (new FreemarkerVariable("(.)(\\p{Upper})Nameform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpper12() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})$1 $2",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpper42() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})42",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpperForm() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})form.",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpperName() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper}) name",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper})(.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper})(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperPUpperUu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper}) uu",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) uu$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) uu$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperUu12() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uu$1 $2", (new FreemarkerVariable("(.)(\\p{Upper})UU$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) uu42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) uu42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperUu42() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uu42", (new FreemarkerVariable("(.)(\\p{Upper})UU42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) uu name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) uu name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperUuName() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uu name", (new FreemarkerVariable("(.)(\\p{Upper})UUName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) uu(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) uu(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperUuPUpper() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uu(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})UU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) uu uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) uu uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperUuUu() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uu uu", (new FreemarkerVariable("(.)(\\p{Upper})UUUU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code (.)(\p{ upper}) uuform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return '(.)(\\p{ upper}) uuform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnPUpperUuform() {
    // Arrange, Act and Assert
    assertEquals("(.)(\\p{ upper}) uuform.", (new FreemarkerVariable("(.)(\\p{Upper})UUform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u$1 $2(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u$1 $2(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUU12PUpper() {
    // Arrange, Act and Assert
    assertEquals("u u$1 $2(.)(\\p{ upper})", (new FreemarkerVariable("UU$1 $2(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u42(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u42(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUU42PUpper() {
    // Arrange, Act and Assert
    assertEquals("u u42(.)(\\p{ upper})", (new FreemarkerVariable("UU42(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u(.)(\p{ upper})$1 $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u(.)(\\p{ upper})$1 $2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUPUpper12() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper})$1 $2", (new FreemarkerVariable("UU(.)(\\p{Upper})$1 $2")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u(.)(\p{ upper})42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u(.)(\\p{ upper})42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUPUpper42() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper})42", (new FreemarkerVariable("UU(.)(\\p{Upper})42")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u(.)(\p{ upper})form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u(.)(\\p{ upper})form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUPUpperForm() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper})form.", (new FreemarkerVariable("UU(.)(\\p{Upper})form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u(.)(\p{ upper}) name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u(.)(\\p{ upper}) name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUPUpperName() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper}) name", (new FreemarkerVariable("UU(.)(\\p{Upper})Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u(.)(\p{ upper})(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u(.)(\\p{ upper})(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUPUpperPUpper() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("UU(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u u(.)(\p{ upper}) uu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u u(.)(\\p{ upper}) uu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUPUpperUu() {
    // Arrange, Act and Assert
    assertEquals("u u(.)(\\p{ upper}) uu", (new FreemarkerVariable("UU(.)(\\p{Upper})UU")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u uform.form.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u uform.form.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUformForm() {
    // Arrange, Act and Assert
    assertEquals("u uform.form.", (new FreemarkerVariable("UUform.form.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u uform. name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u uform. name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUformName() {
    // Arrange, Act and Assert
    assertEquals("u uform. name", (new FreemarkerVariable("UUform.Name")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u uform.(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u uform.(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUformPUpper() {
    // Arrange, Act and Assert
    assertEquals("u uform.(.)(\\p{ upper})", (new FreemarkerVariable("UUform.(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u uname name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u uname name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUnameName() {
    // Arrange, Act and Assert
    assertEquals("u uname name", (new FreemarkerVariable("UUNameName")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u uname(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u uname(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUnamePUpper() {
    // Arrange, Act and Assert
    assertEquals("u uname(.)(\\p{ upper})", (new FreemarkerVariable("UUName(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u unameform.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u unameform.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUnameform() {
    // Arrange, Act and Assert
    assertEquals("u unameform.", (new FreemarkerVariable("UUNameform.")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getDisplayName()}.
   * <ul>
   *   <li>Then return {@code u uu u(.)(\p{ upper})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); then return 'u uu u(.)(\\p{ upper})'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDisplayName()"})
  void testGetDisplayName_thenReturnUUuUPUpper() {
    // Arrange, Act and Assert
    assertEquals("u uu u(.)(\\p{ upper})", (new FreemarkerVariable("UUUU(.)(\\p{Upper})")).getDisplayName());
  }

  /**
   * Test {@link FreemarkerVariable#getFormFieldName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with name is {@code form.}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getFormFieldName()}
   */
  @Test
  @DisplayName("Test getFormFieldName(); given FreemarkerVariable(String) with name is 'form.'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getFormFieldName()"})
  void testGetFormFieldName_givenFreemarkerVariableWithNameIsForm_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new FreemarkerVariable("form.")).getFormFieldName());
  }

  /**
   * Test {@link FreemarkerVariable#getFormFieldName()}.
   * <ul>
   *   <li>Given {@link FreemarkerVariable#FreemarkerVariable(String)} with {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerVariable#getFormFieldName()}
   */
  @Test
  @DisplayName("Test getFormFieldName(); given FreemarkerVariable(String) with 'Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getFormFieldName()"})
  void testGetFormFieldName_givenFreemarkerVariableWithName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new FreemarkerVariable("Name")).getFormFieldName());
  }

  /**
   * Test {@link FreemarkerVariable#getDataPath()}.
   * <p>
   * Method under test: {@link FreemarkerVariable#getDataPath()}
   */
  @Test
  @DisplayName("Test getDataPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getDataPath()"})
  void testGetDataPath() {
    // Arrange, Act and Assert
    assertEquals("Name", (new FreemarkerVariable("Name")).getDataPath());
  }

  /**
   * Test {@link FreemarkerVariable#getErrorPath()}.
   * <p>
   * Method under test: {@link FreemarkerVariable#getErrorPath()}
   */
  @Test
  @DisplayName("Test getErrorPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.symphony.templating.FreemarkerVariable.getErrorPath()"})
  void testGetErrorPath() {
    // Arrange, Act and Assert
    assertEquals("Name.error", (new FreemarkerVariable("Name")).getErrorPath());
  }
}
