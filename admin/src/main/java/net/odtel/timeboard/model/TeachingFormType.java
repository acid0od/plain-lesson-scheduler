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
    LECTURE("lecture"),
    PRACTICAL("practical"),
    LABORATORYWORK("laboratoryWork"),
    COURSEWORK("courseWork"),
    EXAM("exam"),
    CREDIT("credit");

    private String codeName;

    TeachingFormType(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeName() {
        return codeName;
    }

    public static TeachingFormType findByCodeName(String name) {
        for (TeachingFormType v : values()) {
            log.info("v={}", v.getCodeName());
            if (v.getCodeName().equals(name)) {
                return v;
            }
        }
        return null;
    }
}
