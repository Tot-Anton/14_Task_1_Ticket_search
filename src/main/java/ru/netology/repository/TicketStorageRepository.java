package ru.netology.repository;

import ru.netology.domain.TicketInformation;

public class TicketStorageRepository {
    private TicketInformation[] items = new TicketInformation[0];

    public TicketStorageRepository() {
    }

    public void add(TicketInformation item) {
        // создаём новый массив
        int length = items.length + 1;
        TicketInformation[] tmp = new TicketInformation[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        // закладываем последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        TicketInformation[] tmp = new TicketInformation[length];
        int index = 0;
        for (TicketInformation item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public TicketInformation[] findAll(){
        return items;
    }


}
