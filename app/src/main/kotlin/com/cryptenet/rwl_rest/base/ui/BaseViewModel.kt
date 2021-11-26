package com.cryptenet.rwl_rest.base.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cryptenet.rwl_rest.base.mvi.Events
import com.cryptenet.rwl_rest.base.mvi.Intents
import com.cryptenet.rwl_rest.base.mvi.States
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<STATES : States, EVENTS : Events, INTENTS : Intents> : ViewModel() {
    private val initialState: STATES by lazy { setInitialState() }
    abstract fun setInitialState(): STATES

    private val _states: MutableState<STATES> = mutableStateOf(initialState)
    val states: State<STATES> = _states

    private val _events: MutableSharedFlow<EVENTS> = MutableSharedFlow()

    private val _intents: Channel<INTENTS> = Channel()
    val intents = _intents.receiveAsFlow()

    init {
        subscribeToEvents()
    }

    fun setEvents(events: EVENTS) {
        viewModelScope.launch { _events.emit(events) }
    }

    protected fun setStates(reducer: STATES.() -> STATES) {
        val newStates = states.value.reducer()
        _states.value = newStates
    }

    private fun subscribeToEvents() {
        viewModelScope.launch { _events.collect { handleEvents(it) } }
    }

    abstract fun handleEvents(events: EVENTS)

    protected fun setIntents(builder: () -> INTENTS) {
        val intentValue = builder()
        viewModelScope.launch { _intents.send(intentValue) }
    }
}
