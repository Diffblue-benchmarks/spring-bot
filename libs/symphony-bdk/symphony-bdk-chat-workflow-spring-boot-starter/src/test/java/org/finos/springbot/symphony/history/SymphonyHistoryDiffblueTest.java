package org.finos.springbot.symphony.history;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.bdk.core.service.message.MessageService;
import com.symphony.bdk.core.service.pagination.model.PaginationAttribute;
import com.symphony.bdk.gen.api.model.MessageSearchQuery;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.symphony.content.CashTag;
import org.finos.springbot.symphony.content.HashTag;
import org.finos.springbot.symphony.content.SymphonyAddressable;
import org.finos.springbot.symphony.conversations.StreamResolver;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SymphonyHistoryImpl.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class SymphonyHistoryDiffblueTest {
  @MockitoBean private EntityJsonConverter entityJsonConverter;

  @MockitoBean private MessageService messageService;

  @MockitoBean private StreamResolver streamResolver;

  @Autowired private SymphonyHistory symphonyHistory;

  /**
   * Test {@link SymphonyHistory#getLastEntityJsonFromHistory(Class, Tag, SymphonyAddressable)} with
   * {@code Class}, {@code Tag}, {@code SymphonyAddressable}.
   *
   * <p>Method under test: {@link SymphonyHistory#getLastEntityJsonFromHistory(Class,
   * org.finos.springbot.workflow.content.Tag, SymphonyAddressable)}
   */
  @Test
  @DisplayName(
      "Test getLastEntityJsonFromHistory(Class, Tag, SymphonyAddressable) with 'Class', 'Tag', 'SymphonyAddressable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SymphonyHistory.getLastEntityJsonFromHistory(Class, org.finos.springbot.workflow.content.Tag, SymphonyAddressable)"
  })
  void testGetLastEntityJsonFromHistoryWithClassTagSymphonyAddressable() {
    // Arrange
    when(messageService.searchMessages(
            Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(new ArrayList<>());
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<EntityJson> actualLastEntityJsonFromHistory =
        symphonyHistory.getLastEntityJsonFromHistory(
            type, new CashTag("42"), mock(SymphonyAddressable.class));

    // Assert
    verify(messageService)
        .searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertFalse(actualLastEntityJsonFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistory#getLastEntityJsonFromHistory(Class, Tag, SymphonyAddressable)} with
   * {@code Class}, {@code Tag}, {@code SymphonyAddressable}.
   *
   * <p>Method under test: {@link SymphonyHistory#getLastEntityJsonFromHistory(Class,
   * org.finos.springbot.workflow.content.Tag, SymphonyAddressable)}
   */
  @Test
  @DisplayName(
      "Test getLastEntityJsonFromHistory(Class, Tag, SymphonyAddressable) with 'Class', 'Tag', 'SymphonyAddressable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SymphonyHistory.getLastEntityJsonFromHistory(Class, org.finos.springbot.workflow.content.Tag, SymphonyAddressable)"
  })
  void testGetLastEntityJsonFromHistoryWithClassTagSymphonyAddressable2() {
    // Arrange
    when(messageService.searchMessages(
            Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(new ArrayList<>());
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<EntityJson> actualLastEntityJsonFromHistory =
        symphonyHistory.getLastEntityJsonFromHistory(
            type, new HashTag("42"), mock(SymphonyAddressable.class));

    // Assert
    verify(messageService)
        .searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertFalse(actualLastEntityJsonFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistory#getEntityJsonFromHistory(Tag, SymphonyAddressable, Instant)} with
   * {@code Tag}, {@code SymphonyAddressable}, {@code Instant}.
   *
   * <p>Method under test: {@link
   * SymphonyHistory#getEntityJsonFromHistory(org.finos.springbot.workflow.content.Tag,
   * SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getEntityJsonFromHistory(Tag, SymphonyAddressable, Instant) with 'Tag', 'SymphonyAddressable', 'Instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SymphonyHistory.getEntityJsonFromHistory(org.finos.springbot.workflow.content.Tag, SymphonyAddressable, Instant)"
  })
  void testGetEntityJsonFromHistoryWithTagSymphonyAddressableInstant() {
    // Arrange
    when(messageService.searchMessages(
            Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(new ArrayList<>());
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    CashTag t = new CashTag("42");
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<EntityJson> actualEntityJsonFromHistory =
        symphonyHistory.getEntityJsonFromHistory(
            t, address, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService)
        .searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertTrue(actualEntityJsonFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistory#getEntityJsonFromHistory(Tag, SymphonyAddressable, Instant)} with
   * {@code Tag}, {@code SymphonyAddressable}, {@code Instant}.
   *
   * <p>Method under test: {@link
   * SymphonyHistory#getEntityJsonFromHistory(org.finos.springbot.workflow.content.Tag,
   * SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getEntityJsonFromHistory(Tag, SymphonyAddressable, Instant) with 'Tag', 'SymphonyAddressable', 'Instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SymphonyHistory.getEntityJsonFromHistory(org.finos.springbot.workflow.content.Tag, SymphonyAddressable, Instant)"
  })
  void testGetEntityJsonFromHistoryWithTagSymphonyAddressableInstant2() {
    // Arrange
    when(messageService.searchMessages(
            Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(new ArrayList<>());
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    HashTag t = new HashTag("42");
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<EntityJson> actualEntityJsonFromHistory =
        symphonyHistory.getEntityJsonFromHistory(
            t, address, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService)
        .searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertTrue(actualEntityJsonFromHistory.isEmpty());
  }
}
