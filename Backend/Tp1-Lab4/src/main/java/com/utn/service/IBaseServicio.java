package com.utn.service;

import java.util.List;

public interface IBaseServicio <DTO>{

	List<DTO> findAll() throws Exception;

    DTO findById(int id) throws Exception;

    DTO save(DTO dto) throws Exception;

    DTO update(int id, DTO dto) throws Exception;

    boolean delete(int id) throws Exception;
}
