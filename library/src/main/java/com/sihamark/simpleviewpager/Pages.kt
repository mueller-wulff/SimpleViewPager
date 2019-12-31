package com.sihamark.simpleviewpager

import android.content.Context
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

	constructor(
		context: Context, @StringRes titleRes: Int, getFragment: () -> Fragment
	) : this(context.getString(titleRes), getFragment)

	override val fragment: Fragment by lazy { getFragment() }
}