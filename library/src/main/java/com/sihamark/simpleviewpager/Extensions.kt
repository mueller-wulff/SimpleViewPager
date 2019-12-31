package com.sihamark.simpleviewpager

import androidx.fragment.app.FragmentManager

fun <T : Page> List<T>.toPagerAdapter(fragmentManager: FragmentManager) =
	ListPagerAdapter(fragmentManager, this)