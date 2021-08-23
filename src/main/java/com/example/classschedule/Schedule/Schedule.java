package com.example.classschedule.Schedule;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", session='" + session + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Id
    @SequenceGenerator(
            name = "schedule_sequence",
            sequenceName = "schedule_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "schedule_sequence"
    )
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "owner")
    private String owner;

    @NotNull
    @Column(name = "session")
    private String session;

    public Schedule() {

    }

    public Schedule(Long id, String name, String owner, String session, LocalDate date) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.session = session;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(id, schedule.id) && Objects.equals(name, schedule.name) && Objects.equals(owner, schedule.owner) && Objects.equals(session, schedule.session) && Objects.equals(date, schedule.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, session, date);
    }
}
