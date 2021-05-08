package com.jwebmp.plugins.security.localstorage.implementations;

import com.jwebmp.core.Event;
import com.jwebmp.core.events.IEventConfigurator;
import com.jwebmp.core.utilities.StaticStrings;

import jakarta.validation.constraints.NotNull;

public class LocalStorageEventConfigurator implements IEventConfigurator<LocalStorageEventConfigurator>
{
	@Override
	public @NotNull Event<?, ?> configureEvent(Event event)
	{
		event.returnVariable("localstorage");
		return event;
	}
}
