package com.example.books.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.books.R
import com.example.books.databinding.ActivitySignUpBinding
import com.example.books.models.User
import com.example.books.ui.main.MainViewModel
import com.example.books.utils.Status
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {

    lateinit var binding:ActivitySignUpBinding
    val viewModel: SignViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            lifecycleScope.launch {
                val name = binding.editTextName.text.toString()
                val email = binding.editTextMail.text.toString()
                val password = binding.editTextPassword.text.toString()
                val confirmPassword  =binding.editTextConfirmPassword.text.toString()
                createUser(User(name,email,password,confirmPassword))
            }
        }


    }
  suspend  fun createUser(user: User){
        viewModel.postUser(user).collect{
            it.let {
                when(it.status){
                    Status.SUCCESS->{
                        Log.e( "createUser: ",it.data.toString() )
                    }
                    Status.LOADING->{}
                    Status.ERROR->{
                        Log.e( "createUsererror: ",it.message.toString() )
                    }
                }
            }
        }
    }
}