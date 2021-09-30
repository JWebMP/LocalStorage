package com.jwebmp.plugins.security.localstorage.implementations;

import com.google.inject.Provider;
import com.guicedee.guicedinjection.GuiceContext;
import com.jwebmp.core.base.ajax.AjaxCall;

import java.util.UUID;

import static com.jwebmp.core.utilities.StaticStrings.*;

public class LocalStorageStringProvider implements Provider<String>
{
	@Override
	public String get()
	{
		AjaxCall<?> call = GuiceContext.get(AjaxCall.class);
		com.jwebmp.core.base.ajax.AjaxResponse<?> response = GuiceContext.get(com.jwebmp.core.base.ajax.AjaxResponse.class);
		UUID uuid = null;
		if(call.getLocalStorage().isEmpty())
			uuid = UUID.randomUUID();
		
		
		if (call.getSessionStorage()
		        .containsKey(LOCAL_STORAGE_PARAMETER_KEY))
		{
			return call.getSessionStorage()
			           .get(LOCAL_STORAGE_PARAMETER_KEY);
		}
		if (uuid == null)
		{
			uuid = UUID.randomUUID();
		}
		call.getSessionStorage()
		    .put(LOCAL_STORAGE_PARAMETER_KEY, uuid.toString());
		response.getSessionStorage()
		        .put(LOCAL_STORAGE_PARAMETER_KEY, uuid.toString());
		
		return uuid.toString();
	}
	
}
