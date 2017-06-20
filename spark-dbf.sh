#!/bin/bash

export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=128m"
dest=target

echo "Building spark-dbf project..."

mvn clean install -Dspark.version=1.5.2 assembly:single
$SPARK_HOME/bin/spark-shell --jars ${dest}/spark-dbf-1.0-jar-with-dependencies.jar
