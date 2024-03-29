/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.core;

import java.util.Properties;

public interface ConfigPropertiesHandler {
    void handle(Properties properties) throws RegurgitatorException;
}
