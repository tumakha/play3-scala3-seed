name := """play3-scala3-seed"""
organization := "com.example"
version := "1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.10.0"

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

given Patterns = Resolver.ivyStylePatterns

resolvers ++= Seq(
  Resolver.sonatypeCentralSnapshots,
  Resolver.jcenterRepo,
  Resolver.typesafeRepo("releases"),
  Resolver.typesafeIvyRepo("releases"),
  "hmrc-releases" at "https://artefacts.tax.service.gov.uk/artifactory/hmrc-releases/",
  "third-party-maven-releases" at "https://artefacts.tax.service.gov.uk/artifactory/third-party-maven-releases/",
  Resolver.uri("third-party-ivy-releases", java.net.URI("https://artefacts.tax.service.gov.uk/artifactory/third-party-ivy-releases")),
  "HMRC-open-artefacts-maven2" at "https://open.artefacts.tax.service.gov.uk/maven2",
  Resolver.uri("HMRC-open-artefacts-ivy2", java.net.URI("https://open.artefacts.tax.service.gov.uk/ivy2"))
)

addCommandAlias("precommit", "clean;coverage;test;coverageOff;coverageReport;package")
addCommandAlias("testCoverage", "clean;coverage;test;coverageOff;coverageReport;coverageAggregate;package")

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
