package com.vitesia.api.service;

import java.util.List;

import com.vitesia.api.dto.ClienteDto;
import com.vitesia.api.model.Cliente;

import com.vitesia.api.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vitesia
 */
@Primary
@Service
public class ClienteService {

    private final Logger log = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;


    private Cliente transformaDtoCliente (ClienteDto clienteDto, Cliente cliente){
        cliente.setDireccion(clienteDto.getDireccion());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setLatitud(clienteDto.getLatitud());
        cliente.setLongitud(clienteDto.getLongitud());
        cliente.setName(clienteDto.getName());
        cliente.setPoblacion(clienteDto.getPoblacion());
        cliente.setTelefono(clienteDto.getTelefono());

        return cliente;
    }

    public Cliente getCliente(String cif) {
    	Cliente cliente = new Cliente();
    	cliente = clienteRepository.findByCif(cif);
    	return cliente;
    }
    
	public void delete(Integer id) {
		clienteRepository.deleteById(id);
	}

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }


    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    public Cliente updateCliente(ClienteDto clienteDto) {

        Cliente existe = clienteRepository.findByCif(clienteDto.getCif());

        if (existe!=null){
            existe = transformaDtoCliente (clienteDto, existe);
            return clienteRepository.save(existe);
        }
        else
            return null;    
    }


    
}
