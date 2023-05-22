# Manuális tesztelés dokumentáció 

## A tesztelni kívánt funkciók 
1. Virológus léptetése
2. Paralysing ágens használata
3. Chorea ágens használata
4. Oblivion ágens használata
5. Protection ágens használata
6. Keresés laboratórium mezőn
7. Keresés fertőzött laboratórium mezőn
8. Keresés óvóhely mezőn
9. Keresés raktár mezőn
10. Rablás egy bénult virológustól
11. Balta használata egy másik virológuson
12. Találkozás a medvével
---
## 1: Virológus léptetése
### Teszteset célja
A teszteset célja annak vizsgálata, hogy a virológus a saját körében képes-e átlépni egy sajátjával szomszédos mezőre, és a lépése után már nem tud lépni máshova.
### Elvárt viselkedés
- a virológus csak a saját körében tud lépni
- a virológus a saját körében csak egyszer tud lépni
- a virológus csak a vele szomszédos mezőre tud lépni
### Dokumentáció 

---
## 2: Paralysing ágens használata
### Teszteset célja
A teszteset célja annak vizsgálata, hogy a virológus a saját körében képes-e felkenni a Paralysing ágenst, ezzel bénító hatást eredményezve. 
### Elvárt viselkedés
- a virológus csak a saját körében tud ágenst kenni
- a virológus a Paralysing ágens felkenése után megkapja a Paralyzed állapotot
- a virológus a Paralysing ágens felkenése után nem tud mozogni
### Dokumentáció 

---
## 3: Chorea ágens használata
### Teszteset célja
A teszteset célja annak vizsgálata, hogy a virológus a saját körében képes-e felkenni a Chorea ágenst, ezzel véletlenszerű lépést előidézve.
### Elvárt viselkedés
- a virológus csak a saját körében tud ágenst kenni
- a virológus a Chorea ágens felkenése után megkapja a Dancing állapotot
- a virológus a Chorea ágens felkenése után automatikusan véletlenszerű mezőkre lép
### Dokumentáció 

---
## 4. Oblivion ágens használata
### Teszteset célja
A teszteset célja annak vizsgálata, hogy a virológus a saját körében képes-e felkenni az Oblivion ágenst, ezzel véletlenszerű lépést előidézve.
### Elvárt viselkedés
- a virológus csak a saját körében tud ágenst kenni
- a virológus a Oblivion ágens felkenése után elfelejti az összes megtanult kódot
### Dokumentáció 

---
## 5. Protection ágens használata
### Teszteset célja
A teszteset célja annak vizsgálata, hogy a virológus a saját körében képes-e felkenni a Protection ágenst, ezzel véletlenszerű lépést előidézve.
### Elvárt viselkedés
- a virológus csak a saját körében tud ágenst kenni
- a virológus a Protection ágens felkenése után megkapja az Immune állapotot
- a virológus a Protection ágens felkenése után kivédi az összes vírust három körön keresztül
### Dokumentáció 

---
## 6. Keresés laboratórium mezőn
### Teszteset célja
A teszteset célja annak vizsgálata, hogy a virológus a saját körében képes-e letapogatni egy laboratórium mezőt, és így az ott lévő kódot megtanulni.
### Elvárt viselkedés
- a virológus csak a saját körében tud laboratóriumot letapogatni
- a virológus a laboratórium letapogatása után megtanul egy kódot
### Dokumentáció 

---
## 7. Keresés fertőzött laboratórium mezőn
### Teszteset célja
A teszteset célja annak vizsgálata, hogy a virológus a saját körében képes-e letapogatni egy fertőzött laboratórium mezőt, és így medvévé válik-e.
### Elvárt viselkedés
- a virológus csak a saját körében tud fertőzött laboratóriumot letapogatni
- a virológus a laboratórium letapogatása után Bear státuszt kap
- a virológus a laboratórium letapogatása után nem tud lépni, véletlenszerűen mozog
### Dokumentáció 

---
## 8. Keresés óvóhely mezőn
### Teszteset célja
A teszteset célja annak vizsgálata, hogy a virológus a saját körében képes-e letapogatni egy óvóhelyet, és az ott lévő tárgyat megszerezni.
### Elvárt viselkedés
- a virológus csak a saját körében tud óvóhelyet letapogatni
- a virológus felszerelésében megjelenik a tárgy
### Dokumentáció 

---
## 9. Keresés raktár mezőn
### Teszteset célja
A teszteset célja annak vizsgálata, hogy a virológus a saját körében képes-e letapogatni egy raktárat, és az ott lévő tárgyat megszerezni.
### Elvárt viselkedés
- a virológus csak a saját körében tud raktárat letapogatni
- a virológus felszerelésében megjelenik egy anyag
### Dokumentáció 

---
## 10. Rablás egy bénult virológustól
### Teszteset célja
A teszteset célja annak vizsgálata, hogy a virológus a saját körében képes-e kirabolni egy bénult virológust, és a nála lévő tárgyat megszerezni.
### Elvárt viselkedés
- a virológus csak a saját körében tud másik virológust kirabolni
- a virológus csak bénult virológust tud kirabolni
- a virológus felszerelésében a rablás után megjelenik a bénult virológus anyaga 
### Dokumentáció 

---
## 11. Balta használata egy másik virológuson
### Teszteset célja
A teszteset célja annak vizsgálata, hogy a virológus a saját körében képes-e megölni egy másik virológust a nála lévő baltával.
### Elvárt viselkedés
- a virológus csak a saját körében tud másik virológust megölni
- a virológus csak vele egy mezőn lévő másik virológust tud megölni
- a halott virológus eltűnik a pályáról
- a balta elhasználódásakor eltűnik a virológus felszereléséből
### Dokumentáció 

---
## 12: Találkozás a medvével
### Teszteset célja
A teszteset célja annak vizsgálata, hogy a virológus, amennyiben egy medvével rendelkező mezőre lép, megfertőződik-e maga is a medvevírussal.
### Elvárt viselkedés
- a virológus a medvével rendelkező mezőre lépés után megfertőződik a medvevírussal
- a virológus a lépés után Bear státuszt kap
- a virológus a lépés után nem tud többet lépni, véletlenszerűen mozog
### Dokumentáció 

---