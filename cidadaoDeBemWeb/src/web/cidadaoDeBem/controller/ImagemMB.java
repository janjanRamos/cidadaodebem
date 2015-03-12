package web.cidadaoDeBem.controller;

import java.io.FileNotFoundException;
import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import web.cidadaoDeBem.utilitarios.ImagemUtil;

@RequestScoped
public class ImagemMB implements Serializable {
	private static final long serialVersionUID = -2512806101450140965L;

	public StreamedContent getFoto() throws FileNotFoundException {
		String fotoNome = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("fotoNome");

		if (FacesContext.getCurrentInstance().getRenderResponse()
				|| fotoNome == null)
			return new DefaultStreamedContent();

		else
			return ImagemUtil.recuperarFotoDisco(fotoNome);
	}
}