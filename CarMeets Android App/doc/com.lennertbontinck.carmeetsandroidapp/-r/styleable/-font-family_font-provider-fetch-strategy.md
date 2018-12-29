[app](../../../index.md) / [com.lennertbontinck.carmeetsandroidapp](../../index.md) / [R](../index.md) / [styleable](index.md) / [FontFamily_fontProviderFetchStrategy](./-font-family_font-provider-fetch-strategy.md)

# FontFamily_fontProviderFetchStrategy

`static val FontFamily_fontProviderFetchStrategy: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)
`static val FontFamily_fontProviderFetchStrategy: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

**Attr**
description The strategy to be used when fetching font data from a font provider in XML layouts. This attribute is ignored when the resource is loaded from code, as it is equivalent to the choice of API between androidx.core.content.res.ResourcesCompat#getFont(Context, int) (blocking) and androidx.core.content.res.ResourcesCompat#getFont(Context, int, FontCallback, Handler) (async).

Must be one of the following constant values.

     ConstantValueDescription async1The async font fetch works as follows. First, check the local cache, then if the requeted font is not cached, trigger a request the font and continue with layout inflation. Once the font fetch succeeds, the target text view will be refreshed with the downloaded font data. The fontProviderFetchTimeout will be ignored if async loading is specified. blocking0The blocking font fetch works as follows. First, check the local cache, then if the requested font is not cached, request the font from the provider and wait until it is finished. You can change the length of the timeout by modifying fontProviderFetchTimeout. If the timeout happens, the default typeface will be used instead.

**Attr**
name com.lennertbontinck.carmeetsandroidapp:fontProviderFetchStrategy

