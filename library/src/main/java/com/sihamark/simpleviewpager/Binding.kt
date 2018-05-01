package com.sihamark.simpleviewpager

import android.databinding.BindingAdapter
import android.support.annotation.IdRes
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View

@BindingAdapter("viewPager")
fun setViewPager(tabLayout: TabLayout, @IdRes viewPagerId: Int) {
	val viewPager: ViewPager = (tabLayout.parent as View)
		.findViewById(viewPagerId) ?: return
	tabLayout.setupWithViewPager(viewPager)
}