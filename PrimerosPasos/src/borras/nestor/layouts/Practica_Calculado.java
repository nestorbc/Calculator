package borras.nestor.layouts;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Practica_Calculado {
	
	public static void main(String[] args) {
	
	CalculadoraPractica LaCalculadora = new CalculadoraPractica();
	
	LaCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	LaCalculadora.setVisible(true);
		
	}
}


class CalculadoraPractica extends JFrame{
	
	public CalculadoraPractica(){
		
	
		setBounds(500, 300, 450, 300);
		setTitle("La Calculadora");
		
		PanelCalculadora miLamina = new PanelCalculadora();		
		add(miLamina);
				
	}	
}




class PanelCalculadora extends JPanel{
	
	public PanelCalculadora() {
		
		comienzo = true;
		
		setLayout(new BorderLayout());		
		
		
		pantalla = new JButton("0");
		pantalla.setEnabled(false);
		add(pantalla,BorderLayout.NORTH);
		
		numeracion = new JPanel ();		
		numeracion.setLayout(new GridLayout(4,4));
		
		InsertarNum intertar = new InsertarNum();
		
		Operacion realizarOperacion = new Operacion();
		
		ponerBoton ("7",intertar);
		ponerBoton ("8",intertar);
		ponerBoton("9",intertar);
		ponerBotonOperacion("x",realizarOperacion);
		ponerBoton("4",intertar);
		ponerBoton("5",intertar);
		ponerBoton ("6",intertar);
		ponerBotonOperacion ("-",realizarOperacion);
		ponerBoton("1",intertar);
		ponerBoton("2",intertar);
		ponerBoton("3",intertar);
		ponerBotonOperacion ("+",realizarOperacion);
		ponerBoton ("0",intertar);
		ponerBoton (",",intertar);
		ponerBotonOperacion("=",realizarOperacion);
		ponerBotonOperacion ("/",realizarOperacion);

				
		add(numeracion,BorderLayout.CENTER);		
		
		}
	
		private void ponerBoton (String textoBoton, InsertarNum oyente) {
			
		JButton boton = new JButton (textoBoton);
		
		boton.addActionListener(oyente);
		
		numeracion.add(boton);
		}
		


		private void ponerBotonOperacion (String textoBoton, Operacion oyente) {
	
			JButton boton = new JButton (textoBoton);

			boton.addActionListener(oyente);

			numeracion.add(boton);
		}
		
		private class InsertarNum  implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
								
				String entrada = e.getActionCommand();
				
				if (comienzo) {
					
					pantalla.setText(entrada);	
					
				comienzo = false;
				}
				
				else {
					
					pantalla.setText(pantalla.getText()+entrada);
					
				}
				
				ultimoValor = Double.parseDouble(pantalla.getText());
								
			}						
		}
		private class Operacion implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String operacionPulsada = e.getActionCommand();
				
				if(operacionPulsada.equals("+")) {
					
					double valor = Double.parseDouble(pantalla.getText());
		
					resultado += ultimoValor;
				
					pantalla.setText("" + resultado);
					
					ultimaOperación = "+";
				}
				
				else if (operacionPulsada.equals("x")){
				
					double valor = Double.parseDouble(pantalla.getText());
					
					if (contador == 0) resultado = valor*1;
					
					else {resultado *= ultimoValor;}
															
					pantalla.setText("" + resultado);
					
					ultimaOperación = "x";
					
					contador ++;
					
				}
				
				else if (operacionPulsada.equals("-")){
					
					double valor = Double.parseDouble(pantalla.getText());
					
					if (contador == 0) resultado = valor;
					
					else {resultado -= ultimoValor;}
															
					pantalla.setText("" + resultado);
					
					ultimaOperación = "-";
					
					contador ++;
				}
				
				else if (operacionPulsada.equals("/")){
					
					double valor = Double.parseDouble(pantalla.getText());
					
					if (contador == 0) resultado = valor;
					
					else {
												
							resultado /= ultimoValor;
						}
															
					pantalla.setText("" + resultado);
					
					ultimaOperación = "/";
					
					contador ++;
					}
				
				
				
				else {
					
					if(ultimaOperación.equals("+")) resultado += ultimoValor; 
					if(ultimaOperación.equals("x")) resultado *= ultimoValor; contador =0;
					if(ultimaOperación.equals("-")) resultado -= ultimoValor; contador =0;
					if(ultimaOperación.equals("/")) resultado /= ultimoValor; contador =0;


														
					pantalla.setText("" + resultado);
					
					ultimoValor = 0;
					
				}
				
				comienzo = true;
							
			}
			
			private String ultimaOperación;
			private int contador;

		
		}			
		private JPanel numeracion;		
		private JButton pantalla;		
		private boolean comienzo;		
		private double resultado;
		private double ultimoValor;
}


	
	