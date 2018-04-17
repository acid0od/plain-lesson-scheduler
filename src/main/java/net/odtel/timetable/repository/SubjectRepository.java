package net.odtel.timetable.repository;

import net.odtel.timetable.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Subject findOneByName(String name);
}
