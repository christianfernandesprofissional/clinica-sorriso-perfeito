package com.sorrisoperfeito.cepapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ViaCepService {

	@Autowired(required = true)
	private RestTemplate restTemplate;
	
	public EnderecoDTO buscarPorCep(String cep) {
		String url = "https://viacep.com.br/ws/" + cep + "/json/";
	
		return restTemplate.getForObject(url, EnderecoDTO.class);
	}
	
}
