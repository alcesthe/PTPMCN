package com.example.classschedule.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s WHERE s.name = ?1 and s.session = ?2 and s.date = ?3")
    Optional<Schedule> findExistDateAndSession(String name, String session, LocalDate date );

    @Query("SELECT s FROM Schedule s WHERE s.name like ?1%")
    List<Schedule> findByName(String name);

}
