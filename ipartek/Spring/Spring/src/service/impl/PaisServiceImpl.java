package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.PaisDAO;
import service.PaisService;
import vo.Pais;


@Service
public class PaisServiceImpl implements PaisService {
	
	@Autowired
	PaisDAO paisDAO;

	@Override
	public ArrayList<Pais> getPaises() {
		return paisDAO.getPaises();
	}

}
