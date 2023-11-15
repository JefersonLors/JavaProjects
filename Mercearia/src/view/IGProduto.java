package view;

import dao.DaoProduto;

import dao.fromDB.ProdutoFDB;
import model.Produto;
import model.filtros.ProdutoFiltro;
import utils.Utils;

import java.awt.*;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class IGProduto extends JDialog{
	// Elementos do tipo JTextField
	private JTextField textProdCadNome;
	private JTextField textProdCadPreco;
	private JTextField textProdListCodigo;
	private JTextField textProdListPreco;
	private JTextField textProdListNome;

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

	// JScrollPane
	private JScrollPane scrlProdListPesquisar;

	// Dao de produto
	private DaoProduto daoProduto;

	// JTable
	private JTable tableProdutos;

	// JScrollPane
	private JScrollPane scrollPane;
	public IGProduto( Frame owner ) {
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
		this.textProdListNome = new JTextField();
		this.textProdCadNome = new JTextField();
		this.textProdCadPreco = new JTextField();
		this.textProdListCodigo = new JTextField();

		// JScrollPane;
		this.scrlProdListPesquisar =  new JScrollPane();

		// JTable
		this.tableProdutos = new JTable();

		// JScrollPane
		this.scrollPane = new JScrollPane(this.tableProdutos);

		// Dao
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
		this.getContentPane().add(this.tabbedPaneProduto, "name_271883838618499");

		// Configura as abas para aparecer no topo
		this.tabbedPaneProduto.setTabPlacement(JTabbedPane.TOP);

		// Exibe tela de cadastro de produtos;
		panelCadastrarProduto();

		// Exibe tela de lista de produtos
		panelListarProduto();
	}
	private void panelCadastrarProduto(){
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
		this.btnProdCadLimpar.addActionListener((ActionEvent e) -> {
			textProdCadNome.setText("");
			textProdCadPreco.setText("");
		});
		this.panelCadastrarProduto.add(this.btnProdCadLimpar);

		this.btnProdCadSalvar.setText("Salvar");
		this.btnProdCadSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdCadSalvar.setBounds(241, 162, 113, 42);
		this.btnProdCadSalvar.addActionListener((ActionEvent e) -> {
			String nomeProduto = textProdCadNome.getText();
			String precoProduto = textProdCadPreco.getText();

			if( !Utils.validaCampoTextoVazio(nomeProduto)){
				JOptionPane.showMessageDialog(null, "O nome do produto é um campo obrigatório.");
				return;
			}
			if( !Utils.validaCampoTextoVazio(precoProduto)){
				JOptionPane.showMessageDialog(null, "O preco do produto é um campo obrigatório.");
				return;
			}
			if( !Utils.validaPrecoProduto(Double.parseDouble(precoProduto))){
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
		this.btnProdListLimpar.addActionListener((ActionEvent e) -> {
			textProdListNome.setText("");
			textProdListCodigo.setText("");
			textProdListPreco.setText("");
		});
		this.panelListarProduto.add(this.btnProdListLimpar);

		this.btnProdListPesquisar.setText("Pesquisar");
		this.btnProdListPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdListPesquisar.setBounds(262, 167, 113, 42);
		this.btnProdListPesquisar.addActionListener((ActionEvent e) -> {
			String codigoProduto = textProdListCodigo.getText();
			String nomeProduto = textProdListNome.getText();
			String precoProduto = textProdListPreco.getText();

			ProdutoFiltro produtoFiltro = new ProdutoFiltro();

			try {
				if( Utils.validaCampoTextoVazio(codigoProduto)){
					produtoFiltro.id = codigoProduto;
				}

				if( Utils.validaCampoTextoVazio(nomeProduto)){
					produtoFiltro.nome = nomeProduto;
				}
				if( Utils.validaCampoTextoVazio(precoProduto)){
					produtoFiltro.preco = precoProduto;
				}
				ArrayList<ProdutoFDB> produtos = daoProduto.getProdutos(produtoFiltro);
				tabelaDeProdutos(produtos);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Exceção: " + ex.getMessage());
			}
		});
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

		this.textProdListNome.setBounds(105, 127, 273, 20);
		this.panelListarProduto.add(this.textProdListNome);
		this.textProdListNome.setColumns(10);
	}
	private void tabelaDeProdutos( ArrayList<ProdutoFDB> resultado ){
		this.tabbedPaneProduto.remove(this.scrollPane);
		this.tabbedPaneProduto.addTab("Produtos", null, this.scrollPane, BorderLayout.CENTER);
		this.tableProdutos.setModel(new AbstractTableModel() {
			@Override
			public int getRowCount() {
				return resultado.size();
			}
			@Override
			public int getColumnCount() {
				return 3;
			}
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				ProdutoFDB produto = resultado.get(rowIndex);
				switch (columnIndex) {
					case 0: return produto.id;
					case 1: return produto.nome;
					case 2: return produto.preco;
					default: return null;
				}
			}
			@Override
			public String getColumnName(int columnIndex) {
				switch (columnIndex) {
					case 0: return "Id";
					case 1: return "Nome";
					case 2: return "Preco";
					default: return null;
				}
			}
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex) {
					case 0: return int.class;
					case 1: return String.class;
					case 2: return Double.class;
					default: return null;
				}
			}
		});
		this.tabbedPaneProduto.setSelectedComponent(this.scrollPane);
	}

}
