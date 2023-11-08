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

public class IGMenuPrincipal extends JFrame{
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
		this.menuPrincipalFrame.setBounds(100, 100, 450, 426);
		this.menuPrincipalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.menuPrincipalFrame.getContentPane().setLayout(new CardLayout(0, 0));
		this.menuPrincipalFrame.setLocation(700, 200);
		this.menuPrincipalFrame.setVisible(true);

		this.menuPrincipalFrame.getContentPane().add(this.panelMenuPrincipal, "name_224302439441100");
		this.panelMenuPrincipal.setLayout(null);

		this.lblMenuPrincipal.setText("Menu Principal");
		this.lblMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 26));
		this.lblMenuPrincipal.setBounds(120, 0, 182, 83);
		this.panelMenuPrincipal.add(this.lblMenuPrincipal);

		this.btnMenuProcessoSeletivo.setText("Processo \r\nSeletivo");
		this.btnMenuProcessoSeletivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				igPocessoSeletivo.setModal(true);
				igPocessoSeletivo.setVisible(true);
			}
		});

		this.btnMenuProcessoSeletivo.setBounds(126, 106, 159, 52);
		this.panelMenuPrincipal.add(this.btnMenuProcessoSeletivo);

		this.btnMenuCandidato.setText("Candidato");
		this.btnMenuCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				igCandidato.setModal(true);
				igCandidato.setVisible(true);
			}
		});

		this.btnMenuCandidato.setBounds(126, 185, 159, 52);
		this.panelMenuPrincipal.add(this.btnMenuCandidato);

		this.btnMenuProdutor.setText("Produtor");
		this.btnMenuProdutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				igProdutor.setModal(true);
				igProdutor.setVisible(true);
			}
		});

		this.btnMenuProdutor.setBounds(126, 266, 159, 52);
		this.panelMenuPrincipal.add(this.btnMenuProdutor);

		this.separatorMenuPrincipal.setBounds(23, 79, 388, 16);
		this.panelMenuPrincipal.add(this.separatorMenuPrincipal);
	}

	public void setIGVisivel(boolean flag) {
		menuPrincipalFrame.setVisible(flag);
	}
}
