[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.extensions](../index.md) / [IsoConverter](./index.md)

# IsoConverter

`protected class IsoConverter`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `IsoConverter()` |

### Properties

| Name | Summary |
|---|---|
| [GMT_ID](-g-m-t_-i-d.md) | `static val GMT_ID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>ID to represent the 'GMT' string |
| [TIMEZONE_Z](-t-i-m-e-z-o-n-e_-z.md) | `static val TIMEZONE_Z: `[`TimeZone`](http://docs.oracle.com/javase/6/docs/api/java/util/TimeZone.html)<br>The GMT timezone, prefetched to avoid more lookups. |

### Functions

| Name | Summary |
|---|---|
| [checkOffset](check-offset.md) | `static fun checkOffset(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, expected: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Check if the expected character exist at the given offset in the value. |
| [format](format.md) | `static fun format(date: `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns `date` formatted as yyyy-MM-ddThh:mm:ss.sssZ |
| [indexOfNonDigit](index-of-non-digit.md) | `static fun indexOfNonDigit(string: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the index of the first character in the string that is not a digit, starting at offset. |
| [padInt](pad-int.md) | `static fun padInt(buffer: `[`StringBuilder`](http://docs.oracle.com/javase/6/docs/api/java/lang/StringBuilder.html)`, value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Zero pad a number to a specified length |
| [parse](parse.md) | `static fun parse(date: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)<br>Parse a date from ISO-8601 formatted string. It expects a format [yyyy-MM-dd|yyyyMMdd][T(hh:mm[:ss[.sss]]|hhmm[ss[.sss]])]?[Z|[+-]hh:mm]] |
| [parseInt](parse-int.md) | `static fun parseInt(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, beginIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, endIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Parse an integer located between 2 given offsets in a string |
