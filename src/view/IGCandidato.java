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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import interfaces.IGComum;

public class IGCandidato extends JDialog implements IGComum {
	// JTextField
	private JTextField textCandNomeCadastra;
	private JTextField textFieldCandCtt1;
	private JTextField textCandCtt2;
	private JTextField textCandNomePesquisa;
	private JTextField textCandCodigo;
	private JTable tableCandLista;

	// JTabbedPane e JPanel
	private JTabbedPane tabbedPaneCandidato;
	private JPanel panelCandPesquisa;
	private JPanel panelCandCadastrar;

	// JLabels
	private JLabel lblCandTituloPesquisa;
	private JLabel lblCandCódigo;
	private JLabel lblCandPesquisa;
	private JLabel lblCandHabilidadesPesquisa;
	private JLabel lblCandCadastrar;
	private JLabel lblCandNome;
	private JLabel lblCandNascimento;
	private JLabel lblCandSexo;
	private JLabel lblCandHabilidade;
	private JLabel lblCandCtt1;
	private JLabel lblCandCtt2;
	private JLabel lblCandTextoApresentacao;

	// JButton e JSeparator
	private JButton btnCandPesquisar;
	private JButton btnCandSalvar;
	private JSeparator separatorCandPesquisa;
	private JSeparator separatorCandCadastra;

	// JComboBox e JList
	private JComboBox comboBoxCandSexo;
	private JComboBox comboBoxTipoCtt2;
	private JComboBox comboBoxTipoCtt1;
	private JList listCandHabilidades;
	private JList listCandHabilidadesPesquisa;

	// JTextArea e JFormattedTextField, JScrollPane
	private JTextArea textAreaCandApresentacao;
	private JFormattedTextField formattedTextFieldCandNascimento;
	private JScrollPane scrollPane;
	
	public IGCandidato(Frame owner, boolean modal) {
		super(owner, modal);
		this.instanciaComponentes() ;
		this.inicializaInterfaceGrafica();
	}

	public IGCandidato(Frame owner) {
		super(owner);
		this.instanciaComponentes() ;
		this.inicializaInterfaceGrafica();
	}

	public IGCandidato() {
		this.instanciaComponentes() ;
		this.inicializaInterfaceGrafica();
	}
	
	public void instanciaComponentes() {
		// JTextField
		this.textCandNomeCadastra = new JTextField();
		this.textCandNomePesquisa = new JTextField();

		// JTabbedPane, JPanel
		this.tabbedPaneCandidato = new JTabbedPane();
		this.panelCandPesquisa = new JPanel();
		this.panelCandCadastrar = new JPanel();

		// JLabels
		this.lblCandTituloPesquisa = new JLabel();
		this.lblCandPesquisa = new JLabel();
		this.lblCandCódigo = new JLabel();
		this.lblCandHabilidadesPesquisa = new JLabel();
		this.lblCandCadastrar = new JLabel();
		this.lblCandNome = new JLabel();
		this.lblCandNascimento = new JLabel();
		this.lblCandSexo = new JLabel();
		this.lblCandHabilidade = new JLabel();
		this.lblCandCtt1 = new JLabel();
		this.lblCandCtt2 = new JLabel();
		this.lblCandTextoApresentacao = new JLabel("Apresentação");

		// JButton, JSeparator
		this.btnCandPesquisar = new JButton();
		this.btnCandSalvar = new JButton();
		this.separatorCandPesquisa = new JSeparator();
		this.separatorCandCadastra = new JSeparator();

		// JComboBox, JList
		this.comboBoxCandSexo = new JComboBox();
		this.comboBoxTipoCtt2 = new JComboBox();
		this.comboBoxTipoCtt1 = new JComboBox();
		this.listCandHabilidades = new JList();
		this.listCandHabilidadesPesquisa = new JList();

		// JTextArea, JFormattedTextField, JScrollPane
		this.textAreaCandApresentacao = new JTextArea();
		this.formattedTextFieldCandNascimento = new JFormattedTextField();
		this.scrollPane = new JScrollPane();

	}
	
	@Override
	public void inicializaInterfaceGrafica() {
		setBounds(100, 100, 450, 426);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		setLocationRelativeTo(this.getFocusOwner());
		
		this.tabbedPaneCandidato.setTabPlacement(JTabbedPane.TOP);
		getContentPane().add(this.tabbedPaneCandidato, "name_217006642080300");
		
		this.tabbedPaneCandidato.addTab("Pesquisar", null, panelCandPesquisa, null);
		this.panelCandPesquisa.setLayout(null);
		
		this.lblCandTituloPesquisa.setText("Candidato - Pesquisa");
		this.lblCandTituloPesquisa.setBounds(117, 11, 203, 25);
		this.lblCandTituloPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panelCandPesquisa.add(this.lblCandTituloPesquisa);
		
		this.btnCandPesquisar.setText("Pesquisar");
		this.btnCandPesquisar.setBounds(293, 312, 107, 36);
		this.panelCandPesquisa.add(this.btnCandPesquisar);
		
		this.separatorCandPesquisa.setBounds(23, 299, 377, 2);
		this.panelCandPesquisa.add(this.separatorCandPesquisa);
		
		this.lblCandPesquisa.setText("Nome");
		this.lblCandPesquisa.setBounds(200, 54, 46, 14);
		this.panelCandPesquisa.add(this.lblCandPesquisa);
		
		this.lblCandCódigo.setText("Código");
		this.lblCandCódigo.setBounds(23, 54, 56, 14);
		this.panelCandPesquisa.add(this.lblCandCódigo);
		
		this.textCandNomePesquisa.setBounds(258, 51, 142, 20);
		this.panelCandPesquisa.add(this.textCandNomePesquisa);
		this.textCandNomePesquisa.setColumns(10);
		
		this.textCandCodigo = new JTextField();
		this.textCandCodigo.setBounds(71, 51, 100, 20);
		this.panelCandPesquisa.add(this.textCandCodigo);
		this.textCandCodigo.setColumns(10);
		
		this.lblCandHabilidadesPesquisa.setText("Habilidades");
		this.lblCandHabilidadesPesquisa.setBounds(23, 108, 74, 14);
		this.panelCandPesquisa.add(this.lblCandHabilidadesPesquisa);

		this.listCandHabilidadesPesquisa.setBounds(104, 103, 295, 25);
		this.panelCandPesquisa.add(this.listCandHabilidadesPesquisa);

		this.tabbedPaneCandidato.addTab("Cadastrar", null, this.panelCandCadastrar, null);
		this.panelCandCadastrar.setLayout(null);

		this.lblCandCadastrar.setText("Candidato - Cadastra");
		this.lblCandCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblCandCadastrar.setBounds(116, 11, 215, 25);
		this.panelCandCadastrar.add(this.lblCandCadastrar);

		this.btnCandSalvar.setText("Salvar");
		this.btnCandSalvar.setBounds(292, 312, 107, 36);
		this.panelCandCadastrar.add(this.btnCandSalvar);

		this.separatorCandCadastra.setBounds(22, 299, 377, 2);
		this.panelCandCadastrar.add(this.separatorCandCadastra);

		this.lblCandNome.setText("Nome");
		this.lblCandNome.setBounds(22, 55, 51, 14);
		this.panelCandCadastrar.add(this.lblCandNome);

		this.textCandNomeCadastra.setBounds(71, 52, 129, 20);
		this.panelCandCadastrar.add(this.textCandNomeCadastra);
		this.textCandNomeCadastra.setColumns(10);
		
		this.lblCandNascimento.setText("Nascimento");
		this.lblCandNascimento.setBounds(210, 55, 68, 14);
		this.panelCandCadastrar.add(this.lblCandNascimento);

		this.lblCandSexo.setText("Sexo");
		this.lblCandSexo.setBounds(22, 94, 46, 14);
		this.panelCandCadastrar.add(this.lblCandSexo);

		this.comboBoxCandSexo.setBounds(71, 90, 87, 22);
		this.panelCandCadastrar.add(this.comboBoxCandSexo);

		this.lblCandHabilidade.setText("Habilidades");
		this.lblCandHabilidade.setBounds(180, 94, 68, 14);
		this.panelCandCadastrar.add(this.lblCandHabilidade);

		this.listCandHabilidades.setBounds(258, 89, 141, 25);
		this.panelCandCadastrar.add(this.listCandHabilidades);

		this.lblCandCtt1.setText("Contato");
		this.lblCandCtt1.setBounds(22, 134, 68, 14);
		this.panelCandCadastrar.add(this.lblCandCtt1);

		this.textFieldCandCtt1 = new JTextField();
		this.textFieldCandCtt1.setBounds(188, 131, 112, 20);
		this.panelCandCadastrar.add(this.textFieldCandCtt1);
		this.textFieldCandCtt1.setColumns(10);
		
		this.lblCandCtt2.setText("Contato");
		this.lblCandCtt2.setBounds(22, 171, 51, 14);
		this.panelCandCadastrar.add(lblCandCtt2);
		
		this.textCandCtt2 = new JTextField();
		this.textCandCtt2.setBounds(189, 168, 112, 20);
		this.panelCandCadastrar.add(this.textCandCtt2);
		this.textCandCtt2.setColumns(10);
		
		this.comboBoxTipoCtt2.setBounds(71, 130, 107, 22);
		this.panelCandCadastrar.add(this.comboBoxTipoCtt2);

		this.comboBoxTipoCtt1.setBounds(71, 167, 107, 22);
		this.panelCandCadastrar.add(this.comboBoxTipoCtt1);

		this.lblCandTextoApresentacao.setText("Apresentação");
		this.lblCandTextoApresentacao.setBounds(22, 206, 87, 14);
		this.panelCandCadastrar.add(this.lblCandTextoApresentacao);

		this.textAreaCandApresentacao.setBounds(22, 235, 377, 53);
		this.panelCandCadastrar.add(this.textAreaCandApresentacao);

		this.formattedTextFieldCandNascimento.setBounds(287, 52, 112, 20);
		this.panelCandCadastrar.add(this.formattedTextFieldCandNascimento);

		getContentPane().add(scrollPane, "name_220870457178100");
		
		this.tableCandLista = new JTable();
		scrollPane.setViewportView(this.tableCandLista);

	}

}
