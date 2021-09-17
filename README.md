# Proyecto Final Algorítmica II (CoDyMeRebirth_HospitalSearcher-Dijkstra-FloydWarshall)

## Integrantes del grupo:

- Dylan Chambi Frontanilla
- Camila Alejandra Grandy Camacho
- Joseph Anthony Meneses Salguero
- Marcos Andres Simon Agreda

## Requisitos de Software:

- Windows 8-8.1-10 x64/ Mac OS X 10.8- 10.9- 10.10- 10.11- 10.12 - 10.13- 10.14 / Linux desde 4.19
- Lenguaje de programación Kotlin 1.5.30
- Lenguaje de programación Java JDK 13.0  
- Android Studio 2020.3.1
- Emulador de software Android (Opcional)
- Versión de Android superior a 7.0 (Nougat)
- Google Maps instalado en emulador


## Instalación:

- Descargar e instalar [WinRar](https://www.winrar.es/descargas).
- Descargar la última versión disponible de [Android Studio](https://developer.android.com/studio).
- Seguir las instrucciones de instalación que proporciona el instalador de Android Studio.
- La última versión de Android Studio instalará automáticamente el lenguaje de programación Kotlin.  
- Descargar la versión 13.0 del JDK de [Java](https://www.oracle.com/java/technologies/javase/jdk13-archive-downloads.html)
- Seguir las instrucciones de instalación del paquete que contiene el JDK de Java Recuerde la ruta de instalación.
- Dirigirse a **Panel de control\Sistema y seguridad\Sistema** y apretar en el botón **Configuración avanzada del sistema**.
- En la sección de **Opciones avanzadas**, hacer click en **Variables de entorno**.
- En la parte de **Variables del sistema**, seleccionar la opción **Path**, y hacer click en **Editar**.
- Presionar el botón **Nuevo** e indique la ruta de instalación del JDK, y haga click en **Aceptar**.
- Descargue el contenido del presente repositorio.
- Descomprima el archivo .zip utilizando WinRar
- Coloque los archivos en una carpeta deseada.
- Abra Android Studio.
- En la parte superior, hacer click en **Archivo** y en **Importar Proyecto**
- Seleccione la carpeta que contenga los archivos
- Seleccione en la parte superior, su emulador de Android (o teléfono móvil).
- Haga click en el botón de **Correr Aplicación**.

## Explicación de los Algoritmos

El algoritmo de Dijkstra, es un conocido algoritmo, el cual permite encontrar las distancias más cortas entre los vértices de un grafo.
Su funcionamiento se basa, en que, a partir de un vértice inicial, el algoritmo viajará a través de los vértices del grafo, hasta haber visitado todo el grafo.
Cabe destacar que el algoritmo de Dijkstra solo funciona con pesos positivos en las aristas.
Los pasos que sigue el algoritmo de Dijkstra, son los siguientes:

- Declarar tres estructuras: Una cola de prioridad, un areglo que guarde las distancias entre vértices, y un arreglo que guarde si los vértices ya han sido visitados.
- En el arreglo de **visitados** marcar todas las casillas correspondientes a los vértices con infinito (un entero muy grande).
- En el arreglo de **visitados** marcar la distancia del vértice inical con 0.
- Visitar a los vecinos del vértice actual
- Calcular la distancia del vértice vecino
- Verificar si la distancia es mínima, si es así, guardar la nueva distancia.
- Repetir los pasos anteriores hasta haber visitado todos los vértices.

Por otro lado, el algoritmo de Floyd-Warshall también es un algoritmo que nos ayuda a encontrar un camino con la distancia mínima en un grafo (direccionado o no direccionado), este algoritmo tiene una complejidad de O(n^3) lo cual lo hace más lento encontrando caminos que dijkstra, pero a su vez este algoritmo tiene la posibilidad de usar distancias negativas a diferencia del dijkstra.
Los pasos que sigue el algoritmo de Floyd-Warshall:

- Declaramos 2 estructuras, una matriz donde se guardan los pesos o distancias con sus respectivos vértices y una matriz de siguientes donde se guardan los caminos hacia cierto vértice.
- Llenamos la matriz de pesos o distancias con las respectivas distancias, si no hay camino de un vértice a otro se debe poner infinito. Guardamos en la matriz de siguientes el mismo número del respectivo vértice.
- En este caso los vértices de inicio y fin no son necesarios ya que el algoritmo encuentra el mínimo para todos los vértices desde cualquier inicio.
- Con un triple for donde visitamos toda la matriz con la ayuda de un pivote que nos ayuda a ver si por otro camino la distancia es menor a la actual.
- Si la distancia es menor, entonces guardamos la distancia en la matriz de distancias y también guardamos el vértice por donde pasó el pivote.
- Para saber la distancia mínima entre dos vértices, solo hace falta introducir el número de los vértices y la distancia mínima estaría en la posición de la matriz de los respectivos vértices.


En el presente proyecto, se implementó estos grandes algoritmos, para poder obtener las distancias mínimas entre las diferentes capitales de tres diferentes continentes,
las cuales contienen sucursales de hospitales. Los algoritmos viajará a través de todas las conexiones existentes entre las distintas sucursales, a partir de un punto
de inicio; y al finalizar, los algoritmos devolverán la distancia mínima entre las sucursales especificadas.

Además de ésto, gracias a una API de Google Maps, y a una modificación de los algoritmos antes mencionados, se puede obtener una vista satelital completamente real
de las ubicaciones de los hospitales de inicio, final, y los demás hospitales que se encuentran en el trayecto. También, el API proporcionará una unión entre todos los 
hospitales que se encuentran en el trayecto.




