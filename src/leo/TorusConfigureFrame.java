package leo;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TorusConfigureFrame extends JFrame{
	
	String fileName = "./mytorus.data";
	JTextField jR1 = new JTextField("5");
	JTextField jN1 = new JTextField("20");
	 JTextField jR2 = new JTextField("5");
	 JTextField jN2 = new JTextField("20");
	 
	public TorusConfigureFrame() {
		Font font = new Font("Serif", Font.ITALIC, 15);
        this.setTitle("TorusConfigureFrame");        
        this.pack();
        this.setVisible(true);
        setLayout(new BorderLayout());
        JPanel jp = new JPanel(new GridLayout(12,1));
        jp.setFont(font);
        JLabel jmlabel = new JLabel("R1");
        jp.add(jmlabel);         
        
        jp.add(jR1);
        JLabel jnlabel = new JLabel("N1");
        jp.add(jnlabel);        
        jp.add(jN1);
        
        JLabel jslabel = new JLabel("R2");
        jp.add(jslabel);       
        jp.add(jR2);
        
        JLabel jwlabel = new JLabel("N2");
        jp.add(jwlabel);        
        jp.add(jN2);        
        JButton pathButton = new JButton("save file to path");
        jp.add(pathButton);       
        
        pathButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            	
            	showpathDialog();
            }          
         });
        
        JButton runButton = new JButton("Run");
        jp.add(runButton);
        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	double R1 = Double.parseDouble(jR1.getText());
            	int N1 = Integer.parseInt(jN1.getText());
            	double R2 = Double.parseDouble(jR1.getText());
            	int N2 = Integer.parseInt(jN1.getText());
            	TorusObj torusObj = new TorusObj(N1,R1,N2,R2, fileName);
            	JOptionPane.showMessageDialog(null, "complete!");
            }          
         });
        
        this.add(jp, BorderLayout.CENTER);           
        this.setBounds(0, 0, 400, 600);        
	}	
	
	public void showpathDialog(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");  		 
		int userSelection = fileChooser.showSaveDialog(this);		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    fileName = fileChooser.getSelectedFile().getAbsolutePath();
		    System.out.println("Save as file: " + fileName);
		}
	}
	public static void main(String[] args) {
		new TorusConfigureFrame();			
	}
}
