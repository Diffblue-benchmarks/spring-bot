package org.finos.springbot.teams.templating.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ThymeleafVariableDiffblueTest {
  /**
   * Method under test: {@link ThymeleafVariable#field(String)}
   */
  @Test
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
   * Method under test: {@link ThymeleafVariable#getDisplayName()}
   */
  @Test
  void testGetDisplayName() {
    // Arrange, Act and Assert
    assertEquals("name", (new ThymeleafVariable("Name")).getDisplayName());
    assertEquals("u u", (new ThymeleafVariable("UU")).getDisplayName());
    assertEquals("(.)(\\p{ upper})", (new ThymeleafVariable("(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u uu u", (new ThymeleafVariable("UUUU")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper})", (new ThymeleafVariable("UU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u u$1 $2", (new ThymeleafVariable("UU$1 $2")).getDisplayName());
    assertEquals("u uname", (new ThymeleafVariable("UUName")).getDisplayName());
    assertEquals("u uform.", (new ThymeleafVariable("UUform.")).getDisplayName());
    assertEquals("u u42", (new ThymeleafVariable("UU42")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uu", (new ThymeleafVariable("(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $2", (new ThymeleafVariable("(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) name", (new ThymeleafVariable("(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form.", (new ThymeleafVariable("(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("(.)(\\p{ upper})42", (new ThymeleafVariable("(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("$1 $2 uu", (new ThymeleafVariable("$1 $2UU")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper})", (new ThymeleafVariable("$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $2 name", (new ThymeleafVariable("$1 $2Name")).getDisplayName());
    assertEquals("name uu", (new ThymeleafVariable("NameUU")).getDisplayName());
    assertEquals("name(.)(\\p{ upper})", (new ThymeleafVariable("Name(.)(\\p{Upper})")).getDisplayName());
    assertEquals("name name", (new ThymeleafVariable("NameName")).getDisplayName());
    assertEquals("form. uu", (new ThymeleafVariable("form.UU")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper})", (new ThymeleafVariable("form.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form. name", (new ThymeleafVariable("form.Name")).getDisplayName());
    assertEquals("42 uu", (new ThymeleafVariable("42UU")).getDisplayName());
    assertEquals("42(.)(\\p{ upper})", (new ThymeleafVariable("42(.)(\\p{Upper})")).getDisplayName());
    assertEquals("42 name", (new ThymeleafVariable("42Name")).getDisplayName());
    assertEquals("u uu uu u", (new ThymeleafVariable("UUUUUU")).getDisplayName());
    assertEquals("u uu u(.)(\\p{ upper})", (new ThymeleafVariable("UUUU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u uu u$1 $2", (new ThymeleafVariable("UUUU$1 $2")).getDisplayName());
    assertEquals("u uu uname", (new ThymeleafVariable("UUUUName")).getDisplayName());
    assertEquals("u uu uform.", (new ThymeleafVariable("UUUUform.")).getDisplayName());
    assertEquals("u uu u42", (new ThymeleafVariable("UUUU42")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper}) uu", (new ThymeleafVariable("UU(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("UU(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper})$1 $2", (new ThymeleafVariable("UU(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper}) name", (new ThymeleafVariable("UU(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper})form.", (new ThymeleafVariable("UU(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper})42", (new ThymeleafVariable("UU(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("u u$1 $2 uu", (new ThymeleafVariable("UU$1 $2UU")).getDisplayName());
    assertEquals("u u$1 $2(.)(\\p{ upper})", (new ThymeleafVariable("UU$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u u$1 $2$1 $2", (new ThymeleafVariable("UU$1 $2$1 $2")).getDisplayName());
    assertEquals("u u$1 $2 name", (new ThymeleafVariable("UU$1 $2Name")).getDisplayName());
    assertEquals("u u$1 $2form.", (new ThymeleafVariable("UU$1 $2form.")).getDisplayName());
    assertEquals("u u$1 $242", (new ThymeleafVariable("UU$1 $242")).getDisplayName());
    assertEquals("u uname uu", (new ThymeleafVariable("UUNameUU")).getDisplayName());
    assertEquals("u uname(.)(\\p{ upper})", (new ThymeleafVariable("UUName(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u uname$1 $2", (new ThymeleafVariable("UUName$1 $2")).getDisplayName());
    assertEquals("u uname name", (new ThymeleafVariable("UUNameName")).getDisplayName());
    assertEquals("u unameform.", (new ThymeleafVariable("UUNameform.")).getDisplayName());
    assertEquals("u uname42", (new ThymeleafVariable("UUName42")).getDisplayName());
    assertEquals("u uform. uu", (new ThymeleafVariable("UUform.UU")).getDisplayName());
    assertEquals("u uform.(.)(\\p{ upper})", (new ThymeleafVariable("UUform.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u uform.$1 $2", (new ThymeleafVariable("UUform.$1 $2")).getDisplayName());
    assertEquals("u uform. name", (new ThymeleafVariable("UUform.Name")).getDisplayName());
    assertEquals("u uform.form.", (new ThymeleafVariable("UUform.form.")).getDisplayName());
    assertEquals("u uform.42", (new ThymeleafVariable("UUform.42")).getDisplayName());
    assertEquals("u u42 uu", (new ThymeleafVariable("UU42UU")).getDisplayName());
    assertEquals("u u42(.)(\\p{ upper})", (new ThymeleafVariable("UU42(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u u42$1 $2", (new ThymeleafVariable("UU42$1 $2")).getDisplayName());
    assertEquals("u u42 name", (new ThymeleafVariable("UU42Name")).getDisplayName());
    assertEquals("u u42form.", (new ThymeleafVariable("UU42form.")).getDisplayName());
    assertEquals("u u4242", (new ThymeleafVariable("UU4242")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uu uu", (new ThymeleafVariable("(.)(\\p{Upper})UUUU")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uu(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})UU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uu$1 $2", (new ThymeleafVariable("(.)(\\p{Upper})UU$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uu name", (new ThymeleafVariable("(.)(\\p{Upper})UUName")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uuform.", (new ThymeleafVariable("(.)(\\p{Upper})UUform.")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uu42", (new ThymeleafVariable("(.)(\\p{Upper})UU42")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper}) uu",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})$1 $2",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper}) name",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})form.",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})42",
        (new ThymeleafVariable("(.)(\\p{Upper})(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $2 uu", (new ThymeleafVariable("(.)(\\p{Upper})$1 $2UU")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $2(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $2$1 $2", (new ThymeleafVariable("(.)(\\p{Upper})$1 $2$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $2 name", (new ThymeleafVariable("(.)(\\p{Upper})$1 $2Name")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $2form.", (new ThymeleafVariable("(.)(\\p{Upper})$1 $2form.")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $242", (new ThymeleafVariable("(.)(\\p{Upper})$1 $242")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) name uu", (new ThymeleafVariable("(.)(\\p{Upper})NameUU")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) name(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})Name(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) name$1 $2", (new ThymeleafVariable("(.)(\\p{Upper})Name$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) name name", (new ThymeleafVariable("(.)(\\p{Upper})NameName")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) nameform.", (new ThymeleafVariable("(.)(\\p{Upper})Nameform.")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) name42", (new ThymeleafVariable("(.)(\\p{Upper})Name42")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form. uu", (new ThymeleafVariable("(.)(\\p{Upper})form.UU")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form.(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})form.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form.$1 $2", (new ThymeleafVariable("(.)(\\p{Upper})form.$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form. name", (new ThymeleafVariable("(.)(\\p{Upper})form.Name")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form.form.", (new ThymeleafVariable("(.)(\\p{Upper})form.form.")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form.42", (new ThymeleafVariable("(.)(\\p{Upper})form.42")).getDisplayName());
    assertEquals("(.)(\\p{ upper})42 uu", (new ThymeleafVariable("(.)(\\p{Upper})42UU")).getDisplayName());
    assertEquals("(.)(\\p{ upper})42(.)(\\p{ upper})",
        (new ThymeleafVariable("(.)(\\p{Upper})42(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper})42$1 $2", (new ThymeleafVariable("(.)(\\p{Upper})42$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper})42 name", (new ThymeleafVariable("(.)(\\p{Upper})42Name")).getDisplayName());
    assertEquals("(.)(\\p{ upper})42form.", (new ThymeleafVariable("(.)(\\p{Upper})42form.")).getDisplayName());
    assertEquals("(.)(\\p{ upper})4242", (new ThymeleafVariable("(.)(\\p{Upper})4242")).getDisplayName());
    assertEquals("$1 $2 uu uu", (new ThymeleafVariable("$1 $2UUUU")).getDisplayName());
    assertEquals("$1 $2 uu(.)(\\p{ upper})", (new ThymeleafVariable("$1 $2UU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $2 uu$1 $2", (new ThymeleafVariable("$1 $2UU$1 $2")).getDisplayName());
    assertEquals("$1 $2 uu name", (new ThymeleafVariable("$1 $2UUName")).getDisplayName());
    assertEquals("$1 $2 uuform.", (new ThymeleafVariable("$1 $2UUform.")).getDisplayName());
    assertEquals("$1 $2 uu42", (new ThymeleafVariable("$1 $2UU42")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper}) uu", (new ThymeleafVariable("$1 $2(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("$1 $2(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper})$1 $2", (new ThymeleafVariable("$1 $2(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper}) name", (new ThymeleafVariable("$1 $2(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper})form.", (new ThymeleafVariable("$1 $2(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper})42", (new ThymeleafVariable("$1 $2(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("$1 $2$1 $2 uu", (new ThymeleafVariable("$1 $2$1 $2UU")).getDisplayName());
    assertEquals("$1 $2$1 $2(.)(\\p{ upper})", (new ThymeleafVariable("$1 $2$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $2$1 $2 name", (new ThymeleafVariable("$1 $2$1 $2Name")).getDisplayName());
    assertEquals("$1 $2 name uu", (new ThymeleafVariable("$1 $2NameUU")).getDisplayName());
    assertEquals("$1 $2 name(.)(\\p{ upper})", (new ThymeleafVariable("$1 $2Name(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $2 name$1 $2", (new ThymeleafVariable("$1 $2Name$1 $2")).getDisplayName());
    assertEquals("$1 $2 name name", (new ThymeleafVariable("$1 $2NameName")).getDisplayName());
    assertEquals("$1 $2 nameform.", (new ThymeleafVariable("$1 $2Nameform.")).getDisplayName());
    assertEquals("$1 $2 name42", (new ThymeleafVariable("$1 $2Name42")).getDisplayName());
    assertEquals("$1 $2form. uu", (new ThymeleafVariable("$1 $2form.UU")).getDisplayName());
    assertEquals("$1 $2form.(.)(\\p{ upper})", (new ThymeleafVariable("$1 $2form.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $2form. name", (new ThymeleafVariable("$1 $2form.Name")).getDisplayName());
    assertEquals("$1 $242 uu", (new ThymeleafVariable("$1 $242UU")).getDisplayName());
    assertEquals("$1 $242(.)(\\p{ upper})", (new ThymeleafVariable("$1 $242(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $242 name", (new ThymeleafVariable("$1 $242Name")).getDisplayName());
    assertEquals("name uu uu", (new ThymeleafVariable("NameUUUU")).getDisplayName());
    assertEquals("name uu(.)(\\p{ upper})", (new ThymeleafVariable("NameUU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("name uu$1 $2", (new ThymeleafVariable("NameUU$1 $2")).getDisplayName());
    assertEquals("name uu name", (new ThymeleafVariable("NameUUName")).getDisplayName());
    assertEquals("name uuform.", (new ThymeleafVariable("NameUUform.")).getDisplayName());
    assertEquals("name uu42", (new ThymeleafVariable("NameUU42")).getDisplayName());
    assertEquals("name(.)(\\p{ upper}) uu", (new ThymeleafVariable("Name(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("name(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("Name(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("name(.)(\\p{ upper})$1 $2", (new ThymeleafVariable("Name(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("name(.)(\\p{ upper}) name", (new ThymeleafVariable("Name(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("name(.)(\\p{ upper})form.", (new ThymeleafVariable("Name(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("name(.)(\\p{ upper})42", (new ThymeleafVariable("Name(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("name$1 $2 uu", (new ThymeleafVariable("Name$1 $2UU")).getDisplayName());
    assertEquals("name$1 $2(.)(\\p{ upper})", (new ThymeleafVariable("Name$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("name$1 $2 name", (new ThymeleafVariable("Name$1 $2Name")).getDisplayName());
    assertEquals("name name uu", (new ThymeleafVariable("NameNameUU")).getDisplayName());
    assertEquals("name name(.)(\\p{ upper})", (new ThymeleafVariable("NameName(.)(\\p{Upper})")).getDisplayName());
    assertEquals("name name$1 $2", (new ThymeleafVariable("NameName$1 $2")).getDisplayName());
    assertEquals("name name name", (new ThymeleafVariable("NameNameName")).getDisplayName());
    assertEquals("name nameform.", (new ThymeleafVariable("NameNameform.")).getDisplayName());
    assertEquals("name name42", (new ThymeleafVariable("NameName42")).getDisplayName());
    assertEquals("nameform. uu", (new ThymeleafVariable("Nameform.UU")).getDisplayName());
    assertEquals("nameform.(.)(\\p{ upper})", (new ThymeleafVariable("Nameform.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("nameform. name", (new ThymeleafVariable("Nameform.Name")).getDisplayName());
    assertEquals("name42 uu", (new ThymeleafVariable("Name42UU")).getDisplayName());
    assertEquals("name42(.)(\\p{ upper})", (new ThymeleafVariable("Name42(.)(\\p{Upper})")).getDisplayName());
    assertEquals("name42 name", (new ThymeleafVariable("Name42Name")).getDisplayName());
    assertEquals("form. uu uu", (new ThymeleafVariable("form.UUUU")).getDisplayName());
    assertEquals("form. uu(.)(\\p{ upper})", (new ThymeleafVariable("form.UU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form. uu$1 $2", (new ThymeleafVariable("form.UU$1 $2")).getDisplayName());
    assertEquals("form. uu name", (new ThymeleafVariable("form.UUName")).getDisplayName());
    assertEquals("form. uuform.", (new ThymeleafVariable("form.UUform.")).getDisplayName());
    assertEquals("form. uu42", (new ThymeleafVariable("form.UU42")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper}) uu", (new ThymeleafVariable("form.(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("form.(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper})$1 $2", (new ThymeleafVariable("form.(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper}) name", (new ThymeleafVariable("form.(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper})form.", (new ThymeleafVariable("form.(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper})42", (new ThymeleafVariable("form.(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("form.$1 $2 uu", (new ThymeleafVariable("form.$1 $2UU")).getDisplayName());
    assertEquals("form.$1 $2(.)(\\p{ upper})", (new ThymeleafVariable("form.$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form.$1 $2 name", (new ThymeleafVariable("form.$1 $2Name")).getDisplayName());
    assertEquals("form. name uu", (new ThymeleafVariable("form.NameUU")).getDisplayName());
    assertEquals("form. name(.)(\\p{ upper})", (new ThymeleafVariable("form.Name(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form. name$1 $2", (new ThymeleafVariable("form.Name$1 $2")).getDisplayName());
    assertEquals("form. name name", (new ThymeleafVariable("form.NameName")).getDisplayName());
    assertEquals("form. nameform.", (new ThymeleafVariable("form.Nameform.")).getDisplayName());
    assertEquals("form. name42", (new ThymeleafVariable("form.Name42")).getDisplayName());
    assertEquals("form.form. uu", (new ThymeleafVariable("form.form.UU")).getDisplayName());
    assertEquals("form.form.(.)(\\p{ upper})", (new ThymeleafVariable("form.form.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form.form. name", (new ThymeleafVariable("form.form.Name")).getDisplayName());
    assertEquals("form.42 uu", (new ThymeleafVariable("form.42UU")).getDisplayName());
    assertEquals("form.42(.)(\\p{ upper})", (new ThymeleafVariable("form.42(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form.42 name", (new ThymeleafVariable("form.42Name")).getDisplayName());
    assertEquals("42 uu uu", (new ThymeleafVariable("42UUUU")).getDisplayName());
    assertEquals("42 uu(.)(\\p{ upper})", (new ThymeleafVariable("42UU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("42 uu$1 $2", (new ThymeleafVariable("42UU$1 $2")).getDisplayName());
    assertEquals("42 uu name", (new ThymeleafVariable("42UUName")).getDisplayName());
    assertEquals("42 uuform.", (new ThymeleafVariable("42UUform.")).getDisplayName());
    assertEquals("42 uu42", (new ThymeleafVariable("42UU42")).getDisplayName());
    assertEquals("42(.)(\\p{ upper}) uu", (new ThymeleafVariable("42(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("42(.)(\\p{ upper})(.)(\\p{ upper})",
        (new ThymeleafVariable("42(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("42(.)(\\p{ upper})$1 $2", (new ThymeleafVariable("42(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("42(.)(\\p{ upper}) name", (new ThymeleafVariable("42(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("42(.)(\\p{ upper})form.", (new ThymeleafVariable("42(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("42(.)(\\p{ upper})42", (new ThymeleafVariable("42(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("42$1 $2 uu", (new ThymeleafVariable("42$1 $2UU")).getDisplayName());
    assertEquals("42$1 $2(.)(\\p{ upper})", (new ThymeleafVariable("42$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("42$1 $2 name", (new ThymeleafVariable("42$1 $2Name")).getDisplayName());
    assertEquals("42 name uu", (new ThymeleafVariable("42NameUU")).getDisplayName());
    assertEquals("42 name(.)(\\p{ upper})", (new ThymeleafVariable("42Name(.)(\\p{Upper})")).getDisplayName());
    assertEquals("42 name$1 $2", (new ThymeleafVariable("42Name$1 $2")).getDisplayName());
    assertEquals("42 name name", (new ThymeleafVariable("42NameName")).getDisplayName());
    assertEquals("42 nameform.", (new ThymeleafVariable("42Nameform.")).getDisplayName());
    assertEquals("42 name42", (new ThymeleafVariable("42Name42")).getDisplayName());
    assertEquals("42form. uu", (new ThymeleafVariable("42form.UU")).getDisplayName());
    assertEquals("42form.(.)(\\p{ upper})", (new ThymeleafVariable("42form.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("42form. name", (new ThymeleafVariable("42form.Name")).getDisplayName());
    assertEquals("4242 uu", (new ThymeleafVariable("4242UU")).getDisplayName());
    assertEquals("4242(.)(\\p{ upper})", (new ThymeleafVariable("4242(.)(\\p{Upper})")).getDisplayName());
    assertEquals("4242 name", (new ThymeleafVariable("4242Name")).getDisplayName());
  }

  /**
   * Method under test: {@link ThymeleafVariable#getFormFieldName()}
   */
  @Test
  void testGetFormFieldName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new ThymeleafVariable("Name")).getFormFieldName());
    assertEquals("", (new ThymeleafVariable("form.")).getFormFieldName());
  }

  /**
   * Method under test: {@link ThymeleafVariable#getDataPath()}
   */
  @Test
  void testGetDataPath() {
    // Arrange, Act and Assert
    assertEquals("Name", (new ThymeleafVariable("Name")).getDataPath());
  }

  /**
   * Method under test: {@link ThymeleafVariable#getErrorPath()}
   */
  @Test
  void testGetErrorPath() {
    // Arrange, Act and Assert
    assertEquals("Name?.error", (new ThymeleafVariable("Name")).getErrorPath());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ThymeleafVariable#ThymeleafVariable(String)}
   *   <li>{@link ThymeleafVariable#toString()}
   *   <li>{@link ThymeleafVariable#getDepth()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ThymeleafVariable actualThymeleafVariable = new ThymeleafVariable("Name");
    String actualToStringResult = actualThymeleafVariable.toString();

    // Assert
    assertEquals("Name", actualToStringResult);
    assertEquals(1, actualThymeleafVariable.getDepth());
  }
}
