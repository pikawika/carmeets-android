# Welkom bij CarMeets Android App!

Dit is de GitHub repository voor de Android App van CarMeets. U kan hier steeds alle broncode raadplegen en clonen. Ik heb gebruik gemaakt van Trello boards als todo lijstjes, ook deze kan u hier raadplegen

IMPORTANT: De backend is gratis gehost op heroku, hierdoor kunnen er af en toe langere wachtijden zijn. Voornamelijk bij het initieel laden kan het even duren tegen de server opgestart is. Dit is omdat de heroku server na enige minuten inactiviteit in slaapstand gaat. 

## Inhoudsopgave

> - [Wat is de CarMeets app](#wat-is-de-carmeets-app)
> - [Ontwikkelaar](#ontwikkelaar)
> - [Documentatie in de code](#documentatie-in-de-code)
> - [Releases en APKs](#documentatie-en-apks-per-feature)
> - [GitHub Repository van de backend](#github-repository-van-de-backend)
> - [Gebruikte bronnen](#gebruikte-bronnen)

## Wat is de CarMeets App
Net zoals vele autoliefhebbers was ik het beu steeds te moeten horen dat ik weer een kwaliteitsmeeting gemist had omdat ik niet wist wanneer deze plaatsvond. Daarom besloot ik, [Lennert Bontinck](https://www.lennertbontinck.com/), een website te maken waar je snel en eenvoudig alle meetings naar jouw smaak kan terugvinden en bewaren in je agenda. [Deze website](http://carmeets.lennertbontinck.com) was een succesvol eindwerk gebouwd met de MEAN-stack voor WebApplicaties 4. Aangezien ik het idee achter CarMeets nog steeds tof vind besloot ik dus ook een Android App te maken om CarMeets nog makkelijker in gebruik te maken!

## Ontwikkelaar

| Naam     | GitHub                        | E-mail                               |
| :---     | :---                          | :---                                |
| Bontinck Lennert | <https://github.com/pikawika> | [lennert.bontinck.y9785@student.hogent.be](mailto:lennert.bontinck.y9785@student.hogent.be) |

## Documentatie in de code

Er zijn in de code inline comments voorzien met uitleg wat bepaalde regels code juist doen en waarom ze nodig zijn. Overigens is voor de utils en tal van andere functies documentation voorzien zodanig dat deze uitleg over de functie en de parameters verschijnt bij het aanroepen van de functies.

## Documentatie en APKs per Feature

> 1. Feature 1: Layout van de toolbar, bottom navigation, meetinglijst en detail pagina. Basic werking met dummy data en poc op onclicks.
>     - [Meer info over Feature 1](Documentatie%20per%20feature/feature1-Basic-Gui_Home-and-detail.md)
>     - [APK](apks/carmeets-feature1.apk)
> 2. Feature 2: MVVM structuur en meetinglijst + detail via rest api verkregen
>     - [Meer info over Feature 2](Documentatie%20per%20feature/feature2-mvvm_basic-rest.md)
>     - [APK](apks/carmeets-feature2.apk) 
> 3. Feature 3: Intents + Best practices cleanup
>     - [Meer info over Feature 3](Documentatie%20per%20feature/feature3-intents-best_practices.md)
>     - [APK](apks/carmeets-feature3.apk) 
> 4. Feature 4: Login, Registreer en Standaard startpagina
>     - [Meer info over Feature 4](Documentatie%20per%20feature/feature4-login-registreer-standaard_start_pagina.md)
>     - [APK](apks/carmeets-feature4.apk) 
> 5. Feature 5 - Manage account en standaard lijstweergave
>     - [Meer info over Feature 5](Documentatie%20per%20feature/feature5-manage_account-default_listdesign.md)
>     - [APK](apks/carmeets-feature5.apk)
> 6. Feature 6 - Like en going, favorietenlijste, aantal in volgende week en responsive design fixes
>     - [Meer info over Feature 6](Documentatie%20per%20feature/feature6-like_and_going-response_fixes.md)
>     - [APK](apks/carmeets-feature6.apk)

## GitHub Repository van de backend
Aangezien de CarMeets Android App een opvolging is van de CarMeets website gemaakt met de MEAN-stack zal ik de bestaande backend hergebruik en aanvullen waar nodig.
> [GitHub repository van de MEAN-stack applicatie](https://github.com/pikawika/Carmeets)

## Gebruikte bronnen

Buiten het in de les ter beschikking gestelde boek heb volgende bronnen geraadpleegd voor mijn project:

> - [Kotlin documentatie](https://kotlinlang.org/docs/reference/)
> - [Naming conventions](https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md) 
> - [Hoe schrijf je zelf documentatie](https://kotlinlang.org/docs/reference/kotlin-doc.html)
> - [Notificatie icoon met aantal](https://stackoverflow.com/questions/17696486/actionbar-notification-count-icon-badge-like-google-has)
> - [Support voor meerdere screen sizes](https://developer.android.com/training/multiscreen/screensizes)
> - [Metar project dat MVVM en retrofit gebruik uitlegd](https://github.com/hdeweirdt/Metar)
> - [Moshi Rfc3339DateJsonAdapter.java](https://github.com/square/moshi/blob/master/adapters/src/main/java/com/squareup/moshi/Rfc3339DateJsonAdapter.java)
> - [Het gebruik van intents]( https://developer.android.com/guide/components/intents-common)
> - [Functies meegeven als parameter](https://antonioleiva.com/function-references-kotlin/)
> - [Auth interceptor op uitgaande requests](https://github.com/MarcinMoskala/SimpleKotlinMvpBoilerplate/blob/master/app/src/main/java/com/marcinmoskala/simplekotlinmvpboilerplate/repositories/providers/Retrofit.kt)
> - [Doc over Kotlin Enums](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)
