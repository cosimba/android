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
import com.example.guard.ui.home.mode1.HomeFragment1
import com.example.guard.ui.home.mode2.HomeFragment2
import com.example.guard.ui.home.mode3.HomeFragment3
import com.example.guard.ui.home.mode4.HomeFragment4
import com.example.guard.ui.notifications.mode1.NotificationsFragment1
import com.example.guard.ui.notifications.mode2.NotificationsFragment2
import com.example.guard.ui.notifications.mode3.NotificationsFragment3
import com.example.guard.ui.notifications.mode4.NotificationsFragment4
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedMode = getSelectedMode()  // 로그인 시 선택한 모드 불러오기
        setupBottomNavigationForMode(selectedMode)
    }

    private fun getSelectedMode(): Int {
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        return sharedPreferences.getInt("SELECTED_MODE", 1)  // 기본값 모드 1
    }

    private fun setupBottomNavigationForMode(mode: Int) {
        // Bottom Navigation 메뉴 설정
        val navView: BottomNavigationView = binding.navView
        navView.menu.clear() // 메뉴 초기화

        when (mode) {
            1 -> navView.inflateMenu(R.menu.mode1_bottom_nav_menu)
            2 -> navView.inflateMenu(R.menu.mode2_bottom_nav_menu)
            3 -> navView.inflateMenu(R.menu.mode3_bottom_nav_menu)
            4 -> navView.inflateMenu(R.menu.mode4_bottom_nav_menu)
        }

        // 기본 Fragment 설정 (HomeFragment)
        val initialFragment = getFragmentForMode(mode, FragmentType.HOME)
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_activity_main, initialFragment)
            .commit()

        // 네비게이션 컨트롤 설정
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home_mode1, R.id.navigation_dashboard_mode1, R.id.navigation_notifications_mode1,
                R.id.navigation_home_mode2, R.id.navigation_dashboard_mode2, R.id.navigation_notifications_mode2,
                R.id.navigation_home_mode3, R.id.navigation_dashboard_mode3, R.id.navigation_notifications_mode3,
                R.id.navigation_home_mode4, R.id.navigation_dashboard_mode4, R.id.navigation_notifications_mode4
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Bottom Navigation 클릭 이벤트 설정
        navView.setOnNavigationItemSelectedListener { menuItem ->
            val fragment: Fragment = when (menuItem.itemId) {
                R.id.navigation_home_mode1, R.id.navigation_home_mode2, R.id.navigation_home_mode3, R.id.navigation_home_mode4 -> {
                    getFragmentForMode(getSelectedMode(), FragmentType.HOME)
                }
                R.id.navigation_dashboard_mode1, R.id.navigation_dashboard_mode2, R.id.navigation_dashboard_mode3, R.id.navigation_dashboard_mode4 -> {
                    getFragmentForMode(getSelectedMode(), FragmentType.DASHBOARD)
                }
                R.id.navigation_notifications_mode1, R.id.navigation_notifications_mode2, R.id.navigation_notifications_mode3, R.id.navigation_notifications_mode4 -> {
                    getFragmentForMode(getSelectedMode(), FragmentType.NOTIFICATIONS)
                }
                else -> return@setOnNavigationItemSelectedListener false
            }

            // Fragment 전환
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, fragment)
                .commit()
            true
        }
    }

    private fun getFragmentForMode(mode: Int, fragmentType: FragmentType): Fragment {
        return when (fragmentType) {
            FragmentType.HOME -> when (mode) {
                1 -> HomeFragment1()
                2 -> HomeFragment2()
                3 -> HomeFragment3()
                4 -> HomeFragment4()
                else -> HomeFragment1() // 기본값으로 모드 1
            }
            FragmentType.DASHBOARD -> when (mode) {
                1 -> Mode1Fragment()
                2 -> Mode2Fragment()
                3 -> Mode3Fragment()
                4 -> Mode4Fragment()
                else -> Mode1Fragment() // 기본값으로 모드 1
            }
            FragmentType.NOTIFICATIONS -> when (mode) {
                1 -> NotificationsFragment1()
                2 -> NotificationsFragment2()
                3 -> NotificationsFragment3()
                4 -> NotificationsFragment4()
                else -> NotificationsFragment1() // 기본값으로 모드 1
            }
        }
    }
}

// Fragment 타입을 정의하는 Enum 클래스
enum class FragmentType {
    HOME,
    DASHBOARD,
    NOTIFICATIONS
}
