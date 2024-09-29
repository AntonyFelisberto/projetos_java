
package VIEW;

public class formPrincipal extends javax.swing.JFrame {


    public formPrincipal() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        areaPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menuNovoFuncionario = new javax.swing.JMenuItem();
        menuGerenciarFuncionario = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuRelatorios = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout areaPrincipalLayout = new javax.swing.GroupLayout(areaPrincipal);
        areaPrincipal.setLayout(areaPrincipalLayout);
        areaPrincipalLayout.setHorizontalGroup(
            areaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        areaPrincipalLayout.setVerticalGroup(
            areaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        jMenu2.setText("Funcionario");

        menuNovoFuncionario.setText("Novo Funcionário");
        menuNovoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoFuncionarioActionPerformed(evt);
            }
        });
        jMenu2.add(menuNovoFuncionario);

        menuGerenciarFuncionario.setText("Gerenciar Funcionário");
        jMenu2.add(menuGerenciarFuncionario);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");

        menuRelatorios.setText("Relatório Funcionários");
        jMenu3.add(menuRelatorios);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Sair");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNovoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoFuncionarioActionPerformed
        
        formFuncionario fun = new formFuncionario();
        areaPrincipal.add(fun);
        fun.show();
    }//GEN-LAST:event_menuNovoFuncionarioActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane areaPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuGerenciarFuncionario;
    private javax.swing.JMenuItem menuNovoFuncionario;
    private javax.swing.JMenuItem menuRelatorios;
    // End of variables declaration//GEN-END:variables
}
