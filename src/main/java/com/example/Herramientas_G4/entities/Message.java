package com.example.Herramientas_G4.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    // ***** ATRIBUTOS *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    @Column(name = "messageText")
    private String messageText;

    // ***** RELACIONES *****
    // Relacion Muchos a uno. El Message tiene enlazados un Client y Un Farm

    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = { "messages", "reservations" })
    @JoinColumn(name = "tool_id")
    private Tool tool;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = { "messages", "reservations" })
    @JoinColumn(name = "client_id")
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // ***** METODOS *****

}
