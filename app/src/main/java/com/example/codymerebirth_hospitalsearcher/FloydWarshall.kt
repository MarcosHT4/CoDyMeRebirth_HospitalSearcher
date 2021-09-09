package com.example.codymerebirth_hospitalsearcher

object FloydWarshall {

    fun doCalcs(weights:Array<IntArray>, nVertices:Int, startPoint:Int, finishPoint:Int): Double {

        val dist = Array(nVertices) {

            DoubleArray(nVertices) {

                Double.POSITIVE_INFINITY

            }

        }

        for(w in weights) {

            dist[w[0]-1][w[1]-1] = w[2].toDouble()
        }
        val next = Array(nVertices) {
            IntArray(nVertices)
        }
        for(i in 0 until next.size) {
            for(j in 0 until next.size) {
                if(i!=j) {
                    next[i][j] = j+1
                }
            }
        }

        for(k in 0 until nVertices) {

            for(i in 0 until nVertices) {

                for(j in 0 until nVertices) {

                    if(dist[i][k]+dist[k][j]<dist[i][j]) {

                        dist[i][j] = dist[i][k] + dist[k][j]
                        next[i][j] = next[i][k]

                    }

                }

            }

        }
        var minDist:Double = printResult(dist, next, startPoint, finishPoint)
        return minDist
    }

    private fun printResult(dist: Array<DoubleArray>, next: Array<IntArray>, startPoint: Int, finishPoint: Int): Double {

        var u: Int
        var v: Int
        var path: String
        println("pair     dist    path")
        for (i in 0 until next.size) {

            for (j in 0 until next.size) {

                if (i != j) {

                    u = i + 1
                    v = j + 1
                    if (u == startPoint && v == finishPoint) {
                        return dist[i][j]
                    }
                }
            }
        }
        return 0.0
    }
}