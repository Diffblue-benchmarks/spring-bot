package org.finos.springbot.symphony.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FreemarkerVariableDiffblueTest {
  /**
   * Method under test: {@link FreemarkerVariable#field(String)}
   */
  @Test
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
   * Method under test: {@link FreemarkerVariable#getDisplayName()}
   */
  @Test
  void testGetDisplayName() {
    // Arrange, Act and Assert
    assertEquals("name", (new FreemarkerVariable("Name")).getDisplayName());
    assertEquals("u u", (new FreemarkerVariable("UU")).getDisplayName());
    assertEquals("(.)(\\p{ upper})", (new FreemarkerVariable("(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u uu u", (new FreemarkerVariable("UUUU")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper})", (new FreemarkerVariable("UU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u u$1 $2", (new FreemarkerVariable("UU$1 $2")).getDisplayName());
    assertEquals("u uname", (new FreemarkerVariable("UUName")).getDisplayName());
    assertEquals("u uform.", (new FreemarkerVariable("UUform.")).getDisplayName());
    assertEquals("u u42", (new FreemarkerVariable("UU42")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uu", (new FreemarkerVariable("(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $2", (new FreemarkerVariable("(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) name", (new FreemarkerVariable("(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form.", (new FreemarkerVariable("(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("(.)(\\p{ upper})42", (new FreemarkerVariable("(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("$1 $2 uu", (new FreemarkerVariable("$1 $2UU")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper})", (new FreemarkerVariable("$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $2 name", (new FreemarkerVariable("$1 $2Name")).getDisplayName());
    assertEquals("name uu", (new FreemarkerVariable("NameUU")).getDisplayName());
    assertEquals("name(.)(\\p{ upper})", (new FreemarkerVariable("Name(.)(\\p{Upper})")).getDisplayName());
    assertEquals("name name", (new FreemarkerVariable("NameName")).getDisplayName());
    assertEquals("form. uu", (new FreemarkerVariable("form.UU")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper})", (new FreemarkerVariable("form.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form. name", (new FreemarkerVariable("form.Name")).getDisplayName());
    assertEquals("42 uu", (new FreemarkerVariable("42UU")).getDisplayName());
    assertEquals("42(.)(\\p{ upper})", (new FreemarkerVariable("42(.)(\\p{Upper})")).getDisplayName());
    assertEquals("42 name", (new FreemarkerVariable("42Name")).getDisplayName());
    assertEquals("u uu uu u", (new FreemarkerVariable("UUUUUU")).getDisplayName());
    assertEquals("u uu u(.)(\\p{ upper})", (new FreemarkerVariable("UUUU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u uu u$1 $2", (new FreemarkerVariable("UUUU$1 $2")).getDisplayName());
    assertEquals("u uu uname", (new FreemarkerVariable("UUUUName")).getDisplayName());
    assertEquals("u uu uform.", (new FreemarkerVariable("UUUUform.")).getDisplayName());
    assertEquals("u uu u42", (new FreemarkerVariable("UUUU42")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper}) uu", (new FreemarkerVariable("UU(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("UU(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper})$1 $2", (new FreemarkerVariable("UU(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper}) name", (new FreemarkerVariable("UU(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper})form.", (new FreemarkerVariable("UU(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("u u(.)(\\p{ upper})42", (new FreemarkerVariable("UU(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("u u$1 $2 uu", (new FreemarkerVariable("UU$1 $2UU")).getDisplayName());
    assertEquals("u u$1 $2(.)(\\p{ upper})", (new FreemarkerVariable("UU$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u u$1 $2$1 $2", (new FreemarkerVariable("UU$1 $2$1 $2")).getDisplayName());
    assertEquals("u u$1 $2 name", (new FreemarkerVariable("UU$1 $2Name")).getDisplayName());
    assertEquals("u u$1 $2form.", (new FreemarkerVariable("UU$1 $2form.")).getDisplayName());
    assertEquals("u u$1 $242", (new FreemarkerVariable("UU$1 $242")).getDisplayName());
    assertEquals("u uname uu", (new FreemarkerVariable("UUNameUU")).getDisplayName());
    assertEquals("u uname(.)(\\p{ upper})", (new FreemarkerVariable("UUName(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u uname$1 $2", (new FreemarkerVariable("UUName$1 $2")).getDisplayName());
    assertEquals("u uname name", (new FreemarkerVariable("UUNameName")).getDisplayName());
    assertEquals("u unameform.", (new FreemarkerVariable("UUNameform.")).getDisplayName());
    assertEquals("u uname42", (new FreemarkerVariable("UUName42")).getDisplayName());
    assertEquals("u uform. uu", (new FreemarkerVariable("UUform.UU")).getDisplayName());
    assertEquals("u uform.(.)(\\p{ upper})", (new FreemarkerVariable("UUform.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u uform.$1 $2", (new FreemarkerVariable("UUform.$1 $2")).getDisplayName());
    assertEquals("u uform. name", (new FreemarkerVariable("UUform.Name")).getDisplayName());
    assertEquals("u uform.form.", (new FreemarkerVariable("UUform.form.")).getDisplayName());
    assertEquals("u uform.42", (new FreemarkerVariable("UUform.42")).getDisplayName());
    assertEquals("u u42 uu", (new FreemarkerVariable("UU42UU")).getDisplayName());
    assertEquals("u u42(.)(\\p{ upper})", (new FreemarkerVariable("UU42(.)(\\p{Upper})")).getDisplayName());
    assertEquals("u u42$1 $2", (new FreemarkerVariable("UU42$1 $2")).getDisplayName());
    assertEquals("u u42 name", (new FreemarkerVariable("UU42Name")).getDisplayName());
    assertEquals("u u42form.", (new FreemarkerVariable("UU42form.")).getDisplayName());
    assertEquals("u u4242", (new FreemarkerVariable("UU4242")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uu uu", (new FreemarkerVariable("(.)(\\p{Upper})UUUU")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uu(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})UU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uu$1 $2", (new FreemarkerVariable("(.)(\\p{Upper})UU$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uu name", (new FreemarkerVariable("(.)(\\p{Upper})UUName")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uuform.", (new FreemarkerVariable("(.)(\\p{Upper})UUform.")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) uu42", (new FreemarkerVariable("(.)(\\p{Upper})UU42")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper}) uu",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})$1 $2",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper}) name",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})form.",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("(.)(\\p{ upper})(.)(\\p{ upper})42",
        (new FreemarkerVariable("(.)(\\p{Upper})(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $2 uu", (new FreemarkerVariable("(.)(\\p{Upper})$1 $2UU")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $2(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $2$1 $2", (new FreemarkerVariable("(.)(\\p{Upper})$1 $2$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $2 name", (new FreemarkerVariable("(.)(\\p{Upper})$1 $2Name")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $2form.", (new FreemarkerVariable("(.)(\\p{Upper})$1 $2form.")).getDisplayName());
    assertEquals("(.)(\\p{ upper})$1 $242", (new FreemarkerVariable("(.)(\\p{Upper})$1 $242")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) name uu", (new FreemarkerVariable("(.)(\\p{Upper})NameUU")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) name(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})Name(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) name$1 $2", (new FreemarkerVariable("(.)(\\p{Upper})Name$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) name name", (new FreemarkerVariable("(.)(\\p{Upper})NameName")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) nameform.", (new FreemarkerVariable("(.)(\\p{Upper})Nameform.")).getDisplayName());
    assertEquals("(.)(\\p{ upper}) name42", (new FreemarkerVariable("(.)(\\p{Upper})Name42")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form. uu", (new FreemarkerVariable("(.)(\\p{Upper})form.UU")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form.(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})form.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form.$1 $2", (new FreemarkerVariable("(.)(\\p{Upper})form.$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form. name", (new FreemarkerVariable("(.)(\\p{Upper})form.Name")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form.form.", (new FreemarkerVariable("(.)(\\p{Upper})form.form.")).getDisplayName());
    assertEquals("(.)(\\p{ upper})form.42", (new FreemarkerVariable("(.)(\\p{Upper})form.42")).getDisplayName());
    assertEquals("(.)(\\p{ upper})42 uu", (new FreemarkerVariable("(.)(\\p{Upper})42UU")).getDisplayName());
    assertEquals("(.)(\\p{ upper})42(.)(\\p{ upper})",
        (new FreemarkerVariable("(.)(\\p{Upper})42(.)(\\p{Upper})")).getDisplayName());
    assertEquals("(.)(\\p{ upper})42$1 $2", (new FreemarkerVariable("(.)(\\p{Upper})42$1 $2")).getDisplayName());
    assertEquals("(.)(\\p{ upper})42 name", (new FreemarkerVariable("(.)(\\p{Upper})42Name")).getDisplayName());
    assertEquals("(.)(\\p{ upper})42form.", (new FreemarkerVariable("(.)(\\p{Upper})42form.")).getDisplayName());
    assertEquals("(.)(\\p{ upper})4242", (new FreemarkerVariable("(.)(\\p{Upper})4242")).getDisplayName());
    assertEquals("$1 $2 uu uu", (new FreemarkerVariable("$1 $2UUUU")).getDisplayName());
    assertEquals("$1 $2 uu(.)(\\p{ upper})", (new FreemarkerVariable("$1 $2UU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $2 uu$1 $2", (new FreemarkerVariable("$1 $2UU$1 $2")).getDisplayName());
    assertEquals("$1 $2 uu name", (new FreemarkerVariable("$1 $2UUName")).getDisplayName());
    assertEquals("$1 $2 uuform.", (new FreemarkerVariable("$1 $2UUform.")).getDisplayName());
    assertEquals("$1 $2 uu42", (new FreemarkerVariable("$1 $2UU42")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper}) uu", (new FreemarkerVariable("$1 $2(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("$1 $2(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper})$1 $2", (new FreemarkerVariable("$1 $2(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper}) name", (new FreemarkerVariable("$1 $2(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper})form.", (new FreemarkerVariable("$1 $2(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("$1 $2(.)(\\p{ upper})42", (new FreemarkerVariable("$1 $2(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("$1 $2$1 $2 uu", (new FreemarkerVariable("$1 $2$1 $2UU")).getDisplayName());
    assertEquals("$1 $2$1 $2(.)(\\p{ upper})", (new FreemarkerVariable("$1 $2$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $2$1 $2 name", (new FreemarkerVariable("$1 $2$1 $2Name")).getDisplayName());
    assertEquals("$1 $2 name uu", (new FreemarkerVariable("$1 $2NameUU")).getDisplayName());
    assertEquals("$1 $2 name(.)(\\p{ upper})", (new FreemarkerVariable("$1 $2Name(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $2 name$1 $2", (new FreemarkerVariable("$1 $2Name$1 $2")).getDisplayName());
    assertEquals("$1 $2 name name", (new FreemarkerVariable("$1 $2NameName")).getDisplayName());
    assertEquals("$1 $2 nameform.", (new FreemarkerVariable("$1 $2Nameform.")).getDisplayName());
    assertEquals("$1 $2 name42", (new FreemarkerVariable("$1 $2Name42")).getDisplayName());
    assertEquals("$1 $2form. uu", (new FreemarkerVariable("$1 $2form.UU")).getDisplayName());
    assertEquals("$1 $2form.(.)(\\p{ upper})", (new FreemarkerVariable("$1 $2form.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $2form. name", (new FreemarkerVariable("$1 $2form.Name")).getDisplayName());
    assertEquals("$1 $242 uu", (new FreemarkerVariable("$1 $242UU")).getDisplayName());
    assertEquals("$1 $242(.)(\\p{ upper})", (new FreemarkerVariable("$1 $242(.)(\\p{Upper})")).getDisplayName());
    assertEquals("$1 $242 name", (new FreemarkerVariable("$1 $242Name")).getDisplayName());
    assertEquals("name uu uu", (new FreemarkerVariable("NameUUUU")).getDisplayName());
    assertEquals("name uu(.)(\\p{ upper})", (new FreemarkerVariable("NameUU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("name uu$1 $2", (new FreemarkerVariable("NameUU$1 $2")).getDisplayName());
    assertEquals("name uu name", (new FreemarkerVariable("NameUUName")).getDisplayName());
    assertEquals("name uuform.", (new FreemarkerVariable("NameUUform.")).getDisplayName());
    assertEquals("name uu42", (new FreemarkerVariable("NameUU42")).getDisplayName());
    assertEquals("name(.)(\\p{ upper}) uu", (new FreemarkerVariable("Name(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("name(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("Name(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("name(.)(\\p{ upper})$1 $2", (new FreemarkerVariable("Name(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("name(.)(\\p{ upper}) name", (new FreemarkerVariable("Name(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("name(.)(\\p{ upper})form.", (new FreemarkerVariable("Name(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("name(.)(\\p{ upper})42", (new FreemarkerVariable("Name(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("name$1 $2 uu", (new FreemarkerVariable("Name$1 $2UU")).getDisplayName());
    assertEquals("name$1 $2(.)(\\p{ upper})", (new FreemarkerVariable("Name$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("name$1 $2 name", (new FreemarkerVariable("Name$1 $2Name")).getDisplayName());
    assertEquals("name name uu", (new FreemarkerVariable("NameNameUU")).getDisplayName());
    assertEquals("name name(.)(\\p{ upper})", (new FreemarkerVariable("NameName(.)(\\p{Upper})")).getDisplayName());
    assertEquals("name name$1 $2", (new FreemarkerVariable("NameName$1 $2")).getDisplayName());
    assertEquals("name name name", (new FreemarkerVariable("NameNameName")).getDisplayName());
    assertEquals("name nameform.", (new FreemarkerVariable("NameNameform.")).getDisplayName());
    assertEquals("name name42", (new FreemarkerVariable("NameName42")).getDisplayName());
    assertEquals("nameform. uu", (new FreemarkerVariable("Nameform.UU")).getDisplayName());
    assertEquals("nameform.(.)(\\p{ upper})", (new FreemarkerVariable("Nameform.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("nameform. name", (new FreemarkerVariable("Nameform.Name")).getDisplayName());
    assertEquals("name42 uu", (new FreemarkerVariable("Name42UU")).getDisplayName());
    assertEquals("name42(.)(\\p{ upper})", (new FreemarkerVariable("Name42(.)(\\p{Upper})")).getDisplayName());
    assertEquals("name42 name", (new FreemarkerVariable("Name42Name")).getDisplayName());
    assertEquals("form. uu uu", (new FreemarkerVariable("form.UUUU")).getDisplayName());
    assertEquals("form. uu(.)(\\p{ upper})", (new FreemarkerVariable("form.UU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form. uu$1 $2", (new FreemarkerVariable("form.UU$1 $2")).getDisplayName());
    assertEquals("form. uu name", (new FreemarkerVariable("form.UUName")).getDisplayName());
    assertEquals("form. uuform.", (new FreemarkerVariable("form.UUform.")).getDisplayName());
    assertEquals("form. uu42", (new FreemarkerVariable("form.UU42")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper}) uu", (new FreemarkerVariable("form.(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("form.(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper})$1 $2", (new FreemarkerVariable("form.(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper}) name", (new FreemarkerVariable("form.(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper})form.", (new FreemarkerVariable("form.(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("form.(.)(\\p{ upper})42", (new FreemarkerVariable("form.(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("form.$1 $2 uu", (new FreemarkerVariable("form.$1 $2UU")).getDisplayName());
    assertEquals("form.$1 $2(.)(\\p{ upper})", (new FreemarkerVariable("form.$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form.$1 $2 name", (new FreemarkerVariable("form.$1 $2Name")).getDisplayName());
    assertEquals("form. name uu", (new FreemarkerVariable("form.NameUU")).getDisplayName());
    assertEquals("form. name(.)(\\p{ upper})", (new FreemarkerVariable("form.Name(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form. name$1 $2", (new FreemarkerVariable("form.Name$1 $2")).getDisplayName());
    assertEquals("form. name name", (new FreemarkerVariable("form.NameName")).getDisplayName());
    assertEquals("form. nameform.", (new FreemarkerVariable("form.Nameform.")).getDisplayName());
    assertEquals("form. name42", (new FreemarkerVariable("form.Name42")).getDisplayName());
    assertEquals("form.form. uu", (new FreemarkerVariable("form.form.UU")).getDisplayName());
    assertEquals("form.form.(.)(\\p{ upper})", (new FreemarkerVariable("form.form.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form.form. name", (new FreemarkerVariable("form.form.Name")).getDisplayName());
    assertEquals("form.42 uu", (new FreemarkerVariable("form.42UU")).getDisplayName());
    assertEquals("form.42(.)(\\p{ upper})", (new FreemarkerVariable("form.42(.)(\\p{Upper})")).getDisplayName());
    assertEquals("form.42 name", (new FreemarkerVariable("form.42Name")).getDisplayName());
    assertEquals("42 uu uu", (new FreemarkerVariable("42UUUU")).getDisplayName());
    assertEquals("42 uu(.)(\\p{ upper})", (new FreemarkerVariable("42UU(.)(\\p{Upper})")).getDisplayName());
    assertEquals("42 uu$1 $2", (new FreemarkerVariable("42UU$1 $2")).getDisplayName());
    assertEquals("42 uu name", (new FreemarkerVariable("42UUName")).getDisplayName());
    assertEquals("42 uuform.", (new FreemarkerVariable("42UUform.")).getDisplayName());
    assertEquals("42 uu42", (new FreemarkerVariable("42UU42")).getDisplayName());
    assertEquals("42(.)(\\p{ upper}) uu", (new FreemarkerVariable("42(.)(\\p{Upper})UU")).getDisplayName());
    assertEquals("42(.)(\\p{ upper})(.)(\\p{ upper})",
        (new FreemarkerVariable("42(.)(\\p{Upper})(.)(\\p{Upper})")).getDisplayName());
    assertEquals("42(.)(\\p{ upper})$1 $2", (new FreemarkerVariable("42(.)(\\p{Upper})$1 $2")).getDisplayName());
    assertEquals("42(.)(\\p{ upper}) name", (new FreemarkerVariable("42(.)(\\p{Upper})Name")).getDisplayName());
    assertEquals("42(.)(\\p{ upper})form.", (new FreemarkerVariable("42(.)(\\p{Upper})form.")).getDisplayName());
    assertEquals("42(.)(\\p{ upper})42", (new FreemarkerVariable("42(.)(\\p{Upper})42")).getDisplayName());
    assertEquals("42$1 $2 uu", (new FreemarkerVariable("42$1 $2UU")).getDisplayName());
    assertEquals("42$1 $2(.)(\\p{ upper})", (new FreemarkerVariable("42$1 $2(.)(\\p{Upper})")).getDisplayName());
    assertEquals("42$1 $2 name", (new FreemarkerVariable("42$1 $2Name")).getDisplayName());
    assertEquals("42 name uu", (new FreemarkerVariable("42NameUU")).getDisplayName());
    assertEquals("42 name(.)(\\p{ upper})", (new FreemarkerVariable("42Name(.)(\\p{Upper})")).getDisplayName());
    assertEquals("42 name$1 $2", (new FreemarkerVariable("42Name$1 $2")).getDisplayName());
    assertEquals("42 name name", (new FreemarkerVariable("42NameName")).getDisplayName());
    assertEquals("42 nameform.", (new FreemarkerVariable("42Nameform.")).getDisplayName());
    assertEquals("42 name42", (new FreemarkerVariable("42Name42")).getDisplayName());
    assertEquals("42form. uu", (new FreemarkerVariable("42form.UU")).getDisplayName());
    assertEquals("42form.(.)(\\p{ upper})", (new FreemarkerVariable("42form.(.)(\\p{Upper})")).getDisplayName());
    assertEquals("42form. name", (new FreemarkerVariable("42form.Name")).getDisplayName());
    assertEquals("4242 uu", (new FreemarkerVariable("4242UU")).getDisplayName());
    assertEquals("4242(.)(\\p{ upper})", (new FreemarkerVariable("4242(.)(\\p{Upper})")).getDisplayName());
    assertEquals("4242 name", (new FreemarkerVariable("4242Name")).getDisplayName());
  }

  /**
   * Method under test: {@link FreemarkerVariable#getFormFieldName()}
   */
  @Test
  void testGetFormFieldName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new FreemarkerVariable("Name")).getFormFieldName());
    assertEquals("", (new FreemarkerVariable("form.")).getFormFieldName());
  }

  /**
   * Method under test: {@link FreemarkerVariable#getDataPath()}
   */
  @Test
  void testGetDataPath() {
    // Arrange, Act and Assert
    assertEquals("Name", (new FreemarkerVariable("Name")).getDataPath());
  }

  /**
   * Method under test: {@link FreemarkerVariable#getErrorPath()}
   */
  @Test
  void testGetErrorPath() {
    // Arrange, Act and Assert
    assertEquals("Name.error", (new FreemarkerVariable("Name")).getErrorPath());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FreemarkerVariable#FreemarkerVariable(String)}
   *   <li>{@link FreemarkerVariable#getDepth()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(1, (new FreemarkerVariable("Name")).getDepth());
  }
}
