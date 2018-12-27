# Feature 9 - code cleanup

Desondanks de code steeds netjes gedocumenteerd was en bepaalde conventies werden nageleefd zijn er her en der schoonheidsfoutjes gemaakt. Deze varieren van een afwijkende naming conventions tot niet performante kotlin code. Dit alles wordt in deze feature aangepakt! Voor de gebruiker zal er in deze feature dus niet veel veranderen.

## Naming convetions

Er is geen éénduidige naming convention voor android projecten. De google documentatie gebruikt doorheen verschillende voorbeelden verschillende conventies. Het was voor mij belangrijk een consistente en logische naamgeving te hebben. Ik basseerde mij hiervoor op de volgende guidelines

> [Project and code guidelines](https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md)

Concreet wilt dit zegge dat id's opgebouwd zijn als volgt:

> Engelstalig waarbij beschrijving optioneel: TYPE\_LAYOUTFILE\_BESCHRIJVING
>> BV: text\_login\_username
>> BV: image\_item\_meeting

String values zijn voorzien van een voorvoegsel voor hun beschrijving (txt,alt,placeholder...)

Variabele namen zijn engelstalig waarbij booleans veelal voorafgaand door is voor een betere leesbaarheid.
