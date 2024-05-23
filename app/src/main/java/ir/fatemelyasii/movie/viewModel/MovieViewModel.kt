package ir.fatemelyasii.movie.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkrdeveloper.movieinfoappmvvm.models.Data
import ir.fatemelyasii.movie.repository.Repository
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val repository = Repository()

    //instance of screen dataClass
    var state by mutableStateOf(ScreenState())
    var id by mutableIntStateOf(0)

    init {
        viewModelScope.launch {
            val response = repository.getMovieList(state.page)
            if (response.isSuccessful) {
                state = state.copy(
                    movies = response.body()!!.data
                )
            }
        }
    }
}

data class ScreenState(
    val movies: List<Data> = emptyList(),
    val page: Int = 1,

)

