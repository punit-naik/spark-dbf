#!/bin/sh
dest=target
mvn clean install -Dspark.version=1.3.1 assembly:single
$SPARK_HOME/bin/spark-shell --jars ${dest}/spark-dbf-1.0-jar-with-dependencies.jar
