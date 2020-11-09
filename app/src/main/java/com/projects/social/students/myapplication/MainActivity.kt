package com.projects.social.students.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val V = 6
        val source = 0
        val output: StringBuilder = java.lang.StringBuilder()
        // connected edges
        val adj: MutableList<MutableList<Node>> = ArrayList()

        // Initialize list for every node
        for (i in 0 until V) {
            val item: MutableList<Node> = ArrayList()
            adj.add(item)
        }

        // Inputs

        adj[0].add(Node(1, 2))
        adj[0].add(Node(2, 3))
        adj[0].add(Node(3, 1))
        adj[0].add(Node(4, 1))
        adj[0].add(Node(5, 3))

        // Calculate the single source shortest path
        val d = DijAlg(V)
        d.dijkstra(adj, source)

        // Print the shortest path to all the nodes
        for (i in d.dist.indices) {
            output.append(source.toString() + " to " + i + " is " + d.dist[i]+"\n")
        }
        findViewById<TextView>(R.id.tv_otpt).text = output
    }
}