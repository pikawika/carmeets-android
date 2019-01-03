[app](../../../index.md) / [com.lennertbontinck.carmeetsandroidapp](../../index.md) / [R](../index.md) / [attr](index.md) / [fontProviderCerts](./font-provider-certs.md)

# fontProviderCerts

`static val fontProviderCerts: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)
`static val fontProviderCerts: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

The sets of hashes for the certificates the provider should be signed with. This is used to verify the identity of the provider, and is only required if the provider is not part of the system image. This value may point to one list or a list of lists, where each individual list represents one collection of signature hashes. Refer to your font provider's documentation for these values.

May be a reference to another resource, in the form "`@[+][*package*:]*type*/*name*`" or a theme attribute in the form "`?[*package*:]*type*/*name*`".

