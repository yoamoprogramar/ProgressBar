
package barraprogreso;

import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class vInicio extends JFrame{
     JLabel etiUsuario,etiPassword;
     JTextField txtUsuario;
     JPasswordField txtPassword;
     JButton btnAceptar, btnCancelar;
     
     public vInicio(){
         this.setTitle("Inicio");
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         this.setSize(250, 200);
         this.setLocationRelativeTo(null);
         this.setResizable(false);
         this.getContentPane().setLayout(new AbsoluteLayout());
         etiUsuario=new JLabel("Usuario:");
         etiPassword=new JLabel("Password:");
         txtUsuario=new JTextField();
         txtPassword=new JPasswordField();
         btnAceptar=new JButton("Aceptar");
         btnCancelar=new JButton("Cancelar");
         this.getContentPane().add(etiUsuario,new AbsoluteConstraints(10,20,100,20));
         this.getContentPane().add(etiPassword,new AbsoluteConstraints(10,50,100,20));
         this.getContentPane().add(txtUsuario,new AbsoluteConstraints(110,20,100,20));
         this.getContentPane().add(txtPassword,new AbsoluteConstraints(110,50,100,20));
         this.getContentPane().add(btnAceptar,new AbsoluteConstraints(10,90,90,20));
         this.getContentPane().add(btnCancelar,new AbsoluteConstraints(110,90,90,20));
         this.setVisible(true);
     }
   
    
}
