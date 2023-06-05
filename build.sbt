name := "ScalaHassInterface"

version := "0.1"

scalaVersion := "2.13.10"

resolvers += Resolver.mavenLocal

libraryDependencies += "com.github.andyglow" %% "websocket-scala-client" % "0.4.0" % Compile
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.4"
libraryDependencies += "com.lihaoyi" %% "sourcecode" % "0.3.0"
libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.32.0"

libraryDependencies += "org.scala-lang.modules" %% "scala-java8-compat" % "1.0.2"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.15"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"
libraryDependencies += "org.scalatest" %% "scalatest-funsuite" % "3.2.15" % "test"

libraryDependencies += "org.scalaz" %% "scalaz-concurrent" % "7.2.35"
