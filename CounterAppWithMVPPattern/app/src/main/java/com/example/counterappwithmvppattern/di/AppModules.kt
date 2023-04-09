package com.example.counterappwithmvppattern.di

import android.app.Activity
import com.example.counterappwithmvppattern.data.CounterRepository
import com.example.counterappwithmvppattern.data.CounterRepositoryImpl
import com.example.counterappwithmvppattern.presenter.CounterPresenter
import com.example.counterappwithmvppattern.presenter.CounterPresenterImpl
import com.example.counterappwithmvppattern.ui.CounterView
import com.example.counterappwithmvppattern.ui.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindMainActivity(activity: MainActivity): CounterView

    @Binds
    abstract fun bindCounterRepository(impl: CounterRepositoryImpl): CounterRepository

    @Binds
    abstract fun bindCounterPresenter(impl: CounterPresenterImpl): CounterPresenter
}

/*
** 以下のエラー対応
*  error: [Dagger/MissingBinding] com.example.counterappwithmvppattern.ui.MainActivity cannot be provided without an @Inject constructor or an @Provides-annotated method.
*  This type supports members injection but cannot be implicitly provided.
*
*  参照: https://github.com/riodext/AndroidDaggerHiltMVP/blob/9968178d477795f63ed9a6155153cdb080fbab00/app/src/main/java/com/aria/androiddaggerhilt/di/MainModule.kt#L38
 */
@Module
@InstallIn(ActivityComponent::class)
object MainActivityModule {

    @Provides
    fun bindActivity(activity: Activity): MainActivity {
        return activity as MainActivity
    }
}