package com.jwebmp.plugins.security.localstorage;

import com.google.inject.*;
import com.jwebmp.core.*;
import com.jwebmp.core.base.angular.services.annotations.structures.*;
import com.jwebmp.core.plugins.*;
import com.jwebmp.core.services.*;
import jakarta.validation.constraints.*;

@Singleton
@PluginInformation(pluginName = "Local Storage ",
                   pluginUniqueName = "local-storage",
                   pluginDescription = "Provides access to read and write into the local storage of a browser.",
                   pluginVersion = "1.0",
                   pluginDependancyUniqueIDs = "jquery",
                   pluginCategories = "storage,cookies,localstorage,security",
                   pluginSubtitle = "Local Storage Service ",
                   pluginGitUrl = "https://github.com/GedMarc/JWebMP-LocalStorageSecurity",
                   pluginSourceUrl = "https://github.com/GedMarc/JWebMP-LocalStorageSecurity",
                   pluginWikiUrl = "https://github.com/GedMarc/JWebMP-LocalStorageSecurity/wiki",
                   pluginOriginalHomepage = "https://github.com/GedMarc/JWebMP-LocalStorageSecurity",
                   pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins.security/jwebmp-plugins-local-storage-security",
                   pluginIconUrl = "",
                   pluginIconImageUrl = "",
                   pluginLastUpdatedDate = "2022/03/07",
                   pluginGroupId = "com.jwebmp.plugins.security",
                   pluginArtifactId = "jwebmp-plugins-local-storage-security",
                   pluginModuleName = "com.jwebmp.plugins.security.localstorage",
                   pluginStatus = PluginStatus.Released
)
@NgBootConstructorParameter("private socketClientService : SocketClientService")
@NgBootConstructorBody(value = "this.socketClientService.send('LocalStorage',{},'localStorage');", sortOrder = 5)
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
		//	page.getBody()
		//	    .addJavaScriptReference(PersistJS.getJavaScriptReference());
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
