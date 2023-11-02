package view;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class IGProcessoSeletivo extends JDialog{
	// JTextField
	private JTextField textCodigoPS;
	private JTextField textNomeBandaPesquisa;
	private JTextField textNomeProdutor;
	private JTextField textNomeBandaCadastro;

	// JTabbedPane
	private JTabbedPane tabbedMenuPS;

	// JPanel
	private JPanel panelPSPesquisa;
	private JPanel panelPSCadastra;

	// JLabel
	private JLabel lblCodProcesso;
	private JLabel lblNomeBandaPesquisa;
	private JLabel lblNomeProdutor;
	private JLabel lblQtdCandidatos;
	private JLabel lblPSTituloPesquisa;
	private JLabel lblNomeBandaCadastro;
	private JLabel lblPSTituloCadastrar;
	private JLabel lblProdutor;
	private JLabel lblMaxCandidatos;

	// JButton
	private JButton btnPesquisar;
	private JButton btnSalvar;

	// JSeparator
	private JSeparator separatorPSPesquisa;
	private JSeparator separatorPSCadastrar;

	// JSpinner
	private JSpinner spinnerQtdCandidatos;
	private JSpinner spinnerMaxCandidatos;

	// JComboBox
	private JComboBox comboBoxProdutores;

	// JScrollPane e JTable
	private JScrollPane scrollPaneListaProcessos;
	private JTable tablePSLista;

	public IGProcessoSeletivo(Frame owner, boolean modal) {
		super(owner, modal);
		this.instanciaComponentes();
		this.inicializaInterfaceGrafica();
	}

	public IGProcessoSeletivo(Frame owner) {
		super(owner);
		this.instanciaComponentes();
		this.inicializaInterfaceGrafica();
	}

	public IGProcessoSeletivo() {
		this.instanciaComponentes();
		this.inicializaInterfaceGrafica();
	}

	private void instanciaComponentes(){
		this.tabbedMenuPS = new JTabbedPane();
		this.panelPSPesquisa = new JPanel();
		this.lblCodProcesso = new JLabel();
		this.textCodigoPS = new JTextField();
		this.lblNomeBandaPesquisa = new JLabel();
		this.lblNomeProdutor = new JLabel();
		this.textNomeBandaPesquisa = new JTextField();
		this.textNomeProdutor = new JTextField();
		this.lblQtdCandidatos = new JLabel();
		this.btnPesquisar = new JButton();
		this.lblPSTituloPesquisa = new JLabel();
		this.separatorPSPesquisa = new JSeparator();
		this.spinnerQtdCandidatos = new JSpinner();
		this.panelPSCadastra = new JPanel();
		this.textNomeBandaCadastro = new JTextField();
		this.lblNomeBandaCadastro = new JLabel();
		this.lblPSTituloCadastrar = new JLabel();
		this.lblProdutor = new JLabel();
		this.comboBoxProdutores = new JComboBox();
		this.btnSalvar = new JButton();
		this.separatorPSCadastrar = new JSeparator();
		this.lblMaxCandidatos = new JLabel();
		this.spinnerMaxCandidatos = new JSpinner();
		this.scrollPaneListaProcessos = new JScrollPane();
		this.tablePSLista = new JTable();
	}

	private void inicializaInterfaceGrafica() {
		this.setBounds(100, 100, 450, 426);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new CardLayout(0, 0));
		this.setLocationRelativeTo(this.getFocusOwner());

		this.tabbedMenuPS.setTabPlacement(JTabbedPane.TOP);
		this.getContentPane().add(this.tabbedMenuPS, "name_205706229708800");

		this.tabbedMenuPS.addTab("Pesquisar", null, this.panelPSPesquisa, null);
		this.panelPSPesquisa.setLayout(null);

		this.lblCodProcesso.setText("Código");
		this.lblCodProcesso.setBounds(263, 100, 50, 30);
		this.panelPSPesquisa.add(this.lblCodProcesso);

		this.textCodigoPS.setBounds(317, 105, 83, 20);
		this.panelPSPesquisa.add(this.textCodigoPS);
		this.textCodigoPS.setColumns(10);

		this.lblNomeBandaPesquisa.setText("NomeBanda");
		this.lblNomeBandaPesquisa.setBounds(23, 62, 94, 14);
		this.panelPSPesquisa.add(this.lblNomeBandaPesquisa);

		this.lblNomeProdutor.setText("NomeProdutor");
		this.lblNomeProdutor.setBounds(23, 108, 107, 14);
		this.panelPSPesquisa.add(this.lblNomeProdutor);

		this.textNomeBandaPesquisa.setBounds(102, 59, 150, 20);
		this.panelPSPesquisa.add(this.textNomeBandaPesquisa);
		this.textNomeBandaPesquisa.setColumns(10);

		this.textNomeProdutor.setToolTipText("nome produtor");
		this.textNomeProdutor.setBounds(114, 105, 125, 20);
		this.panelPSPesquisa.add(this.textNomeProdutor);
		this.textNomeProdutor.setColumns(10);

		this.lblQtdCandidatos.setText("N. Candidatos");
		this.lblQtdCandidatos.setBounds(270, 62, 87, 14);
		this.panelPSPesquisa.add(this.lblQtdCandidatos);

		this.btnPesquisar.setText("Pesquisar");
		this.btnPesquisar.setBounds(293, 154, 107, 36);
		this.panelPSPesquisa.add(this.btnPesquisar);

		this.lblPSTituloPesquisa.setText("Processo Seletivo - Pesquisa");
		this.lblPSTituloPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblPSTituloPesquisa.setBounds(74, 11, 287, 30);
		this.panelPSPesquisa.add(this.lblPSTituloPesquisa);

		this.separatorPSPesquisa.setBounds(23, 141, 377, 2);
		this.panelPSPesquisa.add(this.separatorPSPesquisa);

		this.spinnerQtdCandidatos.setBounds(360, 59, 40, 20);
		this.panelPSPesquisa.add(this.spinnerQtdCandidatos);

		this.tabbedMenuPS.addTab("Cadastrar", null, this.panelPSCadastra, null);
		this.panelPSCadastra.setLayout(null);

		this.textNomeBandaCadastro.setBounds(108, 67, 161, 20);
		this.textNomeBandaCadastro.setColumns(10);
		this.panelPSCadastra.add(this.textNomeBandaCadastro);

		this.lblNomeBandaCadastro.setText("Nome banda");
		this.lblNomeBandaCadastro.setBounds(20, 70, 80, 14);
		this.panelPSCadastra.add(this.lblNomeBandaCadastro);

		this.lblPSTituloCadastrar.setText("Processo Seletivo - Cadastrar");
		this.lblPSTituloCadastrar.setBounds(66, 11, 260, 25);
		this.lblPSTituloCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panelPSCadastra.add(this.lblPSTituloCadastrar);

		this.lblProdutor.setText("Produtor");
		this.lblProdutor.setBounds(20, 111, 63, 14);
		this.panelPSCadastra.add(this.lblProdutor);

		this.comboBoxProdutores.setBounds(85, 108, 137, 22);
		this.panelPSCadastra.add(this.comboBoxProdutores);

		this.btnSalvar.setText("Salvar");
		this.btnSalvar.setBounds(296, 153, 107, 36);
		this.panelPSCadastra.add(this.btnSalvar);

		this.separatorPSCadastrar.setBounds(20, 136, 383, 7);
		this.panelPSCadastra.add(this.separatorPSCadastrar);

		this.lblMaxCandidatos.setText("Max. Candidatos");
		this.lblMaxCandidatos.setBounds(245, 109, 107, 14);
		this.panelPSCadastra.add(this.lblMaxCandidatos);

		this.spinnerMaxCandidatos.setBounds(355, 106, 48, 20);
		this.panelPSCadastra.add(this.spinnerMaxCandidatos);

		this.getContentPane().add(this.scrollPaneListaProcessos, "name_215122882251700");

		this.scrollPaneListaProcessos.setViewportView(this.tablePSLista);
	}
}
