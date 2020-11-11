package com.jwebmp.plugins.security.localstorage;

import com.google.inject.Singleton;
import com.jwebmp.core.Page;
import com.jwebmp.core.services.IPageConfigurator;

import jakarta.validation.constraints.NotNull;

import static com.jwebmp.plugins.security.localstorage.enumerations.LocalStorageReferencePool.*;

@Singleton
public class LocalStoragePageConfigurator
		implements IPageConfigurator<LocalStoragePageConfigurator>
{
	/**
	 * The local storage
	 */
	private boolean localStorage = true;

	@Override
	public @NotNull Page<?> configure(Page<?> page)
	{
		page.getBody()
		    .addJavaScriptReference(PersistJS.getJavaScriptReference());
		return page;
	}

	@Override
	public boolean enabled()
	{
		return localStorage;
	}


	/**
	 * If this page should be rendered with dynamic local storage support
	 *
	 * @return
	 */
	public boolean isLocalStorage()
	{
		return localStorage;
	}

	/**
	 * If the page should be rendered with dynamic local storage support. This renders a default page that is then fetched from the server to support cordova applications
	 *
	 * @param localStorage
	 */
	public void setLocalStorage(boolean localStorage)
	{
		this.localStorage = localStorage;
	}
}
