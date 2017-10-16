package barraprogreso;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class vHola extends JFrame {

    JLabel etiHola;
    JButton btnFinalizar;

    public vHola() {
        this.setTitle("Hola Mundo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setLayout(new AbsoluteLayout());
        etiHola = new JLabel("Hola Mundo");
        etiHola.setFont(new Font("Arial Black", 1, 40));
        btnFinalizar = new JButton("Finalizar");
        this.getContentPane().add(etiHola, new AbsoluteConstraints(100, 50, 476, 40));
        this.getContentPane().add(btnFinalizar, new AbsoluteConstraints(200, 100, 100, 40));
    }

}
