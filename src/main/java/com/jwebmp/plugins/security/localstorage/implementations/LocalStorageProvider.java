package com.jwebmp.plugins.security.localstorage.implementations;

import com.google.common.base.*;
import com.google.inject.*;

import java.util.*;

public class LocalStorageProvider implements Provider<UUID>
{
	@Inject
	private LocalStorageStringProvider stringProvider;
	
	@Override
	public UUID get()
	{
		String result = stringProvider.get();
		if (Strings.isNullOrEmpty(result))
		{
			return null;
		}
		return UUID.fromString(stringProvider.get());
	}
}
