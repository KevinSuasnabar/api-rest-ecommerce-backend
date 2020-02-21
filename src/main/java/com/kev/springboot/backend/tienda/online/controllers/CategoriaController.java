package com.kev.springboot.backend.tienda.online.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kev.springboot.backend.tienda.online.models.entity.Categoria;
import com.kev.springboot.backend.tienda.online.models.services.ICategoriaService;

@RestController
@RequestMapping("/api")
public class CategoriaController {

	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping("/categorias")
	public List<Categoria> getAll() {
		return categoriaService.getAll();
	}

	@GetMapping("/categorias/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Categoria categoria = null;
		Map<String, Object> response = new HashMap<>();

		try {
			categoria = categoriaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la BD");
			response.put("error", e.getMessage() + " :" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (categoria == null) {
			response.put("mensaje", "La categoria con ID:".concat(id.toString().concat(" no existe en la BD!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}

	@PostMapping("/categorias")
	private ResponseEntity<?> create(@RequestBody Categoria categoria, BindingResult result) {
		Categoria newCategoria = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()// guardamos los errores en esa lista
					.stream().map(err -> {
						return "'El campo " + err.getField() + "' " + err.getDefaultMessage();
					}).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);// error 400

		}

		try {
			newCategoria = categoriaService.save(categoria);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la BD");
			response.put("error", e.getMessage() + " :" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Categoria creada con exito!");
		response.put("categoria", newCategoria);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/categorias/{id}")
	private ResponseEntity<?> update(@PathVariable Long id, @RequestBody Categoria categoria, BindingResult result) {
		Categoria catActual = categoriaService.findById(id);
		Categoria catUpdated = null;
		Map<String, Object> response = new HashMap<>();// para guardar los mensajes varios

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()// guardamos los errores en esa lista
					.stream().map(err -> {
						return "'El campo " + err.getField() + "' " + err.getDefaultMessage();
					}).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);// error 400

		}

		if (catActual == null) {
			response.put("mensaje",
					"No se pudo editar la categoria con ID:".concat(id.toString().concat(" no existe en la BD!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			catActual.setNombre(categoria.getNombre());
			catActual.setProductos(categoria.getProductos());
			catUpdated = categoriaService.save(catActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la categoria  en la BD");
			response.put("error", e.getMessage() + " :" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Categoria actualizada con exito");
		response.put("categoria", catUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
