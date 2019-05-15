package com.example.tictrac.presentation.base

import android.arch.lifecycle.MutableLiveData

data class Resource<out T> constructor(
    val state: ResourceState,
    val data: T? = null,
    val message: String? = null
)

fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T) =
    postValue(Resource(ResourceState.SUCCESS, data))

fun <T> MutableLiveData<Resource<T>>.setLoading() =
    postValue(Resource(ResourceState.LOADING, value?.data))

fun <T> MutableLiveData<Resource<T>>.setError(throwable: Throwable) =
    postValue(Resource(ResourceState.ERROR, null, throwable.message))