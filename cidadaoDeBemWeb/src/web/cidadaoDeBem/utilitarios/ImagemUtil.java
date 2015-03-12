package web.cidadaoDeBem.utilitarios;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import cidadaoDeBem.ejb.modelo.Imagem;

public class ImagemUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"dd-MM-yyyy-HH-mm-ss-SSS");
	public static final String FOLDER = File.separator + "fotos"
			+ File.separator;

	public static List<Imagem> handlePicture(List<byte[]> imageToHandle) {
		List<Imagem> imagens = new ArrayList<Imagem>();
		String nomeFoto = "";
		Imagem foto = null;
		for (byte[] b : imageToHandle) {
			nomeFoto = DATE_FORMAT.format(Calendar.getInstance().getTime())
					+ ".png";

			foto = new Imagem();
			foto.setNome(nomeFoto);
			foto.setImagem(b);
			imagens.add(foto);

			try {
				salvarNoDisco(ImageIO.read(new ByteArrayInputStream(b)),
						nomeFoto);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return imagens;
	}

	private static void salvarNoDisco(BufferedImage fotoSalvar, String nomeFoto)
			throws IOException {
		File f = new File(FOLDER);

		if (!f.exists()) {
			f.mkdirs();
			f.setReadable(true);
			f.setWritable(true);
		}

		ImageIO.write(fotoSalvar, "png", new File(FOLDER + nomeFoto));
	}

	public static StreamedContent recuperarFotoDisco(String fotoNome)
			throws FileNotFoundException {
		try {
			return new DefaultStreamedContent(new FileInputStream(new File(
					FOLDER + fotoNome)), "image/png");
		} catch (IOException e) {
			e.printStackTrace();

			return new DefaultStreamedContent(new FileInputStream(new File(
					FOLDER + "DEFAULT.png")), "image/png");
		}
	}

	{

	}
}
