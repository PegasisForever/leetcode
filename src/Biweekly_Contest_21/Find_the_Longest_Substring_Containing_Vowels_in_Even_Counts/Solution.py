class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        vowels = ('a', 'e', 'i', 'o', 'u')
        map = {}
        state = [True, True, True, True, True]
        map[tuple(state)] = -1
        maxLength = 0

        for index in range(0, len(s)):
            c = s[index]
            for i in range(5):
                if c == vowels[i]:
                    state[i] = not state[i]
                    break

            if tuple(state) not in map:
                map[tuple(state)] = index
            else:
                maxLength = max(maxLength, index - map[tuple(state)])

        return maxLength