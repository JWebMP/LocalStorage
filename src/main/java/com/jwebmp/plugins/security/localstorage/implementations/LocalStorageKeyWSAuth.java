package com.jwebmp.plugins.security.localstorage.implementations;

import com.guicedee.guicedservlets.websockets.services.*;

public class LocalStorageKeyWSAuth
		implements IWebSocketAuthDataProvider<LocalStorageKeyWSAuth>
{
	@Override
	public StringBuilder getJavascriptToPopulate()
	{
		StringBuilder sb = new StringBuilder();
		//sb.append("alert('sending local storage');" +
		sb.append("this.send('LocalStorage',{},'localStorage');");
		return sb;
	}
	
	@Override
	public String name()
	{
		return "LocalStorageWSAuth";
	}
	
	@Override
	public boolean enabled()
	{
		return true;
	}
}
