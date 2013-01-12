// $Id: ClAbstractVariable.java,v 1.14 2001/04/02 14:43:24 gjb Exp $
//
// Cassowary Incremental Constraint Solver
// Original Smalltalk Implementation by Alan Borning
// This Java Implementation by Greg J. Badros, <gjb@cs.washington.edu>
// http://www.cs.washington.edu/homes/gjb
// (C) 1998, 1999 Greg J. Badros and Alan Borning
// See ../LICENSE for legal details regarding this software
//
// ClAbstractVariable

package org.klomp.cassowary;

public abstract class ClAbstractVariable {
    private String _name;

    private static int iVariableNumber;

    public ClAbstractVariable(String name) {
        _name = name;
        iVariableNumber++;
    }

    public ClAbstractVariable() {
        _name = "v" + iVariableNumber;
        iVariableNumber++;
    }

    public ClAbstractVariable(long varnumber, String prefix) {
        _name = prefix + varnumber;
        iVariableNumber++;
    }

    public String name() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public boolean isDummy() {
        return false;
    }

    public abstract boolean isExternal();

    public abstract boolean isPivotable();

    public abstract boolean isRestricted();

    @Override
    public abstract String toString();

    public static int numCreated() {
        return iVariableNumber;
    }

}
