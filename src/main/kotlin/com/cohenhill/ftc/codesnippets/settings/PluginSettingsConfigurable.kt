package com.cohenhill.ftc.codesnippets.settings

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class PluginSettingsConfigurable : Configurable {

    private val state = PluginState.instance.state
    private val languageDropdown = ComboBox(arrayOf("Java", "Kotlin"))

    override fun getDisplayName(): String = "FTC Code Snippets"

    override fun createComponent(): JComponent {
        languageDropdown.selectedItem = state.preferredLanguage

        return panel {
            group("Code Generation") {
                row("Preferred language:") {
                    cell(languageDropdown)
                        .align(AlignX.FILL)
                        .comment("Select the default language for generated FTC templates")
                }
            }
        }
    }

    override fun isModified(): Boolean {
        return languageDropdown.selectedItem != state.preferredLanguage
    }

    override fun apply() {
        state.preferredLanguage = languageDropdown.selectedItem as String
    }

    override fun reset() {
        languageDropdown.selectedItem = state.preferredLanguage
    }
}
