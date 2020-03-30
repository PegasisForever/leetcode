import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
typealias LeetNode = TreeNode

fun LeetNode.toNode(): Node<Int> {
    return Node(`val`).apply {
        left = this@toNode.left?.toNode()
        right = this@toNode.right?.toNode()
    }
}

fun Node<Int>.toLeetNode(): LeetNode {
    return TreeNode(value).apply {
        left = this@toLeetNode.left?.toLeetNode()
        right = this@toLeetNode.right?.toLeetNode()
    }
}

class Node<T>(var value: T, private val comparator: Comparator<T>? = null) : Comparable<Node<T>> {
    var left: Node<T>? = null
    var right: Node<T>? = null

    val size
        get(): Int {
            var size = 0
            if (left != null) size++
            if (right != null) size++
            return size
        }

    fun remove(node: Node<T>) {
        this.replace(node, null)
    }

    fun replace(old: Node<T>?, new: Node<T>?) {
        if (left == old) left = new
        else if (right == old) right = new
    }

    override fun compareTo(other: Node<T>): Int {
        return if (comparator != null) {
            comparator.compare(value, other.value)
        } else if (value is Comparable<*>) {
            return (value as Comparable<T>).compareTo(other.value)
        } else {
            error("Type is not comparable, please provide a comparator.")
        }
    }
}

class BinarySearchTree<T>(
    private val comparator: Comparator<T>? = null,
    private var root: Node<T>? = null
) : MutableCollection<T> {
    private var _size = 0

    init {
        if (root != null) {
            val iterator = iterator()
            while (iterator.hasNext()) {
                _size++
                iterator.next()
            }
        }
    }

    override fun add(element: T): Boolean {
        val newNode = Node(element)
        _size++
        if (root == null) {
            root = newNode
            return true
        }
        var curr = root
        while (curr != null) {
            if (newNode > curr) {
                if (curr.right == null) {
                    curr.right = newNode
                    return true
                } else {
                    curr = curr.right
                }
            } else {
                if (curr.left == null) {
                    curr.left = newNode
                    return true
                } else {
                    curr = curr.left
                }
            }
        }
        error("wtf")
    }

    override fun remove(element: T): Boolean {
        val (parent, node) = search(element) ?: return false

        when (node.size) {
            0 -> if (parent == null) {
                root = null
            } else {
                parent.remove(node)
            }
            1 -> if (parent == null) {
                root = node.left ?: node.right
            } else {
                parent.replace(node, node.left ?: node.right)
            }
            2 -> {
                val successor = findSuccessor(node)!!
                val needRemoveParent = search(successor.value)!!.first!!
                val temp = successor.value
                successor.value = node.value
                node.value = temp

                val needRemove = successor
                val child = needRemove.left ?: needRemove.right
                if (needRemoveParent.left?.value == needRemove.value) needRemoveParent.left = child
                else if (needRemoveParent.right?.value == needRemove.value) needRemoveParent.right = child
            }
        }
        _size--
        return true
    }

    override fun contains(element: T): Boolean = search(element) != null

    //return: parent to node
    private fun search(target: T, root: Node<T>? = this.root): Pair<Node<T>?, Node<T>>? {
        root ?: return null
        val targetNode = Node(target)
        var parent: Node<T>? = null
        var curr = root

        while (curr != null) {
            val oldCurr = curr
            curr = when {
                curr == targetNode -> return parent to curr
                curr < targetNode -> curr.right
                else -> curr.left
            }
            parent = oldCurr
        }
        return null
    }

    private fun findSuccessor(node: Node<T>): Node<T>? {
        var curr = node.right
        while (curr?.left != null) {
            curr = curr.left
        }
        return curr
    }

    override val size: Int
        get() = _size

    operator fun get(index: Int): T {
        if (index !in 0 until size) error("Index out of bound")

        if (index < size / 2) {
            val iterator = TreeIterator()
            repeat(index) {
                iterator.next()
            }
            return iterator.next()
        } else {
            val iterator = TreeIterator(true)
            repeat(size - 1 - index) {
                iterator.next()
            }
            return iterator.next()
        }
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        elements.forEach { element ->
            if (search(element) == null) return false
        }
        return true
    }

    override fun isEmpty() = size == 0

    override fun addAll(elements: Collection<T>): Boolean {
        elements.forEach { add(it) }
        return true
    }

    override fun clear() {
        root = null
    }

    inner class TreeIterator(private val reverse: Boolean = false) : MutableIterator<T> {
        private val stack = Stack<Node<T>>()
        private var curr = root
        private var lastReturned: T? = null

        init {
            updateCurr()
        }

        private fun updateCurr() {
            while (curr != null) {
                stack.push(curr)
                curr = if (reverse) curr!!.right else curr!!.left
            }
        }

        override fun hasNext() = stack.isNotEmpty()

        override fun next(): T {
            val node = stack.pop()
            curr = if (reverse) node!!.left else node!!.right
            updateCurr()
            lastReturned = node.value
            return node.value
        }

        override fun remove() {
            this@BinarySearchTree.remove(lastReturned)
        }
    }

    override fun iterator() = TreeIterator()

    override fun removeAll(elements: Collection<T>): Boolean {
        var removedAny = false
        elements.forEach {
            if (remove(it)) removedAny = true
        }
        return removedAny
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }
}