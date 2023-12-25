package com.techacademy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {
	private final CountryRepository repository;

	@Autowired
	public CountryService(CountryRepository repository) {
		this.repository= repository;
	}

	//全件検索して返し
	public List<Country> getCountryList(){
		//リポジトリのFindAllを呼び出し
		return repository.findAll();
	}

	//一件検索
	public Country getCountry(String code) {
		Optional <Country> option = repository.findById(code);
		Country country = option.orElse(null);
		return country;
	}
	//更新（追加）を行う
	@Transactional
	public void update(String code, String name, int population) {
		Country country = new Country(code,name,population);
		repository.save(country);
	}
	//削除する
	@Transactional
	public void deleteCountry(String code) {
		repository.deleteById(code);
	}

}
