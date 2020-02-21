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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kev.springboot.backend.tienda.online.models.entity.Categoria;
import com.kev.springboot.backend.tienda.online.models.entity.Producto;
import com.kev.springboot.backend.tienda.online.models.services.ICategoriaService;
import com.kev.springboot.backend.tienda.online.models.services.IProductoService;

@RestController
@RequestMapping("/api")
public class ProductoController {

	//aa
	@Autowired
	private IProductoService productoService;


	@GetMapping("/productos")
	public List<Producto> getAllProd() {
		return productoService.findAll();
	}

	@GetMapping("/productos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Producto producto = null;
		Map<String, Object> response = new HashMap<>();

		try {
			producto = productoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la BD");
			response.put("error", e.getMessage() + " :" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (producto == null) {
			response.put("mensaje", "El producto ID:".concat(id.toString().concat(" no existe en la BD!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);

	}

	@PostMapping("/productos")
	public ResponseEntity<?> create(@RequestBody Producto producto, BindingResult result) {
		Producto newProduct = null;
		Map<String, Object> response = new HashMap<>();// para guardar los mensajes varios

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()// guardamos los errores en esa lista
					.stream().map(err -> {
						return "'El campo " + err.getField() + "' " + err.getDefaultMessage();
					}).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);// error 400

		}

		try {
			newProduct = productoService.save(producto);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la BD");
			response.put("error", e.getMessage() + " :" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Producto creado con exito!");
		response.put("producto", newProduct);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/productos/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Producto producto, BindingResult result) {
		Producto prodActual = productoService.findById(id);
		Producto prodUpdated = null;
		Map<String, Object> response = new HashMap<>();// para guardar los mensajes varios

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()// guardamos los errores en esa lista
					.stream().map(err -> {
						return "'El campo " + err.getField() + "' " + err.getDefaultMessage();
					}).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);// error 400

		}

		if (prodActual == null) {
			response.put("mensaje",
					"No se pudo editar el Producto con ID:".concat(id.toString().concat(" no existe en la BD!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			prodActual.setNombre(producto.getNombre());
			prodActual.setPrecio(producto.getPrecio());
			prodActual.setCreateAt(producto.getCreateAt());
			prodActual.setCategoria(producto.getCategoria());
			prodActual.setStatus(producto.getStatus());
			prodUpdated = productoService.save(prodActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar al actualzar a la BD");
			response.put("error", e.getMessage() + " :" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Producto actualizado con exito");
		response.put("producto", prodUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/productos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();// para guardar los mensajes varios

		try {
			productoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error  al eliminar de la BD");
			response.put("error", e.getMessage() + " :" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Producto eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/productos/filtrar/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Producto> filtrarProductos(@PathVariable String term){
		return productoService.findProductoByNombre(term);
	}

}
