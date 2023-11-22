package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class IGMenuPrincipal extends JFrame{
	private JPanel panelMenuPrincipal = new JPanel();

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				IGMenuPrincipal window = new IGMenuPrincipal();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	public IGMenuPrincipal() {
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		setVisible(true);

		getContentPane().add(panelMenuPrincipal, "name_204553905066100");
		panelMenuPrincipal.setLayout(null);
		
		JButton btnMenuPrincipLivro = new JButton("Livro");
		btnMenuPrincipLivro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMenuPrincipLivro.setBounds(160, 11, 105, 43);
		btnMenuPrincipLivro.addActionListener( (e) -> {
				new IGLivro(this);
			});
		panelMenuPrincipal.add(btnMenuPrincipLivro);
		
		JButton btnMenuPrincipAutor = new JButton("Autor");
		btnMenuPrincipAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMenuPrincipAutor.setBounds(160, 75, 105, 43);
		panelMenuPrincipal.add(btnMenuPrincipAutor);
		
		JButton btnMenuPrincipEditora = new JButton("Editora");
		btnMenuPrincipEditora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMenuPrincipEditora.setBounds(160, 142, 105, 43);
		panelMenuPrincipal.add(btnMenuPrincipEditora);
		
		JButton btnMenuPrincipVenda = new JButton("Venda");
		btnMenuPrincipVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMenuPrincipVenda.setBounds(160, 207, 105, 43);
		panelMenuPrincipal.add(btnMenuPrincipVenda);
	}
}
