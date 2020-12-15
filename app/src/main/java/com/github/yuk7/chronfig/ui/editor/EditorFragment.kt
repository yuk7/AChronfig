package com.github.yuk7.chronfig.ui.editor

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.yuk7.chronfig.R
import com.github.yuk7.chronfig.databinding.FragmentEditorBinding

class EditorFragment : Fragment(R.layout.fragment_editor) {
    private lateinit var binding: FragmentEditorBinding
    private lateinit var viewModel : EditorViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentEditorBinding.bind(view)
        viewModel = ViewModelProvider(this).get(EditorViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }
}