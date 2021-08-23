package com.example.classschedule.Schedule;

import com.example.classschedule.User.User;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService implements CrudListener<Schedule> {

    private final ScheduleRepository repository;

    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Schedule> findAll(){
        return repository.findAll();
    }

    @Override
    public Schedule add(Schedule schedule){
        Optional<Schedule> scheduleOptional = repository.findExistDateAndSession(schedule.getName(), schedule.getSession(), schedule.getDate());
        if (scheduleOptional.isPresent()){
            throw new IllegalStateException("Schedule Taken");
        }
        else{
            return repository.save(schedule);
        }
    }

    @Override
    public Schedule update(Schedule schedule){
        Optional<Schedule> scheduleOptional = repository.findExistDateAndSession(schedule.getName(), schedule.getSession(), schedule.getDate());
        if (scheduleOptional.isPresent()){
            throw new IllegalStateException("Schedule Taken");
        }
        else{
            return repository.save(schedule);
        }
    }

    @Override
    public void delete(Schedule schedule){
        repository.delete(schedule);
    }

    public List<Schedule> findByName(String name){
        if (name.isEmpty()){
            return repository.findAll();
        } else {
            List<Schedule> scheduleList = repository.findByName(name);
            return scheduleList;
        }
    }

}
