package com.example.Herramientas_G4.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Herramientas_G4.entities.Client;
import com.example.Herramientas_G4.entities.ReportClient;
import com.example.Herramientas_G4.entities.Reservation;
import com.example.Herramientas_G4.repositories.ClientRepository;
import com.example.Herramientas_G4.repositories.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ClientRepository clientRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // ****** INICIO REPORTES ******
    public List<Reservation> getReservationsBetweenTime(String start, String end) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd", Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        List<Reservation> result = null;
        try {
            Date startDate = formatter.parse(start);
            Date endDate = formatter.parse(end);
            result = this.reservationRepository.findByStartDateBetween(startDate, endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String getReservationsStatus() {
        List<Reservation> completed = this.reservationRepository.findByStatus("completed");
        List<Reservation> cancelled = this.reservationRepository.findByStatus("cancelled");
        String result = "{" + "\"completed\":" + completed.size() + ","
                + "\"cancelled\":" + cancelled.size()
                + "}";
        return result;
    }

    public List<ReportClient> getReservationsReportClients() {
        List<ReportClient> listReportClients = new ArrayList();
        List<Client> listClients = this.clientRepository.findAll();
        for (int i = 0; i < listClients.size(); i++) {
            ReportClient reportClient = new ReportClient(listClients.get(i));
            listReportClients.add(reportClient);
        }
        return listReportClients;
    }

    // METODOS CRUD
    public ReservationRepository getReservationRepository() {
        return reservationRepository;
    }

    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Reservation> getListReservations() {
        return null;
    }

    public Reservation getReservation(int id) {
        return null;
    }

    public void actualizarReservation(Integer idReservation, Reservation reservation) {
    }

    public void getReservation(Reservation reservation) {
    }

    // ****** FIN REPORTES ******

}