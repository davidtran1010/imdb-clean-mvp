package com.example.mymoviesmvp.view

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.example.mymoviesmvp.R
import com.example.mymoviesmvp.utils.ViewUtils

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDrawer()
        initToolBar()
        loadHomeFragment()
    }

    private fun initToolBar() {

        toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolbar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }
    }

    private fun initDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        navView.layoutParams.width = ViewUtils.getScreenWidth(this) * 45 / 100

        drawerLayout.addDrawerListener(object: DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(p0: Int) {
                Log.d("UI","Drawer state: " + p0)
            }

            override fun onDrawerSlide(p0: View, p1: Float) {
                Log.d("UI","Drawer slide: " + p1)
            }

            override fun onDrawerClosed(p0: View) {
                Log.d("UI","Drawer closed ")
            }

            override fun onDrawerOpened(p0: View) {
                Log.d("UI","Drawer opened ")
            }
        })
    }
    private fun loadHomeFragment() {
        val homeFragment: Fragment = HomeFragment()

        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.fragment_container, homeFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
