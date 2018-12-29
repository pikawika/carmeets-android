[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.adapters](../index.md) / [MeetingAdapter](./index.md)

# MeetingAdapter

`class MeetingAdapter : Adapter<`[`ViewHolder`](-view-holder/index.md)`>`

[RecyclerView.Adapter](#) voor het vullen van een recyclerview met meeting items. Gebruikt hiervoor de
[MeetingViewModel.meetingList](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/meeting-list.md) en [GuiViewModel.listDesign](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/list-design.md) ingesteld in de [MeetingViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md).

### Parameters

`parentActivity` - : de actieve activity. Required of type AppCompatActivity.

### Types

| Name | Summary |
|---|---|
| [ViewHolder](-view-holder/index.md) | `inner class ViewHolder : ViewHolder` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MeetingAdapter(parentActivity: AppCompatActivity)`<br>[RecyclerView.Adapter](#) voor het vullen van een recyclerview met meeting items. Gebruikt hiervoor de [MeetingViewModel.meetingList](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/meeting-list.md) en [GuiViewModel.listDesign](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/list-design.md) ingesteld in de [MeetingViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md). |

### Properties

| Name | Summary |
|---|---|
| [guiViewModel](gui-view-model.md) | `var guiViewModel: `[`GuiViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md)<br>[GuiViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md) met de data over de GUI instellingen |
| [meetingViewModel](meeting-view-model.md) | `var meetingViewModel: `[`MeetingViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md)<br>[MeetingViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md) met de data over alle meetings |
| [onClickListener](on-click-listener.md) | `val onClickListener: OnClickListener` |
| [parentActivity](parent-activity.md) | `val parentActivity: AppCompatActivity`<br>: de actieve activity. Required of type AppCompatActivity. |

### Functions

| Name | Summary |
|---|---|
| [getItemCount](get-item-count.md) | `fun getItemCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`ViewHolder`](-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: ViewGroup, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ViewHolder`](-view-holder/index.md) |
