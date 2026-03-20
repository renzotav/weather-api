package com.renzo.weatherapi.repository;


import com.renzo.weatherapi.dto.ClimaDTO;
import com.renzo.weatherapi.model.Clima;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClimaRepository extends JpaRepository<Clima, Long> {

    List<ClimaDTO> findByCidade(String cidade);

    String cidade(String cidade);

    List<ClimaDTO> findByTemperatura(int temperatura);

    int temperatura(int temperatura);

    List<Clima> findByCidadeAndTemperatura(String cidade, int temperatura);

    List<Clima> findByCidadeContaining(String cidade);

    List<Clima> findAllByOrderByTemperaturaAsc();
}
