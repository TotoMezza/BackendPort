
package com.portfolio.tm.Interface;

import com.portfolio.tm.entity.Persona;
import java.util.List;


public interface IPersonaService {
   //Traer Lista de Personas
   public List<Persona> getPersona();
   //Guardar una instancia de Persona
   public void guardarPersona(Persona persona);
   //Eliminar una Instancia de Persona
    public void borrarPersona(Long id);
   //Buscar una persona por id
   public Persona buscarPersona(Long id);
}
