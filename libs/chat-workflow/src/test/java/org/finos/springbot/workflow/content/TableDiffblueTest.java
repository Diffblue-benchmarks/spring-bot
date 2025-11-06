package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class TableDiffblueTest {
  /**
   * Method under test: {@link Table#of(List, List)}
   */
  @Test
  void testOf() {
    // Arrange
    ArrayList<Content> headers = new ArrayList<>();
    ArrayList<List<? extends Content>> data = new ArrayList<>();

    // Act
    Table actualOfResult = Table.of(headers, data);

    // Assert
    assertTrue(actualOfResult instanceof Table.TableImpl);
    assertEquals("", actualOfResult.getText());
    List<Content> columnNames = actualOfResult.getColumnNames();
    assertTrue(columnNames.isEmpty());
    List<List<Content>> data2 = actualOfResult.getData();
    assertTrue(data2.isEmpty());
    assertSame(headers, columnNames);
    assertSame(data, data2);
  }

  /**
   * Method under test: {@link Table#of(List, List)}
   */
  @Test
  void testOf2() {
    // Arrange
    ArrayList<Content> headers = new ArrayList<>();
    headers.add(new CodeBlock.CodeBlockImpl("foo"));
    ArrayList<List<? extends Content>> data = new ArrayList<>();

    // Act
    Table actualOfResult = Table.of(headers, data);

    // Assert
    assertTrue(actualOfResult instanceof Table.TableImpl);
    assertEquals(" foo", actualOfResult.getText());
    List<List<Content>> data2 = actualOfResult.getData();
    assertTrue(data2.isEmpty());
    assertSame(headers, actualOfResult.getColumnNames());
    assertSame(data, data2);
  }

  /**
   * Method under test: {@link Table#of(List, List)}
   */
  @Test
  void testOf3() {
    // Arrange
    ArrayList<Content> headers = new ArrayList<>();
    headers.add(new CodeBlock.CodeBlockImpl("foo"));
    headers.add(new CodeBlock.CodeBlockImpl("foo"));
    ArrayList<List<? extends Content>> data = new ArrayList<>();

    // Act
    Table actualOfResult = Table.of(headers, data);

    // Assert
    assertTrue(actualOfResult instanceof Table.TableImpl);
    assertEquals(" foo foo", actualOfResult.getText());
    List<List<Content>> data2 = actualOfResult.getData();
    assertTrue(data2.isEmpty());
    assertSame(headers, actualOfResult.getColumnNames());
    assertSame(data, data2);
  }

  /**
   * Method under test: {@link Table#of(List, List)}
   */
  @Test
  void testOf4() {
    // Arrange
    ArrayList<Content> headers = new ArrayList<>();

    ArrayList<List<? extends Content>> data = new ArrayList<>();
    data.add(new ArrayList<>());

    // Act
    Table actualOfResult = Table.of(headers, data);

    // Assert
    assertTrue(actualOfResult instanceof Table.TableImpl);
    assertEquals("", actualOfResult.getText());
    List<Content> columnNames = actualOfResult.getColumnNames();
    assertTrue(columnNames.isEmpty());
    assertSame(headers, columnNames);
    assertSame(data, actualOfResult.getData());
  }

  /**
   * Method under test: {@link Table#of(List, List)}
   */
  @Test
  void testOf5() {
    // Arrange
    ArrayList<Content> headers = new ArrayList<>();

    ArrayList<List<? extends Content>> data = new ArrayList<>();
    data.add(new ArrayList<>());
    data.add(new ArrayList<>());

    // Act
    Table actualOfResult = Table.of(headers, data);

    // Assert
    assertTrue(actualOfResult instanceof Table.TableImpl);
    assertEquals("", actualOfResult.getText());
    List<Content> columnNames = actualOfResult.getColumnNames();
    assertTrue(columnNames.isEmpty());
    assertSame(headers, columnNames);
    assertSame(data, actualOfResult.getData());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Table.TableImpl#equals(Object)}
   *   <li>{@link Table.TableImpl#hashCode()}
   * </ul>
   */
  @Test
  void testTableImplEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    Table.TableImpl tableImpl = new Table.TableImpl(columns, new ArrayList<>());
    ArrayList<Content> columns2 = new ArrayList<>();
    Table.TableImpl tableImpl2 = new Table.TableImpl(columns2, new ArrayList<>());

    // Act and Assert
    assertEquals(tableImpl, tableImpl2);
    int expectedHashCodeResult = tableImpl.hashCode();
    assertEquals(expectedHashCodeResult, tableImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Table.TableImpl#equals(Object)}
   *   <li>{@link Table.TableImpl#hashCode()}
   * </ul>
   */
  @Test
  void testTableImplEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    Table.TableImpl tableImpl = new Table.TableImpl(columns, new ArrayList<>());

    // Act and Assert
    assertEquals(tableImpl, tableImpl);
    int expectedHashCodeResult = tableImpl.hashCode();
    assertEquals(expectedHashCodeResult, tableImpl.hashCode());
  }

  /**
   * Method under test: {@link Table.TableImpl#equals(Object)}
   */
  @Test
  void testTableImplEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    columns.add(new CodeBlock.CodeBlockImpl("foo"));
    Table.TableImpl tableImpl = new Table.TableImpl(columns, new ArrayList<>());
    ArrayList<Content> columns2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(tableImpl, new Table.TableImpl(columns2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link Table.TableImpl#equals(Object)}
   */
  @Test
  void testTableImplEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(new ArrayList<>());
    Table.TableImpl tableImpl = new Table.TableImpl(new ArrayList<>(), data);
    ArrayList<Content> columns = new ArrayList<>();

    // Act and Assert
    assertNotEquals(tableImpl, new Table.TableImpl(columns, new ArrayList<>()));
  }

  /**
   * Method under test: {@link Table.TableImpl#equals(Object)}
   */
  @Test
  void testTableImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();

    // Act and Assert
    assertNotEquals(new Table.TableImpl(columns, new ArrayList<>()), null);
  }

  /**
   * Method under test: {@link Table.TableImpl#equals(Object)}
   */
  @Test
  void testTableImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();

    // Act and Assert
    assertNotEquals(new Table.TableImpl(columns, new ArrayList<>()), "Different type to TableImpl");
  }

  /**
   * Method under test: {@link Table.TableImpl#getText()}
   */
  @Test
  void testTableImplGetText() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();

    // Act and Assert
    assertEquals("", (new Table.TableImpl(columns, new ArrayList<>())).getText());
  }

  /**
   * Method under test: {@link Table.TableImpl#getText()}
   */
  @Test
  void testTableImplGetText2() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    columns.add(new CodeBlock.CodeBlockImpl("foo"));

    // Act and Assert
    assertEquals(" foo", (new Table.TableImpl(columns, new ArrayList<>())).getText());
  }

  /**
   * Method under test: {@link Table.TableImpl#getText()}
   */
  @Test
  void testTableImplGetText3() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    columns.add(new CodeBlock.CodeBlockImpl("foo"));
    columns.add(new CodeBlock.CodeBlockImpl("foo"));

    // Act and Assert
    assertEquals(" foo foo", (new Table.TableImpl(columns, new ArrayList<>())).getText());
  }

  /**
   * Method under test: {@link Table.TableImpl#getText()}
   */
  @Test
  void testTableImplGetText4() {
    // Arrange
    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(new ArrayList<>());

    // Act and Assert
    assertEquals("", (new Table.TableImpl(new ArrayList<>(), data)).getText());
  }

  /**
   * Method under test: {@link Table.TableImpl#getText()}
   */
  @Test
  void testTableImplGetText5() {
    // Arrange
    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(new ArrayList<>());
    data.add(new ArrayList<>());

    // Act and Assert
    assertEquals("", (new Table.TableImpl(new ArrayList<>(), data)).getText());
  }

  /**
   * Method under test: {@link Table.TableImpl#getText()}
   */
  @Test
  void testTableImplGetText6() {
    // Arrange
    ArrayList<Content> contentList = new ArrayList<>();
    contentList.add(new CodeBlock.CodeBlockImpl("foo"));

    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(contentList);

    // Act and Assert
    assertEquals(" foo", (new Table.TableImpl(new ArrayList<>(), data)).getText());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Table.TableImpl#TableImpl(List, List)}
   *   <li>{@link Table.TableImpl#getColumnNames()}
   *   <li>{@link Table.TableImpl#getData()}
   * </ul>
   */
  @Test
  void testTableImplGettersAndSetters() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    ArrayList<List<Content>> data = new ArrayList<>();

    // Act
    Table.TableImpl actualTableImpl = new Table.TableImpl(columns, data);
    List<Content> actualColumnNames = actualTableImpl.getColumnNames();
    List<List<Content>> actualData = actualTableImpl.getData();

    // Assert
    assertTrue(actualColumnNames.isEmpty());
    assertTrue(actualData.isEmpty());
    assertSame(columns, actualColumnNames);
    assertSame(data, actualData);
  }
}
