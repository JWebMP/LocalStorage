package com.jwebmp.plugins.security.localstorage.implementations;

import com.google.inject.Provider;
import com.guicedee.guicedinjection.GuiceContext;
import com.jwebmp.core.base.ajax.AjaxCall;

import java.util.UUID;

public class LocalStorageStringProvider implements Provider<String>
{
	@Override
	public String get()
	{
		AjaxCall<?> call = GuiceContext.get(AjaxCall.class);
		if(call.getLocalStorage().isEmpty())
			return UUID.randomUUID().toString();
		
		return call.getLocalStorage().get("jwamsmk");
	}
	
}
