package com.james.foodhub.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.james.foodhub.R
import com.james.foodhub.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityWelcomeBinding
    private lateinit var oneTapClient: SignInClient
    private lateinit var signInRequest: BeginSignInRequest
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityWelcomeBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        auth = Firebase.auth
        oneTapClient = Identity.getSignInClient(this)
        signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    // Your server's client ID, not your Android client ID.
                    .setServerClientId(getString(R.string.your_web_client_id))
                    // Only show accounts previously used to sign in.
                    .setFilterByAuthorizedAccounts(true)
                    .build())
            .build()

    }



    fun buttonGoogleSignIn(view: View) {

    }
}