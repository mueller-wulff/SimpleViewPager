/*
 * Copyright (c) 2018.  Müller & Wulff GmbH. All rights reserved.
 */

package com.sihamark.simpleviewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ListPagerAdapter(
	fragmentManager: FragmentManager,
	private val pages: List<Page>
) : FragmentPagerAdapter(fragmentManager) {
	override fun getItem(position: Int): Fragment = pages[position].fragment
	override fun getCount(): Int = pages.size
	override fun getPageTitle(position: Int): CharSequence? = pages[position].title
}

