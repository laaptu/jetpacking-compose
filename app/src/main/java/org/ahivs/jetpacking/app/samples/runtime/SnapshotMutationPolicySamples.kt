package org.ahivs.jetpacking.app.samples.runtime

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SnapshotMutationPolicy
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.Snapshot


fun counterSample() {
    /**
     * A policy that treats an `MutableState<Int>` as a counter. Changing the value to the same
     * integer value will not be considered a change. When snapshots are applied the changes made by
     * the applying snapshot are added together with changes of other snapshots. Changes to a
     * [MutableState] with a counterPolicy will never cause an apply conflict.
     *
     * As the name implies, this is useful when counting things, such as tracking the amount of
     * a resource consumed or produced while in a snapshot. For example, if snapshot A produces 10
     * things and snapshot B produces 20 things, the result of applying both A and B should be that
     * 30 things were produced.
     */
    fun counterPolicy(): SnapshotMutationPolicy<Int> = object : SnapshotMutationPolicy<Int> {
        override fun equivalent(a: Int, b: Int): Boolean = a == b
        override fun merge(previous: Int, current: Int, applied: Int) =
            current + (applied - previous)
    }

    val state = mutableStateOf(0, counterPolicy())
    val snapshot1 = Snapshot.takeMutableSnapshot()
    val snapshot2 = Snapshot.takeMutableSnapshot()
    try {
        snapshot1.enter { state.value += 10 }
        snapshot2.enter { state.value += 20 }
        snapshot1.apply().check()
        snapshot2.apply().check()
    } finally {
        snapshot1.dispose()
        snapshot2.dispose()
    }

    // State is now equals 30 as the changes made in the snapshots are added together.
}