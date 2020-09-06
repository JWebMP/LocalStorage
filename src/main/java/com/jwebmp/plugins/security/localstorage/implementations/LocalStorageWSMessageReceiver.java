package com.jwebmp.plugins.security.localstorage.implementations;

import com.guicedee.guicedservlets.websockets.GuicedWebSocket;
import com.guicedee.guicedservlets.websockets.options.WebSocketMessageReceiver;
import com.guicedee.guicedservlets.websockets.services.IWebSocketService;
import com.guicedee.logger.LogFactory;

import javax.websocket.Session;
import java.util.logging.Level;
import java.util.logging.Logger;

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
					String sessionKey = messageReceiver.getData()
					                            .get("sessionid").toString();
					LocalStorageWSMessageReceiver.log.log(Level.FINER, "Messaging web socket to session - " + sessionKey);
					GuicedWebSocket.addToGroup(sessionKey,session);
					GuicedWebSocket.getWebSocketSessionBindings()
					               .put(sessionKey, session);
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
