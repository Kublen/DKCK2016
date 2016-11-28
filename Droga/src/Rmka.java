import java.awt.EventQueue;


public class Rmka{

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Program();
				
			}
		});
		


	}

}