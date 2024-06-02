package com.jwebmp.plugins.security.localstorage.implementations;

import com.google.inject.Provider;
import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedservlets.websockets.options.CallScopeProperties;
import com.guicedee.guicedservlets.websockets.options.CallScopeSource;
import com.jwebmp.core.base.ajax.AjaxCall;

import java.util.UUID;

import static com.jwebmp.interception.services.StaticStrings.LOCAL_STORAGE_PARAMETER_KEY;

public class LocalStorageStringProvider implements Provider<String>
{
    @Override
    public String get()
    {
        AjaxCall<?> call = IGuiceContext.get(AjaxCall.class);
        com.jwebmp.core.base.ajax.AjaxResponse<?> response = IGuiceContext.get(com.jwebmp.core.base.ajax.AjaxResponse.class);
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

        CallScopeProperties callScopeProperties = IGuiceContext.get(CallScopeProperties.class);
        if (callScopeProperties.getSource() == CallScopeSource.WebSocket)
        {
            if (callScopeProperties.getProperties()
                                   .containsKey(LOCAL_STORAGE_PARAMETER_KEY))
            {
                return callScopeProperties.getProperties()
                                          .get(LOCAL_STORAGE_PARAMETER_KEY)
                                          .toString();
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
