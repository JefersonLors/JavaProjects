package view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	}

	private void initializeInterfaceGrafica() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new CardLayout(0, 0));
		this.setLocationRelativeTo(this.getFocusOwner());

		this.tabbedPaneVenda.setTabPlacement(JTabbedPane.TOP);
		this.getContentPane().add(this.tabbedPaneVenda, "name_273216614947300");

		this.panelCadastrarVenda.setLayout(null);
		this.tabbedPaneVenda.addTab("Cadastrar", null, this.panelCadastrarVenda, null);

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

		this.btnProdCadLimpar.setText("Limpar");
		this.btnProdCadLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdCadLimpar.setBounds(72, 162, 113, 42);
		this.panelCadastrarVenda.add(this.btnProdCadLimpar);

		this.btnProdCadSalvar.setText("Salvar");
		this.btnProdCadSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdCadSalvar.setBounds(241, 162, 113, 42);
		this.panelCadastrarVenda.add(this.btnProdCadSalvar);

		this.comboBoxVendCadProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.comboBoxVendCadProdutos.setBounds(80, 76, 137, 22);
		this.panelCadastrarVenda.add(this.comboBoxVendCadProdutos);

		this.spinnerVendCadQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.spinnerVendCadQtd.setBounds(333, 77, 71, 20);
		this.panelCadastrarVenda.add(this.spinnerVendCadQtd);

		this.panelListarVendas.setLayout(null);
		this.tabbedPaneVenda.addTab("Listar", null, this.panelListarVendas, null);

		this.lblListarVenda.setText("Venda - Listar");
		this.lblListarVenda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblListarVenda.setBounds(143, 16, 171, 25);
		this.panelListarVendas.add(this.lblListarVenda);

		this.separatorCadListar.setBounds(10, 52, 409, 2);
		this.panelListarVendas.add(this.separatorCadListar);

		this.btnProdListLimpar.setText("Limpar");
		this.btnProdListLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdListLimpar.setBounds(80, 167, 113, 42);
		this.panelListarVendas.add(this.btnProdListLimpar);

		this.btnProdListPesquisar.setText("Pesquisar");
		this.btnProdListPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnProdListPesquisar.setBounds(249, 167, 113, 42);
		this.panelListarVendas.add(this.btnProdListPesquisar);

		this.spinnerVendListQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.spinnerVendListQtd.setBounds(333, 73, 71, 20);
		this.panelListarVendas.add(this.spinnerVendListQtd);

		this.lblVendaListQtd.setText("Quantidade");
		this.lblVendaListQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblVendaListQtd.setBounds(238, 72, 85, 19);
		this.panelListarVendas.add(this.lblVendaListQtd);

		this.comboBoxListVendProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.comboBoxListVendProdutos.setBounds(80, 72, 137, 22);
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
}
