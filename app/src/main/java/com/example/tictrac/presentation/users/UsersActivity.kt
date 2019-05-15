package com.example.tictrac.presentation.users

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.tictrac.R
import com.example.tictrac.domain.entity.User
import com.example.tictrac.presentation.base.Resource
import com.example.tictrac.presentation.base.ResourceState
import com.example.tictrac.presentation.user.UserActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class UsersActivity : AppCompatActivity(), UsersAdapter.InteractionListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: UsersViewModel
    private lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        initViewModel()
        initUI()
    }

    override fun onUserPressed(adapterPosition: Int) {
        UserActivity.start(
            this,
            adapter.get(adapterPosition)
        )
    }

    private fun initUI() {
        adapter = UsersAdapter(this)
        rvUsers.layoutManager = LinearLayoutManager(this)
        rvUsers.adapter = adapter
    }

    private fun initViewModel() {
        this.viewModel = ViewModelProviders.of(this, viewModelFactory)[UsersViewModel::class.java]
        this.viewModel.users.observe(this, Observer(::updateUsers))
        this.viewModel.fetch()
    }

    private fun updateUsers(resource: Resource<List<User>>?) {
        resource?.let {
            when (it.state) {
                ResourceState.LOADING -> progressBar.visibility = View.VISIBLE
                ResourceState.SUCCESS -> progressBar.visibility = View.GONE
                ResourceState.ERROR -> progressBar.visibility = View.GONE
            }
            it.data?.let { users -> adapter.submitList(users) }
            it.message?.let { message -> Toast.makeText(this, message, Toast.LENGTH_LONG).show() }
        }
    }
}