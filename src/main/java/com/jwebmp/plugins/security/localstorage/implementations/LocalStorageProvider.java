package com.jwebmp.plugins.security.localstorage.implementations;

import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.UUID;

public class LocalStorageProvider implements Provider<UUID>
{
	@Inject
	private LocalStorageStringProvider stringProvider;
	
	@Override
	public UUID get()
	{
		return UUID.fromString(stringProvider.get());
	}
}
