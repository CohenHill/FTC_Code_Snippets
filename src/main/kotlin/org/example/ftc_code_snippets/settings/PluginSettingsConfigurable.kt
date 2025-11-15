package org.example.ftc_code_snippets.settings

import com.intellij.openapi.options.Configurable
import javax.swing.JComboBox
import javax.swing.JComponent
import javax.swing.JPanel

class PluginSettingsConfigurable : Configurable {

    private val state = PluginState.instance.state
    private val panel = JPanel()
    private val languageDropdown = JComboBox(arrayOf("Java", "Kotlin"))

    override fun getDisplayName(): String = "FTC Code Snippets"

    override fun createComponent(): JComponent {
        languageDropdown.selectedItem = state.preferredLanguage
        panel.add(languageDropdown)
        return panel
    }

    override fun isModified(): Boolean {
        return languageDropdown.selectedItem != state.preferredLanguage
    }

    override fun apply() {
        state.preferredLanguage = languageDropdown.selectedItem as String
    }
}