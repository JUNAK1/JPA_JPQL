# JPA_JPQL

El gerente de la fábrica de muebles MosKea ha decidido utilizar un sistema de Base de Datos para representar la estructura de los muebles que distribuye.
Teniendo en cuenta que: Los muebles están representados por un nombre y un identiﬁcador único. También se quiere conocer su precio. Todo mueble está formado por una o más piezas. Cada pieza tiene un identiﬁcador único y puede formar parte de varios muebles. Todas las
unidades de una pieza se encuentran en uno solo estante del almacén. El estante esta ubicado en un pasillo. El modelo de base de datos planteado para dar solución a la necesidad es el siguiente:
 
![](https://raw.githubusercontent.com/JUNAK1/JPA_JPQL/master/Captura.PNG)
1.	Crear el esquema de base de datos en el motor de su preferencia (Oracle, MySQL).
2.	Realizar el mapeo objeto relacional de dicha base de datos en un proyecto JAVA usando la estrategia de generación de llaves adecuada.
3.	Crear un método que inserte en la base de datos con por lo menos 5 registros en cada tabla.
4.	Crear un método que permita consultar cuales piezas se deben usar para crear un determinado mueble.
5.	Crear un método que permita consultar en cuales estantes se debe buscar para crear un determinado mueble.
6.	Crear un método que permita consultar los muebles de una categoría dada.
