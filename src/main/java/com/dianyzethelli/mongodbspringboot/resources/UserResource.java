package com.dianyzethelli.mongodbspringboot.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
