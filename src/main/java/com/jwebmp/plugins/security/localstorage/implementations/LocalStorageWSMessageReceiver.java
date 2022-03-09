package com.jwebmp.plugins.security.localstorage.implementations;

import com.guicedee.guicedservlets.websockets.*;
import com.guicedee.guicedservlets.websockets.options.*;
import com.guicedee.guicedservlets.websockets.services.*;
import com.guicedee.logger.*;
import com.jwebmp.core.base.ajax.*;
import jakarta.websocket.*;

import java.util.*;
import java.util.logging.*;

import static com.jwebmp.core.utilities.StaticStrings.*;

public class LocalStorageWSMessageReceiver
		implements IWebSocketMessageReceiver
{
	private static final Logger log = LogFactory.getLog("LocalStorageWSReceiver");
	private static boolean enabled = true;
	
	public static boolean isEnabled()
	{
		return enabled;
	}
	
	public static void setEnabled(boolean enabled)
	{
		LocalStorageWSMessageReceiver.enabled = enabled;
	}
	
	//	@Override
	public void onOpen(Session session, GuicedWebSocket socket)
	{
	
	}
	
	//	@Override
	public void onClose(Session session, GuicedWebSocket socket)
	{
	
	}
	
	@Override
	public Set<String> messageNames()
	{
		Set<String> messageNames = new HashSet<>();
		messageNames.add("LocalStorage");
		return messageNames;
	}
	
	@Override
	public void receiveMessage(WebSocketMessageReceiver<?> messageReceiver) throws SecurityException
	{
		try
		{
			Session session = messageReceiver.getSession();
			Map<String, Object> map = messageReceiver.getMap("localStorage");
			if (map.containsKey(LOCAL_STORAGE_PARAMETER_KEY))
			{
				String sessionKey = map.get(LOCAL_STORAGE_PARAMETER_KEY)
				                       .toString();
				LocalStorageWSMessageReceiver.log.log(Level.FINER, "Web socket local storage - " + LOCAL_STORAGE_PARAMETER_KEY);
				messageReceiver.setBroadcastGroup(sessionKey);
				GuicedWebSocket.addToGroup(sessionKey, session);
				GuicedWebSocket.getWebSocketSessionBindings()
				               .put(LOCAL_STORAGE_PARAMETER_KEY, session);
				GuicedWebSocket.addWebsocketProperty(session, LOCAL_STORAGE_PARAMETER_KEY, sessionKey);
			}
			else
			{
				String sessionUUID = UUID.randomUUID()
				                         .toString();
				AjaxResponse<?> newKey = new AjaxResponse<>();
				newKey.getLocalStorage()
				      .put(LOCAL_STORAGE_PARAMETER_KEY, sessionUUID);
				newKey.preConfigure();
				GuicedWebSocket.addToGroup(sessionUUID, session);
				GuicedWebSocket.getWebSocketSessionBindings()
				               .put(sessionUUID, session);
				GuicedWebSocket.broadcastMessage(sessionUUID, newKey.toString());
				messageReceiver.setBroadcastGroup(sessionUUID);
				GuicedWebSocket.addWebsocketProperty(session, LOCAL_STORAGE_PARAMETER_KEY, sessionUUID);
			}
		}
		catch (Exception e)
		{
			LocalStorageWSMessageReceiver.log.log(Level.WARNING, "Unable to check for local storage key", e);
		}
	}
	
	
	//@Override
	public void onError(Throwable t, GuicedWebSocket socket)
	{
	
	}
	
	//@Override
	public boolean enabled()
	{
		return LocalStorageWSMessageReceiver.enabled;
	}
}
