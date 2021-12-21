package com.jwebmp.plugins.security.localstorage.implementations;

import com.google.inject.*;
import com.guicedee.guicedinjection.*;
import com.guicedee.guicedservlets.websockets.*;
import com.jwebmp.core.base.ajax.*;

import java.util.*;

import static com.jwebmp.core.utilities.StaticStrings.*;

public class LocalStorageStringProvider implements Provider<String>
{
	@Override
	public String get()
	{
		AjaxCall<?> call = GuiceContext.get(AjaxCall.class);
		com.jwebmp.core.base.ajax.AjaxResponse<?> response = GuiceContext.get(com.jwebmp.core.base.ajax.AjaxResponse.class);
		UUID uuid = null;
		if (call.getLocalStorage()
		        .isEmpty())
		{
			return null;
		}
		
		if (call.getLocalStorage()
		        .containsKey(LOCAL_STORAGE_PARAMETER_KEY))
		{
			return call.getLocalStorage()
			           .get(LOCAL_STORAGE_PARAMETER_KEY);
		}
		
		if (call.isWebSocketCall())
		{
			var websocket = call.getWebsocketSession();
			if (GuicedWebSocket.hasProperty(websocket, LOCAL_STORAGE_PARAMETER_KEY))
			{
				return GuicedWebSocket.getPropertyMap(websocket)
				                      .get(LOCAL_STORAGE_PARAMETER_KEY);
			}
		}
		
		if (uuid == null)
		{
			uuid = UUID.randomUUID();
		}
		
		call.getLocalStorage()
		    .put(LOCAL_STORAGE_PARAMETER_KEY, uuid.toString());
		response.getLocalStorage()
		        .put(LOCAL_STORAGE_PARAMETER_KEY, uuid.toString());
		
		return uuid.toString();
	}
	
}
