import play.core.PlayVersion
import play.sbt.PlayImport.{guice, ws}
import sbt.*

object AppDependencies {

  private val jacksonModuleScalaVersion = "2.17.2"

  // Test dependencies
  private val scalaTestPlusPlayVersion       = "7.0.1"
  private val scalatestVersion               = "3.2.19"
  private val scalatestPlusScalacheckVersion = "3.2.19.0"
  private val scalaTestPlusMockitoVersion    = "3.2.19.0"
  private val flexMarkVersion                = "0.64.8"
  private val wiremockVersion                = "3.8.0"

  private val compileDependencies = Seq(
    guice,
    ws,
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonModuleScalaVersion
  )

  private val testDependencies = Seq(
    "org.playframework"      %% "play-test"          % PlayVersion.current            % Test,
    "org.apache.pekko"       %% "pekko-testkit"      % PlayVersion.pekkoVersion       % Test,
    "org.scalatestplus.play" %% "scalatestplus-play" % scalaTestPlusPlayVersion       % Test,
    "org.scalatest"          %% "scalatest"          % scalatestVersion               % Test,
    "org.scalatestplus"      %% "scalacheck-1-18"    % scalatestPlusScalacheckVersion % Test,
    "org.scalatestplus"      %% "mockito-5-12"       % scalaTestPlusMockitoVersion    % Test,
    "com.vladsch.flexmark"    % "flexmark-all"       % flexMarkVersion                % Test, // for scalatest 3.2.x,
    "org.wiremock"            % "wiremock"           % wiremockVersion                % Test
  )

  val appDependencies: Seq[ModuleID] = compileDependencies ++ testDependencies

}
