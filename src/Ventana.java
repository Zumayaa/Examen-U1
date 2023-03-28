import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Ventana extends JFrame {//hola
    public JPanel panel = null;

    private String anterior = "cargaPantalla";
    private String actual = "cargaPantalla";

    private String bienvenidonombre;
    private JComboBox<String> seleccionar = new JComboBox<String>();
    private String email = "";

    ImageIcon logoEmpresa = new ImageIcon("cactus-company.png");


    public Ventana(){

        this.setVisible(true);
        this.setSize(600,700);
        this.setTitle("Cactu's Corporation");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#CAE9DA"));
        this.setLayout(null);
        this.setResizable(false);

        setIconImage(logoEmpresa.getImage());


        limpiarVentana();

        this.add(panel);

        this.repaint();
        this.revalidate();
    }

    public void limpiarVentana(){

        if(panel!= null) {
            this.remove(panel);
        }

        if(actual.equals("cargaPantalla")){
            panel = cargaPantalla();

            this.add(panel);

            this.repaint();
            this.revalidate();
        }

        if(actual.equals("login")){
            panel = login();

            this.add(panel);

            this.repaint();
            this.revalidate();
        }

        if(actual.equals("menu")){
            panel = menupanel();

            this.add(panel);

            this.repaint();
            this.revalidate();
        }

        if(actual.equals("micuenta")){
            panel = miCuenta();

            this.add(panel);

            this.repaint();
            this.revalidate();
        }

        if(actual.equals("editarCuenta")){
            panel = editarCuenta();

            this.add(panel);

            this.repaint();
            this.revalidate();
        }

        if(actual.equals("crearcuenta")){
            panel = crearCuenta();

            this.add(panel);

            this.repaint();
            this.revalidate();
        }

        if(actual.equals("listaUsers")){
            panel = listaUsuarios();

            this.add(panel);

            this.repaint();
            this.revalidate();
        }

        if(actual.equals("ayuda")){
            panel = ayuda();

            this.add(panel);

            this.repaint();
            this.revalidate();
        }
    }

    public JPanel cargaPantalla(){
        anterior = actual;
        actual = "cargaPantalla";

        JPanel cargaPanel = new JPanel();
        cargaPanel.setSize(600, 700);
        cargaPanel.setLocation(0, 0);
        cargaPanel.setLayout(null);
        cargaPanel.setBackground(Color.decode("#95E799"));

        JLabel bienvenido = new JLabel("Powered by Ramses & Zumaya",JLabel.CENTER);
        bienvenido.setFont(new Font("Arial",Font.BOLD,15));
        bienvenido.setSize(500,100);
        bienvenido.setLocation(40,550);
        bienvenido.setForeground(Color.decode("#0C7F11"));
        cargaPanel.add(bienvenido);

        JLabel cactus = new JLabel("Cactu's Corporation",JLabel.CENTER);
        cactus.setFont(new Font("Dialog",Font.BOLD,35));
        cactus.setSize(500,100);
        cactus.setLocation(50,100);
        cactus.setForeground(Color.decode("#0C7F11"));
        cargaPanel.add(cactus);

        JProgressBar barra = new JProgressBar(0,100);
        barra.setSize(700,20);
        barra.setLocation(0,641);
        barra.setForeground(Color.decode("#00C808"));
        cargaPanel.add(barra);

        JButton iniciar = new JButton("Iniciar sesión");
        iniciar.setSize(200,50);
        iniciar.setLocation(195,200);
        iniciar.setVisible(false);
        iniciar.setBackground(Color.decode("#005F04"));
        iniciar.setForeground(Color.white);
        iniciar.setBorder(null);
        iniciar.setFont(new Font("Arial", Font.BOLD, 20));
        cargaPanel.add(iniciar);

        this.add(cargaPanel);

        JLabel imagen = new JLabel();
        imagen.setSize(100,100);
        ImageIcon imag = new ImageIcon("cactus-logo.png");
        Icon icono = new ImageIcon (imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icono);
        imagen.setLocation(240,460);
        cargaPanel.add(imagen);

        try {
            for(int i = 0; i<=100;i++) {
                Thread.sleep(10);
                barra.setValue(i);
            }
        }catch(Exception e) {

        }
        if(barra.getValue() == 100) {
            iniciar.setVisible(true);
            iniciar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    anterior = actual;
                    actual = "login";
                    limpiarVentana();

                    repaint();
                    revalidate();
                }

            });

        }
        return cargaPanel;
    }
    //LOGIN---------------------------------------------------------------------------
    public JPanel login(){
        anterior = actual;
        actual = "login";

        JPanel loginPanel = new JPanel();
        loginPanel.setSize(600, 700);
        loginPanel.setLocation(0, 0);
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.decode("#95E799"));

        JLabel imagen = new JLabel();
        imagen.setSize(80,80);
        ImageIcon imag = new ImageIcon("cactus-logo.png");
        Icon icono = new ImageIcon (imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icono);
        imagen.setLocation(240,540);
        loginPanel.add(imagen);

        JLabel imagen2 = new JLabel();
        imagen2.setSize(210,210);
        ImageIcon imag2 = new ImageIcon("cactus-login.png");
        Icon icono2 = new ImageIcon (imag2.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_DEFAULT));
        imagen2.setIcon(icono2);
        imagen2.setLocation(175,35);
        loginPanel.add(imagen2);

        JLabel panel = new JLabel("Inicio de sesión",JLabel.CENTER);
        panel.setFont(new Font("Arial",Font.BOLD,35));
        panel.setSize(300,80);
        panel.setLocation(130,10);
        panel.setForeground(Color.decode("#005F04"));
        loginPanel.add(panel);

        JLabel user = new JLabel("Ingresa tu nombre de usuario",JLabel.CENTER);
        user.setFont(new Font("Arial",Font.BOLD,15));
        user.setSize(300,80);
        user.setLocation(100,200);
        user.setForeground(Color.decode("#005F04"));
        loginPanel.add(user);

        JTextField username = new JTextField();
        username.setSize(270,42);
        username.setLocation(142,260);
        loginPanel.add(username);

        JLabel pass = new JLabel("Ingresa tu contraseña",JLabel.CENTER);
        pass.setFont(new Font("Arial",Font.BOLD,15));
        pass.setSize(260,80);
        pass.setLocation(93,300);
        pass.setForeground(Color.decode("#005F04"));
        loginPanel.add(pass);

        JPasswordField contrasena = new JPasswordField();
        contrasena.setSize(270,42);
        contrasena.setLocation(142,350);
        loginPanel.add(contrasena);

        JButton acceder = new JButton("Acceder");
        acceder.setSize(150,30);
        acceder.setLocation(205,410);
        acceder.setBackground(Color.decode("#005F04"));
        acceder.setForeground(Color.white);
        acceder.setBorder(null);
        acceder.setFont(new Font("Arial", Font.BOLD, 20));
        loginPanel.add(acceder);

        JButton cancelarBorrar = new JButton("Borrar todo");
        cancelarBorrar.setSize(100,30);
        cancelarBorrar.setLocation(230,460);
        cancelarBorrar.setBackground(Color.decode("#FF0000"));
        cancelarBorrar.setForeground(Color.white);
        cancelarBorrar.setBorder(null);
        loginPanel.add(cancelarBorrar);

        cancelarBorrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                contrasena.setText("");

            }

        });

        acceder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                email = username.getText();
                String pwd = new String (contrasena.getPassword());

                BufferedReader reader;
                Boolean flag = false;

                try{
                    //  FileReader file = new FileReader("src\\users.txt");
                    FileReader file = new FileReader("C:\\Users\\Public\\Documents\\Tareas\\Examen-U1\\src\\users.txt");
                    reader = new BufferedReader(file);
                    String line = reader.readLine();

                    while(line != null) {
                        String data[] = line.split(",");
                        System.out.println(data[2]);
                        if(email.equals(data[2])) {
                            if(pwd.equals(data[3])) {
                                flag = true;
                                bienvenidonombre = data[0];
                            }
                        }

                        line = reader.readLine();
                    }
                    if(flag) {
                        System.out.println("entra");
                        anterior = actual;
                        actual = "menu";
                        limpiarVentana();

                        repaint();
                        revalidate();

                    }else
                        JOptionPane.showMessageDialog(null,"No puede entrar","ERROR", JOptionPane.INFORMATION_MESSAGE);
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }

        });

        return loginPanel;
    }

    //MENU PRINCIPAL---------------------------------------------------------------------
    public JPanel menupanel(){
        anterior = actual;
        actual = "menu";

        JPanel menu = new JPanel();
        menu.setSize(600,700);
        menu.setLocation(0,0);
        menu.setLayout(null);
        menu.setBackground(Color.decode("#95E799"));

        JLabel bienvenido = new JLabel("Bienvenido " + bienvenidonombre + "!");
        bienvenido.setSize(400,30);
        bienvenido.setFont(new Font("Arial", Font.BOLD, 30));
        bienvenido.setForeground(Color.decode("#005F04"));
        bienvenido.setLocation(170,50);
        menu.add(bienvenido);

        JLabel imagen = new JLabel();
        imagen.setSize(180,180);
        ImageIcon imag = new ImageIcon("cactus-welcome.png");
        Icon icono = new ImageIcon (imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icono);
        imagen.setLocation(190,150);
        menu.add(imagen);

        JLabel imagen2 = new JLabel();
        imagen2.setSize(90,90);
        ImageIcon imag2 = new ImageIcon("cactus-logo.png");
        Icon icono2 = new ImageIcon (imag2.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_DEFAULT));
        imagen2.setIcon(icono2);
        imagen2.setLocation(235,500);
        menu.add(imagen2);

        JMenuBar menuBar = new JMenuBar();
        JMenu cuenta = new JMenu("Cuenta");
        JMenu usuarios = new JMenu("Usuarios");
        JMenu ayuda = new JMenu("Ayuda");
        menuBar.add(cuenta);
        menuBar.add(usuarios);
        menuBar.add(ayuda);

        JMenuItem micuenta = new JMenuItem("Mi cuenta");
        JMenuItem cerrasesi = new JMenuItem("Cerrar sesión");
        cuenta.add(cerrasesi);
        cuenta.add(micuenta);

        JMenuItem listausu = new JMenuItem("Lista de usuarios");
        JMenuItem crearusu = new JMenuItem("Crear Usuario");
        usuarios.add(listausu);
        usuarios.add(crearusu);

        JMenuItem comocrear = new JMenuItem("¿Como crear usuarios?");
        ayuda.add(comocrear);

        this.setJMenuBar(menuBar);

        cerrasesi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int op = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Cerrar sesión",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

                if(op==JOptionPane.YES_OPTION) {
                    setJMenuBar(null);
                    anterior = actual;
                    actual = "login";
                    limpiarVentana();

                    repaint();
                    revalidate();
                }

            }

        });

        micuenta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                anterior = actual;
                actual = "micuenta";
                limpiarVentana();
            }

        });

        crearusu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                anterior = actual;
                actual = "crearcuenta";
                limpiarVentana();

            }
        });



        listausu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                anterior = actual;
                actual = "listaUsers";
                limpiarVentana();
            }

        });

        comocrear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                anterior = actual;
                actual = "ayuda";
                limpiarVentana();

                repaint();
                revalidate();
            }
        });
        return menu;

    }
    //MI CUENTA------------------------------------------------------------------------------
    public JPanel miCuenta(){
        anterior = actual;
        actual = "micuenta";

        JPanel miCuenta = new JPanel();
        miCuenta.setSize(600, 700);
        miCuenta.setLocation(0, 0);
        miCuenta.setLayout(null);
        miCuenta.setBackground(Color.decode("#95E799"));

        JLabel inicia = new JLabel("Mi cuenta",JLabel.CENTER);
        inicia.setFont(new Font("Arial",Font.BOLD,35));
        inicia.setSize(300,80);
        inicia.setLocation(135,10);
        inicia.setForeground(Color.decode("#005F04"));
        miCuenta.add(inicia);

        JLabel nameRegistrar = new JLabel("Ingresa tu nombre",JLabel.CENTER);
        nameRegistrar.setFont(new Font("Arial",Font.BOLD,15));
        nameRegistrar.setSize(300,80);
        nameRegistrar.setLocation(25,165);
        nameRegistrar.setForeground(Color.decode("#005F04"));
        miCuenta.add(nameRegistrar);

        JTextField nombreRegistrar = new JTextField();
        nombreRegistrar.setSize(200,43);
        nombreRegistrar.setLocation(80,220);
        miCuenta.add(nombreRegistrar);

        JLabel apellidoRegistrar = new JLabel("Ingresa tu apellido",JLabel.CENTER);
        apellidoRegistrar.setFont(new Font("Arial",Font.BOLD,15));
        apellidoRegistrar.setSize(300,80);
        apellidoRegistrar.setLocation(235,165);
        apellidoRegistrar.setForeground(Color.decode("#005F04"));
        miCuenta.add(apellidoRegistrar);

        JTextField apeRegistrar = new JTextField();
        apeRegistrar.setSize(200,43);
        apeRegistrar.setLocation(290,220);
        miCuenta.add(apeRegistrar);

        JLabel emailRegistrar = new JLabel("Correo electrónico",JLabel.CENTER);
        emailRegistrar.setFont(new Font("Arial",Font.BOLD,15));
        emailRegistrar.setSize(280,80);
        emailRegistrar.setLocation(80,250);
        emailRegistrar.setForeground(Color.decode("#005F04"));
        miCuenta.add(emailRegistrar);

        JTextField correoRegistrar = new JTextField();
        correoRegistrar.setSize(280,43);
        correoRegistrar.setLocation(150,300);
        miCuenta.add(correoRegistrar);

        JLabel passRegistrar = new JLabel("Contraseña",JLabel.CENTER);
        passRegistrar.setFont(new Font("Arial",Font.BOLD,15));
        passRegistrar.setSize(260,80);
        passRegistrar.setLocation(65,330);
        passRegistrar.setForeground(Color.decode("#005F04"));
        miCuenta.add(passRegistrar);

        JPasswordField contraseñaRegistrar = new JPasswordField();
        contraseñaRegistrar.setSize(280,43);
        contraseñaRegistrar.setLocation(150,380);
        miCuenta.add(contraseñaRegistrar);

        JButton accederRegistrar = new JButton("Actualizar datos");
        accederRegistrar.setSize(190,30);
        accederRegistrar.setLocation(195,445);
        accederRegistrar.setBackground(Color.decode("#005F04"));
        accederRegistrar.setForeground(Color.white);
        accederRegistrar.setBorder(null);
        accederRegistrar.setFont(new Font("Arial", Font.BOLD, 20));
        miCuenta.add(accederRegistrar);

        accederRegistrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any fields are empty
                if (nombreRegistrar.getText().isEmpty() || apeRegistrar.getText().isEmpty() || correoRegistrar.getText().isEmpty() || contraseñaRegistrar.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Debes de modificar todos los datos para poder continuar", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    File file = new File("C:\\Users\\Public\\Documents\\Tareas\\Examen-U1\\src\\users.txt" );
                    if (file.exists()) {
                        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

                        String newEmail = correoRegistrar.getText();
                        for (String linea : lines) {
                            String[] parts = linea.split(",");
                            if (parts.length >= 3 && parts[2].equals(newEmail)) {
                                JOptionPane.showMessageDialog(null, "El correo ingresado ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }

                        int index = -1;
                        for (int i = 0; i < lines.size(); i++) {
                            String[] parts = lines.get(i).split(",");
                            if (parts.length >= 3 && parts[2].equals(email)) {
                                index = i;
                                break;
                            }
                        }

                        if (index >= 0) {
                            String[] parts = lines.get(index).split(",");
                            parts[0] = nombreRegistrar.getText();
                            parts[1] = apeRegistrar.getText();
                            parts[2] = correoRegistrar.getText();
                            parts[3] = new String(contraseñaRegistrar.getPassword());
                            lines.set(index, String.join(",", parts));

                            Files.write(file.toPath(), lines, StandardCharsets.UTF_8);

                            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró el usuario en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el archivo de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton cancelar = new JButton("Cancelar");
        cancelar.setSize(150,30);
        cancelar.setLocation(215,495);
        cancelar.setBackground(Color.decode("#E32636"));
        cancelar.setForeground(Color.white);
        cancelar.setBorder(null);
        cancelar.setFont(new Font("Arial", Font.BOLD, 20));
        miCuenta.add(cancelar);

        cancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                anterior = actual;
                actual = "menu";
                limpiarVentana();

                repaint();
                revalidate();

            }

        });

        return miCuenta;
    }

    public JPanel editarCuenta(){
        anterior = actual;
        actual = "editarCuenta";

        JPanel miCuenta = new JPanel();
        miCuenta.setSize(600, 700);
        miCuenta.setLocation(0, 0);
        miCuenta.setLayout(null);
        miCuenta.setBackground(Color.decode("#95E799"));

        JLabel inicia = new JLabel("Editar cuenta",JLabel.CENTER);
        inicia.setFont(new Font("Arial",Font.BOLD,35));
        inicia.setSize(300,80);
        inicia.setLocation(135,10);
        inicia.setForeground(Color.decode("#005F04"));
        miCuenta.add(inicia);

        JLabel imagen = new JLabel();
        imagen.setSize(170,170);
        ImageIcon imag = new ImageIcon("cactus-edit.png");
        Icon icono = new ImageIcon (imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icono);
        imagen.setLocation(197,50);
        miCuenta.add(imagen);

        JLabel imagen2 = new JLabel();
        imagen2.setSize(40,40);
        ImageIcon imag2 = new ImageIcon("cactus-logo.png");
        Icon icono2 = new ImageIcon (imag2.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_DEFAULT));
        imagen2.setIcon(icono2);
        imagen2.setLocation(270,595);
        miCuenta.add(imagen2);

        JLabel nameRegistrar = new JLabel("Ingresa tu nombre",JLabel.CENTER);
        nameRegistrar.setFont(new Font("Arial",Font.BOLD,15));
        nameRegistrar.setSize(300,80);
        nameRegistrar.setLocation(25,165);
        nameRegistrar.setForeground(Color.decode("#005F04"));
        miCuenta.add(nameRegistrar);

        JTextField nombreRegistrar = new JTextField();
        nombreRegistrar.setSize(200,43);
        nombreRegistrar.setLocation(80,220);
        miCuenta.add(nombreRegistrar);

        JLabel apellidoRegistrar = new JLabel("Ingresa tu apellido",JLabel.CENTER);
        apellidoRegistrar.setFont(new Font("Arial",Font.BOLD,15));
        apellidoRegistrar.setSize(300,80);
        apellidoRegistrar.setLocation(235,165);
        apellidoRegistrar.setForeground(Color.decode("#005F04"));
        miCuenta.add(apellidoRegistrar);

        JTextField apeRegistrar = new JTextField();
        apeRegistrar.setSize(200,43);
        apeRegistrar.setLocation(290,220);
        miCuenta.add(apeRegistrar);

        JLabel emailRegistrar = new JLabel("Correo electrónico",JLabel.CENTER);
        emailRegistrar.setFont(new Font("Arial",Font.BOLD,15));
        emailRegistrar.setSize(280,80);
        emailRegistrar.setLocation(80,250);
        emailRegistrar.setForeground(Color.decode("#005F04"));
        miCuenta.add(emailRegistrar);

        JTextField correoRegistrar = new JTextField();
        correoRegistrar.setSize(280,43);
        correoRegistrar.setLocation(150,300);
        miCuenta.add(correoRegistrar);

        JLabel passRegistrar = new JLabel("Contraseña",JLabel.CENTER);
        passRegistrar.setFont(new Font("Arial",Font.BOLD,15));
        passRegistrar.setSize(260,80);
        passRegistrar.setLocation(65,330);
        passRegistrar.setForeground(Color.decode("#005F04"));
        miCuenta.add(passRegistrar);

        JPasswordField contrasenaRegistrar = new JPasswordField();
        contrasenaRegistrar.setSize(280,43);
        contrasenaRegistrar.setLocation(150,380);
        miCuenta.add(contrasenaRegistrar);

        JLabel passConfirm = new JLabel("Confirmar contraseña",JLabel.CENTER);
        passConfirm.setFont(new Font("Arial",Font.BOLD,15));
        passConfirm.setSize(260,80);
        passConfirm.setLocation(98,410);
        passConfirm.setForeground(Color.decode("#005F04"));
        miCuenta.add(passConfirm);

        JPasswordField contrasenaConfirm = new JPasswordField();
        contrasenaConfirm.setSize(280,43);
        contrasenaConfirm.setLocation(150,460);
        miCuenta.add(contrasenaConfirm);

        JButton accederRegistrar = new JButton("Actualizar datos");
        accederRegistrar.setSize(180,30);
        accederRegistrar.setLocation(200,515);
        accederRegistrar.setBackground(Color.decode("#005F04"));
        accederRegistrar.setForeground(Color.white);
        accederRegistrar.setBorder(null);
        accederRegistrar.setFont(new Font("Arial", Font.BOLD, 20));
        miCuenta.add(accederRegistrar);

        accederRegistrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) seleccionar.getSelectedItem();
                File file = new File("C:\\Users\\Public\\Documents\\Tareas\\Examen-U1\\src\\users.txt");
                List<String> lineas = new ArrayList<>();
                boolean encontrado = false;
                String name = nombreRegistrar.getText();
                String apellido = apeRegistrar.getText();
                String email = correoRegistrar.getText();
                String pwd = (new String(contrasenaRegistrar.getPassword()));
                String pwdCopy = (new String(contrasenaConfirm.getPassword()));

                if(name.length() == 0 || apellido.length() == 0 || email.length() == 0 || pwd.length() == 0 || pwdCopy.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debes de modificar todos los datos para poder continuar", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    if(pwd.equals(pwdCopy)) {
                        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] campos = line.split(",");
                                if (campos[0].equals(seleccionado)) {
                                    encontrado = true;
                                    String nuevaLinea = nombreRegistrar.getText() + "," + apeRegistrar.getText() + "," + correoRegistrar.getText() + "," + new String(contrasenaRegistrar.getPassword());
                                    lineas.add(nuevaLinea);
                                } else {
                                    lineas.add(line);
                                }
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        if (!encontrado) {
                            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                                for (int i = 0; i < lineas.size(); i++) {
                                    String linea = lineas.get(i);
                                    bw.write(linea);
                                    bw.newLine();
                                }
                                JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                nombreRegistrar.setText("");
                                apeRegistrar.setText("");
                                correoRegistrar.setText("");
                                contrasenaRegistrar.setText("");
                                contrasenaConfirm.setText("");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Será reedirigido a la lista de usuarios", "Redirección", JOptionPane.INFORMATION_MESSAGE);
                        anterior = actual;
                        actual = "listaUsers";
                        limpiarVentana();

                        repaint();
                        revalidate();
                    }else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                        contrasenaRegistrar.setText("");
                        contrasenaConfirm.setText("");
                    }
                }
            }

        });

        JButton cancelar = new JButton("Cancelar");
        cancelar.setSize(150,30);
        cancelar.setLocation(215,555);
        cancelar.setBackground(Color.decode("#E32636"));
        cancelar.setForeground(Color.white);
        cancelar.setBorder(null);
        cancelar.setFont(new Font("Arial", Font.BOLD, 20));
        miCuenta.add(cancelar);

        cancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                anterior = actual;
                actual = "listaUsers";
                limpiarVentana();

                repaint();
                revalidate();

            }

        });

        return miCuenta;
    }









    public JPanel crearCuenta(){
        anterior = actual;
        actual = "crearcuenta";

        JPanel crearcuenta = new JPanel();
        crearcuenta.setSize(600, 700);
        crearcuenta.setLocation(0, 0);
        crearcuenta.setLayout(null);
        crearcuenta.setBackground(Color.decode("#95E799"));

        JLabel inicia = new JLabel("Crear cuenta",JLabel.CENTER);
        inicia.setFont(new Font("Arial",Font.BOLD,35));
        inicia.setSize(300,80);
        inicia.setLocation(135,10);
        inicia.setForeground(Color.decode("#005F04"));
        crearcuenta.add(inicia);

        JLabel imagen = new JLabel();
        imagen.setSize(140,140);
        ImageIcon imag = new ImageIcon("cactus-create.png");
        Icon icono = new ImageIcon (imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icono);
        imagen.setLocation(210,67);
        crearcuenta.add(imagen);

        JLabel imagen2 = new JLabel();
        imagen2.setSize(40,40);
        ImageIcon imag2 = new ImageIcon("cactus-logo.png");
        Icon icono2 = new ImageIcon (imag2.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_DEFAULT));
        imagen2.setIcon(icono2);
        imagen2.setLocation(270,595);
        crearcuenta.add(imagen2);

        JLabel nameRegistrar = new JLabel("Ingresa tu nombre",JLabel.CENTER);
        nameRegistrar.setFont(new Font("Arial",Font.BOLD,15));
        nameRegistrar.setSize(300,80);
        nameRegistrar.setLocation(25,165);
        nameRegistrar.setForeground(Color.decode("#005F04"));
        crearcuenta.add(nameRegistrar);

        JTextField nombreRegistrar = new JTextField();
        nombreRegistrar.setSize(200,43);
        nombreRegistrar.setLocation(80,220);
        crearcuenta.add(nombreRegistrar);

        JLabel apellidoRegistrar = new JLabel("Ingresa tu apellido",JLabel.CENTER);
        apellidoRegistrar.setFont(new Font("Arial",Font.BOLD,15));
        apellidoRegistrar.setSize(300,80);
        apellidoRegistrar.setLocation(235,165);
        apellidoRegistrar.setForeground(Color.decode("#005F04"));
        crearcuenta.add(apellidoRegistrar);

        JTextField apeRegistrar = new JTextField();
        apeRegistrar.setSize(200,43);
        apeRegistrar.setLocation(290,220);
        crearcuenta.add(apeRegistrar);

        JLabel emailRegistrar = new JLabel("Correo electrónico",JLabel.CENTER);
        emailRegistrar.setFont(new Font("Arial",Font.BOLD,15));
        emailRegistrar.setSize(280,80);
        emailRegistrar.setLocation(80,250);
        emailRegistrar.setForeground(Color.decode("#005F04"));
        crearcuenta.add(emailRegistrar);

        JTextField correoRegistrar = new JTextField();
        correoRegistrar.setSize(280,43);
        correoRegistrar.setLocation(150,300);
        crearcuenta.add(correoRegistrar);

        JLabel passRegistrar = new JLabel("Contraseña",JLabel.CENTER);
        passRegistrar.setFont(new Font("Arial",Font.BOLD,15));
        passRegistrar.setSize(260,80);
        passRegistrar.setLocation(65,330);
        passRegistrar.setForeground(Color.decode("#005F04"));
        crearcuenta.add(passRegistrar);

        JPasswordField contrasenaRegistrar = new JPasswordField();
        contrasenaRegistrar.setSize(280,43);
        contrasenaRegistrar.setLocation(150,380);
        crearcuenta.add(contrasenaRegistrar);

        JLabel passConfirm = new JLabel("Confirmar contraseña",JLabel.CENTER);
        passConfirm.setFont(new Font("Arial",Font.BOLD,15));
        passConfirm.setSize(260,80);
        passConfirm.setLocation(98,410);
        passConfirm.setForeground(Color.decode("#005F04"));
        crearcuenta.add(passConfirm);

        JPasswordField contrasenaConfirmar = new JPasswordField();
        contrasenaConfirmar.setSize(280,43);
        contrasenaConfirmar.setLocation(150,460);
        crearcuenta.add(contrasenaConfirmar);

        JButton accederRegistrar = new JButton("Crear Usuario");
        accederRegistrar.setSize(180,30);
        accederRegistrar.setLocation(200,515);
        accederRegistrar.setBackground(Color.decode("#005F04"));
        accederRegistrar.setForeground(Color.white);
        accederRegistrar.setBorder(null);
        accederRegistrar.setFont(new Font("Arial", Font.BOLD, 20));
        crearcuenta.add(accederRegistrar);

        JButton cancelar = new JButton("Cancelar");
        cancelar.setSize(150,30);
        cancelar.setLocation(215,555);
        cancelar.setBackground(Color.decode("#E32636"));
        cancelar.setForeground(Color.white);
        cancelar.setBorder(null);
        cancelar.setFont(new Font("Arial", Font.BOLD, 20));
        crearcuenta.add(cancelar);

        cancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                anterior = actual;
                actual = "menu";
                limpiarVentana();

                repaint();
                revalidate();

            }

        });

        accederRegistrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nombreRegistrar.getText();
                String apellido = apeRegistrar.getText();
                String email = correoRegistrar.getText();
                String pwd = (new String(contrasenaRegistrar.getPassword()));
                String pwdCopy = (new String(contrasenaConfirmar.getPassword()));
                FileWriter writer;
                PrintWriter linea;

                if(name.length() == 0 || apellido.length() == 0 || email.length() == 0 || pwd.length() == 0 || pwdCopy.length() == 0) {
                    JOptionPane.showMessageDialog(null, "No has ingresado uno o más valores","Mal",JOptionPane.WARNING_MESSAGE);
                    nombreRegistrar.setText("");
                    apeRegistrar.setText("");
                    correoRegistrar.setText("");
                    contrasenaRegistrar.setText("");
                    contrasenaConfirmar.setText("");
                }else {
                    if(pwd.equals(pwdCopy)) {
                        try {
                            writer = new FileWriter("C:\\Users\\Public\\Documents\\Tareas\\Examen-U1\\src\\users.txt",true);
                            linea = new PrintWriter(writer);

                            linea.println(name + "," + apellido + "," + email + "," + pwd);
                            linea.close();
                            writer.close();

                            int op = JOptionPane.showConfirmDialog(null, "Creado exitosamente, ¿Desea crear otro usuario?", "Éxito",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

                            if(op == JOptionPane.YES_OPTION) {
                                nombreRegistrar.setText("");
                                apeRegistrar.setText("");
                                correoRegistrar.setText("");
                                contrasenaRegistrar.setText("");
                                contrasenaConfirmar.setText("");
                            }else {
                                anterior = actual;
                                actual = "menu";
                                limpiarVentana();
                                JOptionPane.showMessageDialog(null, "Fue reedirigido al menú", "Usted no quiere crear otro usuario",JOptionPane.INFORMATION_MESSAGE);

                                repaint();
                                revalidate();
                            }
                        }catch(IOException de){
                            de.printStackTrace();
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas no han coincidido","Mal",JOptionPane.WARNING_MESSAGE);
                        contrasenaRegistrar.setText("");
                        contrasenaConfirmar.setText("");
                    }
                }
            }

        });
        return crearcuenta;
    }

    private static void eliminarLineaEnArchivo(int fila) {
        try {
            File file = new File("src\\users.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String lineaActual;
            StringBuffer buffer = new StringBuffer();
            int filaActual = 0;
            while ((lineaActual = reader.readLine()) != null) {
                if (filaActual != fila) {
                    buffer.append(lineaActual + "\n");
                }
                filaActual++;
            }
            reader.close();
            FileWriter writer = new FileWriter(file, false);
            writer.write(buffer.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public JPanel listaUsuarios(){
        anterior = actual;
        actual = "listaUsers";

        JPanel listaUsuarios = new JPanel();
        listaUsuarios.setSize(600, 700);
        listaUsuarios.setLocation(0, 0);
        listaUsuarios.setLayout(null);
        listaUsuarios.setBackground(Color.decode("#95E799"));

        JLabel list = new JLabel("Lista de usuarios");
        list.setFont(new Font("Arial", Font.BOLD, 30));
        list.setLocation(160,30);
        list.setSize(400,40);
        list.setForeground(Color.decode("#005F04"));
        listaUsuarios.add(list);

        JLabel imagen = new JLabel();
        imagen.setSize(80,80);
        ImageIcon imag = new ImageIcon("cactus-table.png");
        Icon icono = new ImageIcon (imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icono);
        imagen.setLocation(240,70);
        listaUsuarios.add(imagen);

        JLabel imagen2 = new JLabel();
        imagen2.setSize(40,40);
        ImageIcon imag2 = new ImageIcon("cactus-logo.png");
        Icon icono2 = new ImageIcon (imag2.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_DEFAULT));
        imagen2.setIcon(icono2);
        imagen2.setLocation(260,593);
        listaUsuarios.add(imagen2);

        JLabel editar = new JLabel("Editar",JLabel.CENTER);
        editar.setFont(new Font("Arial",Font.BOLD,15));
        editar.setSize(100,80);
        editar.setLocation(60,110);
        editar.setForeground(Color.decode("#005F04"));
        listaUsuarios.add(editar);

        JButton editarUser = new JButton("Editar");
        editarUser.setSize(400,30);
        editarUser.setLocation(85,210);
        editarUser.setBackground(Color.decode("#005F04"));
        editarUser.setForeground(Color.white);
        editarUser.setBorder(null);
        editarUser.setFont(new Font("Arial", Font.BOLD, 20));
        editarUser.setEnabled(false);
        listaUsuarios.add(editarUser);

        JButton abrirTabla = new JButton("Mostrar datos");
        abrirTabla.setSize(150,30);
        abrirTabla.setLocation(205,250);
        abrirTabla.setBackground(Color.decode("#009407"));
        abrirTabla.setForeground(Color.white);
        abrirTabla.setBorder(null);
        abrirTabla.setFont(new Font("Arial", Font.BOLD, 20));
        listaUsuarios.add(abrirTabla);

        JTable tabla = new JTable();
        tabla.setLocation(120,400);
        tabla.setSize(260,200);
        tabla.setVisible(false);
        listaUsuarios.add(tabla);

        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tabla.getSelectedRow();
                int columnaSeleccionada = tabla.getSelectedColumn();
                if (columnaSeleccionada == 4 ) {
                    String emailLogueado = (String) tabla.getValueAt(filaSeleccionada, 2);
                    System.out.println(emailLogueado);
                    if(emailLogueado.equals(email)) {
                        JOptionPane.showMessageDialog(null, "No, no puedes borrarte a ti mismo...", "Así te quería agarrar", JOptionPane.OK_OPTION);
                    }else {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar esta fila?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                        if (opcion == JOptionPane.YES_OPTION) {
                            DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
                            modelo.removeRow(filaSeleccionada);
                            eliminarLineaEnArchivo(filaSeleccionada);
                        }
                    }	}
            }
        });

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setLocation(85,290);
        scrollPane.setSize(400,300);
        scrollPane.setVisible(false);
        listaUsuarios.add(scrollPane);


        seleccionar.setSize(400,40);
        seleccionar.setLocation(85,160);
        listaUsuarios.add(seleccionar);
        seleccionar.removeAllItems();


        File file = new File("C:\\Users\\Public\\Documents\\Tareas\\Examen-U1\\src\\users.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] parts = linea.split(",");
                seleccionar.addItem(parts[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        seleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) seleccionar.getSelectedItem();
                editarUser.setEnabled(true);
                editarUser.setText("Editar " + seleccionado);

            }


        });


        editarUser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) seleccionar.getSelectedItem();
                if(seleccionado.equals(email)) {
                    JOptionPane.showMessageDialog(null, "En 'Mi cuenta' puedes editar tu información", "No puedes editarte a ti mismo en esta ventana", JOptionPane.OK_OPTION);
                    int op = JOptionPane.showConfirmDialog(null, "¿Deseas que te reedirigamos a 'Mi cuenta'?", "Reedirección", JOptionPane.YES_NO_OPTION);
                    if(op == JOptionPane.YES_OPTION) {
                        anterior = actual;
                        actual = "micuenta";
                        limpiarVentana();

                        repaint();
                        revalidate();
                    }
                }else {
                    anterior = actual;
                    actual = "editarCuenta";
                    limpiarVentana();

                    repaint();
                    revalidate();
                }

            }

        });

        abrirTabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("C:\\Users\\Public\\Documents\\Tareas\\Examen-U1\\src\\users.txt");
                BufferedReader bufer;

                try {
                    bufer = new BufferedReader(new FileReader(file));
                    String[] columnas = {"Nombre", "Apellidos", "Correo", "Contraseña", "Acción"};

                    DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
                    modelo.setColumnIdentifiers(columnas);

                    modelo.setRowCount(0);

                    TableColumnModel columnModel = tabla.getColumnModel();
                    columnModel.getColumn(columnModel.getColumnCount() - 1).setCellRenderer(new ButtonRenderer());

                    Object[] datosEnLinea = bufer.lines().toArray();

                    for(int i = 0; i<datosEnLinea.length; i++) {
                        String linea = datosEnLinea[i].toString().trim();
                        String [] data = linea.split(",");
                        modelo.addRow(data);

                    }
                    tabla.setVisible(true);
                    scrollPane.setVisible(true);
                    repaint();
                    revalidate();

                }catch (Exception er) {
                    er.printStackTrace();
                }

            }

        });

        return listaUsuarios;

    }

    public JPanel ayuda() {
        anterior = actual;
        actual = "ayuda";

        JPanel ayuda = new JPanel();
        ayuda.setSize(600, 700);
        ayuda.setLocation(0, 0);
        ayuda.setLayout(null);
        ayuda.setBackground(Color.decode("#95E799"));

        JLabel comocrea = new JLabel("¿Como crear un usuario?");
        comocrea.setFont(new Font("Arial", Font.BOLD, 30));
        comocrea.setLocation(100,20);
        comocrea.setSize(400,40);
        comocrea.setForeground(Color.decode("#005F04"));
        ayuda.add(comocrea);

        JLabel imagen2 = new JLabel();
        imagen2.setSize(90,90);
        ImageIcon imag2 = new ImageIcon("cactus-logo.png");
        Icon icono2 = new ImageIcon (imag2.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_DEFAULT));
        imagen2.setIcon(icono2);
        imagen2.setLocation(245,55);
        ayuda.add(imagen2);

        JTextArea instrucciones = new JTextArea("1. Hacer click en la opción 'Usuarios' en\n" +
                "el menú superior.\n \n"+
                "2. Hacer click en la opción 'Crear Usuario'\n"+
                "en el menú desplegado.\n \n"+
                "3. Llenar los campos solicitados\n \n"+
                "4. Escribi una pequeña descripción de ti\n \n"+
                "5. Seleccionar tu comida favorita.\n \n"+
                "6. Seleccionar tu color favorito.\n \n"+
                "7. Hacer click en el botón 'Crear Usuario'\n \n"+
                "8. Listo, el usuario se ha creado.");
        instrucciones.setEditable(false);

        instrucciones.setBackground(Color.decode("#95E799"));
        instrucciones.setLocation(100,155);
        instrucciones.setSize(380,400);
        instrucciones.setFont(new Font("Arial", Font.BOLD, 18));
        instrucciones.setForeground(Color.decode("#005F04"));
        ayuda.add(instrucciones);

        JButton crear = new JButton("Crear un usuario ahora");
        crear.setSize(260,40);
        crear.setLocation(150,560);
        crear.setBackground(Color.decode("#005F04"));
        crear.setForeground(Color.white);
        crear.setBorder(null);
        crear.setFont(new Font("Arial", Font.BOLD, 20));
        ayuda.add(crear);

        crear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                anterior = actual;
                actual = "crearcuenta";
                limpiarVentana();

                repaint();
                revalidate();

            }

        });

        return ayuda;

    }



}