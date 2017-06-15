# Spark SQL DBF Library

A library for querying [DBF](http://www.digitalpreservation.gov/formats/fdd/fdd000325.shtml) data with [Spark SQL](http://spark.apache.org/docs/latest/sql-programming-guide.html).

*This is work in progress* and is based on the [spark-avro](https://github.com/databricks/spark-avro) project.
The "Ye Olde" DBF file format encapsulates data and schema just like the modern Avro format. So it was natural and
quick to mutate the avro project and adapt it to our trusty and ubiquitous dbf format.

## Requirements
This library requires Spark 1.3+ and depends on the [Shapefile](https://github.com/punit-naik/Shapefile) github project.

## Building
Typically, [SBT](http://www.scala-sbt.org/) is used to build Scala based projects, but, I'm using [Maven](http://maven.apache.org/) to build this one.
The pom.xml has plugins to compile scala and java sources.

Make sure to first clone and install the [Shapefile](https://github.com/punit-naik/Shapefile) project, then

```
$ mvn clean install -Dspark.version=1.3.1 assembly:single
```

## Linking
You can link against this library in your program at the following coordinates:

```
groupId: com.esri
artifactId: spark-dbf
version: 1.0
```

The spark-dbf jar file can also be added to a Spark using the `--jars` command line option.
For example, to include it when starting the spark shell:

```
$ bin/spark-shell --jars spark-dbf-1.0-with-dependencies.jar
```

## Examples

You can download the sample dbf from [here](https://github.com/infused/dbf/blob/master/spec/fixtures/cp1251.dbf)


```
$ wget https://github.com/infused/dbf/blob/master/spec/fixtures/cp1251.dbf
```

### Scala API

```scala
import com.esri.spark.dbf._
val testDBF = sqlContext.dbfFile("cp1251.dbf")
testDBF.rdd.collect

```

### Python and SQL API
DBF data can be queried in pure SQL or from python by registering the data as a temporary table.


```sql
CREATE TEMPORARY TABLE trips
USING com.esri.spark.dbf
OPTIONS (path "cp1251.dbf")
```

### Java API
DBF files can be read using static functions in DBFUtils.


```java
import com.esri.spark.dbf.DBFUtils;

DataFrame trips = DBFUtils.dbfFile(sqlContext, "cp1251.dbf");
```

## Sample spark shell session with simple geometry UDF

This sample uses our [Geometry API](https://github.com/Esri/geometry-api-java) to define a UDF that calculates the
distance in meters between two lat/lon pairs.

```shell
$ ./spark-dbf.sh
```

```scala
import com.esri.core.geometry.{GeometryEngine, Point}
import com.esri.spark.dbf._
val cp1251 = sqlContext.dbfFile("sp1251.dbf").registerTempTable("cp1251")
sqlContext.sql("select * from cp1251").foreach(println)
```
