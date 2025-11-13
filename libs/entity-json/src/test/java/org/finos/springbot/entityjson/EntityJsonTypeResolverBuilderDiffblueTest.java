package org.finos.springbot.entityjson;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityJsonTypeResolverBuilderDiffblueTest {
  /**
   * Test {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}.
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}
   */
  @Test
  @DisplayName("Test addVersionSpace(VersionSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.addVersionSpace(VersionSpace)"})
  void testAddVersionSpace() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);
    Class<Object> toUse = Object.class;
    VersionSpace vs = new VersionSpace(toUse, "1.0.2", "1.0.2");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> entityJsonTypeResolverBuilder.addVersionSpace(vs));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}.
   *
   * <ul>
   *   <li>Given {@code JsonNode}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}
   */
  @Test
  @DisplayName(
      "Test addVersionSpace(VersionSpace); given 'com.fasterxml.jackson.databind.JsonNode'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.addVersionSpace(VersionSpace)"})
  void testAddVersionSpace_givenComFasterxmlJacksonDatabindJsonNode_thenDoesNotThrow() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());
    Class<JsonNode> class1 = JsonNode.class;
    entityJsonTypeResolverBuilder.addVersionSpace(ObjectMapperFactory.noVersion(class1));
    Class<Object> class12 = Object.class;

    // Act and Assert
    assertDoesNotThrow(
        () ->
            entityJsonTypeResolverBuilder.addVersionSpace(ObjectMapperFactory.noVersion(class12)));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When noVersion {@link Object}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}
   */
  @Test
  @DisplayName(
      "Test addVersionSpace(VersionSpace); given 'java.lang.Object'; when noVersion Object; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.addVersionSpace(VersionSpace)"})
  void testAddVersionSpace_givenJavaLangObject_whenNoVersionObject_thenDoesNotThrow() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);
    Class<Object> class12 = Object.class;

    // Act and Assert
    assertDoesNotThrow(
        () ->
            entityJsonTypeResolverBuilder.addVersionSpace(ObjectMapperFactory.noVersion(class12)));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}.
   *
   * <ul>
   *   <li>When noVersion {@link Object}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}
   */
  @Test
  @DisplayName("Test addVersionSpace(VersionSpace); when noVersion Object; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.addVersionSpace(VersionSpace)"})
  void testAddVersionSpace_whenNoVersionObject_thenDoesNotThrow() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertDoesNotThrow(
        () -> entityJsonTypeResolverBuilder.addVersionSpace(ObjectMapperFactory.noVersion(class1)));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}.
   *
   * <ul>
   *   <li>When {@link VersionSpace#VersionSpace(Class)} with toUse is {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#addVersionSpace(VersionSpace)}
   */
  @Test
  @DisplayName("Test addVersionSpace(VersionSpace); when VersionSpace(Class) with toUse is Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.addVersionSpace(VersionSpace)"})
  void testAddVersionSpace_whenVersionSpaceWithToUseIsObject() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);
    Class<Object> toUse = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityJsonTypeResolverBuilder.addVersionSpace(new VersionSpace(toUse)));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}
   */
  @Test
  @DisplayName(
      "Test new EntityJsonTypeResolverBuilder(TypeFactory, List); given 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.<init>(TypeFactory, List)"})
  void testNewEntityJsonTypeResolverBuilder_givenJavaLangObject() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));

    // Act
    EntityJsonTypeResolverBuilder actualEntityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, allowed);

    // Assert
    assertEquals("type", actualEntityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(actualEntityJsonTypeResolverBuilder.getDefaultImpl());
    assertFalse(actualEntityJsonTypeResolverBuilder.isTypeIdVisible());
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}
   */
  @Test
  @DisplayName(
      "Test new EntityJsonTypeResolverBuilder(TypeFactory, List); given 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.<init>(TypeFactory, List)"})
  void testNewEntityJsonTypeResolverBuilder_givenJavaLangObject2() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    Class<Object> class12 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class12));

    // Act
    EntityJsonTypeResolverBuilder actualEntityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, allowed);

    // Assert
    assertEquals("type", actualEntityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(actualEntityJsonTypeResolverBuilder.getDefaultImpl());
    assertFalse(actualEntityJsonTypeResolverBuilder.isTypeIdVisible());
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return TypeProperty is {@code type}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityJsonTypeResolverBuilder#EntityJsonTypeResolverBuilder(TypeFactory, List)}
   */
  @Test
  @DisplayName(
      "Test new EntityJsonTypeResolverBuilder(TypeFactory, List); when ArrayList(); then return TypeProperty is 'type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJsonTypeResolverBuilder.<init>(TypeFactory, List)"})
  void testNewEntityJsonTypeResolverBuilder_whenArrayList_thenReturnTypePropertyIsType() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    // Act
    EntityJsonTypeResolverBuilder actualEntityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());

    // Assert
    assertEquals("type", actualEntityJsonTypeResolverBuilder.getTypeProperty());
    assertNull(actualEntityJsonTypeResolverBuilder.getDefaultImpl());
    assertFalse(actualEntityJsonTypeResolverBuilder.isTypeIdVisible());
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#getVersionHandler()}.
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#getVersionHandler()}
   */
  @Test
  @DisplayName("Test getVersionHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeserializationProblemHandler EntityJsonTypeResolverBuilder.getVersionHandler()"
  })
  void testGetVersionHandler() throws IOException {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());

    // Act
    DeserializationProblemHandler actualVersionHandler =
        entityJsonTypeResolverBuilder.getVersionHandler();

    // Assert
    assertNull(actualVersionHandler.handleMissingTypeId(null, null, null, "Failure Msg"));
    Object object = DeserializationProblemHandler.NOT_HANDLED;
    assertSame(object, actualVersionHandler.handleInstantiationProblem(null, null, null, null));
    assertSame(object, actualVersionHandler.handleMissingInstantiator(null, null, null, "Msg"));
    assertSame(object, actualVersionHandler.handleWeirdKey(null, null, "42", "Failure Msg"));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>Given {@code JsonNode}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName("Test useForType(JavaType); given 'com.fasterxml.jackson.databind.JsonNode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_givenComFasterxmlJacksonDatabindJsonNode() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);

    ArrayType t = mock(ArrayType.class);
    when(t.isEnumType()).thenReturn(false);
    when(t.isJavaLangObject()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(false);
    Class<JsonNode> forNameResult = JsonNode.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isJavaLangObject();
    verify(t).isPrimitive();
    assertFalse(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>When {@link ArrayType} {@link ArrayType#getRawClass()} return {@link Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName(
      "Test useForType(JavaType); given Object; when ArrayType getRawClass() return Object; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_givenObject_whenArrayTypeGetRawClassReturnObject_thenReturnFalse() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());

    ArrayType t = mock(ArrayType.class);
    when(t.isEnumType()).thenReturn(false);
    when(t.isJavaLangObject()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isJavaLangObject();
    verify(t).isPrimitive();
    assertFalse(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link ArrayType} {@link ArrayType#isEnumType()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName(
      "Test useForType(JavaType); given 'true'; when ArrayType isEnumType() return 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_givenTrue_whenArrayTypeIsEnumTypeReturnTrue_thenReturnFalse() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());

    ArrayType t = mock(ArrayType.class);
    when(t.isEnumType()).thenReturn(true);
    when(t.isPrimitive()).thenReturn(true);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).isEnumType();
    verify(t).isPrimitive();
    assertFalse(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayType#isTypeOrSuperTypeOf(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName("Test useForType(JavaType); then calls isTypeOrSuperTypeOf(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_thenCallsIsTypeOrSuperTypeOf() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);

    ArrayType t = mock(ArrayType.class);
    when(t.isTypeOrSuperTypeOf(Mockito.<Class<?>>any())).thenReturn(false);
    when(t.isEnumType()).thenReturn(false);
    when(t.isJavaLangObject()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isJavaLangObject();
    verify(t).isPrimitive();
    verify(t).isTypeOrSuperTypeOf(isA(Class.class));
    assertFalse(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>When {@link ArrayType} {@link ArrayType#isPrimitive()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName(
      "Test useForType(JavaType); when ArrayType isPrimitive() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_whenArrayTypeIsPrimitiveThrowIllegalArgumentException() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());

    ArrayType t = mock(ArrayType.class);
    when(t.isPrimitive()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityJsonTypeResolverBuilder.useForType(t));
    verify(t).isPrimitive();
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>When {@link ArrayType} {@link ArrayType#isTypeOrSuperTypeOf(Class)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName(
      "Test useForType(JavaType); when ArrayType isTypeOrSuperTypeOf(Class) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_whenArrayTypeIsTypeOrSuperTypeOfReturnTrue_thenReturnTrue() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);

    ArrayType t = mock(ArrayType.class);
    when(t.isTypeOrSuperTypeOf(Mockito.<Class<?>>any())).thenReturn(true);
    when(t.isEnumType()).thenReturn(false);
    when(t.isJavaLangObject()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act
    boolean actualUseForTypeResult = entityJsonTypeResolverBuilder.useForType(t);

    // Assert
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isJavaLangObject();
    verify(t).isPrimitive();
    verify(t).isTypeOrSuperTypeOf(isA(Class.class));
    assertTrue(actualUseForTypeResult);
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>When {@link ArrayType} {@link ArrayType#isTypeOrSuperTypeOf(Class)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName(
      "Test useForType(JavaType); when ArrayType isTypeOrSuperTypeOf(Class) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_whenArrayTypeIsTypeOrSuperTypeOfThrowIllegalArgumentException() {
    // Arrange
    ArrayList<VersionSpace> allowed = new ArrayList<>();
    Class<Object> class1 = Object.class;
    allowed.add(ObjectMapperFactory.noVersion(class1));
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(TypeFactory.defaultInstance(), allowed);

    ArrayType t = mock(ArrayType.class);
    when(t.isTypeOrSuperTypeOf(Mockito.<Class<?>>any())).thenThrow(new IllegalArgumentException());
    when(t.isEnumType()).thenReturn(false);
    when(t.isJavaLangObject()).thenReturn(false);
    when(t.isPrimitive()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(t.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityJsonTypeResolverBuilder.useForType(t));
    verify(t).getRawClass();
    verify(t).isEnumType();
    verify(t).isJavaLangObject();
    verify(t).isPrimitive();
    verify(t).isTypeOrSuperTypeOf(isA(Class.class));
  }

  /**
   * Test {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}.
   *
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonTypeResolverBuilder#useForType(JavaType)}
   */
  @Test
  @DisplayName(
      "Test useForType(JavaType); when PlaceholderForType(int) with ordinal is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJsonTypeResolverBuilder.useForType(JavaType)"})
  void testUseForType_whenPlaceholderForTypeWithOrdinalIsOne_thenReturnTrue() {
    // Arrange
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    EntityJsonTypeResolverBuilder entityJsonTypeResolverBuilder =
        new EntityJsonTypeResolverBuilder(typeFactory, new ArrayList<>());

    // Act
    boolean actualUseForTypeResult =
        entityJsonTypeResolverBuilder.useForType(new PlaceholderForType(1));

    // Assert
    assertTrue(actualUseForTypeResult);
  }
}
