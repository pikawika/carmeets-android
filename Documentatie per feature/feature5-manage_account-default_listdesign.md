# Feature 5 - Manage account en standaard lijstweergave

Een aangemelde gebruiker wilt mogelijks zijn email, gebruikersnaam of wachtwoord kunnen wijzigen. deze feature voorziet die functionaliteit alsook het instellen van een standaard lijstweergave optie.

## Inhoudsopgave

> - [Netwerk requests error verwerking](#netwerk-requests-error-verwerking)
> - [Dialog met textinput](#dialog-met-textinput)
> - [Standaard lijstweergave](#standaard-lijstweergave)
> - [Allerlei](#allerlei)

## Netwerk requests error verwerking

Bij het maken van deze feature zijn heel wat fouten met de backend boven water gekomen (asynce dingen die ik verwachte sync te lopen etc). Deze fouten zijn nu rechtgezet en bij het foutief invullen van iets wordt een gepaste error vanuit de backend gestuurd en gebruikt in de android app.

## Dialog met textinput

Er is een dialog voorzien met een edittext. Deze is aanspreekbaar via

> MessageUtil.showDialogWithTextInput(...)

Leuk hieraan is dat een functie (die een string als param verwacht) kan worden meegegeven als parameter voor deze dailog creatie functie. Deze functie zal dan uitgevoerd worden indien de dialog bevestigd wordt. Dit maakt het mogelijk eentonige fragments te vermijden. Wordt bv gebruikt bij wijzig gebruikersnaam en wijzig e-mailadres. 

## Standaard lijstweergave

De gebruiker kan een standaard lijstweergave instellen. Deze wordt bijgehouden in de shared preferences en zorgt er voor dat de door de gebruiker ingestelde lijstweergave initieel gebruikt wordt bij het openen van de app en het bekijken van een lijst waar deze op toepassing is. 

## Allerlei

Voor de fragtags is nu een enum gebruikt ipv string values aangezien deze niet vertaald dienen te worden en puur code matische functie hebben. Er is weer een pak cleanup gedaan en er zijn enkele verbetere documentaties en utils voorzien.