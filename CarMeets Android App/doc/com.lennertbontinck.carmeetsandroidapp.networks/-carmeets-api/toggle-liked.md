[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.networks](../index.md) / [CarmeetsApi](index.md) / [toggleLiked](./toggle-liked.md)

# toggleLiked

`@POST("meetings/toggleLiked") abstract fun toggleLiked(@Body toggleLikedRequest: `[`ToggleLikedRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-toggle-liked-request/index.md)`): Observable<`[`LikedAmountResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-liked-amount-response/index.md)`>`

Verander de like status van de aangemelde gebruiker voor een bepaalde meeting.

### Parameters

`toggleLikedRequest` - een [ToggleLikedRequest](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-toggle-liked-request/index.md) object van de meeting waarop de actie moet uitgevoerd worden.