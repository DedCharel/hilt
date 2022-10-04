package ua.cn.stu.http.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ua.cn.stu.http.app.utils.logger.LogCatLogger
import ua.cn.stu.http.app.utils.logger.Logger


@Module
@InstallIn(SingletonComponent::class)
class StaffsModule {

    @Provides
    fun provideLogger(): Logger = LogCatLogger
}