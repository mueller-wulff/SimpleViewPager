/*
 * Copyright (c) 2018.  Müller & Wulff GmbH. All rights reserved.
 */

package com.sihamark.simpleviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ListPagerAdapter(
	fragmentManager: FragmentManager,
	private val pages: List<Page>
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
	override fun getItem(position: Int): Fragment = pages[position].fragment
	override fun getCount(): Int = pages.size
	override fun getPageTitle(position: Int): CharSequence? = pages[position].title
}

