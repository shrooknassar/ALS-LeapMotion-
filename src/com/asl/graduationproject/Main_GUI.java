package com.asl.graduationproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import com.leapmotion.leap.Controller;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Main_GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_GUI window = new Main_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public Main_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 51, 51));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnTranslateNumbers = new JButton("Translate Numbers");
		btnTranslateNumbers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller controller = new Controller();
				NumbersTranslation listener = new NumbersTranslation();
				UpdateServosLocation servoListener = new UpdateServosLocation() ; 
				controller.addListener(listener);
				controller.addListener(servoListener);
				
				System.out.println("press enter to quit");
				
				try{
					System.in.read();
				}catch(IOException e){
					e.printStackTrace();
				}
				
				controller.removeListener(listener);
				controller.removeListener(servoListener);
			}
		});
		btnTranslateNumbers.setForeground(new Color(0, 102, 102));
		btnTranslateNumbers.setBounds(32, 92, 136, 38);
		frame.getContentPane().add(btnTranslateNumbers);
		
		JButton btnNewButton = new JButton("Tranlsate Alphabet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller controller = new Controller();
				AlphabetTranslation listener = new AlphabetTranslation();
				UpdateServosLocation servoListener = new UpdateServosLocation() ; 
			
				controller.addListener(listener);
				controller.addListener(servoListener);
				
				System.out.println("press enter to quit");
				
				try{
					System.in.read();
				}catch(IOException e1){
					e1.printStackTrace();
				}
				
				controller.removeListener(listener);
				controller.removeListener(servoListener);
			}
		});
		btnNewButton.setForeground(new Color(0, 102, 102));
		btnNewButton.setBounds(250, 92, 136, 38);
		frame.getContentPane().add(btnNewButton);
	}
}
