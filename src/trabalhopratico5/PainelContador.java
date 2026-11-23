package trabalhopratico5;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 * Painel que estende JPanel e implementa Runnable.
 * Representa o componente de contagem contendo a lista e o label de finalizacao.
 */
public class PainelContador extends JPanel implements Runnable {

    private int valorMaximo = 1000;
    private int prioridade = Thread.NORM_PRIORITY;
    private Thread thread;
    private DefaultListModel<String> modeloLista;

    // Componentes de interface
    private JScrollPane spLista;
    private JList<String> lstValores;
    private JLabel lblFinal;

    public PainelContador() {
        initComponents();
        modeloLista = new DefaultListModel<>();
        lstValores.setModel(modeloLista);
        lblFinal.setVisible(false);
    }

    private void initComponents() {
        spLista = new JScrollPane();
        lstValores = new JList<>();
        lblFinal = new JLabel();

        spLista.setViewportView(lstValores);

        lblFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFinal.setText("Final");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spLista, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
            .addComponent(lblFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(spLista, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFinal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    public void setValorMaximo(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public int getValorMaximo() {
        return valorMaximo;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setTextoFinal(String texto) {
        lblFinal.setText(texto);
    }

    public JLabel getLblFinal() {
        return lblFinal;
    }

    public JList<String> getLstValores() {
        return lstValores;
    }

    public DefaultListModel<String> getModeloLista() {
        return modeloLista;
    }

    public void limpar() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        modeloLista.clear();
        lblFinal.setVisible(false);
    }

    public void iniciar(int maximo, int prioridade) {
        limpar();
        this.valorMaximo = maximo;
        this.prioridade = prioridade;

        thread = new Thread(this);
        thread.setPriority(prioridade);
        thread.start();
    }

    @Override
    public void run() {
        // Garante que a lista está vazia e o label "Final" oculto ao iniciar
        SwingUtilities.invokeLater(() -> {
            lblFinal.setVisible(false);
            modeloLista.clear();
        });

        for (int i = 0; i < valorMaximo; i++) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            final String valor = String.valueOf(i);
            SwingUtilities.invokeLater(() -> {
                modeloLista.addElement(valor);
                int ultimo = modeloLista.getSize() - 1;
                if (ultimo >= 0) {
                    lstValores.ensureIndexIsVisible(ultimo);
                }
            });

            try {
                // Pequena pausa (ex: 2ms) para permitir chaveamento de threads e atualizacao visual
                Thread.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        // Ao terminar o laco da contagem, torna o label visivel
        SwingUtilities.invokeLater(() -> {
            lblFinal.setVisible(true);
        });
    }
}
