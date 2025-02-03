package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
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
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.work.TimeWork.<init>()",
      "java.time.Instant org.finos.springbot.tests.work.TimeWork.getI()",
      "java.time.LocalDate org.finos.springbot.tests.work.TimeWork.getLd()",
      "java.time.LocalDateTime org.finos.springbot.tests.work.TimeWork.getLdt()",
      "java.time.LocalTime org.finos.springbot.tests.work.TimeWork.getLt()",
      "java.time.ZonedDateTime org.finos.springbot.tests.work.TimeWork.getZdt()",
      "java.time.ZoneId org.finos.springbot.tests.work.TimeWork.getZid()",
      "void org.finos.springbot.tests.work.TimeWork.setI(java.time.Instant)",
      "void org.finos.springbot.tests.work.TimeWork.setLd(java.time.LocalDate)",
      "void org.finos.springbot.tests.work.TimeWork.setLdt(java.time.LocalDateTime)",
      "void org.finos.springbot.tests.work.TimeWork.setLt(java.time.LocalTime)",
      "void org.finos.springbot.tests.work.TimeWork.setZdt(java.time.ZonedDateTime)",
      "void org.finos.springbot.tests.work.TimeWork.setZid(java.time.ZoneId)"})
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
    assertSame(actualI.EPOCH, actualI);
    assertSame(actualLt.MIN, actualLt);
  }
}
