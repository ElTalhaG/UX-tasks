package compose.project.demo.mobile_app.ui.screens.mylists

import compose.project.demo.mobile_app.core.model.ShoppingList

sealed interface MyListsState {

    data object Loading : MyListsState

    data class Success(
        val lists: List<ShoppingList>
    ) : MyListsState

    data class Error(
        val msg: String
    ) : MyListsState
}