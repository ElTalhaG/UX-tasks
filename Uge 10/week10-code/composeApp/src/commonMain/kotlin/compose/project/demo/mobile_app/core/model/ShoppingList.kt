package compose.project.demo.mobile_app.core.model


    data class ShoppingList(
        val id: Int,
        val name: String,
        var items: List<ShoppingListItem> = emptyList(),
    )
