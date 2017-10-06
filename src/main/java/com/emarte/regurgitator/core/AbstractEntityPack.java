/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.core;

import java.util.*;

public class AbstractEntityPack implements EntityPack {
    private final Map<String, ConditionBehaviour> CONDITION_BEHAVIOURS = new HashMap<String, ConditionBehaviour>();
    private final Map<String, ConfigurationLoader> CONFIGURATION_LOADERS = new HashMap<String, ConfigurationLoader>();
    private final Map<String, ParameterType> PARAMETER_TYPES = new HashMap<String, ParameterType>();
    private final Map<String, RulesBehaviour> RULES_BEHAVIOURS = new HashMap<String, RulesBehaviour>();
    private final Map<String, ValueBuilder> VALUE_BUILDERS = new HashMap<String, ValueBuilder>();
    private final Map<String, ValueGenerator> VALUE_GENERATORS = new HashMap<String, ValueGenerator>();
    private final Map<String, ValueProcessor> VALUE_PROCESSORS = new HashMap<String, ValueProcessor>();

    protected void addConditionBehaviour(String code, ConditionBehaviour conditionBehaviour) {
        CONDITION_BEHAVIOURS.put(code, conditionBehaviour);
    }

    @Override
    public ConditionBehaviour getConditionBehaviour(String id) {
        return CONDITION_BEHAVIOURS.get(id);
    }

    protected void addConfigurationLoader(String code, ConfigurationLoader configurationLoader) {
        CONFIGURATION_LOADERS.put(code, configurationLoader);
    }

    @Override
    public ConfigurationLoader getConfigurationLoader(String id) {
        return CONFIGURATION_LOADERS.get(id);
    }

    protected void addParameterType(String code, ParameterType parameterType) {
        PARAMETER_TYPES.put(code, parameterType);
    }

    @Override
    public ParameterType getParameterType(String id) {
        return PARAMETER_TYPES.get(id);
    }

    protected void addRulesBehaviour(String code, RulesBehaviour rulesBehaviour) {
        RULES_BEHAVIOURS.put(code, rulesBehaviour);
    }

    @Override
    public RulesBehaviour getRulesBehaviour(String id) {
        return RULES_BEHAVIOURS.get(id);
    }

    protected void addValueBuilder(String code, ValueBuilder valueBuilder) {
        VALUE_BUILDERS.put(code, valueBuilder);
    }

    @Override
    public ValueBuilder getValueBuilder(String id) {
        return VALUE_BUILDERS.get(id);
    }

    protected void addValueGenerator(String code, ValueGenerator valueGenerator) {
        VALUE_GENERATORS.put(code, valueGenerator);
    }

    @Override
    public ValueGenerator getValueGenerator(String id) {
        return VALUE_GENERATORS.get(id);
    }

    protected void addValueProcessor(String code, ValueProcessor valueProcessor) {
        VALUE_PROCESSORS.put(code, valueProcessor);
    }

    @Override
    public ValueProcessor getValueProcessor(String id) {
        return VALUE_PROCESSORS.get(id);
    }
}
