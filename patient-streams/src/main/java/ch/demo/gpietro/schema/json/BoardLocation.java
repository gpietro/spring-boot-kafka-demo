package ch.demo.gpietro.schema.json;

import lombok.Data;

import java.util.Date;

@Data
public class BoardLocation {

    private Long patientId;
    private Long episodeOfCareId;
    private Long wardId;
    private Long roomId;
    private Long bedId;
    private String firstName;
    private String lastName;
    private String status;
    private Date birthDate;
}
