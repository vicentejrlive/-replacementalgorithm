/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author horgun
 */
public class JanelaPrincipal extends javax.swing.JFrame {
    private int quantPaginas = 0;
    private int quantMolduras = 0;
    private String simular = "";
    private JLabel tempo;
    private JTable tabela;
    private JTable molduras;
    private long timerStart;

    public int getQuantPaginas() {
        return quantPaginas;
    }

    public void setQuantPaginas(int quantPaginas) {
        this.quantPaginas = quantPaginas;
    }

    public int getQuantMolduras() {
        return quantMolduras;
    }

    public void setQuantMolduras(int quantMolduras) {
        this.quantMolduras = quantMolduras;
    }
    
    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmos de Substituição de Páginas");
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu4.setText("Simulações");

        jMenuItem1.setText("Segunda chance");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.simular = "segundachance";
        Propriedades prop = new Propriedades(this, rootPaneCheckingEnabled);
        prop.executar(this);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }
    
    //Cria as tabelas de páginas e de molduras
    public void inicializarMetodo(){
        timerStart = System.currentTimeMillis();//Inicia relógio
        tempo = new JLabel("Tempo: " + (System.currentTimeMillis() - timerStart)/1000);//Label para mostrar o relógio
        Timer t = new Timer();
        jPanel1.add(tempo);
        //Atualiza o relógio visualmente a cada segundo
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tempo.setText("Tempo: " + (System.currentTimeMillis() - timerStart)/1000);
            }
        }, 1000, 1000);
        tabela = criarTabela();
        JScrollPane tabelaScrollPane = new JScrollPane(tabela);
        jPanel1.add(tabelaScrollPane);
        molduras = criarMolduras();
        JScrollPane moldurasScrollPane = new JScrollPane(molduras);
        jPanel1.add(moldurasScrollPane);
        this.pack();
    }
    //Escrever algoritmo de substuição segunda chance
    public void segundaChance(){
        
    }
    
    //Escrever algoritmo de substuição WSclock
    public void wsClock(){
        
    }
    
    public JTable criarTabela(){
        String colunas[] = {"Pagina", "Tempo Carregado", "Tempo Ultima Ref.", "R", "M"};
        Object dados[][] = new Object[quantPaginas][5];
        for (int i = 0; i < quantPaginas; i++){
            Object obj[] = {i, 0, 0, 0, 0};
            dados[i] = obj;
        }
        return new JTable(dados, colunas);
    }
    
    public JTable criarMolduras(){
        String colunas[] = {"Moldura", "Pagina"};
        Object dados[][] = new Object[quantMolduras][2];
        for (int i = 0; i < quantMolduras; i++){
            Object obj[] = {i, null};
            dados[i] = obj;
        }
        return new JTable(dados, colunas);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
