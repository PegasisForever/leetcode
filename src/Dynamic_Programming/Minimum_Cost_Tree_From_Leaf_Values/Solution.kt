package Dynamic_Programming.Minimum_Cost_Tree_From_Leaf_Values

// TODO
// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
class Solution {
    class Pair(var value: Int, var max: Int)

    //This problem is a variation of Matrix chain multiplication.
    //It is a very famous Dp problem.
    //Upvote if you like the solution. Thanks!
    lateinit var ar: IntArray
    lateinit var dp: Array<Array<Pair?>>

    //Here a pair object has 2 attributes, val and max
    //val -> It is the value of the internal node formed by multiplying the
    //       maximum values of leaf in the right and left sub trees.
    //max -> If this tree were to be a subtree to a node above it, we need to pass on the
    //       max value of the leaf present in this sub tree
    fun solve(i: Int, j: Int): Pair? {
        //If single node, No internal node is formed.
        //Therefore, val = 0, max = ar[i]
        if (j - i + 1 == 1) return Pair(0, ar[i])

        //If 2 nodes, val of the internal node will be ar[i] * ar[j]
        //And the max of them will be passed as the maximum leaf value for a Node above it
        if (j - i + 1 == 2) return Pair(ar[i] * ar[j], Math.max(ar[i], ar[j]))

        //If value is already calculated, return it.
        if (dp[i][j] != null) return dp[i][j]

        //Initialize the current internal node value as Integer Max
        var min = Int.MAX_VALUE
        var max = -1
        for (k in i until j) {
            //Aftering solving the left part
            val left = solve(i, k)
            //Aftering solving the right part
            val right = solve(k + 1, j)

            val sum = when {
                //If left.val == 0, then it was a single node
                //right.val will be the only internal node that is formed
                left!!.value == 0 -> right!!.value + left.max * right.max
                //If right.val == 0, then it was a single node
                //left.val will be the only internal node that is formed
                right!!.value == 0 -> left.value + left.max * right.max
                //Otherwise, left.val and right.val are the values of the internal nodes
                //Formed by the left and right subtree
                else -> left.value + right.value + left.max * right.max
            }

            //We add left.max * right.max to all the cases because
            //the parent node in all the cases will be the product of the
            //Max leaf value in the left and right subtree

            //Update sum and max if necessary
            if (min > sum) {
                min = sum
                max = Math.max(left.max, right.max)
            }
        }

        //Store in dp and return
        return Pair(min, max).also { dp[i][j] = it }
    }

    fun mctFromLeafValues(arr: IntArray?): Int {
        if (arr == null || arr.isEmpty()) return 0
        dp = Array(arr.size) { Array<Pair?>(arr.size) { null } }
        ar = arr
        return solve(0, arr.size - 1)!!.value
    }
}
