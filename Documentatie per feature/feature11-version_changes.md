# Feature 11 - Kotlin versie hoger, min sdk lager

In deze branch zorgen we er voor dat onze app voldoet aan de versie vereisten van school namelijk:

- Gradle 3.2.1 --> reeds ok.
- Kotlin version 1.3.11 (momenteel 1.2.71)
- MinSdk 19 (momenteel 21)
- targetSDK 28 --> reeds ok.

## Kotlin versie upgrade
De kotlin versie upgrade was op zich vrij eenvoudig. Er waren 2 compatibiliteitsfoutjes dat we moesten oplossen namelijk:

- Mockk heeft een aparte versie voor kotlin V13 namelijk xxx.kotlin13
- Kotlin reflect moet manueel in gradle voorzien worden.

## Min sdk verlagen
Om de min SDK te verlagen moeten er een aantal zaken aangepast worden. Voornamelijk de tint in ImageCompactview zorge voor enkele problemen. Hiernaast moesten we ook:

- Multidex inschakelen.
- Drawables uit V24 halen.
- Bij het inflaten (cardview) niet de application context maar de context van de actieve fragment/activity gebruiken.
- Multidex voorzien en onze applicatie een MultiDexApplication maken.
- Via ImageViewCompat werken voor de tint ipv rechtstreeks de tintlist.

## Wat werkt niet met lagere SDK's
Na enkele aanpassingen werken runnen de testen allemaal zoals het hoort en een uitgebreide user test doet geen errors bovenkomen of naarheden in de user experience. Er is 1 zaak waar developers rekening mee moeten houden:

- Het mocken van data met Mockk moet gebeuren op een emulator die een recente SDK heeft anders kan Mockk lastig doen over object mocking. (Voorlopig enkel TokenUtilTest)
