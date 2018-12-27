# Feature 8 - GUI optimalisaties

De werking van de app is volledig geïmplementeerd, echter kan dit alles nog iets mooier gepresenteerd worden. In het bijzonder moet:

- De layout voor tablet nog iets verbeterd worden
- Een loading en empty list fragment voorzien worden
- De detail pagina nog vervolledigd worden
- Bij de fragment transaction animaties voorzien worden

## Inhoudsopgave

> - [Two pane voor instellingen](#two-pane-voor-instellingen)
> - [Loading en empty list fragment](#loading-en-empty-list-fragment)
> - [Detail pagina vervolledigen](#detail-pagina-vervolledigen)
> - [Animaties](#animaties)

## Two pane voor instellingen

De meetinglijst, en bijgevolg de favorietenlijst, waren reeds geoptimaliseerd voor grotere schermen door het voorzien van een two pane layout. 

Bij instellingen is die two pane structuur nu ook geïmplementeerd, er is namelijk een hoofdmenu links en dan 2 submenu's rechts (preferences en manage account).

Dit zorgt, samen met de andere [animaties](#animaties) voor two pane layout, voor een mooi resultaat bij alle schermformaten! Ook is er voor te kleine schermen steeds voorzien dat de nodige overflow gescrolled kan worden op een mooie manier.

## Loading en empty list fragment

Doordat de backend server gratis gehost is op heroku is het zeker interessant om een laadscherm te voorzien. Ook is het mogelijk dat een net geregistreerde gebruiker nog een lege favorietenlijst heeft, hier dient ook een gepaste boodschap voor gegeven te worden in plaats van een lege fragment weer te geven.

Dit gebeurd adhv 2 nieuwe partials die in de mainactivity include worden en hun visibility gebind wordt. Het binden van die visibility is nu ook veel eenvoudiger doordat er een bindingadapter voorzien is die een boolean waarde automatisch omzet naar view.gone of view.visible.

De loading fragment voorziet een gif van een autotje die drift in een cirkel. Een zeer toepasselijk laad animatietje dus! Gifs worden echter niet onderstuend door de standaard android:src toekenning dus is er een glide methode voorzien bij de bindingadpter om de lokale gif resource in te laden als afbeelding en glide toont gifs wel geanimeerd!

## Detail pagina vervolledigen

Tot op heden was het niet mogelijk om op de detail pagina te zien hoeveel gebruikers er gaan naar een bepaalde meeting en hoeveel gebruikers een bepaalde meeting liken. Dit is adhv databinding op een lijst en een adapter die de lijst omzet naar een zin voorzien.

Op een zelfde manier is de lijst van categorieën voorzien op de detail pagina.

Ook zijn er enkele visuele optimalisaties rondom de app gedaan voor een algemeen betere gebruikerservaring. (padding, margins...)


## Animaties

Animaties zijn een moeilijk gegeven, ze kunnen de gebruikerservaring een pak beter maken maar ook een pak slechter. In deze app is er voor gekozen gebruik te maken van snelle, subtiele animaties voor de ervaring positief te bevorderen.

Er zijn verschillende aanpassingen gedaan op feedback van testers vooraleer een finaal resultaat bekomend was.

Deze animaties zijn voorzien op fragmenttransactions. Enkele van de animaties zijn:

- Bij het wijzigen van bottom navigation item wordt naar de juiste pagina "geveegd" (links of rechts afhankelijk van huidge pagina)
- Bij het klikken op een meeting word in single pane modus de meeting van onder ingeveegd, bij het teruggaan naar de lijst verdwijnd ze dan weer in tegenovergestelde richting.
- Bij het klikken op een meeting word in two pane modus de meeting van links naar rechts "geveegd" in het rechter deel van het scherm, wat zorgt voor een boekeffect.
- Bij de settings wordt op een identieke manier als de meetings animaties gedaan voor submenu's.
- Bij het afmelden of aanmelden wordt het login scherm in of weggeveegd.
- Bij het willen openen van favorieten zonder je aangemeld bent wordt er half naar het favorieten scherm geveegd vooraleer het terugkeert naar het vorig scherm en een popup geeft dat je moet aanmelden.
- ...

Graag geef ik een speciale shout-out naar XDA lid :  [niranjan94](https://forum.xda-developers.com/member.php?u=4699848) die [tal van open source xml animatie bestanden](https://forum.xda-developers.com/showthread.php?t=2331728) ter beschikking stelde. Dit heeft een heleboel tijd bespaard!