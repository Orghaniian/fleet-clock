plugins {
    base
    alias(libs.plugins.fleet.plugin)
}

version = "1.0.0"

fleetPlugin {
    id = "com.orghaniian.clock"

    metadata {
        readableName = "Clock"
        description = "Displays the time in the status bar."
    }

    fleetRuntime {
        version = libs.versions.fleet.runtime
    }
}
