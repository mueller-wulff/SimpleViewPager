/*
 * Copyright (c) 2018.  Müller & Wulff GmbH. All rights reserved.
 */

package com.sihamark.simpleviewpager

import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Hans Markwart on 16.03.2018
 */
class ListPagerAdapter(
	fragmentManager: FragmentManager,
	private val pages: List<Page>
) : FragmentPagerAdapter(fragmentManager) {
	override fun getItem(position: Int): Fragment = pages[position].fragment
	override fun getCount(): Int = pages.size
	override fun getPageTitle(position: Int): CharSequence? = pages[position].title
}

interface Page {
	val title: CharSequence
	val fragment: Fragment
}

class SimplePage(
	override val title: CharSequence,
	getFragment: () -> Fragment
) : Page {

	constructor(
		context: Context, @StringRes titleRes: Int, getFragment: () -> Fragment
	) : this(context.getString(titleRes), getFragment)

	override val fragment: Fragment by lazy { getFragment() }
}