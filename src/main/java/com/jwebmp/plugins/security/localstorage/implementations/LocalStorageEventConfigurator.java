package com.jwebmp.plugins.security.localstorage.implementations;

import com.jwebmp.core.Event;
import com.jwebmp.core.events.IEventConfigurator;
import com.jwebmp.core.utilities.StaticStrings;

import javax.validation.constraints.NotNull;

public class LocalStorageEventConfigurator implements IEventConfigurator<LocalStorageEventConfigurator>
{
	@Override
	public @NotNull Event<?, ?> configureEvent(Event event)
	{
		event.returnVariable(StaticStrings.LOCAL_STORAGE_VARIABLE_KEY);
		return event;
	}
}
