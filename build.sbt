name := """play3-scala3-seed"""
organization := "com.example"
version := "1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.5.1"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    PlayKeys.playDefaultPort := 8888,
    libraryDependencies ++= AppDependencies.appDependencies
  )

excludeDependencies ++= Seq(
  "org.typelevel"          % "cats-kernel_2.13",
  "org.typelevel"          % "cats-core_2.13",
  "org.scala-lang.modules" % "scala-parser-combinators_2.13"
)

resolvers ++= Resolver.sonatypeOssRepos("public") ++ Seq(
  Resolver.jcenterRepo,
  Resolver.typesafeRepo("releases"),
  Resolver.typesafeIvyRepo("releases"),
  MavenRepository("HMRC-open-artefacts-maven2", "https://open.artefacts.tax.service.gov.uk/maven2"),
  Resolver.url("HMRC-open-artefacts-ivy2", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(Resolver.ivyStylePatterns)
)

addCommandAlias("precommit", "clean;coverage;test;coverageOff;coverageReport;package")

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
