package com.example.codymerebirth_hospitalsearcher

class Vertex (val name: Int) : Comparable<Vertex> {

    var dist = Int.MAX_VALUE
    var previous: Vertex? = null
    val neighbours = HashMap<Vertex, Int>()


    fun printPath():Int {

        var totalDist:Int = 0
        if (this == previous) {
            return 0
        }
        else if (previous == null) {
            return 100000
        }
        else {

            totalDist+=previous!!.printPath()
            totalDist+=dist

        }

        return totalDist
    }

    override fun compareTo(other: Vertex): Int {
        if (dist == other.dist) return name.compareTo(other.name)
        return dist.compareTo(other.dist)
    }

    override fun toString() = "($name, $dist)"
}