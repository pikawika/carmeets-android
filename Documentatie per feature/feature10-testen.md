# Feature 10 - Testen

In deze branch gaan we dieper in op geautomatiseerde testen. Dit wilt echter niet zeggen dat er nog geen testen tot op heden gedaan waren. Meer hierover in de onderstaande documentatie.

## Inhoudsopgave

> - [Responsievere layout en databinding liked/going](#responsievere-layout-en-databinding-liked-going)
> - [Like en Going methode](#like-en-going-methode)
> - [Favorietenlijst en notificatiebelletje](#favorietenlijst-en-notificatiebelletje)
> - [Login popup](#login-popup)

## Testen voorheen deze feature

Voorafgaan werd na elke feature uitbundig usertesting gedaan op zowel de android studio emulator alsook op volgende fysieke toestellen: 

- Android O: OnePlus 5
- Android O: Samsung S9+
- Android M: Oneplus 1

Dit test op fysieke toestellen werdt gedaan met de gesignde apk die op het einde van elke feauture verkregen was. Crashes die boven water kwamen werden opgelost, GUI optimalisaties werden veelal in de branch achteraf of in de GUI optimalisaties branch gedaan.

## Voorziene geautomatiseerde testen

Er is gebruikmakend van JUnit, Espresso en Mockk voor geautomatiseerde testen. De geautomatiseerde testen, samen met de reeds verrichte userttesten, zorgen voor een vrijwel volledige geteste eindapplicatie!

Volgende testen zijn voorzien:

- Util testen:
    - Preference Util testen: 
        - preferenceUtil\_setAndGetToken\_isCorrect
        - preferenceUtil\_setAndGetBootPage\_isMeetingPageCorrect
        - preferenceUtil\_setAndGetBootPage\_isFavouritesPageCorrect
        - preferenceUtil\_setAndGetBootPage\_isAccountPageCorrect
        - preferenceUtil\_setAndGetDefaultList\_isSmallCorrect
        - preferenceUtil\_setAndGetDefaultList\_isBigCorrect
        - preferenceUtil\_deletePreferences\_isCorrect
    - Token Util testen: 
        - tokenUtil\_getTokenContent\_isCorrect
        - tokenUtil\_getTokenContent\_isEmpty
        - tokenUtil\_getTokenContent\_isWrongToken
    - Adapter Util testen: 
        - adapterUtil\_meetingToMeetingWithUserInfo\_noUserLink
        - adapterUtil\_meetingToMeetingWithUserInfo\_userLiked
        - adapterUtil\_meetingToMeetingWithUserInfo\_userGoing
        - adapterUtil\_meetingToMeetingWithUserInfo\_userLikedAndGoing
- Room Database testen:
    - meetingDao\_insertAndGetAllMeetings\_insertsAndSaves4Meetings
    - meetingDao\_insertAndDeleteAllMeetings\_inserts4MeetingsAndDeletesAllMeetings
- UI testen:
    - Authentication Required testen: 
        - accountPage\_showLoginIfNotSignedIn
        - favouritesList\_showLoginDialogForNotSignedIn\_goToLoginOnAccept
        - notification\_showLoginDialogForNotSignedIn\_goToLoginOnAccept
        - meetingDetails\_like\_showLoginDialogForNotSignedIn\_cancel
        - meetingDetails\_going\_showLoginDialogForNotSignedIn\_goToLoginOnAccept
    - Login testen 
        - login\_bothFieldsEmpty\_showToastEmptyFields
        - login\_usernameFieldsEmpty\_showToastEmptyFields
        - login\_passwordFieldsEmpty\_showToastEmptyFields
        - login\_correctInfo\_logInWithUsername_userLogsIn
        - login\_correctInfo\_logInWithEmail\_userLogsIn
    - Register testen 
        - register\_allFieldsEmpty\_showToastEmptyFields
        - register\_someFieldsEmpty\_showToastEmptyFields
        - register\_passwordsDoNotMatch\_showToastPasswordsNotEqual
        - register\_existingUsername\_doesNotRegister
        - register\_existingEmail\_doesNotRegister
        - registerv_correctInfo\_registerAndCorrectUsername
    - Favourite testen 
        - meetingDetails\_toggleGoing\_isSavedOnServerAndCorrectTint
        - meetingDetails\_toggleLiked\_isSavedOnServerAndCorrectTint
        - favouritesList\_likeFirstMeetingOfList\_isInFavouritesList
        - favouritesList\_goingFirstMeetingOfList\_isInFavouritesList
        - favouritesList\_likedAndGoingFirstMeetingOfList\_isInFavouritesList