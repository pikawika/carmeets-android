[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.extensions](../index.md) / [IsoConverter](index.md) / [parseInt](./parse-int.md)

# parseInt

`private static fun parseInt(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, beginIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, endIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Parse an integer located between 2 given offsets in a string

### Parameters

`value` - the string to parse

`beginIndex` - the start index for the integer in the string

`endIndex` - the end index for the integer in the string

### Exceptions

`NumberFormatException` - if the value is not a number

**Return**
the int

