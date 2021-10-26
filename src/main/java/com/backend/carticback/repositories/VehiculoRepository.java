package com.backend.carticback.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.backend.carticback.models.VehiculoModel;
import java.util.ArrayList;

@Repository
public interface VehiculoRepository extends CrudRepository<VehiculoModel, Long>{

    public abstract ArrayList<VehiculoModel> findByPlaca(String placa);
}
