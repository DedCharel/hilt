package ua.cn.stu.http.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ua.cn.stu.http.app.model.accounts.AccountsSource
import ua.cn.stu.http.app.model.boxes.BoxesSource
import ua.cn.stu.http.sources.accounts.RetrofitAccountsSource
import ua.cn.stu.http.sources.boxes.RetrofitBoxesSource

@Module
@InstallIn(SingletonComponent::class)
abstract class SourcesModule {

    @Binds
    abstract fun bindAccountSource(
        retrofitAccountsSource: RetrofitAccountsSource
    ): AccountsSource

    @Binds
    abstract fun bindBoxesSource(
        retrofitBoxesSource: RetrofitBoxesSource
    ): BoxesSource
}