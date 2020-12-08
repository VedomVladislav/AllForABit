package domain;

import model.Spittle;

public interface SpitterService {

    SpitterService getSpittleById(Long id);

    void saveSpittle(Spittle spittle);

    void deleteSpittle(long id);


}
