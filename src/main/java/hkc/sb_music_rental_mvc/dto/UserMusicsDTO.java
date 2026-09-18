package hkc.sb_music_rental_mvc.dto;

import java.util.List;

public class UserMusicsDTO {
    private Integer id;
    private String username;
    private List<MusicResponseDTO> musics;

    public UserMusicsDTO(String username, List<MusicResponseDTO> musics) {
        this.username = username;
        this.musics = musics;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<MusicResponseDTO> getMusics() {
        return musics;
    }

    public void setMusics(List<MusicResponseDTO> musics) {
        this.musics = musics;
    }

}
