package com.emarte.regurgitator.core;

import static com.emarte.regurgitator.core.Caching.Cache;
import static com.emarte.regurgitator.core.EntityLookup.configurationLoader;
import static com.emarte.regurgitator.core.FileUtil.getInputStreamForFile;

public class ConfigurationFile {
    private static final Log log = Log.getLog(ConfigurationFile.class);

    public static Step loadFile(String configFilePath) throws RegurgitatorException {
		Cache cache = Caching.getCache(ConfigurationFile.class);

		if(cache.hasValue(configFilePath)) {
			log.debug("Found cached configuration for path '" + configFilePath + "'");
			return (Step) cache.getValue(configFilePath);
		}

		log.debug("Loading configuration from '" + configFilePath + "'");

		try {
			String suffix = configFilePath.substring(configFilePath.lastIndexOf(".") + 1);
			Step step = configurationLoader(suffix).load(getInputStreamForFile(configFilePath));
			cache.setValue(configFilePath, step);
			return step;
		} catch(RegurgitatorException re) {
			throw re;
		} catch(Exception e) {
			throw new RegurgitatorException("Error loading regurgitator configuration", e);
		}
	}
}

