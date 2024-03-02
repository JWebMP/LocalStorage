import com.jwebmp.plugins.security.localstorage.implementations.LocalStorageInclusionModule;

module com.jwebmp.plugins.security.localstorage {

    requires com.jwebmp.core.base.angular.client;
    requires com.jwebmp.client;
    requires com.jwebmp.core;

    requires com.guicedee.guicedservlets.websockets;
    requires jakarta.websocket;
    requires jakarta.websocket.client;

    requires static lombok;

    provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.security.localstorage.LocalStoragePageConfigurator;
    provides com.guicedee.guicedservlets.websockets.services.IWebSocketMessageReceiver with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageWSMessageReceiver;
    provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with LocalStorageInclusionModule;

    provides com.guicedee.guicedinjection.interfaces.IGuiceModule with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageSecurityBinder;

    exports com.jwebmp.plugins.security.localstorage;
    opens com.jwebmp.plugins.security.localstorage to com.google.guice, com.jwebmp.core;

    exports com.jwebmp.plugins.security.localstorage.implementations;
    opens com.jwebmp.plugins.security.localstorage.implementations to com.google.guice, com.jwebmp.core;
}
