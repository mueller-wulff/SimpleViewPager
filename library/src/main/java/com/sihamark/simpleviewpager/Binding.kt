package com.sihamark.simpleviewpager

import android.databinding.BindingAdapter
import android.support.annotation.IdRes
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View

@BindingAdapter("viewPager")
fun setViewPager(tabLayout: TabLayout, @IdRes viewPagerId: Int) {
	val viewPager = searchForViewPager(tabLayout, viewPagerId) ?: return
	tabLayout.setupWithViewPager(viewPager)
}

private fun searchForViewPager(view: View, @IdRes viewPagerId: Int): ViewPager? {
	return searchRecursively(view, viewPagerId, 0, 3)
}

private fun searchRecursively(
	view: View, @IdRes viewPagerId: Int,
	level: Int,
	maxLevel: Int
): ViewPager? {
	if (level >= maxLevel) return null
	val viewPager = view.findViewById<ViewPager>(viewPagerId)
	return if (viewPager != null) {
		viewPager
	} else {
		val parent = view.parent as? View
		if (parent != null) {
			searchRecursively(parent, viewPagerId, level + 1, maxLevel)
		} else {
			null
		}
	}
}