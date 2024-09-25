package com.example.guard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.guard.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // UI 요소들 참조
        val employeeNumber: EditText = binding.employeeNumber
        val phoneNumber: EditText = binding.phoneNumber
        val modeSpinner: Spinner = binding.modeSpinner
        val registerButton: Button = binding.registerButton

        registerButton.setOnClickListener {
            // 회원가입 정보 입력 후 로그인으로 이동

            val selectedMode = modeSpinner.selectedItemPosition + 1 // Spinner에서 선택한 모드 (1부터 시작)
            val empNum = employeeNumber.text.toString()
            val phoneNum = phoneNumber.text.toString()

            // 회원 정보와 선택한 모드 저장
            val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putInt("SELECTED_MODE", selectedMode)
                putString("EMPLOYEE_NUMBER", empNum)
                putString("PHONE_NUMBER", phoneNum)
                apply()
            }

            // 회원가입 완료 후 MainActivity로 이동
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
