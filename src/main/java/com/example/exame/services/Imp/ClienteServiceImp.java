package com.example.exame.services.Imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exame.dto.ClienteRequestDto;
import com.example.exame.dto.ClienteResponseDto;
import com.example.exame.model.Cliente;
import com.example.exame.repository.ClienteRepository;
import com.example.exame.services.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService {
	
	@Autowired
    private ClienteRepository repository;
    
    @Override
    public void guardarCliente(ClienteRequestDto c) {

        Cliente cliente = new Cliente();
        cliente.setCelular(c.getCelularCliente());
        cliente.setNombre(c.getNombreCliente());
        cliente.setIdCliente(c.getIdCliente());
        repository.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public void editarCliente(ClienteRequestDto c) {
    	
    	Cliente cliente = new Cliente();
		cliente.setIdCliente(c.getIdCliente());
		cliente.setNombre(c.getNombreCliente());
		cliente.setCelular(c.getCelularCliente());

		repository.saveAndFlush(cliente);

    }

    @Override
    public List<ClienteResponseDto> listarCliente() {

        List<Cliente> cliente = repository.findAll();
        List<ClienteResponseDto> dto = new ArrayList<ClienteResponseDto>();
        ClienteResponseDto clienteDto = null;
        
        for (Cliente c : cliente) {
        	clienteDto = new ClienteResponseDto();
        	clienteDto.setIdCliente(c.getIdCliente());
        	clienteDto.setCelularCliente(c.getCelular());
        	clienteDto.setNombreCliente(c.getNombre());
            dto.add(clienteDto);
        }
        
        return dto;
    }

    @Override
    public ClienteResponseDto clienteById(Integer id) {
    	Cliente cliente = repository.findById(id).orElse(null);
    	ClienteResponseDto clienteDto =new ClienteResponseDto();
		
    	clienteDto.setIdCliente(cliente.getIdCliente());
    	clienteDto.setNombreCliente(cliente.getNombre());
    	clienteDto.setCelularCliente(cliente.getCelular());
		
		
		return clienteDto;
    }

}
