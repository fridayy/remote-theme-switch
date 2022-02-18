package com.github.fridayy.remotethemeswitch.services

import com.intellij.openapi.project.Project
import com.github.fridayy.remotethemeswitch.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
