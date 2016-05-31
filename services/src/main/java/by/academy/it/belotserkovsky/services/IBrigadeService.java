package by.academy.it.belotserkovsky.services;

/**
 * Created by K.Belotserkovsky
 */
public interface IBrigadeService {

    /**
     * Parse date input through checkbox
     * @param selectedWorks
     * @param bidId
     */
    void createBrigade (String[] selectedWorks, Long bidId);

    /**
     * Define profession of worker, switch case
     * @param kindOfWorks
     * @return String profession
     */
    String defineProfession(String kindOfWorks);
}
