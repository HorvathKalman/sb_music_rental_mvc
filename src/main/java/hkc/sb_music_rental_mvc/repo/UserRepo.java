package hkc.sb_music_rental_mvc.repo;

import hkc.sb_music_rental_mvc.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository <User, Integer> {
}
