package com.example.tictrac.presentation.users

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.tictrac.domain.entity.User
import com.example.tictrac.domain.usecase.UsersInteractor
import com.example.tictrac.presentation.base.Resource
import com.example.tictrac.presentation.base.setError
import com.example.tictrac.presentation.base.setLoading
import com.example.tictrac.presentation.base.setSuccess
import com.example.tictrac.presentation.util.Connectivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val usersInteractor: UsersInteractor,
    private val connectivity: Connectivity
) : ViewModel() {

    val users = MutableLiveData<Resource<List<User>>>()
    private val compositeDisposable = CompositeDisposable()

    fun fetch() {
        val users = if (connectivity.isConnected())
            usersInteractor.fetchUsers()
        else
            usersInteractor.fetchLocalUsers()

        compositeDisposable.add(
            users
                .doOnSubscribe { this.users.setLoading() }
                .subscribe(
                    { this.users.setSuccess(it) },
                    { this.users.setError(it) }
                )
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
    }
}