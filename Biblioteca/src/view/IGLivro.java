package view;

import dao.DaoEditora;
import dao.DaoLivro;
import dao.filter.LivroFiltro;
import dao.fromDB.EditoraFromDB;
import dao.fromDB.LivroFromDB;
import dao.idao.IDaoEditora;
import dao.idao.IDaoLivro;
import model.Editora;
import model.Livro;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class IGLivro extends JDialog {
	private JTextField textPesqLivroISBN;
	private JTextField textPesqLivroTitulo;
	private JTextField textPesqLivroPreco;
	private JTextField textCadLivroPreco;
	private JTextField textCadLivroISBN;
	private JTextField textCadLivroTitulo;
	private JTabbedPane tabbedPaneLivro;
	private JButton btnCadLivro;
	private JButton btnPesqLivro;
	private JPanel panelPesqLivro;
	private JLabel lblPesqLivroISBN;
	private JLabel lblPesqLivroEdicao;
	private JSpinner spinnerPesqLivroEdicao;
	private JLabel lblPesqLivroTitulo;
	private JLabel lblPesqLivroEditora;
	private JLabel lblPesqLivroPreco;
	private JComboBox comboBoxPesqLivroEditora;
	private JButton btnPesqLivroLimpar;
	private JButton btnPesqLivroPesquisar;
	private JPanel panelCadLivro;
	private JLabel lblCadLivroPreco;
	private JLabel lblEditoraCadLivroEditora;
	private JComboBox comboBoxCadLivroEditora;
	private JLabel lblCadLivroISBN;
	private JLabel lblCadLivroEdicao;
	private JSpinner spinnerCadLivroEdicao;
	private JLabel lblCadLivroTitulo;
	private JButton btnCadLivroLimpar;
	private JButton btnCadLivroCadastrar;
	private JPanel panelMenuLivro;
	private IDaoLivro iDaoLivro;
	private IDaoEditora iDaoEditora;
	public IGLivro(Frame owner) {
		super(owner);
		this.initializeComponents();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new CardLayout(0, 0));
		getContentPane().add(this.tabbedPaneLivro, "name_199690257826300");
		setVisible(true);
		this.menuLivro();
	}
	private void initializeComponents() {
		try{
			this.textPesqLivroISBN = new JTextField();
			this.textPesqLivroTitulo = new JTextField();
			this.textPesqLivroPreco = new JTextField();
			this.textCadLivroPreco = new JTextField();
			this.textCadLivroISBN = new JTextField();
			this.textCadLivroTitulo = new JTextField();
			this.tabbedPaneLivro = new JTabbedPane(JTabbedPane.TOP);
			this.btnCadLivro = new JButton("Cadastrar");
			this.btnCadLivro.setText("Cadastrar");
			this.btnPesqLivro = new JButton("Pesquisar");
			this.panelPesqLivro = new JPanel();
			this.lblPesqLivroISBN = new JLabel("ISBN");
			this.lblPesqLivroEdicao = new JLabel("Edição");
			this.spinnerPesqLivroEdicao = new JSpinner();
			this.lblPesqLivroTitulo = new JLabel("Título");
			this.lblPesqLivroEditora = new JLabel("Editora");
			this.lblPesqLivroPreco = new JLabel("Preço");
			this.comboBoxPesqLivroEditora = new JComboBox();
			this.btnPesqLivroLimpar = new JButton("Limpar");
			this.btnPesqLivroPesquisar = new JButton("Pesquisar");
			this.panelCadLivro = new JPanel();
			this.lblCadLivroPreco = new JLabel("Preço");
			this.lblEditoraCadLivroEditora = new JLabel("Editora");
			this.comboBoxCadLivroEditora = new JComboBox();
			this.lblCadLivroISBN = new JLabel("ISBN");
			this.lblCadLivroEdicao = new JLabel("Edição");
			this.spinnerCadLivroEdicao = new JSpinner();
			this.lblCadLivroTitulo = new JLabel("Título");
			this.btnCadLivroLimpar = new JButton("Limpar");
			this.btnCadLivroCadastrar = new JButton("Cadastrar");
			this.panelMenuLivro = new JPanel();
			this.iDaoLivro =  new DaoLivro();
			this.iDaoEditora = new DaoEditora();
		}catch (Exception ex ){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	private void menuLivro(){
		try{
			this.setModal(true);
			this.panelMenuLivro.setLayout(null);
			this.tabbedPaneLivro.addTab("Menu", null, this.panelMenuLivro, null);

			this.btnCadLivro.setFont(new Font("Tahoma", Font.PLAIN, 12));
			this.btnCadLivro.setBounds(161, 45, 98, 39);
			this.btnCadLivro.addActionListener((e) -> this.cadastrarLivro());
			this.panelMenuLivro.add(this.btnCadLivro);

			this.btnPesqLivro.setFont(new Font("Tahoma", Font.PLAIN, 12));
			this.btnPesqLivro.setBounds(161, 113, 98, 39);
			this.btnPesqLivro.addActionListener((e) -> this.pesquisarLivro());
			this.panelMenuLivro.add(this.btnPesqLivro);
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
	private void cadastrarLivro(){
			try{
				this.tabbedPaneLivro.addTab("Cadastrar", null, this.panelCadLivro, null);
				this.panelCadLivro.setLayout(null);
				this.panelCadLivro.setVisible(true);

				this.textCadLivroPreco.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.textCadLivroPreco.setColumns(10);
				this.textCadLivroPreco.setBounds(75, 105, 125, 22);
				this.panelCadLivro.add(this.textCadLivroPreco);

				this.lblCadLivroPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
				this.lblCadLivroPreco.setBounds(25, 103, 59, 21);
				this.panelCadLivro.add(this.lblCadLivroPreco);

				this.lblEditoraCadLivroEditora.setFont(new Font("Tahoma", Font.PLAIN, 15));
				this.lblEditoraCadLivroEditora.setBounds(25, 55, 59, 21);
				this.panelCadLivro.add(this.lblEditoraCadLivroEditora);

				this.comboBoxCadLivroEditora.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.comboBoxCadLivroEditora.setBounds(75, 56, 143, 22);
				var editorasBD = this.iDaoEditora.getEditora();

				this.comboBoxCadLivroEditora.addItem(" ");
				editorasBD.stream()
						.map(editora -> editora.getDecricao())
						.toList()
						.stream()
						.sorted(( s1, s2) -> s1.compareToIgnoreCase(s2))
						.distinct()
						.forEach(editoraNome -> this.comboBoxCadLivroEditora.addItem(editoraNome));

				this.panelCadLivro.add(this.comboBoxCadLivroEditora);

				this.lblCadLivroISBN.setFont(new Font("Tahoma", Font.PLAIN, 15));
				this.lblCadLivroISBN.setBounds(238, 55, 59, 21);
				this.panelCadLivro.add(this.lblCadLivroISBN);

				this.textCadLivroISBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.textCadLivroISBN.setColumns(10);
				this.textCadLivroISBN.setBounds(279, 54, 125, 22);
				this.panelCadLivro.add(this.textCadLivroISBN);

				this.lblCadLivroEdicao.setFont(new Font("Tahoma", Font.PLAIN, 15));
				this.lblCadLivroEdicao.setBounds(294, 11, 59, 21);
				this.panelCadLivro.add(this.lblCadLivroEdicao);

				this.spinnerCadLivroEdicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.spinnerCadLivroEdicao.setBounds(345, 11, 59, 22);
				this.panelCadLivro.add(this.spinnerCadLivroEdicao);

				this.textCadLivroTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.textCadLivroTitulo.setColumns(10);
				this.textCadLivroTitulo.setBounds(76, 12, 193, 22);
				this.panelCadLivro.add(this.textCadLivroTitulo);

				this.lblCadLivroTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
				this.lblCadLivroTitulo.setBounds(25, 11, 59, 21);
				this.panelCadLivro.add(this.lblCadLivroTitulo);

				this.btnCadLivroLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.btnCadLivroLimpar.setBounds(94, 154, 98, 39);
				this.btnCadLivroLimpar.addActionListener((e) -> {
					this.textCadLivroTitulo.setText("");
					this.textCadLivroPreco.setText("");
					this.textCadLivroISBN.setText("");
					this.spinnerCadLivroEdicao.setValue(0);
					this.comboBoxCadLivroEditora.setSelectedIndex(0);
				});
				this.panelCadLivro.add(this.btnCadLivroLimpar);

				this.btnCadLivroCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.btnCadLivroCadastrar.setBounds(249, 154, 98, 39);
				this.btnCadLivroCadastrar.addActionListener((e) -> {
					try{
						var nomeEditora = this.comboBoxCadLivroEditora.getSelectedItem().toString();
						var editoras = this.iDaoEditora.getEditora();
						var editoraSelecionada = editoras.stream()
								.filter((editora)-> editora.descricao.equals(nomeEditora))
								.toList()
								.stream()
								.findFirst();

						this.iDaoLivro.postLivro(new Livro(
								this.textCadLivroISBN.getText(),
								this.textCadLivroTitulo.getText(),
								Integer.parseInt(this.spinnerCadLivroEdicao.getValue().toString()),
								Double.parseDouble(this.textCadLivroPreco.getText()),
								editoraSelecionada.get().codEditora
						));
						this.btnCadLivroLimpar.doClick();
					}catch( Exception ex ){
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				});
				this.panelCadLivro.add(this.btnCadLivroCadastrar);
				this.tabbedPaneLivro.setSelectedComponent(this.panelCadLivro);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	private void pesquisarLivro(){
			try{
				this.tabbedPaneLivro.addTab("Pesquisar", null, this.panelPesqLivro, null);
				this.panelPesqLivro.setVisible(true);
				this.panelPesqLivro.setLayout(null);

				this.lblPesqLivroISBN.setFont(new Font("Tahoma", Font.PLAIN, 15));
				this.lblPesqLivroISBN.setBounds(235, 55, 59, 21);
				this.panelPesqLivro.add(this.lblPesqLivroISBN);

				this.lblPesqLivroEdicao.setFont(new Font("Tahoma", Font.PLAIN, 15));
				this.lblPesqLivroEdicao.setBounds(291, 11, 59, 21);
				this.panelPesqLivro.add(this.lblPesqLivroEdicao);

				this.textPesqLivroISBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.textPesqLivroISBN.setColumns(10);
				this.textPesqLivroISBN.setBounds(276, 54, 125, 22);
				this.panelPesqLivro.add(this.textPesqLivroISBN);

				this.spinnerPesqLivroEdicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.spinnerPesqLivroEdicao.setBounds(342, 11, 59, 22);
				this.panelPesqLivro.add(this.spinnerPesqLivroEdicao);

				this.lblPesqLivroTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
				this.lblPesqLivroTitulo.setBounds(22, 11, 59, 21);
				this.panelPesqLivro.add(this.lblPesqLivroTitulo);

				this.textPesqLivroTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.textPesqLivroTitulo.setColumns(10);
				this.textPesqLivroTitulo.setBounds(73, 12, 193, 22);
				this.panelPesqLivro.add(this.textPesqLivroTitulo);

				this.lblPesqLivroEditora.setFont(new Font("Tahoma", Font.PLAIN, 15));
				this.lblPesqLivroEditora.setBounds(22, 55, 59, 21);
				this.panelPesqLivro.add(this.lblPesqLivroEditora);

				this.comboBoxPesqLivroEditora.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.comboBoxPesqLivroEditora.setBounds(72, 56, 143, 22);

				var editoras = this.iDaoEditora.getEditora();

				this.comboBoxPesqLivroEditora.addItem(" ");
				editoras.stream()
						.map( editora -> editora.getDecricao() )
						.toList()
						.stream()
						.sorted((o1, o2) -> o1.compareToIgnoreCase(o2) )
						.distinct()
						.forEach( nomeEditora -> this.comboBoxPesqLivroEditora.addItem(nomeEditora));

				this.panelPesqLivro.add(this.comboBoxPesqLivroEditora);

				this.lblPesqLivroPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
				this.lblPesqLivroPreco.setBounds(22, 103, 59, 21);
				this.panelPesqLivro.add(this.lblPesqLivroPreco);

				this.textPesqLivroPreco.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.textPesqLivroPreco.setColumns(10);
				this.textPesqLivroPreco.setBounds(72, 105, 125, 22);
				this.panelPesqLivro.add(this.textPesqLivroPreco);

				this.btnPesqLivroLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.btnPesqLivroLimpar.setBounds(91, 154, 98, 39);
				this.btnPesqLivroLimpar.addActionListener((e) ->{
					this.textPesqLivroISBN.setText("");
					this.textPesqLivroPreco.setText("");
					this.textPesqLivroTitulo.setText("");
					this.spinnerPesqLivroEdicao.setValue(0);
					this.comboBoxPesqLivroEditora.setSelectedIndex(0);
				});
				this.panelPesqLivro.add(this.btnPesqLivroLimpar);

				this.btnPesqLivroPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				this.btnPesqLivroPesquisar.setBounds(246, 154, 98, 39);
				this.btnPesqLivroPesquisar.addActionListener((e)->{
					try{
						var editorasBD = this.iDaoEditora.getEditora();
						var editoraSelecNome = this.comboBoxPesqLivroEditora.getSelectedItem().toString();
						var editoraSelecObj = editoras.stream()
												.filter(editora -> editora.descricao.equals(editoraSelecNome))
												.toList()
												.stream()
												.findFirst();
						var edicao = this.spinnerPesqLivroEdicao.getValue().toString();
						var filtro = new LivroFiltro(
								"",
								this.textPesqLivroISBN.getText(),
								this.textPesqLivroTitulo.getText(),
								edicao.equals("0") ? "" : edicao,
								this.textPesqLivroPreco.getText(),
								editoraSelecObj.get().codEditora + ""
						);
						var resultado = this.iDaoLivro.getLivro( filtro );
						this.inicializaTabelaDeLivros(resultado);
						resultado.stream().forEach(item -> System.out.println(item));
					}catch (Exception ex){
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				});
				this.panelPesqLivro.add(this.btnPesqLivroPesquisar);
				this.tabbedPaneLivro.setSelectedComponent(this.panelPesqLivro);

			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	private void inicializaTabelaDeLivros( ArrayList<LivroFromDB> livros){
		var tabela = new JTable();
		tabela.setVisible(true);
		tabela.setModel(new AbstractTableModel() {
			@Override
			public int getRowCount() {
				return livros.size();
			}

			@Override
			public int getColumnCount() {
				return 6;
			}
			@Override
			public String getColumnName(int columnIndex){
				switch (columnIndex){
					case 0: return "CodLivro";
					case 1: return "ISBN";
					case 2: return "Título";
					case 3: return "Edição";
					case 4: return "Preço";
					case 5: return "CodEditora";
					default: return null;
				}
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				var row = livros.get(rowIndex);
				switch (columnIndex){
					case 0: return row.codLivro;
					case 1: return row.isbn;
					case 2: return row.titulo;
					case 3: return row.numEdicao;
					case 4: return row.preco;
					case 5: return row.codEditora;
					default: return null;
				}
			}
		});

		this.tabbedPaneLivro.add("Livros", tabela);
		this.tabbedPaneLivro.setSelectedComponent(tabela);
	}
}
