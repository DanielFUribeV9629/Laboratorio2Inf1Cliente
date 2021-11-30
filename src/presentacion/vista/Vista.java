package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import presentacion.controlador.ControladorCliente;
import presentacion.modelo.RequestSemaforo;

public class Vista extends javax.swing.JFrame {

    private ControladorCliente controladorCliente;
    private final RequestSemaforo modelo;

    public Vista(RequestSemaforo aThis) {
        modelo = aThis;
        initComponents();
        configInicial();
        capturaEventos();
    }

    public ControladorCliente getControl() {
        if (controladorCliente == null) {
            controladorCliente = new ControladorCliente(this);
        }
        return controladorCliente;
    }
    
    private void configInicial(){
        conectarse.setEnabled(true);
        desconectarse.setEnabled(false);
        bienvenida.setVisible(false);
        ingresaYa.setVisible(true);
        cantSemaforos1.setEnabled(false);
        cantSemaforos2.setEnabled(false);
        luzRojaMal1.setEnabled(false);
        luzRojaMal2.setEnabled(false);
        luzAmaMal1.setEnabled(false);
        luzAmaMal2.setEnabled(false);
        luzVerdeMal1.setEnabled(false);
        luzVerdeMal2.setEnabled(false);
        enviar.setEnabled(false);
        radioLuzRoja1.setEnabled(false);
        radioLuzRoja2.setEnabled(false);
        radioLuzAma1.setEnabled(false);
        radioLuzAma2.setEnabled(false);
        radioLuzVerde1.setEnabled(false);
        radioLuzVerde2.setEnabled(false);
    }

    private void capturaEventos() {
        enviar.addActionListener(getControl());
        conectarse.addActionListener(getControl());
        desconectarse.addActionListener(getControl());
        this.addComponentListener(getControl());
    }

    public JButton getBtnEnviar() {
        return enviar;
    }

    public JLabel getTxtBienvenida() {
        return bienvenida;
    }

    public JTextField getTxtCantSemaforos1() {
        return cantSemaforos1;
    }

    public JTextField getTxtCantSemaforos2() {
        return cantSemaforos2;
    }

    public JButton getBtnConectar() {
        return conectarse;
    }

    public JButton getBtnDesconectar() {
        return desconectarse;
    }

    public JLabel getTxtIngresaYa() {
        return ingresaYa;
    }

    public JTextField getTxtLuzRojaMal1() {
        return luzRojaMal1;
    }

    public JTextField getTxtLuzRojaMal2() {
        return luzRojaMal2;
    }

    public JTextField getTxtLuzAmaMal1() {
        return luzAmaMal1;
    }

    public JTextField getTxtLuzAmaMal2() {
        return luzAmaMal2;
    }

    public JTextField getTxtLuzVerdeMal1() {
        return luzVerdeMal1;
    }

    public JTextField getTxtLuzVerdeMal2() {
        return luzVerdeMal2;
    }

    public RequestSemaforo getModelo() {
        return modelo;
    }
    
    public void setRadioLuzRoja1(boolean prende){
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semaforo_red.png")));        
        radioLuzRoja1.setSelected(true);
    }
    
    public void setRadioLuzRoja2(boolean prende){
       jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semaforo_red.png")));        
        radioLuzRoja2.setSelected(true);
 
    }
    
    public void setRadioLuzAma1(boolean prende){
       jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semaforo_yellow.png")));        
        radioLuzAma1.setSelected(true);
    }
    
    public void setRadioLuzAma2(boolean prende){
       jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semaforo_yellow.png")));        
        radioLuzAma2.setSelected(true);
    }
    
    public void setRadioLuzVerde1(boolean prende){
       jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semaforo_green.png")));        
        radioLuzVerde1.setSelected(true);
    }
    
    public void setRadioLuzVerde2(boolean prende){
       jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semaforo_green.png")));        
        radioLuzVerde2.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo1 = new javax.swing.ButtonGroup();
        Grupo2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        luzRojaMal1 = new javax.swing.JTextField();
        luzAmaMal1 = new javax.swing.JTextField();
        luzVerdeMal1 = new javax.swing.JTextField();
        cantSemaforos1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cantSemaforos2 = new javax.swing.JTextField();
        luzRojaMal2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        luzVerdeMal2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        luzAmaMal2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        bienvenida = new javax.swing.JLabel();
        ingresaYa = new javax.swing.JLabel();
        enviar = new javax.swing.JButton();
        conectarse = new javax.swing.JButton();
        desconectarse = new javax.swing.JButton();
        radioLuzRoja1 = new javax.swing.JRadioButton();
        radioLuzAma1 = new javax.swing.JRadioButton();
        radioLuzVerde1 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        radioLuzVerde2 = new javax.swing.JRadioButton();
        radioLuzAma2 = new javax.swing.JRadioButton();
        radioLuzRoja2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 500));
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Grupo 1");

        separador.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Luces verdes dañadas");
        jLabel2.setToolTipText("");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cantidad de Semáforos");
        jLabel3.setToolTipText("");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Luces rojas dañadas");
        jLabel4.setToolTipText("");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Luces amarillas dañadas");
        jLabel5.setToolTipText("");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semaforo.png"))); // NOI18N
        jLabel6.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Grupo 2");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semaforo.png"))); // NOI18N
        jLabel8.setToolTipText("");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Luces rojas dañadas");
        jLabel10.setToolTipText("");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Luces verdes dañadas");
        jLabel11.setToolTipText("");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Luces amarillas dañadas");
        jLabel12.setToolTipText("");

        bienvenida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bienvenida.setForeground(new java.awt.Color(0, 0, 255));
        bienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bienvenida.setText("Bienvenido !! Ya estas conectado !!");

        ingresaYa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ingresaYa.setForeground(new java.awt.Color(255, 0, 0));
        ingresaYa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingresaYa.setText("Conectate y brindanos información !!!");

        enviar.setText("Enviar");

        conectarse.setText("Conectarse");

        desconectarse.setText("Desconectarse");

        Grupo1.add(radioLuzRoja1);
        radioLuzRoja1.setText("Luz Roja");

        Grupo1.add(radioLuzAma1);
        radioLuzAma1.setText("Luz Amarilla");

        Grupo1.add(radioLuzVerde1);
        radioLuzVerde1.setText("Luz Verde");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Cantidad de Semáforos");
        jLabel13.setToolTipText("");

        Grupo2.add(radioLuzVerde2);
        radioLuzVerde2.setText("Luz Verde");

        Grupo2.add(radioLuzAma2);
        radioLuzAma2.setText("Luz Amarilla");

        Grupo2.add(radioLuzRoja2);
        radioLuzRoja2.setText("Luz Roja");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(luzRojaMal1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addComponent(luzAmaMal1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioLuzRoja1)
                                    .addComponent(radioLuzAma1)
                                    .addComponent(radioLuzVerde1)
                                    .addComponent(cantSemaforos1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(luzVerdeMal1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172)
                        .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(luzVerdeMal2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(luzRojaMal2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addComponent(luzAmaMal2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radioLuzRoja2)
                                            .addComponent(radioLuzAma2)
                                            .addComponent(radioLuzVerde2))
                                        .addGap(44, 44, 44))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cantSemaforos2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 36, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addComponent(conectarse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(desconectarse))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(116, 116, 116)
                .addComponent(jLabel7)
                .addGap(206, 206, 206))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(509, Short.MAX_VALUE)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(516, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(406, Short.MAX_VALUE)
                    .addComponent(ingresaYa, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(377, 377, 377)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(conectarse)
                            .addComponent(desconectarse))
                        .addGap(5, 5, 5)
                        .addComponent(bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(radioLuzRoja1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioLuzAma1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioLuzVerde1)
                        .addGap(44, 125, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantSemaforos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radioLuzRoja2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioLuzAma2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioLuzVerde2)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cantSemaforos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(28, 28, 28)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(luzRojaMal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(luzAmaMal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(luzVerdeMal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(luzRojaMal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(luzAmaMal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(luzVerdeMal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 141, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(ingresaYa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(443, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Grupo1;
    private javax.swing.ButtonGroup Grupo2;
    private javax.swing.JLabel bienvenida;
    private javax.swing.JTextField cantSemaforos1;
    private javax.swing.JTextField cantSemaforos2;
    private javax.swing.JButton conectarse;
    private javax.swing.JButton desconectarse;
    private javax.swing.JButton enviar;
    private javax.swing.JLabel ingresaYa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField luzAmaMal1;
    private javax.swing.JTextField luzAmaMal2;
    private javax.swing.JTextField luzRojaMal1;
    private javax.swing.JTextField luzRojaMal2;
    private javax.swing.JTextField luzVerdeMal1;
    private javax.swing.JTextField luzVerdeMal2;
    private javax.swing.JRadioButton radioLuzAma1;
    private javax.swing.JRadioButton radioLuzAma2;
    private javax.swing.JRadioButton radioLuzRoja1;
    private javax.swing.JRadioButton radioLuzRoja2;
    private javax.swing.JRadioButton radioLuzVerde1;
    private javax.swing.JRadioButton radioLuzVerde2;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
