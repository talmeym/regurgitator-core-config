package com.emarte.regurgitator.core;

import java.util.Set;

public interface Loader<DATA, RESULT> {
    RESULT load(DATA DATA, Set<Object> allIds) throws RegurgitatorException;
}
