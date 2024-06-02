package com.jwebmp.plugins.security.localstorage.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;

import java.util.HashSet;
import java.util.Set;

public class LocalStorageInclusionModule implements IGuiceScanModuleInclusions<LocalStorageInclusionModule>
{
    @Override
    public Set<String> includeModules()
    {
        Set<String> set = new HashSet<>();
        set.add("com.jwebmp.plugins.security.localstorage");
        return set;
    }
}
