# Feature 6 - Like en going, favorietenlijste, aantal in volgende week en responsive design fixes

Het voordeel van een account was tot op heden niet duidelijk. Buiten enkele standaard waardes instellen kon je niets tof. CarMeets draait er echter rond eenvoudig ook een meeting te kunnen liken of te laten weten dat je gaat. Dit moet in de app ook lukken! Het is dan ook vanzelfsprekend dat er een lijst is met deze meetings (favorietenlijst) en hoeveel er in de nabije toekomst zijn. Ook zijn er een paar GUI fixes die dienen uitgevoerd te worden.

## Inhoudsopgave

> - [Responsievere layout en databinding liked/going](#responsievere-layout-en-databinding-liked-going)
> - [Like en Going methode](#like-en-going-methode)
> - [Favorietenlijst en notificatiebelletje](#favorietenlijst-en-notificatiebelletje)
> - [Login popup](#login-popup)

## Responsievere layout en databinding liked/going

De account pagina en submenu's waren niet echt responsive, dit is nu opgelost door o.a. het gebruik van een scrollview als het scherm te klein is. Voor de detailpagina van de meeting zijn de knoppen om een meeting te liken of te zeggen dat je gaat zichtbaar. Het moet duidelijk zijn aan deze knoppen of je deze opties al dan niet hebt gedaan. Dit gebeurd aan de hand van een databinding of de gebruiker al dan niet geliked/going heeft ingesteld met de kleur van het desbetreffende icoon. Hierdoor oogt het icoon roos als de optie geselecteerd is en zwart indien niet.

## Like en Going methode

Er is een onclick listener op beide knoppen ingesteld die een rest call doet. Dit gebeurd via de CarMeetsAPI adhv toggle methodes (liked = !liked in de backend). Hierdoor is het enkel nodig deze methode in de backend op te roepen, de id van de betrokken meeting mee te geven en de methode werkt. De token wordt namelijk automatisch meegegeven sinds een vorige feature en zo weet de backend welke gebruiker het verzoek doet.

Na het uitvoeren van een toggle request wordt de lijst opnieuw geladen waardoor ook het gelikete item opnieuw geladen wordt en de changes op de gui worden uitgevoerd.

## Favorietenlijst en notificatiebelletje

De favorietenlijst toont nu het overzicht van meetings die de gebruiker liked en/of heeft opgegeven dat hij zal gaan.

Naast het notificatiebelletje in de toolbar staat nu ook hoeveel meetings uit je favorietenlijst in de komende 7 dagen vallen.

## Login popup

De voorgaande features hebben reeds tal van utils voorzien. Voor deze feature is de MessageUtil zijn showDialogLoginRequired veel gebruikt. Dit toont namelijk een mooie popup dat de gebruiker zich moet aanmelden voor het gebruik van een bepaalde functie met de mogelijkheid om door te klikken naar het login scherm.