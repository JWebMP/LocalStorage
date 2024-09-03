package com.jwebmp.plugins.security.localstorage.implementations;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedservlets.websockets.options.CallScopeProperties;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.interception.services.AjaxCallIntercepter;

import java.util.UUID;

import static com.jwebmp.interception.services.StaticStrings.LOCAL_STORAGE_PARAMETER_KEY;

public class LocalStorageInterceptor implements AjaxCallIntercepter<LocalStorageInterceptor>
{
    @Override
    public void intercept(AjaxCall<?> call, AjaxResponse<?> response)
    {
        if (call.getLocalStorage()
                .containsKey(LOCAL_STORAGE_PARAMETER_KEY))
        {
            try
            {
                CallScopeProperties callScopeProperties = IGuiceContext.get(CallScopeProperties.class);
                callScopeProperties.getProperties()
                                   .put(LOCAL_STORAGE_PARAMETER_KEY, call.getLocalStorage()
                                                                         .get(LOCAL_STORAGE_PARAMETER_KEY));
            }
            catch (Throwable e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            String newKey = UUID.randomUUID()
                                .toString();
            response.getLocalStorage()
                    .put(LOCAL_STORAGE_PARAMETER_KEY, newKey);
            try
            {
                CallScopeProperties callScopeProperties = IGuiceContext.get(CallScopeProperties.class);
                callScopeProperties.getProperties()
                                   .put(LOCAL_STORAGE_PARAMETER_KEY, newKey);
            }
            catch (Throwable e)
            {
                e.printStackTrace();
            }
        }
    }
}
