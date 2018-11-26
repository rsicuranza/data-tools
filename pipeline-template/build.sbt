name := "pipeline-template"

version := "0.1"

scalaVersion := "2.11.8"
val sparkVersion = "2.3.0"

resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.4",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test",
  "com.typesafe" % "config" % "1.3.2",
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "com.github.scopt" %% "scopt" % "3.7.0",
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
//  "com.github.mrpowers" % "spark-daria" % "v2.1.0_0.24.0",
//  "com.github.mrpowers" % "spark-fast-tests" % "v2.3.0_0.12.0" % "test",
  "mysql" % "mysql-connector-java" % "5.1.6",
  "org.scalaz" %% "scalaz-core" % "7.2.27"
)

assembly / assemblyOption := (assembly / assemblyOption).value
  .copy(includeScala = false)
