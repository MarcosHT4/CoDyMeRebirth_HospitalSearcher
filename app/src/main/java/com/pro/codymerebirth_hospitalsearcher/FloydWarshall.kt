package com.pro.codymerebirth_hospitalsearcher



object FloydWarshall {

    lateinit var dist: Array<IntArray>
    lateinit var next: Array<IntArray>



    fun doCalcs(weights:Array<IntArray>, nVertices:Int, startPoint:Int, finishPoint:Int): Int{

        dist = Array(nVertices) {

            IntArray(nVertices) {

                1000000

            }
        }



        for(i in 0..weights.size-1) {

            for (j in 0..weights.get(i).size - 1) {

                if (weights[i][j] != 0) {

                    dist[i][j] = weights[i][j]

                }
            }
        }

        for(i in 0..weights.size-1) {

            for(j in 0..weights.get(i).size - 1) {

                if(weights[i][j]!=0) {

                    dist[i][j] = weights[i][j]

                }

            }

        }

        next = Array(nVertices) {
            IntArray(nVertices)
        }
        for(i in 0 until next.size) {
            for(j in 0 until next.size) {
                if(i!=j) {
                    next[i][j] = j
                }
            }
        }

        for(k in 0 until nVertices) {

            for(i in 0 until nVertices) {

                for(j in 0 until nVertices) {

                    if(dist[i][k]+ dist[k][j]< dist[i][j] ) {

                        dist[i][j] = dist[i][k] + dist[k][j]
                        next[i][j] = next[i][k]

                    }

                }

            }

        }

        return dist[startPoint][finishPoint]
    }

    fun printResult(startPoint:Int, finishPoint: Int): ArrayList<Int> {

        var u: Int
        val v: Int
        //var path: String
        val listHospitals:ArrayList<Int> = ArrayList()


        u = startPoint
        v = finishPoint

        do {
            listHospitals.add(u)
            u = next[u][v]


        } while (u != v)

        listHospitals.add(v)

        return listHospitals
    }


}