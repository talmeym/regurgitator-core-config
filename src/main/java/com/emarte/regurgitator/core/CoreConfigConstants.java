package com.emarte.regurgitator.core;

public interface CoreConfigConstants {
	public static final String ID = "id";
    public static final String SOURCE = "source";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String GENERATOR = "generator";
    public static final String MERGE = "merge";
    public static final String BUILDER = "builder";
	public static final String PROCESSOR = "processor";
    public static final String VALUE = "value";
    public static final String FILE = "file";

	// decision
    public static final String RULES = "rules";
    public static final String STEPS = "steps";
    public static final String RULE = "rule";
    public static final String STEP = "step";
    public static final String CONDITION = "condition";
	public static final String BEHAVIOUR = "behaviour";
	public static final String EXPECTATION = "expectation";
    public static final String DEFAULT_STEP = "default-step";

	// extract
	public static final String FORMAT = "format";
	public static final String INDEX = "index";

	// substitute
	public static final String TOKEN = "token";
	public static final String REPLACEMENT = "replacement";

	// number generator
	public static final String MAX = "max";

	// index-of-processor
	public static final String LAST = "last";
}
