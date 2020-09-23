name := "SimpleAkka"

version := "0.1"

scalaVersion := "2.13.3"
val akkaVersion = "2.6.8"
val kafkaVersion = "2.6.0"


libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "org.apache.kafka" %% "kafka" % kafkaVersion
)