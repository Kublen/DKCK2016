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
	private Rectangle kontener1;
	private Rectangle kontener2;
	private Rectangle kontener3;
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
		kontener1 = new Rectangle(485,765,30,30);
		kontener2 = new Rectangle(525,765,30,30);
		kontener3 = new Rectangle(565,765,30,30);
		
		
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
		graphics2d.setColor(Color.RED);
		graphics2d.fill(kontener1);
		graphics2d.setColor(Color.ORANGE);
		graphics2d.fill(kontener2);
		graphics2d.setColor(Color.GREEN);
		graphics2d.fill(kontener3);
		droga.setColor(Color.green);
		
		Font font = new Font("Arial", Font.BOLD, 24);
		droga.setFont(font);		
		
		Rectangle2D polka1 = new Rectangle2D.Double(40,40,200,120);
		droga.draw(polka1);
		
		Rectangle2D polka2 = new Rectangle2D.Double(320,40,200,120);
		droga.draw(polka2);
			
		Rectangle2D polka3 = new Rectangle2D.Double(600,40,200,120);
		droga.draw(polka3);
		
		Rectangle2D polka4 = new Rectangle2D.Double(40,280,120,320);
		droga.draw(polka4);	
		
		Rectangle2D polka5 = new Rectangle2D.Double(680,280,120,320);
		droga.draw(polka5);		
		
		Rectangle2D wyjazd = new Rectangle2D.Double(240,720,160,120);
		droga.draw(wyjazd);		
		
		Rectangle2D przyjazd = new Rectangle2D.Double(440,720,160,120);
		droga.draw(przyjazd);
		
		droga.setStroke(new BasicStroke(1));
		droga.setColor(Color.gray);
		for(int i=0; i<rozmiarPojazdu; i++){
			droga.draw(new Line2D.Double(i*rozmiarPojazdu, 0, i*rozmiarPojazdu, rozmiarPlanszy));
			droga.draw(new Line2D.Double(0, i*rozmiarPojazdu, rozmiarPlanszy, i*rozmiarPojazdu));
		}
		droga.setColor(Color.blue);
		droga.drawString("Polka 1", 55, 70);
		droga.drawString("Polka 2", 330, 70);
		droga.drawString("Polka 3", 610, 70);
		droga.drawString("Polka 4", 55, 310);
		droga.drawString("Polka 5", 695, 310);
		droga.drawString("OUT", 255, 750);
		droga.drawString("IN", 455, 750);
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
	
	//wspolrzedne kontenerow
	int[] kontener1xy = {485,765};
	int[] kontener2xy = {525,765};
	int[] kontener3xy = {565,765};
	
	int[] polka1temp={0,0}; 
	int polka2temp=0, polka3temp=0, polka4temp=0, polka5temp=0, intemp=0;
	//polka 1
	int[] polka1miejsce1 = {85,85,0};
	int[] polka1miejsce2 = {165,85,0};
	//polka 2
	int[] polka2miejsce1 = {365,85,0};
	int[] polka2miejsce2 = {445,85,0};
	//polka 3
	int[] polka3miejsce1 = {645,85,0}; //645, 85
	int[] polka3miejsce2 = {725,85,0}; //725, 85
	//polka 4
	int[] polka4miejsce1 = {85,365,0}; //85, 365
	int[] polka4miejsce2 = {85,445,0}; //85, 445
	int[] polka4miejsce3 = {85,525,0}; //85, 525
	//polka 5
	int[] polka5miejsce1 = {725,365,0}; //725, 365
	int[] polka5miejsce2 = {725,445,0}; // 725, 445
	int[] polka5miejsce3 = {725,525,0}; //725, 525
	//out
	int[] outmiejsce1 = {285,765,0}; //
	int[] outmiejsce2 = {325,765,0}; //
	
	//Wazna funkcja, po przeniesieniu robi puste miejsce na polce
	public void WstawZero(int x, int y){
		//polka1
		if(polka1miejsce1[0]==x && polka1miejsce1[1]==y){polka1miejsce1[2]=0;}
		if(polka1miejsce2[0]==x && polka1miejsce2[1]==y){polka1miejsce2[2]=0;}
		//polka2
		if(polka2miejsce1[0]==x && polka2miejsce1[1]==y){polka2miejsce1[2]=0;}
		if(polka2miejsce2[0]==x && polka2miejsce2[1]==y){polka2miejsce2[2]=0;}
		//polka3
		if(polka3miejsce1[0]==x && polka3miejsce1[1]==y){polka3miejsce1[2]=0;}
		if(polka3miejsce2[0]==x && polka3miejsce2[1]==y){polka3miejsce2[2]=0;}
		//polka4
		if(polka4miejsce1[0]==x && polka4miejsce1[1]==y){polka4miejsce1[2]=0;}
		if(polka4miejsce2[0]==x && polka4miejsce2[1]==y){polka4miejsce2[2]=0;}
		if(polka4miejsce1[0]==x && polka4miejsce1[1]==y){polka4miejsce1[2]=0;}
		//polka5
		if(polka5miejsce1[0]==x && polka5miejsce1[1]==y){polka5miejsce1[2]=0;}
		if(polka5miejsce2[0]==x && polka5miejsce2[1]==y){polka5miejsce2[2]=0;}
		if(polka5miejsce1[0]==x && polka5miejsce1[1]==y){polka5miejsce1[2]=0;}
		//polka out
		if(outmiejsce1[0]==x && outmiejsce1[1]==y){outmiejsce1[2]=0;}
		if(outmiejsce2[0]==x && outmiejsce2[1]==y){outmiejsce2[2]=0;}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==pole2 || e.getSource()==potwierdz){
		pole.append("U->: "+pole2.getText()+"\n");
		switch(pole2.getText()){
		//kontener czerwony 1 --------------------------------------------------------------------------------------------
		//polka 1 --------------------------------------------------------------------------------------------
			case "Przenies czerwony kontener na polke 1" :
				if(polka1miejsce1[2]==0){
					WstawZero(kontener1xy[0],kontener1xy[1]);
					pojazd.setLocation(120, 160);x=120;y=160; 
					kontener1.setLocation(polka1miejsce1[0],polka1miejsce1[1]); polka1miejsce1[2]=1;
					kontener1xy[0]=polka1miejsce1[0];
					kontener1xy[1]=polka1miejsce1[1];
					pole.append("W:-> Przeniesiono czerwony kontener na polke 1.\n");
				}
				else if(polka1miejsce2[2]==0){
					pojazd.setLocation(120, 160);x=120;y=160; 
					kontener1.setLocation(polka1miejsce2[0],polka1miejsce2[1]); polka1miejsce2[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=polka1miejsce2[0];
					kontener1xy[1]=polka1miejsce2[1];
					pole.append("W:-> Przeniesiono czerwony kontener na polke 1.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;
		// polka 2 --------------------------------------------------------------------------------------------	
			case "Przenies czerwony kontener na polke 2" : 
				if(polka2miejsce1[2]==0){
					pojazd.setLocation(400, 160);x=400;y=160; 
					kontener1.setLocation(polka2miejsce1[0],polka2miejsce1[1]); polka2miejsce1[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=polka2miejsce1[0];
					kontener1xy[1]=polka2miejsce1[1];
					pole.append("W:-> Przeniesiono czerwony kontener na polke 2.\n");
				}
				else if(polka2miejsce2[2]==0){
					pojazd.setLocation(120, 160);x=120;y=160; 
					kontener1.setLocation(polka2miejsce2[0],polka2miejsce2[1]); polka2miejsce2[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=polka2miejsce2[0];
					kontener1xy[1]=polka2miejsce2[1];
					pole.append("W:-> Przeniesiono czerwony kontener na polke 2.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;
		//polka 3 --------------------------------------------------------------------------------------------	
			case "Przenies czerwony kontener na polke 3" : 
				if(polka3miejsce1[2]==0){
					pojazd.setLocation(680, 160);x=680;y=160;
					kontener1.setLocation(polka3miejsce1[0],polka3miejsce1[1]); polka3miejsce1[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=polka3miejsce1[0];
					kontener1xy[1]=polka3miejsce1[1];
					pole.append("W:-> Przeniesiono czerwony kontener na polke 3.\n");
				}
				else if(polka3miejsce2[2]==0){
					pojazd.setLocation(680, 160);x=680;y=160; 
					kontener1.setLocation(polka3miejsce2[0],polka3miejsce2[1]); polka3miejsce2[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=polka3miejsce2[0];
					kontener1xy[1]=polka3miejsce2[1];
					pole.append("W:-> Przeniesiono czerwony kontener na polke 3.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;
		//polka 4 --------------------------------------------------------------------------------------------		
			case "Przenies czerwony kontener na polke 4" : 
				if(polka4miejsce1[2]==0){
					pojazd.setLocation(160, 400);x=160;y=400;
					kontener1.setLocation(polka4miejsce1[0],polka4miejsce1[1]); polka4miejsce1[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=polka4miejsce1[0];
					kontener1xy[1]=polka4miejsce1[1];
					pole.append("W:-> Przeniesiono czerwony kontener na polke 4.\n");
				}
				else if(polka4miejsce2[2]==0){
					pojazd.setLocation(160, 400);x=160;y=400; 
					kontener1.setLocation(polka4miejsce2[0],polka4miejsce2[1]); polka4miejsce2[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=polka4miejsce2[0];
					kontener1xy[1]=polka4miejsce2[1];
					pole.append("W:-> Przeniesiono czerwony kontener na polke 4.\n");
				}
				else if(polka4miejsce3[2]==0){
					pojazd.setLocation(160, 400);x=160;y=400; 
					kontener1.setLocation(polka4miejsce3[0],polka4miejsce3[1]); polka4miejsce3[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=polka4miejsce3[0];
					kontener1xy[1]=polka4miejsce3[1];
					pole.append("W:-> Przeniesiono czerwony kontener na polke 4.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;
		//polka 5 --------------------------------------------------------------------------------------------	
			case "Przenies czerwony kontener na polke 5" : 
				if(polka5miejsce1[2]==0){
					pojazd.setLocation(640, 400);x=640;y=400;
					kontener1.setLocation(polka5miejsce1[0],polka5miejsce1[1]); polka5miejsce1[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=polka5miejsce1[0];
					kontener1xy[1]=polka5miejsce1[1];
					pole.append("W:-> Przeniesiono czerwony kontener na polke 5.\n");
				}
				else if(polka5miejsce2[2]==0){
					pojazd.setLocation(640, 400);x=640;y=400;
					kontener1.setLocation(polka5miejsce2[0],polka5miejsce2[1]); polka5miejsce2[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=polka5miejsce2[0];
					kontener1xy[1]=polka5miejsce2[1];
					pole.append("W:-> Przeniesiono czerwony kontener na polke 5.\n");
				}
				else if(polka5miejsce3[2]==0){
					pojazd.setLocation(640, 400);x=640;y=400; 
					kontener1.setLocation(polka5miejsce3[0],polka5miejsce3[1]); polka5miejsce3[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=polka5miejsce3[0];
					kontener1xy[1]=polka5miejsce3[1];
					pole.append("W:-> Przeniesiono czerwony kontener na polke 5.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;		
			// strefa out --------------------------------------------------------------------------------------------
            case "Przenies czerwony kontener do strefy out" : 
            	if(outmiejsce1[2]==0){
            		pojazd.setLocation(320, 680);x=320;y=680; 
					kontener1.setLocation(outmiejsce1[0],outmiejsce1[1]); outmiejsce1[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=outmiejsce1[0];
					kontener1xy[1]=outmiejsce1[1];
					pole.append("W:-> Przeniesiono czerwony kontener na strefe out.\n");
				}
				else if(outmiejsce2[2]==0){
					pojazd.setLocation(320, 680);x=320;y=680;
					kontener1.setLocation(outmiejsce2[0],outmiejsce2[1]); outmiejsce2[2]=1;
					WstawZero(kontener1xy[0],kontener1xy[1]);
					kontener1xy[0]=outmiejsce2[0];
					kontener1xy[1]=outmiejsce2[1];
					pole.append("W:-> Przeniesiono czerwony kontener na strefe out.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break; 
		//kontener zolty 2 --------------------------------------------------------------------------------------------
		//polka 1 --------------------------------------------------------------------------------------------	
		    case "Przenies zolty kontener na polke 1" : 
		    	if(polka1miejsce1[2]==0){
					pojazd.setLocation(120, 160);x=120;y=160; 
					kontener2.setLocation(polka1miejsce1[0],polka1miejsce1[1]); polka1miejsce1[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener1xy[0]=polka1miejsce1[0];
					kontener1xy[1]=polka1miejsce1[1];
					pole.append("W:-> Przeniesiono zolty kontener na polke 1.\n");
				}
				else if(polka1miejsce2[2]==0){
					pojazd.setLocation(120, 160);x=120;y=160; 
					kontener2.setLocation(polka1miejsce2[0],polka1miejsce2[1]); polka1miejsce2[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=polka1miejsce2[0];
					kontener2xy[1]=polka1miejsce2[1];
					pole.append("W:-> Przeniesiono zolty kontener na polke 1.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;
		//polka 2 --------------------------------------------------------------------------------------------	
            case "Przenies zolty kontener na polke 2" :
            	if(polka2miejsce1[2]==0){
					pojazd.setLocation(400, 160);x=400;y=160; 
					kontener2.setLocation(polka2miejsce1[0],polka2miejsce1[1]); polka2miejsce1[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=polka2miejsce1[0];
					kontener2xy[1]=polka2miejsce1[1];
					pole.append("W:-> Przeniesiono zolty kontener na polke 2.\n");
				}
				else if(polka2miejsce2[2]==0){
					pojazd.setLocation(120, 160);x=120;y=160; 
					kontener2.setLocation(polka2miejsce2[0],polka2miejsce2[1]); polka2miejsce2[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=polka2miejsce2[0];
					kontener2xy[1]=polka2miejsce2[1];
					pole.append("W:-> Przeniesiono zolty kontener na polke 2.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;
		// polka 3 --------------------------------------------------------------------------------------------	
            case "Przenies zolty kontener na polke 3" :
            	if(polka3miejsce1[2]==0){
            		pojazd.setLocation(680, 160);x=680;y=160; 
					kontener2.setLocation(polka3miejsce1[0],polka3miejsce1[1]); polka3miejsce1[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=polka3miejsce1[0];
					kontener2xy[1]=polka3miejsce1[1];
					pole.append("W:-> Przeniesiono zolty kontener na polke 3.\n");
				}
				else if(polka3miejsce2[2]==0){
					pojazd.setLocation(680, 160);x=680;y=160;
					kontener2.setLocation(polka3miejsce2[0],polka3miejsce2[1]); polka3miejsce2[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=polka3miejsce2[0];
					kontener2xy[1]=polka3miejsce2[1];
					pole.append("W:-> Przeniesiono zolty kontener na polke 3.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;            
        // polka 4 --------------------------------------------------------------------------------------------	
            case "Przenies zolty kontener na polke 4" : 
            	if(polka4miejsce1[2]==0){
            		pojazd.setLocation(160, 400);x=160;y=400; 
					kontener2.setLocation(polka4miejsce1[0],polka4miejsce1[1]); polka4miejsce1[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=polka4miejsce1[0];
					kontener2xy[1]=polka4miejsce1[1];
					pole.append("W:-> Przeniesiono zolty kontener na polke 4.\n");
				}
				else if(polka4miejsce2[2]==0){
					pojazd.setLocation(160, 400);x=160;y=400;
					kontener2.setLocation(polka4miejsce2[0],polka4miejsce2[1]); polka4miejsce2[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=polka4miejsce2[0];
					kontener2xy[1]=polka4miejsce2[1];
					pole.append("W:-> Przeniesiono zolty kontener na polke 4.\n");
				}
				else if(polka4miejsce3[2]==0){
					pojazd.setLocation(160, 400);x=160;y=400;
					kontener2.setLocation(polka4miejsce3[0],polka4miejsce3[1]); polka4miejsce3[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=polka4miejsce3[0];
					kontener2xy[1]=polka4miejsce3[1];
					pole.append("W:-> Przeniesiono zolty kontener na polke 4.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;            
        // polka 5 --------------------------------------------------------------------------------------------	   
            case "Przenies zolty kontener na polke 5" : 
            	if(polka5miejsce1[2]==0){
            		pojazd.setLocation(640, 400);x=640;y=400; 
					kontener2.setLocation(polka5miejsce1[0],polka5miejsce1[1]); polka5miejsce1[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=polka5miejsce1[0];
					kontener2xy[1]=polka5miejsce1[1];
					pole.append("W:-> Przeniesiono zolty kontener na polke 5.\n");
				}
				else if(polka5miejsce2[2]==0){
					pojazd.setLocation(640, 400);x=640;y=400;
					kontener2.setLocation(polka5miejsce2[0],polka5miejsce2[1]); polka5miejsce2[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=polka5miejsce2[0];
					kontener2xy[1]=polka5miejsce2[1];
					pole.append("W:-> Przeniesiono zolty kontener na polke 5.\n");
				}
				else if(polka5miejsce3[2]==0){
					pojazd.setLocation(640, 400);x=640;y=400;
					kontener2.setLocation(polka5miejsce3[0],polka5miejsce3[1]); polka5miejsce3[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=polka5miejsce3[0];
					kontener2xy[1]=polka5miejsce3[1];
					pole.append("W:-> Przeniesiono zolty kontener na polke 5.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;           
		// strefa out --------------------------------------------------------------------------------------------
            case "Przenies zolty kontener do strefy out" : 
            	if(outmiejsce1[2]==0){
            		pojazd.setLocation(320, 680);x=320;y=680;
					kontener2.setLocation(outmiejsce1[0],outmiejsce1[1]); outmiejsce1[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=outmiejsce1[0];
					kontener2xy[1]=outmiejsce1[1];
					pole.append("W:-> Przeniesiono zolty kontener na strefe out.\n");
				}
				else if(outmiejsce2[2]==0){
					pojazd.setLocation(320, 680);x=320;y=680;
					kontener2.setLocation(outmiejsce2[0],outmiejsce2[1]); outmiejsce2[2]=1;
					WstawZero(kontener2xy[0],kontener2xy[1]);
					kontener2xy[0]=outmiejsce2[0];
					kontener2xy[1]=outmiejsce2[1];
					pole.append("W:-> Przeniesiono zolty kontener na strefe out.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break; 
            
        //kontener zielony 3 --------------------------------------------------------------------------------------------
		// polka 1 --------------------------------------------------------------------------------------------	
            case "Przenies zielony kontener na polke 1" : 
            	if(polka1miejsce1[2]==0){
					pojazd.setLocation(120, 160);x=120;y=160; 
					kontener3.setLocation(polka1miejsce1[0],polka1miejsce1[1]); polka1miejsce1[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=polka1miejsce1[0];
					kontener3xy[1]=polka1miejsce1[1];
					pole.append("W:-> Przeniesiono zielony kontener na polke 1.\n");
				}
				else if(polka1miejsce2[2]==0){
					pojazd.setLocation(120, 160);x=120;y=160; 
					kontener3.setLocation(polka1miejsce2[0],polka1miejsce2[1]); polka1miejsce2[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=polka1miejsce2[0];
					kontener3xy[1]=polka1miejsce2[1];
					pole.append("W:-> Przeniesiono zielony kontener na polke 1.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;
		//polka 2 --------------------------------------------------------------------------------------------
            case "Przenies zielony kontener na polke 2" : 
            	if(polka2miejsce1[2]==0){
					pojazd.setLocation(400, 160);x=400;y=160; 
					kontener3.setLocation(polka2miejsce1[0],polka2miejsce1[1]); polka2miejsce1[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=polka2miejsce1[0];
					kontener3xy[1]=polka2miejsce1[1];
					pole.append("W:-> Przeniesiono zielony kontener na polke 2.\n");
				}
				else if(polka2miejsce2[2]==0){
					pojazd.setLocation(120, 160);x=120;y=160; 
					kontener3.setLocation(polka2miejsce2[0],polka2miejsce2[1]); polka2miejsce2[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=polka2miejsce2[0];
					kontener3xy[1]=polka2miejsce2[1];
					pole.append("W:-> Przeniesiono zielony kontener na polke 2.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;
        // polka 3 --------------------------------------------------------------------------------------------
            case "Przenies zielony kontener na polke 3" : 
            	if(polka3miejsce1[2]==0){
            		pojazd.setLocation(680, 160);x=680;y=160; 
					kontener3.setLocation(polka3miejsce1[0],polka3miejsce1[1]); polka3miejsce1[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=polka3miejsce1[0];
					kontener3xy[1]=polka3miejsce1[1];
					pole.append("W:-> Przeniesiono zielony kontener na polke 3.\n");
				}
				else if(polka3miejsce2[2]==0){
					pojazd.setLocation(680, 160);x=680;y=160;
					kontener3.setLocation(polka3miejsce2[0],polka3miejsce2[1]); polka3miejsce2[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=polka3miejsce2[0];
					kontener3xy[1]=polka3miejsce2[1];
					pole.append("W:-> Przeniesiono zielony kontener na polke 3.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;            
        // polka 4 --------------------------------------------------------------------------------------------	    
            case "Przenies zielony kontener na polke 4" : 
            	if(polka4miejsce1[2]==0){
            		pojazd.setLocation(160, 400);x=160;y=400; 
					kontener3.setLocation(polka4miejsce1[0],polka4miejsce1[1]); polka4miejsce1[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=polka4miejsce1[0];
					kontener3xy[1]=polka4miejsce1[1];
					pole.append("W:-> Przeniesiono zielony kontener na polke 4.\n");
				}
				else if(polka4miejsce2[2]==0){
					pojazd.setLocation(160, 400);x=160;y=400;
					kontener3.setLocation(polka4miejsce2[0],polka4miejsce2[1]); polka4miejsce2[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=polka4miejsce2[0];
					kontener3xy[1]=polka4miejsce2[1];
					pole.append("W:-> Przeniesiono zielony kontener na polke 4.\n");
				}
				else if(polka4miejsce3[2]==0){
					pojazd.setLocation(160, 400);x=160;y=400;
					kontener3.setLocation(polka4miejsce3[0],polka4miejsce3[1]); polka4miejsce3[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=polka4miejsce3[0];
					kontener3xy[1]=polka4miejsce3[1];
					pole.append("W:-> Przeniesiono zielony kontener na polke 4.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;        
        // polka 5 --------------------------------------------------------------------------------------------	    
            case "Przenies zielony kontener na polke 5" : 
            	if(polka5miejsce1[2]==0){
            		pojazd.setLocation(640, 400);x=640;y=400; 
					kontener3.setLocation(polka5miejsce1[0],polka5miejsce1[1]); polka5miejsce1[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=polka5miejsce1[0];
					kontener3xy[1]=polka5miejsce1[1];
					pole.append("W:-> Przeniesiono zielony kontener na polke 5.\n");
				}
				else if(polka5miejsce2[2]==0){
					pojazd.setLocation(640, 400);x=640;y=400;
					kontener3.setLocation(polka5miejsce2[0],polka5miejsce2[1]); polka5miejsce2[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=polka5miejsce2[0];
					kontener3xy[1]=polka5miejsce2[1];
					pole.append("W:-> Przeniesiono zielony kontener na polke 5.\n");
				}
				else if(polka5miejsce3[2]==0){
					pojazd.setLocation(640, 400);x=640;y=400;
					kontener3.setLocation(polka5miejsce3[0],polka5miejsce3[1]); polka5miejsce3[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=polka5miejsce3[0];
					kontener3xy[1]=polka5miejsce3[1];
					pole.append("W:-> Przeniesiono zielony kontener na polke 5.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break;
		// out --------------------------------------------------------------------------------------------	 		
            case "Przenies zielony kontener do strefy out" : 
            	if(outmiejsce1[2]==0){
            		pojazd.setLocation(320, 680);x=320;y=680; 
					kontener3.setLocation(outmiejsce1[0],outmiejsce1[1]); outmiejsce1[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=outmiejsce1[0];
					kontener3xy[1]=outmiejsce1[1];
					pole.append("W:-> Przeniesiono zielony kontener na strefe out.\n");
				}
				else if(outmiejsce2[2]==0){
					pojazd.setLocation(320, 680);x=320;y=680;
					kontener3.setLocation(outmiejsce2[0],outmiejsce2[1]); outmiejsce2[2]=1;
					WstawZero(kontener3xy[0],kontener3xy[1]);
					kontener3xy[0]=outmiejsce2[0];
					kontener3xy[1]=outmiejsce2[1];
					pole.append("W:-> Przeniesiono zielony kontener na strefe out.\n");
				}
				else pole.append("W:-> Brak miejsca\n"); break; 
        // default --------------------------------------------------------------------------------------------		
            default : pole.append("U->: "+pole2.getText()+"\n"+"W:-> Nie rozumiem\n");break;
		}
		pole2.setText("");
	}

		
		repaint();
	}
}


/*case "prawo" : pojazd.setLocation(x+40,y); x=x+40;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
case "lewo" : pojazd.setLocation(x-40,y); x=x-40;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
case "dol" : pojazd.setLocation(x,y+40); y=y+40;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
case "gora" : pojazd.setLocation(x,y-40); y=y-40;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
case "Idz do polki 1" : pojazd.setLocation(120, 160);x=120;y=160;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
case "Idz do polki 2" : pojazd.setLocation(400, 160);x=400;y=160;break;
case "Idz do polki 3" : pojazd.setLocation(680, 160);x=680;y=160;break;
case "Idz do polki 4" : pojazd.setLocation(160, 400);x=160;y=320;break;
case "Idz do polki 5" : pojazd.setLocation(640, 480);x=600;y=480;break;
case "out" : pojazd.setLocation(320, 680);x=320;y=680;break;
case "in" : pojazd.setLocation(520, 680);x=120;y=680;break;*/