package com.example.guard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.guard.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val registerButton: Button = binding.registerButton
        registerButton.setOnClickListener {
            // 회원가입 정보 입력 후 로그인으로 이동
            val selectedMode = 1  // 임시로 모드 1 선택
            val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putInt("SELECTED_MODE", selectedMode)
                apply()
            }

            // 회원가입 완료 후 MainActivity로 이동
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
