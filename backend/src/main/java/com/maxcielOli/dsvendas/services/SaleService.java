package com.maxcielOli.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maxcielOli.dsvendas.dto.SaleDTO;
import com.maxcielOli.dsvendas.entities.Sale;
import com.maxcielOli.dsvendas.repositories.SaleRepository;
import com.maxcielOli.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository SellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		SellerRepository.findAll();
		Page<Sale> result =  repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
}
