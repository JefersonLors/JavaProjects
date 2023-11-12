package view;

import dao.DaoProduto;
import dao.DaoVenda;
import exceptions.QuantidadeInvalidaException;
import model.Produto;
import model.Venda;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
	private JButton btnProdCadLimpar;
	private JButton btnProdCadSalvar;
	private JButton btnProdListLimpar;
	private JButton btnProdListPesquisar;

	// JComboBox
	private JComboBox comboBoxVendCadProdutos;
	private JComboBox comboBoxListVendProdutos;

	// JSpinner
	private JSpinner spinnerVendCadQtd;
	private JSpinner spinnerVendListQtd;

	private DaoVenda daoVenda;

	private DaoProduto daoProduto;

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
		this.btnProdCadLimpar = new JButton();
		this.btnProdCadSalvar = new JButton();
		this.btnProdListLimpar = new JButton();
		this.btnProdListPesquisar = new JButton();

		// Componentes de JComboBox
		this.comboBoxVendCadProdutos = new JComboBox();
		this.comboBoxListVendProdutos = new JComboBox();

		// Componentes de JSpinner
		this.spinnerVendCadQtd = new JSpinner();
		this.spinnerVendListQtd = new JSpinner();

		// Componentes de JTextField
		this.textVendListPreco = new JTextField();

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

		ArrayList<Produto> produtos = null;

		try {
			produtos = this.daoProduto.getProdutos();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		this.comboBoxVendCadProdutos.addItem("");

		for( Produto item : produtos){
			this.comboBoxVendCadProdutos.addItem(item.getNome());
		}
		this.panelCadastrarVenda.add(this.comboBoxVendCadProdutos);

		this.spinnerVendCadQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel();
		spinnerNumberModel.setMinimum(0);
		this.spinnerVendCadQtd.setModel(spinnerNumberModel);
		this.spinnerVendCadQtd.setBounds(333, 77, 71, 20);
		this.panelCadastrarVenda.add(this.spinnerVendCadQtd);

		this.btnProdCadLimpar.setText("Limpar");
		this.btnProdCadLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdCadLimpar.setBounds(72, 162, 113, 42);
		this.btnProdCadLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxVendCadProdutos.setSelectedIndex(0);
				spinnerVendCadQtd.setValue(0);
			}
		});
		this.panelCadastrarVenda.add(this.btnProdCadLimpar);

		this.btnProdCadSalvar.setText("Salvar");
		this.btnProdCadSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdCadSalvar.setBounds(241, 162, 113, 42);
		this.btnProdCadSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		this.panelCadastrarVenda.add(this.btnProdCadSalvar);
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

		this.btnProdListLimpar.setText("Limpar");
		this.btnProdListLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdListLimpar.setBounds(80, 167, 113, 42);
		this.btnProdListLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxListVendProdutos.setSelectedIndex(0);
				spinnerVendListQtd.setValue(0);
				textVendListPreco.setText("");
			}
		});
		this.panelListarVendas.add(this.btnProdListLimpar);

		this.btnProdListPesquisar.setText("Pesquisar");
		this.btnProdListPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdListPesquisar.setBounds(249, 167, 113, 42);
		this.panelListarVendas.add(this.btnProdListPesquisar);

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

		ArrayList<Produto> produtos = null;

		try {
			produtos = this.daoProduto.getProdutos();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		this.comboBoxListVendProdutos.addItem("");

		for( Produto item : produtos){
			this.comboBoxListVendProdutos.addItem(item.getNome());
		}

		this.panelListarVendas.add(this.comboBoxListVendProdutos);

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
}
