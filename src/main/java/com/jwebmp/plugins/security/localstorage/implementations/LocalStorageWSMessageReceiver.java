package com.jwebmp.plugins.security.localstorage.implementations;

import com.guicedee.guicedservlets.websockets.GuicedWebSocket;
import com.guicedee.guicedservlets.websockets.options.WebSocketMessageReceiver;
import com.guicedee.guicedservlets.websockets.services.IWebSocketService;
import com.guicedee.logger.LogFactory;

import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.utilities.StaticStrings;
import jakarta.websocket.Session;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.jwebmp.core.utilities.StaticStrings.LOCAL_STORAGE_PARAMETER_KEY;

public class LocalStorageWSMessageReceiver
		implements IWebSocketService
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

	@Override
	public void onOpen(Session session, GuicedWebSocket socket)
	{

	}

	@Override
	public void onClose(Session session, GuicedWebSocket socket)
	{

	}

	@Override
	public void onMessage(String message, Session session, WebSocketMessageReceiver messageReceiver, GuicedWebSocket socket)
	{
		if (enabled())
		{
			if (messageReceiver.getAction()
			                   .equalsIgnoreCase("LocalStorage"))
			{
				try
				{
					if(messageReceiver.getData() != null && messageReceiver.getData().get(LOCAL_STORAGE_PARAMETER_KEY) != null)
					{
						String sessionKey = messageReceiver.getData()
						                                   .get(LOCAL_STORAGE_PARAMETER_KEY).toString();
						LocalStorageWSMessageReceiver.log.log(Level.FINER, "Messaging web socket to local storage - " + LOCAL_STORAGE_PARAMETER_KEY);
						messageReceiver.setBroadcastGroup(sessionKey);
						GuicedWebSocket.addToGroup(sessionKey,session);
						GuicedWebSocket.getWebSocketSessionBindings()
						               .put(LOCAL_STORAGE_PARAMETER_KEY, session);
					}
					else {
						String sessionUUID = UUID.randomUUID()
						                         .toString();
						AjaxResponse<?> newKey = new AjaxResponse<>();
						newKey.getLocalStorage()
						      .put(LOCAL_STORAGE_PARAMETER_KEY, sessionUUID);
						GuicedWebSocket.addToGroup(sessionUUID, session);
						GuicedWebSocket.getWebSocketSessionBindings()
						               .put(sessionUUID, session);
						GuicedWebSocket.broadcastMessage(sessionUUID, newKey.toString());
						messageReceiver.setBroadcastGroup(sessionUUID);
					}
				}
				catch (Exception e)
				{
					LocalStorageWSMessageReceiver.log.log(Level.WARNING, "Unable to check for local storage key", e);
				}
			}
		}
	}

	@Override
	public void onError(Throwable t, GuicedWebSocket socket)
	{

	}

	@Override
	public boolean enabled()
	{
		return LocalStorageWSMessageReceiver.enabled;
	}
}
