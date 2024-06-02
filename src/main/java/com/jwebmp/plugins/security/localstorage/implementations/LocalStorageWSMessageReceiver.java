package com.jwebmp.plugins.security.localstorage.implementations;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedservlets.websockets.options.CallScopeProperties;
import com.guicedee.guicedservlets.websockets.options.IGuicedWebSocket;
import com.guicedee.guicedservlets.websockets.options.WebSocketMessageReceiver;
import com.guicedee.guicedservlets.websockets.services.IWebSocketMessageReceiver;
import com.guicedee.vertx.websockets.GuicedWebSocket;
import com.jwebmp.core.base.ajax.AjaxResponse;
import lombok.extern.java.Log;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;

import static com.jwebmp.interception.services.StaticStrings.LOCAL_STORAGE_PARAMETER_KEY;

@Log
public class LocalStorageWSMessageReceiver
        implements IWebSocketMessageReceiver
{
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
            //Session session = messageReceiver.getSession();
            GuicedWebSocket socket = (GuicedWebSocket) IGuiceContext.get(IGuicedWebSocket.class);
            Map<String, Object> map = messageReceiver.getData();
            boolean found = false;
            CallScopeProperties callScopeProperties = IGuiceContext.get(CallScopeProperties.class);
            if (map.containsKey("localStorage"))
            {
                Map<String, Object> localStorage = (Map<String, Object>) map.get("localStorage");
                if (localStorage.containsKey(LOCAL_STORAGE_PARAMETER_KEY))
                {
                    found = true;
                    String sessionKey = localStorage.get(LOCAL_STORAGE_PARAMETER_KEY)
                                                    .toString();
                    LocalStorageWSMessageReceiver.log.log(Level.FINER, "Web socket local storage - " + LOCAL_STORAGE_PARAMETER_KEY);
                    messageReceiver.setBroadcastGroup(sessionKey);
                    callScopeProperties.getProperties()
                                       .put(LOCAL_STORAGE_PARAMETER_KEY, sessionKey);
                    socket.addToGroup(sessionKey);
                }
            }
            if (!found)
            {
                String sessionUUID = UUID.randomUUID()
                                         .toString();
                AjaxResponse<?> newKey = new AjaxResponse<>();
                newKey.getLocalStorage()
                      .put(LOCAL_STORAGE_PARAMETER_KEY, sessionUUID);
                newKey.preConfigure();
                callScopeProperties.getProperties()
                                   .put(LOCAL_STORAGE_PARAMETER_KEY, sessionUUID);
                socket.addToGroup(sessionUUID);
                socket.broadcastMessage(sessionUUID, newKey.toString());
                messageReceiver.setBroadcastGroup(sessionUUID);
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
