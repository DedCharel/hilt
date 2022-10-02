package ua.cn.stu.http.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ua.cn.stu.http.app.model.settings.AppSettings
import ua.cn.stu.http.app.model.settings.SharedPreferencesAppSettings

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsModule {

    @Binds
    abstract fun bindAppSettings(
        appSettings: SharedPreferencesAppSettings
    ): AppSettings
}