/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.core;

import java.util.HashMap;
import java.util.Map;

public class AbstractEntityPack implements EntityPack {
    private final Map<String, ConditionBehaviour> CONDITION_BEHAVIOURS = new HashMap<>();
    private final Map<String, ConfigurationLoader> CONFIGURATION_LOADERS = new HashMap<>();
    private final Map<String, ParameterType<?>> PARAMETER_TYPES = new HashMap<>();
    private final Map<String, RulesBehaviour> RULES_BEHAVIOURS = new HashMap<>();
    private final Map<String, ValueBuilder> VALUE_BUILDERS = new HashMap<>();
    private final Map<String, ValueGenerator> VALUE_GENERATORS = new HashMap<>();
    private final Map<String, ValueProcessor> VALUE_PROCESSORS = new HashMap<>();

    protected void addConditionBehaviour(String code, ConditionBehaviour behaviour) {
        CONDITION_BEHAVIOURS.put(code, behaviour);
    }

    @Override
    public ConditionBehaviour getConditionBehaviour(String id) {
        return CONDITION_BEHAVIOURS.get(id);
    }

    protected void addConfigurationLoader(String code, ConfigurationLoader loader) {
        CONFIGURATION_LOADERS.put(code, loader);
    }

    @Override
    public ConfigurationLoader getConfigurationLoader(String id) {
        return CONFIGURATION_LOADERS.get(id);
    }

    protected void addParameterType(String code, ParameterType<?> type) {
        PARAMETER_TYPES.put(code, type);
    }

    @Override
    public ParameterType<?> getParameterType(String id) {
        return PARAMETER_TYPES.get(id);
    }

    protected void addRulesBehaviour(String code, RulesBehaviour behaviour) {
        RULES_BEHAVIOURS.put(code, behaviour);
    }

    @Override
    public RulesBehaviour getRulesBehaviour(String id) {
        return RULES_BEHAVIOURS.get(id);
    }

    protected void addValueBuilder(String code, ValueBuilder builder) {
        VALUE_BUILDERS.put(code, builder);
    }

    @Override
    public ValueBuilder getValueBuilder(String id) {
        return VALUE_BUILDERS.get(id);
    }

    protected void addValueGenerator(String code, ValueGenerator generator) {
        VALUE_GENERATORS.put(code, generator);
    }

    @Override
    public ValueGenerator getValueGenerator(String id) {
        return VALUE_GENERATORS.get(id);
    }

    protected void addValueProcessor(String code, ValueProcessor processor) {
        VALUE_PROCESSORS.put(code, processor);
    }

    @Override
    public ValueProcessor getValueProcessor(String id) {
        return VALUE_PROCESSORS.get(id);
    }
}
