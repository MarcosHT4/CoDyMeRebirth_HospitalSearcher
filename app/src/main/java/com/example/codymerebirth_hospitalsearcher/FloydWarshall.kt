package com.example.codymerebirth_hospitalsearcher

object FloydWarshall {

    fun doCalcs(weights:Array<IntArray>, nVertices:Int, startPoint:Int, finishPoint:Int): Int{

        val dist = Array(nVertices) {

            IntArray(nVertices) {

                1000000

            }

        }

        for(i in 0..weights.size-1) {

            for(j in 0..weights.get(i).size - 1) {

                if(weights[i][j]!=0) {

                    dist[i][j] = weights[i][j]

                }

            }

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

                    if(dist[i][k]+dist[k][j]<dist[i][j] ) {

                        dist[i][j] = dist[i][k] + dist[k][j]
                        next[i][j] = next[i][k]

                    }

                }

            }

        }
        var minDist:Int = printResult(dist, next, startPoint, finishPoint)
        return minDist
    }

    private fun printResult(dist: Array<IntArray>, next: Array<IntArray>, startPoint: Int, finishPoint: Int): Int {

        var u: Int
        var v: Int
        var path: String
        println("pair     dist    path")
        for (i in 0 until next.size) {

            for (j in 0 until next.size) {

                if (i != j) {

                    u = i
                    v = j
                    if (u == startPoint && v == finishPoint) {
                        return dist[i][j]
                    }
                }
            }
        }
        return 0
    }
}