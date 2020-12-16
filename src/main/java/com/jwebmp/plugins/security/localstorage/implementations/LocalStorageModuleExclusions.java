package com.jwebmp.plugins.security.localstorage.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class LocalStorageModuleExclusions
		implements IGuiceScanModuleExclusions<LocalStorageModuleExclusions>
{

	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.plugins.security.localstorage");
		return strings;
	}
}
