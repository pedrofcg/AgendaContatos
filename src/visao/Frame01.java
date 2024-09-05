package visao;

import entidades.Contatos;
import entidades.Telefone;
import entidades.Endereco;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.ContatoDao;
import controle.Controle;
import entidades.Icrud;
import java.util.List;

abstract public class Frame01 extends javax.swing.JInternalFrame {
    
    private int editingRow = -1;
    private Controle controle;
    

  
    public Frame01() {     
        initComponents();   
        inicializarControle();
        habilitaBotoes(true);
        habilitaCampos(false);
        
        
        try {
            carregarDados("id");
        } catch (Exception ex) {
            Logger.getLogger(Frame01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    abstract public void inicializarComponentes();
    abstract public void salvar();
    
    
    private void inicializarControle() {
        try {
            // Supondo que ContatoDao implemente Icrud
            Icrud contatoDao = new ContatoDao();
            controle = new Controle(contatoDao);
        } catch (Exception ex) {
            Logger.getLogger(Frame01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void carregarDados(String orderBy) throws Exception {
        
        
        List<Contatos> listaContatos = controle.listarContatos(orderBy);
        DefaultTableModel model = (DefaultTableModel) jTableContatos.getModel();
        model.setRowCount(0);  // Limpa a tabela
        for (Contatos contato : listaContatos) {
        String telefone = contato.getTelefone().getDdi() + " " + contato.getTelefone().getDdd() + " " + contato.getTelefone().getNumero();
        String endereco = contato.getEndereco().getLogradouro() + ", " + contato.getEndereco().getNumero() + " , " +
                          contato.getEndereco().getComplemento() + ", " + contato.getEndereco().getCep() + ", " +
                          contato.getEndereco().getCidade() + ", " + contato.getEndereco().getEstado();
        model.addRow(new Object[]{contato.getId(), contato.getNomeCompleto(), contato.getEmail(), telefone, endereco});
    }
    }
    
    public void habilitaBotoes(boolean estado){
        
        
        jButtonExcluir.setEnabled(estado);
        jButtonNovo.setEnabled(estado);
        jButtonSalvar.setEnabled(!estado);
        jButtonCancelar.setEnabled(!estado);
        jButton_Alterar.setEnabled(estado);
        
        
    }
    public void habilitaCampos(boolean estado){
    
        jTextFieldNome_Completo.setEnabled(estado);
        jTextField_Email.setEnabled(estado);
        jTextField_Telefone.setEnabled(estado);
        jTextFieldDDD.setEnabled(estado);
        jTextFieldDDI.setEnabled(estado);
        jTextField_logradouro.setEnabled(estado);
        jTextField_complemento.setEnabled(estado);
        jTextField_numero.setEnabled(estado);
        jTextField_cep.setEnabled(estado);
        jTextField_cidade.setEnabled(estado);
        jTextField_estado.setEnabled(estado);
        
        
    }
    public void limpaCampo(){
    
    jTextFieldNome_Completo.setText("");
    jTextField_Email.setText("");
    jTextField_Telefone.setText("");
    jTextFieldDDD.setText("");
    jTextFieldDDI.setText("");
    jTextField_logradouro.setText("");
    jTextField_complemento.setText("");
    jTextField_numero.setText("");
    jTextField_cep.setText("");
    jTextField_cidade.setText("");
    jTextField_estado.setText("");
    
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBotoes = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jButton_Alterar = new javax.swing.JButton();
        jPanel_Add = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNome_Completo = new javax.swing.JTextField();
        jTextField_Email = new javax.swing.JTextField();
        jTextField_Telefone = new javax.swing.JTextField();
        jTextFieldDDI = new javax.swing.JTextField();
        jTextFieldDDD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField_estado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField_cidade = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField_cep = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_logradouro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField_numero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField_complemento = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContatos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton_consultar = new javax.swing.JButton();
        jTextField_Consultar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBox_Ordenar = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(java.awt.Color.darkGray);
        setPreferredSize(new java.awt.Dimension(1568, 1020));

        jPanelBotoes.setBackground(new java.awt.Color(209, 209, 209));

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/novo.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/remove.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancel.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Fechar.png"))); // NOI18N
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jButton_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/edit.png"))); // NOI18N
        jButton_Alterar.setText("Alterar");
        jButton_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButtonNovo)
                .addGap(26, 26, 26)
                .addComponent(jButtonExcluir)
                .addGap(18, 18, 18)
                .addComponent(jButton_Alterar)
                .addGap(138, 138, 138)
                .addComponent(jButtonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 491, Short.MAX_VALUE)
                .addComponent(jButtonFechar)
                .addGap(388, 388, 388))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonFechar)
                    .addComponent(jButton_Alterar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel_Add.setBackground(new java.awt.Color(209, 209, 209));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel1.setText("Nome Completo :");

        jLabel2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel2.setText("Telefone :");

        jLabel3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel3.setText("Email :");

        jTextField_Email.setText("example@email.com");
        jTextField_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_EmailActionPerformed(evt);
            }
        });

        jTextField_Telefone.setText("xxxxxxxxx");
        jTextField_Telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TelefoneActionPerformed(evt);
            }
        });

        jTextFieldDDI.setText("xx");
        jTextFieldDDI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDDIActionPerformed(evt);
            }
        });

        jTextFieldDDD.setText("(xx)");

        jLabel5.setText("DDI");

        jLabel6.setText("DDD");

        jLabel7.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel7.setText("Endereco:");

        jLabel12.setText("Estado");

        jTextField_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_estadoActionPerformed(evt);
            }
        });

        jLabel13.setText("Cidade");

        jTextField_cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cidadeActionPerformed(evt);
            }
        });

        jLabel11.setText("CEP");

        jTextField_cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cepActionPerformed(evt);
            }
        });

        jLabel14.setText("+");

        jLabel8.setText("Logradouro");

        jTextField_logradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_logradouroActionPerformed(evt);
            }
        });

        jLabel9.setText("Numero");

        jTextField_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_numeroActionPerformed(evt);
            }
        });

        jLabel10.setText("Complemento");

        jTextField_complemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_complementoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_AddLayout = new javax.swing.GroupLayout(jPanel_Add);
        jPanel_Add.setLayout(jPanel_AddLayout);
        jPanel_AddLayout.setHorizontalGroup(
            jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_AddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_AddLayout.createSequentialGroup()
                        .addGroup(jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_AddLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldNome_Completo, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                .addComponent(jTextField_Email))
                            .addGroup(jPanel_AddLayout.createSequentialGroup()
                                .addGroup(jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_AddLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel5))
                                    .addComponent(jTextFieldDDI, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_AddLayout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel_AddLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jTextFieldDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel_AddLayout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel_AddLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_AddLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_logradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(834, Short.MAX_VALUE))
        );
        jPanel_AddLayout.setVerticalGroup(
            jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_AddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNome_Completo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(4, 4, 4)
                .addGroup(jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDDI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jTextField_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_logradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jTableContatos.setBackground(new java.awt.Color(0, 153, 51));
        jTableContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Email", "Telefone", "Endereco"
            }
        ));
        jScrollPane1.setViewportView(jTableContatos);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N

        jButton_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/consultar.png"))); // NOI18N
        jButton_consultar.setText("Consultar");
        jButton_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_consultarActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Digite o Email");

        jComboBox_Ordenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nome", "Email" }));
        jComboBox_Ordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_OrdenarActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Ordenar Por :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1171, 1171, 1171)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(465, 465, 465)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox_Ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1332, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_consultar)
                            .addComponent(jTextField_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_Ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_Add, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        
       
        limpaCampo();
        habilitaCampos(true);
        habilitaBotoes(false);
        
    
        
        
        
        
        
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        
    habilitaBotoes(true);
    habilitaCampos(false);
    
        
    
    try {
        
            
            DefaultTableModel model = (DefaultTableModel) jTableContatos.getModel(); 
            
        // Captura os dados do formulário
        
        String nomeCompleto = jTextFieldNome_Completo.getText();
        int ddi = Integer.parseInt(jTextFieldDDI.getText());
        int ddd = Integer.parseInt(jTextFieldDDD.getText());
        int numero = Integer.parseInt(jTextField_Telefone.getText());
        String email = jTextField_Email.getText();
        String logradouro = jTextField_logradouro.getText();
        int numeroEndereco = Integer.parseInt(jTextField_numero.getText());
        String complemento = jTextField_complemento.getText();
        int cep = Integer.parseInt(jTextField_cep.getText());
        String cidade = jTextField_cidade.getText();
        String estado = jTextField_estado.getText();
        
        // Cria um objeto Telefone
        Telefone telefone = new Telefone(ddi, ddd, numero);
        
        // Cria um objeto Endereco
        Endereco endereco = new Endereco(logradouro, numeroEndereco, complemento, cep, cidade, estado);
        
        // Cria um objeto Contatos
        Contatos contato = new Contatos(0, nomeCompleto, email, telefone, endereco);
        
        String erro = controle.verificar(contato);
        if (!erro.isEmpty()) {
            JOptionPane.showMessageDialog(this, erro, "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        // Chama o método incluir
        if (editingRow == -1){
        controle.incluir(contato);
        model.setRowCount(0);
        carregarDados("id");
        }else{
            int contatoId = (int) jTableContatos.getValueAt(editingRow, 0);
            contato.setId(contatoId);
            controle.alterar(contato);
            model.setRowCount(0);
            carregarDados("id");
            editingRow = -1;
          
        }
        // Limpa os campos e desabilita-os
        limpaCampo();
        habilitaCampos(false);
        habilitaBotoes(true);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao incluir contato: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

        limpaCampo();

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        
        habilitaBotoes(true);
        habilitaCampos(false);
        limpaCampo();
        
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextField_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_EmailActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
         
        
        try {
            
           
        DefaultTableModel model = (DefaultTableModel) jTableContatos.getModel();    
        int linhaSelecionada = jTableContatos.getSelectedRow();

        if (linhaSelecionada >= 0) {
            int confirmacao = JOptionPane.showConfirmDialog(this,
                    "Tem certeza de que deseja excluir ?",
                    "Confirmação de Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirmacao == JOptionPane.YES_OPTION) {
                String nome = jTableContatos.getValueAt(linhaSelecionada, 1).toString();
                controle.excluir(nome);
                 model.setRowCount(0);
                carregarDados("id");
                limpaCampo();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum contato selecionado para exclusão.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao excluir contato: " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
    }
       


        
        
        
        
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTextField_TelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TelefoneActionPerformed

    private void jTextField_logradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_logradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_logradouroActionPerformed

    private void jTextField_cepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_cepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_cepActionPerformed

    private void jTextField_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_estadoActionPerformed

    private void jTextField_cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_cidadeActionPerformed

    private void jTextField_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_numeroActionPerformed

    private void jTextField_complementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_complementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_complementoActionPerformed

    private void jTextFieldDDIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDDIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDDIActionPerformed

    private void jButton_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AlterarActionPerformed
        
        
        int selectedRow = jTableContatos.getSelectedRow();
    
    if (selectedRow >= 0) {
        habilitaCampos(true);
        limpaCampo();
        habilitaBotoes(false);

        editingRow = selectedRow;

       
        jTextFieldNome_Completo.setText((String) jTableContatos.getValueAt(selectedRow, 1));
        jTextField_Email.setText((String) jTableContatos.getValueAt(selectedRow, 2));

        // Para o telefone e endereço, assumindo que você armazena eles como objetos
        String telefoneString = (String) jTableContatos.getValueAt(selectedRow, 3);
        String enderecoString = (String) jTableContatos.getValueAt(selectedRow, 4);
        String telefonePart = telefoneString;        
        jTextFieldDDI.setText(telefonePart.substring(0, 2));
        jTextFieldDDD.setText(telefonePart.substring(3, 5 ));
        jTextField_Telefone.setText(telefonePart.substring(5).replace(" ", ""));

        String[] enderecoParts = enderecoString.split(", ");
        jTextField_logradouro.setText(enderecoParts[0]);
        jTextField_numero.setText(enderecoParts[1].replace(" ", ""));
        jTextField_complemento.setText(enderecoParts[2]);
        jTextField_cep.setText(enderecoParts[3]);
        jTextField_cidade.setText(enderecoParts[4]);
        jTextField_estado.setText(enderecoParts[5]);
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um contato para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton_AlterarActionPerformed

    private void jButton_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_consultarActionPerformed
        
    // Desabilitar todos os campos de texto
    habilitaCampos(false);

    // Desabilitar todos os botões
    habilitaBotoes(false);
    jButtonSalvar.setEnabled(false);

    // Habilitar apenas o campo de texto Consultar
    jTextField_Consultar.setEnabled(true);

    // Obter o email digitado no campo de texto
    String email = jTextField_Consultar.getText();

    try {
        // Instanciar ContatoDao e chamar o método consultar
        ContatoDao dao = new ContatoDao();
        List<Contatos> contatos = dao.consultar(email);

        // Verificar se algum contato foi encontrado
        if (contatos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum contato encontrado.");
        } else {
            // Preencher a tabela com os dados do contato encontrado
            DefaultTableModel model = (DefaultTableModel) jTableContatos.getModel();
            model.setRowCount(0); // Limpar a tabela

            for (Contatos contato : contatos) {
                Object[] row = {
                    contato.getId(),
                    contato.getNomeCompleto(),
                    contato.getEmail(),  
                    contato.getTelefone().getDdi() + "-" + contato.getTelefone().getDdd() + "-" + contato.getTelefone().getNumero(),
                    contato.getEndereco().getLogradouro() + ", " +
                    contato.getEndereco().getNumero() + ", " +
                    contato.getEndereco().getComplemento() + ", " +
                    contato.getEndereco().getCep() + ", " +
                    contato.getEndereco().getCidade() + ", " +
                    contato.getEndereco().getEstado()
                };
                model.addRow(row);
            }

            // Preencher os campos de texto com os dados do primeiro contato encontrado
            int selectedRow = 0; // Assume-se que sempre se pega o primeiro contato encontrado
            int contatoId = (int) jTableContatos.getValueAt(selectedRow, 0);
            jTextFieldNome_Completo.setText((String) jTableContatos.getValueAt(selectedRow, 1));
            jTextField_Email.setText((String) jTableContatos.getValueAt(selectedRow, 2));

            // Preencher os campos de telefone e endereço
            String telefoneString = (String) jTableContatos.getValueAt(selectedRow, 3);
            String enderecoString = (String) jTableContatos.getValueAt(selectedRow, 4);

            // Separar o telefone em partes
            String[] telefoneParts = telefoneString.split("-");
            jTextFieldDDI.setText(telefoneParts[0]);
            jTextFieldDDD.setText(telefoneParts[1]);
            jTextField_Telefone.setText(telefoneParts[2].replace(" ", ""));

            // Separar o endereço em partes
            String[] enderecoParts = enderecoString.split(", ");
            jTextField_logradouro.setText(enderecoParts[0]);
            jTextField_numero.setText(enderecoParts[1].replace(" ", ""));
            jTextField_complemento.setText(enderecoParts[2]);
            jTextField_cep.setText(enderecoParts[3]);
            jTextField_cidade.setText(enderecoParts[4]);
            jTextField_estado.setText(enderecoParts[5]);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao consultar contatos: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton_consultarActionPerformed

    private void jComboBox_OrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_OrdenarActionPerformed
        
    String selectedItem = (String) jComboBox_Ordenar.getSelectedItem();
    String orderBy;
    
    if (selectedItem.equals("ID")) {
        orderBy = "id";
    } else if (selectedItem.equals("Nome")) {
        orderBy = "nomecompleto";
    } else if (selectedItem.equals("Email")) {
        orderBy = "email";
    } else {
        // Default order if the combo box value is unrecognized
        orderBy = "id";
    }

    try {
        carregarDados(orderBy);
    } catch (Exception e) {
        e.printStackTrace();
    }
        
        
        
    }//GEN-LAST:event_jComboBox_OrdenarActionPerformed

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButton_Alterar;
    private javax.swing.JButton jButton_consultar;
    private javax.swing.JComboBox<String> jComboBox_Ordenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanel_Add;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableContatos;
    private javax.swing.JTextField jTextFieldDDD;
    private javax.swing.JTextField jTextFieldDDI;
    public javax.swing.JTextField jTextFieldNome_Completo;
    private javax.swing.JTextField jTextField_Consultar;
    public javax.swing.JTextField jTextField_Email;
    public javax.swing.JTextField jTextField_Telefone;
    private javax.swing.JTextField jTextField_cep;
    private javax.swing.JTextField jTextField_cidade;
    private javax.swing.JTextField jTextField_complemento;
    private javax.swing.JTextField jTextField_estado;
    private javax.swing.JTextField jTextField_logradouro;
    private javax.swing.JTextField jTextField_numero;
    // End of variables declaration//GEN-END:variables
}
