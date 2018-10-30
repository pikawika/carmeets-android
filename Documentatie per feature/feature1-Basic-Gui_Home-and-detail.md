# Feature 1: Basic GUI van home (meetinglijst) en de detailpagina (één meeting)

## Inhoudsopgave

> - [Home:](#home)
>    - [De lijst](#de-lijst)
>    - [De App Bar](#de-app-bar)
>    - [Bottom Navigation Bar](#bottom-navigation-bar)


## Home:

Het scherm waar je origineel naar opent zal een lijst zijn van alle meetings startende vanaf en inclusief vandaag. Ook zal er al een app bar moeten zijn en een navigation menu onderaan.

### De lijst

- De lijst is een fragment met een recycler listview, "rage against the app" zal hiervoor een grote bron zijn.
- Het eerste list item is een zoek icoon met rechts daarvan Zoeken in het groot zodat dit zeker opvalt
- De rest van de lijst zijn de meetings, initieel is dit alles vanaf vandaag op datum gesorteerd.
    - Toon de img links met in de rechteronderhoek liked en going icoon en amount
    - Naast de image staat de titel en daaronder de korte subtitel
    - Onder de titels staat de locatie zijnde een pin icoontje met daarnaast de gemeente

### De App Bar

- Links staat de back toets waar iedereen hem verwacht
- In het midden staat de titel van de huidige view
- Rechts staat en zoek icoontje dat naar zoeken gaat en een bel icoontje met een nrtje bij van hoeveel events er deze week zijn dat de gebruiker "geliked" heeft of "going" heeft gekozen

### Bottom Navigation Bar

- Links staat het lijst icoontje en verwijst naar de lijst waarnaar de app boot
- In het midden staat het hartje en vinkje icoon waarmee je naar je gelikete en going meetings gaat
- Rechts staat je profiel icoontje dat je naar je profiel settings neemt om oa je voorkeuren te wijzigen. 

