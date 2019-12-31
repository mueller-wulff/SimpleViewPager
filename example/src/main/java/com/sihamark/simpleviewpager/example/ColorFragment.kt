package com.sihamark.simpleviewpager.example

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.sihamark.simpleviewpager.R
import kotlinx.android.synthetic.main.fragment_color.*

class ColorFragment : Fragment(R.layout.fragment_color) {

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		color_view.setBackgroundColor(ContextCompat.getColor(requireContext(), getColor()))
	}

	@ColorRes
	private fun getColor(): Int = arguments?.getInt(ARG_COLOR) ?: error("no color given")

	companion object {
		private const val ARG_COLOR = "arg.color"

		fun newInstance(@ColorRes color: Int) = ColorFragment().apply {
			arguments = Bundle().apply { putInt(ARG_COLOR, color) }
		}
	}
}