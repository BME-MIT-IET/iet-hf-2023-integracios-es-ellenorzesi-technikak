# UI teszt dokumentáció - MenuFrameTest

Ez a dokumentum a `MenuFrameTest` és az `GameFrameTest` osztályban implementált UI tesztek dokumentációját tartalmazza. A tesztek Java nyelven íródtak, és az AssertJSwingJUnit keretrendszert használják az UI teszteléshez.

## Tesztosztály: `MenuFrameTest`

### Osztály leírása
A `MenuFrameTest` osztály UI-teszteket tartalmaz a `MenuFrame` osztályhoz, amely az alkalmazásban egy menüablakot képvisel. A tesztek különböző UI elemeket és azok viselkedését ellenőrzik a menüablakon belül.

#### 1. `testWindowTitle`
- Leírás: Ellenőrzi, hogy a menüablak ablakcíme helyesen van-e beállítva.
- Tesztlépések:
  - Meggyőződik róla, hogy a menüablak címe `Blind Virologists`.
- Várt eredmény: Az ablak címe megegyezik a `Blind Virologists` címmel.

#### 2. `testButtonNewGame`
- Leírás: Ellenőrzi az `New Game` gomb tulajdonságait és viselkedését a menüablakban.
- Tesztelési lépések:
  - Megkeresi az `New Game` gombot.
  - Meggyőződik róla, hogy a gomb engedélyezve van, látható, és megjeleníti az `New Game` szöveget.
- Várt eredmény: Az `New Game` gomb engedélyezve van, látható, és megjeleníti az `New Game` szöveget.

#### 3. `testButtonLoadGame`
- Leírás: A menüablakban lévő `Load Game` gomb tulajdonságainak és viselkedésének ellenőrzése.
- Tesztlépések:
  - Megkeresi a `Load Game` gombot.
  - Meggyőződik róla, hogy a gomb engedélyezve van, látható, és megjeleníti a `Load Game` szöveget.
- Várt eredmény: A `Load Game` gomb engedélyezve van, látható, és megjeleníti a `Load Game` szöveget.

#### 4. `testLabelTitle`.
- Leírás: A menüablakban lévő címke tulajdonságainak ellenőrzése.
- Tesztlépések:
  - Megkeresi a `Blind Virologists` szöveget tartalmazó címkét.
  - Meggyőződik róla, hogy a címke látható és engedélyezett.
- Várt eredmény: A címke látható és engedélyezve van.

#### 5. `testLabelNumberOfPlayers`
- Leírás: A `Number of players` címke tulajdonságainak ellenőrzése a menüablakban.
- Tesztlépések:
  - Megkeresi a `Number of players` szövegű címkét.
  - Meggyőződik róla, hogy a címke látható és engedélyezett.
- Várt eredmény: A `Number of players` címke látható és engedélyezett.

#### 6. `testTextFieldPlayerCount`
- Leírás: A `Number of players` szövegmező tulajdonságainak és viselkedésének ellenőrzése.
- Tesztlépések:
  - Megkeresi a `Number of players` szövegű címkét.
  - Meggyőződik róla, hogy a szövegmező látható, engedélyezett, szerkeszthető és a `2` szöveget jeleníti meg.
  - Rákattint a szövegmezőre, és ellenőrzi, hogy fókuszba kerül-e.
  - Szimulálja a backspace billentyű lenyomását a szövegmező törléséhez.
  - Meggyőződik róla, hogy a szövegmező üres lesz.
  - Beírja a `123` szöveget a szövegmezőbe.
  - Meggyőződik róla, hogy a szövegmezőben megjelenik a `123` szöveg.
- Várt eredmény: A `Number of players` szövegmező látható, engedélyezett, szerkeszthető, és a leírtaknak megfelelően viselkedik.

#### 7. `testButtonClickNewGame`
- Leírás: A `New Game` gombra kattintás eseményének viselkedésének ellenőrzése a menüablakban.
- Tesztlépések:
  - Rákattint a `New Game` gombra.
  - Megkeresi a játékablakot, amely a gombra kattintás eredményeként megnyílik.
  - Meggyőződik róla, hogy a játékablak címe `Blind Virologists` és a `GameFrame` osztály példánya.
- Várt eredmény: Az `New Game` gombra kattintás eseménye megnyitja a játékablakot a megfelelő címmel.

#### 8. `testTextFieldPlayerCountOnlyNumericalValueAllowed`
- Leírás: Ellenőrzi, hogy a `Number of players` szövegmezőben csak numerikus értékek engedélyezettek-e.
- Tesztlépések:
  - Megkeresi a `Number of players` szövegmezőt.
  - Rákattint a szövegmezőre, és beírja a `The` szöveget (nem numerikus érték).
  - Meggyőződik róla, hogy a szövegmező megtartja a `2` eredeti értékét.
- Várt eredmény: A `Number of players` szövegmező nem fogad el nem számszerű értékeket, és megtartja eredeti értékét.

#### 9. `testTextFieldPlayerCountMaxLengthLimited`
- Leírás: Ellenőrzi, hogy a `Number of players` szövegmező maximális hossza korlátozott-e.
- Tesztlépések:
  - Megkeresi a `Number of players` szövegmezőt.
  - Rákattint a szövegmezőre, és szimulálják a backspace billentyű lenyomását.
  - Beírja a `012345678910` szöveget (11 karakter).
  - Meggyőződik róla, hogy a szövegmező a bevitelt legfeljebb 10 karakter hosszúságúra vágja le.
- Várt eredmény: A `Number of players` szövegmező a bevitelt legfeljebb 10 karakter hosszúságúra korlátozza.


## Tesztosztály: `GameFrameTest`

### Osztály Leírás
A `GameFrameTest` osztály UI teszteket tartalmaz a `GameFrame` osztályhoz, mely az alkalmazásban egy játékablakot reprezentál. A tesztek ellenőrzik a különböző UI elemeket és viselkedésüket a játékablakon belül.

### Teszt Metódusok

#### 1. `testButtonSearchField`
- Leírás: Ellenőrzi a `Search Field` gomb viselkedését a játékablakban.
- Teszt Lépések:
  - Előkészíti a friss játékkörnyezetet, beleértve egy `Axe` felszerelést, egy `Virologist`-et és egy másik `Virologist`-et.
  - Megtalálja a `Search Field` gombot.
  - Rákattint a  gombra.
  - Ellenőrzi, hogy az első `Virologist` felveszi az `Axe` felszerelést.
- Várt Eredmény: A `Search Field` gomb hatására az első `Virologist` által felveszi az `Axe` felszerelést.

#### 2. `testComboBoxVirologists`
- Leírás: Ellenőrzi a virológusok kombinált doboz viselkedését a játékablakban.
- Teszt Lépések:
  - Előkészíti a friss játékkörnyezetet, beleértve egy `FreeField`-et, egy `Virologist`-et és egy másik `Virologist`-et.
  - Megtalálja a virológusok kombinált dobozát.
  - Ellenőrzi, hogy a kombinált doboz tartalmazza-e az összes virológus nevét a játékban.
  - Kiválasztja a második virológust a kombinált dobozból.
  - Ellenőrzi, hogy a második virológus ki van-e választva a kombinált dobozban.
- Várt Eredmény: A virológusok kombinált doboz megjeleníti az összes virológust és lehetővé teszi egy adott virológus kiválasztását.

#### 3. `testComboBoxCodes`
- Leírás: Ellenőrzi a kódok kombinált doboz viselkedését a játékablakban.
- Teszt Lépések:
  - Előkészíti a friss játékkörnyezetet, beleértve egy `Laboratory`-t, egy `Protection` kódot, egy `Virologist`-et és egy másik `Virologist`-et.
  - Megtalálja a kódok kombinált dobozát.
  - Ellenőrzi, hogy a kombinált doboz tartalmazza-e az elérhető kódokat.
- Várt Eredmény: A kódok kombinált doboz megjeleníti a rendelkezésre álló kódokat a játékban.

#### 4. `testLearnParalysingAndParalyseAndRob`
- Leírás: Ellenőrzi a `Search Field` gomb, a kódok kombinált doboz és a virológusok kombinált doboz együttes viselkedését a játékablakban.
- Teszt Lépések:
  - Előkészíti a friss játékkörnyezetet, beleértve egy `Laboratory`-t, egy `Paralysing` kódot, egy `Virologist`-et `Material` felszereléssel és egy másik `Virologist`-et `Bag` felszereléssel.
  - Megnyomja a `Search Field` gombot.
  - Megtalálja a kódok kombinált dobozát.
  - Ellenőrzi, hogy a `Paralysing` kód megjelenik-e.
  - Kiválasztja a `Paralysing` kódot.
  - Ellenőrzi, hogy a `Paralysing` kód ki van-e választva.
  - Megtalálja a virológusok kombinált dobozát.
  - Kiválasztja a második virológust.
  - Ellenőrzi, hogy a második virológus ki van-e választva.
  - Megnyomja a `Lubricate` gombot.
  - Kiválasztja a második virológust.
  - Ellenőrzi, hogy a második virológus továbbra is ki van-e választva.
  - Megnyomja a `Rob` gombot.
  - Ellenőrzi, hogy az első virológus most már rendelkezik-e a `Bag` felszereléssel.
  - Megnyomja a `Next Round` gombot.
  - Ellenőrzi, hogy egy menüelem jelenik meg a `Paralysed` szöveggel.
- Várt Eredmény: A `Search Field` gomb által felveszi a `Paralysing` kódot, a kódok kombinált doboz lehetővé teszi a kódok kiválasztását, a virológusok kombinált doboz lehetővé teszi a virológusok kiválasztását, és az `Lubricate` és `Rob` gombok elvégzik a megfelelő műveleteket.

#### 5. `testLearnCode`
- Leírás: Ellenőrzi a `Search Field` gomb és a kódok kombinált doboz viselkedését a játékablakban.
- Teszt Lépések:
  - Előkészíti a friss játékkörnyezetet, beleértve egy `Laboratory`-t, egy `Protection` kódot, egy `Virologist`-et és egy másik `Virologist`-et.
  - Megnyomja a `Search Field` gombot.
  - Megtalálja a kódok kombinált dobozát.
  - Ellenőrzi, hogy a `Protection` kód megjelenik-e.
- Várt Eredmény: A `Search Field` gomb által felveszi a `Protection` kódot, és a kódok kombinált doboz megjeleníti a rendelkezésre álló kódokat.

#### 6. `testAxePickupAndKill`
- Leírás: Ellenőrzi a `Search Field` gomb, virológusok kombinált doboz és az `Axe` gomb együttes viselkedését a játékablakban.
- Teszt Lépések:
  - Előkészíti a friss játékkörnyezetet, beleértve egy `Axe` felszerelést, egy `Virologist`-et és egy másik `Virologist`-et.
  - Megnyomja a `Search Field` gombot.
  - Ellenőrzi, hogy az első `Virologist` felveszi az `Axe` felszerelést.
  - Megtalálja a virológusok kombinált dobozát, és a második virológus kiválasztása.
  - Az `Axe` gomb megnyomása.
  - Ellenőrzi, hogy a második `Virologist` kiesik a játékból.
- Várt Eredmény: A `Search Field` gomb által felveszi az `Axe` felszerelést, a virológusok kombinált doboz lehetővé teszi a virológusok kiválasztását, és az `Axe` gomb megöli a kiválasztott virológust.

### Segédfüggvények: `startFreshWithShelter` és `startFresh`
- Leírás: A tesztekben használt segédfüggvények, amelyek előkészítik a friss játékkörnyezetet a tesztek számára.
- `startFreshWithShelter`: Létrehoz egy új játékkörnyezetet, beleértve egy `Shelter`-t.
- `startFresh`: Létrehoz egy új játékkörnyezetet.

## Tesztkörnyezet beállítása

### Függőségek
- AssertJSwingJUnit keretrendszer

### Teszt beállítása
- Az `onSetUp()` metódus minden teszteset előtt végrehajtódik, és a következő lépéseket hajtja végre:
  - Létrehoz egy példányt a `MenuFrame` osztályból.
  - Létrehoz egy `FrameFixture`-t a menüablakhoz a `FrameFixture(robot(), frame)` konstruktor segítségével.
  - Létrehozza az `UITestUtils` osztály példányát a felhasználói felület teszteléséhez kapcsolódó segédmetódusokhoz.
  - Megjeleníti a menüablakot.
