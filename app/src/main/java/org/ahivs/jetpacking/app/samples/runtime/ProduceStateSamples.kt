package org.ahivs.jetpacking.app.samples.runtime

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map

@Suppress("UNUSED_PARAMETER")
@Composable
private fun Text(text: String): Unit = TODO()

class ProduceStateSampleViewModel {
    val people: Flow<List<Person>> = TODO()

    interface Disposable {
        fun dispose()
    }

    @Suppress("UNUSED_PARAMETER")
    fun registerPersonObserver(observer: (Person) -> Unit): Disposable = TODO()
}

data class Person(val name: String)

private sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    class Data<T>(val data: T) : UiState<T>()
}


@Composable
fun ProduceState(viewModel: ProduceStateSampleViewModel) {
    val uiState by produceState<UiState<List<Person>>>(UiState.Loading, viewModel) {
        viewModel.people
            .map { UiState.Data(it) }
            .collect { value = it }
    }

    when (val state = uiState) {
        is UiState.Loading -> Text("Loading...")
        is UiState.Data -> Column {
            for (person in state.data) {
                Text("Hello, ${person.name}")
            }
        }
    }
}

@Suppress("UNUSED_VARIABLE")

@Composable
fun ProduceStateAwaitDispose(viewModel: ProduceStateSampleViewModel) {
    val currentPerson by produceState<Person?>(null, viewModel) {
        val disposable = viewModel.registerPersonObserver { person ->
            value = person
        }

        awaitDispose {
            disposable.dispose()
        }
    }
}