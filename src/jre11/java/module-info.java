import com.jwebmp.plugins.security.localstorage.implementations.LocalStorageInclusionModule ;

module com.jwebmp.plugins.security.localstorage {

	requires com.jwebmp.core;
	requires jakarta.validation;
	requires com.google.guice;
	requires com.fasterxml.jackson.databind;
	requires com.google.guice.extensions.servlet;
	requires com.guicedee.guicedinjection;
	requires com.guicedee.guicedservlets.websockets;
	requires jakarta.websocket.api;
	
	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.security.localstorage.LocalStoragePageConfigurator;
	provides com.jwebmp.core.events.IEventConfigurator with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageEventConfigurator;
	provides com.guicedee.guicedservlets.websockets.services.IWebSocketAuthDataProvider with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageKeyWSAuth;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageModuleExclusions;
	provides com.guicedee.guicedservlets.websockets.services.IWebSocketService with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageWSMessageReceiver;
	//provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with LocalStorageInclusionModule;

	
	opens com.jwebmp.plugins.security.localstorage to com.google.guice,com.jwebmp.core;
	opens com.jwebmp.plugins.security.localstorage.implementations  to com.google.guice,com.jwebmp.core;
}
