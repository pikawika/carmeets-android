[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.viewmodels](../index.md) / [GuiViewModel](./index.md)

# GuiViewModel

`class GuiViewModel : ViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GuiViewModel()` |

### Properties

| Name | Summary |
|---|---|
| [actionBarSubTitle](action-bar-sub-title.md) | `val actionBarSubTitle: MutableLiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>De subtitel die in de actionbar moet ingesteld worden. |
| [actionBarTitle](action-bar-title.md) | `val actionBarTitle: MutableLiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>De titel die in de actionbar moet ingesteld worden. |
| [activeMenuItem](active-menu-item.md) | `var activeMenuItem: MutableLiveData<`[`MenuItemEnum`](../../com.lennertbontinck.carmeetsandroidapp.enums/-menu-item-enum/index.md)`>`<br>Het huidige door de gebruiker geselecteerde menu item. |
| [isBackButtonVisible](is-back-button-visible.md) | `val isBackButtonVisible: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Of de backbutton al dan niet moet zichtbaar zijn |
| [isEmptyListVisible](is-empty-list-visible.md) | `val isEmptyListVisible: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Het huidige door de gebruiker geselecteerde design van lijstitems. |
| [isListDesignOptionsVisible](is-list-design-options-visible.md) | `val isListDesignOptionsVisible: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Of de huidige omgeving al dan niet two pane is |
| [isTwoPaneEnvironment](is-two-pane-environment.md) | `val isTwoPaneEnvironment: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Of de huidige omgeving al dan niet two pane is |
| [listDesign](list-design.md) | `val listDesign: MutableLiveData<`[`ListDesignEnum`](../../com.lennertbontinck.carmeetsandroidapp.enums/-list-design-enum/index.md)`>`<br>Het huidige door de gebruiker geselecteerde design van lijstitems. |

### Functions

| Name | Summary |
|---|---|
| [resetLayout](reset-layout.md) | `fun resetLayout(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Zet de standaardwaarden van de layout terug zijnde: |
