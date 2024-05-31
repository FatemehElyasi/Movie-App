package ir.fatemelyasii.movie.paging

interface Pagination<Key, Item> {
    suspend fun loadNextPage()
    fun reset()
}