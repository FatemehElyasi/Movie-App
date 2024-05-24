package ir.fatemelyasii.movie

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.fatemelyasii.movie.navigation.Navigation
import ir.fatemelyasii.movie.ui.theme.MovieTheme
import ir.fatemelyasii.movie.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTheme {
                //1-delete status bar
                WindowCompat.setDecorFitsSystemWindows(window,false)
                window.setFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                )
                //2-create linear colors
                val linearGradientBrush=Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFB226E1),
                        Color(0xFFFC6603),
                        Color(0xFF5995EE),
                        Color(0xFF3D3535)
                    ),
                    start = Offset(Float.POSITIVE_INFINITY, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY),
                )

                //3-background
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //-------------
                    /*val movieViewModel = viewModel<MovieViewModel>()
                    val state = movieViewModel.state
                    Text(text = state.movies.toString())
                     */
                    //-------------
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(brush = linearGradientBrush))

                    {
                        //4-call background
                        Navigation()
                    }
                }
            }
        }
    }
}
