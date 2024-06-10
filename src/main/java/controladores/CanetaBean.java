package controladores;

import dao.CanetaDAO;
import entidades.Caneta;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@ManagedBean
@ViewScoped
public class CanetaBean {
    private Caneta caneta = new Caneta();
    private List<Caneta> canetas;

    public CanetaBean() {
        listar();
    }

    public void salvar() {
        CanetaDAO.salvar(caneta);
        listar();
        caneta = new Caneta();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Caneta salva com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void selecionar(Caneta caneta) {
        this.caneta = caneta;
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Caneta selecionada", "Marca: " + caneta.getMarca() + ", Modelo: " + caneta.getModelo() + ", Cor: " + caneta.getCor());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void excluir(Caneta caneta) {
        CanetaDAO.excluir(caneta);
        listar();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Caneta excluída com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void listar() {
        canetas = CanetaDAO.listar();
    }

    public Caneta getCaneta() {
        return caneta;
    }

    public void setCaneta(Caneta caneta) {
        this.caneta = caneta;
    }

    public List<Caneta> getCanetas() {
        if (canetas == null) {
            listar();
        }
        return canetas;
    }

    public void setCanetas(List<Caneta> canetas) {
        this.canetas = canetas;
    }
    public void contarCanetasPorCor() {
        int azuis = 0;
        int pretas = 0;
        int vermelhas = 0;

        for (Caneta c : canetas) {
            if ("Azul".equalsIgnoreCase(c.getCor())) {
                azuis++;
            } else if ("Preta".equalsIgnoreCase(c.getCor())) {
                pretas++;
            } else if ("Vermelha".equalsIgnoreCase(c.getCor())) {
                vermelhas++;
            }
        }

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Quantidade de Canetas",
                "Azuis: " + azuis + ", Pretas: " + pretas + ", Vermelhas: " + vermelhas);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
