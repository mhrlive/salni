package com.mhrlive.salni

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
// import com.bumptech.glide.Glide // Commented out for now - add Glide dependency if needed
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.mhrlive.salni.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()

        // Check if user is signed in
        val currentUser = firebaseAuth.currentUser
        if (currentUser == null) {
            navigateToLogin()
            return
        }

        setupGoogleSignInClient()
        displayUserInfo()
        setupClickListeners()
    }

    private fun setupGoogleSignInClient() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    private fun displayUserInfo() {
        val user = firebaseAuth.currentUser
        user?.let { firebaseUser ->
            binding.tvWelcome.text = getString(R.string.welcome_message, firebaseUser.displayName ?: "User")
            binding.tvUserEmail.text = firebaseUser.email
            binding.tvUserId.text = "User ID: ${firebaseUser.uid}"

            // Load profile picture if available
            firebaseUser.photoUrl?.let { photoUrl ->
                try {
                    // Note: In a real app, you would use Glide or similar library
                    // For this demo, we'll just use the default launcher icon
                    binding.ivProfilePicture.setImageResource(R.mipmap.ic_launcher)
                } catch (e: Exception) {
                    // Fallback to default image
                    binding.ivProfilePicture.setImageResource(R.mipmap.ic_launcher)
                }
            }
        }
    }

    private fun setupClickListeners() {
        binding.btnSignOut.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        // Sign out from Firebase
        firebaseAuth.signOut()

        // Sign out from Google
        googleSignInClient.signOut().addOnCompleteListener(this) {
            Toast.makeText(this, "Signed out successfully", Toast.LENGTH_SHORT).show()
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}