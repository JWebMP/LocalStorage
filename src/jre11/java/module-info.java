module com.jwebmp.plugins.security.localstorage {

	requires com.jwebmp.core;
	requires java.validation;
	requires com.google.guice;
	requires com.fasterxml.jackson.databind;
	requires com.google.guice.extensions.servlet;
	requires com.jwebmp.guicedinjection;
	requires com.jwebmp.interception;
	requires com.jwebmp.websockets;
	requires javax.websocket.api;

	provides com.jwebmp.interception.services.DataCallIntercepter with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageIntercepter;
	provides com.jwebmp.interception.services.AjaxCallIntercepter with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageIntercepter;
	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.security.localstorage.LocalStoragePageConfigurator;
	provides com.jwebmp.core.events.IEventConfigurator with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageEventConfigurator;
	provides com.jwebmp.websockets.services.IWebSocketAuthDataProvider with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageKeyWSAuth;
	provides com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageModuleExclusions;
	provides com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageModuleExclusions;
	provides com.jwebmp.websockets.services.IWebSocketService with com.jwebmp.plugins.security.localstorage.implementations.LocalStorageWSMessageReceiver;

	opens com.jwebmp.plugins.security.localstorage to com.google.guice,com.jwebmp.core;
	opens com.jwebmp.plugins.security.localstorage.implementations  to com.google.guice,com.jwebmp.core;
}
