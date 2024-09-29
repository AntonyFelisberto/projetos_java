package VIEW;
import MODEL.Aluno; //}importa os pacotes que você criou para usar na inserção para o banco
import DAO.DAOAluno;//}
import javax.swing.JOptionPane;//pra mostrar o painel de execução

public class FormAluno extends javax.swing.JFrame {
    Aluno alu=new Aluno();      //}
    DAOAluno ald=new DAOAluno();//}ta nomeando as classe dos pacotes para serem chamados
    
    public FormAluno() {
        initComponents();//inicia o form
        tx_id.setEnabled(false);//ele inativa 
        tx_nome.grabFocus();//é a partir de onde a escrita vai começar a focar
        //bt_deletar.setVisible(false);  //}vai deixar os botões invisiveis
       // bt_atualizar.setVisible(false);//
        bt_deletar.setEnabled(false);   //ele inativa
        bt_atualizar.setEnabled(false);//ele inativa
    }
    void limpar(){
        tx_id.setText(null);            //apaga o que esta escrito na parte da variavel
        tx_nome.setText(null);          //
        tx_email.setText(null);         //
        tx_senha.setText(null);         //
        tx_nome.grabFocus();            //dar foco no cursor do nome
        bt_deletar.setEnabled(false);   //ele inativa
        bt_atualizar.setEnabled(false); //ele inativa
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tx_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tx_nome = new javax.swing.JTextField();
        tx_email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JToggleButton();
        tx_senha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        tx_pesquisar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bt_pesquisar = new javax.swing.JToggleButton();
        bt_atualizar = new javax.swing.JToggleButton();
        bt_deletar = new javax.swing.JToggleButton();
        bt_salvar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAluno = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id");

        jLabel2.setText("Nome");

        jLabel3.setText("Email");

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel5.setText("senha");

        jLabel6.setText("Pesquisar");

        bt_pesquisar.setText("Pesquisar");

        bt_atualizar.setText("Atualizar");

        bt_deletar.setText("Deletar");
        bt_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deletarActionPerformed(evt);
            }
        });

        bt_salvar.setText("Salvar");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        tabelaAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaAluno);

        jLabel4.setText("FORMULÁRIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(bt_pesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_novo)
                                .addGap(18, 18, 18)
                                .addComponent(bt_atualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_deletar)
                                .addGap(18, 18, 18)
                                .addComponent(bt_salvar))
                            .addComponent(tx_senha)
                            .addComponent(tx_id)
                            .addComponent(tx_nome)
                            .addComponent(tx_email, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tx_pesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))))
                .addGap(0, 74, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addComponent(tx_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_novo)
                    .addComponent(bt_salvar)
                    .addComponent(bt_deletar)
                    .addComponent(bt_atualizar))
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tx_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        if(tx_nome.getText().equals("") || tx_email.getText().equals("") || tx_senha.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "campos vazios ","ERRO",JOptionPane.WARNING_MESSAGE);
        }else{                            //null //mensagem que aparece //titulo da mensagem //tipo de caixa que vai aparecer
        //inserir dados
        alu.setAluno_nome(tx_nome.getText());  //}
        alu.setAluno_email(tx_email.getText());//}ele pega os dados do formulario
        alu.setAluno_senha(tx_senha.getText());//}
        ald.inserirAluno(alu/*passa todos os dados da classe pro banco de dados*/);
        JOptionPane.showMessageDialog(null,"cadastro efetuado");
        limpar();//chamando a função pra limpar tudo
        }
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
       limpar();//chamando a função pra limpar tudo
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deletarActionPerformed
      
    }//GEN-LAST:event_bt_deletarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bt_atualizar;
    private javax.swing.JToggleButton bt_deletar;
    private javax.swing.JToggleButton bt_novo;
    private javax.swing.JToggleButton bt_pesquisar;
    private javax.swing.JToggleButton bt_salvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAluno;
    private javax.swing.JTextField tx_email;
    private javax.swing.JTextField tx_id;
    private javax.swing.JTextField tx_nome;
    private javax.swing.JTextField tx_pesquisar;
    private javax.swing.JPasswordField tx_senha;
    // End of variables declaration//GEN-END:variables
}
