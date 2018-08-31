package GameModule;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class InitializeBoard extends Frame {
	
	public boolean player1Turn=true;
	public boolean player2Turn=false;
	public boolean player1Won=false;
	public boolean player2Won=false;
	
	public Button button1;
	public Button button2;
	public Button button3;
	public Button button4;
	public Button button5;
	public Button button6;
	public Button button7;
	public Button button8;
	public Button button9;
	
	public TextField field;
	
	InitializeBoard(){
		addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        });
		buttonInitialization();
		setTitle("Tic Tak Toe");
		setSize(300,300);//frame size 300 width and 300 height  
		setLayout(null);//no layout manager  
		setVisible(true);//now frame will be visible, by default not visible  
	}
	
	public void buttonInitialization() {
		button1=new Button(""); 
		button1.setBounds(20,60,80,60);// setting button position 
		button2=new Button(""); 
		button2.setBounds(110,60,80,60);// setting button position 
		button3=new Button(""); 
		button3.setBounds(200,60,80,60);// setting button position 
		button4=new Button(""); 
		button4.setBounds(20,130,80,60);// setting button position 
		button5=new Button(""); 
		button5.setBounds(110,130,80,60);// setting button position 
		button6=new Button(""); 
		button6.setBounds(200,130,80,60);// setting button position 
		button7=new Button(""); 
     	button7.setBounds(20,200,80,60);// setting button position 
		button8=new Button(""); 	
		button8.setBounds(110,200,80,60);// setting button position 
		button9=new Button(""); 
		button9.setBounds(200,200,80,60);// setting button position 
		
		field=new TextField();
		field.setText(StartGame.player1Name+":"+StartGame.player1WonMatch+" "+StartGame.player2Name+":"+StartGame.player2WonMatch);
		field.setBounds(20, 270, 200, 20);
		 
		add(button1);//adding button into frame  
		add(button2);//adding button into frame
		add(button3);//adding button into frame
		add(button4);//adding button into frame
		add(button5);//adding button into frame
		add(button6);//adding button into frame
		add(button7);//adding button into frame
		add(button8);//adding button into frame
		add(button9);//adding button into frame

		add(field);
		
		button1EventOverride();
		button2EventOverride();
		button3EventOverride();
		button4EventOverride();
		button5EventOverride();
		button6EventOverride();
		button7EventOverride();
		button8EventOverride();
		button9EventOverride();
		
	}
	
	public void button1EventOverride() {
		button1.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				buttonEvent(button1);
	        }
		});
	}
	public void button2EventOverride() {
		button2.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				buttonEvent(button2);
	        }
		});
	}
	public void button3EventOverride() {
		button3.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				buttonEvent(button3);
	        }
		});
	}
	public void button4EventOverride() {
		button4.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				buttonEvent(button4);
	        }
		});
	}
	public void button5EventOverride() {
		button5.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				buttonEvent(button5);
	        }
		});
	}
	public void button6EventOverride() {
		button6.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				buttonEvent(button6);
	        }
		});
	}
	public void button7EventOverride() {
		button7.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				buttonEvent(button7);
	        }
		});
	}
	public void button8EventOverride() {
		button8.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				buttonEvent(button8);
	        }
		});
	}
	public void button9EventOverride() {
		button9.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				buttonEvent(button9);
	        }
		});
	}
	
	public void buttonEvent(Button button) {
		if(!button.getLabel().equals("X") || !button.getLabel().equals("O")) {
			if(player1Turn) {
				button.setLabel("X");
				checkForWinPlayer1();
				player1Turn=false;
				player2Turn=true;
			}
			else {
				button.setLabel("O");
				checkForWinPlayer2();
				player1Turn=true;
				player2Turn=false;
			}
		}
		if(player1Won==false && player2Won==false) {
			checkforTie();
		}
	}
	
	public void checkForWinPlayer1(){
		combination(button1,button2,button3,"X",1);
		combination(button4,button5,button6,"X",1);
		combination(button7,button8,button9,"X",1);
		combination(button1,button4,button7,"X",1);
		combination(button2,button5,button8,"X",1);
		combination(button3,button6,button9,"X",1);
		combination(button1,button5,button9,"X",1);
		combination(button3,button5,button7,"X",1);
	}
	
	public void checkForWinPlayer2(){
		combination(button1,button2,button3,"O",2);
		combination(button4,button5,button6,"O",2);
		combination(button7,button8,button9,"O",2);
		combination(button1,button4,button7,"O",2);
		combination(button2,button5,button8,"O",2);
		combination(button3,button6,button9,"O",2);
		combination(button1,button5,button9,"O",2);
		combination(button3,button5,button7,"O",2);
	}
	
	public void combination(Button btn1, Button btn2, Button btn3, String X, int status) {
		if(btn1.getLabel().equals(X)) {
			if(btn2.getLabel().equals(X)) {
				if(btn3.getLabel().equals(X)) {
					if(status==1) {
						player1Won=true;
						StartGame.player1WonMatch++;
						
					}else {
						player2Won=true;
						StartGame.player2WonMatch++;
					}
				}
			}
		}
		if(player1Won==true || player2Won==true) {
			if(status==1) {
				JOptionPane.showMessageDialog(null,StartGame.player1Name+" Won");
			}
			else {
				JOptionPane.showMessageDialog(null,StartGame.player2Name+" Won");
			}
			dispose();
			player1Turn=true;
			player2Turn=false;
			player1Won=false;
			player2Won=false;
			new InitializeBoard();
		}
	}
	
	
	public void checkforTie() {
		if(button1.getLabel().equals("X") || button1.getLabel().equals("O")) {
			if(button2.getLabel().equals("X") || button2.getLabel().equals("O")) {
				if(button3.getLabel().equals("X") || button3.getLabel().equals("O")) {
					if(button4.getLabel().equals("X") || button4.getLabel().equals("O")) {
						if(button5.getLabel().equals("X") || button5.getLabel().equals("O")) {
							if(button6.getLabel().equals("X") || button6.getLabel().equals("O")) {
								if(button7.getLabel().equals("X") || button7.getLabel().equals("O")) {
									if(button8.getLabel().equals("X") || button8.getLabel().equals("O")) {
										if(button9.getLabel().equals("X") || button9.getLabel().equals("O")) {
											JOptionPane.showMessageDialog(null, "Game Tie");
											dispose();
											new InitializeBoard(); 
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
