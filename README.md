

# Programozási technológia 1. próba  ZH – 2016.12.15. 


Készítsük el a Királynők nevű egyszerű logikai játékot. Ehhez adott egy 8x8-as sakktábla, amelyen a királynőket úgy kell elhelyeznünk balról-jobbra oszloponként, hogy egyik oszlopba se tegyünk úgy királynőt, hogy a korábbiakat üsse (a királynő függőlegesen, vízszintesen és átlósan is tetszőleges távolságra léphet). Mielőtt hozzákezd a feladat megoldásának, olvassa végig a feladatlapot, mivel bizonyos funkciók utólagos bevezetése esetlegesen más, korábbi funkciók újraírását eredményezheti. 

### 2 pontért:	Hozza létre kódból a 8x8 darab gombot tartalmazó sakktáblát, és az eseménykezelőt a gombokhoz úgy, hogy mindig csak a sakktábla legelső üres oszlopába tehessünk királynőt. Ellenőrizzük, hogy olyan helyre akarja-e tenni a játékos az új királynőt, ahol nem üti egyik korábban elhelyezett sem, és ne engedjük lerakni a királynőt rossz helyre.

### 3 pontért:	Ha sikerült mind a 8 királynőt elhelyezni a táblán, akkor gratuláljunk a játékosnak egy dialógus ablakon megjelenített ’Gratulálok, nyertél!’ felirattal, majd indítsuk újra a játékot. 
Hozzunk létre egy menüpontot, amellyel újrakezdhetjük a játékot, továbbá egy ’Visszavonás’ menüpontot, amivel egyesével vissza lehet vonni a lépéseket (ezeket érdemes egy vektorban/listben tárolni).


### 4 pontért:	Jelenítsük meg, hogy adott pályaállás esetén mely mezőkre léphetünk, pl. a gomb háttérszínét színezzük ezeknél át (btn.seBackground(Color.GRAY);).
Hozzunk létre egy menüpontot, amivel megállíthatjuk a játékot. Ekkor semmire sem lehet
kattintani (vagy nincs hatása a kattintásnak), és nem is láthatjuk a pályán lévő feliratokat.
A menüpont újbóli használatával a játék mutassa újra a pályaállást és lehessen folytatni a játékot.
Valósítsuk meg a játékot MV architektúrát alkalmazva, azaz egy külön osztályban legyen implementálva a játék táblájának modellje és az egyes műveletei (lépések, visszavonás, sikerült-e bejárni a táblát).

### 5 pontért:	Készítsünk egy időzítőt és számlálót, mely alapján tájékozódhat a játékos, hogy mennyi idő telt el az aktuális játék kezdete óta. Ha lejárt az idő,akkor vesztett a játékos.


Használható segédanyagok: Könyv, nyomtatott jegyzet, tárgy honlapja és a rajta elérhető projektek, JavaDoc.
A zárthelyi végén a legalább elégségesre osztályzott megoldásokat fel kell tölteni: webcím.
