[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.fragments](../index.md) / [MeetingDetailFragment](./index.md)

# MeetingDetailFragment

`class MeetingDetailFragment : Fragment`

Een [Fragment](#) die de details van een meeting laat zien.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MeetingDetailFragment()`<br>Een [Fragment](#) die de details van een meeting laat zien. |

### Properties

| Name | Summary |
|---|---|
| [accountViewModel](account-view-model.md) | `lateinit var accountViewModel: `[`AccountViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md)<br>[AccountViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md) met de data over de aangemelde gebruiker |
| [binding](binding.md) | `lateinit var binding: `[`FragmentMeetingDetailsBinding`](../../com.lennertbontinck.carmeetsandroidapp.databinding/-fragment-meeting-details-binding/index.md)<br>De [FragmentMeetingDetailsBinding](../../com.lennertbontinck.carmeetsandroidapp.databinding/-fragment-meeting-details-binding/index.md) dat we gebruiken voor de effeciteve databinding |
| [guiViewModel](gui-view-model.md) | `lateinit var guiViewModel: `[`GuiViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md)<br>[GuiViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md) met de data over de GUI instellingen |
| [meetingViewModel](meeting-view-model.md) | `lateinit var meetingViewModel: `[`MeetingViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md)<br>[MeetingViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md) met de data van alle meetings |

### Functions

| Name | Summary |
|---|---|
| [addToCalander](add-to-calander.md) | `fun addToCalander(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Start een intent om het huidige geselecteerde meeting item toe te voegen aan de kalender. |
| [getDirections](get-directions.md) | `fun getDirections(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Start een intent om directies te verkijgen naar de huidige geselecteerde meeting. |
| [goToWebsite](go-to-website.md) | `fun goToWebsite(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Start een intent om de website van de huidige geselecteerde meeting te openen. |
| [initListeners](init-listeners.md) | `fun initListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het instantiëren van de listeners. |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?` |
| [onStart](on-start.md) | `fun onStart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStop](on-stop.md) | `fun onStop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopListeners](stop-listeners.md) | `fun stopListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het stoppen van de listeners |
