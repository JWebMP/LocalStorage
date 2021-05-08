package com.jwebmp.plugins.security.localstorage.implementations;

import com.guicedee.guicedservlets.websockets.WebSocketsConfiguration;
import com.guicedee.guicedservlets.websockets.services.IWebSocketAuthDataProvider;

import static com.jwebmp.core.utilities.StaticStrings.*;

public class LocalStorageKeyWSAuth
		implements IWebSocketAuthDataProvider<LocalStorageKeyWSAuth>
{
	@Override
	public StringBuilder getJavascriptToPopulate()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("jw.env.scope.localstorage = jw.localstorage;\n");
		sb.append("jw.websocket.newMessage('LocalStorage'," +
		                         "{'jwamsmk':jw.localstorage['jwamsmk'],'headers':jw.headers}" +
		                         ");"
		);
		return sb;
	}

	@Override
	public String name()
	{
		return "LocalStorageWS";
	}

	@Override
	public boolean enabled()
	{
		return true;
	}
}
