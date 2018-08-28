package com.muellerwulff.simpleviewpager.example

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.muellerwulff.simpleviewpager.Page
import com.muellerwulff.simpleviewpager.R
import com.muellerwulff.simpleviewpager.SimplePage
import com.muellerwulff.simpleviewpager.databinding.ActivityMainBinding
import com.muellerwulff.simpleviewpager.toPagerAdapter

class MainActivity : AppCompatActivity() {

	private val pages: List<Page> by lazy {
		listOf(
			SimplePage(this, R.string.page1) {
				TestFragment.newInstance(R.color.page1)
			},
			SimplePage(this, R.string.page2) {
				TestFragment.newInstance(R.color.page2)
			},
			SimplePage(this, R.string.page3) {
				TestFragment.newInstance(R.color.page3)
			}
		)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val binding: ActivityMainBinding =
			DataBindingUtil.setContentView(this, R.layout.activity_main)

		binding.adapter = pages.toPagerAdapter(supportFragmentManager)
	}
}
