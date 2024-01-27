package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.Kid;
import hack.fulldream.hackathonback.service.KidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/kid")
public class KidController {
    public final KidService kidService;

    public KidController(KidService kidService) {
        this.kidService = kidService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kid> FindKidById(@PathVariable UUID id){
        Optional<Kid> kid = kidService.findById(id);
        return kid.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping
    public Kid createKid(@RequestBody Kid kid){
        return kidService.save(kid);
    }

    @DeleteMapping("/{id}")
    public Optional<Kid> deleteKid(@PathVariable UUID id){
        return kidService.delete(id);
    }

}
