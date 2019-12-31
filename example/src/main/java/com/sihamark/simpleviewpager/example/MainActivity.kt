package com.sihamark.simpleviewpager.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sihamark.simpleviewpager.Page
import com.sihamark.simpleviewpager.R
import com.sihamark.simpleviewpager.SimplePage
import com.sihamark.simpleviewpager.databinding.ActivityMainBinding
import com.sihamark.simpleviewpager.toPagerAdapter

class MainActivity : AppCompatActivity() {

	private val pages: List<Page> by lazy {
		listOf(
			SimplePage(
				this@MainActivity,
				R.string.page1
			) { ColorFragment.newInstance(R.color.page1) },
			SimplePage(
				this@MainActivity,
				R.string.page2
			) { ColorFragment.newInstance(R.color.page2) },
			SimplePage(
				this@MainActivity,
				R.string.page3
			) { ColorFragment.newInstance(R.color.page3) }
		)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val binding: ActivityMainBinding =
			DataBindingUtil.setContentView(this, R.layout.activity_main)

		binding.adapter = pages.toPagerAdapter(supportFragmentManager)
	}
}
