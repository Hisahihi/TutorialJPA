package com.techacademy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
	public final CountryRepository repository;

	@Autowired
	public CountryService(CountryRepository repository) {
		this.repository= repository;
	}

	//全件検索して返し
	public List<Country> getCountryList(){
		//リポジトリのFindAllを呼び出し
		return repository.findAll();
	}

}
