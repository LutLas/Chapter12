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
    println("************************")
    println("Veggies")
    for(i in vegetables)println("${i.name}, $${i.unitPrice}, ${i.category}, ${i.quantity}")
    println("************************")
    println("Greater than 3 unit price")
    for(i in unitPriceOver3)println("${i.name}, $${i.unitPrice}, ${i.category}, ${i.quantity}")
    println("************************")
    println("Not Frozen")
    for(i in notFrozen)println("${i.name}, $${i.unitPrice}, ${i.category}, ${i.quantity}")
    println("************************")

    val ints = listOf(1, 2, 3, 4)
    val doubleInts = ints.map { it * 2 }
    val groceryNames = groceries.map { it.name }
    val halfUnitPrice = groceries.map { it.unitPrice * 0.5 }
    val newPrices = groceries.filter{it.unitPrice > 3.0}.map { it.unitPrice * 2 }
    println(doubleInts)
    println(groceryNames)
    println(halfUnitPrice)
    println(newPrices)

    groceries.forEach { println("${ it.name }, K${ it.unitPrice } ${it.category}") }
    /*
    Which code is more concise "for" or "forEach"
    for (item in groceries) if (item.unitPrice > 3.0) println(item.name)
    groceries.filter { it.unitPrice > 3.0 }.forEach { println(it.name) }
    */

    var itemNames = ""
    groceries.forEach{ itemNames += "${it.name} "}
    println("itemNames: $itemNames")

    val groupByCategory = groceries.groupBy { it.category }
    println("Category: $groupByCategory")
    groceries.groupBy { it.category }.forEach {
        println(it.key)
        /*it.value.forEach { println("   ${it.name}") }*/


    }
    val sumOfInts = ints.fold(0){runningSum, item -> runningSum + item}
    println(sumOfInts)

}

data class Grocery(
    val name: String,
    val category: String,
    val unit: String,
    val unitPrice: Double,
    val quantity: Int
)