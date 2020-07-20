from typing import List, Optional


class Node:
    def __init__(self, i: int, char: str):
        self.i = i
        self.char = char
        self.children = set()
        self.map = [0] * 26  # index(character) -> count in sub tree


class Solution:
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:
        nodes = [Node(i, labels[i]) for i in range(n)]
        for edge in edges:
            nodes[edge[0]].children.add(nodes[edge[1]])
            nodes[edge[1]].children.add(nodes[edge[0]])

        def add_array(a: List[int], b: List[int]):
            for i in range(26):
                a[i] += b[i]

        def step(node: Node, parent: Optional[Node]):
            if parent:
                node.children.remove(parent)
            node.map[ord(node.char) - 97] = 1
            for child in node.children:
                step(child, node)
                add_array(node.map, child.map)

        step(nodes[0], None)

        return list(map(lambda node: node.map[ord(node.char) - 97], nodes))
