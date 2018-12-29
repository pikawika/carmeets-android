[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.roomdatabase](../index.md) / [MeetingDao](./index.md)

# MeetingDao

`interface MeetingDao`

Een doa interface voor het uitvoeren van acties om de room database zijn meeting_table

### Functions

| Name | Summary |
|---|---|
| [deleteAllMeetings](delete-all-meetings.md) | `abstract fun deleteAllMeetings(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Clear de room database zijn *meetingtable* |
| [getAllMeetings](get-all-meetings.md) | `abstract fun getAllMeetings(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Meeting`](../../com.lennertbontinck.carmeetsandroidapp.models/-meeting/index.md)`>>`<br>Haal alle meetings uit de room database |
| [insert](insert.md) | `abstract fun insert(meeting: `[`Meeting`](../../com.lennertbontinck.carmeetsandroidapp.models/-meeting/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Zet een meeting in de room database |

### Inheritors

| Name | Summary |
|---|---|
| [MeetingDao_Impl](../-meeting-dao_-impl/index.md) | `open class MeetingDao_Impl : `[`MeetingDao`](./index.md) |
