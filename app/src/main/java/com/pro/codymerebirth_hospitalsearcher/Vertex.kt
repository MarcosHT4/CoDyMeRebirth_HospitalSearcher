package com.pro.codymerebirth_hospitalsearcher

class Vertex (val name: Int) : Comparable<Vertex> {

    var dist = Int.MAX_VALUE
    var previous: Vertex? = null
    val neighbours = HashMap<Vertex, Int>()


    fun pathVertex():ArrayList<Int> {
        var vertices = ArrayList<Int>()

        if (this == previous) {
            vertices.add(this.name)
        }
        else if (previous == null) {
            return ArrayList()
        }
        else {
            vertices = previous!!.pathVertex()
            vertices.add(name)
        }
        return vertices
    }

    fun distanciaAVertice(): Int{
        return dist
    }

    override fun compareTo(other: Vertex): Int {
        if (dist == other.dist) return name.compareTo(other.name)
        return dist.compareTo(other.dist)
    }

    override fun toString() = "($name, $dist)"
}