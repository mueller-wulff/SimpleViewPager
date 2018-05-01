package com.sihamark.simpleviewpager.example

import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sihamark.simpleviewpager.databinding.FragmentColorBinding

/**
 * @author Hans Markwart (fanaloce@gmail.com)
 *
 * created at 01.05.2018.
 */
class TestFragment : Fragment() {

	@ColorRes
	private var color = 0

	private lateinit var binding: FragmentColorBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		color = getColor()
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentColorBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		binding.color = ContextCompat.getColor(requireContext(), color)
	}

	@ColorRes
	private fun getColor(): Int = arguments?.getInt(ARG_COLOR) ?: error("no color given")

	companion object {
		private const val ARG_COLOR = "arg.color"

		fun newInstance(@ColorRes color: Int) = TestFragment().apply {
			arguments = Bundle().apply { putInt(ARG_COLOR, color) }
		}
	}
}