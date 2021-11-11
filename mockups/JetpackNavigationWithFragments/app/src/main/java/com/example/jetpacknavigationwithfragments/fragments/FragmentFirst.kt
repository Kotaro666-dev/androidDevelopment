package com.example.jetpacknavigationwithfragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpacknavigationwithfragments.R
import com.example.jetpacknavigationwithfragments.databinding.FragmentFirstBinding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class FragmentFirst : Fragment() {
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.fragmentFragmentNavigateToFragmentSecond.apply {
            // Dispose the Composition when the view's LifecycleOwner
//            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose world
                MaterialTheme {
                    NavigationButton(
                        onClick = { onClickNavigateToFragmentSecondButton(view) },
                        buttonTitle = "ログイン",
                        backgroundColor = Color.Green,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 20.dp)

                    )
                }
            }
        }

        binding.fragmentFragmentNavigateToFragmentThird.apply {
            // Dispose the Composition when the view's LifecycleOwner
//            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose world
                MaterialTheme {
                    NavigationButton(
                        onClick = { onClickNavigateToFragmentThirdButton(view) },
                        buttonTitle = "新規登録",
                        backgroundColor = Color.Blue,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 20.dp)
                    )
                }
            }
        }

//        binding.fragmentFragmentNavigateToFragmentSecond.setOnClickListener {
//            onClickNavigateToFragmentSecondButton(
//                view
//            )
//        }
//        binding.fragmentFragmentNavigateToFragmentThird.setOnClickListener {
//            onClickNavigateToFragmentThirdButton(
//                view
//            )
//        }
//        binding.composeView.apply {
//            // Dispose the Composition when the view's LifecycleOwner
//            // is destroyed
//            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
//            setContent {
//                // In Compose world
//                MaterialTheme {
//                    Text("Hello Compose!")
//                }
//            }
//        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onClickNavigateToFragmentSecondButton(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_fragmentFirst_to_fragmentSecond)
    }

    private fun onClickNavigateToFragmentThirdButton(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_fragmentFirst_to_fragmentThird)
    }
}

@Composable
fun NavigationButton(
    onClick: () -> Unit,
    buttonTitle: String,
    backgroundColor: Color = MaterialTheme.colors.primary,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = Color.White
        )
    ) {
        Text(text = buttonTitle)
    }
}

@Preview
@Composable
fun PreviewNavigationButton() {
    NavigationButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = {},
        buttonTitle = "新規登録",
        backgroundColor = Color.Cyan
    )
}
