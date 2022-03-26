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

## RowScope と ColumnScope 内で使用可能な Modifier.weight を切り出したウィジェットで定義したい場合

Modifier.weight を使うと、以下のことが実現できる

> RowScope と ColumnScope でのみ使用可能な weight 修飾子を使用すると、コンポーザブルのサイズを親の内部で柔軟に変動するように設定することもできます。

https://developer.android.com/jetpack/compose/layout?hl=ja

ただし、切り出したウィジェットから weight を直接参照できない。

### 解決方法

切り出したウィジェットが Row または Column の Children だと明示する

```kotlin
@Composable
fun RowScope.TodoListIconButton(
    weightValue: Float
) {
    IconButton(onClick = {
        // やることリスト画面に遷移
    }) {
        Icon(
            // 省略
            modifier = Modifier
                .weight(weightValue)
        )
    }
}
```

## Clickable を設定したウィジェットから rippleEffect を除去する方法

indication を null に設定する

注意：interactionSource も同時に設定しないと、indication を設定できない

```kotlin
val interactionSource = remember { MutableInteractionSource() }
Column {
    Text(
        text = "Click me and my neighbour will indicate as well!",
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                /* .... */
            }
    )
}
```

参考サイト：https://stackoverflow.com/questions/66703448/how-to-disable-ripple-effect-when-clicking-in-jetpack-compose

## ボトムナビゲーションバーの表示/非表示切替

以下の資料を参照して実装

hide Top and Bottom Navigator on a specific screen inside Scaffold Jetpack Compose
https://stackoverflow.com/questions/66837991/hide-top-and-bottom-navigator-on-a-specific-screen-inside-scaffold-jetpack-compo

アプローチの方法として、ボトムナビゲーションバーウィジェット箇所を AnimatedVisibility を使用して切り替える