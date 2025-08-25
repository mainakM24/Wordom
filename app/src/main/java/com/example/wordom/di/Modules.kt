package com.example.wordom.di

import com.example.wordom.data.local.WordomDatabase
import com.example.wordom.data.remote.RetrofitInstance
import com.example.wordom.data.repositories.WordRepositoryImpl
import com.example.wordom.domain.repositories.WordRepository
import com.example.wordom.domain.usecases.AddFavWordUseCase
import com.example.wordom.domain.usecases.GetFavWordUseCase
import com.example.wordom.domain.usecases.GetWordUseCase
import com.example.wordom.presentation.viewmodels.FavouriteViewModel
import com.example.wordom.presentation.viewmodels.HomeViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel

val wordomModule = module {
    single { RetrofitInstance.getApiService() }
    single { WordomDatabase.getDataBase(get()) }
    single<WordRepository> { WordRepositoryImpl(get(), get()) }
    factory { GetWordUseCase(get()) }
    factory { AddFavWordUseCase(get()) }
    factory { GetFavWordUseCase(get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { FavouriteViewModel(get()) }
}