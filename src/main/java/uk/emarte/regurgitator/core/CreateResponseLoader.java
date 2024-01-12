/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.core;

import java.util.List;

import static uk.emarte.regurgitator.core.ValueSourceLoader.loadValueSource;

abstract class CreateResponseLoader {
    Step buildCreateResponse(String id, String source, String value, String file, List<ValueProcessor> processors, Log log) throws RegurgitatorException {
        log.debug("Loaded create response '{}'", id);
        return new CreateResponse(id, loadValueSource(source, value, file), processors);
    }
}
