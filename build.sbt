name := """play3-scala3-seed"""
organization := "com.example"
version := "1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.2"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    PlayKeys.playDefaultPort := 8888,
    libraryDependencies ++= AppDependencies.appDependencies
  )

addCommandAlias("precommit", "clean;coverage;test;coverageOff;coverageReport;package")

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
