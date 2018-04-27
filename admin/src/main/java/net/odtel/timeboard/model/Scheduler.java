/* ===========================================================================
 * Copyright (c) 2015 Comcast Corp. All rights reserved.
 * ===========================================================================
 *
 * Author: Alexander Ievstratiev
 * Created: 04/23/2018  4:42 PM
 */
package net.odtel.timeboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scheduler {

    @PrimaryKey
    private UUID id;

    @Column("subject_name")
    private String subjectName;

    @Column("subject_type")
    private String subjectType;

    private int semester;
    private int week;
    private int hours;

}
