package com.emarte.regurgitator.core;

import static com.emarte.regurgitator.core.CacheProvider.Cache;
import static com.emarte.regurgitator.core.EntityLookup.configurationLoader;
import static com.emarte.regurgitator.core.FileUtil.getInputStreamForFile;

public class ConfigurationFile {
    private static final Log log = Log.getLog(ConfigurationFile.class);

    public static Step loadFile(String configFilePath) throws RegurgitatorException {
		Cache<Step> cache = Caching.getCache(Step.class);

		if(cache.contains(configFilePath)) {
			log.debug("Found cached configuration for path '" + configFilePath + "'");
			return cache.get(configFilePath);
		}

		log.debug("Loading configuration from '" + configFilePath + "'");

		try {
			String suffix = configFilePath.substring(configFilePath.lastIndexOf(".") + 1);
			Step step = configurationLoader(suffix).load(getInputStreamForFile(configFilePath));
			cache.set(configFilePath, step);
			return step;
		} catch(RegurgitatorException re) {
			throw re;
		} catch(Exception e) {
			throw new RegurgitatorException("Error loading regurgitator configuration", e);
		}
	}
}

