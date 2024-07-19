import play.sbt.routes.RoutesKeys.routes
import sbt.Keys.compile
import sbt.{AutoPlugin, Compile, Setting, Test}
import wartremover.WartRemover.autoImport.{wartremoverErrors, wartremoverExcluded, wartremoverWarnings}
import wartremover.{Wart, Warts}

object WartRemoverSettings extends AutoPlugin {

  override def trigger = allRequirements

  private val compileErrorOn: Seq[Wart] =
    Warts.allBut(
      Wart.Equals,
      Wart.ImplicitParameter,
      Wart.DefaultArguments,
      Wart.Throw,
      Wart.Nothing,
      Wart.ToString,
      Wart.FinalCaseClass,
      Wart.AsInstanceOf,
      Wart.Overloading,
      Wart.OptionPartial,
      Wart.IterableOps,
      Wart.ListAppend,
      Wart.PlatformDefault,
      Wart.MutableDataStructures,
      Wart.SeqUpdated,
      Wart.While,
      Wart.Var,
      Wart.Any
    )

  private val compileWarnOn: Seq[Wart] =
    Warts.allBut(
      Wart.Equals,
      Wart.ToString,
      Wart.ImplicitParameter,
      Wart.DefaultArguments,
      Wart.Throw,
      Wart.Nothing,
      Wart.Overloading,
      Wart.FinalCaseClass,
      Wart.PlatformDefault,
      Wart.While
    )

  private val testErrorOn: Seq[Wart] =
    Warts.allBut(
      Wart.Equals,
      Wart.ToString,
      Wart.GlobalExecutionContext,
      Wart.DefaultArguments,
      Wart.Any,
      Wart.Nothing,
      Wart.Throw,
      Wart.Var,
      Wart.Null,
      Wart.Overloading,
      Wart.FinalCaseClass,
      Wart.StringPlusAny,
      Wart.AsInstanceOf,
      Wart.OptionPartial,
      Wart.TryPartial,
      Wart.MutableDataStructures,
      Wart.PlatformDefault
    )

  private val testWarnOn: Seq[Wart] =
    Warts.allBut(
      Wart.Equals,
      Wart.ToString,
      Wart.GlobalExecutionContext,
      Wart.DefaultArguments,
      Wart.Nothing,
      Wart.Throw,
      Wart.Overloading,
      Wart.FinalCaseClass,
      Wart.PlatformDefault
    )

  override lazy val projectSettings: Seq[Setting[?]] = Seq(
    wartremoverExcluded ++= (Compile / routes).value,
    // Compile main sources
    Compile / compile / wartremoverErrors ++= compileErrorOn,
    Compile / compile / wartremoverWarnings ++= compileWarnOn,
    // Test sources
    Test / wartremoverErrors ++= testErrorOn,
    Test / wartremoverWarnings ++= testWarnOn
  )

}
