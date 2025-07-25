package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.content.Table.TableImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TableDiffblueTest {
  /**
   * Test {@link Table#of(List, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.
   *   <li>Then return Data is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Table#of(List, List)}
   */
  @Test
  @DisplayName(
      "Test of(List, List); given ArrayList(); when ArrayList() add ArrayList(); then return Data is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Table Table.of(List, List)"})
  void testOf_givenArrayList_whenArrayListAddArrayList_thenReturnDataIsArrayList() {
    // Arrange
    ArrayList<Content> headers = new ArrayList<>();

    ArrayList<List<? extends Content>> data = new ArrayList<>();
    data.add(new ArrayList<>());
    data.add(new ArrayList<>());

    // Act
    Table actualOfResult = Table.of(headers, data);

    // Assert
    assertTrue(actualOfResult instanceof TableImpl);
    assertSame(data, actualOfResult.getData());
  }

  /**
   * Test {@link Table#of(List, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link Table#of(List, List)}
   */
  @Test
  @DisplayName(
      "Test of(List, List); given ArrayList(); when ArrayList() add ArrayList(); then return Data size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Table Table.of(List, List)"})
  void testOf_givenArrayList_whenArrayListAddArrayList_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<Content> headers = new ArrayList<>();

    ArrayList<List<? extends Content>> data = new ArrayList<>();
    data.add(new ArrayList<>());

    // Act
    Table actualOfResult = Table.of(headers, data);

    // Assert
    assertTrue(actualOfResult instanceof TableImpl);
    assertEquals("", actualOfResult.getText());
    List<List<Content>> data2 = actualOfResult.getData();
    assertEquals(1, data2.size());
    assertTrue(data2.get(0).isEmpty());
    assertTrue(actualOfResult.getColumnNames().isEmpty());
    assertSame(data, data2);
  }

  /**
   * Test {@link Table#of(List, List)}.
   *
   * <ul>
   *   <li>Given {@link Content}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Content}.
   *   <li>Then return Text is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Table#of(List, List)}
   */
  @Test
  @DisplayName(
      "Test of(List, List); given Content; when ArrayList() add Content; then return Text is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Table Table.of(List, List)"})
  void testOf_givenContent_whenArrayListAddContent_thenReturnTextIsNull() {
    // Arrange
    ArrayList<Content> headers = new ArrayList<>();
    headers.add(mock(Content.class));

    // Act
    Table actualOfResult = Table.of(headers, new ArrayList<>());

    // Assert
    assertTrue(actualOfResult instanceof TableImpl);
    assertEquals(" null", actualOfResult.getText());
    assertTrue(actualOfResult.getData().isEmpty());
    assertSame(headers, actualOfResult.getColumnNames());
  }

  /**
   * Test {@link Table#of(List, List)}.
   *
   * <ul>
   *   <li>Given {@link Content}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Content}.
   *   <li>Then return Text is {@code null null}.
   * </ul>
   *
   * <p>Method under test: {@link Table#of(List, List)}
   */
  @Test
  @DisplayName(
      "Test of(List, List); given Content; when ArrayList() add Content; then return Text is 'null null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Table Table.of(List, List)"})
  void testOf_givenContent_whenArrayListAddContent_thenReturnTextIsNullNull() {
    // Arrange
    ArrayList<Content> headers = new ArrayList<>();
    headers.add(mock(Content.class));
    headers.add(mock(Content.class));

    // Act
    Table actualOfResult = Table.of(headers, new ArrayList<>());

    // Assert
    assertTrue(actualOfResult instanceof TableImpl);
    assertEquals(" null null", actualOfResult.getText());
    assertTrue(actualOfResult.getData().isEmpty());
    assertSame(headers, actualOfResult.getColumnNames());
  }

  /**
   * Test {@link Table#of(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Table#of(List, List)}
   */
  @Test
  @DisplayName("Test of(List, List); when ArrayList(); then return Text is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Table Table.of(List, List)"})
  void testOf_whenArrayList_thenReturnTextIsEmptyString() {
    // Arrange
    ArrayList<Content> headers = new ArrayList<>();

    // Act
    Table actualOfResult = Table.of(headers, new ArrayList<>());

    // Assert
    assertTrue(actualOfResult instanceof TableImpl);
    assertEquals("", actualOfResult.getText());
    assertTrue(actualOfResult.getColumnNames().isEmpty());
    assertTrue(actualOfResult.getData().isEmpty());
  }

  /**
   * Test TableImpl {@link TableImpl#equals(Object)}, and {@link TableImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TableImpl#equals(Object)}
   *   <li>{@link TableImpl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TableImpl equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TableImpl.equals(Object)", "int TableImpl.hashCode()"})
  void testTableImplEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    TableImpl tableImpl = new TableImpl(columns, new ArrayList<>());
    ArrayList<Content> columns2 = new ArrayList<>();
    TableImpl tableImpl2 = new TableImpl(columns2, new ArrayList<>());

    // Act and Assert
    assertEquals(tableImpl, tableImpl2);
    int expectedHashCodeResult = tableImpl.hashCode();
    assertEquals(expectedHashCodeResult, tableImpl2.hashCode());
  }

  /**
   * Test TableImpl {@link TableImpl#equals(Object)}, and {@link TableImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TableImpl#equals(Object)}
   *   <li>{@link TableImpl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TableImpl equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TableImpl.equals(Object)", "int TableImpl.hashCode()"})
  void testTableImplEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    TableImpl tableImpl = new TableImpl(columns, new ArrayList<>());

    // Act and Assert
    assertEquals(tableImpl, tableImpl);
    int expectedHashCodeResult = tableImpl.hashCode();
    assertEquals(expectedHashCodeResult, tableImpl.hashCode());
  }

  /**
   * Test TableImpl {@link TableImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TableImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test TableImpl equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TableImpl.equals(Object)", "int TableImpl.hashCode()"})
  void testTableImplEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    columns.add(mock(Content.class));
    TableImpl tableImpl = new TableImpl(columns, new ArrayList<>());
    ArrayList<Content> columns2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(tableImpl, new TableImpl(columns2, new ArrayList<>()));
  }

  /**
   * Test TableImpl {@link TableImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TableImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test TableImpl equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TableImpl.equals(Object)", "int TableImpl.hashCode()"})
  void testTableImplEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(new ArrayList<>());
    TableImpl tableImpl = new TableImpl(new ArrayList<>(), data);
    ArrayList<Content> columns = new ArrayList<>();

    // Act and Assert
    assertNotEquals(tableImpl, new TableImpl(columns, new ArrayList<>()));
  }

  /**
   * Test TableImpl {@link TableImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TableImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test TableImpl equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TableImpl.equals(Object)", "int TableImpl.hashCode()"})
  void testTableImplEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    ArrayList<Content> columns2 = new ArrayList<>();
    columns.add(new TableImpl(columns2, new ArrayList<>()));
    TableImpl tableImpl = new TableImpl(columns, new ArrayList<>());

    ArrayList<Content> columns3 = new ArrayList<>();
    columns3.add(mock(Content.class));

    // Act and Assert
    assertNotEquals(tableImpl, new TableImpl(columns3, new ArrayList<>()));
  }

  /**
   * Test TableImpl {@link TableImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TableImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test TableImpl equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TableImpl.equals(Object)", "int TableImpl.hashCode()"})
  void testTableImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();

    // Act and Assert
    assertNotEquals(new TableImpl(columns, new ArrayList<>()), null);
  }

  /**
   * Test TableImpl {@link TableImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TableImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test TableImpl equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TableImpl.equals(Object)", "int TableImpl.hashCode()"})
  void testTableImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();

    // Act and Assert
    assertNotEquals(new TableImpl(columns, new ArrayList<>()), "Different type to TableImpl");
  }

  /**
   * Test TableImpl {@link TableImpl#getText()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Text Text}.
   * </ul>
   *
   * <p>Method under test: {@link TableImpl#getText()}
   */
  @Test
  @DisplayName(
      "Test TableImpl getText(); given ArrayList() add ArrayList(); then return 'Text Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableImpl.getText()"})
  void testTableImplGetText_givenArrayListAddArrayList_thenReturnTextText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("Text");
    Content content2 = mock(Content.class);
    when(content2.getText()).thenReturn("Text");

    ArrayList<Content> columns = new ArrayList<>();
    columns.add(content2);
    columns.add(content);

    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(new ArrayList<>());

    // Act
    String actualText = new TableImpl(columns, data).getText();

    // Assert
    verify(content2).getText();
    verify(content).getText();
    assertEquals(" Text Text", actualText);
  }

  /**
   * Test TableImpl {@link TableImpl#getText()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Text Text}.
   * </ul>
   *
   * <p>Method under test: {@link TableImpl#getText()}
   */
  @Test
  @DisplayName(
      "Test TableImpl getText(); given ArrayList() add ArrayList(); then return 'Text Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableImpl.getText()"})
  void testTableImplGetText_givenArrayListAddArrayList_thenReturnTextText2() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("Text");
    Content content2 = mock(Content.class);
    when(content2.getText()).thenReturn("Text");

    ArrayList<Content> columns = new ArrayList<>();
    columns.add(content2);
    columns.add(content);

    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(new ArrayList<>());
    data.add(new ArrayList<>());

    // Act
    String actualText = new TableImpl(columns, data).getText();

    // Assert
    verify(content2).getText();
    verify(content).getText();
    assertEquals(" Text Text", actualText);
  }

  /**
   * Test TableImpl {@link TableImpl#getText()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Text Text Text}.
   * </ul>
   *
   * <p>Method under test: {@link TableImpl#getText()}
   */
  @Test
  @DisplayName(
      "Test TableImpl getText(); given ArrayList() add ArrayList(); then return 'Text Text Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableImpl.getText()"})
  void testTableImplGetText_givenArrayListAddArrayList_thenReturnTextTextText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("Text");
    Content content2 = mock(Content.class);
    when(content2.getText()).thenReturn("Text");

    ArrayList<Content> columns = new ArrayList<>();
    columns.add(content2);
    columns.add(content);
    Content content3 = mock(Content.class);
    when(content3.getText()).thenReturn("Text");

    ArrayList<Content> contentList = new ArrayList<>();
    contentList.add(content3);

    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(contentList);

    // Act
    String actualText = new TableImpl(columns, data).getText();

    // Assert
    verify(content2).getText();
    verify(content).getText();
    verify(content3).getText();
    assertEquals(" Text Text Text", actualText);
  }

  /**
   * Test TableImpl {@link TableImpl#getText()}.
   *
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code Text}.
   *   <li>Then return {@code Text}.
   * </ul>
   *
   * <p>Method under test: {@link TableImpl#getText()}
   */
  @Test
  @DisplayName(
      "Test TableImpl getText(); given Content getText() return 'Text'; then return 'Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableImpl.getText()"})
  void testTableImplGetText_givenContentGetTextReturnText_thenReturnText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("Text");

    ArrayList<Content> columns = new ArrayList<>();
    columns.add(content);

    // Act
    String actualText = new TableImpl(columns, new ArrayList<>()).getText();

    // Assert
    verify(content).getText();
    assertEquals(" Text", actualText);
  }

  /**
   * Test TableImpl {@link TableImpl#getText()}.
   *
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code Text}.
   *   <li>Then return {@code Text Text}.
   * </ul>
   *
   * <p>Method under test: {@link TableImpl#getText()}
   */
  @Test
  @DisplayName(
      "Test TableImpl getText(); given Content getText() return 'Text'; then return 'Text Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableImpl.getText()"})
  void testTableImplGetText_givenContentGetTextReturnText_thenReturnTextText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("Text");
    Content content2 = mock(Content.class);
    when(content2.getText()).thenReturn("Text");

    ArrayList<Content> columns = new ArrayList<>();
    columns.add(content2);
    columns.add(content);

    // Act
    String actualText = new TableImpl(columns, new ArrayList<>()).getText();

    // Assert
    verify(content2).getText();
    verify(content).getText();
    assertEquals(" Text Text", actualText);
  }

  /**
   * Test TableImpl {@link TableImpl#getText()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TableImpl#getText()}
   */
  @Test
  @DisplayName("Test TableImpl getText(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableImpl.getText()"})
  void testTableImplGetText_thenReturnEmptyString() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();

    // Act and Assert
    assertEquals("", new TableImpl(columns, new ArrayList<>()).getText());
  }

  /**
   * Test TableImpl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TableImpl#TableImpl(List, List)}
   *   <li>{@link TableImpl#getColumnNames()}
   *   <li>{@link TableImpl#getData()}
   * </ul>
   */
  @Test
  @DisplayName("Test TableImpl getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TableImpl.<init>(List, List)",
    "List TableImpl.getColumnNames()",
    "List TableImpl.getData()"
  })
  void testTableImplGettersAndSetters() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    ArrayList<List<Content>> data = new ArrayList<>();

    // Act
    TableImpl actualTableImpl = new TableImpl(columns, data);
    List<Content> actualColumnNames = actualTableImpl.getColumnNames();
    List<List<Content>> actualData = actualTableImpl.getData();

    // Assert
    assertTrue(actualColumnNames.isEmpty());
    assertTrue(actualData.isEmpty());
    assertSame(columns, actualColumnNames);
    assertSame(data, actualData);
  }
}
