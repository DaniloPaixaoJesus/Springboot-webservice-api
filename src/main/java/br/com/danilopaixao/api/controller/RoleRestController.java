package br.com.danilopaixao.api.controller;

import br.com.danilopaixao.api.request.RoleRequest;
import br.com.danilopaixao.api.response.RoleResponse;
import br.com.danilopaixao.core.role.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 * @author user
 *
 */
@RestController
public class RoleRestController {
	
	@Autowired
	private RoleService service;
	
	@ApiOperation("EndPoint to get Role by ID ")
	@GetMapping(value = "/api/v1/roles/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RoleResponse getRole(
    		@PathVariable(value = "id", required = true) final Long id ) {
		return this.service.getById(id);
	}	
	
	@ApiOperation("Endpoint to get ALL Role")
	@GetMapping(value = "/api/v1/roles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<RoleResponse> getAllRoles() {
		return this.service.getByAllRoles();
    }
	
	@ApiOperation("Endpoint to create new Role")
	@PostMapping(value = "/api/v1/roles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody RoleResponse saveRole(
    		@RequestBody(required = true) final RoleRequest role) {
		return this.service.save(role);
    }
	
	@ApiOperation("Endpoint to update a Role")
	@PostMapping(value = "/api/v1/roles/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RoleResponse upDateRole(
    		@PathVariable(value = "id", required = true) final Long id ,
    		@RequestBody(required = true) final RoleRequest role) {
		role.setId(id);
		return this.service.save(id, role);
    }
	
	@ApiOperation("Endpoint to inative a Role")
	@DeleteMapping(value = "/api/v1/roles/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RoleResponse cancelRole(
    		@PathVariable(value = "id", required = true) final Long id) {
		return this.service.inativeRole(id);
    }
	

}

