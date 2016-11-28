import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Plansza extends JPanel implements ActionListener {
	
	private Rectangle pojazd;
	static Timer timer;
	private int rozmiarPojazdu = 40;
	private int rozmiarPlanszy=880;
	JTextArea pole;
	JTextField pole2;
	JButton potwierdz;
	private int x=400;
	private int y=400;
	Plansza(){

		pojazd = new Rectangle(x,y,rozmiarPojazdu,rozmiarPojazdu);
		
		setBackground(Color.white);
		setPreferredSize(new Dimension(500,500));
		setLayout(null);
		JPanel polecenia=new Polecenia();
		polecenia.setBounds(rozmiarPlanszy,0, 300, rozmiarPlanszy);
		add(polecenia);
		polecenia.setLayout(null);
		
		pole = new JTextArea();
		pole2 = new JTextField();
		
		JScrollPane sp = new JScrollPane(pole);
		sp.setBounds(10, 10, 275, 700);
		pole2.setBounds(10, 710, 275, 40);
		pole2.addActionListener(this);
		polecenia.add(pole2);
		polecenia.add(sp);
		potwierdz = new JButton("potwierdz");
		potwierdz.setBounds(10, 755, 200,50);
		polecenia.add(potwierdz);
		potwierdz.addActionListener(this);
		
		setFocusable(true);
		ruch();	
		
	}
	public void paintComponent(Graphics graphics){
		
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		Graphics2D droga = (Graphics2D) graphics;
		droga.setStroke(new BasicStroke(5));
		graphics2d.setColor(Color.BLUE);
		graphics2d.fill(pojazd);
		droga.setColor(Color.green);
		
		Font font = new Font("Arial", Font.BOLD, 24);
		droga.setFont(font);		
		
		Rectangle2D polka1 = new Rectangle2D.Double(35,35,200,100);
		droga.draw(polka1);
		
		Rectangle2D polka2 = new Rectangle2D.Double(300,35,200,100);
		droga.draw(polka2);
			
		Rectangle2D polka3 = new Rectangle2D.Double(575,35,200,100);
		droga.draw(polka3);
		
		Rectangle2D polka4 = new Rectangle2D.Double(35,300,175,450);
		droga.draw(polka4);	
		
		Rectangle2D polka5 = new Rectangle2D.Double(600,300,175,450);
		droga.draw(polka5);		
		
		Rectangle2D wyjazd = new Rectangle2D.Double(275,750,100,75);
		droga.draw(wyjazd);		
		
		Rectangle2D przyjazd = new Rectangle2D.Double(445,750,100,75);
		droga.draw(przyjazd);
		
		droga.setStroke(new BasicStroke(1));
		droga.setColor(Color.gray);
		for(int i=0; i<rozmiarPojazdu; i++){
			droga.draw(new Line2D.Double(i*rozmiarPojazdu, 0, i*rozmiarPojazdu, rozmiarPlanszy));
			droga.draw(new Line2D.Double(0, i*rozmiarPojazdu, rozmiarPlanszy, i*rozmiarPojazdu));
		}
		droga.setColor(Color.blue);
		droga.drawString("Polka 1", 60, 60);
		droga.drawString("Polka 2", 325, 60);
		droga.drawString("Polka 3", 600, 60);
		droga.drawString("Polka 4", 60, 325);
		droga.drawString("Polka 5", 625, 325);
		droga.drawString("OUT", 300, 775);
		droga.drawString("IN", 485, 775);
	}
		
	
	public void przesunPojazdX(int przesuniecie){	
		pojazd.setBounds((int)pojazd.getX()+przesuniecie, (int)pojazd.getY(), (int)pojazd.getWidth(), (int)pojazd.getHeight());		
	}
	
	public void przesunPojazdY(int przesuniecie){
		pojazd.setBounds((int)pojazd.getX(), (int)pojazd.getY()+przesuniecie, (int)pojazd.getWidth(), (int)pojazd.getHeight());
	}
	
	public void ruch(){
		timer = new Timer();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==pole2 || e.getSource()==potwierdz){
		switch(pole2.getText()){
			case "prawo" : pojazd.setLocation(x+40,y); x=x+40;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
			case "lewo" : pojazd.setLocation(x-40,y); x=x-40;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
			case "dol" : pojazd.setLocation(x,y+40); y=y+40;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
			case "gora" : pojazd.setLocation(x,y-40); y=y-40;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
			default : pole.append("U->: "+pole2.getText()+"\n"+"W:-> I chuj\n");break;
		}
		pole2.setText("");
	}

		
		repaint();
	}
}
