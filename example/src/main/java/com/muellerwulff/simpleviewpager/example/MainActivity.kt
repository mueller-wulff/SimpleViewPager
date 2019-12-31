package com.muellerwulff.simpleviewpager.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.muellerwulff.simpleviewpager.Page
import com.muellerwulff.simpleviewpager.SimplePage
import com.muellerwulff.simpleviewpager.example.databinding.ActivityMainBinding
import com.muellerwulff.simpleviewpager.toStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	private val pages: List<Page> by lazy {
		listOf(
			SimplePage(R.string.page1) { ColorFragment.newInstance(R.color.page1) },
			SimplePage(R.string.page2) { ColorFragment.newInstance(R.color.page2) },
			SimplePage(R.string.page3) { ColorFragment.newInstance(R.color.page3) }
		)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

		pager.adapter = pages.toStatePagerAdapter(supportFragmentManager)
	}
}
