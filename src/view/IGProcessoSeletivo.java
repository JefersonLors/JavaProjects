package view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;

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

import interfaces.IGComum;


public class IGProcessoSeletivo extends JDialog implements IGComum{
	private JTextField textCodigoPS;
	private JTextField textNomeBandaPesquisa;
	private JTextField textNomeProdutor;
	private JTextField textNomeBandaCadastro;
	
	private JTable tablePSLista;
	
	public IGProcessoSeletivo(Frame owner, boolean modal) {
		super(owner, modal);
		this.inicializaInterfaceGrafica();
	}

	public IGProcessoSeletivo(Frame owner) {
		super(owner);
		
		this.inicializaInterfaceGrafica();
	}

	public IGProcessoSeletivo() {
		this.inicializaInterfaceGrafica();
	}

	@Override
	public void inicializaInterfaceGrafica() {
		//Processo Seletivo
		setBounds(100, 100, 450, 426);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		setLocationRelativeTo(this.getFocusOwner());
		
		
		JTabbedPane tabbedMenuPS = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedMenuPS, "name_205706229708800");
		
		JPanel panelPSPesquisa = new JPanel();
		tabbedMenuPS.addTab("Pesquisar", null, panelPSPesquisa, null);
		panelPSPesquisa.setLayout(null);
		
		JLabel lblCodProcesso = new JLabel("Código");
		lblCodProcesso.setBounds(263, 100, 50, 30);
		panelPSPesquisa.add(lblCodProcesso);
		
		textCodigoPS = new JTextField();
		textCodigoPS.setBounds(317, 105, 83, 20);
		panelPSPesquisa.add(textCodigoPS);
		textCodigoPS.setColumns(10);
		
		JLabel lblNomeBandaPesquisa = new JLabel("NomeBanda");
		lblNomeBandaPesquisa.setBounds(23, 62, 94, 14);
		panelPSPesquisa.add(lblNomeBandaPesquisa);
		
		JLabel lblNomeProdutor = new JLabel("NomeProdutor");
		lblNomeProdutor.setBounds(23, 108, 107, 14);
		panelPSPesquisa.add(lblNomeProdutor);
		
		textNomeBandaPesquisa = new JTextField();
		textNomeBandaPesquisa.setBounds(102, 59, 150, 20);
		panelPSPesquisa.add(textNomeBandaPesquisa);
		textNomeBandaPesquisa.setColumns(10);
		
		textNomeProdutor = new JTextField();
		textNomeProdutor.setToolTipText("nome produtor");
		textNomeProdutor.setBounds(114, 105, 125, 20);
		panelPSPesquisa.add(textNomeProdutor);
		textNomeProdutor.setColumns(10);
		
		JLabel lblQtdCandidatos = new JLabel("N. Candidatos");
		lblQtdCandidatos.setBounds(270, 62, 87, 14);
		panelPSPesquisa.add(lblQtdCandidatos);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(293, 154, 107, 36);
		panelPSPesquisa.add(btnPesquisar);
		
		JLabel lblPSTituloPesquisa = new JLabel("Processo Seletivo - Pesquisa");
		lblPSTituloPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPSTituloPesquisa.setBounds(74, 11, 287, 30);
		panelPSPesquisa.add(lblPSTituloPesquisa);
		
		JSeparator separatorPSPesquisa = new JSeparator();
		separatorPSPesquisa.setBounds(23, 141, 377, 2);
		panelPSPesquisa.add(separatorPSPesquisa);
		
		JSpinner spinnerQtdCandidatos = new JSpinner();
		spinnerQtdCandidatos.setBounds(360, 59, 40, 20);
		panelPSPesquisa.add(spinnerQtdCandidatos);
		
		JPanel panelPSCadastra = new JPanel();
		tabbedMenuPS.addTab("Cadastrar", null, panelPSCadastra, null);
		panelPSCadastra.setLayout(null);
		
		textNomeBandaCadastro = new JTextField();
		textNomeBandaCadastro.setBounds(108, 67, 161, 20);
		textNomeBandaCadastro.setColumns(10);
		panelPSCadastra.add(textNomeBandaCadastro);
		
		JLabel lblNomeBandaCadastro = new JLabel("Nome banda");
		lblNomeBandaCadastro.setBounds(20, 70, 80, 14);
		panelPSCadastra.add(lblNomeBandaCadastro);
		
		JLabel lblPSTituloCadastrar = new JLabel("Processo Seletivo - Cadastrar");
		lblPSTituloCadastrar.setBounds(66, 11, 260, 25);
		lblPSTituloCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPSCadastra.add(lblPSTituloCadastrar);
		
		JLabel lblProdutor = new JLabel("Produtor");
		lblProdutor.setBounds(20, 111, 63, 14);
		panelPSCadastra.add(lblProdutor);
		
		JComboBox comboBoxProdutores = new JComboBox();
		comboBoxProdutores.setBounds(85, 108, 137, 22);
		panelPSCadastra.add(comboBoxProdutores);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(296, 153, 107, 36);
		panelPSCadastra.add(btnSalvar);
		
		JSeparator separatorPSCadastrar = new JSeparator();
		separatorPSCadastrar.setBounds(20, 136, 383, 7);
		panelPSCadastra.add(separatorPSCadastrar);
		
		JLabel lblMaxCandidatos = new JLabel("Max. Candidatos");
		lblMaxCandidatos.setBounds(245, 109, 107, 14);
		panelPSCadastra.add(lblMaxCandidatos);
		
		JSpinner spinnerMaxCandidatos = new JSpinner();
		spinnerMaxCandidatos.setBounds(355, 106, 48, 20);
		panelPSCadastra.add(spinnerMaxCandidatos);
		
		JScrollPane scrollPaneListaProcessos = new JScrollPane();
		getContentPane().add(scrollPaneListaProcessos, "name_215122882251700");
		
		tablePSLista = new JTable();
		scrollPaneListaProcessos.setViewportView(tablePSLista);
	}


}
