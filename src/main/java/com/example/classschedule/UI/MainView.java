package com.example.classschedule.UI;

import com.example.classschedule.Schedule.Schedule;
import com.example.classschedule.Schedule.ScheduleService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.impl.field.provider.ComboBoxProvider;

import java.util.Arrays;
import java.util.List;

@Route("/main")
public class MainView extends VerticalLayout {

    public MainView(ScheduleService service) {
        GridCrud<Schedule> crud = new GridCrud<>(Schedule.class, service);

        TextField filter = new TextField();
        filter.setPlaceholder("Filter by Name");
        filter.setClearButtonVisible(true);
        crud.getCrudLayout().addFilterComponent(filter);

//        Button searchBtn = new Button("Search");
//        crud.getCrudLayout().addFilterComponent(searchBtn);

        // Grid Config
        crud.getGrid().setColumns("name","owner","session","date");
        crud.getGrid().setColumnReorderingAllowed(true);

        // Form Config
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.getCrudFormFactory().setVisibleProperties(
                CrudOperation.ADD,
                "name","owner","session","date"
        );
        crud.getCrudFormFactory().setVisibleProperties(
                "name","owner","session","date"
        );

        List<String> sessionList = Arrays.asList("DAY", "EVENING");
        crud.getCrudFormFactory().setFieldProvider("session",new ComboBoxProvider<>(sessionList));

        // Layout Config
        setSizeFull();
        add(crud);

        // Logic
        crud.setOperations(
                () -> service.findByName(filter.getValue()),
                schedule -> service.add(schedule),
                schedule -> service.update(schedule),
                schedule -> service.delete(schedule)
        );

        filter.addValueChangeListener(e -> crud.refreshGrid());
    }

}
