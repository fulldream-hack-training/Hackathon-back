package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.Kid;
import hack.fulldream.hackathonback.service.KidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/kid")
public class KidController {

    private final KidService kidService;

    public KidController(KidService kidService) {
        this.kidService = kidService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kid> getKidById(@PathVariable UUID id) {
        Optional<Kid> kid = kidService.findById(id);
        return kid.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{firstName}")
    public ResponseEntity<List<Kid>> getKidsByFirstName(@PathVariable String firstName) {
        List<Kid> kids = kidService.findByKidName(firstName);
        return ResponseEntity.ok(kids);
    }

    @PutMapping
    public ResponseEntity<Kid> createKid(@RequestBody Kid kid) {
        Kid savedKid = kidService.save(kid);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedKid);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKid(@PathVariable UUID id) {
        kidService.deleteKid(id);
        return ResponseEntity.noContent().build();
    }
}
