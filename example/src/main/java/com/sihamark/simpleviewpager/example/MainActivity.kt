package com.sihamark.simpleviewpager.example

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sihamark.simpleviewpager.ListPagerAdapter
import com.sihamark.simpleviewpager.Page
import com.sihamark.simpleviewpager.R
import com.sihamark.simpleviewpager.SimplePage
import com.sihamark.simpleviewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private val pages: List<Page> by lazy {
		listOf(
			SimplePage(
				this@MainActivity,
				R.string.page1,
				{ TestFragment.newInstance(R.color.page1) }),
			SimplePage(
				this@MainActivity,
				R.string.page2,
				{ TestFragment.newInstance(R.color.page2) }),
			SimplePage(
				this@MainActivity,
				R.string.page3,
				{ TestFragment.newInstance(R.color.page3) })
		)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val binding: ActivityMainBinding =
			DataBindingUtil.setContentView(this, R.layout.activity_main)

		binding.adapter = ListPagerAdapter(supportFragmentManager, pages)
	}
}
