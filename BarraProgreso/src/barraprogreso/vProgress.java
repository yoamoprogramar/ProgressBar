package barraprogreso;

import java.awt.Color;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class vProgress extends JFrame {

    JProgressBar progress;

    public vProgress() {
        this.setTitle("ProgressBar");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setLayout(new AbsoluteLayout());
        progress= new JProgressBar(0, 100);
        progress.setStringPainted(true);
        progress.setBackground(Color.red);
        progress.setForeground(Color.yellow);
        progress.setBorderPainted(true);
        this.getContentPane().add(progress, new AbsoluteConstraints(10, 50, 476, 40));
        
    }
 

}
