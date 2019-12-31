/*
 * Copyright (c) 2018.  Müller & Wulff GmbH. All rights reserved.
 */

package com.muellerwulff.simpleviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

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

