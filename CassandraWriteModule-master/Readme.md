
#### Reglas de Mapeo
##### Basados en los DMP (Data Modeling Principles)

Keyspace : Es un Objeto que mantiene unidas a todas las familias de columnas de un diseño. Schema en una db relacional. 

1. Los tipos de entidades y relaciones mapean a tablas mientras que los datos se asignan a filas. Los atributos de las entidades y las relaciones se mapean a columnas.
2. Si se utilizan en una consulta por igualdad de atributos, entonces, éstos forman la clave primaria y tales columnas se incluirán en las particiones por clave.
3. Si se utilizan en consultas por desigualdad, estos atributos mapean como columnas dinámicas, conteniendo los valores.
4. Mapea a columna dinámica con orden ascendente o descendente según se especifique en la consulta.
5. Mapea a clave primaria. Una tabla que almacena datos de entidades o relaciones como filas debe incluir atributos claves que identifique estos datos unívocamente.

* Entidades y relaciones mapean a tablas	
* Atributos de búsqueda por igualdad se convierten en partition key 
* Atributos de inecuación se convierten Clustering columns
* Atributos de ordenamiento se incluyen en Clustering column con orden adecuado
* Atributos clave de entidades se convierten en Clustering column para garantizar unicidad (*)

 

``` sql
CREATE TABLE latencia_por_dispositivo (
nombre text,
id int,
dominio text,
fecha timestamp,
valor double, 
PRIMARY KEY ((id, dominio), fecha )
) WITH CLUSTERING ORDER BY fecha ASC, )
```

