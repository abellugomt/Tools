package com.example.Herramientas_G4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Herramientas_G4.entities.Tool;
import com.example.Herramientas_G4.repositories.ToolRepository;

@Service
public class ToolService {

    @Autowired
    private ToolRepository ToolRepository;

    public ToolService(ToolRepository ToolRepository) {
        this.ToolRepository = ToolRepository;
    }

    // METODOS CRUD
    public List<Tool> getListTools() {
        return this.ToolRepository.findAll();
    }

    public Tool getTool(int id) {
        if (!this.ToolRepository.findById(id).isEmpty()) {
            return this.ToolRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Tool crearTool(Tool tool) {
        System.out.println("service OK *************");
        return this.ToolRepository.save(tool);
    }

    public void eliminarTool(int id) {
        if (!this.ToolRepository.findById(id).isEmpty()) {
            this.ToolRepository.deleteById(id);
        }
    }

    public void actualizarTool(int id, Tool tool) {
        if (!this.ToolRepository.findById(id).isEmpty()) {
            Tool toolDB = this.ToolRepository.findById(id).get();
            if (tool.getName() != null) {
                toolDB.setName(tool.getName());
            }
            if (tool.getBrand() != null) {
                toolDB.setBrand(tool.getBrand());
            }
            if (tool.getDescription() != null) {
                toolDB.setDescription(tool.getDescription());
            }
            if (tool.getYear() != null) {
                toolDB.setYear(tool.getYear());
            }

            this.ToolRepository.save(toolDB);
        }
    }
}
