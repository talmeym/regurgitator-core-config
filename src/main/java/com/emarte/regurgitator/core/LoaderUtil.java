/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.core;

import java.lang.reflect.Constructor;

@SuppressWarnings({"unchecked"})
abstract class LoaderUtil<DATA, TYPE extends Loader> {

    public abstract TYPE deriveLoader(DATA data) throws RegurgitatorException;

    abstract String deriveClass(DATA data) throws RegurgitatorException;

    abstract String deriveClass(String packageName, String className) throws RegurgitatorException;

    TYPE buildFromClass(String className) throws RegurgitatorException {
        try {
            Class clazz = Class.forName(className);
            Constructor constructor = clazz.getConstructor();
            Object object = constructor.newInstance();

            if (!(object instanceof Loader)) {
                throw new RegurgitatorException("Class '" + clazz + "' does not implement Loader");
            }

            return (TYPE) object;
        } catch (NoSuchMethodException e) {
            throw new RegurgitatorException("Class has no default constructor: " + className, e);
        } catch (ClassCastException e) {
            throw new RegurgitatorException("Class is not of correct type", e);
        } catch (ClassNotFoundException e) {
            throw new RegurgitatorException("Class not found: " + className);
        } catch (Exception e) {
            throw new RegurgitatorException("Exception calling constructor of class: " + className, e);
        }
    }
}
