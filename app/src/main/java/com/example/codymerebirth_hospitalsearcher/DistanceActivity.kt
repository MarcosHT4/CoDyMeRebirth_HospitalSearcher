package com.example.codymerebirth_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codymerebirth_hospitalsearcher.databinding.ActivityDistanceBinding
import com.google.android.gms.common.api.Api
import com.google.android.gms.maps.model.LatLng

class DistanceActivity : AppCompatActivity() {

    private lateinit var distanceBinding: ActivityDistanceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        distanceBinding = ActivityDistanceBinding.inflate(layoutInflater)
        setContentView(distanceBinding.root)

        val continente = intent.getIntExtra("continent", 0)
        val startPoint = intent.getIntExtra("startPoint", 0)
        val finishPoint = intent.getIntExtra("finishPoint", 0)


        distanceBinding.verMapaButton.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            // TODO se debe enviar una lista con los hospitales que conforman el camino
            //intent.putExtra(path: List<Hospital>)
            startActivity(intent)
        }
        //Aqui va el dijstra o el brow-warshal xd
        //upgradePath(latamHospitals[startPoint]!!, latamHospitals[finishPoint]!!, Distancia obtenida con dijkstra )
    }


    fun upgradePath(origen: Hospital, destino: Hospital, distancia: Int){
        distanceBinding.origen.text = origen.name
        distanceBinding.destino.text = destino.name
        distanceBinding.distanciaMinima.text = distancia.toString()
    }
    fun createDistances(continente: Int){
        when(continente){
            1 -> {
                addEdge(9, 8, 1400)
                addEdge(8,7,1103)
                addEdge(7, 6, 1802)
                addEdge(6, 0, 2033)
                addEdge(0, 1, 1427)
                addEdge(1, 2, 1344)
                addEdge(6, 5, 3286)
                addEdge(5, 4, 1407)
                addEdge(4, 2, 593)
                addEdge(2, 3, 2903)
                addEdge(3, 10, 2755)
                addEdge(10, 11, 444)
                addEdge(11, 12, 336)
            } 2 -> {
                addEdge(0,1,1090)
                addEdge(1,2,978)
                addEdge(1,3,484)
                addEdge(3,4,959)
                addEdge(4,5,550)
                addEdge(5,6,572)
                addEdge(5,7,688)
                addEdge(5,8,662)
                addEdge(4,9,526)
                addEdge(9,10,1847)
                addEdge(9,12,472)
                addEdge(9,11,1848)
                addEdge(10,13,1469)
                addEdge(10,11,2964)
                addEdge(11,12,1854)
                addEdge(11,14,276)
                addEdge(14,15,1398)
            } 3 -> {
                addEdge(11, 10, 464)
                addEdge(0,1, 623)
                addEdge(1,9, 609)
                addEdge(1,2, 1271)
                addEdge(2, 7, 1420)
                addEdge(2, 3, 582)
                addEdge(3,4,  839)
                addEdge(2, 8, 373)
                addEdge(2, 5, 313)
                addEdge(5, 6, 210)
            }
        }
    }

    fun addEdge(origen: Int, destino: Int, distancia: Int){
        latamGrafo[origen][destino] = distancia
        latamGrafo[destino][origen] = distancia
    }
}


//Latinoamerica

val hospitalSucre = Hospital("Hospital Santa Barbara", 0, LatLng(-19.044638688080493, -65.26289977359298))
val hospitalCaracas = Hospital("Hospital de Clinicas Caracas", 9, LatLng(10.510392244048777, -66.89886880000002))
val hospitalBuenosAires = Hospital("Hospital Italiano de Buenos Aires", 4, LatLng(-34.60615526599895, -58.42587738679744))
val hospitalBogota = Hospital("Hospital Universitario Nacional de Colombia", 8, LatLng(4.648851154530483, -74.0958786891307))
val hospitalQuito = Hospital("Hospital Vozandes Quito", 7, LatLng(-0.17266468170644111, -78.48944501611999))
val hospitalLima = Hospital("Hospital Nacional Arzobispo Loayza", 6, LatLng(-12.049894835206626, -77.04329160256935))
val hospitalAsuncion = Hospital("Hospital Universitario Ntra. Sra. de Asunción", 1, LatLng(-25.29245087720329, -57.56199163305948))
val hospitalSantiago = Hospital("Hospital Dr. Luis Tisné Brousse", 5, LatLng(-33.50062824284426, -70.57905180031733))
val hospitalMontevideo = Hospital("Hospital Británico de Montevideo", 2, LatLng(-34.894289082319425, -56.16285437329951))
val hospitalBrasilia = Hospital("Hospital Alvorada Brasilia", 3, LatLng(-15.813129246960239, -47.91250150252596))
val hospitalGeorgetown = Hospital("Georgetown Public Hospital Corporation", 10, LatLng(6.815718116762575, -58.157052933055304))
val hospitalParamaribo = Hospital("Academic Hospital Paramaribo", 11, LatLng(5.836922274316439, -55.18308396028875))
val hospitalCayena = Hospital("Centro Hospitalario Andrée-Rosemon", 12, LatLng(4.923919567336988, -52.320488600763234))

//Europa del este


val hospitalMoscu = Hospital("Hospital clinico central", 0, LatLng(55.75007428923332, 37.38975771534646))
val hospitalHelsinki = Hospital("Surgical Hospital", 1, LatLng(60.16161953320194, 24.948867722771716))
val hospitalOslo = Hospital("Hôpital national norvégien", 2, LatLng(59.95579743610828, 10.701196370278698))
val hospitalEstocolmo = Hospital("Hospital de San Göran", 3, LatLng(59.48086427743339, 18.059729196907757))
val hospitalMinsk = Hospital("National Hospital of Belarus' Interior Ministry", 4, LatLng(54.64466763858227, 27.5106429809813))
val hospitalVarsovia = Hospital("American Clinic Warsaw", 5, LatLng(52.15515540391875, 21.077973725722103))
val hospitalBerlin = Hospital("Alexianer St. Hedwig Hospital", 6, LatLng(52.871787371307256, 13.340160586250244))
val hospitalPraga = Hospital("General University Hospital in Prague", 7, LatLng(50.07333581333177, 14.420886253960607))
val hospitalBratislava = Hospital("Hospital Bratislava Ružinov", 8, LatLng(48.47581700294231, 17.1605481190893))
val hospitalKiev = Hospital("Kyiv City Clinical Hospital", 9, LatLng(50.970627878721245, 30.41443955096359))
val hospitalBudapest = Hospital("Szent Gellért Magánklinika Budapest", 10, LatLng(47.707550253211785, 18.613309288842167))
val hospitalTiflis = Hospital("German Hospital", 11, LatLng(41.84625652975446, 44.473796144840954))
val hospitalChisinau = Hospital("Medpark International Hospital", 12, LatLng(46.861595502936744, 28.914024252787808))
val hospitalAtenas = Hospital("Koutanitis, Nik. B., Galinos Polyiatreia S.A.", 13, LatLng(37.96059088783629, 23.737585169307067))
val hospitalErevan = Hospital("Heratsi Hospital Complex", 14, LatLng(40.48659368546972, 44.008989670419645))
val hospitalAnkara = Hospital("Memorial Ankara Hastanesi", 15, LatLng(40.077413596198284, 31.826482715130485))


//Europa del Oeste


val hospitalLisboa = Hospital("Centro Hospitalar Universitário de Lisboa Central - Hospital de São José", 0, LatLng(40.20806468626688, -9.19344756180251))
val hospitalMadrid = Hospital("Hospital de La Princesa", 1, LatLng(41.13111378757351, -3.7657087665523745))
val hospitalParis = Hospital("Lariboisière Hospital AP-HP", 2, LatLng(49.0242468937122, 2.236030216820476))
val hospitalBerna = Hospital("Inselspital", 3, LatLng(46.94756056987751, 7.424605553960608))
val hospitalViena = Hospital("Hospital general de Viena", 4, LatLng(50.65914784863094, 14.827293706081425))
val hospitalBruselas = Hospital("Instituto Jules Bordet", 5, LatLng(50.833507672949644, 4.347087325361968))
val hospitalAmsterdam = Hospital("OLVG, location Spuistraat", 6, LatLng(52.37118763534204, 4.889372025419725))
val hospitalRoma = Hospital("Rome American Hospital", 7, LatLng(41.90003220640084, 12.602381055745447))
val hospitalLuxemburgo = Hospital("Hospital materno Gran Duquesa Charlotte", 8, LatLng(49.617597294338694, 6.098589640663677))
val hospitalAndorraLaBella = Hospital("Nostra Senyora de Meritxell Hospital", 9, LatLng(42.51145937049988, 1.5336092980918983))
val hospitalLondres = Hospital("Royal London Hospital", 10, LatLng(51.517508455928564, -0.06000350159278706))
val hospitalDublin = Hospital("Hospital materno nacional de Dublín", 11, LatLng(53.33990050330571, -6.245567788033456))


val latamHospitals: HashMap<Int, Hospital> = hashMapOf(
    0 to hospitalSucre,
    1 to hospitalAsuncion,
    2 to hospitalMontevideo,
    3 to hospitalBrasilia,
    4 to hospitalBuenosAires,
    5 to hospitalSantiago,
    6 to hospitalLima,
    7 to hospitalQuito,
    8 to hospitalBogota,
    9 to hospitalCaracas,
    10 to hospitalGeorgetown,
    11 to hospitalParamaribo,
    12 to hospitalCayena
)
val latamGrafo = Array(20){ IntArray(20) { 0 } }