package net.odtel.timetable.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    private long id;

    private String name;

    private int credits;


}
