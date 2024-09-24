package com.example.guard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.guard.databinding.ActivityMainBinding
import com.example.guard.ui.dashboard.mode1.Mode1Fragment
import com.example.guard.ui.dashboard.mode2.Mode2Fragment
import com.example.guard.ui.dashboard.mode3.Mode3Fragment
import com.example.guard.ui.dashboard.mode4.Mode4Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedMode = getSelectedMode()  // 로그인 시 선택한 모드 불러오기

        when (selectedMode) {
            1 -> setupBottomNavigationForMode(Mode1Fragment(), R.menu.mode1_bottom_nav_menu)
            2 -> setupBottomNavigationForMode(Mode2Fragment(), R.menu.mode2_bottom_nav_menu)
            3 -> setupBottomNavigationForMode(Mode3Fragment(), R.menu.mode3_bottom_nav_menu)
            4 -> setupBottomNavigationForMode(Mode4Fragment(), R.menu.mode4_bottom_nav_menu)
        }
    }

    private fun getSelectedMode(): Int {
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        return sharedPreferences.getInt("SELECTED_MODE", 1)  // 기본값 모드 1
    }

    private fun setupBottomNavigationForMode(fragment: Fragment, menuResId: Int) {
        // Bottom Navigation 메뉴 설정
        val navView: BottomNavigationView = binding.navView
        navView.menu.clear() // 메뉴 초기화
        navView.inflateMenu(menuResId)

        // 메인 프래그먼트 설정
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_activity_main, fragment)
            .commit()

        // 추가로 네비게이션 컨트롤 설정이 필요한 경우
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
