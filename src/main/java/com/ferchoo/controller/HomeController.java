package com.ferchoo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ferchoo.model.Vacante;

@Controller
public class HomeController {

	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
		model.addAttribute("vacantes", lista);
		return "tabla";
	}

	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero de soporte");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		model.addAttribute("vacante", vacante);
		return "detalle";

	}

	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Auxiliar de Contabilidad");
		lista.add("Ingeniero de sistemas");
		lista.add("Vendedor");
		lista.add("Arquitecto");

		model.addAttribute("empleos", lista);

		return "listado";
	}

	@GetMapping("/")
	public String mostrarHome(Model model) {

		/*
		 * model.addAttribute("msg", " ¡ Bienvenidos a empleos app !");
		 * model.addAttribute("fecha", new Date());
		 */

		String nombre = "Auxiliar de contabilidad";
		Date fechaPub = new Date();
		double salario = 9000.0;
		boolean vigente = true;

		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);

		return "home";
	}

	private List<Vacante> getVacantes() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<>();

		try {
			// 1
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Solicitamos Ing. Civil para diseño de puente peatonal.");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(8500.00);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");

			// 2
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador publico");
			vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia titulado.");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalario(null);
			vacante2.setDestacado(1);
			vacante2.setImagen("empresa2.png");

			// 3
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Electrico");
			vacante3.setDescripcion(
					"Empresa internacional solicita Ingeniero mecanico para mantenimiento de la intalacion electrica.");
			vacante3.setFecha(sdf.parse("10-02-2019"));
			vacante3.setSalario(10500.0);
			vacante3.setDestacado(0);

			// 4
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador grfico");
			vacante4.setDescripcion("Solicitamos Diseñador grafico titulado para diseñar publicidad de la empresa.");
			vacante4.setFecha(sdf.parse("11-02-2019"));
			vacante4.setSalario(null);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa4.png");

			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);

		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return lista;
	}

}
