package com.cohenhill.ftc.codesnippets

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import org.jetbrains.annotations.NonNls
import com.cohenhill.ftc.codesnippets.settings.PluginState
import javax.swing.Icon

open class NewFromTemplateAction(
    text: String,
    description: String,
    private val baseTemplateName: String,
    private val icon: Icon? = null
) : CreateFileFromTemplateAction(text, description, icon) {

    private fun resolvedTemplateName(): String {
        val lang = PluginState.instance.state.preferredLanguage

        return if (lang == "Kotlin") {
            "${baseTemplateName}kt.kt"
        } else {
            "$baseTemplateName.java"
        }
    }

    override fun buildDialog(
        project: Project,
        directory: PsiDirectory,
        builder: CreateFileFromTemplateDialog.Builder
    ) {
        val template = resolvedTemplateName()

        builder.setTitle("Create $baseTemplateName")
        builder.addKind(baseTemplateName, icon, template)
    }

    override fun getActionName(
        directory: PsiDirectory,
        @NonNls newName: String,
        @NonNls templateName: String
    ): String = "Creating $templateName"
}
