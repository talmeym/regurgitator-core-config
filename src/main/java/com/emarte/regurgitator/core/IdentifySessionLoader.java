/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.core;

import static com.emarte.regurgitator.core.ValueSourceLoader.loadValueSource;

abstract class IdentifySessionLoader {
    Step buildIdentifySession(String id, String source, String value, Log log) throws RegurgitatorException {
        log.debug("Loaded identify session '{}'", id);
        return new IdentifySession(id, loadValueSource(source, value));
    }
}
