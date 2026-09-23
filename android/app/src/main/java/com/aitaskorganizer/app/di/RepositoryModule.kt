package com.aitaskorganizer.app.di

import com.aitaskorganizer.app.data.repository.SourceRepository

object RepositoryModule {
    val sourceRepository: SourceRepository by lazy {
        SourceRepository(NetworkModule.sourceApi)
    }
}
