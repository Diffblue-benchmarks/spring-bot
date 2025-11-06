package org.finos.springbot.symphony.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.symphony.user.DisplayName;
import com.symphony.user.EmailAddress;
import com.symphony.user.StreamID;
import java.util.List;
import org.finos.springbot.entityjson.VersionSpace;
import org.junit.jupiter.api.Test;

class SymphonyDataHandlerCofigDiffblueTest {
  /**
   * Method under test:
   * {@link SymphonyDataHandlerCofig#syphonyExtendedVersionSpace()}
   */
  @Test
  void testSyphonyExtendedVersionSpace() {
    // Arrange and Act
    List<VersionSpace> actualSyphonyExtendedVersionSpaceResult = SymphonyDataHandlerCofig.syphonyExtendedVersionSpace();

    // Assert
    assertEquals(3, actualSyphonyExtendedVersionSpaceResult.size());
    VersionSpace getResult = actualSyphonyExtendedVersionSpaceResult.get(0);
    assertEquals("1.0", getResult.writeVersion);
    VersionSpace getResult2 = actualSyphonyExtendedVersionSpaceResult.get(1);
    assertEquals("1.0", getResult2.writeVersion);
    VersionSpace getResult3 = actualSyphonyExtendedVersionSpaceResult.get(2);
    assertEquals("1.0", getResult3.writeVersion);
    assertEquals("1.0, ", getResult.getVersions());
    assertEquals("1.0, ", getResult2.getVersions());
    assertEquals("1.0, ", getResult3.getVersions());
    assertEquals("com.symphony.user.displayName", getResult.typeName);
    assertEquals("com.symphony.user.emailAddress", getResult3.typeName);
    assertEquals("com.symphony.user.streamID", getResult2.typeName);
    Class<DisplayName> expectedToUse = DisplayName.class;
    assertEquals(expectedToUse, getResult.getToUse());
    Class<EmailAddress> expectedToUse2 = EmailAddress.class;
    assertEquals(expectedToUse2, getResult3.getToUse());
    Class<StreamID> expectedToUse3 = StreamID.class;
    assertEquals(expectedToUse3, getResult2.getToUse());
  }
}
