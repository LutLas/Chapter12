fun main() {
    val groceries = listOf(
        Grocery(
            "Tomatoes",
            "Vegetable",
            "lb",
            3.0,
            3
        ),
        Grocery(
            "Mushrooms",
            "Vegetable",
            "lb",
            4.0,
            1
        ),
        Grocery(
            "Bagels",
            "Bakery",
            "Pack",
            1.5,
            2
        ),
        Grocery(
            "Olive oil",
            "Pantry",
            "Bottle",
            6.0,
            1
        ),
        Grocery(
            "Ice Cream",
            "Frozen",
            "Pack",
            3.0,
            2
        )
    )

    val lowestUnitPrice = groceries.minByOrNull { it.unitPrice }
    val lowestQuantity = groceries.minByOrNull { it.quantity }
    val sumQuantity = groceries.sumBy { it.quantity }
    val totalPrice = groceries.sumByDouble { it.quantity * it.unitPrice }
    val vegetables = groceries.filter { it.category == "Vegetable" }
    val unitPriceOver3 = groceries.filter { it.unitPrice > 3.0 }
    val notFrozen = groceries.filterNot { it.category == "Frozen" }

    println("lowest price : ${lowestUnitPrice?.name}")
    println("lowest quantity : ${lowestQuantity?.name}")
    println("Total grocery quantity : $sumQuantity")
    println("Total grocery price : $$totalPrice")
    println("Veggies")
    for(i in vegetables)println("${i.name}, $${i.unitPrice}, ${i.category}, ${i.quantity}")
    println("************************")
    println("Greater than 3 unit price")
    for(i in unitPriceOver3)println("${i.name}, $${i.unitPrice}, ${i.category}, ${i.quantity}")
    println("************************")
    println("Not Frozen")
    for(i in notFrozen)println("${i.name}, $${i.unitPrice}, ${i.category}, ${i.quantity}")
    println("************************")


}

data class Grocery(
    val name: String,
    val category: String,
    val unit: String,
    val unitPrice: Double,
    val quantity: Int
)