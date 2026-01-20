import play.core.PlayVersion
import play.sbt.PlayImport.{guice, ws}
import sbt.*

object AppDependencies {

  private val catsEffectVersion         = "3.6.3"
  private val apachePOIVersion          = "5.5.1"
  private val pdfBoxVersion             = "3.0.6"
  private val pdfItext5Version          = "9.7.2"
  private val uniformVersion            = "4.10.0"
  private val jacksonModuleScalaVersion = "2.20.2"
  private val notifyClientVersion       = "6.0.0-RELEASE"
  private val bootstrapVersion          = "9.1.0"
  private val playFrontendVersion       = "10.5.0"
  private val mongoVersion              = "2.2.0"
  private val playLanguageVersion       = "8.0.0"
  private val cryptoJsonVersion         = "8.0.0"

  // Test dependencies
  private val scalaTestPlusPlayVersion       = "7.0.2"
  private val scalatestVersion               = "3.2.19"
  private val scalatestPlusScalacheckVersion = "3.2.19.0"
  private val scalaTestPlusMockitoVersion    = "3.2.19.0"
  private val flexMarkVersion                = "0.64.8"
  private val wiremockVersion                = "3.13.2"

  private val compileDependencies = Seq(
    guice,
    ws,
    "org.typelevel"                %% "cats-effect"                % catsEffectVersion,
    "com.fasterxml.jackson.module" %% "jackson-module-scala"       % jacksonModuleScalaVersion,
    "org.apache.poi"                % "poi"                        % apachePOIVersion,
    "org.apache.pdfbox"             % "pdfbox"                     % pdfBoxVersion,
    "org.xhtmlrenderer"             % "flying-saucer-pdf-itext5"   % pdfItext5Version,
    "com.luketebbs.uniform"        %% "interpreter-play28"         % uniformVersion cross CrossVersion.for3Use2_13,
    // GOV.UK Notify service https://www.notifications.service.gov.uk
    "uk.gov.service.notify"         % "notifications-java-client"  % notifyClientVersion,
    // HMRC public artefacts
    "uk.gov.hmrc"                  %% "bootstrap-frontend-play-30" % bootstrapVersion,
    "uk.gov.hmrc"                  %% "play-frontend-hmrc-play-30" % playFrontendVersion,
    "uk.gov.hmrc.mongo"            %% "hmrc-mongo-play-30"         % mongoVersion,
    "uk.gov.hmrc"                  %% "play-language-play-30"      % playLanguageVersion,
    "uk.gov.hmrc"                  %% "crypto-json-play-30"        % cryptoJsonVersion
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
