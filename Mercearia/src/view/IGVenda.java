package view;

import dao.DaoProduto;
import dao.DaoVenda;

import model.Produto;
import model.Venda;
import model.filtros.VendaFiltro;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;


public class IGVenda extends JDialog{

	// JTextField
	private JTextField textVendListPreco;

	// JTabbedPane
	private JTabbedPane tabbedPaneVenda;

	// JPanel
	private JPanel panelCadastrarVenda;
	private JPanel panelListarVendas;

	// JLabel
	private JLabel lblCadastrarVenda;
	private JLabel lblVendaCadProduto;
	private JLabel lblVendaQtd;
	private JLabel lblListarVenda;
	private JLabel lblVendaListQtd;
	private JLabel lblVendaListVenda;
	private JLabel lblVendaListPreco;

	// JSeparator
	private JSeparator separatorProdCadastrar;
	private JSeparator separatorCadListar;

	// JButton
	private JButton btnVendCadLimpar;
	private JButton btnVendCadSalvar;
	private JButton btnVendListLimpar;
	private JButton btnVendListPesquisar;

	// JComboBox
	private JComboBox comboBoxVendCadProdutos;
	private JComboBox comboBoxListVendProdutos;

	// JSpinner
	private JSpinner spinnerVendCadQtd;
	private JSpinner spinnerVendListQtd;

	private DaoVenda daoVenda;

	private DaoProduto daoProduto;

	private ArrayList<Produto> produtoList;
	public IGVenda( Frame owner) {
		super(owner);
		instanciaComponentes();
		initializeInterfaceGrafica();
	}
	
	private void instanciaComponentes() {
		// Componentes de JTabbedPane
		this.tabbedPaneVenda = new JTabbedPane();

		// Componentes de JPanel
		this.panelCadastrarVenda = new JPanel();
		this.panelListarVendas = new JPanel();

		// Componentes de JLabel
		this.lblCadastrarVenda = new JLabel();
		this.lblVendaCadProduto = new JLabel();
		this.lblVendaQtd = new JLabel();
		this.lblListarVenda = new JLabel();
		this.lblVendaListQtd = new JLabel();
		this.lblVendaListVenda = new JLabel();
		this.lblVendaListPreco = new JLabel();

		// Componentes de JSeparator
		this.separatorProdCadastrar = new JSeparator();
		this.separatorCadListar = new JSeparator();

		// Componentes de JButton
		this.btnVendCadLimpar = new JButton();
		this.btnVendCadSalvar = new JButton();
		this.btnVendListLimpar = new JButton();
		this.btnVendListPesquisar = new JButton();

		// Componentes de JComboBox
		this.comboBoxVendCadProdutos = new JComboBox();
		this.comboBoxListVendProdutos = new JComboBox();

		// Componentes de JSpinner
		this.spinnerVendCadQtd = new JSpinner();
		this.spinnerVendListQtd = new JSpinner();

		// Componentes de JTextField
		this.textVendListPreco = new JTextField();

		this.produtoList =  new ArrayList<Produto>();

		// DaoVenda
		try{
			this.daoVenda = new DaoVenda();
			this.daoProduto = new DaoProduto();
		}catch( Exception ex){
			ex.printStackTrace();
		}
	}

	private void initializeInterfaceGrafica() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new CardLayout(0, 0));
		this.setLocationRelativeTo(this.getFocusOwner());
		this.tabbedPaneVenda.setTabPlacement(JTabbedPane.TOP);
		this.getContentPane().add(this.tabbedPaneVenda, "name_273216614947300");

		this.panelCadastrarProduto();
		this.panelListarProduto();
	}
	private void panelCadastrarProduto(){
		this.tabbedPaneVenda.addTab("Cadastrar", null, this.panelCadastrarVenda, null);
		this.panelCadastrarVenda.setLayout(null);

		this.lblCadastrarVenda.setText("Venda - Cadastrar");
		this.lblCadastrarVenda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblCadastrarVenda.setBounds(126, 11, 179, 30);
		this.panelCadastrarVenda.add(this.lblCadastrarVenda);

		this.separatorProdCadastrar.setBounds(10, 52, 409, 2);
		this.panelCadastrarVenda.add(this.separatorProdCadastrar);

		this.lblVendaCadProduto.setText("Produto");
		this.lblVendaCadProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblVendaCadProduto.setBounds(20, 76, 59, 19);
		this.panelCadastrarVenda.add(this.lblVendaCadProduto);

		this.lblVendaQtd.setText("Quantidade");
		this.lblVendaQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblVendaQtd.setBounds(238, 76, 85, 19);
		this.panelCadastrarVenda.add(this.lblVendaQtd);

		this.comboBoxVendCadProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.comboBoxVendCadProdutos.setBounds(80, 76, 137, 22);

		try {
			this.produtoList = this.daoProduto.getProdutos();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		this.comboBoxVendCadProdutos.addItem("");

		for( Produto item : this.produtoList){
			this.comboBoxVendCadProdutos.addItem(item.getNome());
		}

		this.panelCadastrarVenda.add(this.comboBoxVendCadProdutos);

		this.spinnerVendCadQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel();
		spinnerNumberModel.setMinimum(0);
		this.spinnerVendCadQtd.setModel(spinnerNumberModel);
		this.spinnerVendCadQtd.setBounds(333, 77, 71, 20);
		this.panelCadastrarVenda.add(this.spinnerVendCadQtd);

		this.btnVendCadLimpar.setText("Limpar");
		this.btnVendCadLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnVendCadLimpar.setBounds(72, 162, 113, 42);
		this.btnVendCadLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxVendCadProdutos.setSelectedIndex(0);
				spinnerVendCadQtd.setValue(0);
			}
		});
		this.panelCadastrarVenda.add(this.btnVendCadLimpar);

		this.btnVendCadSalvar.setText("Salvar");
		this.btnVendCadSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnVendCadSalvar.setBounds(241, 162, 113, 42);
		this.btnVendCadSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeProdutoVendido = comboBoxVendCadProdutos.getSelectedItem().toString();
				long idProdutoVendido;
				int qtd = Integer.parseInt(spinnerVendCadQtd.getValue().toString());

				if( !validaCampoTextoVazio(nomeProdutoVendido)){
					JOptionPane.showMessageDialog(null, "O campo de produto é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if( !validaQuantidadeProduto(qtd) ){
					JOptionPane.showMessageDialog(null, "A quantidade de produtos precisa ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}

				try{
					for( Produto produto : produtoList){
						if( produto.getNome().equals(nomeProdutoVendido)){
							idProdutoVendido = produto.getId();
							daoVenda.postVenda( new Venda(idProdutoVendido, qtd));
							break;
						}
					}
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!!", "Confirmação",  JOptionPane.INFORMATION_MESSAGE);

				} catch ( Exception ex ){
					JOptionPane.showMessageDialog(null, "Exceção: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		this.panelCadastrarVenda.add(this.btnVendCadSalvar);
	}
	private void panelListarProduto(){
		this.tabbedPaneVenda.addTab("Listar", null, this.panelListarVendas, null);
		this.panelListarVendas.setLayout(null);

		this.lblListarVenda.setText("Venda - Listar");
		this.lblListarVenda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblListarVenda.setBounds(143, 16, 171, 25);
		this.panelListarVendas.add(this.lblListarVenda);

		this.separatorCadListar.setBounds(10, 52, 409, 2);
		this.panelListarVendas.add(this.separatorCadListar);

		this.spinnerVendListQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.spinnerVendListQtd.setBounds(333, 73, 71, 20);

		SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel();
		spinnerNumberModel.setMinimum(0);
		this.spinnerVendListQtd.setModel(spinnerNumberModel);
		this.panelListarVendas.add(this.spinnerVendListQtd);

		this.lblVendaListQtd.setText("Quantidade");
		this.lblVendaListQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblVendaListQtd.setBounds(238, 72, 85, 19);
		this.panelListarVendas.add(this.lblVendaListQtd);

		this.comboBoxListVendProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.comboBoxListVendProdutos.setBounds(80, 72, 137, 22);

		try {
			this.produtoList = daoProduto.getProdutos();
			this.comboBoxListVendProdutos.addItem("");

			for( Produto produto : this.produtoList){
				this.comboBoxListVendProdutos.addItem(produto.getNome());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.panelListarVendas.add(this.comboBoxListVendProdutos);

		this.btnVendListLimpar.setText("Limpar");
		this.btnVendListLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnVendListLimpar.setBounds(80, 167, 113, 42);
		this.btnVendListLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxListVendProdutos.setSelectedIndex(0);
				spinnerVendListQtd.setValue(0);
				textVendListPreco.setText("");
			}
		});
		this.panelListarVendas.add(this.btnVendListLimpar);

		this.btnVendListPesquisar.setText("Pesquisar");
		this.btnVendListPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnVendListPesquisar.setBounds(249, 167, 113, 42);
		this.btnVendListPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeProduto = comboBoxListVendProdutos.getSelectedItem().toString();
				String qtdProduto = spinnerVendListQtd.getValue().toString();
				String precoProduto = textVendListPreco.getText().toString();

				ArrayList<Venda> vendasList = null;
				try{
					vendasList = daoVenda.getVendas( new VendaFiltro( nomeProduto, qtdProduto.equals("0") ? "" : qtdProduto, precoProduto ));
				}catch ( Exception ex ){
					JOptionPane.showMessageDialog(null, "Exceção: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

				for( Venda venda : vendasList ){
					System.out.println(venda);
				}
			}
		});
		this.panelListarVendas.add(this.btnVendListPesquisar);

		this.lblVendaListVenda.setText("Produto");
		this.lblVendaListVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblVendaListVenda.setBounds(20, 72, 59, 19);
		this.panelListarVendas.add(this.lblVendaListVenda);

		this.lblVendaListPreco.setText("Preço R$");
		this.lblVendaListPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblVendaListPreco.setBounds(20, 119, 59, 19);
		this.panelListarVendas.add(this.lblVendaListPreco);

		this.textVendListPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.textVendListPreco.setColumns(10);
		this.textVendListPreco.setBounds(93, 120, 86, 20);
		this.panelListarVendas.add(this.textVendListPreco);
	}
	private void tabelaDeProdutos( ArrayList<Venda> resultado ){

	}
	private static boolean validaQuantidadeProduto( int quantidade ){
		if( quantidade < 1 ){
			return false;
		}
		return true;
	}
	private static boolean validaCampoTextoVazio( String texto){
		if( texto.isEmpty() || texto.isBlank() ){
			return false;
		}
		return true;
	}
	private static boolean validaPrecoProduto( Double precoProduto ){
		if( precoProduto < 0 ){
			return false;
		}
		return true;
	}
}
