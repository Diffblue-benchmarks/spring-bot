package org.finos.springbot.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.user.Mention;
import com.symphony.user.UserId;
import java.util.List;
import org.finos.springbot.entityjson.VersionSpace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.symphonyoss.Taxonomy;
import org.symphonyoss.fin.Security;
import org.symphonyoss.fin.security.id.Cusip;
import org.symphonyoss.fin.security.id.Isin;
import org.symphonyoss.fin.security.id.Openfigi;
import org.symphonyoss.fin.security.id.Ticker;
import org.symphonyoss.taxonomy.Hashtag;

class VersionSpaceHelpDiffblueTest {
  /**
   * Test {@link VersionSpaceHelp#basicSymphonyVersionSpace()}.
   * <p>
   * Method under test: {@link VersionSpaceHelp#basicSymphonyVersionSpace()}
   */
  @Test
  @DisplayName("Test basicSymphonyVersionSpace()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List VersionSpaceHelp.basicSymphonyVersionSpace()"})
  void testBasicSymphonyVersionSpace() {
    // Arrange and Act
    List<VersionSpace> actualBasicSymphonyVersionSpaceResult = VersionSpaceHelp.basicSymphonyVersionSpace();

    // Assert
    assertEquals(9, actualBasicSymphonyVersionSpaceResult.size());
    VersionSpace getResult = actualBasicSymphonyVersionSpaceResult.get(5);
    assertEquals("", getResult.writeVersion);
    VersionSpace getResult2 = actualBasicSymphonyVersionSpaceResult.get(6);
    assertEquals("", getResult2.writeVersion);
    VersionSpace getResult3 = actualBasicSymphonyVersionSpaceResult.get(7);
    assertEquals("", getResult3.writeVersion);
    VersionSpace getResult4 = actualBasicSymphonyVersionSpaceResult.get(8);
    assertEquals("", getResult4.writeVersion);
    assertEquals(", ", getResult.getVersions());
    assertEquals(", ", getResult2.getVersions());
    assertEquals(", ", getResult3.getVersions());
    assertEquals(", ", getResult4.getVersions());
    VersionSpace getResult5 = actualBasicSymphonyVersionSpaceResult.get(0);
    assertEquals("1.0", getResult5.writeVersion);
    VersionSpace getResult6 = actualBasicSymphonyVersionSpaceResult.get(1);
    assertEquals("1.0", getResult6.writeVersion);
    VersionSpace getResult7 = actualBasicSymphonyVersionSpaceResult.get(2);
    assertEquals("1.0", getResult7.writeVersion);
    VersionSpace getResult8 = actualBasicSymphonyVersionSpaceResult.get(3);
    assertEquals("1.0", getResult8.writeVersion);
    VersionSpace getResult9 = actualBasicSymphonyVersionSpaceResult.get(4);
    assertEquals("1.0", getResult9.writeVersion);
    assertEquals("1.0, ", getResult5.getVersions());
    assertEquals("1.0, ", getResult7.getVersions());
    assertEquals("1.0, ", getResult8.getVersions());
    assertEquals("1.0, ", getResult9.getVersions());
    assertEquals("1.0, , 0.*", getResult6.getVersions());
    assertEquals("com.symphony.user.mention", getResult7.typeName);
    assertEquals("com.symphony.user.userId", getResult8.typeName);
    assertEquals("org.symphonyoss.fin.security", getResult6.typeName);
    assertEquals("org.symphonyoss.fin.security.id.cusip", getResult2.typeName);
    assertEquals("org.symphonyoss.fin.security.id.isin", getResult3.typeName);
    assertEquals("org.symphonyoss.fin.security.id.openfigi", getResult4.typeName);
    assertEquals("org.symphonyoss.fin.security.id.ticker", getResult.typeName);
    assertEquals("org.symphonyoss.taxonomy", getResult5.typeName);
    assertEquals("org.symphonyoss.taxonomy.hashtag", getResult9.typeName);
    Class<Mention> expectedToUse = Mention.class;
    assertEquals(expectedToUse, getResult7.getToUse());
    Class<UserId> expectedToUse2 = UserId.class;
    assertEquals(expectedToUse2, getResult8.getToUse());
    Class<Taxonomy> expectedToUse3 = Taxonomy.class;
    assertEquals(expectedToUse3, getResult5.getToUse());
    Class<Security> expectedToUse4 = Security.class;
    assertEquals(expectedToUse4, getResult6.getToUse());
    Class<Cusip> expectedToUse5 = Cusip.class;
    assertEquals(expectedToUse5, getResult2.getToUse());
    Class<Isin> expectedToUse6 = Isin.class;
    assertEquals(expectedToUse6, getResult3.getToUse());
    Class<Openfigi> expectedToUse7 = Openfigi.class;
    assertEquals(expectedToUse7, getResult4.getToUse());
    Class<Ticker> expectedToUse8 = Ticker.class;
    assertEquals(expectedToUse8, getResult.getToUse());
    Class<Hashtag> expectedToUse9 = Hashtag.class;
    assertEquals(expectedToUse9, getResult9.getToUse());
  }
}
