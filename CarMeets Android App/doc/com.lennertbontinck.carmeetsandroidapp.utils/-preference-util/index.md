[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.utils](../index.md) / [PreferenceUtil](./index.md)

# PreferenceUtil

`object PreferenceUtil`

Een util om je te helpen met de shared preferences van de app

Shared preferences staan ingesteld op private zijnde dat ze niet toegangelijk zijn vanuit andere applicaties

### Properties

| Name | Summary |
|---|---|
| [sharedPreferences](shared-preferences.md) | `val sharedPreferences: SharedPreferences`<br>De shared preferences in [Context.MODE_PRIVATE](#) zodat andere applicaties hier niet aan kunnen |

### Functions

| Name | Summary |
|---|---|
| [deletePreferences](delete-preferences.md) | `fun deletePreferences(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Verwijderd alle sharedPreferences |
| [getDefaultBootPage](get-default-boot-page.md) | `fun getDefaultBootPage(): `[`MenuItemEnum`](../../com.lennertbontinck.carmeetsandroidapp.enums/-menu-item-enum/index.md)<br>Haalt de standaard startpagina op van de shared preferences |
| [getDefaultListLayout](get-default-list-layout.md) | `fun getDefaultListLayout(): `[`ListDesignEnum`](../../com.lennertbontinck.carmeetsandroidapp.enums/-list-design-enum/index.md)<br>Haalt de standaard lijst design op van de shared preferences |
| [getToken](get-token.md) | `fun getToken(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Haalt de token op van de shared preferences |
| [setDefaultBootPage](set-default-boot-page.md) | `fun setDefaultBootPage(menuItem: `[`MenuItemEnum`](../../com.lennertbontinck.carmeetsandroidapp.enums/-menu-item-enum/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Slaat de standaard startpagina op in de shared prefences |
| [setDefaultListLayout](set-default-list-layout.md) | `fun setDefaultListLayout(listDesignEnum: `[`ListDesignEnum`](../../com.lennertbontinck.carmeetsandroidapp.enums/-list-design-enum/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Slaat de standaard lijst design op in de shared prefences |
| [setToken](set-token.md) | `fun setToken(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Slaat de token op in de shared prefences |
