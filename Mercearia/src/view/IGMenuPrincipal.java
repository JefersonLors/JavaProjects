package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IGMenuPrincipal {

	// Elementos do tipo JFrame
	private JFrame frame;

	// Elementos do tipo JButton
	private JButton btnMenuVenda;
	private JButton btnMenuProduto;

	// Elementos do tipo JSeparator
	private JSeparator separatorMenuPrincipal;

	// Elementos do tipo JLabel
	private JLabel lblMenuPrincipal;

	// Tela de produtos
	private IGProduto igProduto;

	// Tela de vendas
	private IGVenda igVenda;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new IGMenuPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IGMenuPrincipal() {
		instanciaComponentes();
		initializeInterfaceGrafica();
	}
	private void instanciaComponentes() {
		// Elementos do tipo JFrame
		this.frame = new JFrame();
		this.igVenda = new IGVenda(this.frame);
		this.igProduto = new IGProduto(this.frame);

		// Elementos do tipo JButton
		this.btnMenuVenda = new JButton();
		this.btnMenuProduto = new JButton();

		// Elemento do tipo JSeparator
		this.separatorMenuPrincipal = new JSeparator();

		// Elemento do tipo JLabel
		this.lblMenuPrincipal = new JLabel();
	}

	private void initializeInterfaceGrafica() {
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		this.frame.setLocation(800, 300);
		this.frame.setVisible(true);

		this.lblMenuPrincipal.setText("Menu Principal");
		this.lblMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblMenuPrincipal.setBounds(140, 11, 154, 45);
		this.frame.getContentPane().add(this.lblMenuPrincipal);
	
		this.separatorMenuPrincipal.setBounds(24, 67, 387, 2);
		this.frame.getContentPane().add(this.separatorMenuPrincipal);
	
		this.btnMenuProduto.setText("Produto");
		this.btnMenuProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnMenuProduto.setBounds(147, 91, 126, 45);
		this.btnMenuProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				igProduto.setModal(true);
				igProduto.setVisible(true);
			}
		});
		this.frame.getContentPane().add(this.btnMenuProduto);
	
		this.btnMenuVenda.setText("Venda");
		this.btnMenuVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnMenuVenda.setBounds(147, 167, 126, 45);
		this.btnMenuVenda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				igVenda.setModal(true);
				igVenda.setVisible(true);
			}
		});
		this.frame.getContentPane().add(this.btnMenuVenda);
	}
}
