package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TicketInformation implements Comparable<TicketInformation> {

    private int id;
    private int price;
    private String here;
    private String there;
    private int time;

    @Override
    public int compareTo(@NonNull TicketInformation p) {
        return this.price - p.price;
    }
}

