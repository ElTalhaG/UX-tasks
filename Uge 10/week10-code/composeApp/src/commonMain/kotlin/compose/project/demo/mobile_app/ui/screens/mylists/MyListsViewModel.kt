package compose.project.demo.mobile_app.ui.screens.mylists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import compose.project.demo.mobile_app.core.model.ShoppingList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyListsViewModel : ViewModel() {

    private val _state = MutableStateFlow<MyListsState>(MyListsState.Loading)
    val state: StateFlow<MyListsState> = _state

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            _state.value = MyListsState.Loading
            delay(1000)

            val lists = listOf(
                ShoppingList(id = 1, name = "Frugt og grønt"),
                ShoppingList(id = 2, name = "Morgenmad"),
                ShoppingList(id = 3, name = "Husholdning"),
            )

            _state.value = MyListsState.Success(lists)
        }
    }
}
