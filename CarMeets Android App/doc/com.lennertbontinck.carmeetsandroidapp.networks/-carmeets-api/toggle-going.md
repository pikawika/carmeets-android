[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.networks](../index.md) / [CarmeetsApi](index.md) / [toggleGoing](./toggle-going.md)

# toggleGoing

`@POST("meetings/toggleGoing") abstract fun toggleGoing(@Body toggleGoingRequest: `[`ToggleGoingRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-toggle-going-request/index.md)`): Observable<`[`GoingAmountResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-going-amount-response/index.md)`>`

Verander de going status van de aangemelde gebruiker voor een bepaalde meeting.

### Parameters

`toggleGoingRequest` - een [ToggleGoingRequest](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-toggle-going-request/index.md) object van de meeting waarop de actie moet uitgevoerd worden.