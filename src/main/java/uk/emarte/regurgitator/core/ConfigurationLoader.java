/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.core;

import java.io.InputStream;

public interface ConfigurationLoader {
    Step load(InputStream input) throws RegurgitatorException;
}
