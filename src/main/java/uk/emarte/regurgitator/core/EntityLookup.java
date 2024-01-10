/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.core;

import java.util.ServiceLoader;

public final class EntityLookup {
    private static final ServiceLoader<EntityPack> ENTITY_PACKS = ServiceLoader.load(EntityPack.class);

    static {
        Log log = Log.getLog(EntityLookup.class);

        for (EntityPack pack : ENTITY_PACKS) {
            log.debug("Loaded entity pack: " + pack.getClass().getName());
        }
    }

    public static boolean hasConditionBehaviour(String id) {
        return findConditionBehaviour(id) != null;
    }

    public static ConditionBehaviour conditionBehaviour(String id) throws RegurgitatorException {
        ConditionBehaviour entity = findConditionBehaviour(id);

        if (entity != null) {
            return entity;
        }

        throw new RegurgitatorException("Cannot load condition behaviour: " + id);
    }

    private static ConditionBehaviour findConditionBehaviour(String id) {
        for (EntityPack pack : ENTITY_PACKS) {
            ConditionBehaviour entity = pack.getConditionBehaviour(id);

            if (entity != null) {
                return entity;
            }
        }

        return null;
    }

    public static boolean hasConfigurationLoader(String id) {
        return findConfigurationLoader(id) != null;
    }

    public static ConfigurationLoader configurationLoader(String id) throws RegurgitatorException {
        ConfigurationLoader entity = findConfigurationLoader(id);

        if (entity != null) {
            return entity;
        }

        throw new RegurgitatorException("Cannot load configuration loader: " + id);
    }

    private static ConfigurationLoader findConfigurationLoader(String id) {
        for (EntityPack pack : ENTITY_PACKS) {
            ConfigurationLoader entity = pack.getConfigurationLoader(id);

            if (entity != null) {
                return entity;
            }
        }

        return null;
    }

    public static boolean hasParameterType(String id) {
        return findParameterType(id) != null;
    }

    public static ParameterType<?> parameterType(String id) throws RegurgitatorException {
        ParameterType<?> entity = findParameterType(id);

        if (entity != null) {
            return entity;
        }

        throw new RegurgitatorException("Cannot load parameter type: " + id);
    }

    private static ParameterType<?> findParameterType(String id) {
        for (EntityPack pack : ENTITY_PACKS) {
            ParameterType<?> entity = pack.getParameterType(id);

            if (entity != null) {
                return entity;
            }
        }

        return null;
    }

    public static boolean hasRulesBehaviour(String id) {
        return findRulesBehaviour(id) != null;
    }

    public static RulesBehaviour rulesBehaviour(String id) throws RegurgitatorException {
        RulesBehaviour entity = findRulesBehaviour(id);

        if (entity != null) {
            return entity;
        }

        throw new RegurgitatorException("Cannot load rules behaviour: " + id);
    }

    private static RulesBehaviour findRulesBehaviour(String id) {
        for (EntityPack pack : ENTITY_PACKS) {
            RulesBehaviour entity = pack.getRulesBehaviour(id);

            if (entity != null) {
                return entity;
            }
        }

        return null;
    }

    public static boolean hasValueBuilder(String id) {
        return findValueBuilder(id) != null;
    }

    public static ValueBuilder valueBuilder(String id) throws RegurgitatorException {
        ValueBuilder entity = findValueBuilder(id);

        if (entity != null) {
            return entity;
        }

        throw new RegurgitatorException("Cannot load value builder: " + id);
    }

    private static ValueBuilder findValueBuilder(String id) {
        for (EntityPack pack : ENTITY_PACKS) {
            ValueBuilder entity = pack.getValueBuilder(id);

            if (entity != null) {
                return entity;
            }
        }

        return null;
    }

    public static boolean hasValueGenerator(String id) {
        return findValueGenerator(id) != null;
    }

    public static ValueGenerator valueGenerator(String id) throws RegurgitatorException {
        ValueGenerator entity = findValueGenerator(id);

        if (entity != null) {
            return entity;
        }

        throw new RegurgitatorException("Cannot load value generator: " + id);
    }

    private static ValueGenerator findValueGenerator(String id) {
        for (EntityPack pack : ENTITY_PACKS) {
            ValueGenerator entity = pack.getValueGenerator(id);

            if (entity != null) {
                return entity;
            }
        }

        return null;
    }

    public static boolean hasValueProcessor(String id) {
        return findValueProcessor(id) != null;
    }

    public static ValueProcessor valueProcessor(String id) throws RegurgitatorException {
        ValueProcessor entity = findValueProcessor(id);

        if (entity != null) {
            return entity;
        }

        throw new RegurgitatorException("Cannot load value processor: " + id);
    }

    private static ValueProcessor findValueProcessor(String id) {
        for (EntityPack pack : ENTITY_PACKS) {
            ValueProcessor entity = pack.getValueProcessor(id);

            if (entity != null) {
                return entity;
            }
        }

        return null;
    }
}
