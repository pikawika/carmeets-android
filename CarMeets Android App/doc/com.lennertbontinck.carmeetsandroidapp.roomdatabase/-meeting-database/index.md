[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.roomdatabase](../index.md) / [MeetingDatabase](./index.md)

# MeetingDatabase

`abstract class MeetingDatabase : RoomDatabase`

Een [RoomDatabase](#) voor de app zijnde de [MeetingDatabase](./index.md).
De naam van de database is: carmeets_database.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MeetingDatabase()`<br>Een [RoomDatabase](#) voor de app zijnde de [MeetingDatabase](./index.md). De naam van de database is: carmeets_database. |

### Functions

| Name | Summary |
|---|---|
| [meetingDao](meeting-dao.md) | `abstract fun meetingDao(): `[`MeetingDao`](../-meeting-dao/index.md)<br>Functie voor het bekomen van de [MeetingDao](../-meeting-dao/index.md) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [instance](instance.md) | `var instance: `[`MeetingDatabase`](./index.md)`?`<br>Een instantie van de [MeetingDatabase](./index.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | `fun getInstance(context: Context): `[`MeetingDatabase`](./index.md)<br>Verkrijg de instantie van de [MeetingDatabase](./index.md). Er gebeurt een check zodat maar 1 instantie aangemaakt wordt (singleton principe). |

### Inheritors

| Name | Summary |
|---|---|
| [MeetingDatabase_Impl](../-meeting-database_-impl/index.md) | `open class MeetingDatabase_Impl : `[`MeetingDatabase`](./index.md) |
