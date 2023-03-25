import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {//hola
    public JPanel panel = null;
    private String actual = "cargaPantalla";
    public Ventana(){
        this.setVisible(true);
        this.setSize(600,700);
        this.setTitle("Datos generales");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#CAE9DA"));
        this.setLayout(null);

        panel = listaUsuarios();

        this.add(panel);

        this.repaint();
        this.revalidate();


    }



    public JPanel cargaPantalla(){
        JPanel cargaPanel = new JPanel();
        cargaPanel.setSize(600, 700);
        cargaPanel.setLocation(0, 0);
        cargaPanel.setLayout(null);
        cargaPanel.setBackground(Color.decode("#95E799"));

        JLabel bienvenido = new JLabel("Powered by Ramses & Zumaya",JLabel.CENTER);
        bienvenido.setFont(new Font("Arial",Font.BOLD,15));
        bienvenido.setSize(500,100);
        bienvenido.setLocation(60,350);
        bienvenido.setForeground(Color.decode("#0C7F11"));
        cargaPanel.add(bienvenido);

        this.add(cargaPanel);
        return cargaPanel;
    }




    public JPanel menupanel(){

        JPanel menu = new JPanel();
        menu.setSize(350,24);
        menu.setLocation(30,20);


        this.add(menu);

        JMenuBar menuBar = new JMenuBar();
        JMenu cuenta = new JMenu("Cuenta");
        JMenu usuarios = new JMenu("Usuarios");
        JMenu ayuda = new JMenu("Ayuda");
        menuBar.add(cuenta);
        menuBar.add(usuarios);
        menuBar.add(ayuda);
        menu.setLayout(new BorderLayout());
        menu.add(menuBar,BorderLayout.NORTH);

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


        JPanel instrucciones = new JPanel();
        instrucciones.setSize(350, 250);
        instrucciones.setBackground(new Color(102, 255, 204));
        instrucciones.setLocation(20, 60);

        comocrear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                JLabel comocrea = new JLabel("¿Como crear un usuario?");
                comocrea.setFont(new Font("Arial", Font.BOLD, 18));

                //   comocrea.setLocation(50,0);
                JTextArea instruccioness = new JTextArea("1.Hacer click en la opción 'Usuarios' en\n" +
                        "el menú superior.\n"+
                        "2.Hacer click en la opción 'Crear Usuario'\n"+
                        "en el menú desplegado.\n"+
                        "3.Llenar los campos solicitados\n"+
                        "4.Escribi una pequeña descripción de ti\n"+
                        "5.Seleccionar tu comida favorita.\n"+
                        "6.Seleccionar tu color favorito.\n"+
                        "7.Hacer click en el botón 'Crear Usuario'\n"+
                        "8.Listo, el usuario se ha creado.");
                instruccioness.setEditable(false);

                //    instruccioness.setLocation(0,20);
                instruccioness.setBackground(new Color(102, 255, 204));
                instruccioness.setLocation(0,80);
                instruccioness.setFont(new Font("Arial", Font.BOLD, 15));

                //    instruccioness.setSize();



                add(instrucciones);
                instrucciones.add(comocrea);
                instrucciones.add(instruccioness);




                repaint();
                revalidate();



            }
        });
        return menu;

    }






    public JPanel login(){
        JPanel loginPanel = new JPanel();
        loginPanel.setSize(600, 700);
        loginPanel.setLocation(0, 0);
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.decode("#A5F2DA"));

        JLabel account = new JLabel("Mi cuenta",JLabel.CENTER);
        account.setFont(new Font("Arial",Font.BOLD,20));
        account.setSize(200,80);
        account.setLocation(150,5);
        account.setForeground(Color.white);
        loginPanel.add(account);

        JLabel panel = new JLabel("Inicio de sesión",JLabel.CENTER);
        panel.setFont(new Font("Arial",Font.BOLD,30));
        panel.setSize(300,80);
        panel.setLocation(100,60);
        panel.setForeground(Color.decode("#dcca8a"));
        loginPanel.add(panel);

        JLabel user = new JLabel("Ingresa tu nombre de usuario",JLabel.CENTER);
        user.setFont(new Font("Arial",Font.BOLD,12));
        user.setSize(300,80);
        user.setLocation(60,110);
        user.setForeground(Color.white);
        loginPanel.add(user);

        JTextField username = new JTextField();
        username.setSize(250,40);
        username.setLocation(125,160);
        loginPanel.add(username);

        JLabel pass = new JLabel("Ingresa tu contraseña",JLabel.CENTER);
        pass.setFont(new Font("Arial",Font.BOLD,12));
        pass.setSize(260,80);
        pass.setLocation(60,190);
        pass.setForeground(Color.white);
        loginPanel.add(pass);

        JPasswordField contraseña = new JPasswordField();
        contraseña.setSize(250,40);
        contraseña.setLocation(125,240);
        loginPanel.add(contraseña);

        JButton acceder = new JButton("Acceder");
        acceder.setSize(150,30);
        acceder.setLocation(175,300);
        acceder.setBackground(Color.decode("#ecd47f"));
        loginPanel.add(acceder);

        JButton registrar = new JButton("Registrarse");
        registrar.setSize(150,30);
        registrar.setLocation(175,370);
        registrar.setBackground(Color.decode("#0078FF"));
        loginPanel.add(registrar);

        return loginPanel;
    }

    public JPanel miCuenta(){
        JPanel miCuenta = new JPanel();
        miCuenta.setSize(600, 700);
        miCuenta.setLocation(0, 0);
        miCuenta.setLayout(null);
        miCuenta.setBackground(Color.decode("#A5F2DA"));

        JLabel nameRegistrar = new JLabel("Ingresa tu nombre",JLabel.CENTER);
        nameRegistrar.setFont(new Font("Arial",Font.BOLD,12));
        nameRegistrar.setSize(300,80);
        nameRegistrar.setLocation(05,110);
        nameRegistrar.setForeground(Color.white);
        miCuenta.add(nameRegistrar);

        JTextField nombreRegistrar = new JTextField();
        nombreRegistrar.setSize(150,40);
        nombreRegistrar.setLocation(100,160);
        miCuenta.add(nombreRegistrar);

        JLabel apellidoRegistrar = new JLabel("Ingresa tu apellido",JLabel.CENTER);
        apellidoRegistrar.setFont(new Font("Arial",Font.BOLD,12));
        apellidoRegistrar.setSize(300,80);
        apellidoRegistrar.setLocation(205,110);
        apellidoRegistrar.setForeground(Color.white);
        miCuenta.add(apellidoRegistrar);

        JTextField apeRegistrar = new JTextField();
        apeRegistrar.setSize(150,40);
        apeRegistrar.setLocation(260,160);
        miCuenta.add(apeRegistrar);

        JLabel emailRegistrar = new JLabel("Correo electrónico",JLabel.CENTER);
        emailRegistrar.setFont(new Font("Arial",Font.BOLD,12));
        emailRegistrar.setSize(260,80);
        emailRegistrar.setLocation(50,190);
        emailRegistrar.setForeground(Color.white);
        miCuenta.add(emailRegistrar);

        JTextField correoRegistrar = new JTextField();
        correoRegistrar.setSize(250,40);
        correoRegistrar.setLocation(125,240);
        miCuenta.add(correoRegistrar);

        JLabel passRegistrar = new JLabel("Contraseña",JLabel.CENTER);
        passRegistrar.setFont(new Font("Arial",Font.BOLD,12));
        passRegistrar.setSize(260,80);
        passRegistrar.setLocation(30,260);
        passRegistrar.setForeground(Color.white);
        miCuenta.add(passRegistrar);

        JPasswordField contraseñaRegistrar = new JPasswordField();
        contraseñaRegistrar.setSize(250,40);
        contraseñaRegistrar.setLocation(125,310);
        miCuenta.add(contraseñaRegistrar);

        JLabel confirmPass = new JLabel("Confirmar contraseña",JLabel.CENTER);
        confirmPass.setFont(new Font("Arial",Font.BOLD,12));
        confirmPass.setSize(260,80);
        confirmPass.setLocation(60,330);
        confirmPass.setForeground(Color.white);
        miCuenta.add(confirmPass);

        JPasswordField contraseñaConfirmar = new JPasswordField();
        contraseñaConfirmar.setSize(250,40);
        contraseñaConfirmar.setLocation(125,380);
        miCuenta.add(contraseñaConfirmar);

        JCheckBox terminosConfirm = new JCheckBox("Acepto los términos y condiciones, vendo mi alma al diablo.");
        terminosConfirm.setSize(450,20);
        terminosConfirm.setLocation(60,450);
        terminosConfirm.setOpaque(false);
        terminosConfirm.setForeground(Color.white);
        miCuenta.add(terminosConfirm);

        JButton accederRegistrar = new JButton("Registrarse");
        accederRegistrar.setSize(150,30);
        accederRegistrar.setLocation(175,500);
        accederRegistrar.setBackground(Color.decode("#ecd47f"));
        miCuenta.add(accederRegistrar);

        return miCuenta;
    }

    public JPanel listaUsuarios(){
        JPanel listaUsuarios = new JPanel();
        listaUsuarios.setSize(600, 700);
        listaUsuarios.setLocation(0, 0);
        listaUsuarios.setLayout(null);
        listaUsuarios.setBackground(Color.decode("#A5F2DA"));

        JLabel bienTabla = new JLabel("Bienvenido",JLabel.CENTER);
        bienTabla.setFont(new Font("Arial",Font.BOLD,30));
        bienTabla.setSize(300,80);
        bienTabla.setLocation(100,60);
        bienTabla.setForeground(Color.decode("#dcca8a"));
        listaUsuarios.add(bienTabla);

        JButton abrirTabla = new JButton("Mostrar datos");
        abrirTabla.setSize(150,30);
        abrirTabla.setLocation(175,300);
        abrirTabla.setBackground(Color.decode("#ecd47f"));
        listaUsuarios.add(abrirTabla);

        String[] columnas = {"No. Control", "Apellidos", "Nombres", "Acciones"};

        Object[][] data = {
                {1,"Zumaya",    "Abraham",   ""},
                {2,"Arias",     "Cruz",      ""},
                {3,"Alejandro", "Francisco", ""},
                {4,"PeñaNieto",     "Amlo",      ""},
                {5,"Ojeda",    "Victoria",     ""}
        };

        DefaultTableModel dtm = new DefaultTableModel(data,columnas);
        JTable tabla = new JTable(dtm);
        tabla.setLocation(100,200);
        tabla.setSize(260,200);
        tabla.setVisible(false);
        listaUsuarios.add(tabla);

        abrirTabla.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tabla.setVisible(true);
            }

        });
        return listaUsuarios;

















    }
}
