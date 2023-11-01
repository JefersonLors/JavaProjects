package view;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import interfaces.IGComum;

public class IGProdutor extends JDialog implements IGComum{
	
	private JTextField textProdNome;
	private JTextField textProdCod;
	private JTextField textProdPodutoraNome;
	private JTextField textProdNomeProdutor;
	private JTextField textProdCtt1;
	private JTextField textProdCtt2;
	private JTextField textProdNomeProdutora;
	private JTable tableProdLista;
	
	public IGProdutor(Frame owner, boolean modal) {
		super(owner, modal);
		this.inicializaInterfaceGrafica();
	}

	public IGProdutor(Frame owner) {
		super(owner);
		this.inicializaInterfaceGrafica();
	}

	public IGProdutor() {
		this.inicializaInterfaceGrafica();
	}
	
	@Override
	public void inicializaInterfaceGrafica() {
		//Produtor
		setBounds(100, 100, 450, 426);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		setLocationRelativeTo(this.getFocusOwner());
		
		JTabbedPane tabbedPaneProdutor = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPaneProdutor, "name_222446668301600");
		
		JPanel panelProdPesquisa = new JPanel();
		tabbedPaneProdutor.addTab("Pesquisar", null, panelProdPesquisa, null);
		panelProdPesquisa.setLayout(null);
		
		JLabel lblProdTituloPesquisa = new JLabel("Produtor - Pesquisa");
		lblProdTituloPesquisa.setBounds(117, 11, 203, 25);
		lblProdTituloPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelProdPesquisa.add(lblProdTituloPesquisa);
		
		JButton btnProdPesquisar = new JButton("Pesquisar");
		btnProdPesquisar.setBounds(293, 312, 107, 36);
		panelProdPesquisa.add(btnProdPesquisar);
		
		JSeparator separatorCandPesquisa_1 = new JSeparator();
		separatorCandPesquisa_1.setBounds(23, 299, 377, 2);
		panelProdPesquisa.add(separatorCandPesquisa_1);
		
		JLabel lblProdPesquisa = new JLabel("Nome");
		lblProdPesquisa.setBounds(200, 54, 46, 14);
		panelProdPesquisa.add(lblProdPesquisa);
		
		JLabel lblProdCódigo = new JLabel("Código");
		lblProdCódigo.setBounds(23, 54, 56, 14);
		panelProdPesquisa.add(lblProdCódigo);
		
		textProdNome = new JTextField();
		textProdNome.setBounds(258, 51, 142, 20);
		textProdNome.setColumns(10);
		panelProdPesquisa.add(textProdNome);
		
		textProdCod = new JTextField();
		textProdCod.setBounds(71, 51, 100, 20);
		textProdCod.setColumns(10);
		panelProdPesquisa.add(textProdCod);
		
		JLabel lblProdHabilidadesPesquisa = new JLabel("Habilidades");
		lblProdHabilidadesPesquisa.setBounds(23, 129, 74, 14);
		panelProdPesquisa.add(lblProdHabilidadesPesquisa);
		
		JList listProdHabilidadesPesquisa = new JList();
		listProdHabilidadesPesquisa.setBounds(104, 124, 296, 25);
		panelProdPesquisa.add(listProdHabilidadesPesquisa);
		
		JLabel lblProdProdutora = new JLabel("Produtora");
		lblProdProdutora.setBounds(23, 92, 79, 14);
		panelProdPesquisa.add(lblProdProdutora);
		
		textProdPodutoraNome = new JTextField();
		textProdPodutoraNome.setBounds(85, 87, 315, 20);
		panelProdPesquisa.add(textProdPodutoraNome);
		textProdPodutoraNome.setColumns(10);
		
		JPanel panelProdCadastrar = new JPanel();
		panelProdCadastrar.setLayout(null);
		tabbedPaneProdutor.addTab("Cadastrar", null, panelProdCadastrar, null);
		
		JLabel lblProdCadastrar = new JLabel("Produtor - Cadastra");
		lblProdCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProdCadastrar.setBounds(116, 11, 215, 25);
		panelProdCadastrar.add(lblProdCadastrar);
		
		JButton btnProdSalvar = new JButton("Salvar");
		btnProdSalvar.setBounds(292, 312, 107, 36);
		panelProdCadastrar.add(btnProdSalvar);
		
		JSeparator separatorProdCadastra = new JSeparator();
		separatorProdCadastra.setBounds(22, 299, 377, 2);
		panelProdCadastrar.add(separatorProdCadastra);
		
		JLabel lblProdNomeCadastra = new JLabel("Nome");
		lblProdNomeCadastra.setBounds(22, 55, 51, 14);
		panelProdCadastrar.add(lblProdNomeCadastra);
		
		textProdNomeProdutor = new JTextField();
		textProdNomeProdutor.setColumns(10);
		textProdNomeProdutor.setBounds(71, 52, 129, 20);
		panelProdCadastrar.add(textProdNomeProdutor);
		
		JLabel lblProdNascimento = new JLabel("Nascimento");
		lblProdNascimento.setBounds(210, 55, 68, 14);
		panelProdCadastrar.add(lblProdNascimento);
		
		JLabel lblProdSexo = new JLabel("Sexo");
		lblProdSexo.setBounds(22, 94, 46, 14);
		panelProdCadastrar.add(lblProdSexo);
		
		JComboBox comboBoxProdSexo = new JComboBox();
		comboBoxProdSexo.setBounds(71, 90, 87, 22);
		panelProdCadastrar.add(comboBoxProdSexo);
		
		JLabel lblProdHabilidade = new JLabel("Habilidades");
		lblProdHabilidade.setBounds(180, 94, 68, 14);
		panelProdCadastrar.add(lblProdHabilidade);
		
		JList listProdHabilidades = new JList();
		listProdHabilidades.setBounds(258, 89, 141, 25);
		panelProdCadastrar.add(listProdHabilidades);
		
		JLabel lblProdCtt1 = new JLabel("Contato");
		lblProdCtt1.setBounds(22, 175, 68, 14);
		panelProdCadastrar.add(lblProdCtt1);
		
		textProdCtt1 = new JTextField();
		textProdCtt1.setColumns(10);
		textProdCtt1.setBounds(188, 172, 112, 20);
		panelProdCadastrar.add(textProdCtt1);
		
		JLabel lblProdCtt2 = new JLabel("Contato");
		lblProdCtt2.setBounds(22, 212, 51, 14);
		panelProdCadastrar.add(lblProdCtt2);
		
		textProdCtt2 = new JTextField();
		textProdCtt2.setColumns(10);
		textProdCtt2.setBounds(189, 209, 112, 20);
		panelProdCadastrar.add(textProdCtt2);
		
		JComboBox comboBoxProdTipoCtt1 = new JComboBox();
		comboBoxProdTipoCtt1.setBounds(71, 171, 107, 22);
		panelProdCadastrar.add(comboBoxProdTipoCtt1);
		
		JComboBox comboBoxProdTipoCtt2 = new JComboBox();
		comboBoxProdTipoCtt2.setBounds(71, 208, 107, 22);
		panelProdCadastrar.add(comboBoxProdTipoCtt2);
		
		JLabel lblNomeProdutora = new JLabel("Nome produtora");
		lblNomeProdutora.setBounds(23, 133, 110, 14);
		panelProdCadastrar.add(lblNomeProdutora);
		
		JFormattedTextField formattedTextFieldProdNascimento = new JFormattedTextField();
		formattedTextFieldProdNascimento.setBounds(287, 52, 112, 20);
		panelProdCadastrar.add(formattedTextFieldProdNascimento);
		
		textProdNomeProdutora = new JTextField();
		textProdNomeProdutora.setBounds(128, 130, 272, 20);
		panelProdCadastrar.add(textProdNomeProdutora);
		textProdNomeProdutora.setColumns(10);
		
		JScrollPane scrollPaneProdLista = new JScrollPane();
		getContentPane().add(scrollPaneProdLista, "name_223271342288800");
		
		tableProdLista = new JTable();
		scrollPaneProdLista.setViewportView(tableProdLista);
		
	}

}
