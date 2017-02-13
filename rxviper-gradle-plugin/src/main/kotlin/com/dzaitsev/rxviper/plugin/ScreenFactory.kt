package com.dzaitsev.rxviper.plugin

import org.gradle.api.NamedDomainObjectFactory
import org.gradle.api.Project

internal class ScreenFactory(private val project: Project) : NamedDomainObjectFactory<Screen> {
  override fun create(name: String) = Screen(name, project.container(aClass<UseCase>()))
}