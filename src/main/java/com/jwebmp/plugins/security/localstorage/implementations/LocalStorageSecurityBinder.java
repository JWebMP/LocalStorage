package com.jwebmp.plugins.security.localstorage.implementations;

import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.name.Names;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;
import com.guicedee.guicedservlets.servlets.services.scopes.CallScope;

import java.util.UUID;

public class LocalStorageSecurityBinder extends PrivateModule implements IGuiceModule<LocalStorageSecurityBinder>
{
	@Override
	protected void configure()
	{
		Key<UUID> localstoragekey = Key.get(UUID.class, Names.named("localstorage"));
		bind(localstoragekey).toProvider(LocalStorageProvider.class)
		                     .in(CallScope.class);
		
		expose(localstoragekey);
		
		Key<String> localstoragekeyString = Key.get(String.class, Names.named("localstorage"));
		bind(localstoragekeyString).toProvider(LocalStorageStringProvider.class)
		                           .in(CallScope.class);
		
		expose(localstoragekeyString);
	}
}
