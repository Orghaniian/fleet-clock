package com.orghaniian.clock

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.setValue
import fleet.common.document.EditorEntity
import fleet.compose.theme.components.Button
import fleet.compose.theme.components.withTooltip
import fleet.frontend.editor.StatusBarWidget
import fleet.frontend.editor.WidgetGroup
import fleet.frontend.editor.WidgetPlacement
import fleet.frontend.ui.editor.statusBarButtonStyle
import kotlinx.coroutines.delay
import noria.NoriaContext

class ClockWidget : StatusBarWidget {
    override val id: String = ID
    override val widgetGroup: WidgetGroup = WidgetGroup.RIGHT
    override val placementRequests: Set<WidgetPlacement> = setOf(WidgetPlacement.First)

    private var format by mutableStateOf(ClockFormat.HoursMinutes)

    @Composable
    override fun render(noriaContext: NoriaContext, editorEntity: EditorEntity?) {
        noriaContext.widget()
    }

    @Composable
    private fun NoriaContext.widget() {
        val tooltip = when (format) {
            ClockFormat.HoursMinutes -> "Show seconds"
            ClockFormat.HoursMinutesSeconds -> "Hide seconds"
        }

        withTooltip(tooltipText = tooltip) {
            Button(
                text = clockTime,
                style = statusBarButtonStyle(),
                enabled = true,
                onClick = { toggleFormat() },
            )
        }
    }

    @get:Composable
    private val NoriaContext.clockTime
        get() = produceState(format.now(), format) {
            while (true) {
                value = format.now()
                delay(format.refreshDelay)
            }
        }.value

    private fun toggleFormat() {
        format = when (format) {
            ClockFormat.HoursMinutes -> ClockFormat.HoursMinutesSeconds
            ClockFormat.HoursMinutesSeconds -> ClockFormat.HoursMinutes
        }
    }

    private companion object {
        const val ID = "clock-widget"
    }
}
