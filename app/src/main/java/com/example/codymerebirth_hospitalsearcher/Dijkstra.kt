package com.example.codymerebirth_hospitalsearcher

import java.util.*
import kotlin.collections.HashMap

class Dijkstra(val edges: Array<IntArray>, val directed: Boolean, val showAllPaths: Boolean = false) {
    private val graph = HashMap<Int, Vertex>(edges.size)
    private val listEdges = mutableListOf<Edge>()

    init {


        for(i in 0..edges.size-1) {

            for(j in 0..edges.get(i).size-1) {

                if(edges.get(i).get(j)!=0) {

                    listEdges.add(Edge(i,j,edges.get(i).get(j)))

                }

            }

        }



        for (e in listEdges) {
            if (!graph.containsKey(e.v1)) graph[e.v1] = Vertex(e.v1)
            if (!graph.containsKey(e.v2)) graph[e.v2] = Vertex(e.v2)
        }

        for (e in listEdges) {
            graph[e.v1]!!.neighbours[graph[e.v2]!!] = e.dist
            if (!directed) graph[e.v2]!!.neighbours[graph[e.v1]!!] = e.dist
        }
    }

    fun dijkstra(start: Int) {
        val source = graph[start]
        val q = TreeSet<Vertex>()

        for (v in graph.values) {
            v.previous = if (v == source) source else null
            v.dist = if (v == source) 0 else Int.MAX_VALUE
            q.add(v)
        }

        dijkstra(q)
    }

    private fun dijkstra(q: TreeSet<Vertex>) {
        while (!q.isEmpty()) {
            val u = q.pollFirst()
            if (u.dist == Int.MAX_VALUE) break

            for (a in u.neighbours) {
                val v = a.key

                val alternateDist = u.dist + a.value
                if (alternateDist < v.dist) {
                    q.remove(v)
                    v.dist = alternateDist
                    v.previous = u
                    q.add(v)
                }
            }
        }
    }

    fun printPath(end: Int):Int {

        return graph[end]!!.printPath()

    }

    private fun printAllPaths() {
        for (v in graph.values) {
            v.printPath()
            println()
        }
        println()
    }
}