/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.core;

import java.util.Set;

public interface Loader<DATA, RESULT> {
    RESULT load(DATA DATA, Set<Object> allIds) throws RegurgitatorException;
}
