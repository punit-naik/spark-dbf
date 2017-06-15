name := "spark-dbf"

version := "1.0"

organization := "com.esri"

scalaVersion := "2.10.4"

resolvers += "Local Maven Repository" at "file:///"+Path.userHome+"/.m2/repository"

libraryDependencies += "com.esri" % "Shapefile" % "1.4.2"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.3.1" % "provided"

libraryDependencies += "org.apache.avro" % "avro" % "1.7.7" exclude("org.mortbay.jetty", "servlet-api")

libraryDependencies += "org.apache.avro" % "avro-mapred" % "1.7.7" exclude("org.mortbay.jetty", "servlet-api")

publishMavenStyle := true

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test"

libraryDependencies += "junit" % "junit" % "4.12" % "test"
