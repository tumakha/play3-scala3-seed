resolvers ++= Seq(
  Resolver.sbtPluginRepo("releases"),
  Resolver.typesafeIvyRepo("releases")
)

addSbtPlugin("org.playframework"  % "sbt-plugin"      % "3.0.5")
addSbtPlugin("org.scoverage"      % "sbt-scoverage"   % "2.2.0")
addSbtPlugin("org.scalameta"      % "sbt-scalafmt"    % "2.5.2")
addSbtPlugin("ch.epfl.scala"      % "sbt-scalafix"    % "0.12.1")
addSbtPlugin("org.wartremover"    % "sbt-wartremover" % "3.2.1")
addSbtPlugin("io.github.irundaia" % "sbt-sassify"     % "1.5.2")
addSbtPlugin("com.github.sbt"     % "sbt-digest"      % "2.0.0")
addSbtPlugin("com.github.sbt"     % "sbt-concat"      % "1.0.0")
