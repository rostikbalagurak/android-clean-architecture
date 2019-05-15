package com.example.tictrac.presentation.user

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tictrac.R
import com.example.tictrac.domain.entity.User
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user.*

// TODO add viewModel
class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        initUI()
        fillUser()
    }

    private fun initUI() {
        tvPhone.setOnClickListener {
            callUser()
        }
    }

    private fun callUser() {
        Dexter.withActivity(this)
            .withPermissions(
                Manifest.permission.CALL_PHONE
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    if (report.areAllPermissionsGranted()) {
                        try {
                            val callIntent = Intent(Intent.ACTION_CALL)
                            callIntent.data = Uri.parse("tel:" + tvPhone.text.toString())
                            startActivity(callIntent)
                        } catch (exception: SecurityException) {
                            exception.printStackTrace()
                        }
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<com.karumi.dexter.listener.PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    // TODO
                }
            }).check()
    }

    private fun fillUser() {
        (intent?.extras?.getSerializable(PARAM_USER) as User?)?.let { user ->
            Picasso.get().load(user.profilePicture).into(ivUser)
            tvUserName.text = user.name
            tvEmail.text = user.email
            tvPhone.text = user.infos
        }
    }

    companion object {

        private const val PARAM_USER = "user"

        fun start(context: Context, user: User) {
            val intent = Intent(context, UserActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(PARAM_USER, user)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }
}