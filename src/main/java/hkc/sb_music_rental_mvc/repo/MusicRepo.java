package hkc.sb_music_rental_mvc.repo;

import hkc.sb_music_rental_mvc.model.Music;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicRepo extends CrudRepository<Music, Integer> {

    @Query("""
            SELECT m.id, m.title, m.length
            FROM music AS m
            JOIN user_music AS um
                ON m.id = um.music_id
            WHERE um.user_id = :userId
            """)
    List<Music> findMusicByUserId(@Param("userId") Integer userId);


    @Query("""
            INSERT INTO user_music
            (user_id, music_id) VALUE (:user_id, :music_id)
            """)
     Music addMusicToUser(@Param ("user_id") Integer userId, @Param("music_id") Integer musicId);
}

