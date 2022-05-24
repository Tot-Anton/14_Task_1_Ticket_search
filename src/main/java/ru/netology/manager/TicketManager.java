package ru.netology.manager;

import ru.netology.domain.TicketInformation;
import ru.netology.repository.TicketStorageRepository;

import java.util.Arrays;

public class TicketManager {

    private TicketStorageRepository repository = new TicketStorageRepository();

    public TicketManager() {
    }

    public TicketManager(TicketStorageRepository repository) {
        this.repository = repository;
    }

    public void addTicketManager(TicketInformation item) {
        repository.add(item);
    }

    public TicketInformation[] findAllSort(String from, String to) {

        TicketInformation[] items = repository.findAll();
        TicketInformation[] result = new TicketInformation[0]; // тут будем хранить подошедшие запросу продукты
        for (TicketInformation item : items) {
            if (from.equals(item.getHere())) {
                if (to.equals(item.getThere())) {
                    // "добавляем в конец" массива result продукт product
                    int length = result.length + 1;
                    TicketInformation[] tmp = new TicketInformation[length];
                    // itar+tab
                    // копируем поэлементно
                    //        for (int i = 0; i < items.length; i++) {
                    //            tmp[i] = items[i];
                    //        }
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    // закладываем последним наш элемент
                    int lastIndex = tmp.length - 1;
                    tmp[lastIndex] = item;
                    result = tmp;
                }
            }
        }
        Arrays.sort(result);
        return result;
    }


}
