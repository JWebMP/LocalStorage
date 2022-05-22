import com.jwebmp.plugins.security.localstorage.implementations.LocalStorageInclusionModule ;

module com.jwebmp.plugins.security.localstorage {
	requires transitive com.jwebmp.core.angular;
	
	requires com.guicedee.guicedservlets.websockets;
	requires jakarta.websocket.api;
	
	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.security.localstorage.LocalStoragePageConfigurator;
	provides com.guicedee.guicedservlets.websockets.services.IWebSocketMessageReceiver with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageWSMessageReceiver;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with LocalStorageInclusionModule;

	provides com.guicedee.guicedinjection.interfaces.IGuiceModule with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageSecurityBinder;
	
	exports com.jwebmp.plugins.security.localstorage;
	opens com.jwebmp.plugins.security.localstorage to com.google.guice,com.jwebmp.core;
	
	exports com.jwebmp.plugins.security.localstorage.implementations;
	opens com.jwebmp.plugins.security.localstorage.implementations  to com.google.guice,com.jwebmp.core;
}
