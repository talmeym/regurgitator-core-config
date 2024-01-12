/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.core;

import java.util.List;

import static uk.emarte.regurgitator.core.ValueSourceLoader.loadValueSource;

abstract class CreateParameterLoader {
    Step buildCreateParameter(String id, ParameterPrototype prototype, String context, String source, String value, String file, List<ValueProcessor> processors, Log log) throws RegurgitatorException {
        log.debug("Loaded create parameter '{}'", id);
        return new CreateParameter(id, prototype, context, loadValueSource(source, value, file), processors);
    }
}
