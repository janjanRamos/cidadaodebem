package web.cidadaoDeBem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

@ManagedBean
@ViewScoped
public class UploadMB implements Serializable {
	private static final long serialVersionUID = 7475247398584602545L;

	private List<byte[]> listaImageBytes;

	public void handlePictureUploaded(FileUploadEvent uploadEvent) {
		if (listaImageBytes == null)
			listaImageBytes = new ArrayList<byte[]>();
		this.listaImageBytes.add(uploadEvent.getFile().getContents());
		System.out.println(listaImageBytes.size());
	}

	public List<byte[]> getListaImageBytes() {

		return listaImageBytes;
	}

	public void setListaImageBytes(List<byte[]> listaImageBytes) {
		this.listaImageBytes = listaImageBytes;
	}

}