# Feature 2: MVVM structuur en meetinglijst via rest api verkregen

De MVVM structuur zorgt voor duidelijkheid, uitbreidbaarheid en veiligheid binnen een Android applicatie. Na de lessen hierover was het dan ook vanzelf spreken dat mijn applicatie hier ook gebruik van moest maken. Ook werd het hoog tijd te werken met werkelijke data en geen dummy data. Deze feature combineert beiden door de geziene leerstof te hanteren naar de CarMeets app.

Overigens zijn er al tal van code cleanups die gebeurd zijn in deze feature.

## Inhoudsopgave

> - [MVVM Conversie met rest connectie](#mvvm-conversie-met-rest-connectie)
> - [Beschikbare rest calls vanuit de app](#beschikbare-rest-calls-vanuit-de-app)
> - [Recyclerview met MVVM en rest data](#recyclerview-met-mvvm-en-rest-data)
> - [Binded detail pagina](#binded-detail-pagina)
> - [Voorziene adapters](#voorziene-adapters)



## MVVM Conversie met rest connectie

Voor het overschakelen naar MVVM en het implementeren van retrofit en overige voor de rest connectie heb ik gebruikt gemaakt van de verworven kennis uit de lessen. De broncode van Metar zorgde hier voor een zeer goede basis. Veel van de universele code is dan ook zeer gelijkaardig doordat dit een uiterst goede en duidelijk uitgelegde implementatie van retrofit was. Ik heb wel alle (of toch zo veel mogelijk) code voorzien van nederlandstalige commentaar (zowel kdoc als inline) om mijn kennis van de code te bewijzen.

## Beschikbare rest calls vanuit de app

Momenteel is er nog maar 1 rest call geimplementeerd in de CarmeetsApi interface zijnde 


````
@GET("/API/meetings/alleMeetings")
fun getAllMeetings(): Observable<List<Meeting>>
````

Deze get call returnt alle meetings die vanaf vandaag doorgaan gesorteerd op datum. Datum is in de gebruikte Moshi JSON converter (en vele andere bekende converters) niet voor de hand liggend. Ik heb hiervoor gebruik gemaakt van een extension DateParser. Meer hierover in de sectie [voorziene adapters](#voorziene-adapters).


## Recyclerview met MVVM en rest data

De gehele app is gebasseerd op een overzicht van automeetings in België. De Recyclerview met meetings is dus het belangrijkste onderdeel van de app. Ik werk hiervoor met een door de viewmodel voorziene livedata lijst van meetings die luistert naar veranderingen van de lijst om de recyclerview up daten. Deze verandering zijn niet enkel van toepassing voor dataset aanpassingen maar ook voor het kiezen van een andere lijstdesign, wat ook een geobserveerde enum is uit de viewmodel. 

## Binded detail pagina

De detail pagina gebeurde voorgaans adhv een companion object waar een parcable meeting object werd meegegeven. Dit is niet echt MVVM vriendelijk en moest dus gebind worden.

Dit is vrij eenvoudig. We voorzien in de viewmodel een livedata van de geselecteerde meeting die we binden in de xml van de detailpagina. Hier zijn 3 custom binding adapters voor gemaakt. Eentje met glide voor het laden van de afbeelding en 2 omtrent dateformating voor 23/12/2018 te printen als 23 en Dec. Meer hierover in de sectie [voorziene adapters](#voorziene-adapters).

## Voorziene adapters

- Moshi adapter:
    - DateParser en IsoConverter:
        - Gebasseerd op Rfc3339DateJsonAdapter.
        - Enkel de nodige klassen in Extensions voorzien ipv de gehele dependecy.
- DataBindingUtil die verschillende BindingAdapters bevat:
    - setImageUrl
        - onderschept het binden van **android:src** in een **ImageView** met een **String**.
        - Maakt gebruik van Glide om de meegeven String (zijnde de url van de afbeelding) in te laden.
    - setDayInMonth
        - onderschept het binden van **android:dayInMonth** in een **TextView** met een **Date**.
        - Custom type om te vermijden dat alle android:text binders in een TextView met een date onderschept worden.
        - Haalt de dag van de maand uit de meegegeven datum en stelt hem (Int waarde) in als text van de meegegeven TextView.
    - setShortMonthName
        - onderschept het binden van **android:shortMonthName** in een **TextView** met een **Date**.
        - Custom type om te vermijden dat alle android:text binders in een TextView met een date onderschept worden.
        - Haalt de maand uit de meegegeven datum en stelt hem (Eerste 3 letters van de maand; bv Dec) in als text van de meegegeven TextView.

