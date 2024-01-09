/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.core;

import java.io.IOException;
import java.util.List;

import static uk.emarte.regurgitator.core.FileUtil.getInputStreamForFile;
import static uk.emarte.regurgitator.core.FileUtil.streamToString;

abstract class CreateResponseLoader {
    Step buildCreateResponse(String id, String source, String value, String file, List<ValueProcessor> processors, Log log) throws RegurgitatorException {
        int numberSet = 0;
        numberSet += source != null ? 1 : 0;
        numberSet += value != null ? 1 : 0;
        numberSet += file != null ? 1 : 0;

        if(numberSet == 0) {
            throw new RegurgitatorException("Source, value or file is required");
        }

        if(value != null && file != null) {
            throw new RegurgitatorException("Value and file not both allowed");
        }

        if(file != null) {
            try {
                value = streamToString(getInputStreamForFile(file));
            } catch (IOException e) {
                throw new RegurgitatorException("Error loading file: " + file, e);
            }
        }

        ContextLocation location = source != null ? new ContextLocation(source) : null;
        log.debug("Loaded create response '{}'", id);
        return new CreateResponse(id, new ValueSource(location, value), processors);
    }
}
