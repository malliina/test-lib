import com.mle.sbtutils.SbtProjects
import sbt._
import sbt.Keys._
import bintray.Keys.{bintrayOrganization, repository, bintray => bintrayConf}

/**
 * A scala build file template.
 */
object TemplateBuild extends Build {

  lazy val template = SbtProjects.testableProject("test-lib").settings(projectSettings: _*)

  lazy val projectSettings = bintray.Plugin.bintraySettings ++ Seq(
    organization := "com.github.malliina",
    version := "0.0.6",
    scalaVersion := "2.11.5",
    fork in Test := true,
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    bintrayOrganization in bintrayConf := None,
    publishMavenStyle := false,
    repository in bintrayConf := "testrepo"
  )
}