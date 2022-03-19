# 開発者メモ

## Text の fontsize として dp を扱いたい場合

状況：ユーザーがカスタマイズしたフォントサイズの影響を受けたくない

```kotlin
val density = LocalDensity.current

Text(
    text = "Hello World",
    fontSize = with(density) { 18.dp.toSp() },
) 
```

参考資料：https://y-anz-m.blogspot.com/2021/06/jetpack-compose-text-dp.html