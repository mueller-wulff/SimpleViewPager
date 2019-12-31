package com.muellerwulff.simpleviewpager

import android.app.Activity
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

interface Page {
	val title: CharSequence
	val fragment: Fragment
}

class SimplePage(
	override val title: CharSequence,
	getFragment: () -> Fragment
) : Page {
	override val fragment: Fragment by lazy { getFragment() }
}

fun Activity.SimplePage(@StringRes titleRes: Int, getFragment: () -> Fragment) =
	SimplePage(getString(titleRes), getFragment)

fun Fragment.SimplePage(@StringRes titleRes: Int, getFragment: () -> Fragment) =
	SimplePage(getString(titleRes), getFragment)