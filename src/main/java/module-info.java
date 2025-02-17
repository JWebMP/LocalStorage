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
    provides com.guicedee.guicedservlets.websockets.services.IWebSocketMessageReceiver with LocalStorageWSMessageReceiver;
    provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with LocalStorageInclusionModule;

    provides com.guicedee.guicedinjection.interfaces.IGuiceModule with LocalStorageSecurityBinder;
    provides AjaxCallIntercepter with LocalStorageInterceptor;

    exports com.jwebmp.plugins.security.localstorage;
    opens com.jwebmp.plugins.security.localstorage to com.google.guice, com.jwebmp.core;

    exports com.jwebmp.plugins.security.localstorage.implementations;
    opens com.jwebmp.plugins.security.localstorage.implementations to com.google.guice, com.jwebmp.core;
}
