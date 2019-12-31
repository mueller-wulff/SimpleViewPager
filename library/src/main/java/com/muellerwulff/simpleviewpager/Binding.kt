package com.muellerwulff.simpleviewpager

import android.view.View
import androidx.annotation.IdRes
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

@BindingAdapter("viewPager")
fun setViewPager(tabLayout: TabLayout, @IdRes viewPagerId: Int) {
	val viewPager = searchForViewPager(tabLayout, viewPagerId) ?: return
	tabLayout.setupWithViewPager(viewPager)
}

private fun searchForViewPager(view: View, @IdRes viewPagerId: Int) =
	searchRecursively(view, viewPagerId, 0, 3)

private fun searchRecursively(
	view: View, @IdRes viewPagerId: Int, level: Int, maxLevel: Int
): ViewPager? {
	if (level >= maxLevel) return null
	val viewPager = view.findViewById<ViewPager>(viewPagerId)
	return if (viewPager != null) {
		viewPager
	} else {
		val parent = view.parent as? View
		parent?.let {
			searchRecursively(it, viewPagerId, level + 1, maxLevel)
		}
	}
}