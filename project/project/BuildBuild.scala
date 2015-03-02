import sbt._
import sbt.Keys._

object BuildBuild extends Build {

  override lazy val settings = super.settings ++ sbtPlugins ++ Seq(
    resolvers += Resolver.url(
      "bintray-sbt-plugin-releases",
      url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(
        Resolver.ivyStylePatterns)
  )

  def sbtPlugins = Seq(
    "com.timushev.sbt" % "sbt-updates" % "0.1.6",
    "com.github.malliina" %% "sbt-utils" % "0.0.5",
    "me.lessis" % "bintray-sbt" % "0.2.0"
  ) map addSbtPlugin

  override lazy val projects = Seq(root)
  lazy val root = Project("plugins", file("."))
}