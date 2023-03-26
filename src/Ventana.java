import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Ventana extends JFrame {//hola
    public JPanel panel = null;

    private String anterior = "cargaPantalla";
    private String actual = "cargaPantalla";

    private String bienvenidonombre;

    public Ventana(){

        this.setVisible(true);
        this.setSize(600,700);
        this.setTitle("Sistema");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#CAE9DA"));
        this.setLayout(null);

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
        bienvenido.setLocation(60,350);
        bienvenido.setForeground(Color.decode("#0C7F11"));
        cargaPanel.add(bienvenido);

        JProgressBar barra = new JProgressBar(0,100);
        barra.setSize(400,100);
        barra.setLocation(100,100);
        cargaPanel.add(barra);

        JButton iniciar = new JButton("Inicia");
        iniciar.setSize(90,50);
        iniciar.setLocation(250,200);
        iniciar.setVisible(false);
        cargaPanel.add(iniciar);

        this.add(cargaPanel);

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




    public JPanel login(){
        anterior = actual;
        actual = "login";

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

        JPasswordField contrasena = new JPasswordField();
        contrasena.setSize(250,40);
        contrasena.setLocation(125,240);
        loginPanel.add(contrasena);

        JButton acceder = new JButton("Acceder");
        acceder.setSize(150,30);
        acceder.setLocation(175,300);
        acceder.setBackground(Color.decode("#ecd47f"));
        loginPanel.add(acceder);

        acceder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String email = username.getText();
                String pwd = new String (contrasena.getPassword());

                BufferedReader reader;
                Boolean flag = false;

                try{
                    //  FileReader file = new FileReader("src\\users.txt");
                    FileReader file = new FileReader("src\\users.txt");
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
        menu.setSize(520,60);
        menu.setLocation(30,20);
        JLabel bienvenido = new JLabel("Hola " + bienvenidonombre);
        bienvenido.setFont(new Font("Arial", Font.BOLD, 24));
        bienvenido.setLocation(0,0);
        menu.setBackground(Color.decode("#7cd6ab"));

        menu.add(bienvenido);

        this.add(menu);

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




    public JPanel miCuenta(){
        anterior = actual;
        actual = "micuenta";

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

        JButton accederRegistrar = new JButton("Actualizar datos");
        accederRegistrar.setSize(150,30);
        accederRegistrar.setLocation(250,500);
        accederRegistrar.setBackground(Color.decode("#ecd47f"));
        miCuenta.add(accederRegistrar);

        JButton cancelar = new JButton("Cancelar");
        cancelar.setSize(150,30);
        cancelar.setLocation(100,500);
        cancelar.setBackground(Color.decode("#E32636"));
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

    public JPanel crearCuenta(){
        anterior = actual;
        actual = "crearcuenta";

        JPanel crearCuenta = new JPanel();
        crearCuenta.setSize(600, 700);
        crearCuenta.setLocation(0, 0);
        crearCuenta.setLayout(null);
        crearCuenta.setBackground(Color.decode("#A5F2DA"));

        JLabel nameRegistrar = new JLabel("Ingresa tu nombre",JLabel.CENTER);
        nameRegistrar.setFont(new Font("Arial",Font.BOLD,12));
        nameRegistrar.setSize(300,80);
        nameRegistrar.setLocation(05,110);
        nameRegistrar.setForeground(Color.white);
        crearCuenta.add(nameRegistrar);

        JTextField nombreRegistrar = new JTextField();
        nombreRegistrar.setSize(150,40);
        nombreRegistrar.setLocation(100,160);
        crearCuenta.add(nombreRegistrar);

        JLabel apellidoRegistrar = new JLabel("Ingresa tu apellido",JLabel.CENTER);
        apellidoRegistrar.setFont(new Font("Arial",Font.BOLD,12));
        apellidoRegistrar.setSize(300,80);
        apellidoRegistrar.setLocation(205,110);
        apellidoRegistrar.setForeground(Color.white);
        crearCuenta.add(apellidoRegistrar);

        JTextField apeRegistrar = new JTextField();
        apeRegistrar.setSize(150,40);
        apeRegistrar.setLocation(260,160);
        crearCuenta.add(apeRegistrar);

        JLabel emailRegistrar = new JLabel("Correo electrónico",JLabel.CENTER);
        emailRegistrar.setFont(new Font("Arial",Font.BOLD,12));
        emailRegistrar.setSize(260,80);
        emailRegistrar.setLocation(50,190);
        emailRegistrar.setForeground(Color.white);
        crearCuenta.add(emailRegistrar);

        JTextField correoRegistrar = new JTextField();
        correoRegistrar.setSize(250,40);
        correoRegistrar.setLocation(125,240);
        crearCuenta.add(correoRegistrar);

        JLabel passRegistrar = new JLabel("Contraseña",JLabel.CENTER);
        passRegistrar.setFont(new Font("Arial",Font.BOLD,12));
        passRegistrar.setSize(260,80);
        passRegistrar.setLocation(30,260);
        passRegistrar.setForeground(Color.white);
        crearCuenta.add(passRegistrar);

        JPasswordField contrasenaRegistrar = new JPasswordField();
        contrasenaRegistrar.setSize(250,40);
        contrasenaRegistrar.setLocation(125,310);
        crearCuenta.add(contrasenaRegistrar);

        JLabel passConf = new JLabel("Confirmar contraseña",JLabel.CENTER);
        passConf.setFont(new Font("Arial",Font.BOLD,12));
        passConf.setSize(260,80);
        passConf.setLocation(60,330);
        passConf.setForeground(Color.white);
        crearCuenta.add(passConf);

        JPasswordField contrasenaConfirmar = new JPasswordField();
        contrasenaConfirmar.setSize(250,40);
        contrasenaConfirmar.setLocation(125,380);
        crearCuenta.add(contrasenaConfirmar);

        JButton accederRegistrar = new JButton("Actualizar datos");
        accederRegistrar.setSize(150,30);
        accederRegistrar.setLocation(250,500);
        accederRegistrar.setBackground(Color.decode("#ecd47f"));
        crearCuenta.add(accederRegistrar);

        JButton cancelar = new JButton("Cancelar");
        cancelar.setSize(150,30);
        cancelar.setLocation(100,500);
        cancelar.setBackground(Color.decode("#E32636"));
        crearCuenta.add(cancelar);

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
							writer = new FileWriter("src\\users.txt",true);
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
						JOptionPane.showMessageDialog(null, "Tas ciego","Las contraseñas no coinciden",JOptionPane.WARNING_MESSAGE);
						contrasenaRegistrar.setText("");
						contrasenaConfirmar.setText("");
					}
				}
			}
			
		});
        return crearCuenta;
    }


    public JPanel listaUsuarios(){
        anterior = actual;
        actual = "listaUsers";

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

        JLabel editar = new JLabel("Editar",JLabel.CENTER);
        editar.setFont(new Font("Arial",Font.BOLD,20));
        editar.setSize(300,80);
        editar.setLocation(100,120);
        editar.setForeground(Color.decode("#dcca8a"));
        listaUsuarios.add(editar);

        JButton editarUser = new JButton("Editar");
        editarUser.setSize(150,30);
        editarUser.setLocation(175,250);
        editarUser.setBackground(Color.decode("#FF0000"));
        listaUsuarios.add(editarUser);

        JButton abrirTabla = new JButton("Mostrar datos");
        abrirTabla.setSize(150,30);
        abrirTabla.setLocation(175,370);
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
        
        JComboBox seleccionar = new JComboBox();
        seleccionar.setSize(150,40);
        seleccionar.setLocation(100,160);
        listaUsuarios.add(seleccionar);
       /* 
        seleccionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileReader lector = null;
				try {
					String cadenaLeida = "";
					lector = new FileReader("src\\users.txt");
					BufferedReader buffered = new BufferedReader(lector);
					cadenaLeida = buffered.readLine();
					while(cadenaLeida != null) {
						StringTokenizer st = new StringTokenizer(cadenaLeida,",");
						String nombres = st.nextToken();
						seleccionar.addItem(nombres);
						cadenaLeida = buffered.readLine();
					}
				}catch(Exception er) {
					
				}
				
			}
        	
        });
*/
        DefaultTableModel dtm = new DefaultTableModel(data,columnas);
        JTable tabla = new JTable(dtm);
        tabla.setVisible(true);
        listaUsuarios.add(tabla);

        JScrollPane pane = new JScrollPane(tabla);
        pane.setLocation(100,500);
        pane.setSize(260,200);
        pane.setVisible(true);
        listaUsuarios.add(pane);

        abrirTabla.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tabla.setVisible(true);
                pane.setVisible(true);

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
        ayuda.setBackground(Color.decode("#A5F2DA"));

        JLabel comocrea = new JLabel("¿Como crear un usuario?");
        comocrea.setFont(new Font("Arial", Font.BOLD, 18));
        comocrea.setLocation(100,100);
        comocrea.setSize(300,30);
        ayuda.add(comocrea);

        JTextArea instrucciones = new JTextArea("1. Hacer click en la opción 'Usuarios' en\n" +
                "el menú superior.\n"+
                "2. Hacer click en la opción 'Crear Usuario'\n"+
                "en el menú desplegado.\n"+
                "3. Llenar los campos solicitados\n"+
                "4. Escribi una pequeña descripción de ti\n"+
                "5. Seleccionar tu comida favorita.\n"+
                "6. Seleccionar tu color favorito.\n"+
                "7. Hacer click en el botón 'Crear Usuario'\n"+
                "8. Listo, el usuario se ha creado.");
        instrucciones.setEditable(false);

        instrucciones.setBackground(new Color(102, 255, 204));
        instrucciones.setLocation(100,180);
        instrucciones.setSize(300,200);
        instrucciones.setFont(new Font("Arial", Font.BOLD, 15));
        ayuda.add(instrucciones);

        JButton crear = new JButton("Crear un usuario ahora");
        crear.setSize(150,30);
        crear.setLocation(250,500);
        crear.setBackground(Color.decode("#ecd47f"));
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