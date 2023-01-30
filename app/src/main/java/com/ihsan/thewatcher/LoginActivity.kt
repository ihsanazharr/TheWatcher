package com.ihsan.thewatcher


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.ihsan.thewatcher.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    lateinit var auth : FirebaseAuth
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.forgotPassword.setOnClickListener {
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
        }

        binding.tvToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmailLogin.text.toString()
            val password = binding.edtPasswordLogin.text.toString()

            //Validasi email
            if(email.isEmpty()){
                binding.edtEmailLogin.error = "Email harus diisi !"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }

            //Validasi email tidak sesuai
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtEmailLogin.error = "Email tidak valid !"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }

            //Validasi password
            if(password.isEmpty()){
                binding.edtEmailLogin.error = "Password harus diisi !"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }

            //Validasi panjang password
            if(password.length<6){
                binding.edtEmailLogin.error = "Password minimal 6 karakter !"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(email, password)
        }

    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if(it.isSuccessful){
                    Toast.makeText(this, "Selamat Datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
