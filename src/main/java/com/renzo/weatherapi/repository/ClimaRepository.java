package com.renzo.weatherapi.repository;


import com.renzo.weatherapi.model.Clima;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClimaRepository extends JpaRepository<Clima, Long> {

    List<Clima> findByCidade(String cidade);

    String cidade(String cidade);

    List<Clima> findByTemperatura(int temperatura);

    int temperatura(int temperatura);
}
