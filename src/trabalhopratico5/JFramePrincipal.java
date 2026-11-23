package trabalhopratico5;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 * Formulario principal da aplicacao Trabalho Pratico 5.
 * Controla a inicializacao das Threads com suas respectivas prioridades.
 */
public class JFramePrincipal extends JFrame {

    // Componentes de interface
    private JLabel lblMaximo;
    private JTextField txtMaximo;
    private JLabel lblPrioridade1;
    private JTextField txtPrioridade1;
    private JLabel lblPrioridade2;
    private JTextField txtPrioridade2;
    private JLabel lblObsPrioridades;
    private JButton btnIniciar;
    private JButton btnLimpar;
    
    // Paineis que implementam Runnable (um para cada Thread)
    private PainelContador painel1;
    private PainelContador painel2;

    public JFramePrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        lblMaximo = new JLabel();
        txtMaximo = new JTextField();
        lblPrioridade1 = new JLabel();
        txtPrioridade1 = new JTextField();
        lblPrioridade2 = new JLabel();
        txtPrioridade2 = new JTextField();
        lblObsPrioridades = new JLabel();
        btnIniciar = new JButton();
        painel1 = new PainelContador();
        painel2 = new PainelContador();
        btnLimpar = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabalho Prático 5");

        lblMaximo.setText("Máximo:");

        txtMaximo.setText("1000");

        lblPrioridade1.setText("Prioridade 1:");

        txtPrioridade1.setText("1");

        lblPrioridade2.setText("Prioridade 2:");

        txtPrioridade2.setText("10");

        lblObsPrioridades.setFont(new java.awt.Font("Segoe UI", 0, 11));
        lblObsPrioridades.setText("<html><font size='6' face='Times New Roman'>}</font>&nbsp;Número entre 1 e 10</html>");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        // Layout no formato padrao gerado pelo NetBeans GUI Builder (GroupLayout)
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrioridade1)
                            .addComponent(lblPrioridade2)
                            .addComponent(lblMaximo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtPrioridade1)
                            .addComponent(txtPrioridade2))
                        .addGap(18, 18, 18)
                        .addComponent(lblObsPrioridades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(painel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaximo)
                    .addComponent(txtMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrioridade1)
                            .addComponent(txtPrioridade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrioridade2)
                            .addComponent(txtPrioridade2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblObsPrioridades))
                .addGap(18, 18, 18)
                .addComponent(btnIniciar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLimpar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        int maximo;
        int prioridade1;
        int prioridade2;

        // Validacao do campo maximo
        try {
            maximo = Integer.parseInt(txtMaximo.getText().trim());
            if (maximo <= 0) {
                JOptionPane.showMessageDialog(this, "O valor máximo deve ser um número maior que zero.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um número inteiro válido para o valor máximo.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validacao da Prioridade 1 (1 a 10)
        try {
            prioridade1 = Integer.parseInt(txtPrioridade1.getText().trim());
            if (prioridade1 < Thread.MIN_PRIORITY || prioridade1 > Thread.MAX_PRIORITY) {
                JOptionPane.showMessageDialog(this, "A Prioridade 1 deve ser um número entre 1 e 10.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um número inteiro válido (1 a 10) para a Prioridade 1.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validacao da Prioridade 2 (1 a 10)
        try {
            prioridade2 = Integer.parseInt(txtPrioridade2.getText().trim());
            if (prioridade2 < Thread.MIN_PRIORITY || prioridade2 > Thread.MAX_PRIORITY) {
                JOptionPane.showMessageDialog(this, "A Prioridade 2 deve ser um número entre 1 e 10.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um número inteiro válido (1 a 10) para a Prioridade 2.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Limpa as listas e oculta os labels Fim1/Fim2
        painel1.limpar();
        painel2.limpar();

        // Configura o valor maximo nos dois paineis
        painel1.setValorMaximo(maximo);
        painel2.setValorMaximo(maximo);

        // Cria as duas Threads recebendo os paineis como Runnable
        Thread t1 = new Thread(painel1);
        t1.setPriority(prioridade1);

        Thread t2 = new Thread(painel2);
        t2.setPriority(prioridade2);

        // Inicia a execucao concorrente das duas threads
        t1.start();
        t2.start();
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        painel1.limpar();
        painel2.limpar();
    }

    public static void main(String args[]) {
        /* Define aparencia do sistema */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // Caso Nimbus nao esteja disponivel, mantem o padrao
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }
}
