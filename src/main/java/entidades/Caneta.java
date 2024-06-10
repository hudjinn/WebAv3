package entidades;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Caneta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column
	private String marca;

    @Column
    private String modelo;

	@Column
    private String cor;

	public Caneta() {
	}
	
    public Caneta(String marca, String modelo, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        setCor(cor);
    }

	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        if (cor.equalsIgnoreCase("Azul") || cor.equalsIgnoreCase("Preta") || cor.equalsIgnoreCase("Vermelha")) {
            this.cor = cor;
        } else {
            throw new IllegalArgumentException("Cor inválida. As cores permitidas são: Azul, Preta ou Vermelha.");
        }
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
