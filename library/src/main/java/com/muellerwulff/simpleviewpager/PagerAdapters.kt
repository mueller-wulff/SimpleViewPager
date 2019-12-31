package com.muellerwulff.simpleviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class ListFragmentPagerAdapter(
	fragmentManager: FragmentManager,
	private val pages: List<Page>
) : FragmentPagerAdapter(
	fragmentManager,
	BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
	override fun getItem(position: Int): Fragment = pages[position].fragment
	override fun getCount(): Int = pages.size
	override fun getPageTitle(position: Int): CharSequence? = pages[position].title
}

fun <T : Page> List<T>.toPagerAdapter(fragmentManager: FragmentManager) =
	ListFragmentPagerAdapter(fragmentManager, this)

class ListFragmentStatePagerAdapter(
	fragmentManager: FragmentManager,
	private val pages: List<Page>
) : FragmentStatePagerAdapter(
	fragmentManager,
	BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
	override fun getItem(position: Int): Fragment = pages[position].fragment
	override fun getCount(): Int = pages.size
	override fun getPageTitle(position: Int): CharSequence? = pages[position].title
}

fun <T : Page> List<T>.toStatePagerAdapter(fragmentManager: FragmentManager) =
	ListFragmentStatePagerAdapter(fragmentManager, this)