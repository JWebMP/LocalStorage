import com.jwebmp.interception.services.AjaxCallIntercepter;
import com.jwebmp.plugins.security.localstorage.LocalStoragePageConfigurator;
import com.jwebmp.plugins.security.localstorage.implementations.*;

module com.jwebmp.plugins.security.localstorage {

    requires com.jwebmp.core.base.angular.client;
    requires com.jwebmp.client;
    requires com.jwebmp.core;
    requires com.jwebmp.vertx;


    requires static lombok;

    provides com.jwebmp.core.services.IPageConfigurator with LocalStoragePageConfigurator;
    provides com.guicedee.client.services.websocket.IWebSocketMessageReceiver with LocalStorageWSMessageReceiver;
    provides com.guicedee.client.services.config.IGuiceScanModuleInclusions with LocalStorageInclusionModule;
    provides com.guicedee.client.services.lifecycle.IGuiceModule with LocalStorageSecurityBinder;
    provides AjaxCallIntercepter with LocalStorageInterceptor;

    exports com.jwebmp.plugins.security.localstorage;
    opens com.jwebmp.plugins.security.localstorage to com.google.guice, com.jwebmp.core, tools.jackson.databind, com.jwebmp.core.angular;

    exports com.jwebmp.plugins.security.localstorage.implementations;
    opens com.jwebmp.plugins.security.localstorage.implementations to com.google.guice, com.jwebmp.core, tools.jackson.databind, com.jwebmp.core.angular;
}
