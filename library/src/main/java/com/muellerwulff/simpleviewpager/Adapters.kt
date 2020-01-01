package com.muellerwulff.simpleviewpager

import androidx.fragment.app.*
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @author Hans Markwart (fanaloce@gmail.com)
 *
 * created at 01.01.2020.
 */

//ViewPager2

class ListFragmentStateAdapter(
	fragmentManager: FragmentManager,
	lifecycle: Lifecycle,
	private val pages: List<Page>
) : FragmentStateAdapter(fragmentManager, lifecycle) {

	constructor(activity: FragmentActivity, pages: List<Page>) :
			this(activity.supportFragmentManager, activity.lifecycle, pages)

	constructor(fragment: Fragment, pages: List<Page>) :
			this(fragment.childFragmentManager, fragment.lifecycle, pages)

	override fun createFragment(position: Int) = pages[position].fragment
	override fun getItemCount() = pages.size
}

fun <T : Page> List<T>.toStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) =
	ListFragmentStateAdapter(fragmentManager, lifecycle, this)

fun <T : Page> List<T>.toStateAdapter(fragmentActivity: FragmentActivity) =
	ListFragmentStateAdapter(fragmentActivity, this)

fun <T : Page> List<T>.toStateAdapter(fragment: Fragment) =
	ListFragmentStateAdapter(fragment, this)

//ViewPager

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