package Weekly_Contest_217.Richest_Customer_Wealth

// https://leetcode.com/contest/weekly-contest-217/problems/richest-customer-wealth
class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        return accounts.map { it.sum() }.max()!!
    }
}


