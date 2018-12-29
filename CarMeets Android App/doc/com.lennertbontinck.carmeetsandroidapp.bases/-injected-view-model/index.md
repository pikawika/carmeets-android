[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.bases](../index.md) / [InjectedViewModel](./index.md)

# InjectedViewModel

`abstract class InjectedViewModel : ViewModel`

Een implementeerbare basis [ViewModel](#) klasse voor viewmodels die injectie nodig hebben via dagger.

Er zal adhv het viewmodel type de juiste injectie voorzien worden.

Momenteel compatibel met:

* [MeetingViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md)

Special thanks to Harm De Weirdt for base code and clear explanation of innerworkings.
https://github.com/hdeweirdt/metar

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `InjectedViewModel()`<br>Een implementeerbare basis [ViewModel](#) klasse voor viewmodels die injectie nodig hebben via dagger. |

### Functions

| Name | Summary |
|---|---|
| [inject](inject.md) | `fun inject(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Injecteren adhvd de reeds aangemaakte dagger instantie van de klasse die de [InjectedViewModel](./index.md) overerft. |

### Inheritors

| Name | Summary |
|---|---|
| [AccountViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md) | `class AccountViewModel : `[`InjectedViewModel`](./index.md)<br>Een [InjectedViewModel](./index.md) klasse die alle info over de aangemelde gebruiker bevat. |
| [MeetingViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md) | `class MeetingViewModel : `[`InjectedViewModel`](./index.md)<br>Een [InjectedViewModel](./index.md) klasse die alle meetings bevat. |
