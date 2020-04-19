package Weekly_Contest_185.b

//https://leetcode.com/contest/weekly-contest-185/problems/display-table-of-food-orders-in-a-restaurant/
class Solution {
    fun HashMap<String, Int>.addOne(name: String) {
        this[name] = (this[name] ?: 0) + 1
    }

    fun displayTable(orders: List<List<String>>): List<List<String>> {
        val tableMap = hashMapOf<Int, HashMap<String, Int>>()
        orders.forEach { order ->
            val tableNum = order[1].toInt()
            val table = tableMap[tableNum] ?: hashMapOf()
            table.addOne(order[2])
            tableMap[tableNum] = table
        }

        val sortedTables = tableMap
            .toList()
            .sortedBy {
                it.first
            }
        val foods = hashSetOf<String>()
        sortedTables.forEach { (_, ordered) -> foods.addAll(ordered.keys) }
        val sortedFoods = foods.toMutableList().apply { sort() }

        val result = ArrayList<List<String>>(sortedTables.size + 1)
        result.add(sortedFoods)
        sortedTables.forEach { (tNum, orders) ->
            val line = ArrayList<String>(sortedFoods.size + 1)
            line.add(tNum.toString())
            sortedFoods.forEach { food ->
                line.add(orders[food]?.toString() ?: "0")
            }
            result.add(line)
        }

        sortedFoods.add(0, "Table")

        return result
    }
}