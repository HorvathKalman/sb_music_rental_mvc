package hkc.sb_music_rental_mvc.controller;

import hkc.sb_music_rental_mvc.dto.UserMusicsDTO;
import hkc.sb_music_rental_mvc.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    private AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/")
    public String index() {
        return "user.html";
    }

    @GetMapping("/user")
    public String getUserById(
            Model model,
            @RequestParam("id") Integer userId
    ) {
        UserMusicsDTO dto = appService.getUserWithMusics(userId);
        model.addAttribute("dto", dto);

        return "user.html";

    }
    @PostMapping ("/user/add_music/")
    public String addMusicToUser(
            Model model,
            @RequestParam("musicId") Integer musicId,
            UserMusicsDTO userMusicsDTO
    ){
        UserMusicsDTO dto = appService.addMusicToUser(musicId, userMusicsDTO);
        model.addAttribute("dto", dto);
        return  "user.html";
    }
}
