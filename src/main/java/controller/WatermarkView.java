package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class WatermarkView {
     
    private String keyword;
 
    public String getKeyword() {
        return keyword;
    }
 
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
     
    public void search() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null,"Nome:     Dono:   Servicos: ", "'" + keyword + "'"));
    }
}