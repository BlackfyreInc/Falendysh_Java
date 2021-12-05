package cw13_2;

import java.util.Arrays;
import java.io.Serializable;
import java.util.Objects;

public class Communication_Salon implements Serializable{

    public Client[] clients = new Client[1];

    public Communication_Salon() {}

    public static void sortClients(Client[] array){
        boolean sorted = false;
        Client temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (Long.parseLong(array[i].IdentificationCode) > Long.parseLong(array[i+1].IdentificationCode)) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public void add_client(Client client){
        if (clients[0] == null){
            clients[0] = client;
            sortClients(clients);
            return;
        }
        for (Client value : this.clients) {
            if (Objects.equals(value.IdentificationCode, client.IdentificationCode)) {
                value.PhoneNumbersArray = Arrays.copyOf(value.PhoneNumbersArray, value.PhoneNumbersArray.length + 1);
                value.PhoneNumbersArray[value.PhoneNumbersArray.length - 1] = client.PhoneNumbersArray[0];
                sortClients(clients);
                return;
            }
        }
        this.clients = Arrays.copyOf(this.clients, this.clients.length + 1);
        this.clients[this.clients.length - 1] = client;
        sortClients(clients);
    }

    public void toString(Communication_Salon salon){
        for (Client client : salon.clients) {
            Arrays.sort(client.PhoneNumbersArray);
            System.out.println(client.name + " " + client.surname + " " + client.IdentificationCode + " " + Arrays.toString(client.PhoneNumbersArray).replace("[", "").replace("]", "").replace(",", ""));
        }
    }
}