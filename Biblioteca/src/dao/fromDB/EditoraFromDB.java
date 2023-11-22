package dao.fromDB;

public class EditoraFromDB {
    public int codEditora;
    public String descricao;
    public String endereco;

    public EditoraFromDB(int codEditora, String descricao, String endereco) {
        this.codEditora = codEditora;
        this.descricao = descricao;
        this.endereco = endereco;
    }
    public String getDecricao(){return this.descricao;}
    public String toString(){
        return "" + this.codEditora + " " + this.descricao + " " + this.endereco;
    }
}
