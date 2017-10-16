package barraprogreso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Controller implements ActionListener {

    vInicio vi;
    vProgress vp;
    vHola vh;
    String user = "", pass = "";

    public Controller() {
        vi = new vInicio();
        vi.btnAceptar.addActionListener(this);
        vi.btnCancelar.addActionListener(this);
        vh = new vHola();
        vh.btnFinalizar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vi.btnAceptar) {
            try {
                user = vi.txtUsuario.getText();
                pass = vi.txtPassword.getText();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this.vi, "Campos Vacios");
            }
            if (user.equals("admin") && pass.equals("123")) {
                vp = new vProgress();
                vp.setVisible(true);
                vi.setVisible(false);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int c = 0;
                        while (c <= 100) {
                            try {
                                vp.progress.setValue(c);
                                Thread.sleep(100);
                                c++;
                            } catch (InterruptedException ex) {

                            }
                            if(c>100){
                                vh.setVisible(true);
                                vp.setVisible(false);
                            }
                        }
                    }
                });
                t.start();
            } else {
                JOptionPane.showMessageDialog(this.vi, "Usuario y/o contraseña incorrecta");
            }

        }
        if (e.getSource() == vi.btnCancelar|| e.getSource()==vh.btnFinalizar) {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        Controller c = new Controller();
    }

}
