package hkc.sb_music_rental_mvc.dto;

public class MusicResponseDTO {
    private int id;
    private String title;
    private Integer length;

    public MusicResponseDTO(int id, String title, Integer length) {
        this.id = id;
        this.title = title;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
