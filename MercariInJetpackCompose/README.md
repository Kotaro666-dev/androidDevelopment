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

## Compose でコルーチンを使う場合

- Composable 関数内で使う場合：LaunchedEffect
- Composable 関数外で使う場合（※）：rememberCoroutineScope

※例として、ボタンの onClick 時のイベント対応など

```kotlin
val scope = rememberCoroutineScope()
val pagerState = rememberPagerState()

onClick = {
    scope.launch {
        pagerState.animateScrollToPage(index)
    }
}
```

`animateScrollToPage`は suspendable な関数のため、コルーチン内で呼ぶ必要がある。
