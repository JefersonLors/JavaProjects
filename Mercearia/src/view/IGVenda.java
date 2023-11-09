package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IGVenda extends JDialog{
	// JFrame
	private JFrame frame;

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

	public IGVenda() {
		instanciaComponentes();
		initialize();
	}
	
	private void instanciaComponentes() {
		// Componentes de JFrame
		this.frame = new JFrame();

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		tabbedPaneVenda.setTabPlacement(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPaneVenda, "name_273216614947300");
		
		panelCadastrarVenda.setLayout(null);
		tabbedPaneVenda.addTab("Cadastrar", null, panelCadastrarVenda, null);

		lblCadastrarVenda.setText("Venda - Cadastrar");
		lblCadastrarVenda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastrarVenda.setBounds(126, 11, 179, 30);
		panelCadastrarVenda.add(lblCadastrarVenda);

		separatorProdCadastrar.setBounds(10, 52, 409, 2);
		panelCadastrarVenda.add(separatorProdCadastrar);
		
		lblVendaCadProduto.setText("Produto");
		lblVendaCadProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVendaCadProduto.setBounds(20, 76, 59, 19);
		panelCadastrarVenda.add(lblVendaCadProduto);
		
		lblVendaQtd.setText("Quantidade");
		lblVendaQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVendaQtd.setBounds(238, 76, 85, 19);
		panelCadastrarVenda.add(lblVendaQtd);
		
		btnProdCadLimpar.setText("Limpar");
		btnProdCadLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnProdCadLimpar.setBounds(72, 162, 113, 42);
		panelCadastrarVenda.add(btnProdCadLimpar);

		btnProdCadSalvar.setText("Salvar");
		btnProdCadSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnProdCadSalvar.setBounds(241, 162, 113, 42);
		panelCadastrarVenda.add(btnProdCadSalvar);
		
		comboBoxVendCadProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxVendCadProdutos.setBounds(80, 76, 137, 22);
		panelCadastrarVenda.add(comboBoxVendCadProdutos);

		spinnerVendCadQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinnerVendCadQtd.setBounds(333, 77, 71, 20);
		panelCadastrarVenda.add(spinnerVendCadQtd);

		panelListarVendas.setLayout(null);
		tabbedPaneVenda.addTab("Listar", null, panelListarVendas, null);

		lblListarVenda.setText("Venda - Listar");
		lblListarVenda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListarVenda.setBounds(143, 16, 171, 25);
		panelListarVendas.add(lblListarVenda);

		separatorCadListar.setBounds(10, 52, 409, 2);
		panelListarVendas.add(separatorCadListar);

		btnProdListLimpar.setText("Limpar");
		btnProdListLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnProdListLimpar.setBounds(80, 167, 113, 42);
		panelListarVendas.add(btnProdListLimpar);
		
		btnProdListPesquisar.setText("Pesquisar");
		btnProdListPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnProdListPesquisar.setBounds(249, 167, 113, 42);
		panelListarVendas.add(btnProdListPesquisar);
		
		spinnerVendListQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinnerVendListQtd.setBounds(333, 73, 71, 20);
		panelListarVendas.add(spinnerVendListQtd);
		
		lblVendaListQtd.setText("Quantidade");
		lblVendaListQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVendaListQtd.setBounds(238, 72, 85, 19);
		panelListarVendas.add(lblVendaListQtd);

		comboBoxListVendProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxListVendProdutos.setBounds(80, 72, 137, 22);
		panelListarVendas.add(comboBoxListVendProdutos);

		lblVendaListVenda.setText("Produto");
		lblVendaListVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVendaListVenda.setBounds(20, 72, 59, 19);
		panelListarVendas.add(lblVendaListVenda);
		
		lblVendaListPreco.setText("Preço R$");
		lblVendaListPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVendaListPreco.setBounds(20, 119, 59, 19);
		panelListarVendas.add(lblVendaListPreco);
		
		textVendListPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textVendListPreco.setColumns(10);
		textVendListPreco.setBounds(93, 120, 86, 20);
		panelListarVendas.add(textVendListPreco);
	}
}
