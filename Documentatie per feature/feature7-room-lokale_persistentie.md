# Feature 7 - Lokale persistentie met room en eenvoudigere databinding

Tot op heden kon je de app niet gebruiken als je geen internet verbinding hebt of wanneer de server niet bereikbaar is. We kunnen dit oplossen met een lokale databank via room. Ook waren er een aantal verbeteringen mogelijk voor het databinden adhv van de DataBindingUtil.

## Inhoudsopgave

> - [Responsievere layout en databinding liked/going](#responsievere-layout-en-databinding-liked-going)
> - [Like en Going methode](#like-en-going-methode)
> - [Favorietenlijst en notificatiebelletje](#favorietenlijst-en-notificatiebelletje)
> - [Login popup](#login-popup)

## Databinding Util uitbreidingen

In de app werd er veel databinding gebruikt voor het al dan niet weer geven van een gui item. Dit gebeurde adhv boolean in de viewmodel view.visible of view.gone instellen.

Dit zorgde echter voor veel repterende code, namelijk steeds view.visible instellen aangezien je niet gewoon visibility = bindedboolean kan doen.

Hiervoor is dus een BindingAdapter aangemaakt!

> setVisibility

Deze binder kijkt of android:visibility gelijk gesteld wordt aan een Boolean en zal dan indien de boolean true is de view op visible zetten en omgekeerd.

Ook is bij de liked en going knopjes gebruikt gemaakt van binding voor het weergeven als het knopje als actief (roos/geliked) of niet actief (roos/niet geliked), idem voor going. Dit werdt gedaan adhv een tint kleur instellen op de boolean via een ternary operator in de xml.

Dit kan nu eenvoudiger, namelijk de boolean binden aan 

> android:isToggledOn

en de bijhorende databinder adapter (setIsToggledOn) zal bij true de kleur op roos (colorprimary) instellen en bij false op black.

## Room en RoomUtil

Voor de lokale persistentie is op aanraden van Google (en de lessen) gebruik gemaakt van Room. De implementatie is relatief eenvoudig. 

Er was reeds een methode voorzien om de context van de app te verkijgen en te injecteren, dus die moest niet meer geschreven worden. 

De klasse zelf had al een primary key en deze moest juist nog een annotatie krijgen.

De effectieve databank en dao waren vrij eenvoudig doordat de backend nosql is en er dus maar 1 tabel moest opgeslaan worden. 2 probleem punten waren echter wel: 

- Date object van de meeting
- Categories, listUsersGoing en listUsersLiked (List\<String>)

Hiervoor is een RoomUtil gemaakt die de 2 complexe datatypes convert naar door room opslaanbare types en terug naar een door de app verstaanbaar type.

Deze converters doen volgende omzetting:

- Date
    - Omzetten naar Long adhv Date.Time
- List\<String>
    - Omzetten adhv json string

## Pagina indien geen meetings opgehaald

Uiteraard moet de gebruiker op een gebruiksvriendelijke manier te zien krijgen dat de verbinding met de server mislukt is en hij de offline lijst kan bekijken. Hiervoor is een partial\_error\_with\_show\_cache layout file voor voorzien.

Deze is included in de mainactivity met een visibily bind. Zo kan de viewModel bepalen wanneer dit zichtbaar moet zijn.