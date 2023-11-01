package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import java.awt.EventQueue;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import interfaces.IGComum;

public class IGMenuPrincipal extends JFrame implements IGComum {

	private JFrame menuPrincipalFrame;
	
	private JPanel panelMenuPrincipal;
	
	private JLabel lblMenuPrincipal;
	
	private JButton btnMenuProcessoSeletivo;
	private JButton btnMenuCandidato;
	private JButton btnMenuProdutor;
	private JSeparator separatorMenuPrincipal;
	
	private IGProcessoSeletivo igPocessoSeletivo;
	private IGCandidato igCandidato;
	private IGProdutor igProdutor;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IGMenuPrincipal window = new IGMenuPrincipal();
					window.menuPrincipalFrame = new JFrame();
					
					window.panelMenuPrincipal = new JPanel();
					
					window.lblMenuPrincipal = new JLabel();
					
					window.btnMenuProcessoSeletivo = new JButton();
					window.btnMenuCandidato = new JButton();
					window.btnMenuProdutor = new JButton();
					
					window.separatorMenuPrincipal = new JSeparator();
					
					window.igPocessoSeletivo = new IGProcessoSeletivo(window.menuPrincipalFrame, true);
					window.igCandidato = new IGCandidato(window.menuPrincipalFrame);
					window.igProdutor = new IGProdutor(window.menuPrincipalFrame);
					
					window.inicializaInterfaceGrafica();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public void inicializaInterfaceGrafica() {
		menuPrincipalFrame.setBounds(100, 100, 450, 426);
		menuPrincipalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipalFrame.getContentPane().setLayout(new CardLayout(0, 0));
		
		menuPrincipalFrame.setLocation(700, 200);
		menuPrincipalFrame.setVisible(true);
		
		menuPrincipalFrame.getContentPane().add(panelMenuPrincipal, "name_224302439441100");
		panelMenuPrincipal.setLayout(null);
		
		lblMenuPrincipal.setText("Menu Principal");
		lblMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuPrincipal.setBounds(120, 0, 182, 83);
		panelMenuPrincipal.add(lblMenuPrincipal);
		
		btnMenuProcessoSeletivo.setText("Processo \r\nSeletivo");
		
		btnMenuProcessoSeletivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				igPocessoSeletivo.setModal(true);
				igPocessoSeletivo.setVisible(true);
			}
		});
		
		btnMenuProcessoSeletivo.setBounds(126, 106, 159, 52);
		panelMenuPrincipal.add(btnMenuProcessoSeletivo);
		
		btnMenuCandidato.setText("Candidato");
		btnMenuCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				igCandidato.setModal(true);
				igCandidato.setVisible(true);		
			}
		});
		
		btnMenuCandidato.setBounds(126, 185, 159, 52);
		panelMenuPrincipal.add(btnMenuCandidato);
		
		btnMenuProdutor.setText("Produtor");
		btnMenuProdutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				igProdutor.setModal(true);
				igProdutor.setVisible(true);
			}
		});
		
		btnMenuProdutor.setBounds(126, 266, 159, 52);
		panelMenuPrincipal.add(btnMenuProdutor);
		
		separatorMenuPrincipal.setBounds(23, 79, 388, 16);
		panelMenuPrincipal.add(separatorMenuPrincipal);
		
	}

	public void setIGVisivel(boolean flag) {
		menuPrincipalFrame.setVisible(flag);
	}
}
