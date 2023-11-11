package view;

import dao.DaoProduto;
import model.Produto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class IGProduto extends JDialog{
	// Elementos do tipo JTextField
	private JTextField textProdCadNome;
	private JTextField textProdCadPreco;
	private JTextField textProdListCodigo;
	private JTextField textProdListPreco;
	private JTextField textListNome;

	// Elementos do tipo JTabbedPane e JPanel
	private JTabbedPane tabbedPaneProduto;
	private JPanel panelCadastrarProduto;
	private JPanel panelListarProduto;

	// Elementos do tipo JLabel e JSeparator
	private JLabel lblCadastrarProduto;
	private JLabel lblProdCadNome;
	private JLabel lblProdCadPreco;
	private JLabel lblProdListarId;
	private JLabel lblListarProduto;
	private JLabel lblProdListPreco;
	private JLabel lblProdListarNome;
	private JSeparator separatorProdCadastrar;
	private JSeparator separatorProdListar;

	// Elementos do tipo JButton
	private JButton btnProdCadLimpar;
	private JButton btnProdCadSalvar;
	private JButton btnProdListLimpar;
	private JButton btnProdListPesquisar;

	// Dao de produto
	private DaoProduto daoProduto;

	public IGProduto( Frame owner) {
		super(owner);
		instanciaComponentes();
		initializeInterfaceGrafica();
	}
	private void instanciaComponentes(){
		// Elementos do tipo JTabbedPane e JPanel
		this.tabbedPaneProduto = new JTabbedPane();
		this.panelCadastrarProduto = new JPanel();
		this.panelListarProduto = new JPanel();

		// Elementos do tipo JLabel e JSeparator
		this.lblCadastrarProduto = new JLabel();
		this.lblProdCadNome = new JLabel();
		this.lblProdCadPreco = new JLabel();
		this.lblListarProduto = new JLabel();
		this.lblProdListarId = new JLabel();
		this.lblProdListPreco = new JLabel();
		this.lblProdListarNome = new JLabel();
		this.separatorProdCadastrar = new JSeparator();
		this.separatorProdListar = new JSeparator();

		// Elementos do tipo JButton
		this.btnProdCadLimpar = new JButton();
		this.btnProdCadSalvar = new JButton();
		this.btnProdListLimpar = new JButton();
		this.btnProdListPesquisar = new JButton();

		// Elementos do tipo JTextField
		this.textProdListPreco = new JTextField();
		this.textListNome = new JTextField();
		this.textProdCadNome = new JTextField();
		this.textProdCadPreco = new JTextField();
		this.textProdListCodigo = new JTextField();

		try{
			this.daoProduto = new DaoProduto();
		}catch( Exception ex ){
			ex.printStackTrace();
		}
	}
	private void initializeInterfaceGrafica() {
		// Configura a janela em que irão aparecer as abas
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new CardLayout(0, 0));
		this.setLocationRelativeTo(this.getFocusOwner());

		// Configura as abas para aparecer no topo
		this.tabbedPaneProduto.setTabPlacement(JTabbedPane.TOP);

		// Exibe tela de cadastro de produtos;
		panelCadastrarProduto();

		// Exibe tela de lista de produtos
		panelListarProduto();
	}
	private void panelCadastrarProduto(){
		this.getContentPane().add(this.tabbedPaneProduto, "name_271883838618499");
		this.tabbedPaneProduto.addTab("Cadastrar", null, this.panelCadastrarProduto, null);
		this.panelCadastrarProduto.setLayout(null);

		this.lblCadastrarProduto.setText("Produto - Cadastrar");
		this.lblCadastrarProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblCadastrarProduto.setBounds(126, 11, 179, 30);
		this.panelCadastrarProduto.add(this.lblCadastrarProduto);

		this.separatorProdCadastrar.setBounds(10, 52, 409, 2);
		this.panelCadastrarProduto.add(this.separatorProdCadastrar);

		this.lblProdCadNome.setText("Nome");
		this.lblProdCadNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblProdCadNome.setBounds(20, 76, 59, 19);
		this.panelCadastrarProduto.add(this.lblProdCadNome);

		this.textProdCadNome.setBounds(72, 77, 171, 19);
		this.panelCadastrarProduto.add(this.textProdCadNome);
		this.textProdCadNome.setColumns(10);

		this.lblProdCadPreco.setText("Preço R$");
		this.lblProdCadPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblProdCadPreco.setBounds(253, 75, 59, 19);
		this.panelCadastrarProduto.add(this.lblProdCadPreco);

		this.textProdCadPreco.setColumns(10);
		this.textProdCadPreco.setBounds(326, 76, 81, 19);
		this.panelCadastrarProduto.add(this.textProdCadPreco);

		this.btnProdCadLimpar.setText("Limpar");
		this.btnProdCadLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdCadLimpar.setBounds(72, 162, 113, 42);
		this.panelCadastrarProduto.add(this.btnProdCadLimpar);

		this.btnProdCadSalvar.setText("Salvar");
		this.btnProdCadSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdCadSalvar.setBounds(241, 162, 113, 42);
		this.btnProdCadSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeProduto = textProdCadNome.getText();
				String precoProduto = textProdCadPreco.getText();

				if( !validaCampoTextoVazio(nomeProduto)){
					JOptionPane.showMessageDialog(null, "O nome do produto é um campo obrigatório.");
					return;
				}
				if( !validaCampoTextoVazio(precoProduto)){
					JOptionPane.showMessageDialog(null, "O preco do produto é um campo obrigatório.");
					return;
				}
				if( !validaPrecoProduto(Double.parseDouble(precoProduto))){
					JOptionPane.showMessageDialog(null, "O preco do produto não pode ser negativo.");
					return;
				}
				try {
					Produto novoProduto = new Produto(nomeProduto, Double.parseDouble(precoProduto));
					daoProduto.postProduto(novoProduto);
					JOptionPane.showMessageDialog(null, "Produto " + novoProduto + " salvo com sucesso!");
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Exceção: " + ex.getMessage());
					System.exit(1);
				}
			}
		});
		this.panelCadastrarProduto.add(this.btnProdCadSalvar);
	}
	private void panelListarProduto(){
		this.tabbedPaneProduto.addTab("Listar", null, this.panelListarProduto, null);
		this.panelListarProduto.setLayout(null);

		this.lblListarProduto.setText("Produto - Listar");
		this.lblListarProduto.setBounds(134, 16, 171, 25);
		this.lblListarProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panelListarProduto.add(this.lblListarProduto);

		this.separatorProdListar.setBounds(10, 52, 409, 2);
		this.panelListarProduto.add(this.separatorProdListar);

		this.lblProdListarId.setText("Código");
		this.lblProdListarId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblProdListarId.setBounds(47, 78, 59, 19);
		this.panelListarProduto.add(this.lblProdListarId);

		this.textProdListCodigo.setBounds(105, 79, 86, 20);
		this.panelListarProduto.add(this.textProdListCodigo);
		this.textProdListCodigo.setColumns(10);

		this.btnProdListLimpar.setText("Limpar");
		this.btnProdListLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdListLimpar.setBounds(93, 167, 113, 42);
		this.btnProdCadLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textProdCadNome.setText("");
				textProdCadPreco.setText("");
			}
		});
		this.panelListarProduto.add(this.btnProdListLimpar);

		this.btnProdListPesquisar.setText("Pesquisar");
		this.btnProdListPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdListPesquisar.setBounds(262, 167, 113, 42);
		this.panelListarProduto.add(this.btnProdListPesquisar);

		this.textProdListPreco.setColumns(10);
		this.textProdListPreco.setBounds(289, 79, 86, 20);
		this.panelListarProduto.add(this.textProdListPreco);

		this.lblProdListPreco.setText("Preco R$");
		this.lblProdListPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblProdListPreco.setBounds(218, 78, 59, 19);
		this.panelListarProduto.add(this.lblProdListPreco);

		this.lblProdListarNome.setText("Nome");
		this.lblProdListarNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblProdListarNome.setBounds(47, 126, 59, 19);
		this.panelListarProduto.add(this.lblProdListarNome);

		this.textListNome.setBounds(105, 127, 273, 20);
		this.panelListarProduto.add(this.textListNome);
		this.textListNome.setColumns(10);
	}
	private boolean validaCampoTextoVazio( String texto){
		if( texto.isBlank() || texto.isEmpty() ){
			return false;
		}
		return true;
	}
	private boolean validaPrecoProduto( Double precoProduto ){
		if( precoProduto < 0 ){
			return false;
		}
		return true;
	}
}
