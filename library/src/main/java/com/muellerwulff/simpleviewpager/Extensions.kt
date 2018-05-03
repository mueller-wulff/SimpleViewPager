package com.muellerwulff.simpleviewpager

import android.support.v4.app.FragmentManager

fun <T : Page> List<T>.toPagerAdapter(fragmentManager: FragmentManager) =
	ListPagerAdapter(fragmentManager, this)