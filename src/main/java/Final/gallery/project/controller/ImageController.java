package Final.gallery.project.controller;


import Final.gallery.project.Model.SiteUser;
import Final.gallery.project.Model.image;
import Final.gallery.project.repository.ImageRepository;
import Final.gallery.project.repository.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class ImageController {

    private SiteUserRepository userRepository;
    private ImageRepository imageRepository;
    private Path rootLocation;

    public ImageController(SiteUserRepository userRepository, Path rootLocation, ImageRepository imageRepository) {
        this.userRepository = userRepository;
        this.rootLocation = rootLocation;
        this.imageRepository = imageRepository;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model, Principal principal) throws Exception {

        if (principal == null) {
            return "redirect:/find";
        }

        SiteUser user = userRepository.findByName(principal.getName()).orElseThrow(() -> new Exception());

        List<String> stringss = user.getImageList().stream()
                .map(image -> this.rootLocation.resolve(image.getName()))
                .map(path -> MvcUriComponentsBuilder
                        .fromMethodName(ImageController.class, "serveFile", path.getFileName().toString()).build()
                        .toString())
                .collect(Collectors.toList());


        model.addAttribute("files", stringss);

        return "upload";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws MalformedURLException {

        Path file = this.rootLocation.resolve(filename);
        Resource resource = new UrlResource(file.toUri());

        return ResponseEntity
                .ok()
                .body(resource);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
                                   Principal principal) throws Exception {

        if (file.getSize() == 0) {
            return "redirect:/";
        }

        String uuid = UUID.randomUUID().toString();

        String imagePath = this.rootLocation.resolve(uuid + ".jpg").toString();

        SiteUser user = userRepository.findByName(principal.getName()).orElseThrow(() -> new Exception());

        Set<image> stringList = user.getImageList();
        stringList.add(new image(imagePath));
        Files.copy(file.getInputStream(), this.rootLocation.resolve(imagePath));

        userRepository.save(user);

        return "redirect:/";
    }

    @GetMapping("/find")
    public String findPhotos(Model model) {
        return "findphoto";
    }

    @GetMapping("/search")
    public String findPhotos(@RequestParam("name") String name, Model model)  {

        SiteUser user;
        try {
            user = userRepository.findByName(name).orElseThrow(Exception::new);
        } catch (Exception e) {
            return "redirect:/display";
        }

        List<String> userImages = user.getImageList().stream()
                .map(image -> this.rootLocation.resolve(image.getName()))
                .map(path -> MvcUriComponentsBuilder
                        .fromMethodName(ImageController.class, "serveFile", path.getFileName().toString()).build()
                        .toString())
                .collect(Collectors.toList());

        model.addAttribute("files", userImages);
        model.addAttribute("user", user.getName());

        return "display";

    }

    @RequestMapping("/delete")
    public String findPhotos(Principal principal, @RequestParam("text") String text, String string) throws Exception {

        SiteUser user = userRepository.findByName(principal.getName()).orElseThrow(() -> new Exception());

        text = text.substring(text.lastIndexOf("/"));
        text = this.rootLocation + text;

        image image = imageRepository.findByName(text);

        user.getImageList().remove(image);

        userRepository.save(user);

        return "redirect:/";

    }




    @RequestMapping("/download")
    public ResponseEntity<Resource> downloadPhoto(Principal principal, @RequestParam("text") String text, Model model) throws Exception {
        if (principal == null) {
            model.addAttribute("error", "You need to log in to access the download functionality.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        SiteUser user = userRepository.findByName(principal.getName()).orElseThrow(() -> new Exception());

        text = text.substring(text.lastIndexOf("/"));
        String filePath = this.rootLocation + text;

        Path file = Paths.get(filePath);
        Resource resource = new UrlResource(file.toUri());

        if (resource.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
            return ResponseEntity.ok().headers(headers).body(resource);
        } else {
            throw new FileNotFoundException("File not found: " + filePath);
        }
    }
    @GetMapping("/error401")
    public String error401()
    {
        return "redirect:/login";
    }

    @GetMapping("/displayAll")
    public String displayAllPhotos(Model model) {

        List<String> allImages = imageRepository.findAll().stream()
                .map(image -> this.rootLocation.resolve(image.getName()))
                .map(path -> MvcUriComponentsBuilder
                        .fromMethodName(ImageController.class, "serveFile", path.getFileName().toString()).build()
                        .toString())
                .collect(Collectors.toList());

        model.addAttribute("files", allImages);

        return "displayAllPhotos";
    }


}

