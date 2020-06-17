name := "SparkDataAnalytics"

version := "0.1"

scalaVersion := "2.11.8"

val sparkVersion = "2.4.4"

libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided" withSources()
libraryDependencies += "org.apache.spark" %% "spark-hive" % sparkVersion % "provided" withSources()
libraryDependencies += "com.typesafe" % "config" % "1.4.0"//Used to read application.conf

libraryDependencies += "com.github.wookietreiber" %% "scala-chart" % "latest.integration"
libraryDependencies += "com.itextpdf" % "itextpdf" % "5.5.6"
