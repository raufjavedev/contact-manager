package com.rj.view;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.rj.model.Contact;

import javax.swing.*;
import java.awt.*;

public class ContactFormView extends javax.swing.JDialog {

    /**
     * Creates new form ContactFormView
     * 
     * @param parent
     * @param modal
     */
    public ContactFormView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initStyles();
    }

    private void initStyles() {
        this.setLocationRelativeTo(null);
        lblId.setVisible(false);

        txtFirstName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingresa el nombre");
        txtFirstName.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON,
                new FlatSVGIcon(getClass().getResource("/person.svg")));

        txtLastname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingresa el apellido");
        txtLastname.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON,
                new FlatSVGIcon(getClass().getResource("/person.svg")));

        txtPhoneNumber.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingresa número de teléfono o celular");
        txtPhoneNumber.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON,
                new FlatSVGIcon(getClass().getResource("/smartphone.svg")));

        txtEmailAddress.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingresa correo electrónico");
        txtEmailAddress.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON,
                new FlatSVGIcon(getClass().getResource("/mail.svg")));

        txtAddress.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingresa Dirección de domicilio");
        txtAddress.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON,
                new FlatSVGIcon(getClass().getResource("/home.svg")));

        // Botones
        FlatSVGIcon save = new FlatSVGIcon(getClass().getResource("/save.svg"));
        FlatSVGIcon edit = new FlatSVGIcon(getClass().getResource("/edit.svg"));
        FlatSVGIcon close = new FlatSVGIcon(getClass().getResource("/close.svg"));

        btnSave.setIcon(save);
        btnedit.setIcon(edit);
        btnCancel.setIcon(close);

        btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnedit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtEmailAddress = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Título");

        txtFirstName.setText("Nombres");

        txtLastname.setText("Apellidos");

        txtPhoneNumber.setText("Teléfono / celular");

        txtEmailAddress.setText("Correo");

        txtAddress.setText("Dirección");

        btnSave.setText("Guardar");

        btnedit.setText("Editar");

        btnCancel.setText("Cancelar");

        lblId.setText("Id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtFirstName)
                                        .addComponent(txtLastname, javax.swing.GroupLayout.DEFAULT_SIZE, 309,
                                                Short.MAX_VALUE)
                                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 309,
                                                Short.MAX_VALUE)
                                        .addComponent(txtEmailAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 309,
                                                Short.MAX_VALUE)
                                        .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 309,
                                                Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblId)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnSave)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnedit)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnCancel)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addGap(18, 18, 18)
                                .addComponent(lblId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnSave))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(216, 216, 216)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnedit)
                                                        .addComponent(btnCancel))))
                                .addGap(0, 0, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContactFormView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContactFormView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContactFormView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContactFormView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContactFormView dialog = new ContactFormView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnSave;
    public javax.swing.JButton btnedit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables

    /**
     * Obtiene el ID del contacto
     * 
     * @return Id del contacto en número entero
     */
    public Long getContactId() {
        try {
            return Long.parseLong(lblId.getText());
        } catch (NumberFormatException e) {
            warningMessage("El Id no es número válido.");
        }
        return null;
    }

    /**
     * Obtiene el nombre del campo de texto
     * 
     * @return Nombre
     */
    public String getFirstName() {
        String firstName = txtFirstName.getText();
        if (firstName.isEmpty()) {
            warningMessage("El nombre no debe ser vacío.");
        }
        return firstName;
    }

    /**
     * Obtiene el apellido del campo de texto
     * 
     * @return Apellidos
     */
    public String getLastName() {
        String lastName = txtLastname.getText();
        if (lastName.isEmpty()) {
            warningMessage("El apellido no debe ser vacío.");
        }
        return lastName;
    }

    /**
     * Obtiene correo del campo de texto
     * 
     * @return Correo electrónico
     */
    public String getEmail() {
        String email = txtEmailAddress.getText();
        if (email.isEmpty()) {
            warningMessage("El correo no debe ser vacío.");
        } else if (!email.contains("@")) {
            warningMessage("Ingresa un correo válido.");
        }
        return email;
    }

    /**
     * Obtiene número telefónico del campo de texto
     * 
     * @return Número de teléfono o celular
     */
    public String getPhoneNumber() {
        String phoneNumber = txtPhoneNumber.getText();
        if (phoneNumber.isEmpty()) {
            warningMessage("Número de teléfono no debe ser vacío.");
        }
        return phoneNumber;
    }

    /**
     * Obtiene dirección del campo de texto
     * 
     * @return Número de teléfono o celular
     */
    public String getAddress() {
        String address = txtAddress.getText();
        if (address.isEmpty()) {
            warningMessage("Dirección no debe ser vacío.");
        }
        return address;
    }

    /**
     * Establece el título del formulario.
     * <p>
     * Actualiza el título mostrado en la interfaz de usuario para reflejar
     * el contexto actual del formulario.
     *
     * @param title El título a mostrar en el formulario.
     */
    public void setFormTitle(String title) {
        lblTitle.setText(title);
    }

    /**
     * Muestra los detalles de un contacto en el formulario según su ID.
     * <p>
     * Carga la información del contacto en los campos del formulario
     * para su visualización o edición.
     *
     * @param contact El contacto cuyos datos se mostrarán.
     */
    public void setContactById(Contact contact) {
        lblId.setText(String.valueOf(contact.getId()));
        txtFirstName.setText(contact.getFirstName());
        txtLastname.setText(contact.getLastName());
        txtEmailAddress.setText(contact.getEmail());
        txtPhoneNumber.setText(contact.getPhoneNumber());
        txtAddress.setText(contact.getAddress());
    }

    /**
     * Verifica si algún campo del formulario está vacío.
     * <p>
     * Recorre los campos del formulario y devuelve {@code true} si al menos uno
     * está vacío, o {@code false} si todos están completos.
     *
     * @return {@code true} si hay campos vacíos, {@code false} en caso contrario.
     */
    public boolean isFieldsEmpty() {
        return getFirstName().isEmpty()
                || getLastName().isEmpty()
                || getEmail().isEmpty()
                || getPhoneNumber().isEmpty()
                || getAddress().isEmpty();
    }

    /**
     * Limpia todos los campos del formulario.
     * <p>
     * Restablece los campos de entrada a su estado inicial,
     * eliminando cualquier dato ingresado previamente.
     */
    public void clearFields() {
        lblId.setText("");
        txtFirstName.setText("");
        txtLastname.setText("");
        txtEmailAddress.setText("");
        txtPhoneNumber.setText("");
        txtAddress.setText("");
    }

    // Mensajes
    public void successMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
    }

    public void warningMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.WARNING_MESSAGE);
    }

    public void errorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.ERROR_MESSAGE);
    }
}
