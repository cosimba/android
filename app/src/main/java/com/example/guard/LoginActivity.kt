package com.example.guard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.guard.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginButton: Button = binding.loginButton
        loginButton.setOnClickListener {
            val selectedMode = 1  // 여기서는 임시로 모드 1을 설정
            val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putInt("SELECTED_MODE", selectedMode)
                apply()
            }

            // 로그인 성공 후 MainActivity로 이동
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // LoginActivity를 종료
        }

        // 회원가입 버튼 클릭 시 RegisterActivity로 이동
        binding.registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
