name := "pio-core"

libraryDependencies ++= Seq(
  "com.twitter"       %% "chill"          % "0.3.6",
  "com.typesafe"       % "config"         % "1.2.1",
  "com.typesafe.akka" %% "akka-contrib"   % "2.3.2",
  "com.typesafe.akka" %% "akka-testkit"   % "2.3.2",
  "org.clapper"       %% "grizzled-slf4j" % "1.0.2",
  "org.mongodb"       %% "casbah"         % "2.7.2",
  "org.scalatest"     %% "scalatest"      % "2.1.6" % "test")

scalacOptions <<= (scalacOptions, scalaSource in Compile) map { (options, base) =>
  options :+ ("-P:sxr:base-directory:" + base.getAbsolutePath)
}

resolvers += Resolver.url(
  "Typesafe Releases",
  url("http://repo.typesafe.com/typesafe/ivy-releases"))(
    Resolver.ivyStylePatterns)

addCompilerPlugin("org.scala-sbt.sxr" %% "sxr" % "0.3.0")