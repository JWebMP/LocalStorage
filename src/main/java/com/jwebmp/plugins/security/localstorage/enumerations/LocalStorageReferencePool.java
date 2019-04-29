package com.jwebmp.plugins.security.localstorage.enumerations;

import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;

public enum LocalStorageReferencePool
{
	PersistJS(new JavascriptReference("PersistJS", 1.0, "persist-js/persist-min.js", -10).setPriority(RequirementsPriority.Top_Shelf));
	private final JavascriptReference reference;

	LocalStorageReferencePool(JavascriptReference reference)
	{
		this.reference = reference;
	}

	public JavascriptReference getJavaScriptReference()
	{
		return reference;
	}
}
