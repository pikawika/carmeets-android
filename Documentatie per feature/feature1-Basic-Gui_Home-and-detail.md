# Feature 1: Basic GUI van home (meetinglijst) en de detailpagina (één meeting)

Een goed idee van hoe de GUI er zal uitzien is het begin van een goede app. Daarom stak ik ook enige tijd in [het uittekenen van shetsen](#brainstormsessie-schetsen) en het neerpennen hoe deze schermen er juist zullen uitzien.

## Inhoudsopgave

> - [Het idee](#het-idee)
>     - [Universeel](#universeel)
>         - [De Toolbar](#de-toolbar)
>         - [Bottom Navigation Bar](#bottom-navigation-bar)
>     - [Home](#home)
>         - [De lijst](#de-lijst)
>         - [Zoeken](#zoeken)
>     - [Detail](#detail)
>         - [Header](#header)
>         - [Content](#content)
>         - [Footer (More options)](#footer--more-options-)
>     - [Brainstormsessie: schetsen](#brainstormsessie-schetsen)
>         - [Bel icoon](#bel-icoon)
>         - [Detailscherm](#detailscherm)
>         - [Homelijst](#homelijst)
>         - [Lijstitem v1](#lijstitem-v1)
>         - [Lijstitem v2](#lijstitem-v2)
>         - [Optiesmenu](#optiesmenu)
>         - [Zoekscherm](#zoekscherm)
> - [De uitwerking](#de-uitwerking)
>     - [Zaken die anders zijn dan het initiële idee](#zaken-die-anders-zijn-dan-het-initiële-idee)
>         - [Toolbar en bottom navigation](#toolbar-en-bottom-navigation)
>         - [De layout van de lijst](#de-layout-van-de-lijst)
>         - [De detail pagina](#de-detail-pagina)
>         - [Zoekpagina - niet geïmplementeerd](#zoekpagina---niet-geïmplementeerd)
>     - [Screenshots](#screenshots)
>         - [Home - meetingslijst en favorieten](#home---meetingslijst-en-favorieten)
>         - [Meerdere layouts voor lijst](#meerdere-layouts-voor-lijst)
>         - [Detailpagina](#detailpagina)
>         - [Tablet layout](#tablet-layout)

## Het idee

### Universeel:

#### De Toolbar

- Links staat de back toets waar iedereen hem verwacht.
- In het midden staat de titel van de huidige view.
- Rechts staat en zoek icoontje dat naar zoeken gaat en een bel icoontje met een nrtje bij van hoeveel events er deze week zijn dat de gebruiker "geliked" heeft of "going" heeft gekozen.

#### Bottom Navigation Bar

- Links staat het lijst icoontje en verwijst naar de lijst waarnaar de app boot.
- In het midden staat het hartje en vinkje icoon waarmee je naar je gelikete en going meetings gaat.
- Rechts staat je profiel icoontje dat je naar je profiel settings neemt om oa je voorkeuren te wijzigen. 

### Home:

Het scherm waar je origineel naar opent zal een lijst zijn van alle meetings startende vanaf en inclusief vandaag. Ook zal er al een navigation menu onderaan moeten zijn. Bij een groter scherm zal deze lijst op de linkerhelft van het scherm komen te staan en de detailpagina op de rechterhelft. Het default geselecteerde item is dan het eerste item van de lijst namelijk "zoeken".

#### De lijst

- De lijst is een fragment met een recycler listview, "rage against the app" zal hiervoor een grote bron zijn.
- Initieel is de lijst van meetings vanaf vandaag ingeladen en op datum gesorteerd. De layout is als volgt:
    - Toon de img links met in de rechteronderhoek liked en going icoon en amount.
    - Naast de image staat de titel en daaronder de korte subtitel.
    - Onder de titel staat de locatie zijnde een marker icoontje met daarnaast de gemeente.

    
#### Zoeken

Het eerste list item is een zoek icoon met rechts daarvan Zoeken in het groot zodat dit zeker opvalt. Via dit list item (dat default geselecteerd is op grotere schermen) of via de zoek knop in de Toolbar zal je de lijst van meetings kunnen filteren.

### Detail 

Dit scherm zal dienen om 1 speciefieke meeting weer te geven nadat deze geselecteerd is via de lijst (op home of van gelikete/going meetings). Afhankelijk van de schermgrootte zal dit op op het rechterdeel van het scherm komen of het volledige scherm in beslag nemen.

#### Header

De bovenzijde van de detailpagina zal de image zijn die bij de meeting hoort met in de rechteronderhoek de liked en going knoppen/amount.

#### Content

Links onder de meeting image zal de titel staan met de subtitel. Rechts onder de image (in het verlengde van de liked going amount) zal de datum staan in korte notatie. rechtsboven in de image staan 3 bolletjes, het gekende More options icoon, dat als popup dezelfde lijst opties geeft als de [footer](#footer) voorziet.

Onder dat alles staat de lange tekst van de meeting.

#### Footer (More options)

Onderaan de detailpagina zal je knoppen vinden met dezelfde functionaliteit van het more options menu, namelijk:

- zet een reminder (geef notificatie x uur voor meeting start)
- voeg toe aan kalender (open kalenderapp)
- geef routebeschrijving (open navigatieapp)
- open website indien er een website aan meetings is toegekend (open browserapp)



### Brainstormsessie schetsen

#### Bel icoon
<img src="assets/img/feature1/draft/draft-belicoon.jpg" height="300" />

#### Detailscherm
<img src="assets/img/feature1/draft/draft-detail.jpg" height="300" />

#### Homelijst
<img src="assets/img/feature1/draft/draft-home.jpg" height="300" />

#### Lijstitem v1
<img src="assets/img/feature1/draft/draft-listitema.jpg" height="300" />

#### Lijstitem v2
<img src="assets/img/feature1/draft/draft-listitemb.jpg" height="300" />

#### Optiesmenu
<img src="assets/img/feature1/draft/draft-opties.jpg" height="300" />

#### Zoekscherm
<img src="assets/img/feature1/draft/draft-zoekscherm.jpg" height="300" />

## De uitwerking

### Zaken die anders zijn dan het initiële idee

Bij het omzetten van mijn idee naar implementatie zijn er enkele zaken die afwijken van mijn oorspronkelijke schetsen.

#### Toolbar en bottom navigation

De toolbar en bottom navigation zijn volledig uitgewerkt na enig opzoekingswerk hoe ik het bel icoontje met nummer zou aanpakken. Dit is nu volledig werkend en als bewijs dat ik het aantal kan aanpassen gaat het aantal meldingen omhoog met 1 telkens er op het bel icoontje wordt geklikt. 

#### De layout van de lijst

De layout van de lijst is zoals de schetsen met uitzondering dat de liked en going knoppen niet op de listitem staan aangezien dit het te druk ging maken. Overigens is de geschetse weergave overeenstemmend met de "kleine weergave" en heb ik als extra nog een "grote weergave" voorzien. 

#### De detail pagina

De detail pagina is buiten de opties bolletjes rechtsboven de image identiek aan de schetsen. Ik heb dit weggelaten aangezien de opties reeds onderaan staan en daar makkelijk genoeg te bereiken zijn dat het onnodig is dit te herhalen bovenaan de detail pagina

#### Zoekpagina - niet geïmplementeerd

De zoekpagina is voorlopig nog niet geïmplementeerd.

### Screenshots

#### Home - meetingslijst en favorieten
<img src="assets/img/feature1/screenshot/home.jpg" height="300" />
<img src="assets/img/feature1/screenshot/favoriet.jpg" height="300" />

#### Meerdere layouts voor lijst
<img src="assets/img/feature1/screenshot/layoutmenu.jpg" height="300" />
<img src="assets/img/feature1/screenshot/groot.jpg" height="300" />

#### Detailpagina
<img src="assets/img/feature1/screenshot/detail.jpg" height="300" />
<img src="assets/img/feature1/screenshot/detail2.jpg" height="300" />

#### Tablet layout
<img src="assets/img/feature1/screenshot/tablet.png" height="300" />
<img src="assets/img/feature1/screenshot/tablet2.png" height="300" />
<img src="assets/img/feature1/screenshot/tablet3.png" height="300" />
