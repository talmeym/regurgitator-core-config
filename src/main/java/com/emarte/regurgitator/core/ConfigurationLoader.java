package com.emarte.regurgitator.core;

import java.io.InputStream;

public interface ConfigurationLoader {
	public Step load(InputStream input) throws RegurgitatorException;
}
