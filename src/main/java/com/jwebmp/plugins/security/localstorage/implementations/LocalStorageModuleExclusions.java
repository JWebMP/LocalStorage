package com.jwebmp.plugins.security.localstorage.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class LocalStorageModuleExclusions
		implements IGuiceScanModuleExclusions<LocalStorageModuleExclusions>
{

	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.guicedee.guicedservlets.websockets");
		strings.add("com.jwebmp.plugins.security.localstorage");

		strings.add("org.apache.commons.io");
		strings.add("org.apache.commons.lang3");
		strings.add("org.apache.commons.text");

		strings.add("javax.websocket.api");
		return strings;
	}
}
