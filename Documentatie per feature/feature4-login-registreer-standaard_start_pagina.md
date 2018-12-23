# Feature 4: Login, Registreer en Standaard startpagina

Voor de CarMeets app volledig te benutten is een account nodig. Hiervoor moet dus uiteraard een werkende login en registreer fragment voorzien worden. Deze zullen dan ook in deze feauture voorzien worden alsook de opties om een standaard startpagina in te stellen.

## Inhoudsopgave

> - [Login en registreer fragment](#login-en-registreer-fragment)
> - [NetworkAPI en auth interceptor](#networkapi-en-auth-interceptor)
> - [Netwerk requests error verwerking](#netwerk-requests-error-verwerking)
> - [Dialog: aanmelden vereist](#dialog-aanmelden-vereist)
> - [Shared preferences](#shared-preferences)
> - [Standaard startpagina](#standaard-startpagina)


## Login en registreer fragment

Beiden fragments zijn opgebouwd met een relative layout waarbij de bovenste 50% het logo is en de onderste 50% de input velden enclosed in een scroll view. 

Er is een observer op de loggedin state om bij het aanklikken van account al dan niet door te gaan naar de login pagina. 

## NetworkAPI en auth interceptor

In de NetworkAPI zijn 2 nieuwe methoden voorzien voor het registreren en inloggen van een gebruiker, hiervoor zijn enkele dataclasses gemaakt die dienen voor het bijhouden van alle informatie die nodig is voor die server verzoek en die makkelijk om te zetten zijn naar json. Ook voor het antwoord van de server zijn dergelijke klasses voorzien. Je vind deze respectievelijk onder:

-  network -> requests
-  network -> responses

De provideOkHttpClient van de networkmodule is ook voorzien van een interceptor die automatisch bij elke uitgaande request een header toevoegt met de token. 

## Netwerk requests error verwerking

Er wordt app side gecontroleerd of alle velden ingevuld zijn en of de ingevulde wachtwoorden bij registreren al dan niet overeenkomnen.

Bij het verkrijgen van een error code bij de het zenden van de request naar de server (statuscode != 200) wordt er gekenen of de server een message heeft meegegeven met de fout. indien dit het geval is wordt deze specifieke foutcode getoond anders wordt een universele code getoond.

## Dialog: aanmelden vereist

De message util werd voorzien van 2 nieuwe functies.

> MessageUtil.showDialogYesNo 

Deze functie voorziet een manier om een dialoog aan de gebruiker te tonen met instelbare titel en boodschap. De gebruiker kan dan ja of nee kiezen en bij het kiezen van ja wordt een als parameter meegegeven functie uitvoerd.

> MessageUtil.showDialogLoginRequired

Deze functie voorziet een gemakkelijke manier om een popup te tonen dat zegt dat de gebruiker zich moet aanmelden voor de aangeklikte functie uit te voeren. De gebruiker kan vanaf de popup doorklikken naar de login pagina.



## Shared preferences

Er wordt gebruik gemaakt van shared preferences om de token, gebruikersnaam en startpagina lokaal bij te houden. Deze zijn uiteraard ingesteld op private. Hiervoor is een util voorzien namelijk:

> PreferenceUtil

Deze util voorziet makkelijke communicatie met de shared preferences. De AccountViewmodel gebruikt de util onder andere voor de eerder opgeslagen token op te halen bij het opstarten van de app en, indien er een token aanwezig is, in te stellen dat de app een aangemelde gebruiker heeft. 

## Standaard startpagina

De gebruiker kan een standaard startpagina instellen. Deze wordt bijgehouden in de shared preferences en zorgt er voor dat de door de gebruiker ingestelde pagina geopend wordt bij het openen van de app. 