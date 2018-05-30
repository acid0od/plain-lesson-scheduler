/* ===========================================================================
 * Copyright (c) 2015 Comcast Corp. All rights reserved.
 * ===========================================================================
 *
 * Author: Alexander Ievstratiev
 * Created: 04/26/2018  5:45 PM
 */
package net.odtel.timeboard.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum TeachingFormType {
    LECTURE(0),
    PRACTICAL(1),
    LABORATORYWORK(2),
    COURSEWORK(3),
    EXAM(4),
    CREDIT(5);

    private int codeName;

    TeachingFormType(int codeName) {
        this.codeName = codeName;
    }

    public int getCodeName() {
        return codeName;
    }

    public static TeachingFormType findByCodeName(int name) {
        for (TeachingFormType v : values()) {
            if (v.getCodeName() == name) {
                return v;
            }
        }
        return null;
    }
}
