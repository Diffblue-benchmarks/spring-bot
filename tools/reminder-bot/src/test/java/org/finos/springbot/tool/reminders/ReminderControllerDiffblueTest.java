package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Table;
import org.finos.springbot.workflow.content.Table.TableImpl;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.content.Word;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ReminderController.class, ReminderProperties.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ReminderControllerDiffblueTest {
  @MockBean
  private AllHistory allHistory;

  @Autowired
  private ReminderController reminderController;

  @Autowired
  private ReminderProperties reminderProperties;

  /**
   * Test {@link ReminderController#addreminder(Reminder, Addressable, User)}.
   * <ul>
   *   <li>Then return {@link ReminderList#ReminderList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReminderController#addreminder(Reminder, Addressable, User)}
   */
  @Test
  @DisplayName("Test addreminder(Reminder, Addressable, User); then return ReminderList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReminderList ReminderController.addreminder(Reminder, Addressable, User)"})
  void testAddreminder_thenReturnReminderList() {
    // Arrange
    ReminderList reminderList = new ReminderList();
    Optional<Object> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any())).thenReturn(ofResult);

    Reminder cr = new Reminder();
    cr.setAuthor(new SymphonyUser(1L));
    cr.setDescription("The characteristics of someone or something");
    cr.setLocalTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    Addressable a = mock(Addressable.class);

    // Act
    ReminderList actualAddreminderResult = reminderController.addreminder(cr, a, new SymphonyUser(1L));

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
    assertSame(reminderList, actualAddreminderResult);
  }

  /**
   * Test {@link ReminderController#addreminder(Reminder, Addressable, User)}.
   * <ul>
   *   <li>Then return TimeZone toString is {@code Europe/London}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReminderController#addreminder(Reminder, Addressable, User)}
   */
  @Test
  @DisplayName("Test addreminder(Reminder, Addressable, User); then return TimeZone toString is 'Europe/London'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReminderList ReminderController.addreminder(Reminder, Addressable, User)"})
  void testAddreminder_thenReturnTimeZoneToStringIsEuropeLondon() {
    // Arrange
    Optional<Object> emptyResult = Optional.empty();
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any()))
        .thenReturn(emptyResult);

    Reminder cr = new Reminder();
    cr.setAuthor(new SymphonyUser(1L));
    cr.setDescription("The characteristics of someone or something");
    cr.setLocalTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    Addressable a = mock(Addressable.class);

    // Act
    ReminderList actualAddreminderResult = reminderController.addreminder(cr, a, new SymphonyUser(1L));

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
    assertEquals("Europe/London", actualAddreminderResult.getTimeZone().toString());
    assertEquals(0, actualAddreminderResult.remindBefore.intValue());
    assertEquals(0, actualAddreminderResult.getRemindBefore());
    List<Reminder> reminders = actualAddreminderResult.getReminders();
    assertEquals(1, reminders.size());
    assertSame(cr, reminders.get(0));
  }

  /**
   * Test {@link ReminderController#list(Addressable)}.
   * <ul>
   *   <li>Then return {@link ReminderList#ReminderList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReminderController#list(Addressable)}
   */
  @Test
  @DisplayName("Test list(Addressable); then return ReminderList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReminderList ReminderController.list(Addressable)"})
  void testList_thenReturnReminderList() {
    // Arrange
    ReminderList reminderList = new ReminderList();
    Optional<Object> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any())).thenReturn(ofResult);

    // Act
    ReminderList actualListResult = reminderController.list(mock(Addressable.class));

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
    assertSame(reminderList, actualListResult);
  }

  /**
   * Test {@link ReminderController#list(Addressable)}.
   * <ul>
   *   <li>Then return TimeZone toString is {@code Europe/London}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReminderController#list(Addressable)}
   */
  @Test
  @DisplayName("Test list(Addressable); then return TimeZone toString is 'Europe/London'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReminderList ReminderController.list(Addressable)"})
  void testList_thenReturnTimeZoneToStringIsEuropeLondon() {
    // Arrange
    Optional<Object> emptyResult = Optional.empty();
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any()))
        .thenReturn(emptyResult);

    // Act
    ReminderList actualListResult = reminderController.list(mock(Addressable.class));

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
    assertEquals("Europe/London", actualListResult.getTimeZone().toString());
    assertEquals(0, actualListResult.remindBefore.intValue());
    assertEquals(0, actualListResult.getRemindBefore());
    assertTrue(actualListResult.getReminders().isEmpty());
  }

  /**
   * Test {@link ReminderController#save(ReminderList)}.
   * <p>
   * Method under test: {@link ReminderController#save(ReminderList)}
   */
  @Test
  @DisplayName("Test save(ReminderList)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReminderList ReminderController.save(ReminderList)"})
  void testSave() {
    // Arrange
    ReminderList rl = new ReminderList();

    // Act and Assert
    assertSame(rl, reminderController.save(rl));
  }

  /**
   * Test {@link ReminderController#edit(ReminderList)}.
   * <p>
   * Method under test: {@link ReminderController#edit(ReminderList)}
   */
  @Test
  @DisplayName("Test edit(ReminderList)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReminderList ReminderController.edit(ReminderList)"})
  void testEdit() {
    // Arrange
    ReminderList rl = new ReminderList();

    // Act and Assert
    assertSame(rl, reminderController.edit(rl));
  }

  /**
   * Test {@link ReminderController#timezones()}.
   * <p>
   * Method under test: {@link ReminderController#timezones()}
   */
  @Test
  @DisplayName("Test timezones()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map ReminderController.timezones()"})
  void testTimezones() {
    // Arrange and Act
    Map<String, String> actualTimezonesResult = reminderController.timezones();

    // Assert
    assertEquals(604, actualTimezonesResult.size());
    assertEquals("Africa/Cairo", actualTimezonesResult.get("Africa/Cairo"));
    assertEquals("Africa/Nairobi", actualTimezonesResult.get("Africa/Nairobi"));
    assertEquals("America/Cuiaba", actualTimezonesResult.get("America/Cuiaba"));
    assertEquals("America/El_Salvador", actualTimezonesResult.get("America/El_Salvador"));
    assertEquals("America/Marigot", actualTimezonesResult.get("America/Marigot"));
    assertEquals("Asia/Aden", actualTimezonesResult.get("Asia/Aden"));
    assertEquals("Asia/Aqtau", actualTimezonesResult.get("Asia/Aqtau"));
    assertEquals("Asia/Pontianak", actualTimezonesResult.get("Asia/Pontianak"));
    assertEquals("Etc/GMT+8", actualTimezonesResult.get("Etc/GMT+8"));
    assertEquals("Etc/GMT+9", actualTimezonesResult.get("Etc/GMT+9"));
    assertEquals("Pacific/Kwajalein", actualTimezonesResult.get("Pacific/Kwajalein"));
  }

  /**
   * Test {@link ReminderController#timezones(Addressable)} with {@code Addressable}.
   * <p>
   * Method under test: {@link ReminderController#timezones(Addressable)}
   */
  @Test
  @DisplayName("Test timezones(Addressable) with 'Addressable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Response ReminderController.timezones(Addressable)"})
  void testTimezonesWithAddressable() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act
    Response actualTimezonesResult = reminderController.timezones(a);

    // Assert
    Content message = ((MessageResponse) actualTimezonesResult).getMessage();
    assertTrue(message instanceof TableImpl);
    assertTrue(actualTimezonesResult instanceof MessageResponse);
    assertNull(((MessageResponse) actualTimezonesResult).getTemplateName());
    assertEquals(1, ((TableImpl) message).getColumnNames().size());
    List<List<Content>> data = ((TableImpl) message).getData();
    assertEquals(18, data.size());
    assertEquals(2, data.get(0).size());
    assertEquals(2, data.get(1).size());
    assertEquals(2, data.get(17).size());
    assertEquals(2, data.get(Short.SIZE).size());
    assertTrue(((MessageResponse) actualTimezonesResult).getData().isEmpty());
    String expectedText = String.join("",
        " Region Zone Europe Europe/Amsterdam Europe/Andorra Europe/Astrakhan Europe/Athens Europe/Belfast"
            + " Europe/Belgrade Europe/Berlin Europe/Bratislava Europe/Brussels Europe/Bucharest Europe/Budapest"
            + " Europe/Busingen Europe/Chisinau Europe/Copenhagen Europe/Dublin Europe/Gibraltar Europe/Guernsey"
            + " Europe/Helsinki Europe/Isle_of_Man Europe/Istanbul Europe/Jersey Europe/Kaliningrad Europe/Kiev"
            + " Europe/Kirov Europe/Kyiv Europe/Lisbon Europe/Ljubljana Europe/London Europe/Luxembourg Europe/Madrid"
            + " Europe/Malta Europe/Mariehamn Europe/Minsk Europe/Monaco Europe/Moscow Europe/Nicosia Europe/Oslo"
            + " Europe/Paris Europe/Podgorica Europe/Prague Europe/Riga Europe/Rome Europe/Samara Europe/San_Marino"
            + " Europe/Sarajevo Europe/Saratov Europe/Simferopol Europe/Skopje Europe/Sofia Europe/Stockholm"
            + " Europe/Tallinn Europe/Tirane Europe/Tiraspol Europe/Ulyanovsk Europe/Uzhgorod Europe/Vaduz Europe/Vatican"
            + " Europe/Vienna Europe/Vilnius Europe/Volgograd Europe/Warsaw Europe/Zagreb Europe/Zaporozhye Europe/Zurich"
            + " Africa Africa/Abidjan Africa/Accra Africa/Addis_Ababa Africa/Algiers Africa/Asmara Africa/Asmera"
            + " Africa/Bamako Africa/Bangui Africa/Banjul Africa/Bissau Africa/Blantyre Africa/Brazzaville Africa/Bujumbura"
            + " Africa/Cairo Africa/Casablanca Africa/Ceuta Africa/Conakry Africa/Dakar Africa/Dar_es_Salaam"
            + " Africa/Djibouti Africa/Douala Africa/El_Aaiun Africa/Freetown Africa/Gaborone Africa/Harare"
            + " Africa/Johannesburg Africa/Juba Africa/Kampala Africa/Khartoum Africa/Kigali Africa/Kinshasa Africa/Lagos"
            + " Africa/Libreville Africa/Lome Africa/Luanda Africa/Lubumbashi Africa/Lusaka Africa/Malabo Africa/Maputo"
            + " Africa/Maseru Africa/Mbabane Africa/Mogadishu Africa/Monrovia Africa/Nairobi Africa/Ndjamena Africa/Niamey"
            + " Africa/Nouakchott Africa/Ouagadougou Africa/Porto-Novo Africa/Sao_Tome Africa/Timbuktu Africa/Tripoli"
            + " Africa/Tunis Africa/Windhoek none CET CST6CDT Cuba EET EST5EDT Egypt Eire GB GB-Eire GMT GMT0 Greenwich"
            + " Hongkong Iceland Iran Israel Jamaica Japan Kwajalein Libya MET MST7MDT NZ NZ-CHAT Navajo PRC PST8PDT"
            + " Poland Portugal ROK Singapore Turkey UCT UTC Universal W-SU WET Zulu SystemV SystemV/AST4 SystemV/AST4ADT"
            + " SystemV/CST6 SystemV/CST6CDT SystemV/EST5 SystemV/EST5EDT SystemV/HST10 SystemV/MST7 SystemV/MST7MDT"
            + " SystemV/PST8 SystemV/PST8PDT SystemV/YST9 SystemV/YST9YDT Canada Canada/Atlantic Canada/Central"
            + " Canada/Eastern Canada/Mountain Canada/Newfoundland Canada/Pacific Canada/Saskatchewan Canada/Yukon"
            + " Pacific Pacific/Apia Pacific/Auckland Pacific/Bougainville Pacific/Chatham Pacific/Chuuk Pacific/Easter"
            + " Pacific/Efate Pacific/Enderbury Pacific/Fakaofo Pacific/Fiji Pacific/Funafuti Pacific/Galapagos"
            + " Pacific/Gambier Pacific/Guadalcanal Pacific/Guam Pacific/Honolulu Pacific/Johnston Pacific/Kanton"
            + " Pacific/Kiritimati Pacific/Kosrae Pacific/Kwajalein Pacific/Majuro Pacific/Marquesas Pacific/Midway"
            + " Pacific/Nauru Pacific/Niue Pacific/Norfolk Pacific/Noumea Pacific/Pago_Pago Pacific/Palau Pacific/Pitcairn"
            + " Pacific/Pohnpei Pacific/Ponape Pacific/Port_Moresby Pacific/Rarotonga Pacific/Saipan Pacific/Samoa"
            + " Pacific/Tahiti Pacific/Tarawa Pacific/Tongatapu Pacific/Truk Pacific/Wake Pacific/Wallis Pacific/Yap"
            + " Etc Etc/GMT Etc/GMT+0 Etc/GMT+1 Etc/GMT+10 Etc/GMT+11 Etc/GMT+12 Etc/GMT+2 Etc/GMT+3 Etc/GMT+4 Etc/GMT+5"
            + " Etc/GMT+6 Etc/GMT+7 Etc/GMT+8 Etc/GMT+9 Etc/GMT-0 Etc/GMT-1 Etc/GMT-10 Etc/GMT-11 Etc/GMT-12 Etc/GMT-13"
            + " Etc/GMT-14 Etc/GMT-2 Etc/GMT-3 Etc/GMT-4 Etc/GMT-5 Etc/GMT-6 Etc/GMT-7 Etc/GMT-8 Etc/GMT-9 Etc/GMT0"
            + " Etc/Greenwich Etc/UCT ",
        System.getProperty("user.timezone"),
        " Etc/Universal Etc/Zulu Asia Asia/Aden Asia/Almaty Asia/Amman Asia/Anadyr Asia/Aqtau Asia/Aqtobe"
            + " Asia/Ashgabat Asia/Ashkhabad Asia/Atyrau Asia/Baghdad Asia/Bahrain Asia/Baku Asia/Bangkok Asia/Barnaul"
            + " Asia/Beirut Asia/Bishkek Asia/Brunei Asia/Calcutta Asia/Chita Asia/Choibalsan Asia/Chongqing"
            + " Asia/Chungking Asia/Colombo Asia/Dacca Asia/Damascus Asia/Dhaka Asia/Dili Asia/Dubai Asia/Dushanbe"
            + " Asia/Famagusta Asia/Gaza Asia/Harbin Asia/Hebron Asia/Ho_Chi_Minh Asia/Hong_Kong Asia/Hovd Asia/Irkutsk"
            + " Asia/Istanbul Asia/Jakarta Asia/Jayapura Asia/Jerusalem Asia/Kabul Asia/Kamchatka Asia/Karachi"
            + " Asia/Kashgar Asia/Kathmandu Asia/Katmandu Asia/Khandyga Asia/Kolkata Asia/Krasnoyarsk Asia/Kuala_Lumpur"
            + " Asia/Kuching Asia/Kuwait Asia/Macao Asia/Macau Asia/Magadan Asia/Makassar Asia/Manila Asia/Muscat"
            + " Asia/Nicosia Asia/Novokuznetsk Asia/Novosibirsk Asia/Omsk Asia/Oral Asia/Phnom_Penh Asia/Pontianak"
            + " Asia/Pyongyang Asia/Qatar Asia/Qostanay Asia/Qyzylorda Asia/Rangoon Asia/Riyadh Asia/Saigon Asia/Sakhalin"
            + " Asia/Samarkand Asia/Seoul Asia/Shanghai Asia/Singapore Asia/Srednekolymsk Asia/Taipei Asia/Tashkent"
            + " Asia/Tbilisi Asia/Tehran Asia/Tel_Aviv Asia/Thimbu Asia/Thimphu Asia/Tokyo Asia/Tomsk Asia/Ujung_Pandang"
            + " Asia/Ulaanbaatar Asia/Ulan_Bator Asia/Urumqi Asia/Ust-Nera Asia/Vientiane Asia/Vladivostok Asia/Yakutsk"
            + " Asia/Yangon Asia/Yekaterinburg Asia/Yerevan America America/Adak America/Anchorage America/Anguilla"
            + " America/Antigua America/Araguaina America/Argentina/Buenos_Aires America/Argentina/Catamarca"
            + " America/Argentina/ComodRivadavia America/Argentina/Cordoba America/Argentina/Jujuy America/Argentina"
            + "/La_Rioja America/Argentina/Mendoza America/Argentina/Rio_Gallegos America/Argentina/Salta America"
            + "/Argentina/San_Juan America/Argentina/San_Luis America/Argentina/Tucuman America/Argentina/Ushuaia"
            + " America/Aruba America/Asuncion America/Atikokan America/Atka America/Bahia America/Bahia_Banderas"
            + " America/Barbados America/Belem America/Belize America/Blanc-Sablon America/Boa_Vista America/Bogota"
            + " America/Boise America/Buenos_Aires America/Cambridge_Bay America/Campo_Grande America/Cancun"
            + " America/Caracas America/Catamarca America/Cayenne America/Cayman America/Chicago America/Chihuahua"
            + " America/Ciudad_Juarez America/Coral_Harbour America/Cordoba America/Costa_Rica America/Coyhaique"
            + " America/Creston America/Cuiaba America/Curacao America/Danmarkshavn America/Dawson America/Dawson_Creek"
            + " America/Denver America/Detroit America/Dominica America/Edmonton America/Eirunepe America/El_Salvador"
            + " America/Ensenada America/Fort_Nelson America/Fort_Wayne America/Fortaleza America/Glace_Bay America/Godthab"
            + " America/Goose_Bay America/Grand_Turk America/Grenada America/Guadeloupe America/Guatemala America/Guayaquil"
            + " America/Guyana America/Halifax America/Havana America/Hermosillo America/Indiana/Indianapolis"
            + " America/Indiana/Knox America/Indiana/Marengo America/Indiana/Petersburg America/Indiana/Tell_City"
            + " America/Indiana/Vevay America/Indiana/Vincennes America/Indiana/Winamac America/Indianapolis"
            + " America/Inuvik America/Iqaluit America/Jamaica America/Jujuy America/Juneau America/Kentucky/Louisville"
            + " America/Kentucky/Monticello America/Knox_IN America/Kralendijk America/La_Paz America/Lima"
            + " America/Los_Angeles America/Louisville America/Lower_Princes America/Maceio America/Managua America/Manaus"
            + " America/Marigot America/Martinique America/Matamoros America/Mazatlan America/Mendoza America/Menominee"
            + " America/Merida America/Metlakatla America/Mexico_City America/Miquelon America/Moncton America/Monterrey"
            + " America/Montevideo America/Montreal America/Montserrat America/Nassau America/New_York America/Nipigon"
            + " America/Nome America/Noronha America/North_Dakota/Beulah America/North_Dakota/Center America/North"
            + "_Dakota/New_Salem America/Nuuk America/Ojinaga America/Panama America/Pangnirtung America/Paramaribo"
            + " America/Phoenix America/Port-au-Prince America/Port_of_Spain America/Porto_Acre America/Porto_Velho"
            + " America/Puerto_Rico America/Punta_Arenas America/Rainy_River America/Rankin_Inlet America/Recife"
            + " America/Regina America/Resolute America/Rio_Branco America/Rosario America/Santa_Isabel America/Santarem"
            + " America/Santiago America/Santo_Domingo America/Sao_Paulo America/Scoresbysund America/Shiprock"
            + " America/Sitka America/St_Barthelemy America/St_Johns America/St_Kitts America/St_Lucia America/St_Thomas"
            + " America/St_Vincent America/Swift_Current America/Tegucigalpa America/Thule America/Thunder_Bay"
            + " America/Tijuana America/Toronto America/Tortola America/Vancouver America/Virgin America/Whitehorse"
            + " America/Winnipeg America/Yakutat America/Yellowknife Brazil Brazil/Acre Brazil/DeNoronha Brazil/East"
            + " Brazil/West Mexico Mexico/BajaNorte Mexico/BajaSur Mexico/General Indian Indian/Antananarivo Indian/Chagos"
            + " Indian/Christmas Indian/Cocos Indian/Comoro Indian/Kerguelen Indian/Mahe Indian/Maldives Indian/Mauritius"
            + " Indian/Mayotte Indian/Reunion Antarctica Antarctica/Casey Antarctica/Davis Antarctica/DumontDUrville"
            + " Antarctica/Macquarie Antarctica/Mawson Antarctica/McMurdo Antarctica/Palmer Antarctica/Rothera"
            + " Antarctica/South_Pole Antarctica/Syowa Antarctica/Troll Antarctica/Vostok Chile Chile/Continental"
            + " Chile/EasterIsland Australia Australia/ACT Australia/Adelaide Australia/Brisbane Australia/Broken_Hill"
            + " Australia/Canberra Australia/Currie Australia/Darwin Australia/Eucla Australia/Hobart Australia/LHI"
            + " Australia/Lindeman Australia/Lord_Howe Australia/Melbourne Australia/NSW Australia/North Australia/Perth"
            + " Australia/Queensland Australia/South Australia/Sydney Australia/Tasmania Australia/Victoria Australia/West"
            + " Australia/Yancowinna Arctic Arctic/Longyearbyen Atlantic Atlantic/Azores Atlantic/Bermuda Atlantic/Canary"
            + " Atlantic/Cape_Verde Atlantic/Faeroe Atlantic/Faroe Atlantic/Jan_Mayen Atlantic/Madeira Atlantic/Reykjavik"
            + " Atlantic/South_Georgia Atlantic/St_Helena Atlantic/Stanley US US/Alaska US/Aleutian US/Arizona"
            + " US/Central US/East-Indiana US/Eastern US/Hawaii US/Indiana-Starke US/Michigan US/Mountain US/Pacific"
            + " US/Samoa");
    assertEquals(expectedText, message.getText());
    assertSame(a, actualTimezonesResult.getAddress());
  }

  /**
   * Test {@link ReminderController#remindbefore(Addressable, Word)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Word} {@link Content#getText()} return {@code 42}.</li>
   *   <li>Then return {@link ReminderList#ReminderList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReminderController#remindbefore(Addressable, Word)}
   */
  @Test
  @DisplayName("Test remindbefore(Addressable, Word); given '42'; when Word getText() return '42'; then return ReminderList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReminderList ReminderController.remindbefore(Addressable, Word)"})
  void testRemindbefore_given42_whenWordGetTextReturn42_thenReturnReminderList() {
    // Arrange
    ReminderList reminderList = new ReminderList();
    Optional<Object> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any())).thenReturn(ofResult);
    Addressable a = mock(Addressable.class);
    Word duration = mock(Word.class);
    when(duration.getText()).thenReturn("42");

    // Act
    ReminderList actualRemindbeforeResult = reminderController.remindbefore(a, duration);

    // Assert
    verify(duration).getText();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
    assertSame(reminderList, actualRemindbeforeResult);
  }
}
