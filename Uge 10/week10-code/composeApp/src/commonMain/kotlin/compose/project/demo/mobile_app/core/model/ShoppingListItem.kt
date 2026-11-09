package compose.project.demo.mobile_app.core.model

data class ShoppingListItem(
    val id: Int,
    val description: String,
    val quantity: Int = 1,
    val isChecked: Boolean = false,
    val baseItemId: Int? = null,
)