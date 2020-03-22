

# https://leetcode.com/contest/weekly-contest-181/problems/longest-happy-prefix/
# For some reason this brute force solution works
class Solution:
    def longestPrefix(self, s: str) -> str:
        l = len(s)
        final = ''
        for i in range(l):
            if s[:i] == s[l - i:]:
                final = s[:i]
        return final
