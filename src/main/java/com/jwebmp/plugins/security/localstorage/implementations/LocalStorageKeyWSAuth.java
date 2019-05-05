package com.jwebmp.plugins.security.localstorage.implementations;

import com.jwebmp.websockets.WebSocketsConfiguration;
import com.jwebmp.websockets.services.IWebSocketAuthDataProvider;

import static com.jwebmp.core.utilities.StaticStrings.*;

public class LocalStorageKeyWSAuth
		implements IWebSocketAuthDataProvider<LocalStorageKeyWSAuth>
{
	@Override
	public StringBuilder getJavascriptToPopulate()
	{
		return new StringBuilder("jw.websocket.newMessage('LocalStorage'," +
		                         "{'jwamsmk':jw.localstorage['jwamsmk']}" +
		                         ");"
		);
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
