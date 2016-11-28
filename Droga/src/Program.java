import javax.swing.JFrame;
import javax.swing.JPanel;



public class Program extends JFrame {
	
	
	public Program(){
		
		super("Droga");
		JPanel panel = new Plansza();		
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1180,900);
		setResizable(false);
		
	}


}
