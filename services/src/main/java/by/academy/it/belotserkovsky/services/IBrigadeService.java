package by.academy.it.belotserkovsky.services;

/**
 * Created by K.Belotserkovsky
 */
public interface IBrigadeService {

    /**
     * Parse date input through checkbox
     * @param selected
     * @param bidId
     */
    void createBrigade (String[] selected, Long bidId);
}
