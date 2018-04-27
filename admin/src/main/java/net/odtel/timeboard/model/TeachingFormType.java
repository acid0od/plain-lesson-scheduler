/* ===========================================================================
 * Copyright (c) 2015 Comcast Corp. All rights reserved.
 * ===========================================================================
 *
 * Author: Alexander Ievstratiev
 * Created: 04/26/2018  5:45 PM
 */
package net.odtel.timeboard.model;

public enum TeachingFormType {
    LECTURE("lecture"),
    PRACTICAL("practical"),
    LABORATORYWORK("laboratoryWork"),
    COURSEWORK("courseWork"),
    EXAM("exam"),
    CREDIT("credit");

    private String name;

    TeachingFormType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
