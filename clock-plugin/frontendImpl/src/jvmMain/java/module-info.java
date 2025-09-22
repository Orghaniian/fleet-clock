import com.orghaniian.clock.Clock;

module com.orghaniian.clock {
    requires fleet.frontend;
    requires fleet.kernel;
    requires fleet.util.logging.api;
    requires fleet.rhizomedb;
    requires fleet.frontend.ui;

    exports com.orghaniian.clock;
    provides fleet.kernel.plugins.Plugin with Clock;
}
