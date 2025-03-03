package com.rj.main;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.rj.controller.ContactController;
import com.rj.service.impl.ContactServiceImpl;
import com.rj.view.ContactFormView;
import com.rj.view.MainView;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.rj.service.ContactService;

/**
 * Clase principal de la aplicación.
 * <p>
 * Inicializa la aplicación y configura los componentes necesarios
 * para la gestión de contactos a través de la API.
 */
public class Main {

    public static void main(String[] args) {
        // Configura el tema visual de la aplicación con FlatLaf.
        try {
            UIManager.setLookAndFeel(new FlatArcDarkIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Failed to initialize LaF" + e);
        }

        // Vistas
        MainView mainView = new MainView();
        ContactFormView contactFormView = new ContactFormView(mainView, true);

        // Servicios
        ContactService contactService = new ContactServiceImpl();

        new ContactController(contactService, mainView, contactFormView);

        mainView.setVisible(true);
    }
}
