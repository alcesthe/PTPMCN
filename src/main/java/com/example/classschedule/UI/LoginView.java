package com.example.classschedule.UI;

import com.example.classschedule.User.UserService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route("")
public class LoginView extends VerticalLayout {

    public LoginView(UserService userService){

        Label header = new Label("LOGIN");
        TextField username_input = new TextField("Username");
        TextField password_input = new TextField("Password");
        Button login_btn = new Button("LOGIN");
        Label err_mess = new Label("NOT FOUND USER");
        err_mess.setVisible(false);

        login_btn.addClickListener(e -> {
            boolean isAuthenticated = userService.findExistUser(username_input.getValue(), password_input.getValue());
            if (isAuthenticated) {
                UI.getCurrent().navigate("/main");
            } else {
                err_mess.setVisible(true);
            }
        });

        setSizeFull();
        setAlignItems(Alignment.CENTER);
        add(header, username_input, password_input, login_btn, err_mess );
    }

}
