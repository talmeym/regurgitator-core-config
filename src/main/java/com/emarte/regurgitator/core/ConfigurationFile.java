/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.core;

import java.io.IOException;
import java.util.Properties;
import java.util.ServiceLoader;

import static com.emarte.regurgitator.core.CacheProvider.Cache;
import static com.emarte.regurgitator.core.EntityLookup.configurationLoader;
import static com.emarte.regurgitator.core.FileUtil.getInputStreamForFile;
import static com.emarte.regurgitator.core.Log.getLog;

public final class ConfigurationFile {
    private static final Log log = getLog(ConfigurationFile.class);
    private static final ServiceLoader<ConfigPropertiesHandler> PROPERTIES_HANDLERS = ServiceLoader.load(ConfigPropertiesHandler.class);
    private static Exception initError;

    static {
        try {
            Properties properties = new Properties();

            try {
                log.debug("Loading regurgitator properties");
                properties.load(getInputStreamForFile("classpath:/regurgitator.properties"));
                log.debug("Loaded {} properties", properties.size());

                for(ConfigPropertiesHandler configPropertiesHandler : PROPERTIES_HANDLERS) {
                    configPropertiesHandler.handle(properties);
                }
            } catch(IOException ioe) {
                log.debug("Could not find regurgitator.properties '{}', continuing without properties", ioe.getMessage());
            }
        } catch (Exception e) {
            log.error("Error initialising regurgitator properties", e);
            initError = e;
        }
    }

    public static Step loadFile(String configFilePath) throws RegurgitatorException {
        if(initError != null) {
            if(initError instanceof RegurgitatorException) {
                throw (RegurgitatorException) initError;
            }

            throw new RegurgitatorException("Error initialising regurgitator properties", initError);
        }

        Cache<Step> cache = Caching.getCache(Step.class);

        if(cache.contains(configFilePath)) {
            log.debug("Found cached configuration for path '{}'", configFilePath);
            return cache.get(configFilePath);
        }

        log.debug("Loading configuration from '{}'", configFilePath);

        try {
            String suffix = configFilePath.substring(configFilePath.lastIndexOf(".") + 1);
            Step step = configurationLoader(suffix).load(getInputStreamForFile(configFilePath));
            log.debug("Add configuration to cache");
            cache.set(configFilePath, step);
            return step;
        } catch(RegurgitatorException re) {
            throw re;
        } catch(Exception e) {
            throw new RegurgitatorException("Error loading regurgitator configuration", e);
        }
    }
}

