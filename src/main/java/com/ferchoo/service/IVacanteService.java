package com.ferchoo.service;

import java.util.List;

import com.ferchoo.model.Vacante;

public interface IVacanteService {

	List<Vacante> buscarTodas();

	Vacante buscarPorId(Integer idVacante);

}
