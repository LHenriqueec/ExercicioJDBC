package br.com.iveso.ExercicioJDBC;

import java.util.List;

import br.com.iveso.dao.cdDAO;
import br.com.iveso.exceptions.DAOException;
import br.com.iveso.model.CD;
import br.com.iveso.model.Categoria;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws DAOException {
    	
    	CD cd1 = new CD("Luiz", Categoria.BAKUCP, "Backup de Software");
    	cdDAO cdDao = new cdDAO();
//    	cdDao.create(cd1);
    	cdDao.delet(7);
//    	cd1.setId(3);
//    	cd1.setNome("Luiz");
//    	cd1.setCategoria(Categoria.BAKUCP);
//    	cd1.setConteudo("Backup de Software");
//    	cdDao.update(cd1);
//    	System.out.println(cdDao.load(4));
    	List<CD> listCD = cdDao.findCDsByCategoria(Categoria.SOFTWARE);
    	for(CD cd : listCD) {
    		System.out.println(cd);
    	}
    }
}
