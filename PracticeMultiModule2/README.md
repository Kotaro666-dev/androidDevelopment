# Practice Multi-modularizing

## 概要

Android ネイティブアプリケーションのマルチモジュール化の練習プロジェクトです。

## アーキテクチャ

Google Android 開発チームが推奨する[アーキテクチャガイド](https://developer.android.com/jetpack/guide)に則ったものを採用しています。

- UI layer
  - UI elements: Activity, Fragment
  - State holders: ViewModel
- Domain layer
  - UseCase
- Data layer
  - Repository, Database

## 参考資料

- [6 年にわたる Android アプリの開発環境改善への取り組み](https://blog.nnn.dev/entry/2022/08/03/110000#%E3%83%9E%E3%83%AB%E3%83%81%E3%83%A2%E3%82%B8%E3%83%A5%E3%83%BC%E3%83%AB%E3%82%92%E5%B0%8E%E5%85%A5%E3%81%99%E3%82%8B2022-%E5%B9%B4-1-%E6%9C%88--)
- [Dependency injection with Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Hilt in multi-module apps](https://developer.android.com/training/dependency-injection/hilt-multi-module)
- [Gaia by yuyakaido/Multi-Modularizing App Sample](https://github.com/yuyakaido/Gaia)


