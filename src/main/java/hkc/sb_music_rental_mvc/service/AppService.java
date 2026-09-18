package hkc.sb_music_rental_mvc.service;

import hkc.sb_music_rental_mvc.dto.MusicResponseDTO;
import hkc.sb_music_rental_mvc.dto.UserMusicsDTO;
import hkc.sb_music_rental_mvc.model.Music;
import hkc.sb_music_rental_mvc.model.User;
import hkc.sb_music_rental_mvc.repo.MusicRepo;
import hkc.sb_music_rental_mvc.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    private MusicRepo musicRepo;
    private UserRepo userRepo;

    @Autowired
    public AppService(MusicRepo musicRepo, UserRepo userRepo) {
        this.musicRepo = musicRepo;
        this.userRepo = userRepo;
    }

    public UserMusicsDTO getUserWithMusics(Integer id) {
        UserMusicsDTO responseDTO = null;

        Optional<User> userOpt = userRepo.findById(id);
        if (userOpt.isEmpty()) {
            return null;
        }

        User user = userOpt.get();

        List<Music> usersMusics =
                musicRepo.findMusicByUserId(id);
        List<MusicResponseDTO> usersMusicsDTO = new ArrayList<>();
        for (Music music : usersMusics) {
            MusicResponseDTO tempDTO = new MusicResponseDTO(
                    music.getId(),
                    music.getTitle(),
                    music.getLength()
            );
            usersMusicsDTO.add(tempDTO);
        }

        responseDTO = new UserMusicsDTO(
                user.getName(),
                usersMusicsDTO
        );
        responseDTO.setId(user.getId());
        return responseDTO;
    }

    public UserMusicsDTO addMusicToUser(Integer musicId, UserMusicsDTO inputDTO) {
        UserMusicsDTO responseDTO = null;

        Optional<User> userOpt = userRepo.findById(inputDTO.getId());
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            Optional<Music> musicOpt = musicRepo.findById(musicId);
            if (musicOpt.isPresent()) {

                Music addedMusic = musicRepo.addMusicToUser(inputDTO.getId(), musicId);

                responseDTO = getUserWithMusics(inputDTO.getId());

            }
        }
        return responseDTO;
    }

}



