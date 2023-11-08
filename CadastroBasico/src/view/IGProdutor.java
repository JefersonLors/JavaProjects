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

public class IGProdutor extends JDialog{
	// JButton
	private JButton btnProdPesquisar;
	private JButton btnProdSalvar;

	// JComboBox
	private JComboBox comboBoxProdSexo;
	private JComboBox comboBoxProdTipoCtt1;
	private JComboBox comboBoxProdTipoCtt2;

	// JFormattedTextField
	private JFormattedTextField formattedTextFieldProdNascimento;

	// JLabel
	private JLabel lblProdTituloPesquisa;
	private JLabel lblProdPesquisa;
	private JLabel lblProdCódigo;
	private JLabel lblProdHabilidadesPesquisa;
	private JLabel lblProdProdutora;
	private JLabel lblProdCadastrar;
	private JLabel lblProdNomeCadastra;
	private JLabel lblProdSexo;
	private JLabel lblProdNascimento;
	private JLabel lblProdHabilidade;
	private JLabel lblProdCtt1;
	private JLabel lblProdCtt2;
	private JLabel lblNomeProdutora;

	// JList
	private JList listProdHabilidadesPesquisa;
	private JList listProdHabilidades;

	// JPanel
	private JPanel panelProdPesquisa;
	private JPanel panelProdCadastrar;

	// JScrollPane
	private JScrollPane scrollPaneProdLista;

	// JSeparator
	private JSeparator separatorCandPesquisa_1;
	private JSeparator separatorProdCadastra;

	// JTabbedPane
	private JTabbedPane tabbedPaneProdutor;

	// JTable
	private JTable tableProdLista;

	// JTextField
	private JTextField textProdNome;
	private JTextField textProdCod;
	private JTextField textProdPodutoraNome;
	private JTextField textProdNomeProdutora;
	private JTextField textProdCtt1;
	private JTextField textProdCtt2;
	private JTextField textProdNomeProdutor;


	public IGProdutor(Frame owner, boolean modal) {
		super(owner, modal);
		this.instanciaComponentes();
		this.inicializaInterfaceGrafica();
	}

	public IGProdutor(Frame owner) {
		super(owner);
		this.instanciaComponentes();
		this.inicializaInterfaceGrafica();
	}

	public IGProdutor() {
		this.instanciaComponentes();
		this.inicializaInterfaceGrafica();
	}

	private void instanciaComponentes() {
		this.tabbedPaneProdutor = new JTabbedPane();
		this.panelProdPesquisa = new JPanel();
		this.lblProdTituloPesquisa = new JLabel();
		this.btnProdPesquisar = new JButton();
		this.separatorCandPesquisa_1 = new JSeparator();
		this.lblProdPesquisa = new JLabel();
		this.lblProdCódigo = new JLabel();
		this.textProdNome = new JTextField();
		this.textProdCod = new JTextField();
		this.lblProdHabilidadesPesquisa = new JLabel();
		this.listProdHabilidadesPesquisa = new JList();
		this.lblProdProdutora = new JLabel();
		this.textProdPodutoraNome = new JTextField();
		this.panelProdCadastrar = new JPanel();
		this.lblProdCadastrar = new JLabel();
		this.btnProdSalvar = new JButton();
		this.separatorProdCadastra = new JSeparator();
		this.lblProdNomeCadastra = new JLabel();
		this.textProdNomeProdutor = new JTextField();
		this.lblProdSexo = new JLabel();
		this.lblProdNascimento = new JLabel();
		this.comboBoxProdSexo = new JComboBox();
		this.lblProdHabilidade = new JLabel();
		this.listProdHabilidades = new JList();
		this.lblProdCtt1 = new JLabel();
		this.textProdCtt1 = new JTextField();
		this.lblProdCtt2 = new JLabel();
		this.textProdCtt2 = new JTextField();
		this.comboBoxProdTipoCtt1 = new JComboBox();
		this.comboBoxProdTipoCtt2 = new JComboBox();
		this.lblNomeProdutora = new JLabel();
		this.formattedTextFieldProdNascimento = new JFormattedTextField();
		this.textProdNomeProdutora = new JTextField();
		this.scrollPaneProdLista = new JScrollPane();
		this.tableProdLista = new JTable();
	}

	private void inicializaInterfaceGrafica() {
		this.setBounds(100, 100, 450, 426);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new CardLayout(0, 0));
		this.setLocationRelativeTo(this.getFocusOwner());

		this.tabbedPaneProdutor.setTabPlacement(JTabbedPane.TOP);
		this.getContentPane().add(this.tabbedPaneProdutor, "name_222446668301600");

		this.tabbedPaneProdutor.addTab("Pesquisar", null, this.panelProdPesquisa, null);
		this.panelProdPesquisa.setLayout(null);

		this.lblProdTituloPesquisa.setText("Produtor - Pesquisa");
		this.lblProdTituloPesquisa.setBounds(117, 11, 203, 25);
		this.lblProdTituloPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panelProdPesquisa.add(this.lblProdTituloPesquisa);

		this.btnProdPesquisar.setText("Pesquisar");
		this.btnProdPesquisar.setBounds(293, 312, 107, 36);
		this.panelProdPesquisa.add(this.btnProdPesquisar);

		this.separatorCandPesquisa_1.setBounds(23, 299, 377, 2);
		this.panelProdPesquisa.add(this.separatorCandPesquisa_1);

		this.lblProdPesquisa.setText("Nome");
		this.lblProdPesquisa.setBounds(200, 54, 46, 14);
		this.panelProdPesquisa.add(this.lblProdPesquisa);

		this.lblProdCódigo.setText("Código");
		this.lblProdCódigo.setBounds(23, 54, 56, 14);
		this.panelProdPesquisa.add(this.lblProdCódigo);

		this.textProdNome.setBounds(258, 51, 142, 20);
		this.textProdNome.setColumns(10);
		this.panelProdPesquisa.add(this.textProdNome);

		this.textProdCod.setBounds(71, 51, 100, 20);
		this.textProdCod.setColumns(10);
		this.panelProdPesquisa.add(this.textProdCod);

		this.lblProdHabilidadesPesquisa.setText("Habilidades");
		this.lblProdHabilidadesPesquisa.setBounds(23, 129, 74, 14);
		this.panelProdPesquisa.add(this.lblProdHabilidadesPesquisa);

		this.listProdHabilidadesPesquisa.setBounds(104, 124, 296, 25);
		this.panelProdPesquisa.add(this.listProdHabilidadesPesquisa);

		this.lblProdProdutora.setText("Produtora");
		this.lblProdProdutora.setBounds(23, 92, 79, 14);
		this.panelProdPesquisa.add(this.lblProdProdutora);

		this.textProdPodutoraNome.setBounds(85, 87, 315, 20);
		this.panelProdPesquisa.add(this.textProdPodutoraNome);
		this.textProdPodutoraNome.setColumns(10);

		this.panelProdCadastrar.setLayout(null);
		this.tabbedPaneProdutor.addTab("Cadastrar", null, this.panelProdCadastrar, null);

		this.lblProdCadastrar.setText("Produtor - Cadastra");
		this.lblProdCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblProdCadastrar.setBounds(116, 11, 215, 25);
		this.panelProdCadastrar.add(this.lblProdCadastrar);

		this.btnProdSalvar.setText("Salvar");
		this.btnProdSalvar.setBounds(292, 312, 107, 36);
		this.panelProdCadastrar.add(this.btnProdSalvar);

		this.separatorProdCadastra.setBounds(22, 299, 377, 2);
		this.panelProdCadastrar.add(this.separatorProdCadastra);

		this.lblProdNomeCadastra.setText("Nome");
		this.lblProdNomeCadastra.setBounds(22, 55, 51, 14);
		this.panelProdCadastrar.add(this.lblProdNomeCadastra);

		this.textProdNomeProdutor.setColumns(10);
		this.textProdNomeProdutor.setBounds(71, 52, 129, 20);
		this.panelProdCadastrar.add(this.textProdNomeProdutor);

		this.lblProdNascimento.setText("Nascimento");
		this.lblProdNascimento.setBounds(210, 55, 68, 14);
		this.panelProdCadastrar.add(this.lblProdNascimento);

		this.lblProdSexo.setText("Sexo");
		this.lblProdSexo.setBounds(22, 94, 46, 14);
		this.panelProdCadastrar.add(this.lblProdSexo);

		this.comboBoxProdSexo.setBounds(71, 90, 87, 22);
		this.panelProdCadastrar.add(this.comboBoxProdSexo);

		this.lblProdHabilidade.setText("Habilidades");
		this.lblProdHabilidade.setBounds(180, 94, 68, 14);
		this.panelProdCadastrar.add(this.lblProdHabilidade);

		this.listProdHabilidades.setBounds(258, 89, 141, 25);
		this.panelProdCadastrar.add(this.listProdHabilidades);

		this.lblProdCtt1.setText("Contato");
		this.lblProdCtt1.setBounds(22, 175, 68, 14);
		this.panelProdCadastrar.add(this.lblProdCtt1);

		this.textProdCtt1.setColumns(10);
		this.textProdCtt1.setBounds(188, 172, 112, 20);
		this.panelProdCadastrar.add(this.textProdCtt1);

		this.lblProdCtt2.setText("Contato");
		this.lblProdCtt2.setBounds(22, 212, 51, 14);
		this.panelProdCadastrar.add(this.lblProdCtt2);

		this.textProdCtt2.setColumns(10);
		this.textProdCtt2.setBounds(189, 209, 112, 20);
		this.panelProdCadastrar.add(this.textProdCtt2);

		this.comboBoxProdTipoCtt1.setBounds(71, 171, 107, 22);
		this.panelProdCadastrar.add(this.comboBoxProdTipoCtt1);

		this.comboBoxProdTipoCtt2.setBounds(71, 208, 107, 22);
		this.panelProdCadastrar.add(this.comboBoxProdTipoCtt2);

		this.lblNomeProdutora.setText("Nome produtora");
		this.lblNomeProdutora.setBounds(23, 133, 110, 14);
		this.panelProdCadastrar.add(this.lblNomeProdutora);

		this.formattedTextFieldProdNascimento.setBounds(287, 52, 112, 20);
		this.panelProdCadastrar.add(this.formattedTextFieldProdNascimento);

		this.textProdNomeProdutora.setBounds(128, 130, 272, 20);
		this.panelProdCadastrar.add(this.textProdNomeProdutora);
		this.textProdNomeProdutora.setColumns(10);

		this.getContentPane().add(this.scrollPaneProdLista, "name_223271342288800");
		this.scrollPaneProdLista.setViewportView(this.tableProdLista);
	}

}
