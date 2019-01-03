[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.roomdatabase](../index.md) / [MeetingRepository](./index.md)

# MeetingRepository

`class MeetingRepository`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MeetingRepository(meetingDao: `[`MeetingDao`](../-meeting-dao/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [meetingDao](meeting-dao.md) | `val meetingDao: `[`MeetingDao`](../-meeting-dao/index.md) |
| [meetings](meetings.md) | `val meetings: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Meeting`](../../com.lennertbontinck.carmeetsandroidapp.models/-meeting/index.md)`>>`<br>Alle meetings uit de room meeting databank |

### Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | `fun delete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Verwijder alle meetings uit de lokale room database zijn *meetingtable*. |
| [insert](insert.md) | `fun insert(meetings: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Meeting`](../../com.lennertbontinck.carmeetsandroidapp.models/-meeting/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Verwijderd alle meetings momenteel aanwezig in de lokale room meeting databank en voegt de lijst van meetings toe. |
