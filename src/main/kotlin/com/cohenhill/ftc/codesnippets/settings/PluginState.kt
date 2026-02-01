package com.cohenhill.ftc.codesnippets.settings

import com.intellij.openapi.components.*

@Service(Service.Level.APP)
@State(
    name = "ftc_code_snippets_settings",
    storages = [Storage("ftc_code_snippets.xml")]
)
class PluginState : PersistentStateComponent<PluginState.State> {

    class State {
        var preferredLanguage: String = "Java"  // default
    }

    private var myState = State()

    override fun getState(): State = myState

    override fun loadState(state: State) {
        myState = state
    }

    companion object {
        val instance: PluginState
            get() = service()
    }
}
