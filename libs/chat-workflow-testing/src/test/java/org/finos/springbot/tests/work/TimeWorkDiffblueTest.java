package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimeWorkDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TimeWork}
   *   <li>{@link TimeWork#setI(Instant)}
   *   <li>{@link TimeWork#setLd(LocalDate)}
   *   <li>{@link TimeWork#setLdt(LocalDateTime)}
   *   <li>{@link TimeWork#setLt(LocalTime)}
   *   <li>{@link TimeWork#setZdt(ZonedDateTime)}
   *   <li>{@link TimeWork#setZid(ZoneId)}
   *   <li>{@link TimeWork#getI()}
   *   <li>{@link TimeWork#getLd()}
   *   <li>{@link TimeWork#getLdt()}
   *   <li>{@link TimeWork#getLt()}
   *   <li>{@link TimeWork#getZdt()}
   *   <li>{@link TimeWork#getZid()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimeWork.<init>()",
    "Instant TimeWork.getI()",
    "LocalDate TimeWork.getLd()",
    "LocalDateTime TimeWork.getLdt()",
    "LocalTime TimeWork.getLt()",
    "ZonedDateTime TimeWork.getZdt()",
    "ZoneId TimeWork.getZid()",
    "void TimeWork.setI(Instant)",
    "void TimeWork.setLd(LocalDate)",
    "void TimeWork.setLdt(LocalDateTime)",
    "void TimeWork.setLt(LocalTime)",
    "void TimeWork.setZdt(ZonedDateTime)",
    "void TimeWork.setZid(ZoneId)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TimeWork actualTimeWork = new TimeWork();
    actualTimeWork.setI(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    LocalDate ld = LocalDate.of(1970, 1, 1);
    actualTimeWork.setLd(ld);
    LocalDateTime ldt = LocalDate.of(1970, 1, 1).atStartOfDay();
    actualTimeWork.setLdt(ldt);
    actualTimeWork.setLt(LocalTime.MIDNIGHT);
    ZonedDateTime zdt = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
    actualTimeWork.setZdt(zdt);
    ZoneOffset zid = ZoneOffset.ofTotalSeconds(1);
    actualTimeWork.setZid(zid);
    Instant actualI = actualTimeWork.getI();
    LocalDate actualLd = actualTimeWork.getLd();
    LocalDateTime actualLdt = actualTimeWork.getLdt();
    LocalTime actualLt = actualTimeWork.getLt();
    ZonedDateTime actualZdt = actualTimeWork.getZdt();
    ZoneId actualZid = actualTimeWork.getZid();

    // Assert
    assertEquals("+00:00:01", actualZid.toString());
    assertEquals("1970-01-01", actualLd.toString());
    assertSame(ldt, actualLdt);
    assertSame(zdt, actualZdt);
    assertSame(ld, actualLd);
    assertSame(zid, actualZid);
    assertSame(Instant.EPOCH, actualI);
    assertSame(LocalTime.MIN, actualLt);
  }
}
