package com.orghaniian.clock

import fleet.frontend.editor.statusBarWidget
import fleet.kernel.plugins.ContributionScope
import fleet.kernel.plugins.Plugin
import fleet.kernel.plugins.PluginScope

typealias ClockApi = Unit

class Clock : Plugin<ClockApi> {
    companion object : Plugin.Key<ClockApi>
    override val key: Plugin.Key<ClockApi> = Clock

    override fun ContributionScope.load(pluginScope: PluginScope) {
        statusBarWidget(ClockWidget())
    }
}
