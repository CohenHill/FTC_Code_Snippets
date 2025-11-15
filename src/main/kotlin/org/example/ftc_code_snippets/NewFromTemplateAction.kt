package org.example.ftc_code_snippets

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import org.jetbrains.annotations.NonNls
import org.example.ftc_code_snippets.settings.PluginState

open class NewFromTemplateAction(
    text: String,
    description: String,
    private val baseTemplateName: String   // e.g. "Subsystem"
) : CreateFileFromTemplateAction(text, description, null) {

    private fun resolvedTemplateName(): String {
        val lang = PluginState.instance.state.preferredLanguage

        return if (lang == "Kotlin") {
            val kt = "kt"
            "$baseTemplateName$kt"
        } else {
            "$baseTemplateName"
        }
    }

    override fun buildDialog(
        project: Project,
        directory: PsiDirectory,
        builder: CreateFileFromTemplateDialog.Builder
    ) {
        val template = resolvedTemplateName()

        builder.setTitle("Create $baseTemplateName")
        builder.addKind(baseTemplateName, null, template)
    }

    override fun getActionName(
        directory: PsiDirectory,
        @NonNls newName: String,
        @NonNls templateName: String
    ): String = "Creating $templateName"
}