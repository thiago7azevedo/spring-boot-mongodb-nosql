package com.dianyzethelli.mongodbspringboot.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dianyzethelli.mongodbspringboot.domain.User;
import com.dianyzethelli.mongodbspringboot.dto.UserDTO;
import com.dianyzethelli.mongodbspringboot.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity <List<UserDTO>> findAll(){ // mais robusto utilizar ResponseEntity passando a lista dentro <>
		List<User> list = service.findALL();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
//		expressão lamda para converter cada objeto da lista de User para UserDTO.
//		list.stream(transforma na coleção compativel com lambda).
//		.map (cada objeto x da lista original).
//		-> (aponta do objeto original para criar um novo objeto new UserDTO, passando x como argumento).
//		.collect(coleta toda expressão e volta ou converte novamente para lista). Passa como cargumento a operação Collectros voltando para lista.
		
		return ResponseEntity.ok().body(listDto); // retorna esse metodo se esta OK e no corpo (body) a lista DTO.
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity <UserDTO> findById(@PathVariable String id){ // mais robusto utilizar ResponseEntity passando a lista dentro <>
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) { // mais robusto utilizar ResponseEntity passando a lista dentro <>
		User obj = service.fromDTO(objDto); //converteu DTO para user
		obj = service.insert(obj); // inseriu no banco de dados
		// boa pratica a seguir: colocar no cabeçalho a url do novo recurso criado (URI) 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		// pega o endereço do novo objeto inserido e coloca na uri
		return ResponseEntity.created(uri).build(); //created(uri)/retorna o código 201 http do novo recurso criado
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) { // mais robusto utilizar ResponseEntity passando a lista dentro <>
		service.delete(id);
		return ResponseEntity.noContent().build();//quando a resposta não retorna nada, o código é 204 noContent().
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
