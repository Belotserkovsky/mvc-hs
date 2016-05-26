package by.academy.it.belotserkovsky.daoServices;

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
