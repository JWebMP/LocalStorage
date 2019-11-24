package com.jwebmp.plugins.security.localstorage.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class LocalStorageModuleExclusions
		implements IGuiceScanModuleExclusions<LocalStorageModuleExclusions>,
				           IGuiceScanJarExclusions<LocalStorageModuleExclusions>
{
	@SuppressWarnings("Duplicates")
	@Override
	public @NotNull Set<String> excludeJars()
	{
		Set<String> strings = new HashSet<>();
		strings.add("jwebmp-websockets-*");
		strings.add("jwebmp-plugins-local-storage-*");
		strings.add("commons-io-*");
		strings.add("commons-lang3-*");
		strings.add("commons-text-*");
		strings.add("javax.websocket-api-*");
		return strings;
	}

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
