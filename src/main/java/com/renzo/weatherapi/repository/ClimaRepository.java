package com.renzo.weatherapi.repository;


import com.renzo.weatherapi.model.Clima;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClimaRepository extends JpaRepository<Clima, Long> {
}
