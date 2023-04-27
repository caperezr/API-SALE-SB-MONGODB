package com.cperez.apimongodb.model;

import com.cperez.apimongodb.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    private String id;
    private String name;
    private String phone;

    public Client(ClientDTO clientDTO) {
        this.name = clientDTO.getName();
        this.phone = clientDTO.getPhone();
    }

}
