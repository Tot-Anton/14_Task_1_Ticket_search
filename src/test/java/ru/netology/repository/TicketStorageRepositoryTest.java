package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInformation;
import ru.netology.manager.TicketManager;

import static org.junit.jupiter.api.Assertions.*;

class TicketStorageRepositoryTest {

    TicketInformation items1 = new TicketInformation(1, 15_000, "MCX", "KLF", 1200);
    TicketInformation items2 = new TicketInformation(2, 12_000, "MCX", "KWG", 800);
    TicketInformation items3 = new TicketInformation(3, 17_000, "MCX", "KLF", 1700);
    TicketInformation items4 = new TicketInformation(4, 9_000, "MCX", "MJZ", 500);

    TicketStorageRepository repo = new TicketStorageRepository();
    TicketManager manager = new TicketManager(repo);


    //сортировать по цене без совпадений
    @Test
    public void sortByPriceWithoutMatches() {

        repo.add(items1);
        repo.add(items2);
        repo.add(items3);
        repo.add(items4);

        TicketInformation[] expected = new TicketInformation[]{};
        TicketInformation[] actual = manager.findAllSort("KLF", "MJZ");

        assertArrayEquals(expected, actual);

    }

    //сортировать по цене пустой поиск
    @Test
    public void sortByPriceEmptySearch() {

        repo.add(items1);
        repo.add(items2);
        repo.add(items3);
        repo.add(items4);

        TicketInformation[] expected = new TicketInformation[]{};
        TicketInformation[] actual = manager.findAllSort(" ", " ");

        assertArrayEquals(expected, actual);

    }

    //сортировать по цене пусто поле
    @Test
    public void sortByPriceEmptyField() {


        TicketInformation[] expected = new TicketInformation[]{};
        TicketInformation[] actual = manager.findAllSort("KLF", "MJZ");

        assertArrayEquals(expected, actual);

    }


//    @Test
//    public void sortByPrice() {
//
//        TicketInformation items1 = new TicketInformation(1, 15_000, "MCX", "KLF", 1200);
//        TicketInformation items2 = new TicketInformation(2, 12_000, "MCX", "KWG", 800);
//        TicketInformation items3 = new TicketInformation(3, 17_000, "MCX", "NAL", 1700);
//        TicketInformation items4 = new TicketInformation(4, 9_000, "MCX", "MJZ", 500);
//
//        repo.add(items1);
//        repo.add(items2);
//        repo.add(items3);
//        repo.add(items4);
//
//        TicketInformation[] expected = new TicketInformation[]{items4, items1};
//        TicketInformation[] actual = manager.findAllSort("MCX", "MJZ");
//
//        assertArrayEquals(expected, actual);
//    }




}