/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VistaPrincipal.java
 *
 * Created on 19-ago-2011, 13:26:29
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

/**
 *
 * @author oscarribera
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /** Creates new form VistaPrincipal */
    public VistaPrincipal() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel = new JTabbedPane();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        menuItemCursos = new JMenuItem();
        jMenu2 = new JMenu();
        menuItemAulas = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("totai3capas");
        getContentPane().add(tabPanel, BorderLayout.CENTER);

        jMenu1.setText("Cursos");

        menuItemCursos.setText("Editar cursos");
        menuItemCursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuItemCursosActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemCursos);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ediciones y aulas");

        menuItemAulas.setText("Editar aulas");
        menuItemAulas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuItemAulasActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemAulas);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void menuItemCursosActionPerformed(ActionEvent evt) {//GEN-FIRST:event_menuItemCursosActionPerformed
    addTabCurso();
}//GEN-LAST:event_menuItemCursosActionPerformed

private void menuItemAulasActionPerformed(ActionEvent evt) {//GEN-FIRST:event_menuItemAulasActionPerformed
    addTabAulas();
}//GEN-LAST:event_menuItemAulasActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VistaPrincipal().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem menuItemAulas;
    private JMenuItem menuItemCursos;
    private JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables

    private void addTabCurso() {
        AbmCurso tabCurso = new AbmCurso();
        this.tabPanel.addTab("Cursos", new JScrollPane(tabCurso));
    }

    private void addTabAulas() {
        AbmAula tabAula = new AbmAula();
        this.tabPanel.addTab("Aulas", new JScrollPane(tabAula));
    }
}
