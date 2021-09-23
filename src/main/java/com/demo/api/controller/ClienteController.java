package com.vitesia.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.vitesia.api.dto.ClienteComboDto;
import com.vitesia.api.dto.ClienteDto;
import com.vitesia.api.model.Cliente;
import com.vitesia.api.service.ClienteService;

import org.modelmapper.ModelMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ClienteController {

    private final Logger log = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    ClienteService clienteService;	

    @Autowired
    private ModelMapper modelMapper;



    // LISTA DE CLIENTES
    @GetMapping(value = "/clientes")
	public List<Cliente> clientes () {
        List<Cliente> result = new ArrayList<>();
		try {
			
            if (log.isInfoEnabled()) {
                log.info("Listando los clientes");
            }
			
			result = clienteService.getClientes();

			
			
		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return result;
	}


    // LISTA DE CLIENTES
    @GetMapping(value = "/clientesCombo")
    public List<ClienteComboDto> clientesCombo () {
        List<Cliente> result = new ArrayList<>();
        List<ClienteComboDto> combo = new ArrayList<>();
        try {
                
            if (log.isInfoEnabled()) {
                log.info("Listando los clientes para un combo");
            }
                            
            result = clienteService.getClientes();

            combo = result.stream()
                .map(pedido -> modelMapper.map(pedido, ClienteComboDto.class))
                .collect(Collectors.toList());

                
        } catch (Exception e) {
            log.error("ERROR", e);
        }
        return combo;
    }


	//OBTENER UN CLIENTE POR ID
    @PostMapping(value = "/getCliente")
	public Cliente getCliente (String cif) {
        Cliente result = new Cliente();
		try {
			
            if (log.isInfoEnabled()) {
                log.info("Accediendo al cliente con cif: {}",cif);
            }
			
			result = clienteService.getCliente(cif);
       		return result;
			
			
		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return null;
	}



	//BORRAR UN CLIENTE POR ID
    @PostMapping("/delete")
    public void deleteCliente( Integer id){
        clienteService.delete(id);
    }


    //ANYADIR UN CLIENTE 
    @PostMapping("/createCliente")
    public Cliente createCliente( @RequestBody ClienteDto clienteDto){
        Cliente result = new Cliente();
        try {

            if (log.isInfoEnabled()) {
                log.info("Creando el cliente con cif: {}",clienteDto.getCif());
            }            

            Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
            result = clienteService.createCliente(cliente);
        
            return result;
		
        } catch (Exception e) {
			log.error("ERROR", e);
		}
		
        return null;            
    }


    //ANYADIR UN CLIENTE 
    @PostMapping("/updateCliente")
    public Cliente updateCliente( @RequestBody ClienteDto clienteDto){
        Cliente result = new Cliente();
        try {
    
            if (log.isInfoEnabled()) {
                log.info("Actualizando el cliente con cif: {}",clienteDto.getCif());
            }            
    
            result = clienteService.updateCliente(clienteDto);
            
            return result;
          
        } catch (Exception e) {
            log.error("ERROR", e);
        }
        
        return null;            
    }
    





 
    
}
