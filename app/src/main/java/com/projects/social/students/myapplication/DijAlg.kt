package com.projects.social.students.myapplication

import java.util.*

class DijAlg(  // Number of compartments
    var V: Int
) {
    var adj: List<List<Node>>? = emptyList()
    var dist: IntArray = IntArray(V)
    var settled: MutableSet<Int> = HashSet()
    var pq: PriorityQueue<Node> = PriorityQueue(V, Node())

    // Function for Dijkstra's Algorithm
    fun dijkstra(adj: List<List<Node>>?, src: Int) {
        this.adj = adj
        for (i in 0 until V) dist[i] = Int.MAX_VALUE

        // Add source node to the priority queue
        pq.add(Node(src, 0))

        // Distance to the source is 0
        dist[src] = 0
        while (settled.size != V) {

            // remove the minimum distance node
            // from the priority queue
            val u = pq.remove().node

            // adding the node whose distance is
            // finalized
            settled.add(u)
            e_Neighbours(u)
        }
    }

    // Function to process all the compartments
    // of the passed node
    private fun e_Neighbours(u: Int) {
        var edgeDistance: Int
        var newDistance: Int

        // All the neighbors of v
        for (i in adj!![u].indices) {
            val v = adj!![u][i]

            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost
                newDistance = dist[u] + edgeDistance

                // If new distance is cheaper in cost
                if (newDistance < dist[v.node]) dist[v.node] = newDistance

                // Add the current node to the queue
                pq.add(Node(v.node, dist[v.node]))
            }
        }
    }

}

// Class to represent a node in the graph

class Node : Comparator<Node> {
    var node = 0
    var cost = 0

    constructor()
    constructor(node: Int, cost: Int) {
        this.node = node
        this.cost = cost
    }

    override fun compare(node1: Node, node2: Node): Int {
        if (node1.cost < node2.cost) return -1
        return if (node1.cost > node2.cost) 1 else 0
    }
}