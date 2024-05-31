package ir.fatemelyasii.movie.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.fatemelyasii.movie.models.Data
import ir.fatemelyasii.movie.models.Details
import ir.fatemelyasii.movie.paging.PaginationFactory
import ir.fatemelyasii.movie.repository.Repository
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val repository = Repository()

    //instance of screen dataClass
    var state by mutableStateOf(ScreenState())
    //instance of id for get details by id for sending to screen
    var id by mutableIntStateOf(0)


    private val pagination = PaginationFactory(
        initialPage = state.page,
        onLoadUpdated = {
            state = state.copy(
                isLoading = it
            )
        },
        onRequest = {nextPage ->
            repository.getMovieList(nextPage)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = {items, newPage ->
            state = state.copy(
                movies = state.movies + items.data,
                page = newPage,
                endReached = state.page == 25
            )
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            pagination.loadNextPage()
        }
    }

/*
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
*/

    //FUN FOR CALLING GET DETAILS BY ID
    fun getDetailsById() {
        viewModelScope.launch {
            try {
                val response = repository.getDetailsById(id = id)
                if (response.isSuccessful) {
                    state = state.copy(
                        detailsData = response.body()!!
                    )
                }
            } catch (e: Exception) {
                state = state.copy(
                    error = e.message
                )
            }
        }
    }
}

data class ScreenState(
    val movies: List<Data> = emptyList(),
    val page: Int = 1,
    //---
    val detailsData: Details = Details(),
    //---
    val endReached: Boolean = false,
    val error: String? = null,
    val isLoading: Boolean = false
    )
